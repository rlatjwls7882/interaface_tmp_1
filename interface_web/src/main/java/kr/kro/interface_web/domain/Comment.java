package kr.kro.interface_web.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Comment {
    @Id
    @Column(nullable = false, name = "comment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
