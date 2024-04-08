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
package ru.taximaxim.codekeeper.core.depcies;

import java.io.IOException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.TestUtils;

class ChDiffDepciesTest {

    @ParameterizedTest
    @ValueSource(strings = {
            // test FUNCTION depcy
            "add_func_f1_usr_func_f2",
            // test TABLE depcy
            "add_func_test_qual_usr_t2",
            // test VIEW depcy
            "add_func_func_1_usr_v1",
    })
    void runDiffWithFunctionDependencies(final String userSelTemplate) throws IOException, InterruptedException {
        TestUtils.testDepcy(userSelTemplate, true, DatabaseType.CH, getClass());
    }
}