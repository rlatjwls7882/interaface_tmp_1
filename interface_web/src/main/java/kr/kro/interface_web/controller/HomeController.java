package kr.kro.interface_web.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public static String home() {
        return "index";
    }
}
