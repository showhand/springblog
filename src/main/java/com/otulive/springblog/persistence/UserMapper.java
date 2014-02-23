/**
 * Created on Jan 25, 2012
 */
package com.otulive.springblog.persistence;

import com.otulive.springblog.domain.User;

/**
 * Created by roger on 14-2-23.
 */
public interface UserMapper {

  User findByUserName(String userName);

}
