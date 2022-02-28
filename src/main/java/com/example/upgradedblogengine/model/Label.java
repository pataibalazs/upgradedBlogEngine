package com.example.upgradedblogengine.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;


public class Label {
    @Id
    @GeneratedValue
    private Long labelId;
    private String labelName;
/*
    @ManyToMany(mappedBy = "labels")
    Set<Category> categories;

 */


}
