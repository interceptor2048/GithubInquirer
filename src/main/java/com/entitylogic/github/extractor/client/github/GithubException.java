package com.entitylogic.github.extractor.client.github;

public class GithubException extends RuntimeException {

    public GithubException(String exceptionBody) {
        super(exceptionBody);
    }
}
