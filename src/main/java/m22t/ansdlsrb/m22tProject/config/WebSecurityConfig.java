package m22t.ansdlsrb.m22tProject.config;


import lombok.RequiredArgsConstructor;
import m22t.ansdlsrb.m22tProject.service.UserLoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig  {
    private final UserLoginService userLoginService;

    @Bean
    public WebSecurityCustomizer configure(){
        return (web) -> web.ignoring()
                .requestMatchers("/static/**"); // static 경로 아래는 로그인 없이 접근 가능
    }


    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        return http
                .authorizeRequests()
                    .requestMatchers("/","/signup" ,"/login", "/user","/search-places","/isDuplicated","/userEmailRegister","/nicknameRegister").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .and()
                .logout()
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
                    .and()
                .csrf()
                    .disable()
                .build();


    }



    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder
    ,UserLoginService userLoginService)throws Exception{

        return http.getSharedObject(AuthenticationManagerBuilder.class)
                    .userDetailsService(userLoginService)
                    .and()
                    .build();


    }




    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}



