/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.pgcodekeeper.core.database.api.schema.DbObjType;
import org.pgcodekeeper.core.database.api.schema.ObjectReference;
import org.pgcodekeeper.core.database.base.schema.meta.MetaStatement;
import org.pgcodekeeper.core.database.ch.schema.ChTable;
import org.pgcodekeeper.core.database.ms.schema.MsTable;
import org.pgcodekeeper.core.database.pg.schema.PgSimpleTable;

class DatabaseTypeTest {

    @Test
    void fromStatementTest() {
        assertEquals(DatabaseType.PG, DatabaseType.fromStatement(new PgSimpleTable("test")));
        assertEquals(DatabaseType.MS, DatabaseType.fromStatement(new MsTable("test")));
        assertEquals(DatabaseType.CH, DatabaseType.fromStatement(new ChTable("test")));
        assertThrows(IllegalArgumentException.class,
                () -> DatabaseType.fromStatement(new MetaStatement(new ObjectReference("test", DbObjType.TABLE))));
    }

    @Test
    void getValue() {
        assertEquals(DatabaseType.PG, DatabaseType.getValue("PG"));
        assertEquals(DatabaseType.MS, DatabaseType.getValue("Ms"));
        assertEquals(DatabaseType.CH, DatabaseType.getValue("cH"));
        assertThrows(IllegalArgumentException.class, () -> DatabaseType.getValue("gp"));
    }
}