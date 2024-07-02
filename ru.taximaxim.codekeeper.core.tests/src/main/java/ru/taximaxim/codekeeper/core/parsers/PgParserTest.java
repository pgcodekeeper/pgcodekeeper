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
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser;

/**
 * Tests for PostgreSQL parser rules.
 *
 * @author galiev_mr
 * @since 5.3.8
 */
class PgParserTest {

    @ParameterizedTest
    @ValueSource(strings = {
            // basetype = 'ANY'
            // func args in refs
            "aggregates",
            "alter_table",
            "arrays",
            "case",
            "cluster",
            "conversion",
            "copy",
            "create_cast",
            "create_function",
            "create_misc",
            "create_procedure",
            "create_table",
            "create_table_like",
            "database",
            "date",
            "delete",
            "dependency",
            "domain",
            "drop_if_exists",
            "drop_operator",
            "enum",
            "event_trigger",
            "extension",
            "fast_default",
            "float8",
            "foreign_data",
            "foreign_key",
            "fts_configuration",
            "fts_parser",
            "fts_template",
            "functional_deps",
            "geometry",
            "index",
            "inherit",
            "insert",
            "insert_conflict",
            "interval",
            "join",
            "json_encoding",
            "jsonb",
            "lseg",
            "merge",
            "misc_functions",
            "misc_sanity",
            "name",
            "namespace",
            "numeric",
            "numeric_big",
            "numerology",
            "oid",
            "oidjoins",
            "operator",
            "opr_sanity",
            "other",
            "partition_join",
            "plancache",
            "point",
            "policy",
            "polygon",
            "polymorphism",
            "privileges",
            "publication",
            "rangefuncs",
            "rangetypes",
            "reloptions",
            "role",
            "rowtypes",
            "rules",
            "schema",
            "sequence",
            "server",
            "set",
            "spgist",
            //some strings are unsupported
            "strings",
            "subscription",
            "subselect",
            "sysviews",
            "time",
            "timestamp",
            "timestamptz",
            "timetz",
            "transactions",
            "triggers",
            "tsdicts",
            "tsearch",
            "type",
            "update",
            "user_mapping",
            "view",
            "window",
            "with"
    })
    void parse(final String fileNameTemplate) throws IOException {
        parse(fileNameTemplate, 0);
    }

    @ParameterizedTest
    @CsvSource({
            "collate, 7",
            "groupingsets, 47",
            "partition_aggregate, 1",
            "partition_prune, 6",
            "select, 2"
    })
    void parse(String fileNameTemplate, int allowedAmbiguity) throws IOException {
        List<Object> errors = new ArrayList<>();
        AtomicInteger ambiguity = new AtomicInteger();

        String sql = TestUtils.readResource(fileNameTemplate + FILES_POSTFIX.SQL, getClass());

        SQLParser parser = AntlrParser
            .makeBasicParser(SQLParser.class, sql, fileNameTemplate, errors);

        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
        parser.addErrorListener(new BaseErrorListener() {

            @Override
            public void reportAmbiguity(Parser p, DFA dfa, int start,
                    int stop, boolean exact, BitSet set, ATNConfigSet conf) {
                ambiguity.incrementAndGet();
            }
        });

        parser.sql();

        int count = ambiguity.intValue();
        Assertions.assertTrue(errors.isEmpty(), "File: " + fileNameTemplate + " - ANTLR Error");
        Assertions.assertEquals(allowedAmbiguity, count,
                "File: " + fileNameTemplate + " - ANTLR Ambiguity " + count + " expected " + allowedAmbiguity);
    }
}
