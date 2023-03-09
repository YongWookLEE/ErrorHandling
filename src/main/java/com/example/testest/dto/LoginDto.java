package com.example.testest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDto {
    private String id;
    private String password;
    private String townName;
    private String manageCode;
    private boolean manager;
}
