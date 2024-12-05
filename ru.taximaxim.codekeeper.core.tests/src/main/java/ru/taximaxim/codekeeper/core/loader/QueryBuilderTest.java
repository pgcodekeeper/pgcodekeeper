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

        String expected = """
                SELECT
                  c1,
                  c2,
                  c3,
                  c4""";

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

        String expected = """
                WITH cols AS (select c1, c2 from public.t1)
                SELECT
                  c1,
                  c2
                FROM cols""";

        assertEquals(expected, actual);
    }

    @Test
    void testWhere() {
        String actual = new QueryBuilder()
                .from("public.t1")
                .where("c1 > 0")
                .where("c2 IS NOT NULL")
                .build();

        String expected = """
                SELECT
                 \s
                FROM public.t1 
                WHERE c1 > 0
                  AND c2 IS NOT NULL""";

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

        String expected = """
                SELECT
                  c1
                FROM public.t1
                LEFT JOIN public.t2 t2 ON t2.c1 = t1.c2
                LEFT JOIN public.t3 t3 ON t3.c1 = t1.c3""";

        assertEquals(expected, actual);
    }

    @Test
    void testGroupBy() {
        String actual = new QueryBuilder()
                .column("c1")
                .from("public.t1")
                .groupBy("col1")
                .groupBy("col2")
                .build();

        String expected = """
                SELECT
                  c1
                FROM public.t1
                GROUP BY col1, col2""";

        assertEquals(expected, actual);
    }

    @Test
    void testPostAction() {
        String actual = new QueryBuilder()
                .column("c1")
                .from("public.t1")
                .postAction("FOR XML RAW, ROOT")
                .build();

        String expected = """
                SELECT
                  c1
                FROM public.t1
                FOR XML RAW, ROOT""";

        assertEquals(expected, actual);
    }

    @Test
    void testColumnWithSubselect() {

        QueryBuilder subSelect = new QueryBuilder()
                .column("film_name")
                .from("film_category");

        String actual = new QueryBuilder()
                .column("film_id")
                .column("", subSelect, "AS tokennames")
                .column("pg_catalog.array_agg(", subSelect, "ORDER BY m.mapseqno) AS tokennames")
                .column("film_name")
                .from("film")
                .build();

        String expected = """
                SELECT
                  film_id,
                  (
                    SELECT
                      film_name
                    FROM film_category
                  ) AS tokennames,
                  pg_catalog.array_agg( (
                    SELECT
                      film_name
                    FROM film_category
                  ) ORDER BY m.mapseqno) AS tokennames,
                  film_name
                FROM film""";

        assertEquals(expected, actual);
    }

    @Test
    void testWhereWithSubselect() {

        QueryBuilder subSelect = new QueryBuilder()
                .column("film_id")
                .from("film_category")
                .join("INNER JOIN category USING(category_id)")
                .where("name = 'Action'");

        String actual = new QueryBuilder()
                .column("film_id")
                .column("title")
                .from("film")
                .where("film_id IN", subSelect)
                .build();

        String expected = """
                SELECT
                  film_id,
                  title
                FROM film
                WHERE film_id IN (
                  SELECT
                    film_id
                  FROM film_category
                  INNER JOIN category USING(category_id)
                  WHERE name = 'Action'
                )""";

        assertEquals(expected, actual);
    }

    @Test
    void testFromWithSubselect() {

        QueryBuilder subSelect = new QueryBuilder()
                .column("day_of_week")
                .column("date")
                .column("COUNT(incidnt_num) AS incidents")
                .from("tutorial.sf_crime_incidents_2014_01");

        String actual = new QueryBuilder()
                .column("LEFT(sub.date, 2) AS cleaned_month")
                .column("sub.day_of_week")
                .column("AVG(sub.incidents) AS average_incidents")
                .from(subSelect, "sub")
                .build();

        String expected = """
                SELECT
                  LEFT(sub.date, 2) AS cleaned_month,
                  sub.day_of_week,
                  AVG(sub.incidents) AS average_incidents
                FROM (
                  SELECT
                    day_of_week,
                    date,
                    COUNT(incidnt_num) AS incidents
                  FROM tutorial.sf_crime_incidents_2014_01
                ) sub""";

        assertEquals(expected, actual);
    }

    @Test
    void testJoinWithSubselect() {
        QueryBuilder subSelect = new QueryBuilder()
                .column("id")
                .column("date")
                .from("test.t3");

        String actual = new QueryBuilder()
                .column("t.*")
                .column("sub.date AS date")
                .from("public.t2 t")
                .join("JOIN", subSelect, "sub ON t.id_foreign = sub.id")
                .build();

        String expected = """
                SELECT
                  t.*,
                  sub.date AS date
                FROM public.t2 t
                JOIN (
                  SELECT
                    id,
                    date
                  FROM test.t3
                ) sub ON t.id_foreign = sub.id""";

        assertEquals(expected, actual);
    }

    @Test
    void testWithWithSubselect() {

        QueryBuilder subSelect = new QueryBuilder()
                .column("date")
                .from("tutorial.sf_crime_incidents_2014_01");

        String actual = new QueryBuilder()
                .column("incidents.*")
                .from("tutorial.sf_crime_incidents_2014_01 incidents")
                .with("cols", subSelect)
                .build();

        String expected = """
                WITH cols AS (
                  SELECT
                    date
                  FROM tutorial.sf_crime_incidents_2014_01
                )
                SELECT
                  incidents.*
                FROM tutorial.sf_crime_incidents_2014_01 incidents""";

        assertEquals(expected, actual);
    }

    @Test
    void testMultipleSubselects() {
        QueryBuilder subSubSelect = new QueryBuilder()
                .column("time")
                .from("tutorial.sf_crime_incidents_2014_01");

        QueryBuilder subSelect = new QueryBuilder()
                .column("date")
                .join("JOIN LEFT", subSubSelect, "subsubselect")
                .join("JOIN LEFT", subSubSelect, "subsubselect");

        String actual = new QueryBuilder()
                .column("incidents.*")
                .column("sub.incidents AS incidents_that_day")
                .from(subSubSelect, "AS subsubselect")
                .join("JOIN", subSelect, "subselect")
                .build();

        String expected = """
                SELECT
                  incidents.*,
                  sub.incidents AS incidents_that_day
                FROM (
                  SELECT
                    time
                  FROM tutorial.sf_crime_incidents_2014_01
                ) AS subsubselect
                JOIN (
                  SELECT
                    date
                  JOIN LEFT (
                    SELECT
                      time
                    FROM tutorial.sf_crime_incidents_2014_01
                  ) subsubselect
                  JOIN LEFT (
                    SELECT
                      time
                    FROM tutorial.sf_crime_incidents_2014_01
                  ) subsubselect
                ) subselect""";

        assertEquals(expected, actual);
    }

    @Test
    void testLargeQueryWithSubselects() {
        String expected = """
                  SELECT
                    *
                  FROM (
                    SELECT
                      si.name,
                      si.is_primary_key AS pk,
                      si.is_unique_constraint AS uc,
                      si.ignore_dup_key AS dk,
                      INDEXPROPERTY(si.object_id, si.name, 'IsClustered') AS cl,
                      hi.bucket_count AS bc,
                      ccc.cols,
                      si.filter_definition AS def
                    FROM sys.indexes AS si WITH (NOLOCK)
                    LEFT JOIN sys.objects o WITH (NOLOCK) ON si.object_id = o.object_id
                    LEFT JOIN sys.hash_indexes hi WITH (NOLOCK) ON hi.object_id = si.object_id AND hi.index_id = si.index_id
                    CROSS APPLY (
                      SELECT
                        *
                      FROM (
                        SELECT
                          c.index_column_id AS id,
                          sc.name,
                          c.is_descending_key AS is_desc
                        FROM sys.index_columns c WITH (NOLOCK)
                        JOIN sys.columns sc WITH (NOLOCK) ON c.object_id = sc.object_id AND c.column_id = sc.column_id
                        WHERE c.object_id = si.object_id
                          AND c.index_id = si.index_id
                      ) cc ORDER BY cc.id
                      FOR XML RAW, ROOT
                    ) ccc (cols)
                    WHERE si.object_id=ttt.type_table_object_id
                      AND si.index_id > 0
                      AND si.is_hypothetical = 0
                  ) ii
                  FOR XML RAW, ROOT""";

        QueryBuilder subSubSubSelect = new QueryBuilder()
                .column("c.index_column_id AS id")
                .column("sc.name")
                .column("c.is_descending_key AS is_desc")
                .from("sys.index_columns c WITH (NOLOCK)")
                .join("JOIN sys.columns sc WITH (NOLOCK) ON c.object_id = sc.object_id AND c.column_id = sc.column_id")
                .where("c.object_id = si.object_id")
                .where("c.index_id = si.index_id");

        QueryBuilder subSubSelect = new QueryBuilder()
                .column("*")
                .from(subSubSubSelect, "cc ORDER BY cc.id")
                .postAction("FOR XML RAW, ROOT");

        QueryBuilder subSelect = new QueryBuilder()
                .column("si.name")
                .column("si.is_primary_key AS pk")
                .column("si.is_unique_constraint AS uc")
                .column("si.ignore_dup_key AS dk")
                .column("INDEXPROPERTY(si.object_id, si.name, 'IsClustered') AS cl")
                .column("hi.bucket_count AS bc")
                .column("ccc.cols")
                .column("si.filter_definition AS def")
                .from("sys.indexes AS si WITH (NOLOCK)")
                .join("LEFT JOIN sys.objects o WITH (NOLOCK) ON si.object_id = o.object_id")
                .join("LEFT JOIN sys.hash_indexes hi WITH (NOLOCK) ON hi.object_id = si.object_id AND hi.index_id = si.index_id")
                .join("CROSS APPLY", subSubSelect, "ccc (cols)")
                .where("si.object_id=ttt.type_table_object_id")
                .where("si.index_id > 0")
                .where("si.is_hypothetical = 0");

        String actual = new QueryBuilder()
                .column("*")
                .from(subSelect, "ii")
                .postAction("FOR XML RAW, ROOT")
                .build();

        assertEquals(expected, actual);
    }

    @Test
    void testCopy() {
        QueryBuilder subselect = new QueryBuilder()
                .column("date")
                .from("tutorial.sf_crime_incidents_2014_01");

        QueryBuilder actualBuilder = new QueryBuilder()
                .column("incidents.*")
                .from("tutorial.sf_crime_incidents_2014_01 incidents")
                .with("cols", subselect);
        String actual = actualBuilder.build();

        String expected = actualBuilder.copy().build();

        assertEquals(expected, actual);
    }
}
