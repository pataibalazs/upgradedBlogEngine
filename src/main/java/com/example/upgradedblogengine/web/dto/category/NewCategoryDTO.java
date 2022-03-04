package com.example.upgradedblogengine.web.dto.category;


import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.web.dto.label.LabelDTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

public class NewCategoryDTO {

    @NotEmpty
    private String categoryName;
    @NotNull
    Set<LabelDTO> labels;


    public NewCategoryDTO(String categoryName, Set<LabelDTO> labels) {
        this.categoryName = categoryName;
        this.labels = labels;
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
