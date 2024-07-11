package com.arthur.blog_backend.domain.posts.dto

import com.arthur.blog_backend.domain.posts.Post

data class PostDto(
    val title: String?,
    val content: String?,
    val category: String?,
    val imgUrl: String?,
    val mainView: String?,
)

fun buildNullPostDto() = PostDto(null, null, null, null, null)