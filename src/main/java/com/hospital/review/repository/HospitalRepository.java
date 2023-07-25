package com.hospital.review.repository;

import com.hospital.review.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    List<Hospital> findByBusinessTypeNameIn(List<String> types);
    List<Hospital> findByHospitalNameContaining(String hospitalName);

    List<Hospital> findByHospitalName(String hospitalName);
}
