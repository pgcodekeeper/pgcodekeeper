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
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;

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
        List<Object[]> p = Arrays.asList(new Object[][] {
            {"ms_assemblies"},
            {"ms_authorizations"},
            // TODO из-за кавычек IPV6_ADDR и IPV4_ADDR считаются строками
            {"ms_availability_group"},
            {"ms_backup"},
            {"ms_broker_priority"},
            {"ms_certificates"},
            // TODO goto
            {"ms_control_flow", 6},
            {"ms_cursors"},
            {"ms_database", 1},
            {"ms_delete", 8},
            {"ms_drop"},
            {"ms_event"},
            {"ms_full_width_chars"},
            {"ms_function"},
            {"ms_index"},
            {"ms_insert", 28},
            {"ms_key", 1},
            {"ms_logins", 3},
            {"ms_merge", 3},
            {"ms_other", 10},
            {"ms_predicates"},
            {"ms_procedures"},
            {"ms_roles"},
            {"ms_rule"},
            {"ms_schema"},
            {"ms_select", 30},
            {"ms_sequences"},
            {"ms_server", 6},
            {"ms_statements", 31},
            {"ms_table"},
            {"ms_transactions"},
            {"ms_triggers", 1},
            {"ms_type"},
            {"ms_update", 16},
            {"ms_users"},
            {"ms_xml_data_type", 16},
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

    public MsParserTest(final String fileNameTemplate, Integer allowedAmbiguity) {
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

        String sql = getStringFromInpunStream(MsParserTest.class
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
