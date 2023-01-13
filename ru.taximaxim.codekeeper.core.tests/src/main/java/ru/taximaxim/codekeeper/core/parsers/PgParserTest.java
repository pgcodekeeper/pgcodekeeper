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

import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser;

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
            "foreign_data",
            "server",
            "user_mapping",
            "policy",
            "schema",
            "fts_configuration",
            "fts_parser",
            "fts_template",
            "create_function",
            "operator",
            "create_procedure",
            "sequence",
            "create_table",
            "alter_table",
            "type",
            "view",
            "database",
            "extension",
            "index",
            "triggers",
            "role",
            "rules",
            "domain",
            "other",
            "copy",
            "create_cast",
            "arrays",
            "case",
            "cluster",
            "conversion",
            "create_misc",
            "create_table_like",
            "date",
            "delete",
            "dependency",
            "drop_if_exists",
            "drop_operator",
            "enum",
            "event_trigger",
            "fast_default",
            "float8",
            "foreign_key",
            "functional_deps",
            "geometry",
            "inherit",
            "insert_conflict",
            "insert",
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
            "object_address",
            "oid",
            "oidjoins",
            "opr_sanity",
            "partition_join",
            "plancache",
            "point",
            "polygon",
            "polymorphism",
            "privileges",
            "publication",
            "rangefuncs",
            "rangetypes",
            "reloptions",
            "rowtypes",
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
            "tsdicts",
            "tsearch",
            "update",
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

        String sql = TestUtils.inputStreamToString(PgParserTest.class
            .getResourceAsStream(fileNameTemplate + ".sql"));

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
