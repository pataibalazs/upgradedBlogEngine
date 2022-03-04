package com.example.upgradedblogengine.web.dto.blogpost;

import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.web.dto.label.LabelDTO;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

public class BlogpostDTO {


    private String context;
    private LocalDateTime lastModification;
    private LocalDateTime creationTime;
    private LabelDTO label;


    public BlogpostDTO(String context, LocalDateTime lastModification, LocalDateTime creationTime, LabelDTO label) {
        this.context = context;
        this.lastModification = lastModification;
        this.creationTime = creationTime;
        this.label = label;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public LocalDateTime getLastModification() {
        return lastModification;
    }

    public void setLastModification(LocalDateTime lastModification) {
        this.lastModification = lastModification;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LabelDTO getLabel() {
        return label;
    }

    public void setLabel(LabelDTO label) {
        this.label = label;
    }
}
