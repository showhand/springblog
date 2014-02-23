/**
 * Created on Dec 20, 2011
 */
package com.otulive.springblog.service.jpa;

import com.otulive.springblog.domain.User;
import com.otulive.springblog.repository.UserRepository;
import com.otulive.springblog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by roger on 14-2-23.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional(readOnly = true)
  public User findUserByLoginName(String loginName) {
    return userRepository.findByLoginName(loginName);
  }

}
