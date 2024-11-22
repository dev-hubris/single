package com.example.demo.admin.service;

import com.example.demo.admin.model.Member; // Member 클래스 임포트
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private List<Member> memberList = new ArrayList<>();

    public List<Member> getAllMembers() {
        return memberList;
    }

    public void addMember(String name, String email) {
        memberList.add(new Member(name, email));
    }
}
