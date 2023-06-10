package com.entitylogic.github.extractor.model.github;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class GithubRepository {

    private String id;
    private String name;
    private String fullName;
    private String description;
    private String language;
}
