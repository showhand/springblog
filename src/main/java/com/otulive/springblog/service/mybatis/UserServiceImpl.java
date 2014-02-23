/**
 * Created on Jan 25, 2012
 */
package com.otulive.springblog.service.mybatis;

import com.otulive.springblog.domain.User;
import com.otulive.springblog.persistence.UserMapper;
import com.otulive.springblog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by roger on 14-2-23.
 */
@Service("userService")
@Repository
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  @Transactional(readOnly = true)
  public User findUserByLoginName(String userName) {
    return userMapper.findByUserName(userName);
  }

}
