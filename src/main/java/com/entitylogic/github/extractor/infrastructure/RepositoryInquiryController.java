package com.entitylogic.github.extractor.infrastructure;

import com.entitylogic.github.extractor.mapper.GithubModelMapper;
import com.entitylogic.github.extractor.model.dto.GithubRepositoryDto;
import com.entitylogic.github.extractor.service.GithubQueryParams;
import com.entitylogic.github.extractor.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/repositories")
@RequiredArgsConstructor
class RepositoryInquiryController {

    private final GithubService githubService;
    private final GithubModelMapper githubModelMapper;
    private final ParamsValidator paramsValidator;

    @GetMapping
    ResponseEntity<List<GithubRepositoryDto>> inquiryTopRepositories(
            @RequestParam(required = false, name = "limit") Integer limit,
            @RequestParam(required = false, name = "language") String language,
            @RequestParam(required = false, name = "createdAfter") String createdAfter
    ) {
        GithubQueryParams githubQueryParams = prepareGithubQueryParams(limit, language, createdAfter);
        return new ResponseEntity<>(
                githubModelMapper.mapToRepositoryDtoList(
                        githubService.getRepositories(githubQueryParams)
                ),
                HttpStatus.OK);
    }

    private GithubQueryParams prepareGithubQueryParams(Integer limit, String language, String createdAfter) {
        GithubQueryParams.GithubQueryParamsBuilder githubQueryParamsBuilder = GithubQueryParams.builder();
        Optional.ofNullable(limit).ifPresent(githubQueryParamsBuilder::limit);
        Optional.ofNullable(language).ifPresent(githubQueryParamsBuilder::language);
        Optional.ofNullable(createdAfter).ifPresent(paramsValidator::validateCreatedAfter);
        DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
        Optional.ofNullable(createdAfter).ifPresent(
                s -> githubQueryParamsBuilder.createdAfter(LocalDate.parse(s, dateFormatter))
        );
        GithubQueryParams githubQueryParams = githubQueryParamsBuilder.build();
        return githubQueryParams;
    }
}
