package com.example.upgradedblogengine.web.dto.label;

import com.example.upgradedblogengine.model.Category;

import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

public class LabelDTO {


    @ManyToMany(mappedBy = "labels")
    Set<Category> categories;

    public LabelDTO(String labelName, Set<Category> categories) {
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    private String labelName;


}
