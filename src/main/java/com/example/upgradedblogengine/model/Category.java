package com.example.upgradedblogengine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long categoryId;
    private String categoryName;


    @ManyToMany()
    @JoinTable(
            name = "categoryLabels",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    @JsonIgnore
    Set<Label> labels;


    public Category() {
    }

    public Category(String categoryName, Set<Label> labels) {
        this.categoryName = categoryName;
        this.labels = labels;
    }


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public void addToLabels(Label label){
        this.labels.add(label);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", labels=" + labels +
                '}';
    }
}
