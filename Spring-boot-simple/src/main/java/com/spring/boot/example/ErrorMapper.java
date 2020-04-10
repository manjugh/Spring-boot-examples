package com.spring.boot.example;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties
@PropertySource("classpath:error-mapping.yaml")
public class ErrorMapper {

    public String server;

    public  String port;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    /*public String appName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Map<String, String> testKey;

    public Credential credential = new Credential();

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public Map<String,String> map = new HashMap<>();

    public static class Credential {
        String userName;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        String password;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

    public Map<String, String> getTestKey() {
        return testKey;
    }

    public void setTestKey(Map<String, String> testKey) {
        this.testKey = testKey;
    }

    public String getValue(String key) {
        return testKey.get(key);
    }*/
}
