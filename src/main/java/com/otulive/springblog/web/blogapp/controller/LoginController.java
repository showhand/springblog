package com.otulive.springblog.web.blogapp.controller;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by roger on 14-2-23.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

  @RequestMapping(method = RequestMethod.GET)
  public String login() {
    return "blogs/list";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName,
                     Model model) {
    model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
    return "blogs/list";
  }

}
