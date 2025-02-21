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
package ru.taximaxim.codekeeper.core.parsers.antlr;

public class QNameParserWrapper {

    private final QNameParser<?> parser;

    private QNameParserWrapper(QNameParser<?> parser) {
        this.parser = parser;
    }

    public static QNameParserWrapper parsePg(String fullName) {
        return new QNameParserWrapper(QNameParser.parsePg(fullName));
    }

    public static QNameParserWrapper parseCh(String fullName) {
        return new QNameParserWrapper(QNameParser.parseCh(fullName));
    }

    public static QNameParserWrapper parsePgOperator(String fullName) {
        return new QNameParserWrapper(QNameParser.parsePgOperator(fullName));
    }

    public String getFirstName() {
        return parser.getFirstName();
    }

    public String getSecondName() {
        return parser.getSecondName();
    }

    public String getSchemaName() {
        return parser.getSchemaName();
    }

    public String getThirdName() {
        return parser.getThirdName();
    }

    public boolean hasErrors() {
        return parser.hasErrors();
    }
}
