/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cz.startnet.utils.pgdiff.FILES_POSTFIX;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;

/**
 * Tests for checking column types.
 *
 * @author shamsutdinov_lr
 */
@RunWith(value = Parameterized.class)
public class ExprTypeTest {

    private static final String CHECK = "check_";
    private static final String COMPARE = "compare_";

    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(
                new Object[][]{
                    // Compare the types between an asterisk and an ordinary in view.
                    {COMPARE+"types_aster_ord_view"},
                    // Check types in columns of asterisk in view.
                    {CHECK + "types_aster_cols_view"},
                    // Check types in columns of view.
                    {CHECK + "types_cols_view"},
                    // Check types in columns of view (extended).
                    {CHECK + "types_cols_view_extended"},
                    // Check types in table-less columns.
                    {CHECK + "tableless_cols_types"}
                });
    }

    /**
     * Template name for file names that should be used for the test. Testing
     * method adds _original.sql, _new.sql and _diff.sql to the file name
     * template.
     */
    private final String fileNameTemplate;

    public ExprTypeTest(final String fileNameTemplate) {
        this.fileNameTemplate = fileNameTemplate;
    }

    private String getRelationColumnsTypes(PgDatabase db) throws IOException, InterruptedException {
        StringBuilder cols = new StringBuilder();
        for (AbstractSchema schema : db.getSchemas()) {
            List<PgView> views = schema.getViews();
            if(views.isEmpty()) {
                continue;
            }
            cols.append("\n\nSchema: " + schema.getName());
            for (PgView view : views) {
                cols.append("\n\n  View: " + view.getName());
                cols.append("\n    RelationColumns : ");

                for (Entry<String, String> col : PgDiffUtils.sIter(view.getRelationColumns())) {
                    cols.append("\n     " + col.getKey() + " - " + col.getValue());
                }
            }
        }
        return cols.toString();
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
        PgDiffArguments args = new PgDiffArguments();
        PgDatabase dbNew = ApgdiffTestUtils.loadTestDump(
                fileNameTemplate + FILES_POSTFIX.NEW_SQL, ExprTypeTest.class, args);

        String typesForCompare = null;
        if (fileNameTemplate.startsWith(CHECK)) {
            // compare with a "type-dump"
            typesForCompare = getStringFromInpunStream(ExprTypeTest.class
                    .getResourceAsStream(fileNameTemplate + FILES_POSTFIX.DIFF_SQL));
        } else if (fileNameTemplate.startsWith(COMPARE)) {
            // compare with types with another SQL representation
            typesForCompare = getRelationColumnsTypes(ApgdiffTestUtils.loadTestDump(
                    fileNameTemplate + FILES_POSTFIX.ORIGINAL_SQL, ExprTypeTest.class, args));
        }

        Assert.assertEquals("File: " + fileNameTemplate,
                typesForCompare,
                getRelationColumnsTypes(dbNew));
    }
}
