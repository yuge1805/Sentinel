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
package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.enums.RuleTypeEnum;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: yuge
 * @date: 2023/12/15
 **/
@Component("flowRuleNacosProvider")
@ConditionalOnBean(NacosConfiguration.class)
public class FlowRuleNacosProvider extends AbstractRuleNacosProvider<FlowRuleEntity> {

    public FlowRuleNacosProvider(ConfigService configService, Converter<String, List<FlowRuleEntity>> converter) {
        super(configService, converter);
    }

    @Override
    String getDataId(String app) {
        return app + NacosConfigUtil.FLOW_DATA_ID_POSTFIX;
    }

    @Override
    public boolean isSupport(RuleTypeEnum ruleType) {
        return RuleTypeEnum.FLOW_RULE.equals(ruleType);
    }

}
