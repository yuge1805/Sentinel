package com.alibaba.csp.sentinel.dashboard.datasource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: yuge
 * @date: 2023/12/12
 **/
@ConfigurationProperties(prefix = "datasource.nacos")
public class NacosDataSourceProperties {

    private String serverAddr;

    private String namespace;

    private String groupId;

    private String username;

    private String password;

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
