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
package ru.taximaxim.codekeeper.core.model.graph;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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
        "table, public.t1",
        "regex, public\\.t.",
        "view, public.v1",
        "ms_procedure, \\[dbo\\].\\[test_poc\\]",
        "function_circle, public.f1\\(\\)",
        "ch_dictionary, default.dict",
        "ch_view, default.revenue0",
        "ch_view_2, default.TestView",
        "ch_view_3, default.goal_view",
        "ch_view_4, default.view_join_inner_table",
        "ch_view_5, default.view_aaa_bbb",
        "ch_view_6, default.view_columns_transformers",
        "ch_view_7, default.ch_view_7"
    })
    void compareGraph(String fileName, String objectName) throws IOException, InterruptedException {
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

        StringWriter out = new StringWriter();
        PrintWriter writer = new PrintWriter(out);

        new DepcyWriter(db, 10, writer, isReverse, Collections.emptyList(), false).write(List.of(objectName));
        writer.flush();

        String expected = TestUtils.readResource(fileName + expectedPostfix, getClass());

        Assertions.assertEquals(expected.trim(), out.toString().trim());
    }
}
