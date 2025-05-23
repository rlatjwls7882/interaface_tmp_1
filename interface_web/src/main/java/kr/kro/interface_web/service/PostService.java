package kr.kro.interface_web.service;

import kr.kro.interface_web.domain.Post;
import kr.kro.interface_web.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void createPost(String title, String content, String userId, String categoryId) {
        // 게시글 생성 로직
        // 예: postRepository.save(new Post(title, content, userId, categoryId));
    }
}
