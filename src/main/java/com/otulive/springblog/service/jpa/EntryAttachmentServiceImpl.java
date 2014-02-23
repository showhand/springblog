/**
 * Created on Dec 15, 2011
 */
package com.otulive.springblog.service.jpa;

import com.otulive.springblog.domain.EntryAttachment;
import com.otulive.springblog.repository.EntryAttachmentRepository;
import com.otulive.springblog.service.EntryAttachmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by roger on 14-2-23.
 */
@Service("entryAttachmentService")
@Transactional
public class EntryAttachmentServiceImpl implements EntryAttachmentService {

  @Autowired
  private EntryAttachmentRepository attachmentRepository;

  @Override
  @Transactional(readOnly = true)
  public EntryAttachment findById(Long id) {
    return attachmentRepository.findOne(id);
  }

}
