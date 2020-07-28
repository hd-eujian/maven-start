package com.bootstart.maven;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("eujian.redis")
public class EujianProperties {


    private String host = "127.0.0.1";


    private Integer port = 6379;


    private Integer timeout = 2000;

    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
