/**
 * Created on Dec 12, 2011
 */
package com.otulive.springblog.repository;

import com.otulive.springblog.domain.Comment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {

  @Query("select c from Comment c where c.entry.id = :entryId")
  public List<Comment> findByEntryId(@Param("entryId") Long entryId);

}
