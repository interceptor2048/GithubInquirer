package com.entitylogic.github.extractor.service;

import com.entitylogic.github.extractor.client.github.GithubClient;
import com.entitylogic.github.extractor.client.github.GithubException;
import com.entitylogic.github.extractor.model.github.GithubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GithubService {

    private final GithubClient githubClient;

    public List<GithubRepository> getRepositories() throws GithubException {
        return githubClient.getRepositories();
    }
}
