package kr.kro.interface_web.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private String id; // 학번
    private String name; // 닉네임
    private String content; // 자기소개
}
