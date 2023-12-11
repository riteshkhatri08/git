package com.beta.replyservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.beta.replyservice.model.ErrorReplyMessage;

@ControllerAdvice
public class DefaultExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<Object> handleConflict() {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ErrorReplyMessage("Internal Server Error"));

	}
}
