package com.beta.replyservice.ruleengine;

public enum RuleType {
    RULE_1(1), RULE_2(2);

    private final int value;

    private RuleType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
