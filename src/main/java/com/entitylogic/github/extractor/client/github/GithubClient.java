package com.entitylogic.github.extractor.client.github;

import com.entitylogic.github.extractor.config.GlobalConfiguration;
import com.entitylogic.github.extractor.model.github.GithubRepositoriesResponse;
import com.entitylogic.github.extractor.model.github.GithubRepository;
import com.entitylogic.github.extractor.service.GithubQueryParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
@Slf4j
public class GithubClient {

    private final RestTemplate restTemplate;
    private final GlobalConfiguration globalConfiguration;

    public List<GithubRepository> getRepositories(GithubQueryParams params) {
        try {
            log.debug("Sending github request: {}", url(params));
            GithubRepositoriesResponse inquiredRepos = restTemplate.getForObject(url(params), GithubRepositoriesResponse.class);
            if (inquiredRepos != null) {
                return inquiredRepos.getItems();
            }
            return emptyList();
        } catch (RestClientException e) {
            log.error("Github REST client exception: {}", e.toString());
            throw new GithubException(e.toString());
        }
    }

    private URI url(GithubQueryParams params) {
        String suffix = "";
        if (params.getCreatedAfter() != null) {
            suffix = "&created:>" + params.getCreatedAfter().format(DateTimeFormatter.ISO_DATE);
        }
        return UriComponentsBuilder.fromUriString(globalConfiguration.getGithubApiUrl())
                .queryParam("q", "sort=stars&order=desc" + suffix)
                .build().toUri();
    }
}
