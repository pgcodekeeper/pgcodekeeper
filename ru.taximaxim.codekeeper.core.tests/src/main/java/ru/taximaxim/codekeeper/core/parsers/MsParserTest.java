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
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.log.Log;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser;

/**
 * Tests for MS SQL parser rules.
 *
 * @author galiev_mr
 * @since 5.7.0
 */
@RunWith(value = Parameterized.class)
public class MsParserTest {

    @Parameters
    public static Iterable<Object[]> parameters() {
        return TestUtils.getParameters(new Object[][] {
            {"ms_assemblies"},
            {"ms_authorizations"},
            {"ms_availability_group"},
            {"ms_backup"},
            {"ms_broker_priority"},
            {"ms_certificates"},
            // TODO goto
            {"ms_control_flow", 1},
            {"ms_cursors"},
            {"ms_database", 1},
            {"ms_delete"},
            {"ms_drop"},
            {"ms_event"},
            {"ms_full_width_chars"},
            {"ms_function"},
            {"ms_index"},
            {"ms_insert"},
            {"ms_key", 1},
            {"ms_logins", 3},
            {"ms_merge"},
            {"ms_other", 3},
            {"ms_predicates"},
            {"ms_procedures"},
            {"ms_roles"},
            {"ms_rule"},
            {"ms_schema"},
            {"ms_select"},
            {"ms_sequences"},
            {"ms_server", 6},
            {"ms_statements", 31},
            {"ms_table"},
            {"ms_transactions"},
            {"ms_triggers"},
            {"ms_type"},
            {"ms_update"},
            {"ms_users"},
            {"ms_xml_data_type", 1},
        });
    }

    /**
     * Template name for file names that should be used for the test.
     */
    private final String fileNameTemplate;
    private final int allowedAmbiguity;

    public MsParserTest(final String fileNameTemplate, Integer allowedAmbiguity) {
        this.fileNameTemplate = fileNameTemplate;
        this.allowedAmbiguity = allowedAmbiguity != null ? allowedAmbiguity : 0;
        Log.log(Log.LOG_DEBUG, fileNameTemplate);
    }

    @Test
    public void runDiff() throws IOException {
        List<Object> errors = new ArrayList<>();
        AtomicInteger ambiguity = new AtomicInteger();

        String sql = TestUtils.inputStreamToString(MsParserTest.class
                .getResourceAsStream(fileNameTemplate + ".sql"));

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
        Assert.assertTrue("File: " + fileNameTemplate + " - ANTLR Error", errors.isEmpty());
        Assert.assertFalse("File: " + fileNameTemplate + " - ANTLR Ambiguity " + count, count != allowedAmbiguity);
    }
}
