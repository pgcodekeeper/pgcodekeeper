/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.parsers.antlr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QNameParserTest {

    private static final String SCHEMA = "schema";
    private static final String TABLE = "table";
    private static final Object COLUMN = "column";

    @Test
    void testParseSchemaBothQuoted() {
        Assertions.assertEquals(SCHEMA, QNameParser.parsePg("\"schema\".\"table\"").getSchemaName());
    }

    @Test
    void testParseSchemaFirstQuoted() {
        Assertions.assertEquals(SCHEMA, QNameParser.parsePg("\"schema\".table").getSchemaName());
    }

    @Test
    void testParseSchemaSecondQuoted() {
        Assertions.assertEquals(SCHEMA, QNameParser.parsePg("schema.\"table\"").getSchemaName());
    }

    @Test
    void testParseSchemaNoneQuoted() {
        Assertions.assertEquals(SCHEMA, QNameParser.parsePg("schema.table").getSchemaName());
    }

    @Test
    void testParseSchemaThreeQuoted() {
        Assertions.assertEquals(SCHEMA, QNameParser.parsePg("\"schema\".\"table\".\"column\"").getSchemaName());
    }

    @Test
    void testParseObjectBothQuoted() {
        Assertions.assertEquals(TABLE, QNameParser.parsePg("\"schema\".\"table\"").getFirstName());
    }

    void testParseObjectFirstQuoted() {
        Assertions.assertEquals(TABLE, QNameParser.parsePg("\"schema\".table").getFirstName());
    }

    @Test
    void testParseObjectSecondQuoted() {
        Assertions.assertEquals(TABLE, QNameParser.parsePg("schema.\"table\"").getFirstName());
    }

    @Test
    void testParseObjectNoneQuoted() {
        Assertions.assertEquals(TABLE, QNameParser.parsePg("schema.table").getFirstName());
    }

    @Test
    void testParseObjectThreeQuoted() {
        Assertions.assertEquals(COLUMN, QNameParser.parsePg("\"schema\".\"table\".\"column\"").getFirstName());
    }
}
