/**
 * Created on Oct 27, 2011
 */
package com.otulive.springblog.persistence;

import com.otulive.springblog.domain.Entry;
import com.otulive.springblog.domain.SearchCriteriaPage;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
public interface EntryMapper {

  List<Entry> findAll();

  Entry findById(Long id);

  List<Entry> findByCategoryId(String categoryId);

  List<Entry> findEntryByCriteria(SearchCriteriaPage searchCriteriaPage);

  int findEntryCountByCriteria(SearchCriteriaPage searchCriteriaPage);

  void insertEntry(Entry entry);

  void updateEntry(Entry entry);

  void deleteEntry(Long id);

}
