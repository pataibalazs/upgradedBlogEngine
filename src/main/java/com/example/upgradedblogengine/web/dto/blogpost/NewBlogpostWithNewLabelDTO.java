package com.example.upgradedblogengine.web.dto.blogpost;

import com.example.upgradedblogengine.web.dto.category.NewCategoryDTO;
import com.example.upgradedblogengine.web.dto.label.NewLabelDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class NewBlogpostWithNewLabelDTO {


    @NotNull
    @Valid
    private NewBlogpostDTO newBlogpost;

    @NotNull
    @Valid
    private NewLabelDTO newLabel;


    public NewBlogpostDTO getNewBlogpost() {
        return newBlogpost;
    }

    public void setNewBlogpost(NewBlogpostDTO newBlogpost) {
        this.newBlogpost = newBlogpost;
    }

    public NewLabelDTO getNewLabel() {
        return newLabel;
    }

    public void setNewLabel(NewLabelDTO newLabel) {
        this.newLabel = newLabel;
    }
}
