/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.generators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TextPgDataTest {
    TextPgData data;
    PgDataType type;

    private static final String RANDOM_TEXT_REGEX = "'.*'";

    private static Stream<Arguments> generateValueTestData() {
        return Stream.of(
          Arguments.of(PgDataGenerator.CONSTANT, "'start'"),
          Arguments.of(PgDataGenerator.INCREMENT, null),
          Arguments.of(PgDataGenerator.ANY, null)
        );
    }

    private static Stream<Arguments> getMaxValuesTestData() {
        return Stream.of(
          Arguments.of(0, 0),
          Arguments.of(4, 456976)
        );
    }

    @BeforeEach
    void setUp() {
        type = PgDataType.TEXT;
        data = new TextPgData(type);
    }

    @ParameterizedTest
    @MethodSource("generateValueTestData")
    void testGenerateValue(PgDataGenerator generator, String expected) {
        data.setStart("start");
        data.setGenerator(generator);

        String result = data.generateValue();

        assertEquals(expected, result);
    }

    @Test
    void testGenerateValueRandom() {
        data.setGenerator(PgDataGenerator.RANDOM);
        data.setNotNull(true);

        String result = data.generateValue();

        assertTrue(result.matches(RANDOM_TEXT_REGEX));
    }

    @ParameterizedTest
    @MethodSource("getMaxValuesTestData")
    void testGetMaxValues(int length, int expected) {
        data.setLength(length);

        int result = data.getMaxValues();

        assertEquals(expected, result);
    }

    @Test
    void testValueFromString() {
        String result = data.valueFromString("text");

        assertEquals("text", result);
    }
}
