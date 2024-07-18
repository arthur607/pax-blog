package com.arthur.blog_backend.domain.posts

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PostRepository : MongoRepository<Post, String>{

    fun findByTitle(title: String): Optional<Post>

}
