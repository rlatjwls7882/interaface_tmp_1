package kr.kro.interface_web.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Cascade;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts; // 게시글 목록

    public User() {}
    public User(String id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }
    public void update(String content) {
        this.content = content;
    }
}
