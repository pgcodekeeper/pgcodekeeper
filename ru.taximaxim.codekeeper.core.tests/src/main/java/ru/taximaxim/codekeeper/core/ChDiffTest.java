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
            // Test scenario where DATABASEs is added
            "add_ch_database",
            // Test scenario where DATABASEs compare and haven't different
            "compare_ch_database_without_diffs",
            // Test scenario where DATABASEs compare with different
            "change_ch_database",
            // Test scenario where DATABASE is dropped
            "drop_ch_database" })
    void runDiff(String fileNameTemplate) throws IOException, InterruptedException {
        TestUtils.runDiff(fileNameTemplate, DatabaseType.CH, ChDiffTest.class);
    }
}