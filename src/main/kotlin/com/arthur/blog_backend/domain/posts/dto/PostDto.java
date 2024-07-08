package com.arthur.blog_backend.domain.posts.dto;

import java.time.LocalDateTime;

public class PostDto {

    private String title;
    private String content;
    private String category;
    private final LocalDateTime createdAt = LocalDateTime.now();

    public PostDto() {
    }

    public PostDto(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
