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
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser;

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
            // TODO goto
            "ms_cursors",
            "ms_delete",
            "ms_drop",
            "ms_event",
            "ms_full_width_chars",
            "ms_function",
            "ms_index",
            "ms_insert",
            "ms_merge",
            "ms_predicates",
            "ms_procedures",
            "ms_roles",
            "ms_rule",
            "ms_schema",
            "ms_select",
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
        "ms_control_flow, 1",
        "ms_database, 1",
        "ms_key, 1",
        "ms_logins, 3",
        "ms_other, 3",
        "ms_server, 6",
        "ms_statements, 31",
        "ms_xml_data_type, 1",
    })
    void parse(String fileNameTemplate, Integer allowedAmbiguity) throws IOException {
        List<Object> errors = new ArrayList<>();
        AtomicInteger ambiguity = new AtomicInteger();

        String sql = TestUtils.readResource(fileNameTemplate + ".sql", getClass());

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
