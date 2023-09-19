package m22t.ansdlsrb.m22tProject.controller;


import lombok.RequiredArgsConstructor;
import m22t.ansdlsrb.m22tProject.service.UserSignUpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserSignUpApiController {

    private final UserSignUpService userSignUpService;



    @GetMapping("/userEmailRegister")
    public ResponseEntity<Map<String, Object>> checkUsernameDuplication(@RequestParam String email) {
        HashMap<String, Object> response = new HashMap<>();

        response.put("result", userSignUpService.usernameOverlap(email).get("result"));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/nicknameRegister")
    public ResponseEntity<Map<String, Object>> checkNicknameDuplication(@RequestParam String nickname) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("result", userSignUpService.nicknameOverlap(nickname).get("result"));
        return ResponseEntity.ok(response);
    }


}
