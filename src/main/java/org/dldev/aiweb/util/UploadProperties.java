package org.dldev.aiweb.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "upload")
public class UploadProperties {
    private String location;
    private String kalocation;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKalocation() {
        return kalocation;
    }

    public void setKalocation(String kalocation) {
        this.kalocation = kalocation;
    }
}
