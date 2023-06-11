package com.entitylogic.github.extractor.infrastructure;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
class ParamsValidator {

    private final static Pattern DATE_PATTERN = Pattern.compile("\\d{4}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])");

    public void validateCreatedAfter(String date) throws IncorrectDateException {
        Matcher matcher = DATE_PATTERN.matcher(date);
        if (!matcher.matches())
            throw new IncorrectDateException("Date must be entered in format YYYYMMDD");
    }
}
