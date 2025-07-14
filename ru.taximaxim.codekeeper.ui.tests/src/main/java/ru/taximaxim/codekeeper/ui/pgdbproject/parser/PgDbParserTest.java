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
package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.io.InvalidClassException;

import org.junit.jupiter.api.Test;

class PgDbParserTest {

    @Test
    void testPgDbParserDeserializeRightObject() throws IOException {
        try (var serializedFileStream = PgDbParser.class.getResourceAsStream("pgDbParser_object.ser")) {
            var pgDbParser = new PgDbParser();

            assertDoesNotThrow(() -> pgDbParser.deserialize(serializedFileStream));
        }
    }

    @Test
    void testPgDbParserDeserializeWrongObjectThrowsException() throws IOException {
        try (var serializedFileStream = PgDbParser.class.getResourceAsStream("wrong_object.ser")) {
            var pgDbParser = new PgDbParser();

            assertThrows(InvalidClassException.class, () -> pgDbParser.deserialize(serializedFileStream));
        }
    }
}
