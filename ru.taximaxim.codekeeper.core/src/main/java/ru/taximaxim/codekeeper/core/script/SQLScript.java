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
package ru.taximaxim.codekeeper.core.script;

import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.schema.SQLAction;
import ru.taximaxim.codekeeper.core.schema.SQLAction.SQLActionType;

public class SQLScript {

    private static final String DELIMITER = "\n\n";

    private final Map<SQLActionType, Set<String>> statements = new EnumMap<>(SQLActionType.class);

    private final DatabaseType databaseType;

    public SQLScript(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }

    public void addStatement(SQLAction action) {
        addStatement(action, SQLActionType.MID);
    }

    public void addStatement(String sql) {
        addStatement(sql, SQLActionType.MID);
    }

    public void addStatement(SQLAction action, SQLActionType actionType) {
        addStatement(action.getSQL(databaseType), actionType);
    }

    public void addStatement(String sql, SQLActionType actionType) {
        statements.computeIfAbsent(actionType, e -> new LinkedHashSet<>()).add(sql);
    }

    public String getFullScript() {
        return statements.entrySet().stream()
                .flatMap(t -> t.getValue().stream())
                .collect(Collectors.joining(DELIMITER));
    }

    public static String getText(Set<SQLAction> sqlActions, DatabaseType dbType) {
        SQLScript script = new SQLScript(dbType);
        sqlActions.forEach(script::addStatement);
        return script.getFullScript();
    }
}
