/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.loader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class QueryBuilderTest {

    @Test
    void testColumns() {
        String actual = new QueryBuilder()
                .column("c1")
                .column("c2")
                .column("c3")
                .column("c4")
                .build();

        String expected = "SELECT\n"
                + "  c1,\n"
                + "  c2,\n"
                + "  c3,\n"
                + "  c4";

        assertEquals(expected, actual);
    }

    @Test
    void testWith() {
        String actual = new QueryBuilder()
                .with("cols", "select c1, c2 from public.t1")
                .column("c1")
                .column("c2")
                .from("cols")
                .build();

        String expected = "WITH cols AS (select c1, c2 from public.t1)\n"
                + "SELECT\n"
                + "  c1,\n"
                + "  c2\n"
                + "FROM cols";

        assertEquals(expected, actual);
    }

    @Test
    void testWhere() {
        String actual = new QueryBuilder()
                .from("public.t1")
                .where("c1 > 0")
                .where("c2 IS NOT NULL")
                .build();

        String expected = "SELECT\n"
                + "  \n"
                + "FROM public.t1\n"
                + "WHERE c1 > 0\n"
                + " AND c2 IS NOT NULL";

        assertEquals(expected, actual);
    }

    @Test
    void testJoin() {
        String actual = new QueryBuilder()
                .column("c1")
                .from("public.t1")
                .join("LEFT JOIN public.t2 t2 ON t2.c1 = t1.c2")
                .join("LEFT JOIN public.t3 t3 ON t3.c1 = t1.c3")
                .build();

        String expected = "SELECT\n"
                + "  c1\n"
                + "FROM public.t1\n"
                + "LEFT JOIN public.t2 t2 ON t2.c1 = t1.c2\n"
                + "LEFT JOIN public.t3 t3 ON t3.c1 = t1.c3";

        assertEquals(expected, actual);
    }

}
