package com.example.upgradedblogengine.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Label {
    @Id
    @GeneratedValue
    private Long labelId;
    private String labelName;

    @ManyToMany(mappedBy = "labels")
    @JsonIgnore
    Set<Category> categories;


    public Label( String labelName, Set<Category> categories) {

        this.labelName = labelName;
        this.categories = categories;
    }
    public Label() {

    }

    public Label(Long labelId) {
        this.labelId = labelId;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
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
        return "Label{" +
                "labelId=" + labelId +
                ", labelName='" + labelName + '\'' +
                ", categories=" + categories.size() +
                '}';
    }
}
