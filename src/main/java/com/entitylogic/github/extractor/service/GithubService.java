package com.entitylogic.github.extractor.service;

import com.entitylogic.github.extractor.model.github.GithubRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GithubService {

    public List<GithubRepository> getRepositories() {
        return Collections.emptyList();
    }
}
