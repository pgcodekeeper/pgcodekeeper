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

import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.provider.Arguments;

@TestInstance(Lifecycle.PER_CLASS)
class DatePgDataTest extends AbstractPgTimeDateDataTest<DatePgData, LocalDate>{
    public DatePgDataTest() {
        super(LocalDate.ofEpochDay(0), LocalDate.ofEpochDay(1), LocalDate.of(2070, 1, 1));
    }

    @BeforeEach
    void setUp() {
        data = new DatePgData();
        setDefaultValues();
    }

    @Override
    protected Stream<Arguments> generateAsStringTestData() {
        return Stream.of(
                Arguments.of(PgDataGenerator.CONSTANT, "'1970-01-01'"),
                Arguments.of(PgDataGenerator.INCREMENT, "'1970-01-01'"),
                Arguments.of(PgDataGenerator.ANY, "any value")
              );
    }

    @Override
    protected Stream<Arguments> generateGetMaxValuesTestData() {
        return Stream.of(
                Arguments.of(start, end, 36526),
                Arguments.of(start, LocalDate.ofEpochDay(9999999999L), Integer.MAX_VALUE)
              );
    }

    @Override
    protected Stream<Arguments> generateGetStepFromStringTestData() {
        return Stream.of(Arguments.of(step, "1"));
    }

    @Override
    protected Stream<Arguments> generateValueFromStringTestData() {
        return Stream.of(Arguments.of(start, "1970-01-01"));
    }
}
