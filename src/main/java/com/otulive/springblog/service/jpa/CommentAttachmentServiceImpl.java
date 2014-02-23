/**
 * Created on Dec 28, 2011
 */
package com.otulive.springblog.service.jpa;

import com.otulive.springblog.domain.CommentAttachment;
import com.otulive.springblog.repository.CommentAttachmentRepository;
import com.otulive.springblog.service.CommentAttachmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by roger on 14-2-23.
 */
@Service("commentAttachmentService")
@Transactional
public class CommentAttachmentServiceImpl implements CommentAttachmentService {

  @Autowired
  private CommentAttachmentRepository attachmentRepository;

  @Override
  @Transactional(readOnly = true)
  public CommentAttachment findById(Long id) {
    return attachmentRepository.findOne(id);
  }

}
