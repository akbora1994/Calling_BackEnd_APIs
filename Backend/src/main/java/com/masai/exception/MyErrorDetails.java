package com.masai.exception;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MyErrorDetails {

	    private LocalDate time;
	    private String message;
	    private String details;
}
