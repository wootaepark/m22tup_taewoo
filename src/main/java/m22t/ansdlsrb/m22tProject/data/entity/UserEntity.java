package m22t.ansdlsrb.m22tProject.data.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name="user_info")
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class UserEntity implements UserDetails {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",updatable=false)
    private Long id; //pk 값

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @Column(name="nickname",nullable = false,unique = true)
    private String nickname;

    @Column(name="password")
    private String password;

    @Builder
    public UserEntity(String email, String nickname, String password, String auth){
        this.email=email;
        this.nickname=nickname;
        this.password=password;
    }
    
    @Override // 권환 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override // 사용자의 고유한 값 반환
    public String getUsername() {
        return email;
    }



    @Override
    public boolean isAccountNonExpired() {
        // 만료 되었는지 확인하는 과정
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        //계정이 잠겼는지 확인하는 로직
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
