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

import ru.taximaxim.codekeeper.core.localizations.Messages;

public enum DatabaseType {
    PG("PostgreSQL"),
    MS("MS SQL"),
    CH("ClickHouse");

    private final String dbTypeName;

    private DatabaseType(String dbTypeName) {
        this.dbTypeName = dbTypeName;
    }

    public final String getDbTypeName() {
        return dbTypeName;
    }

    /**
     * Enums valuesOf method version with custom exception.
     *
     * @param dbTypeText
     *            - database name
     * @return DatabaseType for given name or {@link IllegalArgumentException}
     */
    public static final DatabaseType getValue(String dbTypeText) {
        for (DatabaseType t : values()) {
            if (t.name().equalsIgnoreCase(dbTypeText)) {
                return t;
            }
        }

        throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbTypeText);
    }
}