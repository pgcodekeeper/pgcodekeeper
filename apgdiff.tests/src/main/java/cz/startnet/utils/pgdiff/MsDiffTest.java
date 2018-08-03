package cz.startnet.utils.pgdiff;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;

/**
 * Tests for MS SQL statements
 *
 * @author galiev_mr
 */
@RunWith(value = Parameterized.class)
public class MsDiffTest {

    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(
                new Object[][] {
                    // Tests scenario where MS PRIVILEGES for columns is added.
                    {"add_ms_column_privileges"},
                    // Tests scenario where MS COLUMN type is modified.
                    {"modify_ms_column_type"},
                    // Tests scenario where MS SEQUENCE cashe is modified.
                    {"modify_ms_sequence_cache"},
                });
    }

    /**
     * Template name for file names that should be used for the test. Testing
     * method adds _original.sql, _new.sql and _diff.sql to the file name
     * template.
     */
    private final String fileNameTemplate;

    public MsDiffTest(final String fileNameTemplate) {
        this.fileNameTemplate = fileNameTemplate;
        Locale.setDefault(Locale.ENGLISH);
        Log.log(Log.LOG_DEBUG, fileNameTemplate);
    }

    public void runDiffSame(PgDatabase db) throws IOException, InterruptedException {
        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        final PgDiffArguments arguments = new PgDiffArguments();
        arguments.setMsSql(true);
        PgDiff.diffDatabaseSchemas(writer, arguments, db, db, null);
        writer.flush();

        Assert.assertEquals("File name template: " + fileNameTemplate, "", diffInput.toString().trim());
    }

    @Test
    public void runDiff() throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setMsSql(true);

        PgDatabase dbOld = ApgdiffTestUtils.loadTestDump(
                fileNameTemplate + FILES_POSTFIX.ORIGINAL_SQL, MsDiffTest.class, args);
        PgDatabase dbNew = ApgdiffTestUtils.loadTestDump(
                fileNameTemplate + FILES_POSTFIX.NEW_SQL, MsDiffTest.class, args);

        runDiffSame(dbOld);
        runDiffSame(dbNew);

        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        PgDiff.diffDatabaseSchemas(writer, args, dbOld, dbNew, null);
        writer.flush();

        StringBuilder sbExpDiff;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                MsDiffTest.class.getResourceAsStream(fileNameTemplate
                        + FILES_POSTFIX.DIFF_SQL)))) {
            sbExpDiff = new StringBuilder(1024);

            String line;
            while ((line = reader.readLine()) != null) {
                sbExpDiff.append(line);
                sbExpDiff.append('\n');
            }
        }

        Assert.assertEquals("File name template: " + fileNameTemplate,
                sbExpDiff.toString().trim(),
                diffInput.toString().trim());
    }
}
