/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

final class BooleanPgDataTest {
    @Spy
    BooleanData data;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateValueConstant() {
        data.setStart(true);
        data.setGenerator(DataGenerator.CONSTANT);

        boolean result = data.generateValue();

        assertEquals(true, result);
    }

    @Test
    void testGenerateValueIncrement() {
        data.setStart(true);
        data.setGenerator(DataGenerator.INCREMENT);

        assertEquals(true, data.currentInc);
        boolean result = data.generateValue();

        assertEquals(true, result);
        assertEquals(false, data.currentInc);
    }

    @Test
    void testGenerateValueRandom() {
        data.setGenerator(DataGenerator.RANDOM);
        data.setNotNull(true);

        data.generateValue();

        verify(data).generateRandom();
    }

    @Test
    void testMaxValue() {
        int result = data.getMaxValues();

        assertEquals(2, result);
    }
}
