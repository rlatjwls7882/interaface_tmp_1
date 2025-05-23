package kr.kro.interface_web.repository;

import kr.kro.interface_web.domain.Comment;
import kr.kro.interface_web.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
