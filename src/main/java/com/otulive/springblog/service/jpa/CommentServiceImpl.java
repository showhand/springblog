/**
 * Created on Dec 12, 2011
 */
package com.otulive.springblog.service.jpa;

import com.otulive.springblog.domain.Comment;
import com.otulive.springblog.repository.CommentRepository;
import com.otulive.springblog.service.CommentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by roger on 14-2-23.
 */
@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

  final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

  @PersistenceContext
  private EntityManager em;

  @Autowired
  private CommentRepository commentResository;

  @Override
  @Transactional(readOnly = true)
  public Comment findById(Long id) {
    return commentResository.findOne(id);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Comment> findByEntryId(Long entryId) {
    logger.info("Finding comments for entry with id {}", entryId);
    return commentResository.findByEntryId(entryId);
  }

  @Override
  public List<String> findReplyToByEntryId(Long entryId) {
    TypedQuery<String> query = em.createNamedQuery("Comment.findReplyToByEntryId", String.class);
    query.setParameter("entryId", entryId);
    return query.getResultList();
  }

  @Override
  public Comment save(Comment comment) {
    return commentResository.save(comment);
  }

  @Override
  public void delete(Comment comment) {
    // TODO Auto-generated method stub

  }

}
