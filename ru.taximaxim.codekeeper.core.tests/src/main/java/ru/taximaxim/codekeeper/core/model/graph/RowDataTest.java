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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.taximaxim.codekeeper.core.DatabaseType;

public class RowDataTest {

    @Test
    void compareInsertScriptPG() {
        var expected = """
            INSERT INTO test.table (col1, col2, col3)
            VALUES (15, NULL, 'some String')
            ON CONFLICT DO NOTHING;

            """;

        var rowData = createRowData(Arrays.asList("col2"));
        rowData.addReplacement("col2");

        var sb = new StringBuilder();
        rowData.appendInsert(DatabaseType.PG, false, sb);

        assertEquals(expected, sb.toString());
    }

    @Test
    void compareInsertScriptMultiReplacementPG() {
        var expected = """
            INSERT INTO test.table (col1, col2, col3)
            VALUES (15, NULL, NULL)
            ON CONFLICT DO NOTHING;

            """;

        var rowData = createRowData(Arrays.asList("col2", "col3"));
        rowData.addReplacement("col2");
        rowData.addReplacement("col3");

        var sb = new StringBuilder();
        rowData.appendInsert(DatabaseType.PG, false, sb);

        assertEquals(expected, sb.toString());
    }

    @Test
    void compareInsertScriptPGWithIncrement() {
        var expected = """
            INSERT INTO test.table (col1, col2, col3)
            OVERRIDING SYSTEM VALUE
            VALUES (15, NULL, 'some String')
            ON CONFLICT DO NOTHING;

            """;

        var rowData = createRowData(Arrays.asList("col2"));
        rowData.addReplacement("col2");

        var sb = new StringBuilder();
        rowData.appendInsert(DatabaseType.PG, true, sb);
        assertEquals(expected, sb.toString());
    }

    @Test
    void compareUpdateScriptPG() {
        var expected = "UPDATE test.table SET col2 = 439 WHERE col1 = 15;\n\n";
        var rowData = createRowData(Arrays.asList("col2"));
        rowData.addReplacement("col2");

        var sb = new StringBuilder();
        rowData.appendUpdate(DatabaseType.PG, sb);

        assertEquals(expected, sb.toString());
    }

    @Test
    void compareUpdateScriptMultiReplacementPG() {
        var expected = "UPDATE test.table SET col2 = 439, col3 = 'some String' WHERE col1 = 15;\n\n";
        var rowData = createRowData(Arrays.asList("col2", "col3"));
        rowData.addReplacement("col2");
        rowData.addReplacement("col3");

        var sb = new StringBuilder();
        rowData.appendUpdate(DatabaseType.PG, sb);

        assertEquals(expected, sb.toString());
    }

    @Test
    void compareUpdateScriptPGWhitoutFkCol() {
        var rowData = createRowData(Collections.emptyList());
        var sb = new StringBuilder();
        rowData.appendUpdate(DatabaseType.PG, sb);

        assertEquals("", sb.toString());
    }

    @Test
    void compareInsertScriptMS() {
        var expected = """
            INSERT INTO test.table (col1, col2, col3)
            SELECT 15, NULL, 'some String'
            WHERE NOT EXISTS (SELECT 1 FROM test.table WHERE (col1 = 15));
            GO

            """;

        var rowData = createRowData(Arrays.asList("col2"));
        rowData.addReplacement("col2");

        var sb = new StringBuilder();
        rowData.appendInsert(DatabaseType.MS, false, sb);

        assertEquals(expected, sb.toString());
    }

    @Test
    void compareInsertScriptMultiReplacementMS() {
        var expected = """
            INSERT INTO test.table (col1, col2, col3)
            SELECT 15, NULL, NULL
            WHERE NOT EXISTS (SELECT 1 FROM test.table WHERE (col1 = 15));
            GO

            """;

        var rowData = createRowData(Arrays.asList("col2", "col3"));
        rowData.addReplacement("col2");
        rowData.addReplacement("col3");

        var sb = new StringBuilder();
        rowData.appendInsert(DatabaseType.MS, false, sb);

        assertEquals(expected, sb.toString());
    }

    @Test
    void compareInsertScriptMSWithIncrement() {
        var expected = """
            SET IDENTITY_INSERT test.table ON;
            GO

            INSERT INTO test.table (col1, col2, col3)
            SELECT 15, NULL, 'some String'
            WHERE NOT EXISTS (SELECT 1 FROM test.table WHERE (col1 = 15));
            GO

            SET IDENTITY_INSERT test.table OFF;
            GO

            """;

        var rowData = createRowData(Arrays.asList("col2"));
        rowData.addReplacement("col2");

        var sb = new StringBuilder();
        rowData.appendInsert(DatabaseType.MS, true, sb);

        assertEquals(expected, sb.toString());
    }

    @Test
    void compareUpdateScriptMS() {
        var expected = "UPDATE test.table SET col2 = 439 WHERE col1 = 15;\nGO\n\n";
        var rowData = createRowData(Arrays.asList("col2"));

        rowData.addReplacement("col2");

        var sb = new StringBuilder();
        rowData.appendUpdate(DatabaseType.MS, sb);

        assertEquals(expected, sb.toString());
    }

    @Test
    void compareUpdateScriptMultiReplacementMS() {
        var expected = "UPDATE test.table SET col2 = 439, col3 = 'some String' WHERE col1 = 15;\nGO\n\n";
        var rowData = createRowData(Arrays.asList("col2", "col3"));

        rowData.addReplacement("col2");
        rowData.addReplacement("col3");

        var sb = new StringBuilder();
        rowData.appendUpdate(DatabaseType.MS, sb);

        assertEquals(expected, sb.toString());
    }

    @Test
    void compareUpdateScriptMSWhitoutFkCol() {
        var rowData = createRowData(Collections.emptyList());

        var sb = new StringBuilder();
        rowData.appendUpdate(DatabaseType.MS, sb);

        assertEquals("", sb.toString());
    }

    @Test
    void compareFilterGroupCols() {
        var expected = "ID = 15 AND testCol = 439";
        var rowData = createRowData(Arrays.asList("col2"));
        assertEquals(expected,
                rowData.generateFilter(new String[] { "ID", "testCol" }, new String[] { "col1", "col2" }));
    }

    @Test
    void compareFilterSimpleCol() {
        var expected = "ID = 15";
        var rowData = createRowData(Arrays.asList("col2"));
        assertEquals(expected, rowData.generateFilter(new String[] { "ID" }, new String[] { "col1" }));
    }

    @Test
    void compareFilterWithoutDataInRecord() {
        var rowData = createRowData(Arrays.asList("col2"));
        Assertions.assertNull(rowData.generateFilter(new String[] { "ID" }, new String[] { "col5" }));
    }

    private RowData createRowData(List<String> pkCols) {
        String name = "test.table";
        List<String> fkCols = Arrays.asList("col1");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("col1", "15");
        map.put("col2", "439");
        map.put("col3", "'some String'");
        return new RowData(name, null, map, pkCols, fkCols);
    }
}