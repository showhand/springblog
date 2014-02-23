/**
 * Created on Dec 15, 2011
 */
package com.otulive.springblog.repository;

import com.otulive.springblog.domain.EntryAttachment;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by roger on 14-2-23.
 */
public interface EntryAttachmentRepository extends CrudRepository<EntryAttachment, Long> {

}
