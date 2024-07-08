package com.arthur.blog_backend.domain.posts

import org.springframework.stereotype.Service
import java.util.*

@Service
class PostService(private val postRepository: PostRepository) {

    fun findAll(): List<Post> = postRepository.findAll()

    fun findById(id: String): Optional<Post> = postRepository.findById(id)

    fun save(post: Post): Post = postRepository.save(post)

    fun deleteById(id: String) = postRepository.deleteById(id)
}
