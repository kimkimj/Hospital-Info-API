package com.hospital.web.repository;

import com.hospital.web.domain.entity.Hospital;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class HospitalJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public void insertHospitalList(List<Hospital> hospitalList) {
        jdbcTemplate.batchUpdate("INSERT INTO hospital (road_name_address, hospital_name, phone_number," +
                "patient_room_count, total_number_of_beds, business_type_name, business_status_code, medical_department)" +
                "values (?,?,?,?,?,?,?,?)", new BatchPreparedStatementSetter() {

            @Override
            public int getBatchSize() {
                return hospitalList.size();
            }

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Hospital hospital = hospitalList.get(i);
                int parameterIndex = 1;
                ps.setString(parameterIndex++, hospital.getRoadNameAddress());
                ps.setString(parameterIndex, hospital.getHospitalName());
                ps.setString(parameterIndex, hospital.getPhoneNumber());
                ps.setInt(parameterIndex++, hospital.getPatientRoomCount());
                ps.setInt(parameterIndex++, hospital.getTotalNumberOfBeds());
                ps.setString(parameterIndex, hospital.getBusinessTypeName());
                ps.setInt(parameterIndex++, hospital.getBusinessStatusCode());
                ps.setString(parameterIndex, hospital.getMedicalDepartment());
            }
        });
    }
}
