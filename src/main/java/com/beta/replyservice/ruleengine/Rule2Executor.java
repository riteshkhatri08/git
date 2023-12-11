package com.beta.replyservice.ruleengine;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Component
public class Rule2Executor implements IRuleExecutor {

    @Override
    public String applyRule(String input) {

        return DigestUtils.md5DigestAsHex(input.getBytes());
    }

    @Override
    public RuleType getRuleType() {
        return RuleType.RULE_2;
    }

}
