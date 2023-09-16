package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(UserException.class)
	    public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException ex, WebRequest wb){

	        MyErrorDetails err = new MyErrorDetails();
	        err.setTime(LocalDate.now());
	        err.setMessage(ex.getMessage());
	        err.setDetails(wb.getDescription(false));

	        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	    }

	 @ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<MyErrorDetails> dataValidataionException(MethodArgumentNotValidException e,WebRequest req) {
			
			MyErrorDetails err = new MyErrorDetails() ;

			err.setTime(LocalDate.now());
			err.setDetails(req.getDescription(false));
			err.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
			
			return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
		}
		
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<MyErrorDetails> exceptionHandler(Exception ex, WebRequest wb){

	        MyErrorDetails err = new MyErrorDetails();
	        err.setTime(LocalDate.now());
	        err.setMessage(ex.getMessage());
	        err.setDetails(wb.getDescription(false));

	        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	    }
}
