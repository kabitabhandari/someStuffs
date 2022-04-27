package com.example.demo121.fakeapis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This ControllerAdvice class will intercept named exceptions and perform logic
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandlerForController{

    private final static String ID_NOT_FOUND_MESSAGE = "ID Not Found";
    private final static String ID_NOT_MATCHED_MESSAGE = "ID Not Matched";

    @ExceptionHandler(value = {IdNotFoundException.class})
    public final ResponseEntity<PostmanErrorFormat> handleIdNotFoundException(Exception exception){
        log.error("IdNotFoundException: {} {}", exception.getMessage(), exception);
        PostmanErrorFormat error = new PostmanErrorFormat(ID_NOT_FOUND_MESSAGE, String.valueOf(HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {UnmatchedIdException.class})
    public final ResponseEntity<PostmanErrorFormat> handleIdNotMatchedException(Exception exception){
        log.error("IdNotFoundMatched: {} {}", exception.getMessage(), exception);
        PostmanErrorFormat error = new PostmanErrorFormat(ID_NOT_MATCHED_MESSAGE, String.valueOf(HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public final ResponseEntity<PostmanErrorFormat> handleMethodArgumentNotValidatedException(MethodArgumentNotValidException exception){
        log.error("MethodArgumentNotValidatedException: {} {}", exception.getMessage(), exception);


        List<String> allErrorLists = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());


        ListPostmanErrorFormat errorMessage = new ListPostmanErrorFormat(allErrorLists, String.valueOf(HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity(errorMessage,HttpStatus.BAD_REQUEST);
    }



}
