package com.beta.replyservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.beta.replyservice.model.ErrorReplyMessage;
import com.beta.replyservice.model.ReplyMessage;

@RestController

public class ReplyController {

	@GetMapping("/reply")
	public ErrorReplyMessage replying() {
		return new ErrorReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable("message") String message) {
		return new ReplyMessage(message);
	}

}