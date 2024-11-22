package com.example.demo.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    // 인증 없이 접근 가능한 URL 리스트
    private static final String[] WHITE_LIST = {
            "/",
            "/user/login",
            "/user/register",
            "/home",
            "/user/check-duplicate", // 중복 확인 API 추가
            "/static/**", // 정적 리소스
            "/user/forgot",
            "/user/reset"
    };

    /**
     * 정적 리소스에 대한 보안 필터 비활성화
     */
    @Bean
    public WebSecurityCustomizer configure() {
        return web -> web.ignoring()
                .requestMatchers("/static/**", "/user/styles.css", "/script.js", "/register.js");
    }

    /**
     * HTTP 보안 설정
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers(WHITE_LIST).permitAll() // 화이트리스트에 인증 불필요
                        .requestMatchers("/admin/**").hasRole("ADMIN") // 관리자 경로
                        .requestMatchers("/auth/**").hasAnyRole("USER", "ADMIN") // 사용자 경로
                        .anyRequest().authenticated() // 나머지는 인증 필요
                )
                .formLogin(form -> form
                        .loginPage("/user/login") // 로그인 페이지 설정
                        .defaultSuccessUrl("/home") // 로그인 성공 시 이동할 페이지
                        .failureUrl("/user/login?error=true") // 로그인 실패 시 이동할 페이지
                        .usernameParameter("username") // 폼의 사용자명 파라미터
                        .passwordParameter("password") // 폼의 비밀번호 파라미터
                )
                .logout(logout -> logout
                        .logoutUrl("/user/logout")
                        .logoutSuccessUrl("/home") // 로그아웃 성공 시 이동할 페이지
                        .invalidateHttpSession(true)
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/accessDenied") // 접근 거부 시 이동 경로
                )
                .csrf(csrf -> csrf.disable()); // CSRF 비활성화 (개발 시)

        return http.build();
    }

    /**
     * 비밀번호 암호화를 위한 Bean
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 인증 관리자 설정
     */
    @Bean
    public AuthenticationManager authenticationManager(
            HttpSecurity http,
            BCryptPasswordEncoder passwordEncoder) throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService); // 사용자 정보 제공
        authProvider.setPasswordEncoder(passwordEncoder); // 비밀번호 암호화 설정

        return new ProviderManager(authProvider);
    }
}
