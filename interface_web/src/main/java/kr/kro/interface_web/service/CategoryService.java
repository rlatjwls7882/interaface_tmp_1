package kr.kro.interface_web.service;

import kr.kro.interface_web.domain.Category;
import kr.kro.interface_web.domain.Post;
import kr.kro.interface_web.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final UserService userService;

    public Category createCategory(String name, String content) throws Exception {
        Category category = new Category(name, content);
        categoryRepository.save(category);
        return category;
    }
    public void updateCategory(Long categoryId, String name, String content) throws Exception {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        category.update(name, content);
        categoryRepository.save(category);
    }
    public Category getCategory(Long categoryId) throws Exception {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public List<Category> getCategories() throws Exception {
        return (List<Category>) categoryRepository.findAll();
    }

    @Transactional
    public void deleteCategory(Long categoryId) throws Exception {
        categoryRepository.deleteById(categoryId);
    }
}
