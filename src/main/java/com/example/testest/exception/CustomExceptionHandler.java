package com.example.testest.exception;

import com.example.testest.dto.ResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ControllerAdvice
public class CustomExceptionHandler {

    /**
     *  DATA 없을 시 Custom Error 처리
     * @param ex
     * @return 헤더, RESPONSE DTO -RESULT CODE, RESULT MESSAGE
     */
    @ExceptionHandler(NoDataException.class)
    protected ResponseEntity<ResponseDto> NoDataExceptionHandler(NoDataException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("resultCode", ex.getCODE());
        headers.add("resultMsg", ex.getMessage());

        ResponseDto response = new ResponseDto(ex.getCODE(),ex.getMessage(), null);

        return ResponseEntity.ok().headers(headers).body(response);

    }

    /**
     * 500 ERROR
     * @param ex
     * @return 헤더, RESPONSE DTO -RESULT CODE, RESULT MESSAGE
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResponseDto> ExceptionHandler(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("resultCode", "10");
        headers.add("resultMsg", "INTERNAL SERVER ERROR");

        ResponseDto response = new ResponseDto("10","INTERNAL SERVER ERROR", null);

        return ResponseEntity.ok().headers(headers).body(response);

    }

    /**
     * 잘못된 PARAMETER 받을 시 CUSTOM ERROR 처리
     * @param ex
     * @return 헤더, RESPONSE DTO -RESULT CODE, RESULT MESSAGE
     */
    @ExceptionHandler(InvalidRequestParameterException.class)
    protected ResponseEntity<ResponseDto> InvalidRequestParameterExceptionHandler(InvalidRequestParameterException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("resultCode", ex.getCODE());
        headers.add("resultMsg", ex.getMessage());

        ResponseDto response = new ResponseDto(ex.getCODE(),ex.getMessage(), null);

        return ResponseEntity.ok().headers(headers).body(response);

    }

    /**
     *  실행 실패 시 CUSTOM ERROR 처리
     * @param ex
     * @return 헤더, RESPONSE DTO -RESULT CODE, RESULT MESSAGE
     */
    @ExceptionHandler(WrongExecutionException.class)
    protected ResponseEntity<ResponseDto> WrongExecutionExceptionHandler(WrongExecutionException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("resultCode", ex.getCODE());
        headers.add("resultMsg", ex.getMessage());

        ResponseDto response = new ResponseDto(ex.getCODE(),ex.getMessage(), null);

        return ResponseEntity.ok().headers(headers).body(response);

    }

    /**
     *  모르는 ERORR 발생 시 CUSTOM ERROR 처리
     * @param ex
     * @return 헤더, RESPONSE DTO -RESULT CODE, RESULT MESSAGE
     */
    @ExceptionHandler(UnknownException.class)
    protected ResponseEntity<ResponseDto> UnknownExceptionHandler(UnknownException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("resultCode", ex.getCODE());
        headers.add("resultMsg", ex.getMessage());

        ResponseDto response = new ResponseDto(ex.getCODE(),ex.getMessage(), null);

        return ResponseEntity.ok().headers(headers).body(response);

    }
}
