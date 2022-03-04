package com.example.upgradedblogengine.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Blogpost {


    @Id
    @GeneratedValue
    @Column(name = "blogpostId")
    private Long blogpostId;
    private LocalDateTime lastModification;
    private LocalDateTime creationTime;
    private String context;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "labelId")
    private Label label;


    public Blogpost( LocalDateTime lastModification, LocalDateTime creationTime, String context, Label label) {
        this.lastModification = lastModification;
        this.creationTime = creationTime;
        this.context = context;
        this.label = label;
    }

    public Blogpost() {
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Long getBlogpostId() {
        return blogpostId;
    }

    public void setBlogpostId(Long blogpostId) {
        this.blogpostId = blogpostId;
    }
}
