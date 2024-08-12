package com.example.entranceexam.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "filestorage")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;


    @Column(name = "description", nullable = false)
    private String description;


    @Column(name = "file", nullable = false)
    private String file;

    // Геттер для поля id
    public Long getId() {
        return id;
    }

    // Другие геттеры и сеттеры для полей
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
