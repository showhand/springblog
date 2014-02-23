/**
 * Created on Oct 3, 2011
 */
package com.otulive.springblog.common.aop;

import com.otulive.springblog.domain.BlogPosting;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by roger on 14-2-23.
 */
@Aspect
@Component
public class ObscenityFilterAdvice {

  @Autowired
  private ObscenityFilter obscenityFilter;

  public ObscenityFilterAdvice() {
    System.out.println("ObscenityFilterAdvice inited");
  }

  public ObscenityFilter getObscenityFilter() {
    return this.obscenityFilter;
  }

  @Before("execution(* com.otulive.springblog.service..*(..))")
  public void filterObscenities(JoinPoint joinPoint)
      throws Throwable {
    System.out.println("ObscenityFilterAdvice obscenityFilter:" + obscenityFilter);
    Object[] args = joinPoint.getArgs();
    for (int x = 0; x < args.length; x++) {
      if (args[x] instanceof BlogPosting) {
        BlogPosting arg = (BlogPosting) args[x];
        if (obscenityFilter != null && obscenityFilter.containsObscenities(arg.getBody())) {
          arg.setBody(obscenityFilter.obfuscateObscenities(arg.getBody()));
        }
        if (obscenityFilter != null && obscenityFilter.containsObscenities(arg.getSubject())) {
          arg.setSubject(obscenityFilter
                             .obfuscateObscenities(arg.getSubject()));
        }
      }
    }
  }

}
