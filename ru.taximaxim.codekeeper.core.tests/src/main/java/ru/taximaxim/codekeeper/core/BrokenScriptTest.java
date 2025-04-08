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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ru.taximaxim.codekeeper.core.loader.PgDumpLoader;
import ru.taximaxim.codekeeper.core.settings.CliSettings;

class BrokenScriptTest {

    @ParameterizedTest
    @CsvSource({
            "broken_duplicated_schema, line 3:1 SCHEMA test already exists",
            "broken_duplicated_index, line 5:1 INDEX i already exists for TABLE t1"
    })
    void testPgBrokenScript(String fileNameTemplate, String expectedError) throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();

        String resource = fileNameTemplate + FILES_POSTFIX.SQL;
        PgDumpLoader loader = new PgDumpLoader(() -> getClass().getResourceAsStream(resource), resource,
                new CliSettings(args));
        loader.loadAndAnalyze();
        var errors = loader.getErrors();

        Assertions.assertEquals(1, errors.size());

        String actualError = errors.get(0).toString();

        if (!actualError.endsWith(expectedError)) {
            Assertions.assertEquals(expectedError, actualError);
        }
    }
}
