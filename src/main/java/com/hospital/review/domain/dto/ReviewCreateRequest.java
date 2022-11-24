package com.hospital.review.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReviewCreateRequest {
    private Long hospitalId;
    private String username;
    private String title;
    private String content;
}
