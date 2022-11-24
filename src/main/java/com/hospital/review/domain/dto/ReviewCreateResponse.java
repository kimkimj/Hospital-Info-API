package com.hospital.review.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReviewCreateResponse {
    private String username;
    private String title;
    private String content;
    private String message;
}
