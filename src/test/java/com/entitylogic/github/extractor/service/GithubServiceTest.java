package com.entitylogic.github.extractor.service;

import com.entitylogic.github.extractor.client.github.GithubClient;
import com.entitylogic.github.extractor.client.github.GithubException;
import com.entitylogic.github.extractor.model.github.GithubRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GithubServiceTest {

    @InjectMocks
    private GithubService underTest;

    @Mock
    private GithubClient githubClient;

    @Test
    void shouldFetchListOfRepositories() throws GithubException {
        // given
        List<GithubRepository> reposList = List.of(
                GithubRepository.of("1", "name1", "Project name1", "tbd1", "java"),
                GithubRepository.of("2", "name2", "Project name2", "tbd2", "python")
        );
        Mockito.when(githubClient.getRepositories()).thenReturn(reposList);
        // when
        List<GithubRepository> result = underTest.getRepositories();
        // then
        assertEquals(reposList, result);
    }
}