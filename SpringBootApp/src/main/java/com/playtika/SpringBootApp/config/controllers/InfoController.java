package com.playtika.SpringBootApp.config.controllers;

import com.playtika.SpringBootApp.models.dtos.AppInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/info")
public class InfoController {

    @Value("${app.name}")
    public String appName;
    @Value("${app.version:1.1.1}")
    public String appVersion;

    @GetMapping
    public AppInfo getInfo() {
        return new AppInfo(appName, appVersion);//se serializeaza ob json si se trimite
    }

    @GetMapping
    @RequestMapping("/all")
    public List<AppInfo> getAll() {
        List<AppInfo> infos=new ArrayList<>();
        infos.add(new AppInfo("Hello","1"));
        infos.add(new AppInfo("World","2"));
        infos.add(new AppInfo("World","17"));
        return infos;
    }

}
