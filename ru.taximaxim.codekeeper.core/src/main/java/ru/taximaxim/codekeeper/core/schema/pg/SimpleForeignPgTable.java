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
package ru.taximaxim.codekeeper.core.schema.pg;

import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.script.SQLScript;

/**
 * Simple foreign table object
 *
 * @since 4.1.1
 * @author galiev_mr
 *
 */
public class SimpleForeignPgTable extends AbstractForeignTable {

    public SimpleForeignPgTable(String name, String serverName) {
        super(name, serverName);
    }

    @Override
    protected AbstractTable getTableCopy() {
        return new SimpleForeignPgTable(name, serverName);
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, SQLScript script) {
        sbSQL.append(" (\n");

        int start = sbSQL.length();
        for (AbstractColumn column : columns) {
            writeColumn((PgColumn) column, sbSQL, script);
        }

        if (start != sbSQL.length()) {
            sbSQL.setLength(sbSQL.length() - 2);
            sbSQL.append('\n');
        }

        sbSQL.append(')');
    }
}