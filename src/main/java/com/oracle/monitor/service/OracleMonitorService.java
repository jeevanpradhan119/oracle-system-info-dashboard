package com.oracle.monitor.service;

import com.oracle.monitor.repository.OracleMonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OracleMonitorService {

    @Autowired
    private OracleMonitorRepository repository;

    public List<Map<String, Object>> fetchActiveSessions() {
        return repository.getActiveSessions();
    }
}
