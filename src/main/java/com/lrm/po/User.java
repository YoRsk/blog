package com.lrm.po;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String username;
    private String password;
    private String avatar;
    private String email;
    private String workKind;//工作性质
    private String workPlace;//工作地点
    private String introduce;//个人介绍

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Blog> blogs = new ArrayList<>();

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", workKind='" + workKind + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
