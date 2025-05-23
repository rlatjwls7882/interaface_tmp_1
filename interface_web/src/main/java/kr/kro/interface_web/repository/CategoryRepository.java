package kr.kro.interface_web.repository;

import kr.kro.interface_web.domain.Category;
import kr.kro.interface_web.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
