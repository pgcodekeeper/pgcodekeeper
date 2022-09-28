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
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser;

/**
 * Tests for PostgreSQL parser rules.
 *
 * @author galiev_mr
 * @since 5.3.8
 */
@RunWith(value = Parameterized.class)
public class PgParserTest {

    @Parameters
    public static Iterable<Object[]> parameters() {
        return TestUtils.getParameters(new Object[][] {
            // basetype = 'ANY'
            // func args in refs
            {"aggregates"},
            {"alter_table"},
            {"arrays"},
            {"case"},
            {"cluster"},
            {"collate", 7},
            {"conversion"},
            {"copy"},
            {"create_cast"},
            {"create_function"},
            {"create_misc"},
            {"create_procedure"},
            {"create_table_like"},
            {"create_table"},
            {"database"},
            {"date"},
            {"delete"},
            {"dependency"},
            {"domain"},
            {"drop_if_exists"},
            {"drop_operator"},
            {"enum"},
            {"event_trigger"},
            {"fast_default"},
            {"float8"},
            {"foreign_data"},
            {"foreign_key"},
            {"functional_deps"},
            {"geometry"},
            {"groupingsets", 47},
            {"index"},
            {"inherit"},
            {"insert_conflict"},
            {"insert"},
            {"interval"},
            {"join"},
            {"json_encoding"},
            {"jsonb"},
            {"lseg"},
            {"misc_functions"},
            {"misc_sanity"},
            {"name"},
            {"namespace"},
            {"numeric_big"},
            {"numeric"},
            {"numerology"},
            {"object_address"},
            {"oid"},
            {"oidjoins"},
            {"operator"},
            {"opr_sanity"},
            {"other"},
            {"partition_aggregate", 1},
            {"partition_join"},
            {"partition_prune", 6},
            {"plancache"},
            {"point"},
            {"policy"},
            {"polygon"},
            {"polymorphism"},
            {"privileges"},
            {"publication"},
            {"rangefuncs"},
            {"rangetypes"},
            {"reloptions"},
            {"role"},
            {"rowtypes"},
            {"rules"},
            {"select", 2},
            {"set"},
            {"sequence"},
            {"spgist"},
            // some string are unsupported
            {"strings"},
            {"subscription"},
            {"subselect"},
            {"sysviews"},
            {"time"},
            {"timestamp"},
            {"timestamptz"},
            {"timetz"},
            {"transactions"},
            {"triggers"},
            {"tsdicts"},
            {"tsearch"},
            {"type"},
            {"update"},
            {"view"},
            {"window"},
            {"with"},
        });
    }

    /**
     * Template name for file names that should be used for the test.
     */
    private final String fileNameTemplate;
    private final int allowedAmbiguity;

    public PgParserTest(final String fileNameTemplate, Integer allowedAmbiguity) {
        this.fileNameTemplate = fileNameTemplate;
        this.allowedAmbiguity = allowedAmbiguity != null ? allowedAmbiguity : 0;
        Log.log(Log.LOG_DEBUG, fileNameTemplate);
    }

    @Test
    public void runDiff() throws IOException {
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
        Assert.assertTrue("File: " + fileNameTemplate + " - ANTLR Error", errors.isEmpty());
        Assert.assertFalse("File: " + fileNameTemplate + " - ANTLR Ambiguity " + count + " expected " + allowedAmbiguity,
                count != allowedAmbiguity);
    }
}
