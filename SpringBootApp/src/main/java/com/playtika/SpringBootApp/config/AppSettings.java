package com.playtika.SpringBootApp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AppSettings {

    @Value("${app.name}")
    public String appName;

    @Value("${app.version}")
    public String appVersion;

    @PostConstruct
    public void init(){
        System.out.printf("appName= %s , version = ",appName,appVersion);
    }
}
