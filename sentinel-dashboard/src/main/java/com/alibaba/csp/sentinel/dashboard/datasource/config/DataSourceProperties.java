package com.alibaba.csp.sentinel.dashboard.datasource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: yuge
 * @date: 2023/12/12
 **/
@Component
@ConfigurationProperties(prefix = "datasource")
public class DataSourceProperties {

    public static final String NACOS_PROVIDER = "nacos";

    /**
     * provider
     */
    private String provider = "nacos";

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

}
