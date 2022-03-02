package com.example.upgradedblogengine.web.dto.category;

import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.web.dto.label.NewLabelDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

public class NewCategoryWithNewLabelsDTO {

    @NotNull
    @Valid
    private NewCategoryDTO newCategory;

    @NotNull
    @Valid
    private Set<NewLabelDTO> labels;


    public NewCategoryDTO getNewCategory() {
        return newCategory;
    }

    public void setNewCategory(NewCategoryDTO newCategory) {
        this.newCategory = newCategory;
    }

    public Set<NewLabelDTO> getLabels() {
        return labels;
    }

    public void setLabels(Set<NewLabelDTO> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "NewCategoryWithNewLabelsDTO{" +
                "newCategory=" + newCategory +
                ", labels=" + labels +
                '}';
    }
}
