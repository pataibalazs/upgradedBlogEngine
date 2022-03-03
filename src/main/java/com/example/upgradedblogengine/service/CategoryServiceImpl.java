package com.example.upgradedblogengine.service;


import com.example.upgradedblogengine.mapper.CategoryMapper;
import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.repository.CategoryRepository;
import com.example.upgradedblogengine.web.dto.category.NewCategoryDTO;
import com.example.upgradedblogengine.web.dto.category.NewCategoryWithNewLabelsDTO;
import com.example.upgradedblogengine.web.dto.label.NewLabelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {


    private LabelService labelService;

    private CategoryRepository categoryRepository;


    public CategoryServiceImpl(LabelService labelService, CategoryRepository categoryRepository) {
        this.labelService = labelService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public Category createCategoryWithLabels(NewCategoryWithNewLabelsDTO newCategoryWithNewLabelsDTO) {
        Set<NewLabelDTO> initLabelList=newCategoryWithNewLabelsDTO.getLabels();
        Iterator<NewLabelDTO> labelListIterator = initLabelList.iterator();

        Set<Label> labelList = new HashSet<Label>();
        Set<Category> categoryLista=new HashSet<Category>();
        Category category = new Category();

        CategoryMapper.INSTANCE.updateFromDto(newCategoryWithNewLabelsDTO.getNewCategory(), category);

        category.setCategoryName(newCategoryWithNewLabelsDTO.getNewCategory().getCategoryName());
        categoryLista.add(category);

        while(labelListIterator.hasNext()) {

            Label label=labelService.createLabelWithCategories(labelListIterator.next(),categoryLista);


            labelList.add(label);
        }
        category.setLabels(labelList);
        return categoryRepository.save(category);
    }


    @Override
    public List<Category> getCategories(Pageable pageable){

        return categoryRepository.findAll(pageable).getContent();
    }

    @Override
    public Category createCategory(NewCategoryDTO newCategory) {
        Category category = new Category();


        category.setCategoryName(newCategory.getCategoryName());

        Set<Label> labels=labelService.getPersistedLabels(newCategory.getLabels());

        category.setLabels(labels);


        return categoryRepository.save(category);
    }
    @Override
    public void deleteLabel(Long id){
        categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategoryById(Long id, NewCategoryDTO newCategory) {

        Category category = categoryRepository.findById(id).orElseThrow();

        CategoryMapper.INSTANCE.updateFromDto(newCategory, category);

        Set<Label> labels=labelService.getPersistedLabels(newCategory.getLabels());

        category.setLabels(labels);

        return categoryRepository.save(category);
    }









}
