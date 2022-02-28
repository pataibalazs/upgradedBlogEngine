package com.example.upgradedblogengine.service;


import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories(Pageable pageable){

        return categoryRepository.findAll(pageable).getContent();


    }



}
