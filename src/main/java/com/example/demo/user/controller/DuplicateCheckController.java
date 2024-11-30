package com.example.demo.user.controller;

import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user/check-duplicate")
public class DuplicateCheckController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Map<String, Boolean>> checkDuplicate(@RequestParam String userId) {
        boolean isDuplicate = userService.isUserIdDuplicate(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("isDuplicate", isDuplicate);
        return ResponseEntity.ok(response);
    }
}
