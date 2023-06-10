package com.entitylogic.github.extractor.mapper;

import com.entitylogic.github.extractor.model.dto.GithubRepositoryDto;
import com.entitylogic.github.extractor.model.github.GithubRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GithubModelMapper {

    public List<GithubRepositoryDto> mapToRepositoryDtoList(List<GithubRepository> repositories) {
        return repositories.stream()
                .map(r -> new GithubRepositoryDto(
                        r.getId(),
                        r.getName(),
                        r.getFullName(),
                        r.getDescription()
                ))
                .toList();
    }
}
