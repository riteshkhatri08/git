package com.beta.replyservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beta.replyservice.exception.InvalidInputException;
import com.beta.replyservice.model.ReplyMessage;
import com.beta.replyservice.ruleengine.RuleExecutorFactory;

@Service
public class ReplyServiceV2 {

	@Autowired
	RuleExecutorFactory ruleExecutorFactory;

	public ReplyMessage getReplyMessage(String message) {

		// get Rule1, Rule2 and original Message from input
		int rule1 = message.charAt(0) - '0';
		int rule2 = message.charAt(1) - '0';

		// Original message will always be at 3rd index position
		message = message.substring(3);

		// Micro Optimization to avoid rule execution if both rules are of type 1 that
		// reverse the string;
		if (rule1 == 1 && rule2 == 1) {
			return new ReplyMessage(message);
		}

		message = ruleExecutorFactory.getRuleExecutor(rule1).orElseThrow(InvalidInputException::new).applyRule(message);
		message = ruleExecutorFactory.getRuleExecutor(rule2).orElseThrow(InvalidInputException::new).applyRule(message);

		return new ReplyMessage(message);
	}

}
