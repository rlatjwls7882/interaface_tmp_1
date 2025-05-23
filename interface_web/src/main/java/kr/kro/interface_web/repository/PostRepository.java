package kr.kro.interface_web.repository;

import kr.kro.interface_web.domain.Post;
import kr.kro.interface_web.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
