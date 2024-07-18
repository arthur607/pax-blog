package com.arthur.blog_backend.domain.posts.dto

import com.arthur.blog_backend.domain.posts.Comment
import com.arthur.blog_backend.domain.posts.Like
import com.arthur.blog_backend.domain.posts.Post
import com.arthur.blog_backend.domain.posts.Tag

data class PostDto(
    val title: String?,
    val content: String?,
    val category: String?,
    val imgUrl: String?,
    val mainView: String?,
    val comments: List<Comment>?,
    val likes: List<Like>?,
    val tags: List<Tag>?,
    val createdAt: String?,
    val author: String?,
    val minsOfRead: Int?
)

fun buildNullPostDto() = PostDto(null, null, null, null, null, null, null, null,
    null, null, null)

fun buildFrom(post: Post) = PostDto(post.title, post.content, post.category?.name, post.imgUrl, post.mainView,
    post.comments, post.likes, post.tags, post.createdAt, post.author, post.minsOfRead)