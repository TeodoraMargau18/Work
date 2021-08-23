package com.playtika.SpringBootApp.models.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AppInfo {
    @JsonProperty("app-name")
    private String appName;
    private String appVersion;

    public AppInfo(String appName, String appVersion) {
        this.appName = appName;
        this.appVersion = appVersion;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}
