/**
 * Created on Jan 25, 2012
 */
package com.otulive.springblog.service.mybatis;

import com.otulive.springblog.domain.Comment;
import com.otulive.springblog.service.CommentService;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
@Service("commentService")
@Repository
@Transactional
public class CommentServiceImpl implements CommentService {

  @Override
  @Transactional(readOnly = true)
  public Comment findById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Comment> findByEntryId(Long entryId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Comment save(Comment comment) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(Comment comment) {
    // TODO Auto-generated method stub

  }

  @Override
  @Transactional(readOnly = true)
  public List<String> findReplyToByEntryId(Long entryId) {
    // TODO Auto-generated method stub
    return null;
  }

}
