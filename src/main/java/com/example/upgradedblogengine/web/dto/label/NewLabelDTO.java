package com.example.upgradedblogengine.web.dto.label;

import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.model.Label;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

public class NewLabelDTO {


    @NotEmpty
    private String labelName;
    Set<Category> categories;


    public NewLabelDTO(String labelName, Set<Category> categories) {
        this.labelName = labelName;
        this.categories = categories;
    }
    public NewLabelDTO() {
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "NewLabelDTO{" +
                "labelName='" + labelName + '\'' +
                ", categories=" + categories +
                '}';
    }
}
