package com.hospital.web.controller;

import com.hospital.web.domain.entity.Hospital;
import com.hospital.web.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hospitals")
public class HospitalController {
    private final HospitalRepository hospitalRepository;

    // 전체 조회, 도로명 키워드 검색 가능
    @GetMapping("")
    public String list(@RequestParam(required = false) String keyword,
                       Model model,
                       @PageableDefault(size = 20, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Hospital> hospitals;
        if (keyword == null) {
            hospitals = hospitalRepository.findAll(pageable);
        } else {
            hospitals = hospitalRepository.findByRoadNameAddressContaining(keyword, pageable);
        }

        model.addAttribute("hospitals", hospitals);
        model.addAttribute("keyword", keyword);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());

        return "hospitals/list";
    }

    // 단건 조회
    @GetMapping("/{id}")
    public String getHospital(@PathVariable Integer id, Model model) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        if (optionalHospital.isEmpty()) {
            return "hospitals/error";
        } else {
            model.addAttribute("hospital", optionalHospital.get());
            return "hospitals/detail";
        }
    }
}
