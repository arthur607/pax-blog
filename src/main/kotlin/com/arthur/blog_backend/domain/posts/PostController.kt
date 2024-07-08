package com.arthur.blog_backend.domain.posts

import com.arthur.blog_backend.domain.posts.dto.PostDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/posts")
class PostController(private val postService: PostService) {

    @GetMapping
    fun getAllPosts(model: Model): String {
        val posts = postService.findAll()
        model.addAttribute("posts", posts)
        return "index2"
    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: String, model: Model): String {
        val post = postService.findById(id)
        return when {
            post.isPresent -> run {
                model.addAttribute("post", post.get())
                "post"
            }
            else -> "redirect:/posts"
        }
    }

    @GetMapping("/create")
    fun createPostForm(model: Model): String {
        model.addAttribute("postDto", Post(title = "", content = "", category = null))
        return "create_post"
    }

    @PostMapping
    fun createPost(@ModelAttribute postDto: PostDto): String {
        val post = Post(title = postDto.title, content = postDto.content, category = Category(postDto.category))
        postService.save(post)
        return "redirect:/posts"
    }
}
