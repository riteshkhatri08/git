package com.beta.replyservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.beta.replyservice.exception.InvalidInputException;
import com.beta.replyservice.model.ReplyMessage;

@SpringBootTest
public class ReplyServiceV2Test {

	@Autowired
	ReplyServiceV2 replyServiceV2;

	@Test
	public void testReplyRule1andRule1() {
		String input = "Ritesh";

		ReplyMessage replyMessage = replyServiceV2.getReplyMessage("11-" + input);
		assertNotNull(replyMessage);
		assertNotNull(replyMessage.getData());
		assertEquals(input, replyMessage.getData());
	}

	@Test
	public void testReplyRule1andRule2() {
		String input = "Ritesh";
		String expected = "2f286c54e192eab472cf834851e4755b";

		ReplyMessage replyMessage = replyServiceV2.getReplyMessage("12-" + input);
		assertNotNull(replyMessage);
		assertNotNull(replyMessage.getData());
		assertEquals(expected, replyMessage.getData());
	}

	@Test
	public void testReplyRule2andRule1() {
		String input = "Ritesh";
		String expected = "6f3d327aee3abcf7bff35f1e4e44f99d";

		ReplyMessage replyMessage = replyServiceV2.getReplyMessage("21-" + input);
		assertNotNull(replyMessage);
		assertNotNull(replyMessage.getData());
		assertEquals(expected, replyMessage.getData());
	}

	@Test
	public void testReplyRule2andRule2() {
		String input = "Ritesh";
		String expected = "1219eca291f0cf91a83fbd16097c4b85";

		ReplyMessage replyMessage = replyServiceV2.getReplyMessage("22-" + input);
		assertNotNull(replyMessage);
		assertNotNull(replyMessage.getData());
		assertEquals(expected, replyMessage.getData());
	}

	@Test
	public void expectInvalidInputForNonExistingRule() {
		String input = "00-Ritesh";

		assertThrows(InvalidInputException.class, () -> replyServiceV2.getReplyMessage(input));

	}

}
