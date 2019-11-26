package com.diogo.restwithspring.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperation extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public UnsuportedMathOperation(String exception){
        super(exception);
    }



}
