package com.example.upgradedblogengine.service;

import com.example.upgradedblogengine.mapper.BlogpostMapper;
import com.example.upgradedblogengine.mapper.LabelMapper;
import com.example.upgradedblogengine.model.Blogpost;
import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.repository.BlogpostRepository;
import com.example.upgradedblogengine.web.dto.blogpost.NewBlogpostDTO;
import com.example.upgradedblogengine.web.dto.blogpost.NewBlogpostWithNewLabelDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class BlogpostServiceImpl implements BlogpostService{



    BlogpostRepository blogpostRepository;
    LabelService labelService;

    public BlogpostServiceImpl(BlogpostRepository blogpostRepository, LabelService labelService) {
        this.blogpostRepository = blogpostRepository;
        this.labelService = labelService;
    }


    @Override
    public List<Blogpost> getBlogpost(Pageable pageable){

        return blogpostRepository.findAll(pageable).getContent();
    }

    @Override
    public void customMapperBlogpostToDTO(Blogpost blogpost, Label label, NewBlogpostDTO newBlogpostDTO)
    {
        blogpost.setLastModification(LocalDateTime.now());
        blogpost.setLabel(label);
        blogpost.setContext(newBlogpostDTO.getContext());
    }

    @Override
    @Transactional
    public Blogpost createBlogpostWithLabel(NewBlogpostWithNewLabelDTO newBlogpostWithNewLabelDTO) {

        Label label=labelService.createLabel(newBlogpostWithNewLabelDTO.getNewLabel());
        Blogpost blogpost = new Blogpost();
        blogpost.setCreationTime(LocalDateTime.now());
        customMapperBlogpostToDTO(blogpost,label, newBlogpostWithNewLabelDTO.getNewBlogpost());

        return blogpostRepository.save(blogpost);
    }




    @Override
    public Blogpost updateBlogpost(NewBlogpostWithNewLabelDTO newBlogpostWithNewLabelDTO) {

        String labelName = newBlogpostWithNewLabelDTO.getNewLabel().getLabelName();
        Label label=labelService.LabelByNameFromDB(labelName);
        LabelMapper.INSTANCE.updateFromDto(newBlogpostWithNewLabelDTO.getNewLabel(), label);
        Blogpost blogpost=blogpostRepository.findBlogpostByLabel(label);
        customMapperBlogpostToDTO(blogpost,label, newBlogpostWithNewLabelDTO.getNewBlogpost());

        return blogpostRepository.save(blogpost);
    }




}
