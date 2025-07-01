package com.oracle.monitor.model;

import org.springframework.data.annotation.Id;

public class SystemInfo {

    @Id
    private Integer id; // Use Integer, not int (so null is allowed)
    private String name;
    private String status;

    // Constructors
    public SystemInfo() {
    }

    public SystemInfo(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
