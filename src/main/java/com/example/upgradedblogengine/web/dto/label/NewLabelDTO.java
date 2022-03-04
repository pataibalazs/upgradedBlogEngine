package com.example.upgradedblogengine.web.dto.label;

import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.web.dto.category.CategoryDTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

public class NewLabelDTO {


    @NotEmpty
    @Size(min = 3, max = 10)
    private String labelName;
    Set<String> categories;


    public NewLabelDTO(String labelName, Set<String> categories) {
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

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }
}
