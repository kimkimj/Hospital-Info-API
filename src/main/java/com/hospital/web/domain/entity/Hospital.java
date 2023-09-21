package com.hospital.web.domain.entity;

import com.hospital.web.domain.dto.HospitalResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "patient_room_count")
    private Integer patientRoomCount;

    @Column(name = "total_number_of_beds")
    private Integer totalNumberOfBeds;

    @Column(name = "business_type_name")
    private String businessTypeName;

    @Column(name = "business_status_code")
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
