package com.example.testest.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String id;
    private String password;
    private String userName;

    @Builder
    public UserEntity(Long seq, String id, String password, String userName) {
        this.seq = seq;
        this.id = id;
        this.password = password;
        this.userName = userName;
    }

}
