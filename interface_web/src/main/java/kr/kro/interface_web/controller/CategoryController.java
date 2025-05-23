package kr.kro.interface_web.controller;

import jakarta.servlet.http.HttpSession;
import kr.kro.interface_web.domain.Category;
import kr.kro.interface_web.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        try {
            return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping
    public ResponseEntity<?> updateCategory(Long categoryId, String title, String content) {
        try {
            categoryService.updateCategory(categoryId, title, content);
        } catch (Exception e) {
            return ResponseEntity.ok(Boolean.FALSE);
        }
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(String name, String content) {
        try {
            Category category = categoryService.createCategory(name, content);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCategory(long categoryId, HttpSession session) {
        try {
            categoryService.deleteCategory(categoryId);
        } catch (Exception e) {
            return ResponseEntity.ok(Boolean.FALSE);
        }
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
