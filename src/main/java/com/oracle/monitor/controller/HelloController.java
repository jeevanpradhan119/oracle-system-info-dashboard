package com.oracle.monitor.controller;

import com.oracle.monitor.service.OracleMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private OracleMonitorService monitorService;

    @GetMapping("/")
    public String home() {
        return "🎉 Oracle Monitor is running!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "👋 Hello from Spring Boot + Oracle DB!";
    }

    @GetMapping("/sessions")
    public List<Map<String, Object>> getSessions() {
        return monitorService.fetchActiveSessions();
    }
}
