package com.example.conference.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {


    @Value("${app.version}")
    private String appVersion;

    @Value("${app.developer}")
    private String appDeveloper;

    @GetMapping("/")
    public Map<String,String> getStatus(){
        Map<String,String> mp = new HashMap<>();
        mp.put("app-version",appVersion);
        mp.put("developer",appDeveloper);
        return mp;
    }

}
