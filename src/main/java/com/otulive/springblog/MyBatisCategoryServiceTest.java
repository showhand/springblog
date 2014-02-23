/**
 * Created on Jan 25, 2012
 */
package com.otulive.springblog;

import com.otulive.springblog.domain.Category;
import com.otulive.springblog.service.CategoryService;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
public class MyBatisCategoryServiceTest {

  /**
   * @param args
   */
  public static void main(String[] args) {

    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    ctx.load("classpath:mybatis-app-context.xml");
    ctx.refresh();

    System.out.println("App context initialized successfully");

    CategoryService categoryService = ctx.getBean("categoryService", CategoryService.class);

    List<Category> categories = categoryService.findAll();

    for (Category category : categories) {
      System.out.println("Category: " + category.getCategoryId());
    }

    List<Category> parentCategories = categoryService.findAllParentCategory();

    List<Category> subCategories;
    for (Category category : parentCategories) {
      System.out.println("Parent Category: " + category.getCategoryId());

      subCategories = categoryService.findAllSubCategory(category.getCategoryId());
      for (Category categoryTemp : subCategories) {
        System.out.println("--->Sub Category: " + categoryTemp.getCategoryId());
      }
    }
  }

}
