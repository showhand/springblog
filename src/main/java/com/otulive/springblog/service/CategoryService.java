/**
 * Created on Dec 13, 2011
 */
package com.otulive.springblog.service;

import com.otulive.springblog.domain.Category;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
public interface CategoryService {

  public List<Category> findAll();

  public List<Category> findAllParentCategory();

  public List<Category> findAllSubCategory(String parentCategoryId);

}
