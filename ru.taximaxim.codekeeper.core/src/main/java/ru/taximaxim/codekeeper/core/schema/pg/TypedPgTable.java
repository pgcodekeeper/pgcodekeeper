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

import java.util.Collection;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLAction;

/**
 * Typed table object
 *
 * @since 4.1.1
 * @author galiev_mr
 *
 */
public class TypedPgTable extends AbstractRegularTable {

    private final String ofType;

    public TypedPgTable(String name, String ofType) {
        super(name);
        this.ofType = ofType;
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, Collection<SQLAction> alterTableActions) {
        sbSQL.append(" OF ").append(ofType);

        if (!columns.isEmpty()) {
            sbSQL.append(" (\n");

            int start = sbSQL.length();
            for (AbstractColumn column : columns) {
                writeColumn((PgColumn) column, sbSQL, alterTableActions);
            }

            if (start != sbSQL.length()) {
                sbSQL.setLength(sbSQL.length() - 2);
                sbSQL.append("\n)");
            }
        }
    }

    public String getOfType() {
        return ofType;
    }

    @Override
    protected void compareTableTypes(AbstractPgTable newTable, Collection<SQLAction> sqlActions) {
        SQLAction sql = new SQLAction();
        if (newTable instanceof TypedPgTable typedTable) {
            String newType = typedTable.getOfType();
            if (!Objects.equals(ofType, newType)) {
                sql.append(getAlterTable(false))
                .append(" OF ")
                .append(newType);
                sqlActions.add(sql);
            }
        } else {
            sql.append(getAlterTable(false))
            .append(" NOT OF");
            sqlActions.add(sql);

            if (newTable instanceof AbstractRegularTable regTable) {
                regTable.convertTable(sqlActions);
            }
        }
    }

    @Override
    protected boolean isColumnsOrderChanged(AbstractTable newTable) {
        return false;
    }

    @Override
    protected AbstractTable getTableCopy() {
        return new TypedPgTable(name, getOfType());
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof TypedPgTable table && super.compare(obj)) {
            return Objects.equals(ofType, table.getOfType());
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(ofType);
    }

    @Override
    protected void convertTable(Collection<SQLAction> sqlActions) {
        SQLAction sql = new SQLAction();
        sql.append(getAlterTable(false))
        .append(" OF ").append(getOfType());
        sqlActions.add(sql);
    }
}
