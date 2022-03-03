package com.example.upgradedblogengine.repository;

import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.model.Label;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LabelRepository extends JpaRepository<Label, Long>{



}
