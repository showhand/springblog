/**
 * Created on Jan 24, 2012
 */
package com.otulive.springblog.service.jpa;

import com.google.common.collect.Lists;

import com.otulive.springblog.domain.Entry;
import com.otulive.springblog.service.EntryAuditService;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by roger on 14-2-23.
 */
@Service("entryAuditService")
@Transactional
public class EntryAuditServiceImpl implements EntryAuditService {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional(readOnly = true)
  public List<Entry> findAuditById(Long id) {
    AuditReader auditReader = AuditReaderFactory.get(entityManager);
    List<Number> revisions = auditReader.getRevisions(Entry.class, id);

    revisions = Lists.reverse(revisions);

    List<Entry> entries = new ArrayList<Entry>();
    Entry entry;
    for (Number revision : revisions) {
      entry = auditReader.find(Entry.class, id, revision);
      entries.add(entry);
    }
    return entries;
  }

}
