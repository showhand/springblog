/**
 * Created on Jan 25, 2012
 */
package com.otulive.springblog.service.mybatis;

import com.otulive.springblog.domain.Category;
import com.otulive.springblog.persistence.CategoryMapper;
import com.otulive.springblog.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by roger on 14-2-23.
 */
@Service("categoryService")
@Repository
@Transactional
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryMapper categoryMapper;

  @Override
  @Transactional(readOnly = true)
  public List<Category> findAll() {
    return categoryMapper.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public List<Category> findAllParentCategory() {
    return categoryMapper.findAllParentCategory();
  }

  @Override
  @Transactional(readOnly = true)
  public List<Category> findAllSubCategory(String parentCategoryId) {
    return categoryMapper.findAllSubCategory(parentCategoryId);
  }

}
