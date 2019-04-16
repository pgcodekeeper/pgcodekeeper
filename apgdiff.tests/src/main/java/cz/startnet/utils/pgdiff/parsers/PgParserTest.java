package cz.startnet.utils.pgdiff.parsers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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
    public static Collection<?> parameters() {
        return Arrays.asList(
                new Object[][] {
                    {"advisory_lock", 0},
                    // func args in refs
                    {"aggregates", 0},
                    // {"alter_generic", 0},
                    {"alter_operator", 0},
                    {"alter_table", 0},
                    //{"amutils", 0},
                    //{"arrays", 0},
                    {"async", 0},
                    {"bit", 0},
                    {"bitmapops", 0},
                    {"boolean", 0},
                    {"box", 1},
                    {"brin", 0},
                    {"btree_index", 0},
                    {"case", 0},
                    {"char", 0},
                    {"circle", 0},
                    {"cluster", 0},
                    {"collate", 12},
                    {"combocid", 0},
                    //{"conversion", 0},
                    //{"copy", 0},
                    //{"copyselect", 0},
                    // basetype = 'ANY'
                    {"create_aggregate", 0},
                    //{"create_am", 0},
                    //{"create_cast", 0},
                    {"create_function", 1},
                    {"create_index", 10},
                    {"create_misc", 0},

                    // IDEA can't find ambiguity
                    {"create_operator", 7},
                    {"create_procedure", 0},
                    {"create_table_like", 0},
                    {"create_table", 0},
                    {"create_type", 0},
                    {"create_view", 0},
                    {"date", 0},
                    {"dbsize", 0},
                    {"delete", 0},
                    {"dependency", 0},
                    //{"domain", 0},
                    {"drop_if_exists", 0},
                    {"drop_operator", 0},
                    {"enum", 0},
                    {"event_trigger", 0},
                    {"expressions", 0},
                    {"fast_default", 0},
                    {"float4", 0},
                    {"float8", 0},
                    {"foreign_data", 0},
                    {"foreign_key", 0},
                    {"functional_deps", 0},
                    {"geometry", 0},
                    {"gin", 0},
                    {"gist", 3},
                    //{"groupingsets", 0},
                    {"guc", 0},
                    {"hash_func", 0},
                    {"hash_index", 0},
                    {"hash_part", 0},
                    {"horology", 0},
                    {"hs_primary_extremes", 0},
                    {"hs_primary_setup", 0},
                    {"hs_standby_allowed", 0},
                    {"hs_standby_check", 0},
                    {"hs_standby_disallowed", 0},
                    {"hs_standby_functions", 0},
                    {"identity", 0},
                    {"index_including", 0},
                    {"indexing", 1},
                    {"indirect_toast", 0},
                    {"inet", 0},
                    {"inherit", 0},
                    {"insert_conflict", 0},
                    {"insert", 0},
                    {"int2", 0},
                    {"int4", 0},
                    {"int8", 0},
                    {"interval", 0},
                    {"join", 0},
                    {"json_encoding", 0},
                    {"json", 2},
                    {"jsonb", 3},
                    {"limit", 0},
                    {"line", 0},
                    {"lock", 0},
                    {"lseg", 0},
                    {"macaddr", 0},
                    {"macaddr8", 0},
                    {"matview", 0},
                    {"misc_functions", 0},
                    {"misc_sanity", 0},
                    {"money", 0},
                    {"name", 0},
                    {"namespace", 0},
                    {"numeric_big", 6},
                    {"numeric", 0},
                    {"numerology", 0},
                    {"object_address", 0},
                    {"oid", 0},
                    {"oidjoins", 0},
                    {"opr_sanity", 0},
                    {"partition_aggregate", 1},
                    {"partition_info", 0},
                    {"partition_join", 0},
                    {"partition_prune", 6},
                    {"password", 0},
                    {"path", 0},
                    {"pg_lsn", 0},
                    {"plancache", 0},
                    //{"plpgsql", 0},
                    {"point", 5},
                    {"polygon", 0},
                    // IDEA can't find ambiguity
                    {"polymorphism", 1},
                    {"portals_p2", 0},
                    {"portals", 0},
                    {"prepare", 0},
                    {"prepared_xacts", 0},
                    {"privileges", 2},
                    //{"publication", 0},
                    {"random", 0},
                    //{"rangefuncs", 0},
                    {"rangetypes", 0},
                    {"regex.linux.utf8", 0},
                    {"regex", 0},
                    {"regproc", 0},
                    {"reloptions", 0},
                    {"replica_identity", 0},
                    {"returning", 0},
                    {"roleattributes", 0},
                    //{"rolenames", 0},
                    //{"rowsecurity", 0},
                    {"rowtypes", 0},
                    {"rules", 1},
                    {"sanity_check", 0},
                    //{"security_label", 0},
                    {"select_distinct_on", 0},
                    {"select_distinct", 0},
                    {"select_having", 0},
                    {"select_implicit", 0},
                    //{"select_into", 0},
                    {"select_parallel", 0},
                    {"select_views", 0},
                    {"select", 0},
                    {"sequence", 0},
                    {"spgist", 2},
                    {"stats_ext", 0},
                    {"stats", 0},
                    // some string are unsupported
                    {"strings", 0},
                    //{"subscription", 0},
                    {"subselect", 0},
                    {"sysviews", 0},
                    //{"tablesample", 0},
                    {"temp", 0},
                    {"text", 0},
                    {"tidscan", 0},
                    {"time", 0},
                    {"timestamp", 0},
                    {"timestamptz", 0},
                    {"timetz", 0},
                    {"transactions", 0},
                    {"triggers", 0},
                    {"truncate", 0},
                    {"tsdicts", 0},
                    {"tsearch", 1},
                    {"tsrf", 6},
                    {"tstypes", 1},
                    {"type_sanity", 0},
                    {"typed_table", 0},
                    {"union", 0},
                    {"updatable_views", 6},
                    {"update", 0},
                    {"uuid", 0},
                    {"vacuum", 0},
                    {"varchar", 0},
                    {"window", 0},
                    {"with", 0},
                    // xmltable
                    {"xml", 0},
                    {"xmlmap", 0},
                });
    }

    /**
     * Template name for file names that should be used for the test.
     */
    private final String fileNameTemplate;
    private final int allowedAmbiguity;

    public PgParserTest(final String fileNameTemplate, int allowedAmbiguity) {
        this.fileNameTemplate = fileNameTemplate;
        this.allowedAmbiguity = allowedAmbiguity;
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
    public void runDiff() throws IOException, InterruptedException {
        List<AntlrError> errors = new ArrayList<>();
        AtomicBoolean hasAmbiguity = new AtomicBoolean(false);

        String sql = getStringFromInpunStream(PgParserTest.class
                .getResourceAsStream(fileNameTemplate + ".sql"));

        SQLParser parser = AntlrParser
                .makeBasicParser(SQLParser.class, sql, fileNameTemplate, errors);

        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
        parser.addErrorListener(new BaseErrorListener() {

            private int ambiguityCount;

            @Override
            public void reportAmbiguity(Parser p, DFA dfa, int start,
                    int stop, boolean exact, BitSet set, ATNConfigSet conf) {
                if (++ambiguityCount > allowedAmbiguity ) {
                    hasAmbiguity.set(true);
                }
            }
        });

        parser.sql();

        Assert.assertFalse("File: " + fileNameTemplate + " - ANTLR Ambiguity", hasAmbiguity.get());
        Assert.assertTrue("File: " + fileNameTemplate + " - ANTLR Error", errors.isEmpty());
    }
}
