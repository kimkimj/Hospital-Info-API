package com.hospital.web;

import com.hospital.web.domain.entity.Hospital;
import com.hospital.web.parser.ReadData;
import com.hospital.web.repository.HospitalJdbcRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class InsertData {
    static Map<String, String> env = System.getenv();
    static final String DB_URL = env.get("SPRING_DATASOURCE_URL");
    static final String USERNAME = env.get("SPRING_DATASOURCE_USERNAME");
    static final String PASSWORD = env.get("SPRING_DATASOURCE_PASSWORD");

    public static void main(String[] args) throws IOException{
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        ReadData readData = new ReadData();
        List<Hospital> hospitals = readData.readLine("hostpialData.txt");

        HospitalJdbcRepository hospitalJdbcRepository = new HospitalJdbcRepository(jdbcTemplate);
        hospitalJdbcRepository.insertHospitalList(hospitals);
    }
}
