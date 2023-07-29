package com.hospital.web.service;

import com.hospital.web.domain.dto.HospitalResponse;
import com.hospital.web.domain.entity.Hospital;
import com.hospital.web.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalResponse findById(Integer id) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id가 없습니다"));
        HospitalResponse hospitalResponse = Hospital.of(hospital);

        if (hospital.getBusinessStatusCode() == 13) {
            hospitalResponse.setBusinessStatusName("영업중");
        } else if (hospital.getBusinessStatusCode() == 3) {
            hospitalResponse.setBusinessStatusName("폐업");
        } else {
            hospitalResponse.setBusinessStatusName(String.valueOf(hospital.getBusinessStatusCode()));
        }

        return hospitalResponse;
    }

}
