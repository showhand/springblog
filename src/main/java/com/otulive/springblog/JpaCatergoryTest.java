/**
 * Created on Oct 21, 2011
 */
package com.otulive.springblog;

import com.otulive.springblog.domain.Category;
import com.otulive.springblog.service.CategoryService;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
public class JpaCatergoryTest {

  /**
   * @param args
   */
  public static void main(String[] args) {

    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    ctx.load("classpath:jpa-app-context.xml");
    ctx.refresh();

    System.out.println("App context initialized successfully");

    CategoryService categoryService = ctx.getBean("categoryService", CategoryService.class);

    List<Category> categories = categoryService.findAllParentCategory();

    for (Category category : categories) {
      System.out.println("Category id: " + category.getCategoryId());
      List<Category> subCategories = categoryService.findAllSubCategory(category.getCategoryId());
      for (Category subCategory : subCategories) {
        System.out.println("Sub-category id: " + subCategory.getCategoryId());
      }
    }
  }

}
