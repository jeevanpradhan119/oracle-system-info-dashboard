package com.oracle.monitor.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OracleMonitorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getActiveSessions() {
        String sql = "SELECT SID, SERIAL#, USERNAME, STATUS, PROGRAM FROM V$SESSION WHERE USERNAME IS NOT NULL";
        return jdbcTemplate.queryForList(sql);
    }
}
