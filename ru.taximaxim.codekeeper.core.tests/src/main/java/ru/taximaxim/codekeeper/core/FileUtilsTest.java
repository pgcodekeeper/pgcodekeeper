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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ru.taximaxim.codekeeper.core.fileutils.FileUtils;

public final class FileUtilsTest {

    @ParameterizedTest
    @CsvSource({
            "jdbc:sqlserver://127.0.0.1;databaseName={master};integratedSecurity=true, master",
            "jdbc:sqlserver://127.0.0.1;databaseName=master;integratedSecurity=true, master",
            "jdbc:postgresql://127.0.0.1:5432/test_1?user=test&arg=test, test_1",
            "jdbc:jkslauef/sdaf:135/test12&user=userName&arg2=pas{s,"
    })
    void testGetDbNameFromMsUrl(String url, String expected) {
        if (expected == null) {
            expected = "";
        }
        Assertions.assertEquals(expected, FileUtils.dbNameFromUrl(url));
    }
}