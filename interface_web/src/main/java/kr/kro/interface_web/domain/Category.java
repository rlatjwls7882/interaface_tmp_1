package kr.kro.interface_web.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Category {
    @Id
    @Column(nullable = false, name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 카테고리 ID

    @Column(nullable = false)
    private String name; // 카테고리 이름

    @Column(nullable = false)
    private String content; // 카테고리 설명

    @OneToMany(mappedBy = "category")
    private List<Post> posts;

    public Category() {}
    public Category(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public void update(String name, String content) {
        this.name = name;
        this.content = content;
    }
}