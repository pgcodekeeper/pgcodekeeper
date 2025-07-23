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
package ru.taximaxim.codekeeper.core.depcies;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.settings.CoreSettings;

class ChDiffDepciesTest {

    private static Stream<Arguments> provideSelectedObjects() {
        return Stream.of(
                // test FUNCTION depcy
                Arguments.of("add_func_f1", "usr_function_1", Map.of("function_1", DbObjType.FUNCTION)),
                // test TABLE depcy
                Arguments.of("add_func_test_qual", "usr_test_qual", Map.of("test_qual", DbObjType.FUNCTION)),
                // test VIEW depcy
                Arguments.of("add_func_func_1", "usr_func_1", Map.of("func_1", DbObjType.FUNCTION)),
                // test scenario where user drop column. user choice TABLE
                Arguments.of("ch_policy_deps_change_table", "usr_t2",
                        Map.of("default-t2", DbObjType.TABLE, "pol1 ON default.t2", DbObjType.POLICY)),
                // test scenario where added USER with ROLE dep
                Arguments.of("ch_add_user_timon", "usr_timon", Map.of("timon", DbObjType.USER)),
                // test scenario where user change TABLE. VIEW dependency from TABLE. user
                // choice TABLE
                Arguments.of("ch_view_deps_change_table", "usr_t1", Map.of("default-t1_1", DbObjType.TABLE)),
                // test scenario where user remove COLUMN in TABLE. VIEW dependency from TABLE.
                // user choice TABLE
                Arguments.of("ch_view_deps_change_table", "usr_t3", Map.of("default-t3", DbObjType.TABLE)),
                // test scenario where user change TABLE. MATERIALIZED VIEW dependency from
                // TABLE. user choice TABLE
                Arguments.of("ch_view_deps_change_table", "usr_t4", Map.of("default-t4", DbObjType.TABLE)),
                // test scenario where user remove COLUMN in TABLE. MATERIALIZED VIEW dependency
                // from TABLE. user choice TABLE
                Arguments.of("ch_mat_view_deps_change_table", "usr_t1", Map.of("default-t1_1", DbObjType.TABLE)),
                // test scenario where user remove COLUMN in TABLE. VIEW dependency from TABLE.
                // user choice TABLE
                Arguments.of("ch_mat_view_deps_change_table", "usr_t3", Map.of("default-t3", DbObjType.TABLE))
                );
    }

    @ParameterizedTest
    @MethodSource("provideSelectedObjects")
    void testDepcy(final String dbTemplate, String userTemplateName, Map<String, DbObjType> selectedObjs)
            throws IOException, InterruptedException {
        var settings = new CoreSettings();
        settings.setDbType(DatabaseType.CH);
        settings.setEnableFunctionBodiesDependencies(true);
        TestUtils.testDepcy(dbTemplate, userTemplateName, selectedObjs, getClass(), settings);
    }
}