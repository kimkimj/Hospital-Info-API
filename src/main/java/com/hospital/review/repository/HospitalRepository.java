package com.hospital.review.repository;

import com.hospital.review.domain.entity.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

    // 키워드 검색, 페이징 x
    List<Hospital> findByRoadNameAddressContaining(String keyword);
    List<Hospital> findByHospitalNameStartingWith(String keyword);
    List<Hospital> findByHospitalNameEndsWith(String keyword);
    List<Hospital> findByPatientRoomCountBetween(int keyword1, int keyword2);
    List<Hospital> findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(int a, int b);

    // 키워드 검색, 페이징
    Page<Hospital> findByRoadNameAddressContaining(String keyword, Pageable pageable);
}
