package org.dldev.aiweb.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "model")
public class ModelProperties {
    private String location;
    private String skinurl;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSkinurl() {
        return skinurl;
    }

    public void setSkinurl(String skinurl) {
        this.skinurl = skinurl;
    }
}
