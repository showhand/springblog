/**
 * Created on Jan 25, 2012
 */
package com.otulive.springblog.service.mybatis;

import com.otulive.springblog.domain.CommentAttachment;
import com.otulive.springblog.service.CommentAttachmentService;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by roger on 14-2-23.
 */
@Service("commentAttachmentService")
@Repository
@Transactional
public class CommentAttachmentServiceImpl implements CommentAttachmentService {

  @Override
  @Transactional(readOnly = true)
  public CommentAttachment findById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

}
