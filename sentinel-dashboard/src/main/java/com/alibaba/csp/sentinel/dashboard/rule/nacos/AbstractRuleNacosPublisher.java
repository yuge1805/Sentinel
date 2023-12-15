package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.nacos.api.config.ConfigService;

import java.util.List;

/**
 * @author: yuge
 * @date: 2023/12/15
 **/
public abstract class AbstractRuleNacosPublisher<T> implements DynamicRulePublisher<T> {

    protected final ConfigService configService;

    protected final Converter<List<T>, String> converter;

    public AbstractRuleNacosPublisher(ConfigService configService, Converter<List<T>, String> converter) {
        this.configService = configService;
        this.converter = converter;
    }

    @Override
    public void publish(String app, List<T> rules) throws Exception {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }
        configService.publishConfig(getDataId(app),
                getGroupId(app), converter.convert(rules));
    }

    /**
     * get app dataId
     *
     * @param app
     * @return
     */
    abstract String getDataId(String app);

    protected String getGroupId(String app) {
        return NacosConfigUtil.GROUP_ID;
    }

}
