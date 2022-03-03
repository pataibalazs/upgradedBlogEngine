package com.example.upgradedblogengine.service;

import com.example.upgradedblogengine.mapper.CategoryMapper;
import com.example.upgradedblogengine.mapper.LabelMapper;
import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.repository.CategoryRepository;
import com.example.upgradedblogengine.repository.LabelRepository;
import com.example.upgradedblogengine.web.dto.label.NewLabelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LabelServiceImpl implements LabelService{




    private LabelRepository labelRepository;
    private CategoryRepository categoryRepository;

    public LabelServiceImpl(LabelRepository labelRepository, CategoryRepository categoryRepository) {
        this.labelRepository = labelRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Label> getLabels(Pageable pageable){

        //return labelRepository.findAll(pageable).getContent();
        return labelRepository.findAll();
    }

    @Override
    public Label createLabel(NewLabelDTO newLabel){
        Label label= new Label();
        label.setLabelName(newLabel.getLabelName());
        return labelRepository.save(label);
    }

    @Override
    public Label createLabelWithCategories(NewLabelDTO newLabel,Set<Category> categoryList){
        Label label= new Label();
        LabelMapper.INSTANCE.updateFromDto(newLabel, label);
        label.setLabelName(newLabel.getLabelName());
        label.setCategories(categoryList);
        labelRepository.save(label);
        return label;
    }

    @Override
    public Set<Label> getPersistedLabels(Collection<Label> labels){
        return labelRepository.findAllById(labels.stream().map(Label::getLabelId).collect(Collectors.toList())).stream().collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public void deleteLabel(Long id){
        Label label = labelRepository.findById(id).orElseThrow();
        label.getCategories().forEach(u->u.getLabels().remove(label));
        categoryRepository.saveAll(label.getCategories());
        labelRepository.delete(label);
    }




}
