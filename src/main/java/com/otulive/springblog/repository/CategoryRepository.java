/**
 * Created on Dec 13, 2011
 */
package com.otulive.springblog.repository;

import com.otulive.springblog.domain.Category;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
public interface CategoryRepository extends CrudRepository<Category, String> {

  @Query("select c from Category c where c.parentCategory is null")
  public List<Category> findAllParentCategory();

  @Query("select c from Category c where c.parentCategory.categoryId = :parentCategoryId")
  List<Category> findAllSubCategory(@Param("parentCategoryId") String parentCategoryId);

}
