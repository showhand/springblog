/**
 * Created on Oct 21, 2011
 */
package com.otulive.springblog.service.jpa;

import com.google.common.collect.Lists;

import com.otulive.springblog.domain.Entry;
import com.otulive.springblog.domain.SearchCriteria;
import com.otulive.springblog.repository.EntryRepository;
import com.otulive.springblog.service.EntryService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
@Service("entryService")
@Transactional
public class EntryServiceImpl implements EntryService {

  @Autowired
  private EntryRepository entryRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Entry> findAll() {
    return Lists.newArrayList(entryRepository.findAll());
  }

  @Override
  @Transactional(readOnly = true)
  public Page<Entry> findAllByPage(Pageable pageable) {
    return entryRepository.findAll(pageable);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<Entry> findEntryByCriteria(SearchCriteria searchCriteria,
                                         Pageable pageable) {
    String subject = searchCriteria.getSubject();
    String categoryId = searchCriteria.getCategoryId();
    DateTime fromPostDate = searchCriteria.getFromPostDate();
    DateTime toPostDate = searchCriteria.getToPostDate();
    return entryRepository
        .findEntryByCriteria(subject, categoryId, fromPostDate, toPostDate, pageable);
  }

  /* (non-Javadoc)
   * @see com.otulive.springblog.service.EntryService#findById()
   */
  @Override
  @Transactional(readOnly = true)
  public Entry findById(Long id) {
    return entryRepository.findOne(id);
  }

  /* (non-Javadoc)
   * @see com.otulive.springblog.service.EntryService#findByCategoryId()
   */
  @Override
  @Transactional(readOnly = true)
  public List<Entry> findByCategoryId(String categoryId) {
    return entryRepository.findByCategoryId(categoryId);
  }

  /* (non-Javadoc)
   * @see com.otulive.springblog.service.EntryService#save(com.otulive.springblog.domain.Entry)
   */
  @Override
  public Entry save(Entry entry) {
    // If new entry, set post date to current date
    if (entry.getId() == null) {
      DateTime dt = new DateTime();
      entry.setPostDate(dt);
      entry.setCreatedDate(dt);
      entry.setLastModifiedDate(dt);
      Subject currentUser = SecurityUtils.getSubject();
      entry.setCreatedBy(currentUser.getPrincipal().toString());
      entry.setLastModifiedBy(currentUser.getPrincipal().toString());
    }
    return entryRepository.save(entry);
  }

  /* (non-Javadoc)
   * @see com.otulive.springblog.service.EntryService#delete(com.otulive.springblog.domain.Entry)
   */
  @Override
  public void delete(Entry entry) {
    entryRepository.delete(entry);
  }

}
