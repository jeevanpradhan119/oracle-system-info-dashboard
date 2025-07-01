package com.oracle.monitor.controller;

import com.oracle.monitor.model.SystemInfo;
import com.oracle.monitor.repository.SystemInfoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SystemInfoController {

    private final SystemInfoRepository repository;

    public SystemInfoController(SystemInfoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/system-info")
    @ResponseBody
    public List<SystemInfo> getSystemInfo() {
        return repository.findAll(); // JSON endpoint
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<SystemInfo> systemInfoList = repository.findAll();
        model.addAttribute("systemInfoList", systemInfoList);
        return "dashboard"; // this matches dashboard.html
    }

    @GetMapping("/dashboard/filter")
    public String filterByStatus(@RequestParam("status") String status, Model model) {
        List<SystemInfo> systemInfoList = repository.findByStatus(status);
        model.addAttribute("systemInfoList", systemInfoList);
        return "dashboard";
    }

    @PostMapping("/add-system-info")
    public String addSystemInfo(@RequestParam String name, @RequestParam String status) {
        SystemInfo newInfo = new SystemInfo();
        newInfo.setName(name);
        newInfo.setStatus(status);
        repository.save(newInfo);
        return "redirect:/dashboard";
    }

    @PostMapping("/api/system-info")
    @ResponseBody
    public SystemInfo createSystemInfo(@RequestBody SystemInfo systemInfo) {
        return repository.save(systemInfo); // JSON POST endpoint
    }
}
