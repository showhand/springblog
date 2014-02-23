/**
 * Created on Oct 21, 2011
 */
package com.otulive.springblog.service;

import com.otulive.springblog.domain.Entry;
import com.otulive.springblog.domain.SearchCriteria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
public interface EntryService {

  public List<Entry> findAll();

  public Entry findById(Long id);

  public List<Entry> findByCategoryId(String categoryId);

  public Entry save(Entry entry);

  public void delete(Entry entry);

  public Page<Entry> findAllByPage(Pageable pageable);

  public Page<Entry> findEntryByCriteria(SearchCriteria searchCriteria, Pageable pageable);

}
