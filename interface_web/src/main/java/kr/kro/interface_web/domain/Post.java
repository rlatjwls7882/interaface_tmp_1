package kr.kro.interface_web.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Post {
    @Id
    @Column(nullable = false, name = "post_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 게시글 ID

    @Column(nullable = false)
    private String title; // 게시글 제목

    @Column(nullable = false)
    private String content; // 게시글 내용

    @Column(nullable = false)
    private Date inDate; // 작성일

    @Column(nullable = false)
    private Date upDate; // 수정일

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 작성자 관계 설정

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category; // 카테고리 관계 설정

    public Post() {}
    public Post(String title, String content, User user, Category category) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.category = category;
        this.upDate = this.inDate = new Date();
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
        this.upDate = new Date();
    }
}
