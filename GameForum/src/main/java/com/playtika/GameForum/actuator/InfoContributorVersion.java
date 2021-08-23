package com.playtika.GameForum.actuator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;

import java.util.HashMap;
import java.util.Map;

public class InfoContributorVersion
        implements InfoContributor
{

    @Value("${version}")
    public String version;
    @Value("${description}")
    public  String description;


    @Override
    public void contribute(Info.Builder builder) {
        Map<String,Object> properties=new HashMap<>();
        properties.put("version",this.version);
        properties.put("description",this.description);

        builder.withDetails(properties);
    }
}
