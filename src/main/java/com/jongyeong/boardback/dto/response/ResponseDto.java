package com.jongyeong.boardback.dto.response;

import org.springframework.http.ResponseEntity;

import com.jongyeong.boardback.common.ResponseCode;
import com.jongyeong.boardback.common.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto {
    
    private String code;
    private String message;

    public static ResponseEntity<ResponseDto> databaseError(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        
    }

}
