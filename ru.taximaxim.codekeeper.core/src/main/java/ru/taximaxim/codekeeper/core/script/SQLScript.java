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
package ru.taximaxim.codekeeper.core.script;

import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.localizations.Messages;

public class SQLScript {

    private static final String PG_SEPARATOR = ";";
    private static final String MS_SEPARATOR = "\nGO";

    private static final String DELIMITER = "\n\n";

    private final Map<SQLActionType, Set<String>> statements = new EnumMap<>(SQLActionType.class);

    private final DatabaseType databaseType;

    private int count;

    public SQLScript(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }

    public void addStatement(StringBuilder sb) {
        addStatement(sb.toString());
    }

    public void addStatement(String sql) {
        addStatement(sql, SQLActionType.MID);
    }

    public void addStatement(String sql, SQLActionType actionType) {
        addStatement(sql, actionType, true);
    }

    public void addStatementWithoutSeparator(String sql) {
        addStatementWithoutSeparator(sql, SQLActionType.MID);
    }

    public void addStatementWithoutSeparator(String sql, SQLActionType actionType) {
        addStatement(sql, actionType, false);
    }

    public String getSQLWithSeparator(String sql, boolean needSeparator) {
        if (!needSeparator || sql.endsWith("*/") || sql.startsWith("--")) {
            return sql;
        }

        String separator = switch (databaseType) {
            case PG, CH -> PG_SEPARATOR;
            case MS -> MS_SEPARATOR;
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + databaseType);
        };

        return sql + separator;
    }

    public void addStatement(String sql, SQLActionType actionType, boolean needSeparator) {
        statements.computeIfAbsent(actionType, e -> new LinkedHashSet<>()).add(getSQLWithSeparator(sql, needSeparator));
        count++;
    }

    public void addAllStatements(SQLScript script) {
        for (var type : SQLActionType.values()) {
            Set<String> s = script.statements.get(type);
            if (null == s) {
                continue;
            }
            s.forEach(e -> addStatement(e, type, false));
        }
    }

    public String getFullScript() {
        return statements.entrySet().stream()
            .flatMap(t -> t.getValue().stream())
            .collect(Collectors.joining(DELIMITER));
    }

    public int getSize() {
        return count;
    }

    public boolean isEmpty() {
        return 0 == count;
    }
}
