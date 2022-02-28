package com.example.upgradedblogengine.service;

import com.example.upgradedblogengine.model.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories(Pageable pageable);
}
