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
package ru.taximaxim.codekeeper.ui.dbstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ru.taximaxim.codekeeper.core.DatabaseType;

class DbInfoJdbcConnectorTest {

    @Mock
    DbInfo dbInfo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private String generateUrl(DatabaseType type, String dbName) {
        when(dbInfo.getDbType()).thenReturn(type);
        when(dbInfo.getDbHost()).thenReturn("testHost");
        when(dbInfo.getDbPort()).thenReturn(1000);
        when(dbInfo.getDbName()).thenReturn(dbName);

        return new DbInfoJdbcConnector(dbInfo).getUrl();
    }

    @Test
    void testGetUrlPg() {
        String result = generateUrl(DatabaseType.PG, "testDbName");

        assertEquals("jdbc:postgresql://testHost:1000/testDbName", result);
    }

    @Test
    void testGetUrlMsDbNameIsEscapable() {
        String result = generateUrl(DatabaseType.MS, "testDbName");

        assertEquals("jdbc:sqlserver://testHost:1000;databaseName={testDbName}", result);
    }

    @Test
    void testGetUrlMsDbNameIsNotEscapable() {
        String result = generateUrl(DatabaseType.MS, "testDbName}");

        assertEquals("jdbc:sqlserver://testHost:1000", result);
    }

    @Test
    void testGetUrlChDbNameIsNotNull() {
        String result = generateUrl(DatabaseType.CH, "testDbName");

        assertEquals("jdbc:clickhouse://testHost:1000/testDbName", result);
    }

    @Test
    void testGetUrlChDbNameIsNull() {
        String result = generateUrl(DatabaseType.CH, null);

        assertEquals("jdbc:clickhouse://testHost:1000", result);
    }
}
