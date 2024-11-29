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

package ru.taximaxim.codekeeper.core.schema;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.localizations.Messages;

public class SQLAction {

    public static final String GO = "\nGO";

    private final StringBuilder command;
    private final SQLActionType type;

    public enum SQLActionType {
        BEGIN, MID, END, COMMENT
    }

    public SQLAction() {
        this(new StringBuilder());
    }

    public SQLAction(String sql) {
        this(new StringBuilder(sql));
    }

    public SQLAction(StringBuilder sb) {
        this(sb, SQLActionType.MID);
    }

    public SQLAction(StringBuilder sb, SQLActionType type) {
        this.command = sb;
        this.type = type;
    }

    public SQLAction(String sql, SQLActionType type) {
        this.command = new StringBuilder(sql);
        this.type = type;
    }

    public SQLAction append(Object o) {
        command.append(o);
        return this;
    }

    public void reduce(int delta) {
        command.setLength(command.length() - delta);
    }

    public boolean isEmpty() {
        return command.length() > 0;
    }

    public SQLActionType getType() {
        return type;
    }

    public StringBuilder getBuilder() {
        return command;
    }

    @Override
    public String toString() {
        return command.toString();
    }

    public String getSQL(DatabaseType type) {
        String result = command.toString();
        if (result.startsWith("--") || result.endsWith("*/") || result.endsWith("GO\n")) {
            return result;
        }
        return result + getSeparator(type);
    }

    public String getSeparator(DatabaseType dbType) {
        return switch (dbType) {
        case PG, CH -> ";";
        case MS -> GO;
        default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        };
    }
}
