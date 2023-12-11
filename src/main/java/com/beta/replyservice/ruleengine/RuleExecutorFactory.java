package com.beta.replyservice.ruleengine;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class RuleExecutorFactory {

    private final Map<Integer, IRuleExecutor> ruleExecutors;

    RuleExecutorFactory(Collection<IRuleExecutor> ruleExecutors) {

        this.ruleExecutors = ruleExecutors.stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toMap((IRuleExecutor r) -> r.getRuleType().value(),
                                        (IRuleExecutor r) -> r.identity()),
                                Collections::unmodifiableMap));
    }

    public Optional<IRuleExecutor> getRuleExecutor(int ruleTypeValue) {
        return Optional.ofNullable(this.ruleExecutors.getOrDefault(ruleTypeValue, null));
    }

}
