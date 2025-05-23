package kr.kro.interface_web.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class User {
    @Id
    @Column(nullable = false, name = "user_id")
    private String id; // 학번

    @Column(nullable = false)
    private String name; // 닉네임

    @Column(nullable = false)
    private String content; // 자기소개

    @OneToMany(mappedBy = "user")
    private List<Post> posts; // 게시글 목록
}
