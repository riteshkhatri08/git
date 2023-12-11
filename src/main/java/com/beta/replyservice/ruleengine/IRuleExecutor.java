package com.beta.replyservice.ruleengine;

public interface IRuleExecutor {

    public RuleType getRuleType();

    public default IRuleExecutor identity() {
        return this;
    }

    public String applyRule(String input);
}
