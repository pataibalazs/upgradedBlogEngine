package com.example.upgradedblogengine.web.dto.category;


import com.example.upgradedblogengine.model.Label;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

public class NewCategoryDTO {

    @NotEmpty
    private String categoryName;
    @NotNull
    Set<Label> labels;

    public NewCategoryDTO(String categoryName, Set<Label> labels) {
        this.categoryName = categoryName;
        this.labels = labels;
    }

    public NewCategoryDTO() {
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

    @Override
    public String toString() {
        return "NewCategoryDTO{" +
                "categoryName='" + categoryName + '\'' +
                ", labels=" + labels +
                '}';
    }
}
