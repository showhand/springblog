/**
 * Created on Oct 27, 2011
 */
package com.otulive.springblog.service.mybatis;

import com.otulive.springblog.domain.Entry;
import com.otulive.springblog.domain.SearchCriteria;
import com.otulive.springblog.domain.SearchCriteriaPage;
import com.otulive.springblog.persistence.EntryMapper;
import com.otulive.springblog.service.EntryService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
@Service("entryService")
@Repository
@Transactional
public class EntryServiceImpl implements EntryService {

  @Autowired
  private EntryMapper entryMapper;

  @Override
  @Transactional(readOnly = true)
  public Entry findById(Long id) {
    return entryMapper.findById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Entry> findByCategoryId(String categoryId) {
    return entryMapper.findByCategoryId(categoryId);
  }

  @Override
  public Entry save(Entry entry) {
    if (entry.getId() == null) {
      DateTime dt = new DateTime();
      entry.setPostDate(dt);
      entry.setCreatedDate(dt);
      entry.setLastModifiedDate(dt);
      Subject currentUser = SecurityUtils.getSubject();
      entry.setCreatedBy(currentUser.getPrincipal().toString());
      entry.setLastModifiedBy(currentUser.getPrincipal().toString());
      entryMapper.insertEntry(entry);
    } else {
      entryMapper.updateEntry(entry);
    }
    return entry;
  }

  @Override
  public void delete(Entry entry) {
    entryMapper.deleteEntry(entry.getId());
  }

  @Override
  @Transactional(readOnly = true)
  public List<Entry> findAll() {
    return entryMapper.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Page<Entry> findAllByPage(Pageable pageable) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  @Transactional(readOnly = true)
  public Page<Entry> findEntryByCriteria(SearchCriteria searchCriteria,
                                         Pageable pageable) {
    String subject = searchCriteria.getSubject();
    String categoryId = searchCriteria.getCategoryId();
    DateTime fromPostDate = searchCriteria.getFromPostDate();
    DateTime toPostDate = searchCriteria.getToPostDate();

    SearchCriteriaPage searchCriteriaPage = new SearchCriteriaPage();
    searchCriteriaPage.setCategoryId(categoryId);
    searchCriteriaPage.setSubject(subject);
    searchCriteriaPage.setFromPostDate(fromPostDate);
    searchCriteriaPage.setToPostDate(toPostDate);

    int offset = pageable.getPageNumber() * pageable.getPageSize();
    int limit = pageable.getPageSize();
    searchCriteriaPage.setOffset(offset);
    searchCriteriaPage.setPageSize(limit);

    List<Entry> entries = entryMapper.findEntryByCriteria(searchCriteriaPage);

    int totalRecordCount = entryMapper.findEntryCountByCriteria(searchCriteriaPage);

    Page<Entry> result = new PageImpl<Entry>(entries, pageable, totalRecordCount);
    return result;
  }

}
