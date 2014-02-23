/**
 * Created on Oct 18, 2011
 */
package com.otulive.springblog.auditor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.data.domain.AuditorAware;

/**
 * Created by roger on 14-2-23.
 */
public class AuditorAwareBean implements AuditorAware<String> {

  public String getCurrentAuditor() {

    Subject subject = SecurityUtils.getSubject();

    String currentUser = null;

    if (subject != null) {
      currentUser = subject.getPrincipal().toString();
    } else {
      // For import entry using batch job
      currentUser = "batch";
    }

    return currentUser;
  }

}
