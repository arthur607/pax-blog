package com.arthur.blog_backend.domain.posts

import com.arthur.blog_backend.domain.posts.dto.PostDto
import com.arthur.blog_backend.domain.posts.dto.buildFrom
import org.springframework.stereotype.Service
import java.util.*

@Service
class PostService(private val postRepository: PostRepository) {

    fun findAll(): List<PostDto> {
        return postRepository.findAll()
            .filterNotNull()
            .map { buildFrom(it) }
            .ifEmpty { return emptyList() }
    }

    fun findById(id: String): Optional<Post> = postRepository.findById(id)

    fun findByTitle(title: String): Optional<Post> = postRepository.findByTitle(title)

    fun save(post: Post): Post = postRepository.save(post)

    fun deleteById(id: String) = postRepository.deleteById(id)
}
