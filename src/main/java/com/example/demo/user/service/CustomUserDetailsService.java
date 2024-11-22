package com.example.demo.user.service;

import com.example.demo.user.entity.User;
import com.example.demo.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("입력된 username: " + username);

        User user = userMapper.findByUserId(username);
        if (user == null) {
            System.out.println("사용자를 찾을 수 없습니다: " + username);
            throw new UsernameNotFoundException("User not found: " + username);
        }

        System.out.println("조회된 사용자 정보: " + user);

        // 권한 설정
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(
                user.getUserId(),
                user.getPassword(), // 비밀번호는 반드시 암호화된 상태여야 합니다
                authorities
        );
    }
}
