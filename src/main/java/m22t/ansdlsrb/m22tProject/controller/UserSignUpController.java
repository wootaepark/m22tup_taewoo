package m22t.ansdlsrb.m22tProject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import m22t.ansdlsrb.m22tProject.data.dto.UserSignUpDto;
import m22t.ansdlsrb.m22tProject.service.UserSignUpService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserSignUpController {

    private final UserSignUpService userSignUpService;

    @PostMapping("/user")
    public String signup(UserSignUpDto userSignUpDto){
        userSignUpService.save(userSignUpDto);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/startPage";
    }

}
