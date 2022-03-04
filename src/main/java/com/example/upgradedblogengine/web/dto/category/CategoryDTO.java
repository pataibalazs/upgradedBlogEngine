package com.example.upgradedblogengine.web.dto.category;

import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.web.dto.label.LabelDTO;

import java.io.Serializable;
import java.util.Set;

public class CategoryDTO {

    private String categoryName;
    Set<LabelDTO> labels;


    public CategoryDTO(String categoryName, Set<LabelDTO> labels) {
        this.categoryName = categoryName;
        this.labels = labels;
    }
    public CategoryDTO() {

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<LabelDTO> getLabels() {
        return labels;
    }

    public void setLabels(Set<LabelDTO> labels) {
        this.labels = labels;
    }
}
