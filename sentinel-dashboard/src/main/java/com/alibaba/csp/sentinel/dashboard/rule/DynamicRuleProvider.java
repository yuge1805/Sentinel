/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.rule;

import com.alibaba.csp.sentinel.dashboard.enums.RuleTypeEnum;

import java.util.List;

/**
 * @author Eric Zhao
 * @since 1.4.0
 */
public interface DynamicRuleProvider<T> {

    /**
     * get application rules
     *
     * @param appName
     * @return
     * @throws Exception
     */
    List<T> getRules(String appName) throws Exception;

    /**
     * Whether this type of rule can be processed
     *
     * @param ruleType
     * @return
     */
    default boolean isSupport(RuleTypeEnum ruleType) {
        throw new IllegalStateException("Not implemented");
    }

}
