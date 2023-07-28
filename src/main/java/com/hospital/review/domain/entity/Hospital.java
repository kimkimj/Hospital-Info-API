package com.hospital.review.domain.entity;

import com.hospital.review.domain.dto.HospitalResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "road_name_address")
    private String roadNameAddress;
    @Column(name = "hospital_name")
    private String hospitalName;
    private String phoneNumber;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Integer businessStatusCode;
    @Column(name = "medical_department")
    private String medicalDepartment;

    public Hospital(String roadNameAddress, String hospitalName, String phoneNumber, Integer patientRoomCount,
                    Integer totalNumberOfBeds, String businessTypeName, Integer businessStatusCode,
                    String medicalDepartment) {
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.phoneNumber = phoneNumber;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;
        this.businessTypeName = businessTypeName;
        this.businessStatusCode = businessStatusCode;
        this.medicalDepartment = medicalDepartment;
    }

    // HospitalEntity를 HospitalResponse(Dto)로 변환
    public static HospitalResponse of(Hospital hospital) {
        return new HospitalResponse(hospital.getId(),
                hospital.getHospitalName(),
                hospital.getPhoneNumber(),
                hospital.getRoadNameAddress(),
                hospital.getPatientRoomCount(),
                hospital.getTotalNumberOfBeds(),
                hospital.getBusinessTypeName(),
                hospital.getMedicalDepartment());
    }
}
