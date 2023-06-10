package com.entitylogic.github.extractor.infrastructure;

import com.entitylogic.github.extractor.model.dto.GithubRepositoryDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/repositories")
class RepositoryInquiryController {

    @GetMapping
    List<GithubRepositoryDto> inquiryTopRepositories() {
        return Collections.emptyList();
    }
}
