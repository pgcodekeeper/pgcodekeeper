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
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class BitPgDataTest {
    @Spy
    BitPgData data;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateValueConstant() {
        data.setStart("B'01'");
        data.setGenerator(PgDataGenerator.CONSTANT);

        String result = data.generateValue();

        assertEquals("B'01'", result);
    }

    @Test
    void testGenerateValueIncrement() {
        data.setGenerator(PgDataGenerator.INCREMENT);

        String result = data.generateValue();

        assertEquals(null, result);
    }

    @Test
    void testGenerateValueDefault() {
        data.setGenerator(PgDataGenerator.ANY);

        String result = data.generateValue();

        assertEquals(null, result);
    }

    @Test
    void testGenerateValueRandom() {
        data.setGenerator(PgDataGenerator.RANDOM);
        data.setNotNull(true);
        data.generateValue();

        verify(data).generateRandom();
    }

    @ParameterizedTest
    @CsvSource({
        "5, 32",
        "8, 256",
        "0, 0"
    })
    void testGetMaxValues(int length, int expected) {
        data.setLength(length);

        int result = data.getMaxValues();

        assertEquals(expected, result);
    }
}
