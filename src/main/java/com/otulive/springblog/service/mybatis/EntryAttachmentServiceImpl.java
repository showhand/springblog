/**
 * Created on Jan 25, 2012
 */
package com.otulive.springblog.service.mybatis;

import com.otulive.springblog.domain.EntryAttachment;
import com.otulive.springblog.service.EntryAttachmentService;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by roger on 14-2-23.
 */
@Service("entryAttachmentService")
@Repository
@Transactional
public class EntryAttachmentServiceImpl implements EntryAttachmentService {

  @Override
  @Transactional(readOnly = true)
  public EntryAttachment findById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

}
