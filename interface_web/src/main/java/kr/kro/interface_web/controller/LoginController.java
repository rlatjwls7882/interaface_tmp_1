package kr.kro.interface_web.controller;

import jakarta.servlet.http.HttpSession;
import kr.kro.interface_web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "redirect:http://localhost:3000/login.html";
    }

    @PostMapping("/login")
    public void loginPost(@RequestBody Map<String, String> requestBody, HttpSession session) {
        String id = requestBody.get("email");
        try {
            session.setAttribute("id", id);
            if(!userService.existsUser(id)) userService.createUser(id, "", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
