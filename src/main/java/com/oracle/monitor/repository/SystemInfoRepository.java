package com.oracle.monitor.repository;

import com.oracle.monitor.model.SystemInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SystemInfoRepository {

    private final JdbcTemplate jdbcTemplate;

    public SystemInfoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SystemInfo> findAll() {
        String sql = "SELECT * FROM system_info";

        RowMapper<SystemInfo> rowMapper = (rs, rowNum) -> new SystemInfo(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("status"));

        return jdbcTemplate.query(sql, rowMapper);
    }

    public SystemInfo save(SystemInfo systemInfo) {
        String sql = "INSERT INTO system_info (id, name, status) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, systemInfo.getId(), systemInfo.getName(), systemInfo.getStatus());
        return systemInfo;
    }

    public void insert(String name, String status) {
        String sql = "INSERT INTO system_info (name, status) VALUES (?, ?)";
        jdbcTemplate.update(sql, name, status);
    }

    public List<SystemInfo> findByStatus(String status) {
        String sql = "SELECT * FROM system_info WHERE status = ?";
        RowMapper<SystemInfo> rowMapper = (rs, rowNum) -> new SystemInfo(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("status")
        );
        return jdbcTemplate.query(sql, rowMapper, status);
    }
}
