package com.example.upgradedblogengine.repository;

import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabelRepository extends JpaRepository<Label, Long>{


    //List<Category> findCategoryBylabelId(Long labelId);
    //void deletelabelIdBycategoryNameAndlabelId(String categoryName,Long labelId);




}
