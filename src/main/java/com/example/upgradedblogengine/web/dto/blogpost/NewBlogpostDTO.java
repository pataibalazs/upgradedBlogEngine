package com.example.upgradedblogengine.web.dto.blogpost;

import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.web.dto.label.LabelDTO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class NewBlogpostDTO {



    private String context;


    public NewBlogpostDTO(String context) {
        this.context = context;
    }
    public NewBlogpostDTO() {
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}

//
