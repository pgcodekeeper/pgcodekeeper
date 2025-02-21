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

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.TestUtils;

/**
 * Тестирует сравнение БД с неполным выбором различающихся объектов
 * @author botov_av
 */
class MsDiffDepciesTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "empty_usr",
            // t1 <- v1 <- v2 <- v3 <- v4
            // changed: t1, v1, v2, v4
            // user: t1
            "change_ms_table_usr_t1",
            // пользователь изменил constraintPk
            // пользователь выбрал только таблицу с измененным constraintPk
            "change_ms_constrPk_usr",
            // changed: t1, stat1, stat2
            // user: t1
            "change_ms_table_with_stat_usr",
            "drop_ms_sys_ver_table_usr_hist_t1",
    })
    void testDepcy(String userSelTemplate) throws IOException, InterruptedException {
        testDepcy(userSelTemplate, false);
    }

    @ParameterizedTest
    @CsvSource({
        // f1 <- f2
        // added: f1, f2
        // user: f2
        "add_ms_func_exec_usr_f2, true",
        // p1 <- f2
        // added: p1, f2
        // user: f2
        "add_ms_proc_exec_usr_f2, true",
        // f1 <- f2 <- f3
        // changed: f1, f2, f3
        // user: f2
        "change_ms_func_arg_usr_f2, true",
    })
    void testDepcy(String userSelTemplate, Boolean isEnableDepcies) throws IOException, InterruptedException {
        TestUtils.testDepcy(userSelTemplate, isEnableDepcies, DatabaseType.MS, getClass());
    }
}
