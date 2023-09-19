package m22t.ansdlsrb.m22tProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(){return "signup";}

    @GetMapping("/")
    public String Main(){
        return "startPage";
    }
}
