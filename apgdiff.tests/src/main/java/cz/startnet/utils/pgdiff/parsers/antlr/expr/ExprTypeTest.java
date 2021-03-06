/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cz.startnet.utils.pgdiff.FILES_POSTFIX;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.FullAnalyze;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.meta.MetaContainer;
import cz.startnet.utils.pgdiff.schema.meta.MetaUtils;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.log.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

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
    public static Iterable<Object[]> parameters() {
        return ApgdiffTestUtils.getParameters(new Object[][] {
            // Compare the types between an asterisk and an ordinary in view.
            {COMPARE + "types_aster_ord_view"},
            // Check types in columns of asterisk in view.
            {CHECK + "types_aster_cols_view"},
            // Check types in columns of view.
            {CHECK + "types_cols_view"},
            // Check types in columns of view (extended).
            {CHECK + "types_cols_view_extended"},
            // Check types in table-less columns.
            {CHECK + "tableless_cols_types"},
            // Check array types.
            {CHECK + "array_types"},
            // Check ANY type-matching
            {CHECK + "anytype_resolution"},
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
        Log.log(Log.LOG_DEBUG, fileNameTemplate);
    }

    private String getRelationColumnsTypes(MetaContainer meta) {
        StringBuilder cols = new StringBuilder();

        for (Entry<String, Map<String, IRelation>> entry : meta.getRelations().entrySet()) {
            String schemaName = entry.getKey();
            if (ApgdiffUtils.isPgSystemSchema(schemaName)) {
                continue;
            }

            boolean isFirstView = true;
            Map<String, IRelation> relations = entry.getValue();
            for (IRelation rel : relations.values()) {
                if (rel.getStatementType() != DbObjType.VIEW) {
                    continue;
                }

                if (isFirstView) {
                    cols.append("\n\nSchema: " + schemaName);
                    isFirstView = false;
                }

                cols.append("\n\n  View: " + rel.getName());
                cols.append("\n    RelationColumns : ");

                for (Pair<String, String> col : PgDiffUtils.sIter(rel.getRelationColumns())) {
                    cols.append("\n     " + col.getFirst() + " - " + col.getSecond());
                }
            }
        }

        return cols.toString();
    }

    private MetaContainer loadAndAnalyze(PgDiffArguments args, FILES_POSTFIX postfix)
            throws InterruptedException, IOException {
        PgDatabase dbNew = ApgdiffTestUtils.loadTestDump(
                fileNameTemplate + postfix, ExprTypeTest.class, args, false);
        MetaContainer metaDb = MetaUtils.createTreeFromDb(dbNew);
        FullAnalyze.fullAnalyze(dbNew, metaDb, new ArrayList<>());
        return metaDb;
    }

    @Test
    public void runDiff() throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        MetaContainer dbNew = loadAndAnalyze(args, FILES_POSTFIX.NEW_SQL);

        String typesForCompare = null;
        if (fileNameTemplate.startsWith(CHECK)) {
            // compare with a "type-dump"
            typesForCompare = ApgdiffTestUtils.inputStreamToString(ExprTypeTest.class
                    .getResourceAsStream(fileNameTemplate + FILES_POSTFIX.DIFF_SQL));
        } else if (fileNameTemplate.startsWith(COMPARE)) {
            // compare with types with another SQL representation
            typesForCompare = getRelationColumnsTypes(
                    loadAndAnalyze(args, FILES_POSTFIX.ORIGINAL_SQL));
        }

        Assert.assertEquals("File: " + fileNameTemplate,
                typesForCompare,
                getRelationColumnsTypes(dbNew));
    }
}
