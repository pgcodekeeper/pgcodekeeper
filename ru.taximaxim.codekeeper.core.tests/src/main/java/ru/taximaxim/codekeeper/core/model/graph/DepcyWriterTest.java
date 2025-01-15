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
package ru.taximaxim.codekeeper.core.model.graph;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.FILES_POSTFIX;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;

public class DepcyWriterTest {

    @ParameterizedTest
    @CsvSource({
            "ch_view, default.revenue0",
            "ch_view_2, default.TestView",
            "ch_view_3, default.goal_view",
            "ch_view_4, default.view_join_inner_table",
            "ch_view_5, default.view_aaa_bbb",
            "ch_view_6, default.view_columns_transformers",
            "ch_view_7, default.ch_view_7",
            // test analysis work on merge statement
            "function_merge, public.f1",
            // test analysis work on window statement
            "ms_view_window, dbo.v1",
            // "ms_insert_name, public.sales5",
            "ms_procedure, \\[dbo\\].\\[test_poc\\]",
            // same test searching deps of object by name without quotes for MS
            "ms_procedure, dbo.test_poc",
            "ch_dictionary, default.dict",
            // test searching deps of object by name without quotes and case insensitive mode for MS
            "ms_UPPER_CASE, dbo.TEST_POC",
            "view, public.v1",
    })
    void compareReverseGraph(String fileName, String objectName) throws IOException, InterruptedException {
        compareGraph(fileName, FILES_POSTFIX.DEPS_REVERSE_TXT, objectName, true);
    }

    @ParameterizedTest
    @CsvSource({
        "table, public.t1",
        "regex, public\\.t.",
        //test searching deps of object "MyTable" by name without quotes and case insensitive mode for PG
        "quotes, public.mytable",
        //test searching deps of object "MyTable" by name with quotes for PG
        "quotes, public.\"mytable\"",
        // test searching deps of function by full name
        "function_circle, public.f1\\(\\)",
        //test searching deps of function by name with regex for PG
        "function_circle, 'public\\.f1\\(.*'",
        //test searching deps of function by name without parens for PG
        "function_circle, 'public\\.f1'",
        //test searching deps of function by name with quotes and without parens for PG
        "function_circle_quotes, 'public\\.\"Func1\"\\(.*'",
        //test searching deps of quoted function by name without quotes and parens for PG
        "function_circle_quotes, 'public\\.func1'",
        //test searching deps of table with system versioning
        "ms_sys_ver_table, '\\[dbo\\]\\.\\[t1\\]'",
    })
    void compareBothGraph(String fileName, String objectName) throws IOException, InterruptedException {
        compareGraph(fileName, FILES_POSTFIX.DEPS_TXT, objectName, false);
        compareGraph(fileName, FILES_POSTFIX.DEPS_REVERSE_TXT, objectName, true);
    }

    void compareGraph(String fileName, FILES_POSTFIX expectedPostfix, String objectName, boolean isReverse)
            throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        if (fileName.startsWith("ms_")) {
            args.setDbType(DatabaseType.MS);
        } else if (fileName.startsWith("ch_")) {
            args.setDbType(DatabaseType.CH);
        }
        args.setEnableFunctionBodiesDependencies(true);

        AbstractDatabase db = TestUtils.loadTestDump(fileName + FILES_POSTFIX.SQL, getClass(), args);

        var deps = DepcyFinder.byPatterns(10, isReverse, Collections.emptyList(), false, db, List.of(objectName));
        String actual = String.join("\n", deps);
        String expected = TestUtils.readResource(fileName + expectedPostfix, getClass());

        Assertions.assertEquals(expected.trim(), actual);
    }
}
