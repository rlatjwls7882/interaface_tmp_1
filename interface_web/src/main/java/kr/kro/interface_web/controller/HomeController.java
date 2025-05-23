package kr.kro.interface_web.controller;

import kr.kro.interface_web.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model) {
        try {
            model.addAttribute("categories", categoryService.getCategories());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}
