package com.example.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // 임시로 저장하는 회원 목록 (실제 서비스에서는 DB로 대체)
    private List<User> userList = new ArrayList<>();

    public UserController() {
        // 초기 데이터
        userList.add(new User(1, "홍길동", "hong@example.com", "010-1234-5678"));
        userList.add(new User(2, "김철수", "kim@example.com", "010-2345-6789"));
    }

    // 회원 관리 페이지
    @GetMapping("/admin/users")
    public String usersPage(Model model) {
        model.addAttribute("userList", userList); // 회원 목록 데이터를 전달
        return "users"; // templates/users.html
    }

    // 회원 추가 처리
    @PostMapping("/admin/users/add")
    public String addUser(String userName, String email, String phone) {
        int nextId = userList.size() + 1; // 새로운 ID 생성
        userList.add(new User(nextId, userName, email, phone));
        return "redirect:/admin/users"; // 추가 후 회원 관리 페이지로 리다이렉트
    }

    // 회원 삭제 처리 (예: GET 요청으로 처리)
    @GetMapping("/admin/users/delete")
    public String deleteUser(int id) {
        userList.removeIf(user -> user.getId() == id); // ID로 회원 삭제
        return "redirect:/admin/users"; // 삭제 후 회원 관리 페이지로 리다이렉트
    }
}
