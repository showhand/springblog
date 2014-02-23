/**
 * Created on Jan 25, 2012
 */
package com.otulive.springblog.persistence;

import com.otulive.springblog.domain.Category;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
public interface CategoryMapper {

  List<Category> findAll();

  List<Category> findAllParentCategory();

  List<Category> findAllSubCategory(String parentCategoryId);

}
