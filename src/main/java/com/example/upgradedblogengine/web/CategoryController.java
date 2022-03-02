package com.example.upgradedblogengine.web;
import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.repository.CategoryRepository;
import com.example.upgradedblogengine.service.CategoryService;
import com.example.upgradedblogengine.web.dto.category.CategoryDTO;
import com.example.upgradedblogengine.web.dto.category.NewCategoryDTO;
import com.example.upgradedblogengine.web.dto.category.NewCategoryWithNewLabelsDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;


    public CategoryController(CategoryService categoryService, CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }

    //átcastol mapból DTO-vá
    private CategoryDTO mapCategoryToDTO(Category category) {
        return new CategoryDTO(category.getCategoryName(),category.getLabels());
    }

    @GetMapping()
    public List<CategoryDTO> getCategories(Pageable pageable) {

        return categoryService.getCategories(pageable).stream().map(category -> mapCategoryToDTO(category)).collect(Collectors.toList());
    }

    //requestBody annyit takar hogy az utána lévő tagot JSON-ban fogom elküldeni tehát azt a kliens küldi
    @PostMapping()
    public CategoryDTO createCategory(@RequestBody NewCategoryDTO newCategory) {
        return mapCategoryToDTO(categoryService.createCategory(newCategory));
    }

    @PostMapping("/withLabels")
    public void createCategory(@RequestBody @Valid NewCategoryWithNewLabelsDTO newCategoryWithNewLabels) {
        //mapCategoryToDTO(categoryService.createCategoryWithLabels(newCategoryWithNewLabels));
        categoryService.createCategoryWithLabels(newCategoryWithNewLabels);
    }

    @DeleteMapping({"/{id}"})
    public void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }





}
