package com.example.upgradedblogengine.web.dto.category;

import com.example.upgradedblogengine.model.Label;

import java.io.Serializable;
import java.util.Set;

public class CategoryDTO {

    private String categoryName;
    Set<Label> labels;


    public CategoryDTO(String categoryName, Set<Label> labels) {
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

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }
}
