package kr.kro.interface_web.service;

import kr.kro.interface_web.domain.Category;
import kr.kro.interface_web.domain.Post;
import kr.kro.interface_web.domain.User;
import kr.kro.interface_web.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    public void createPost(String title, String content, String userId, Long categoryId) throws Exception {
        User user = userService.getUser();
        Category category = categoryService.getCategory(categoryId);
        postRepository.save(new Post(title, content, user, category));
    }

    public Post getPost(Long postId) throws Exception {
        return postRepository.findById(postId).orElse(null);
    }

    public void updatePost(Long postId, String title, String content, long categoryId) throws Exception {
        Post post = postRepository.findById(postId).orElse(null);
        Category category = categoryService.getCategory(categoryId);
        post.update(title, content, category);
        postRepository.save(post);
    }

    @Transactional
    public void deletePost(Long postId) throws Exception {
        Post post = postRepository.findById(postId).orElse(null);
        postRepository.delete(post);
    }
}
