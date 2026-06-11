package com.dibya.springboottest.DTO;

public class LandingDTO {
    private String appName ;
    private String appVersion;
    private String developerName;

    public String getActiveProfile() {
        return activeProfile;
    }

    public void setActiveProfile(String activeProfile) {
        this.activeProfile = activeProfile;
    }

    private String activeProfile;

    public LandingDTO(String appName, String appVersion, String developerName, String activeProfile) {
        this.appName = appName;
        this.appVersion = appVersion;
        this.developerName = developerName;
        this.activeProfile = activeProfile;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public LandingDTO() {
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
