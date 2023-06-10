package com.entitylogic.github.extractor.infrastructure;

import com.entitylogic.github.extractor.client.github.GithubException;
import com.entitylogic.github.extractor.mapper.GithubModelMapper;
import com.entitylogic.github.extractor.model.dto.GithubRepositoryDto;
import com.entitylogic.github.extractor.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/repositories")
@RequiredArgsConstructor
class RepositoryInquiryController {

    private final GithubService githubService;
    private final GithubModelMapper githubModelMapper;

    @GetMapping
    ResponseEntity<List<GithubRepositoryDto>> inquiryTopRepositories() throws GithubException {
        return new ResponseEntity<>(
                githubModelMapper.mapToRepositoryDtoList(githubService.getRepositories()),
                HttpStatus.OK);
    }
}
