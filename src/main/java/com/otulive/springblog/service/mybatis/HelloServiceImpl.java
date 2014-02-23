/**
 * Created on Oct 21, 2011
 */
package com.otulive.springblog.service.mybatis;

import com.otulive.springblog.service.HelloService;

import org.springframework.stereotype.Service;

/**
 * Created by roger on 14-2-23.
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {

  /* (non-Javadoc)
   * @see com.otulive.springblog.service.HelloService#sayHello()
   */
  @Override
  public String sayHello() {
    return "Hello MyBatis Imlementation!";
  }

}
