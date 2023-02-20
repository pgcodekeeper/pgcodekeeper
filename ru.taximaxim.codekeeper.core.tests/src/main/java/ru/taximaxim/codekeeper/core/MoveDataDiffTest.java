/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package ru.taximaxim.codekeeper.core;

import java.io.IOException;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ru.taximaxim.codekeeper.core.schema.PgDatabase;

/**
 * Tests for migrate data option .
 *
 * @author Gulnaz Khazieva
 */
class MoveDataDiffTest {

    /**
     * Template name for file names that should be used for the test. Testing
     * method adds _original.sql, _new.sql and _diff.sql to the file name
     * template.
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "move_data",
            //implementation for data movement test in PG for case with different columns (with identity columns)
            "move_data_diff_cols_identity",
            //implementation for foreign table data movement test in PG
            "move_data_foreign",
            //implementation for data movement test in PG (with identity columns)
            "move_data_identity",
            //implementation for partition table data movement test in PG
            "move_data_partition_table",
            //implementation for partition table data movement test in PG (with identity columns)
            "move_data_partition_table_identity"
    })

    void runPgDiff(String fileNameTemplate) throws IOException, InterruptedException {
        runDiff(fileNameTemplate, false);
    }

    @ParameterizedTest
    @ValueSource(strings ={
            // implementation for data movement test in MS (without identity columns)
            "drop_ms_table",
            "move_data_ms",
            "move_data_ms_identity"
    })

    void runMsDiff(String fileNameTemplate) throws IOException, InterruptedException {
        runDiff(fileNameTemplate, true);
    }


    void runPgDiffNove(String fileNameTemplate) throws IOException, InterruptedException {
        runDiff(fileNameTemplate, false);
    }

    @Test
    void runDiff(String fileNameTemplate, boolean isMsSql) throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setDataMovementMode(true);
        args.setMsSql(isMsSql);
        PgDatabase dbOld = TestUtils.loadTestDump(
                fileNameTemplate + FILES_POSTFIX.ORIGINAL_SQL, MoveDataDiffTest.class, args);
        PgDatabase dbNew = TestUtils.loadTestDump(
                fileNameTemplate + FILES_POSTFIX.NEW_SQL, MoveDataDiffTest.class, args);

        TestUtils.runDiffSame(dbOld, fileNameTemplate, args);
        TestUtils.runDiffSame(dbNew, fileNameTemplate, args);

        String script = new PgDiff(args).diffDatabaseSchemas(dbOld, dbNew, null);
        String content = script.replaceAll("([0-9a-fA-F]{32})", "randomly_generated_part");

        TestUtils.compareResult(content, fileNameTemplate, MoveDataDiffTest.class);
    }
}
