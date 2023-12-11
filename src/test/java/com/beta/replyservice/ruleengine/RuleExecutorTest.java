package com.beta.replyservice.ruleengine;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RuleExecutorTest {

	@Autowired
	Rule1Executor rule1;

	@Autowired
	Rule2Executor rule2;

	@Test
	public void testRule1() {
		String input = "Ritesh";
		String expected = "hsetiR";

		String actualResult = rule1.applyRule(input);
		assertNotNull(actualResult);
		assertEquals(expected, actualResult);

	}

	@Test
	public void testRule2() {
		String input = "Ritesh";
		String expected = "d99f44e4e1f53ffb7fcba3eea723d3f6";

		String actualResult = rule2.applyRule(input);
		assertNotNull(actualResult);
		assertEquals(expected, actualResult);

	}

}
