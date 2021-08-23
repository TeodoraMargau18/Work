package com.playtika.GameForum.actuator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="version")
public class VersionInfo {

    @Value("${version}")
    public String version;
    @Value("${description}")
    public  String description;

    @ReadOperation
    public VersionDTO getVersion(){
        return new VersionDTO(version,description);
//        return String.format("Version: %s \n Description: %s\n"
//        ,version,description);
    }

    static class VersionDTO{
        String version;
        String description;

        public VersionDTO(String version, String description) {
            this.version = version;
            this.description = description;
        }

        public String getVersion() {
            return version;
        }

        public String getDescription() {
            return description;
        }
    }




}
