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

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

final class CustomPgDataTest {
    CustomData data;

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(DataGenerator.CONSTANT, null),
                Arguments.of(DataGenerator.INCREMENT, null),
                Arguments.of(DataGenerator.RANDOM, null),
                Arguments.of(DataGenerator.ANY, "'data'")
                );
    }

    @BeforeEach
    void setUp() {
        data = new CustomData();
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testGenerateValueConstant(DataGenerator generator, String expected) {
        data.setStart("'data'");
        data.setGenerator(generator);

        String result = data.generateValue();

        assertEquals(expected, result);
    }

    @Test
    void testMaxValue() {
        int result = data.getMaxValues();

        assertEquals(1, result);
    }
}
