/**
 * Created on Nov 1, 2011
 */
package com.otulive.springblog.domain;

import org.joda.time.DateTime;

/**
 * Created by roger on 14-2-23.
 */
public interface BlogPosting {

  public String getBody();

  public void setBody(String body);

  public DateTime getPostDate();

  public void setPostDate(DateTime postDate);

  public String getSubject();

  public void setSubject(String subject);

}
