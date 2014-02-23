/**
 * Created on Dec 13, 2011
 */
package com.otulive.springblog.web.blogapp.controller;

import com.otulive.springblog.domain.Category;
import com.otulive.springblog.service.CategoryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
@RequestMapping("/categories")
@Controller
public class CategoryController {

  final Logger logger = LoggerFactory.getLogger(CategoryController.class);

  @Autowired
  private CategoryService categoryService;

  @RequestMapping(value = "/listallparent", method = RequestMethod.GET,
                  produces = "application/json")
  @ResponseBody
  public List<Category> listAllParent() {
    return categoryService.findAllParentCategory();
  }

  @RequestMapping(value = "/listallchild/{parentCategoryId}", method = RequestMethod.GET,
                  produces = "application/json")
  @ResponseBody
  public List<Category> listAllSubCategory(
      @PathVariable("parentCategoryId") String parentCategoryId) {
    return categoryService.findAllSubCategory(parentCategoryId);
  }

  @RequestMapping(value = "/listforsearch", method = RequestMethod.GET)
  @ResponseBody
  public String listForSearch() {

    StringBuilder result = new StringBuilder("<select><option value=''></option>");

    List<Category> categories = categoryService.findAllParentCategory();

    for (Category category : categories) {
      result.append("<option value='" + category.getCategoryId() + "'>" + category.getCategoryId()
                    + "</option>");
    }

    result.append("</select>");

    return result.toString();
  }

}
