package com.francisca.datawarehouse.exception;

public class DealAlreadyExistException extends RuntimeException {
    //todo
    // this exception class is only used once with the message ""Deal with Id number: " + uniqueId + " already exist""
    // It would make sense to move the "Deal with Id number: " + uniqueId + " already exist" message into the constructor
    // here and then take only the id as the constructor argument.
    public DealAlreadyExistException(String message) {
        super(message);
    }


}
