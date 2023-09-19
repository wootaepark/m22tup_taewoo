package m22t.ansdlsrb.m22tProject.service;


import lombok.RequiredArgsConstructor;
import m22t.ansdlsrb.m22tProject.data.dto.UserSignUpDto;
import m22t.ansdlsrb.m22tProject.data.entity.UserEntity;
import m22t.ansdlsrb.m22tProject.data.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class UserSignUpService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(UserSignUpDto userSignUpDto){
        return userRepository.save(UserEntity.builder()
                .email(userSignUpDto.getEmail())
                .nickname(userSignUpDto.getNickname())
                .password(bCryptPasswordEncoder.encode(userSignUpDto.getPassword()))
                .build()).getId();

    }

    public HashMap<String, Object> usernameOverlap(String email) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", userRepository.existsByEmail(email));
        return map;
    }

    //닉네임 중복 검사
    public HashMap<String, Object> nicknameOverlap(String nickname) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", userRepository.existsByNickname(nickname));
        return map;
    }

}
