package com.example.upgradedblogengine.web.dto.label;

import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.web.dto.category.CategoryDTO;

import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

public class LabelDTO {

    String labelName;
    Set<CategoryDTO> categories;


    public LabelDTO(String labelName, Set<CategoryDTO> categories) {
        this.labelName = labelName;
        this.categories = categories;
    }
    public LabelDTO() {

    }



    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDTO> categories) {
        this.categories = categories;
    }
}
