/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
import org.junit.jupiter.params.provider.ValueSource;

import ru.taximaxim.codekeeper.core.FILES_POSTFIX;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser;

/**
 * Tests for MS SQL parser rules.
 *
 * @author galiev_mr
 * @since 5.7.0
 */
class MsParserTest {

    @ParameterizedTest
    @ValueSource(strings =  {
            "ms_aggregate",
            "ms_assemblies",
            "ms_authorizations",
            "ms_availability_group",
            "ms_backup",
            "ms_broker_priority",
            "ms_certificates",
            "ms_control_flow",
            "ms_cursors",
            "ms_database",
            "ms_delete",
            "ms_drop",
            "ms_event",
            "ms_full_width_chars",
            "ms_function",
            "ms_index",
            "ms_insert",
            "ms_key",
            "ms_logins",
            "ms_merge",
            "ms_other",
            "ms_predicates",
            "ms_procedures",
            "ms_restore",
            "ms_roles",
            "ms_rule",
            "ms_schema",
            "ms_select_match",
            "ms_server",
            "ms_sequences",
            "ms_table",
            "ms_transactions",
            "ms_triggers",
            "ms_type",
            "ms_update",
            "ms_users",
            "ms_view",
    })
    void parse(final String fileNameTemplate) throws IOException {
        parse(fileNameTemplate, 0);
    }

    @ParameterizedTest
    @CsvSource({
        "ms_select, 3",
        "ms_statements, 1",
        "ms_xml_data_type, 1",
    })
    void parse(String fileNameTemplate, Integer allowedAmbiguity) throws IOException {
        List<Object> errors = new ArrayList<>();
        AtomicInteger ambiguity = new AtomicInteger();

        String sql = TestUtils.readResource(fileNameTemplate + FILES_POSTFIX.SQL, getClass());

        TSQLParser parser = AntlrParser
                .makeBasicParser(TSQLParser.class, sql, fileNameTemplate, errors);

        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
        parser.addErrorListener(new BaseErrorListener() {

            @Override
            public void reportAmbiguity(Parser p, DFA dfa, int start,
                    int stop, boolean exact, BitSet set, ATNConfigSet conf) {
                ambiguity.incrementAndGet();
            }
        });

        parser.tsql_file();

        int count = ambiguity.intValue();
        Assertions.assertTrue(errors.isEmpty(), "File: " + fileNameTemplate + " - ANTLR Error");
        Assertions.assertEquals(allowedAmbiguity, count, "File: " + fileNameTemplate + " - ANTLR Ambiguity " + count);
    }
}
