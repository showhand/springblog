/**
 * Created on Dec 20, 2011
 */
package com.otulive.springblog.repository;

import com.otulive.springblog.domain.User;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by roger on 14-2-23.
 */
public interface UserRepository extends CrudRepository<User, Long> {

  User findByLoginName(String loginName);
}
