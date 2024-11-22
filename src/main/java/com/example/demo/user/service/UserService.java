package com.example.demo.user.service;

import com.example.demo.user.entity.User;
import com.example.demo.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        // 비밀번호 암호화
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // 데이터베이스에 사용자 정보 저장
        userMapper.saveUser(user);
    }
    public boolean isUserIdDuplicate(String userId) {
        return userMapper.countByUserId(userId) > 0;
    }

    @Autowired
    private JavaMailSender mailSender;

    // 사용자 검증
    public boolean validateUserByIdAndEmail(String userId, String email) {
        User user = userMapper.findByUserId(userId);
        return user != null && user.getEmail().equals(email);
    }

    // 임시 비밀번호 생성
    public String generateTemporaryPassword() {
        return UUID.randomUUID().toString().substring(0, 8); // 8자리 랜덤 문자열
    }

    // 사용자 비밀번호 업데이트
    public void updateUserPassword(String userId, String tempPassword) {
        String encodedPassword = passwordEncoder.encode(tempPassword);
        userMapper.updatePassword(userId, encodedPassword);
    }

    // 이메일 전송
    public void sendTemporaryPassword(String email, String tempPassword) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("임시 비밀번호 발급 안내");
        message.setText("안녕하세요, SingleBungle입니다.\n\n"
                + "다음은 임시 비밀번호입니다:\n"
                + "임시 비밀번호: " + tempPassword + "\n\n"
                + "로그인 후 반드시 비밀번호를 변경해 주세요.\n"
                + "감사합니다.");
        mailSender.send(message);
    }
    public User getUserByUserId(String userId) {
        return userMapper.findByUserId(userId);
    }


}
