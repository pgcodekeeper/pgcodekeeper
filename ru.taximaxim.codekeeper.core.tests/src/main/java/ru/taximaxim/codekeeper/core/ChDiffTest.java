/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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

class ChDiffTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "add_ch_view",
            "drop_ch_view",
            "alter_ch_view",
            // Test scenario where DATABASEs is added
            "add_ch_database",
            // Test scenario where DATABASEs compare and haven't different
            "compare_ch_database_without_diffs",
            // Test scenario where DATABASEs compare with different
            "change_ch_database",
            // Test scenario where DATABASE is dropped
            "drop_ch_database",
            // Test scenario where TABLEs is added
            "add_ch_tables_engine_merge_tree",
            // Test scenario where TABLEs compare and haven't different
            "compare_ch_engine_no_diffs",
            // Test scenario where TABLE is dropped
            "drop_ch_table",
            // Test scenario where COLUMNs added at TABLE
            "add_ch_columns_at_table",
            // Test scenario where TABLEs COLUMNs altered
            "alter_ch_columns_at_table",
            // Test scenario where COLUMN dropped at TABLE
            "drop_ch_column_at_table",
            // Test scenario where TABLE altered
            "alter_ch_table",
            // Test scenario where engine options altered at TABLE
            "alter_ch_table_engine",
            // uncovereged cases for TABLE with diffs
            // "ch_table_uncovereged_cases_with_diffs",
            // uncovereged cases for TABLE without diffs
            // "ch_table_uncovereged_cases_without_diffs",
            // uncovereged cases for VIEW with diffs
            // "ch_view_uncovereged_cases_with_diffs_original",
            //Test scenario where FUNCTION is added
            "add_ch_function",
            //Test scenario where FUNCTIONs are compared
            "compare_ch_function",
            //Test scenario where FUNCTION is dropped
            "drop_ch_function",
            // Test scenario where POLICY is added
            "add_ch_policy",
            // Test scenario where POLICY is dropped
            "drop_ch_policy",
            // Test scenario where POLICY is changed
            "change_ch_policy",
            //Test scenario where USER is added
            "add_ch_user",
            //Test scenario where USER is compared
            "compare_ch_user",
            //Test scenario where USER is dropped
            "drop_ch_user",
            //Test scenario where ROLE is added
            "add_ch_role",
            //Test scenario where ROLE is compared
            "compare_ch_role",
            //Test scenario where ROLE is dropped
            "drop_ch_role",
            // Test scenario where DICTIONARY added
            "add_ch_dictionary",
            // Test scenario where DICTIONARY changed
            "change_ch_dictionary",
            // Test scenario where DICTIONARY dropped
            "drop_ch_dictionary",
            //Test scenario where PRIVILLEGIES are added
            "add_ch_privilegies",
            //Test scenario where PRIVILLEGIES are revoke
            "revoke_ch_privilegies",
            //Test scenario where PRIVILLEGIES compared
            "compare_ch_privilegies"
    })
    void runDiff(String fileNameTemplate) throws IOException, InterruptedException {
        TestUtils.runDiff(fileNameTemplate, DatabaseType.CH, ChDiffTest.class);
    }

    /**
     * test case when ignore privillegies option enable
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "ch_ignore_privillegies"
    })
    void testIgnorePrivillegies(String fileNameTemplate) throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setIgnorePrivileges(true);
        args.setDbType(DatabaseType.CH);
        String script = TestUtils.getScript(fileNameTemplate, args, ChDiffTest.class);
        TestUtils.compareResult(script, fileNameTemplate, ChDiffTest.class);
    }
}
