package kr.kro.interface_web.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private CategoryService categoryService;

    @Test
    @Order(1)
    void createUser() {
        for(int i=1;i<10;i++) {
            userService.createUser("id"+i, "name"+i, "content"+i);
        }
    }

    @Test
    @Order(2)
    void createCategory() {
        for(int i=1;i<10;i++) {
            try {
                categoryService.createCategory("name"+i, "content"+i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @Order(3)
    void createPost() {
        for(int i=1;i<10;i++) {
            try {
                postService.createPost("title"+i, "content"+i, "id"+i, (long)(i/5+1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
