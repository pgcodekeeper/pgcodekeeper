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

import java.util.stream.Stream;

import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.misc.IntervalSet;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLLexer;

class CustomTSQLAntlrErrorStrategy extends CustomAntlrErrorStrategy {

    @Override
    protected Stream<Integer> getTokenStream(IntervalSet tokens) {
        Stream<Integer> stream = tokens.toList().stream();

        if (tokens.contains(TSQLLexer.ID)) {
            stream = stream.filter(e -> e < TSQLLexer.ABORT || TSQLLexer.YEARS < e);
            stream = stream.filter(e -> e != TSQLLexer.PRECISION && e != TSQLLexer.FILLFACTOR);
        }
        return stream;
    }

    @Override
    protected String getTokenName(Integer token, Vocabulary vocabulary) {
        return switch (token) {
            case TSQLLexer.LOCAL_ID, TSQLLexer.SQUARE_BRACKET_ID, TSQLLexer.ID -> IDENTIFIER;
            case TSQLLexer.DOUBLE_QUOTE_ID, TSQLLexer.STRING -> STRING;
            case TSQLLexer.DECIMAL, TSQLLexer.FLOAT, TSQLLexer.REAL -> NUMBER;
            default -> vocabulary.getDisplayName(token);
        };
    }
}
