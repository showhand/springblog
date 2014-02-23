/**
 * Created on Dec 12, 2011
 */
package com.otulive.springblog.service;

import com.otulive.springblog.domain.Comment;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
public interface CommentService {

  public Comment findById(Long id);

  public List<Comment> findByEntryId(Long entryId);

  public Comment save(Comment comment);

  public void delete(Comment comment);

  public List<String> findReplyToByEntryId(Long entryId);
}
