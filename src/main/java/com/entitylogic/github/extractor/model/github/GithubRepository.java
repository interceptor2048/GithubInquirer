package com.entitylogic.github.extractor.model.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepository {

    private String id;
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    private String description;
    private String language;
}
