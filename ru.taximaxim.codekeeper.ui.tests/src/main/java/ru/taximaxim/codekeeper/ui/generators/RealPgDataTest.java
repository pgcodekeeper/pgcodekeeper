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

class RealPgDataTest {
    private RealPgData data;

    private static Stream<Arguments> generateValueTestData() {
        return Stream.of(
          Arguments.of(PgDataGenerator.CONSTANT, 0.0),
          Arguments.of(PgDataGenerator.ANY, null)
        );
    }

    @BeforeEach
    void setUp() {
        data = new RealPgData(PgDataType.DOUBLE);
    }

    @ParameterizedTest
    @MethodSource("generateValueTestData")
    void testGenerateValue(PgDataGenerator generator, Double expected) {
        data.setStart(0.0);
        data.setGenerator(generator);
        data.setNotNull(true);

        Double result = data.generateValue();

        assertEquals(expected, result);
    }

    @Test
    void testGenerateValueIncrement() {
        data.setStart(0.0);
        data.setStep(1.0);
        data.setGenerator(PgDataGenerator.INCREMENT);

        Double firstResult = data.generateValue();
        Double secondResult = data.generateValue();

        assertEquals(0.0, firstResult);
        assertEquals(1.0, secondResult);
    }

    @Test
    void testGenerateValueRandom() {
        Double start = 6.1;
        Double end = 6.2;
        data.setStart(start);
        data.setEnd(end);
        data.setGenerator(PgDataGenerator.RANDOM);
        data.setNotNull(true);

        Double result = data.generateValue();

        assertTrue(result >= start);
        assertTrue(result < end);
    }

    @Test
    void testGetMaxValue() {
        int result = data.getMaxValues();

        assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    void testValueFromString() {
        Double result = data.valueFromString("6.234");

        assertEquals(6.234, result);
    }
}
