package kr.kro.interface_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/edit_profile")
    public String editProfile() {
        return "edit_profile";
    }

    @GetMapping("/hot")
    public String hot() {
        return "board";
    }

    @GetMapping("/study")
    public String study() {
        return "study";
    }
    @GetMapping("/library")
    public String library() {
        return "library";
    }
}
