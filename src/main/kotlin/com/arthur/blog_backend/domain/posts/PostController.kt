package com.arthur.blog_backend.domain.posts

import com.arthur.blog_backend.domain.posts.dto.PostDto
import com.arthur.blog_backend.domain.posts.dto.buildNullPostDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.LinkedList

@Controller
@RequestMapping("/posts")
class PostController(private val postService: PostService) {

    @GetMapping
    fun getAllPosts(model: Model): String {
        val posts = LinkedList(postService.findAll())
        model.addAttribute("posts", posts)
        return "index2"
    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: String, model: Model): String {
        val post = postService.findById(id)
        return when {
            post.isPresent -> run {
                model.addAttribute("post", post.get())
                "single"
            }
            else -> "redirect:/posts"
        }
    }

    @GetMapping("/create")
    fun createPostForm(model: Model): String {
        model.addAttribute("postDto", buildNullPostDto())
        return "create_post"
    }

    @PostMapping
    fun createPost(@ModelAttribute postDto: PostDto): String {
        val post = Post(title = postDto.title!!, content = postDto.content!!, imgUrl = postDto.imgUrl,
            category = Category(postDto.category!!), author = "Arthur", mainView = postDto.mainView, minsOfRead = calculateReadingTime(postDto.content))
        postService.save(post)
        return "redirect:/posts"
    }

    private fun calculateReadingTime(content: String): Int {
        val contentWithoutTags = content.replace("<[^>]*>", "")
        val count = contentWithoutTags.count { equals(' ') }
        return (count*2) / 238 + (1 * 0.083).toInt()
    }
}
