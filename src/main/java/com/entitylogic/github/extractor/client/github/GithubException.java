package com.entitylogic.github.extractor.client.github;

public class GithubException extends Exception {

    public GithubException(String exceptionBody) {
        super(exceptionBody);
    }
}
