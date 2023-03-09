package com.example.testest.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_town")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TownEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String townName;
    private String manageCode;

    @Builder
    public TownEntity(Long seq, String townName, String manageCode) {
        this.seq = seq;
        this.townName = townName;
        this.manageCode = manageCode;
    }
}
