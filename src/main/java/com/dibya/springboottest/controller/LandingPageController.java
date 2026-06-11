package com.dibya.springboottest.controller;

import com.dibya.springboottest.DTO.LandingDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/home")
public class LandingPageController {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.application.version}")
    private String appVersion;
    private final Environment environment;

    public LandingPageController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping
    public ResponseEntity<?> index(){
        LandingDTO landingDTO = new LandingDTO();
        landingDTO.setAppName(this.appName);
        landingDTO.setAppVersion(this.appVersion);
        landingDTO.setDeveloperName("DibyaKrushna Das");
        landingDTO.setActiveProfile(String.join( ", ", this.environment.getActiveProfiles()));

        return ResponseEntity.status(HttpStatus.OK).body(landingDTO);
    }
}
