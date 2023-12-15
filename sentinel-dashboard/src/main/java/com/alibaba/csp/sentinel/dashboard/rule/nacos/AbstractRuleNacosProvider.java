package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.nacos.api.config.ConfigService;

import java.util.Collections;
import java.util.List;

/**
 * @author: yuge
 * @date: 2023/12/15
 **/
public abstract class AbstractRuleNacosProvider<T> implements DynamicRuleProvider<T> {

    protected final ConfigService configService;

    private final Converter<String, List<T>> converter;

    public AbstractRuleNacosProvider(ConfigService configService, Converter<String, List<T>> converter) {
        this.configService = configService;
        this.converter = converter;
    }

    @Override
    public List<T> getRules(String appName) throws Exception {
        String rules = configService.getConfig(getDataId(appName),
                getGroupId(appName), 3000);
        if (StringUtil.isEmpty(rules)) {
            return Collections.emptyList();
        }
        return converter.convert(rules);
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
