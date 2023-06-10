package com.entitylogic.github.extractor.service;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GithubQueryParams {
    private Integer limit;
}
