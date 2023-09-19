package m22t.ansdlsrb.m22tProject.service;
// 유저 로그인 진행 시 사용자 정보를 가져오는 서비스 코드

import lombok.RequiredArgsConstructor;
import m22t.ansdlsrb.m22tProject.data.entity.UserEntity;
import m22t.ansdlsrb.m22tProject.data.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // 빨간 줄 이 코드로 해결 됨
@Service
public class UserLoginService implements UserDetailsService {
    private final UserRepository userRepository;
    
    @Override
    public UserEntity loadUserByUsername(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()->new IllegalArgumentException(email));
    }




}
