package com.example.upgradedblogengine.repository;

import com.example.upgradedblogengine.model.Blogpost;
import com.example.upgradedblogengine.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogpostRepository extends JpaRepository<Blogpost, Long> {

    public Blogpost findBlogpostByLabel(Label label);
}
