package com.example.upgradedblogengine.web;
import com.example.upgradedblogengine.mapper.CategoryMapper;
import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.repository.CategoryRepository;
import com.example.upgradedblogengine.service.CategoryService;
import com.example.upgradedblogengine.web.dto.category.CategoryDTO;
import com.example.upgradedblogengine.web.dto.category.NewCategoryDTO;
import com.example.upgradedblogengine.web.dto.category.NewCategoryWithNewLabelsDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
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
    public CategoryDTO createCategory(@RequestBody @Valid NewCategoryWithNewLabelsDTO newCategoryWithNewLabels) {
        //mapCategoryToDTO(categoryService.createCategoryWithLabels(newCategoryWithNewLabels));
        return mapCategoryToDTO(categoryService.createCategoryWithLabels(newCategoryWithNewLabels));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping({"/{id}"})
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteLabel(id);
    }

    @PutMapping("/{id}")
    public CategoryDTO updateCategoryWithExistingLabel(@PathVariable Long id, @RequestBody @Valid NewCategoryDTO newCategory)
    {
        return CategoryMapper.INSTANCE.categoryToDTO(categoryService.updateCategoryById(id, newCategory));
    }





}
