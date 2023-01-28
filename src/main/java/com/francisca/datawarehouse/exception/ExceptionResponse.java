package com.francisca.datawarehouse.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionResponse<T> {
    private String message;
    private LocalDateTime timeStamp;
    private HttpStatus status;


}
