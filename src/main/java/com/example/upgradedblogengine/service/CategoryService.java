package com.example.upgradedblogengine.service;

import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.web.dto.category.CategoryDTO;
import com.example.upgradedblogengine.web.dto.category.NewCategoryDTO;
import com.example.upgradedblogengine.web.dto.category.NewCategoryWithNewLabelsDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {

    List<Category> getCategories(Pageable pageable);

    Category createCategory(NewCategoryDTO newCategory);

    public Category createCategoryWithLabels(NewCategoryWithNewLabelsDTO newCategoryWithNewLabelsDTO);

    public void deleteLabel(Long id);

    Category updateCategoryById(Long id, NewCategoryDTO newCategoryDTO);

}
