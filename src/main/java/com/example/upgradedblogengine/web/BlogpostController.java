package com.example.upgradedblogengine.web;

import com.example.upgradedblogengine.mapper.LabelMapper;
import com.example.upgradedblogengine.model.Blogpost;
import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.service.BlogpostService;
import com.example.upgradedblogengine.web.dto.blogpost.BlogpostDTO;
import com.example.upgradedblogengine.web.dto.blogpost.NewBlogpostWithNewLabelDTO;
import com.example.upgradedblogengine.web.dto.category.CategoryDTO;
import com.example.upgradedblogengine.web.dto.category.NewCategoryWithNewLabelsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/blogpost")
public class BlogpostController {

    @Autowired
    BlogpostService blogpostService;

    private BlogpostDTO mapBlogpostToDTO(Blogpost blogpost) {
        return new BlogpostDTO(blogpost.getContext(),blogpost.getLastModification(),blogpost.getCreationTime(), LabelMapper.INSTANCE.labelToDTO(blogpost.getLabel()));
    }

    @GetMapping()
    public List<BlogpostDTO> getBlogpost(Pageable pageable) {
        return blogpostService.getBlogpost(pageable).stream().map(blogpost-> mapBlogpostToDTO(blogpost)).collect(Collectors.toList());
    }

    @PostMapping("/withLabel")
    public BlogpostDTO createBlogpostWithLabel(@RequestBody @Valid NewBlogpostWithNewLabelDTO newBlogpostWithNewLabelDTO) {
        return mapBlogpostToDTO(blogpostService.createBlogpostWithLabel(newBlogpostWithNewLabelDTO));
    }

    @PutMapping("/updateBlogpost")
    public BlogpostDTO updateBlogpostWithLabel(@RequestBody @Valid NewBlogpostWithNewLabelDTO newBlogpostWithNewLabelDTO) {
        return mapBlogpostToDTO(blogpostService.updateBlogpost(newBlogpostWithNewLabelDTO));
    }





}
