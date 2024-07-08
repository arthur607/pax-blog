package com.arthur.blog_backend.domain.posts

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "posts")
data class Post(
    @Id val id: String? = null,
    val title: String,
    val content: String,
    val comments: List<Comment> = listOf(),
    val likes: List<Like> = listOf(),
    val tags: List<Tag> = listOf(),
    val category: Category?,
    val createdAt: LocalDateTime = LocalDateTime.now()
)

data class Comment(val content: String)
data class Like(val userId: String)
data class Tag(val name: String)
data class Category(val name: String)


