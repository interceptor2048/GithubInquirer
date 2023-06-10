package com.entitylogic.github.extractor.service;

import com.entitylogic.github.extractor.client.github.GithubClient;
import com.entitylogic.github.extractor.client.github.GithubException;
import com.entitylogic.github.extractor.model.github.GithubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class GithubService {

    private final GithubClient githubClient;

    public List<GithubRepository> getRepositories(GithubQueryParams params) throws GithubException {
        Stream<GithubRepository> githubRepositoryStream = githubClient.getRepositories().stream();
        if (params.getLimit() != null)
            githubRepositoryStream = githubRepositoryStream.limit(params.getLimit());
        if (params.getLanguage() != null)
            githubRepositoryStream = githubRepositoryStream.filter(gr -> params.getLanguage().equalsIgnoreCase(gr.getLanguage()));
        return githubRepositoryStream.toList();
    }
}
