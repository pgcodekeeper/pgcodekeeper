/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.IPartitionTable;
import ru.taximaxim.codekeeper.core.schema.Inherits;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

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
    protected void appendColumns(StringBuilder sbSQL, StringBuilder sbOption) {
        sbSQL.append(" PARTITION OF ").append(getParentTable());

        if (!columns.isEmpty()) {
            sbSQL.append(" (\n");

            int start = sbSQL.length();
            for (AbstractColumn column : columns) {
                writeColumn((PgColumn) column, sbSQL, sbOption);
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
    protected void compareTableTypes(AbstractPgTable newTable, StringBuilder sb) {
        if (!(newTable instanceof PartitionPgTable)) {
            sb.append("\n\nALTER TABLE ")
            .append(getParentTable())
            .append("\n\tDETACH PARTITION ")
            .append(PgDiffUtils.getQuotedName(getParent().getName()))
            .append('.')
            .append(PgDiffUtils.getQuotedName(getName()))
            .append(';');

            if (newTable instanceof AbstractRegularTable) {
                ((AbstractRegularTable)newTable).convertTable(sb);
            }
        }
    }

    @Override
    protected void convertTable(StringBuilder sb) {
        Inherits newInherits = getInherits().get(0);
        sb.append("\n\nALTER TABLE ");
        sb.append(newInherits.getQualifiedName())
        .append("\n\tATTACH PARTITION ")
        .append(PgDiffUtils.getQuotedName(getParent().getName()))
        .append('.')
        .append(PgDiffUtils.getQuotedName(getName()))
        .append(' ').append(getPartitionBounds()).append(';');
    }

    @Override
    protected void compareTableOptions(AbstractPgTable newTable, StringBuilder sb) {
        super.compareTableOptions(newTable, sb);

        if (newTable instanceof PartitionPgTable) {
            String newBounds = ((PartitionPgTable) newTable).getPartitionBounds();

            Inherits oldInherits = inherits.get(0);
            Inherits newInherits = newTable.getInherits().get(0);

            if (!Objects.equals(partitionBounds, newBounds)
                    || !Objects.equals(oldInherits, newInherits)) {
                sb.append("\n\nALTER TABLE ");
                sb.append(oldInherits.getQualifiedName())
                .append("\n\tDETACH PARTITION ")
                .append(PgDiffUtils.getQuotedName(getParent().getName()))
                .append('.')
                .append(PgDiffUtils.getQuotedName(getName()))
                .append(';');

                sb.append("\n\nALTER TABLE ");
                sb.append(newInherits.getQualifiedName())
                .append("\n\tATTACH PARTITION ")
                .append(PgDiffUtils.getQuotedName(getParent().getName()))
                .append('.')
                .append(PgDiffUtils.getQuotedName(getName()))
                .append(' ')
                .append(((PartitionPgTable)newTable).getPartitionBounds())
                .append(';');
            }
        }
    }

    @Override
    protected void compareInherits(AbstractPgTable newTable, StringBuilder sb) {
        //not support default syntax
    }

    @Override
    protected AbstractTable getTableCopy() {
        return new PartitionPgTable(name, partitionBounds);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PartitionPgTable && super.compare(obj)) {
            PartitionPgTable table = (PartitionPgTable) obj;
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