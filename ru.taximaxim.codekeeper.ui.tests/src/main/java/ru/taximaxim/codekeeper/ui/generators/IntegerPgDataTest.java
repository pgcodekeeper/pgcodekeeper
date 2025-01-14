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

import java.math.BigInteger;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class IntegerPgDataTest {
    @Mock
    PgDataType type;
    @Spy
    @InjectMocks
    IntegerPgData data;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private static Stream<Arguments> generateValueTestData() {
        return Stream.of(
          Arguments.of(PgDataGenerator.CONSTANT, BigInteger.ZERO),
          Arguments.of(PgDataGenerator.ANY, null)
        );
    }

    private static Stream<Arguments> getMaxValuesTestData() {
        return Stream.of(
          Arguments.of(BigInteger.valueOf(0), BigInteger.valueOf(1000), 1001),
          Arguments.of(BigInteger.valueOf(0), BigInteger.valueOf(Integer.MAX_VALUE), Integer.MAX_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("generateValueTestData")
    void testGenerateValue(PgDataGenerator generator, BigInteger expected) {
        data.setStart(BigInteger.ZERO);
        data.setGenerator(generator);

        BigInteger result = data.generateValue();

        assertEquals(expected, result);
    }

    @Test
    void testGenerateValueIncrement() {
        data.setStart(BigInteger.ZERO);
        data.setGenerator(PgDataGenerator.INCREMENT);

        assertEquals(BigInteger.ZERO, data.currentInc);

        BigInteger result = data.generateValue();

        assertEquals(BigInteger.ZERO, result);
        assertEquals(BigInteger.ONE, data.currentInc);
    }

    @Test
    void testGenerateValueRandom() {
        BigInteger start = BigInteger.valueOf(100);
        BigInteger end = BigInteger.valueOf(1000);
        data.setStart(start);
        data.setEnd(end);
        data.setGenerator(PgDataGenerator.RANDOM);
        data.setNotNull(true);

        BigInteger result = data.generateValue();

        assertTrue(result.compareTo(start) >= 0);
        assertTrue(result.compareTo(end) < 0);
    }

    @ParameterizedTest
    @MethodSource("getMaxValuesTestData")
    void testGetMaxValues(BigInteger start, BigInteger end, int expected) {
        data.start = start;
        data.end = end;

        int result = data.getMaxValues();

        assertEquals(expected, result);
    }
}
