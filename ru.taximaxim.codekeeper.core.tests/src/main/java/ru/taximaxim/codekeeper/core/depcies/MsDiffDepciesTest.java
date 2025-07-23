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
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.settings.CoreSettings;

/**
 * Тестирует сравнение БД с неполным выбором различающихся объектов
 * @author botov_av
 */
class MsDiffDepciesTest {

    private static Stream<Arguments> provideSelectedObjects() {
        return Stream.of(
                Arguments.of("empty", null, Collections.emptyMap()),
                // t1 <- v1 <- v2 <- v3 <- v4
                // changed: t1, v1, v2, v4
                // user: t1
                Arguments.of("change_ms_table", "usr_t1", Map.of("dbo-t1", DbObjType.TABLE)),
                // пользователь изменил constraintPk
                // пользователь выбрал только таблицу с измененным constraintPk
                Arguments.of("change_ms_constrPk", "usr_pkey",
                        Map.of("dbo-Employee-Employee_EmployeeID_pkey", DbObjType.CONSTRAINT)),
                // changed: t1, stat1, stat2
                // user: t1
                Arguments.of("change_ms_table_with_stat", "usr_t1", Map.of("dbo-t1", DbObjType.TABLE)),
                Arguments.of("drop_ms_sys_ver_table", "usr_hist_t1", Map.of("dbo-hist_t1", DbObjType.TABLE)),
                // Test case where in table name in wrong case
                Arguments.of("create_ms_view", "usr_v1", Map.of("dbo-v1", DbObjType.VIEW))
        );
    }

    @ParameterizedTest
    @MethodSource("provideSelectedObjects")
    void testDepcy(final String dbTemplate, String userTemplateName, Map<String, DbObjType> selectedObjs)
            throws IOException, InterruptedException {
        var settings = new CoreSettings();
        settings.setDbType(DatabaseType.MS);
        TestUtils.testDepcy(dbTemplate, userTemplateName, selectedObjs, getClass(), settings);
    }

    private static Stream<Arguments> provideSelectedObjectsWithFunctionBody() {
        return Stream.of(
                // f1 <- f2
                // added: f1, f2
                // user: f2
                Arguments.of("add_ms_func_exec", "usr_f2", Map.of("dbo-f2", DbObjType.FUNCTION)),
                // p1 <- f2
                // added: p1, f2
                // user: f2
                Arguments.of("add_ms_proc_exec", "usr_f2", Map.of("dbo-f2", DbObjType.FUNCTION)),
                // f1 <- f2 <- f3
                // changed: f1, f2, f3
                // user: f2
                Arguments.of("change_ms_func_arg", "usr_f2", Map.of("dbo-f2", DbObjType.FUNCTION))
                );
    }

    @ParameterizedTest
    @MethodSource("provideSelectedObjectsWithFunctionBody")
    void testDepcyWithFunctionBody(final String dbTemplate, String userTemplateName,
            Map<String, DbObjType> selectedObjs) throws IOException, InterruptedException {
        var settings = new CoreSettings();
        settings.setDbType(DatabaseType.MS);
        settings.setEnableFunctionBodiesDependencies(true);
        TestUtils.testDepcy(dbTemplate, userTemplateName, selectedObjs, getClass(), settings);
    }
}
