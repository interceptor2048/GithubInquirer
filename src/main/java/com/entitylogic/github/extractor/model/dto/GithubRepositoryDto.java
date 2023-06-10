package com.entitylogic.github.extractor.model.dto;

import lombok.Data;

@Data
public class GithubRepositoryDto {

    private final String id;
    private final String name;
    private final String fullName;
    private final String description;
}
