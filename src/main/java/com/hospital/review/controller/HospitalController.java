package com.hospital.review.controller;

import com.hospital.review.domain.Hospital;
import com.hospital.review.domain.dto.HospitalReadResponse;
import com.hospital.review.domain.dto.ReviewCreateRequest;
import com.hospital.review.domain.dto.ReviewCreateResponse;
import com.hospital.review.service.HospitalService;
import com.hospital.review.service.ReviewService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/hospitals")
@RequiredArgsConstructor //@NoArgsConstructor은 지워야한다
@Slf4j
public class HospitalController {

    private final ReviewService reviewService;
    private final HospitalService hospitalService;


    // 새로운 리뷰를 등록
    // client에서 받은 요청을 서비스로 보내고, 서비에서 return바은 것을 사용자에서 response로 돌려보낸다
    @PostMapping("/{id}/reviews")
     public ResponseEntity<ReviewCreateResponse> add(@RequestBody ReviewCreateRequest reviewCreateRequest) {
        log.info("{}", reviewCreateRequest);
        return ResponseEntity.ok().body(reviewService.createReview(reviewCreateRequest));
    }

    // 병원 id를 조회하면 리뷰까지 같이 나오는 기능
    // api/v1/hospitals/{id}
    @GetMapping("/{id}")
    public ResponseEntity<HospitalReadResponse> getHospital(@PathVariable Long id) {
        Hospital hospitalResponse = hospitalService.findById(id);
        HospitalReadResponse hospitalReadResponse = HospitalReadResponse.fromEntity(hospitalResponse);
        return ResponseEntity.ok().body(hospitalReadResponse);
    }
}
