/**
 * Created on Dec 20, 2011
 */
package com.otulive.springblog.service;

import com.otulive.springblog.domain.User;

/**
 * Created by roger on 14-2-23.
 */
public interface UserService {

  public static final String HASH_ALGORITHM = "SHA-1";
  public static final int HASH_INTERATIONS = 1024;
  public static final int SALT_SIZE = 8;

  public User findUserByLoginName(String loginName);

}
