package kr.kro.interface_web.controller;

import kr.kro.interface_web.service.CategoryService;
import kr.kro.interface_web.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final CategoryService categoryService;

    @GetMapping("/post")
    public String getPost(Long postId, Model model) {
        try {
            model.addAttribute("post", postService.getPost(postId));
            model.addAttribute("categories", categoryService.getCategories());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "post";
    }

    @PostMapping("/post")
    public String createPost(String title, String content, String userId, Long categoryId) {
        try {
            postService.createPost(title, content, userId, categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @PatchMapping("/post")
    public String updatePost(Long postId, String title, String content, long categoryId) {
        try {
            postService.updatePost(postId, title, content, categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/post?postId=" + postId;
    }

    @DeleteMapping("/post")
    public String deletePost(Long postId) {
        try {
            postService.deletePost(postId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/write")
    public String write(Model model) {
        try {
            model.addAttribute("categories", categoryService.getCategories());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "write";
    }
}
