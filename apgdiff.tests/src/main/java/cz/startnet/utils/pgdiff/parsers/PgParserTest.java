package cz.startnet.utils.pgdiff.parsers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
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

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;

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
        List<Object[]> p = Arrays.asList(new Object[][] {
            // basetype = 'ANY'
            // func args in refs
            {"aggregates"},
            {"alter_table"},
            //{"arrays"},
            {"case"},
            {"cluster"},
            {"collate", 7},
            {"conversion"},
            {"copy"},
            {"create_cast"},
            {"create_function"},
            {"create_index", 10},
            {"create_misc"},
            {"create_procedure"},
            {"create_table_like"},
            {"create_table"},
            {"create_type"},
            {"create_view"},
            {"date"},
            {"dbsize"},
            {"delete"},
            {"dependency"},
            {"domain"},
            {"drop_if_exists"},
            {"drop_operator"},
            {"enum"},
            {"event_trigger"},
            {"expressions"},
            {"fast_default"},
            {"float8"},
            {"foreign_data"},
            {"foreign_key"},
            {"functional_deps"},
            {"geometry"},
            {"groupingsets", 47},
            {"hash_func"},
            {"hash_index"},
            {"identity"},
            {"index_including"},
            {"indexing", 1},
            {"indirect_toast"},
            {"inherit"},
            {"insert_conflict"},
            {"insert"},
            {"interval"},
            {"join"},
            {"json_encoding"},
            {"jsonb", 3},
            {"lseg"},
            {"matview"},
            {"misc_functions"},
            {"misc_sanity"},
            {"name"},
            {"namespace"},
            {"numeric_big", 6},
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
            //{"plpgsql"},
            {"point", 5},
            {"policy"},
            {"polygon"},
            // IDEA can't find ambiguity
            {"polymorphism", 1},
            {"privileges", 2},
            {"publication"},
            {"rangefuncs"},
            {"rangetypes"},
            {"regproc"},
            {"reloptions"},
            {"replica_identity"},
            {"returning"},
            {"role"},
            {"rowtypes"},
            {"rules", 1},
            // IDEA can't find 7 ambiguity
            {"select", 11},
            {"set"},
            {"sequence"},
            {"spgist", 2},
            // some string are unsupported
            {"strings"},
            {"subscription"},
            {"subselect"},
            {"sysviews"},
            {"temp"},
            {"time"},
            {"timestamp"},
            {"timestamptz"},
            {"timetz"},
            {"transactions"},
            {"triggers"},
            {"truncate"},
            {"tsdicts"},
            {"tsearch", 1},
            {"tsrf", 6},
            {"tstypes", 1},
            {"type_sanity"},
            {"updatable_views", 6},
            {"update"},
            {"varchar"},
            {"window"},
            {"with"},
        });

        int maxLength = p.stream()
                .mapToInt(oo -> oo.length)
                .max().getAsInt();
        return p.stream()
                .map(oo -> oo.length < maxLength ? Arrays.copyOf(oo, maxLength) : oo)
                ::iterator;
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

    private String getStringFromInpunStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString(ApgdiffConsts.UTF_8);
    }

    @Test
    public void runDiff() throws IOException {
        List<AntlrError> errors = new ArrayList<>();
        AtomicInteger ambiguity = new AtomicInteger();

        String sql = getStringFromInpunStream(PgParserTest.class
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
        Assert.assertFalse("File: " + fileNameTemplate + " - ANTLR Ambiguity " + count, count != allowedAmbiguity);
    }
}
