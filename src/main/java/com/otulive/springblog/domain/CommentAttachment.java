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
@Table(name = "COMMENT_ATTACHMENT_DETAIL")
public class CommentAttachment extends Attachment {

  private Comment comment;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "COMMENT_ID")
  public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }

}
