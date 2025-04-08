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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.IPartitionTable;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;
import ru.taximaxim.codekeeper.core.settings.ISettings;

/**
 * Partition foreign table object
 *
 * @since 4.1.1
 * @author galiev_mr
 */
public final class PartitionForeignPgTable extends AbstractForeignTable implements IPartitionTable {

    private final String partitionBounds;

    public PartitionForeignPgTable(String name, String serverName, String partitionBounds, ISettings settings) {
        super(name, serverName, settings);
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
    protected boolean isNeedRecreate(AbstractTable newTable) {
        return super.isNeedRecreate(newTable)
                || !(Objects.equals(partitionBounds, ((PartitionForeignPgTable) newTable).partitionBounds))
                || !inherits.equals(((AbstractPgTable) newTable).inherits);
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
    protected void appendInherit(StringBuilder sb) {
        // PgTable.inherits stores PARTITION OF table in this implementation
    }

    @Override
    protected AbstractTable getTableCopy() {
        return new PartitionForeignPgTable(name, serverName, partitionBounds, settings);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PartitionForeignPgTable table && super.compare(obj)) {
            return Objects.equals(partitionBounds, table.partitionBounds);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(partitionBounds);
    }
}