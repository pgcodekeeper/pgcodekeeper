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

import java.time.LocalTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.provider.Arguments;

@TestInstance(Lifecycle.PER_CLASS)
final class TimePgDataTest extends AbstractPgTimeDateDataTest<TimeData, LocalTime> {

    public TimePgDataTest() {
        super(LocalTime.of(0, 0), LocalTime.of(0, 1), LocalTime.of(5, 30));
    }

    @BeforeEach
    void setUp() {
        data = new TimeData();
        setDefaultValues();
    }

    @Override
    protected Stream<Arguments> generateAsStringTestData() {
        return Stream.of(
                Arguments.of(DataGenerator.CONSTANT, "'00:00'"),
                Arguments.of(DataGenerator.INCREMENT, "'00:00'")
                );
    }

    @Override
    protected Stream<Arguments> generateValueIncrementTestData() {
        return Stream.of(Arguments.of(start, step));
    }

    @Override
    protected Stream<Arguments> generateGetMaxValuesTestData() {
        return Stream.of(Arguments.of(start, end, 19800001));
    }

    @Override
    protected Stream<Arguments> generateGetStepFromStringTestData() {
        return Stream.of(Arguments.of(step, "PT1M"));
    }

    @Override
    protected Stream<Arguments> generateValueFromStringTestData() {
        return Stream.of(Arguments.of(end, "05:30:00"));
    }
}
