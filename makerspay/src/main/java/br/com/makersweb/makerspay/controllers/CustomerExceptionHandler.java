package br.com.makersweb.makerspay.controllers;

import br.com.makersweb.makerspay.exceptions.CustomerLimitExcededException;
import br.com.makersweb.makerspay.exceptions.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author anderson
 */
@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Void> handleCustomerNotFound(final CustomerNotFoundException ex) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ CustomerLimitExcededException.class, IllegalArgumentException.class, MethodArgumentNotValidException.class, HttpMessageNotReadableException.class })
    public ResponseEntity<Void> handleCustomerLimitExcededException(Exception ex) {
        return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
