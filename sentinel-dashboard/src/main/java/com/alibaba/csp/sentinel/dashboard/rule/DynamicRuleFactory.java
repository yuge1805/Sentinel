package com.alibaba.csp.sentinel.dashboard.rule;

import com.alibaba.csp.sentinel.dashboard.enums.RuleTypeEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: yuge
 * @date: 2023/12/15
 **/
@Component
public class DynamicRuleFactory implements ApplicationContextAware {

    private static ApplicationContext APPLICATION_CONTEXT;

    public static DynamicRuleProvider getRuleProvider(RuleTypeEnum ruleType) {
        return getBeansOfType(DynamicRuleProvider.class).values()
                .stream()
                .filter(dynamicRuleProvider -> {
                    try {
                        return dynamicRuleProvider.isSupport(ruleType);
                    } catch (Exception e) {
                        return false;
                    }
                })
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No rule provider found for rule type: " + ruleType));
    }

    public static DynamicRulePublisher getRulePublisher(RuleTypeEnum ruleType) {
        return getBeansOfType(DynamicRulePublisher.class).values()
                .stream()
                .filter(dynamicRulePublisher -> {
                    try {
                        return dynamicRulePublisher.isSupport(ruleType);
                    } catch (Exception e) {
                        return false;
                    }
                })
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No rule publisher found for rule type: " + ruleType));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APPLICATION_CONTEXT = applicationContext;
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return APPLICATION_CONTEXT.getBeansOfType(clazz);
    }

}
