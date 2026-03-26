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

import org.pgcodekeeper.core.database.api.schema.IStatement;
import org.pgcodekeeper.core.database.ch.schema.ChAbstractStatement;
import org.pgcodekeeper.core.database.ms.schema.MsAbstractStatement;
import org.pgcodekeeper.core.database.pg.schema.PgAbstractStatement;

import ru.taximaxim.codekeeper.ui.database.base.IUiDatabaseProvider;
import ru.taximaxim.codekeeper.ui.database.ch.ChUiDatabaseProvider;
import ru.taximaxim.codekeeper.ui.database.ms.MsUiDatabaseProvider;
import ru.taximaxim.codekeeper.ui.database.pg.PgUiDatabaseProvider;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public enum DatabaseType {

    PG(new PgUiDatabaseProvider()),
    MS(new MsUiDatabaseProvider()),
    CH(new ChUiDatabaseProvider());

    private final IUiDatabaseProvider databaseProvider;

    DatabaseType(IUiDatabaseProvider databaseProvider) {
        this.databaseProvider = databaseProvider;
    }

    public String getDbTypeName() {
        return databaseProvider.getFullName();
    }

    public IUiDatabaseProvider getDatabaseProvider() {
        return databaseProvider;
    }

    /**
     * Enums valuesOf method version with custom exception.
     *
     * @param dbTypeText database name
     * @return DatabaseType for given name
     * @throws IllegalArgumentException if provided database is not supported
     */
    public static DatabaseType getValue(String dbTypeText) {
        for (DatabaseType t : values()) {
            if (t.name().equalsIgnoreCase(dbTypeText)) {
                return t;
            }
        }

        throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type.formatted(dbTypeText));
    }

    public static DatabaseType fromStatement(IStatement st) {
        // FIXME temporary solution
        if (st instanceof PgAbstractStatement) {
            return PG;
        }
        if (st instanceof MsAbstractStatement) {
            return MS;
        }
        if (st instanceof ChAbstractStatement) {
            return CH;
        }

        throw new IllegalArgumentException(Messages.DatabaseType_unsupported_class.formatted(st.getClass()));
    }

}
