package com.entitylogic.github.extractor.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GithubRepositoryDto {

    private String id;
    private String name;
    private String fullName;
    private String description;
}
