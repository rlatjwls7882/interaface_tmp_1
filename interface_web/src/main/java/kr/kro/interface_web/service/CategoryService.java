package kr.kro.interface_web.service;

import kr.kro.interface_web.domain.Category;
import kr.kro.interface_web.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public void createCategory(String name, String content) throws Exception {
        categoryRepository.save(new Category(name, content));
    }
    public void updateCategory(Long categoryId, String name, String content) throws Exception {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        category.update(name, content);
        categoryRepository.save(category);
    }
    public void deleteCategory(Long categoryId) throws Exception {

    }
    public Category getCategory(Long categoryId) throws Exception {
        return categoryRepository.findById(categoryId).orElse(null);
    }
}
