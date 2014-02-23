/**
 * Created on Jan 25, 2012
 */
package com.otulive.springblog.service.mybatis;

import com.otulive.springblog.domain.Entry;
import com.otulive.springblog.service.EntryAuditService;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
@Service("entryAuditService")
@Repository
@Transactional
public class EntryAuditServiceImpl implements EntryAuditService {

  @Override
  @Transactional(readOnly = true)
  public List<Entry> findAuditById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

}
