/**
 * Created on Jan 24, 2012
 */
package com.otulive.springblog.service;

import com.otulive.springblog.domain.Entry;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
public interface EntryAuditService {

  /**
   * Retrieve all audit for an entry base on id
   */
  public List<Entry> findAuditById(Long id);

}
