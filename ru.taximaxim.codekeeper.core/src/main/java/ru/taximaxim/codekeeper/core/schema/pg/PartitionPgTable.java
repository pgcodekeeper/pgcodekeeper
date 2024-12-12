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

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.IPartitionTable;
import ru.taximaxim.codekeeper.core.schema.Inherits;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

/**
 * Partition regular table object
 *
 * @since 4.1.1
 * @author galiev_mr
 */
public class PartitionPgTable extends AbstractRegularTable implements IPartitionTable {

    private final String partitionBounds;

    public PartitionPgTable(String name, String partitionBounds) {
        super(name);
        this.partitionBounds = partitionBounds;
    }

    @Override
    public String getPartitionBounds() {
        return partitionBounds;
    }

    @Override
    public String getParentTable() {
        return inherits.get(0).getQualifiedName();
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, SQLScript script) {
        sbSQL.append(" PARTITION OF ").append(getParentTable());

        if (!columns.isEmpty()) {
            sbSQL.append(" (\n");

            int start = sbSQL.length();
            for (AbstractColumn column : columns) {
                writeColumn((PgColumn) column, sbSQL, script);
            }

            if (start != sbSQL.length()) {
                sbSQL.setLength(sbSQL.length() - 2);
                sbSQL.append("\n)");
            } else {
                sbSQL.setLength(sbSQL.length() - 3);
            }
        }

        sbSQL.append('\n');
        sbSQL.append(partitionBounds);
    }


    @Override
    protected void appendInherit(StringBuilder sbSQL) {
        // PgTable.inherits stores PARTITION OF table in this implementation
    }

    @Override
    protected void compareTableTypes(AbstractPgTable newTable, SQLScript script) {
        if (!(newTable instanceof PartitionPgTable)) {
            script.addStatement(appendTablePartiton(getParentTable(), "DETACH"));

            if (newTable instanceof AbstractRegularTable table) {
                table.convertTable(script);
            }
        }
    }

    @Override
    protected void convertTable(SQLScript script) {
        Inherits newInherits = getInherits().get(0);
        StringBuilder sql = appendTablePartiton(newInherits.getQualifiedName(), "ATTACH");
        sql.append(' ').append(getPartitionBounds());
        script.addStatement(sql);
    }

    private StringBuilder appendTablePartiton(String tableName, String state) {
        return new StringBuilder(ALTER_TABLE).append(tableName)
                .append(MessageFormat.format("\n\t{0} PARTITION ", state))
                .append(PgDiffUtils.getQuotedName(getParent().getName()))
                .append('.')
                .append(PgDiffUtils.getQuotedName(getName()));
    }

    @Override
    protected void compareTableOptions(AbstractPgTable newTable, SQLScript script) {
        super.compareTableOptions(newTable, script);

        if (newTable instanceof PartitionPgTable table) {
            String newBounds = table.getPartitionBounds();

            Inherits oldInherits = inherits.get(0);
            Inherits newInherits = newTable.getInherits().get(0);

            if (!Objects.equals(partitionBounds, newBounds)
                    || !Objects.equals(oldInherits, newInherits)) {
                script.addStatement(appendTablePartiton(oldInherits.getQualifiedName(), "DETACH"));
                StringBuilder sql = appendTablePartiton(newInherits.getQualifiedName(), "ATTACH");
                sql.append(' ').append(table.getPartitionBounds());
                script.addStatement(sql);
            }
        }
    }

    @Override
    protected void compareInherits(AbstractPgTable newTable, SQLScript script) {
        //not support default syntax
    }

    @Override
    protected AbstractTable getTableCopy() {
        return new PartitionPgTable(name, partitionBounds);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PartitionPgTable table && super.compare(obj)) {
            return Objects.equals(partitionBounds, table.partitionBounds);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(partitionBounds);
    }

    @Override
    public void appendMoveDataSql(PgStatement newCondition, SQLScript script, String tblTmpBareName,
            List<String> identityCols) {
        // no impl
    }
}