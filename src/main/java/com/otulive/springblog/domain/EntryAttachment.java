/**
 * Created on Dec 28, 2011
 */
package com.otulive.springblog.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by roger on 14-2-23.
 */
@Entity
@Table(name = "ENTRY_ATTACHMENT_DETAIL")
public class EntryAttachment extends Attachment {

  private Entry entry;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ENTRY_ID")
  public Entry getEntry() {
    return entry;
  }

  public void setEntry(Entry entry) {
    this.entry = entry;
  }

}
