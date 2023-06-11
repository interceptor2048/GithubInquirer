package com.entitylogic.github.extractor.service;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class GithubQueryParams {
    private Integer limit;
    private String language;
    private LocalDate createdAfter;
}
