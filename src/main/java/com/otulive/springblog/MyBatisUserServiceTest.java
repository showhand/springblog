/**
 * Created on Jan 25, 2012
 */
package com.otulive.springblog;

import com.otulive.springblog.domain.User;
import com.otulive.springblog.service.UserService;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by roger on 14-2-23.
 */
public class MyBatisUserServiceTest {

  /**
   * @param args
   */
  public static void main(String[] args) {

    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    ctx.load("classpath:mybatis-app-context.xml");
    ctx.refresh();

    System.out.println("App context initialized successfully");

    UserService userService = ctx.getBean("userService", UserService.class);

    User appUser = userService.findUserByLoginName("clarence");

    System.out.println("User name: " + appUser.getName());
  }

}
