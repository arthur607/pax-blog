package com.arthur.blog_backend.domain.posts

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Document(collection = "posts")
data class Post(
    @Id val id: String? = null,
    val title: String,
    val content: String,
    val mainView: String?,
    val comments: List<Comment> = listOf(),
    val likes: List<Like> = listOf(),
    val tags: List<Tag> = listOf(),
    val category: Category?,
    val imgUrl: String?,
    val createdAt: String = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MMMM uuuu",Locale.of("pt"))),
    val author: String?,
    val minsOfRead: Int?
)

data class Comment(val content: String)
data class Like(val userId: String)
data class Tag(val name: String)
data class Category(val name: String)


