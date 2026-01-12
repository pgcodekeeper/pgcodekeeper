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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DateTimeException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public abstract class AbstractPgTimeDateDataTest<T extends DbData<R>, R extends Comparable<? super R>> {

    private static final String INVALID = "INVALID STRING";

    protected T data;

    protected final R start;
    protected final R step;
    protected final R end;

    protected AbstractPgTimeDateDataTest(R start, R step, R end) {
        this.start = start;
        this.step = step;
        this.end = end;
    }

    protected void setDefaultValues() {
        data.setStart(start);
        data.setEnd(end);
        data.setNotNull(true);
        data.setStep(step);
        data.setAny("any value");
    }

    protected Stream<Arguments> generateValueTestData() {
        return Stream.of(
                Arguments.of(DataGenerator.CONSTANT, start),
                Arguments.of(DataGenerator.ANY, null)
                );
    }

    protected Stream<Arguments> generateValueIncrementTestData() {
        return Stream.of(Arguments.of(start, step));
    }

    protected abstract Stream<Arguments> generateAsStringTestData();

    protected abstract Stream<Arguments> generateGetMaxValuesTestData();

    protected abstract Stream<Arguments> generateGetStepFromStringTestData();

    protected abstract Stream<Arguments> generateValueFromStringTestData();

    @ParameterizedTest
    @MethodSource("generateValueTestData")
    void testGenerateValue(DataGenerator generator, R expected) {
        data.setGenerator(generator);

        R result = data.generateValue();

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("generateValueIncrementTestData")
    void testGenerateValueIncrement(R beforeIncrement, R afterIncrement) {
        data.setGenerator(DataGenerator.INCREMENT);

        R firstResult = data.generateValue();
        R secondResult = data.generateValue();

        assertEquals(beforeIncrement, firstResult);
        assertEquals(afterIncrement, secondResult);
    }

    @Test
    void testGenerateValueRandom() {
        data.setGenerator(DataGenerator.RANDOM);

        R result = data.generateValue();

        assertTrue(result.compareTo(start) >= 0);
        assertTrue(result.compareTo(end) < 0);
    }

    @ParameterizedTest
    @MethodSource("generateAsStringTestData")
    void testGenerateAsString(DataGenerator generator, String expected) {
        data.setGenerator(generator);

        String result = data.generateAsString();

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("generateGetMaxValuesTestData")
    void testGetMaxValues(R start, R end, int expected) {
        data.setStart(start);
        data.setEnd(end);

        int result = data.getMaxValues();

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("generateValueFromStringTestData")
    void testValueFromString(R value, String str) {
        R result = data.valueFromString(str);

        assertEquals(value, result);
    }

    @ParameterizedTest
    @MethodSource("generateGetStepFromStringTestData")
    void testGetStepAsString(R value, String str) {
        data.setStep(value);

        String result = data.getStepAsString();

        assertEquals(str, result);
    }

    @ParameterizedTest
    @MethodSource("generateGetStepFromStringTestData")
    void testSetStepFromString(R value, String str) {
        data.setStepFromString(str);

        assertEquals(value, step);
    }

    @Test
    void testValueFromStringParseException() {
        assertThrows(DateTimeException.class, () -> data.valueFromString(INVALID));
    }

    @Test
    void testSetStepFromStringThrowsException() {
        assertThrows(Exception.class, () -> data.setStepFromString(INVALID));
    }
}
