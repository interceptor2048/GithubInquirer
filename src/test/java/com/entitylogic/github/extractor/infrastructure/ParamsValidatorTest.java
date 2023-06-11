package com.entitylogic.github.extractor.infrastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ParamsValidatorTest {

    @Test
    void shouldThrowExceptionWhenDateInWrongFormat() {
        // given
        ParamsValidator underTest = new ParamsValidator();
        // when & then
        assertThrows(IncorrectDateException.class, () -> {
            underTest.validateCreatedAfter("1234-56-78");
        });
    }

    @Test
    void shouldNotThrowExceptionWhenDateCorrect() {
        // given
        ParamsValidator underTest = new ParamsValidator();
        // when & then
        underTest.validateCreatedAfter("20220101");
    }
}