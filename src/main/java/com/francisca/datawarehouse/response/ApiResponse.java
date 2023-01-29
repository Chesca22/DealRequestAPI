package com.francisca.datawarehouse.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ApiResponse<T> {
    private String message;
    private LocalDateTime timeStamp;
    private T data;
}
