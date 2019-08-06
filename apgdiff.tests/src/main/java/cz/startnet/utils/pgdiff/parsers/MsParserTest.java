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
 * @since 5.5.3
 */
@RunWith(value = Parameterized.class)
public class MsParserTest {

    @Parameters
    public static Iterable<Object[]> parameters() {
        List<Object[]> p = Arrays.asList(new Object[][] {
            {"ms_analytic_windowed_functions"},
            {"ms_applicaton_roles"},
            {"ms_assemblies"},
            {"ms_asymmetric_keys"},
            {"ms_authorizations"},
            // TODO из-за кавычек IPV6_ADDR и IPV4_ADDR считаются строками
            {"ms_availability_group"},
            {"ms_backup"},
            {"ms_backup_certificate"},
            {"ms_backup_master_key"},
            {"ms_backup_service_master_key"},
            {"ms_broker_priority"},
            {"ms_certificates"},
            {"ms_column_encryption_key"},
            {"ms_column_master_key"},
            {"ms_concat_op"},
            // TODO goto
            {"ms_control_flow", 6},
            {"ms_create_function_optional_parens"},
            {"ms_credentials"},
            {"ms_cryptographic_provider"},
            {"ms_cursors"},
            {"ms_database_hadr"},
            {"ms_expressions", 11},
            {"ms_dbcc"},
            {"ms_db_roles"},
            {"ms_ddl_alter_database_mirroring"},
            {"ms_ddl_alter_endpoint"},
            {"ms_ddl_create_alter_database", 1},
            {"ms_ddl_create_drop_type"},
            {"ms_ddl_create_table"},
            {"ms_ddl_function"},
            {"ms_ddl_index"},
            {"ms_ddl_procedures"},
            {"ms_ddl_table"},
            {"ms_dml_delete", 8},
            {"ms_dml_insert", 28},
            {"ms_dml_merge", 3},
            {"ms_dml_openrowset"},
            {"ms_dml_select", 19},
            {"ms_dml_update", 16},
            {"ms_drop"},
            {"ms_event_notification"},
            {"ms_event_session"},
            {"ms_external_data_source"},
            {"ms_external_library"},
            {"ms_fulltext_catalog"},
            {"ms_full_width_chars"},
            {"ms_locktable"},
            {"ms_logins", 3},
            {"ms_master_key", 1},
            {"ms_message_type"},
            {"ms_nestedcomment"},
            {"ms_partition_function"},
            {"ms_partition_scheme"},
            {"ms_predicates"},
            {"ms_print_with_param", 3},
            {"ms_raiseerror"},
            {"ms_remote_service_binding"},
            {"ms_resource_governor"},
            {"ms_resource_pools"},
            {"ms_route"},
            {"ms_rule"},
            {"ms_schema"},
            {"ms_search_property_list"},
            {"ms_security_policy"},
            {"ms_sequences"},
            {"ms_server_audit"},
            {"ms_server_audit_specification"},
            {"ms_server_configuration"},
            {"ms_server_roles", 6},
            {"ms_service"},
            {"ms_service_master_keys"},
            {"ms_statements", 31},
            {"ms_stoplist"},
            {"ms_symmetric_keys"},
            {"ms_synonym", 5},
            {"ms_transactions"},
            {"ms_triggers", 1},
            {"ms_truncate"},
            {"ms_users"},
            {"ms_workload_group", 2},
            {"ms_xml_data_type", 16},
            {"ms_xml_schema_collection"},
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
    public void runDiff() throws IOException, InterruptedException {
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
