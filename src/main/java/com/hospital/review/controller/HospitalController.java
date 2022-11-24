package com.hospital.review.controller;

import com.hospital.review.domain.dto.ReviewCreateRequest;
import com.hospital.review.domain.dto.ReviewCreateResponse;
import com.hospital.review.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hospitals")
@Slf4j
public class HospitalController {

    private final ReviewService reviewService;

    public HospitalController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 새로운 리뷰를 등록
    // client에서 받은 요청을 서비스로 보내고, 서비에서 return바은 것을 사용자에서 response로 돌려보낸다
    @PostMapping("/{id}/reviews")
     public ResponseEntity<ReviewCreateResponse> add(@RequestBody ReviewCreateRequest reviewCreateRequest) {
        log.info("{}", reviewCreateRequest);
        return ResponseEntity.ok().body(reviewService.createReview(reviewCreateRequest));
    }
}
