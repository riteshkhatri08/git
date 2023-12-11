package com.beta.replyservice.controller;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.beta.replyservice.exception.InvalidInputException;
import com.beta.replyservice.model.ErrorReplyMessage;
import com.beta.replyservice.model.ReplyMessage;
import com.beta.replyservice.service.ReplyServiceV2;

@RestController
@RequestMapping(value = "/v2")
@Validated
public class ReplyControllerV2 {

	@Autowired
	ReplyServiceV2 replyService;

	@GetMapping({ "/reply/", "/reply/{message}" })
	public ReplyMessage replying(
			@PathVariable(required = false) @Pattern(regexp = "^[\\d]{2}-[\\S]+") String message) {
		if (null == message) {
			throw new InvalidInputException();
		} else {

			return replyService.getReplyMessage(message);
		}
	}

	// Exception Handle to handle Invalid Input and ConstraintViolationException for
	// this controller
	@ExceptionHandler(value = { ConstraintViolationException.class, InvalidInputException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorReplyMessage handleInvalidInputException() {
		return new ErrorReplyMessage("Invalid input");
	}

}
