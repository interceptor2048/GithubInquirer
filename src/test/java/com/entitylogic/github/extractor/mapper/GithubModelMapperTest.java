package com.entitylogic.github.extractor.mapper;

import com.entitylogic.github.extractor.model.dto.GithubRepositoryDto;
import com.entitylogic.github.extractor.model.github.GithubRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GithubModelMapperTest {

    @Test
    void shouldMapToRepositoryDtoList() {
        // given
        GithubModelMapper underTest = new GithubModelMapper();
        List<GithubRepository> repositoryList = List.of(
                GithubRepository.of("1", "name1", "Project name1", "tbd1", "java"),
                GithubRepository.of("2", "name2", "Project name2", "tbd2", "python")
        );
        List<GithubRepositoryDto> expected = List.of(
                new GithubRepositoryDto("1", "name1", "Project name1", "tbd1"),
                new GithubRepositoryDto("2", "name2", "Project name2", "tbd2")
        );
        // when
        List<GithubRepositoryDto> result = underTest.mapToRepositoryDtoList(repositoryList);
        // then
        assertEquals(expected, result);
    }
}