package com.example.testprogect.common.exception;

import com.example.testprogect.common.Constants;
import org.springframework.http.HttpStatus;

public class CKHubException extends Exception{

    private  static final long serialVersionUID = 4663380430591151694L;

    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public CKHubException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message){
        super(exceptionClass.toString() + message);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public Constants.ExceptionClass getExceptionClass(){
        return exceptionClass;
    }
    public int getHttpStatusCode(){
        return httpStatus.value();
    }
    public String getHttpStatusType(){
        return httpStatus.getReasonPhrase();
    }
    public HttpStatus getHttpStatus(){
        return httpStatus;
    }


}
