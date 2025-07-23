/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core;

import java.io.IOException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.settings.CoreSettings;

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
            "move_data_partition_table_identity",
            //implementation for partition table data movement test in PG with identity columns(dropped, changed identity col)
            "move_data_change_col_identity"
    })
    void runPgDiff(String fileNameTemplate) throws IOException, InterruptedException {
        runDiff(fileNameTemplate, DatabaseType.PG);
    }

    @ParameterizedTest
    @ValueSource(strings ={
            // implementation for data movement test in MS (without identity columns)
            "drop_ms_table",
            "move_data_ms",
            "move_data_ms_identity"
    })
    void runMsDiff(String fileNameTemplate) throws IOException, InterruptedException {
        runDiff(fileNameTemplate, DatabaseType.MS);
    }

    void runDiff(String fileNameTemplate, DatabaseType dbType) throws IOException, InterruptedException {
        var settings = new CoreSettings();
        settings.setDataMovementMode(true);
        settings.setDbType(dbType);
        AbstractDatabase dbOld = TestUtils.loadTestDump(
                fileNameTemplate + FILES_POSTFIX.ORIGINAL_SQL, MoveDataDiffTest.class, settings);
        AbstractDatabase dbNew = TestUtils.loadTestDump(
                fileNameTemplate + FILES_POSTFIX.NEW_SQL, MoveDataDiffTest.class, settings);

        TestUtils.runDiffSame(dbOld, fileNameTemplate, settings);
        TestUtils.runDiffSame(dbNew, fileNameTemplate, settings);

        String script = new PgDiff(settings).diff(dbOld, dbNew, null);
        String content = script.replaceAll("([0-9a-fA-F]{32})", "randomly_generated_part");

        TestUtils.compareResult(content, fileNameTemplate, MoveDataDiffTest.class);
    }
}
