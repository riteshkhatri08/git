package com.beta.replyservice.ruleengine;

import org.springframework.stereotype.Component;

@Component
public class Rule1Executor implements IRuleExecutor {

    @Override
    public String applyRule(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    @Override
    public RuleType getRuleType() {

        return RuleType.RULE_1;
    }

}
