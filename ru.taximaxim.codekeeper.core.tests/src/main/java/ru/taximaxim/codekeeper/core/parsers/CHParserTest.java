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
package ru.taximaxim.codekeeper.core.parsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.dfa.DFA;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ru.taximaxim.codekeeper.core.FILES_POSTFIX;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser;

/**
 * Tests for ClickHouse parser rules.
 *
 * @author khazieva_gr
 */
class CHParserTest {

    @ParameterizedTest
    @CsvSource({
        "ch_database, 0",
        "ch_function, 1",
        // "ch_index, 0",
        // "ch_insert, 0",
        // "ch_other, 0",
        "ch_show, 0",
        "ch_view, 1",
        "ch_policy, 0",
        "ch_table, 1",
        "ch_select, 102",
        "ch_privileges, 0",
        "ch_user, 0",
        "ch_role, 0",
        "ch_dictionary, 0"
    })
    void parse(String fileNameTemplate, int allowedAmbiguity) throws IOException {
        List<Object> errors = new ArrayList<>();
        AtomicInteger ambiguity = new AtomicInteger();
        String dirName = "ch/";

        String sql = TestUtils.readResource(dirName+fileNameTemplate + FILES_POSTFIX.SQL, getClass());

        CHParser parser = AntlrParser
                .makeBasicParser(CHParser.class, sql, fileNameTemplate, errors);

        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
        parser.addErrorListener(new BaseErrorListener() {

            @Override
            public void reportAmbiguity(Parser p, DFA dfa, int start,
                    int stop, boolean exact, BitSet set, ATNConfigSet conf) {
                ambiguity.incrementAndGet();
            }
        });

        parser.ch_file();

        int count = ambiguity.intValue();
        Assertions.assertEquals("[]", errors.toString(), "File: " + fileNameTemplate + " - ANTLR Error");
        Assertions.assertEquals(allowedAmbiguity, count,
                "File: " + fileNameTemplate + " - ANTLR Ambiguity " + count + " expected " + allowedAmbiguity);
    }
}
