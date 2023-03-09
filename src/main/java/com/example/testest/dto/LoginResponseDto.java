package com.example.testest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class LoginResponseDto {
    private String userName;
    private String townName;
    private boolean check;

}
