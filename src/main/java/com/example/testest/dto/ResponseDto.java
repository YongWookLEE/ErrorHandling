package com.example.testest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto<T> {
    private String resultCode;
    private String resultMsg;
    private T data;

    public ResponseDto(String resultCode, String resultMsg, T data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }

}
