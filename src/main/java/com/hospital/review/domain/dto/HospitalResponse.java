package com.hospital.review.domain.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter
public class HospitalResponse {
    private Integer id;
    private String roadNameAddress;
    private String hospitalName;
    private String phoneNumber;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private String businessStatusName;
    private String medicalDepartment;

    public HospitalResponse(Integer id, String roadNameAddress, String hospitalName,
                            String phoneNumber, Integer patientRoomCount, Integer totalNumberOfBeds,
                            String businessTypeName, String medicalDepartment) {
        this.id = id;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;
        this.businessTypeName = businessTypeName;
        this.phoneNumber = phoneNumber;
        this.medicalDepartment = medicalDepartment;
    }

    public void setBusinessStatusName(String businessStatusName) {
        this.businessStatusName = businessStatusName;
    }

}