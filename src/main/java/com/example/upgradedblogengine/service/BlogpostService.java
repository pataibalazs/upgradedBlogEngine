package com.example.upgradedblogengine.service;


import com.example.upgradedblogengine.model.Blogpost;
import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.web.dto.blogpost.NewBlogpostDTO;
import com.example.upgradedblogengine.web.dto.blogpost.NewBlogpostWithNewLabelDTO;
import com.example.upgradedblogengine.web.dto.category.NewCategoryWithNewLabelsDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogpostService {

    public List<Blogpost> getBlogpost(Pageable pageable);

    public Blogpost createBlogpostWithLabel(NewBlogpostWithNewLabelDTO newBlogpostWithNewLabelDTO);
    public void customMapperBlogpostToDTO(Blogpost blogpost,Label label, NewBlogpostDTO newBlogpostDTO);
    public Blogpost updateBlogpost(NewBlogpostWithNewLabelDTO newBlogpostWithNewLabelDTO);
}
