/**
 * Created on Dec 13, 2011
 */
package com.otulive.springblog.service.jpa;

import com.google.common.collect.Lists;

import com.otulive.springblog.domain.Category;
import com.otulive.springblog.repository.CategoryRepository;
import com.otulive.springblog.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Category> findAll() {
    return Lists.newArrayList(categoryRepository.findAll());
  }

  @Override
  @Transactional(readOnly = true)
  public List<Category> findAllParentCategory() {
    return categoryRepository.findAllParentCategory();
  }

  @Override
  @Transactional(readOnly = true)
  public List<Category> findAllSubCategory(String parentCategoryId) {
    return categoryRepository.findAllSubCategory(parentCategoryId);
  }

}
