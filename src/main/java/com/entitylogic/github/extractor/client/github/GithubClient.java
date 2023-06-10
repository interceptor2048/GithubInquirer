package com.entitylogic.github.extractor.client.github;

import com.entitylogic.github.extractor.config.GlobalConfiguration;
import com.entitylogic.github.extractor.model.github.GithubRepositoriesResponse;
import com.entitylogic.github.extractor.model.github.GithubRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
@Slf4j
public class GithubClient {

    private final RestTemplate restTemplate;
    private final GlobalConfiguration globalConfiguration;

    public List<GithubRepository> getRepositories() throws GithubException {
        try {
            GithubRepositoriesResponse inquiredRepos = restTemplate.getForObject(url(), GithubRepositoriesResponse.class);
            if (inquiredRepos != null) {
                return inquiredRepos.getItems();
            }
            return emptyList();
        } catch (RestClientException e) {
            log.error("Github REST client exception: {}", e.toString());
            throw new GithubException(e.toString());
        }
    }

    private URI url() {
        return URI.create(globalConfiguration.getGithubApiUrl());
    }
}
