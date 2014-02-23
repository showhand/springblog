/**
 * Created on Oct 3, 2011
 */
package com.otulive.springblog.common.aop;

/**
 * Created by roger on 14-2-23.
 */
public interface ObscenityFilter {

  public boolean containsObscenities(String data);

  public String obfuscateObscenities(String data);
}
