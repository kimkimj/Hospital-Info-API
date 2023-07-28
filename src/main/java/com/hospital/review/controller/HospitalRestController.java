package com.hospital.review.controller;

import com.hospital.review.domain.dto.HospitalResponse;
import com.hospital.review.service.HospitalService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hospitals")
@RequiredArgsConstructor
public class HospitalRestController {

    private final HospitalService hospitalService;

    // 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) {
        HospitalResponse hospitalResponse = hospitalService.findById(id);
        return ResponseEntity.ok().body(hospitalResponse);
    }
}
