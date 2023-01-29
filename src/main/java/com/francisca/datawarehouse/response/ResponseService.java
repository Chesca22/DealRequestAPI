package com.francisca.datawarehouse.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public  class ResponseService<T>{

        public ResponseEntity<T> response(T response , HttpStatus status){
            return new ResponseEntity<>(response , status);
        }
    }
