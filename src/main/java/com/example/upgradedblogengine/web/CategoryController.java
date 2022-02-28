package com.example.upgradedblogengine.web;
import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.repository.CategoryRepository;
import com.example.upgradedblogengine.service.CategoryService;
import com.example.upgradedblogengine.web.dto.CategoryDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<CategoryDTO> getCategories(Pageable pageable) {
        return categoryService.getCategories(pageable).stream().map(category -> mapCategoryToDTO(category)).collect(Collectors.toList());
    }

    private CategoryDTO mapCategoryToDTO(Category category) {
        return new CategoryDTO(category.getCategoryId(),category.getCategoryName());
    }


}
