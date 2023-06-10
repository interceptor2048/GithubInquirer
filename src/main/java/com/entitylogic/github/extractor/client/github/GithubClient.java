package com.entitylogic.github.extractor.client.github;

import com.entitylogic.github.extractor.model.github.GithubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
public class GithubClient {

    private final RestTemplate restTemplate;

    public List<GithubRepository> getRepositories() {
        return emptyList();
    }
}
