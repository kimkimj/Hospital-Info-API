package com.hospital.review.controller;

import com.hospital.review.domain.Hospital;
import com.hospital.review.domain.dto.HospitalReadResponse;
import com.hospital.review.domain.dto.ReviewCreateRequest;
import com.hospital.review.domain.dto.ReviewCreateResponse;
import com.hospital.review.domain.dto.ReviewReadResponse;
import com.hospital.review.service.HospitalService;
import com.hospital.review.service.ReviewService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
@RequiredArgsConstructor
public class HospitalController {

    private final ReviewService reviewService;
    private final HospitalService hospitalService;

    // 병원 id를 조회하면 병원 정보와 리뷰 조회
    @GetMapping("/{id}")
    public ResponseEntity<HospitalReadResponse> getHospital(@PathVariable Long id) {
        Hospital hospitalResponse = hospitalService.findById(id);
        HospitalReadResponse hospitalReadResponse = HospitalReadResponse.fromEntity(hospitalResponse);
        return ResponseEntity.ok().body(hospitalReadResponse);
    }

    //병원 ID로 해당 병원의 모든 리뷰 조회
    @GetMapping("/{hospitalId}/reviews")
    public ResponseEntity<List<ReviewReadResponse>> reviews(@PathVariable Long hospitalId){
        return ResponseEntity.ok().body(reviewService.findAllByHospitalId(hospitalId));
    }
}
