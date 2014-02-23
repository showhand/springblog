/**
 * Created on Dec 28, 2011
 */
package com.otulive.springblog.repository;

import com.otulive.springblog.domain.CommentAttachment;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by roger on 14-2-23.
 */
public interface CommentAttachmentRepository extends CrudRepository<CommentAttachment, Long> {

}
