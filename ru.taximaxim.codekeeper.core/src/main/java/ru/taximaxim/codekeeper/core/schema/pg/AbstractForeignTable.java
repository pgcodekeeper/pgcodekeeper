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

import java.util.Objects;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

/**
 * Base implementation of foreign table
 *
 * @since 4.1.1
 * @author galiev_mr
 */
public abstract class AbstractForeignTable extends AbstractPgTable implements PgForeignOptionContainer {

    protected final String serverName;

    protected AbstractForeignTable(String name, String serverName) {
        super(name);
        this.serverName = serverName;
    }

    @Override
    public String getAlterTable(boolean nextLine, boolean only) {
        StringBuilder sb = new StringBuilder();
        if (nextLine) {
            sb.append("\n\n");
        }
        sb.append("ALTER FOREIGN TABLE ");
        if (only) {
            sb.append("ONLY ");
        }
        sb.append(getQualifiedName());
        return sb.toString();
    }

    @Override
    protected boolean isNeedRecreate(AbstractTable newTable) {
        return super.isNeedRecreate(newTable)
                || !this.getClass().equals(newTable.getClass())
                || !Objects.equals(serverName, ((AbstractForeignTable) newTable).getServerName());
    }

    @Override
    public void appendOptions(StringBuilder sbSQL) {
        sbSQL.append("\nSERVER ").append(PgDiffUtils.getQuotedName(serverName));
        if (!getOptions().isEmpty()) {
            sbSQL.append('\n');
        }
        PgForeignOptionContainer.super.appendOptions(sbSQL);
        sbSQL.append(';');
    }

    @Override
    public String getTypeName() {
        return "FOREIGN TABLE";
    }
    @Override
    public String getAlterHeader() {
        return getAlterTable(true, false);
    }

    @Override
    protected void appendName(StringBuilder sbSQL) {
        sbSQL.append("CREATE FOREIGN TABLE ");
        appendIfNotExists(sbSQL);
        sbSQL.append(getQualifiedName());
    }

    @Override
    protected void appendAlterOptions(StringBuilder sbSQL) {
        if (hasOids) {
            sbSQL.append(getAlterTable(true, true));
            sbSQL.append(" SET WITH OIDS;");
        }
    }

    @Override
    protected PgSequence writeSequences(PgColumn column, StringBuilder sbOption, boolean newLine) {
        PgSequence sequence = super.writeSequences(column, sbOption, newLine);
        if (!sequence.isLogged()) {
            sbOption.append("\nALTER SEQUENCE ").append(sequence.getQualifiedName()).append(" SET UNLOGGED;");
        }
        return sequence;
    }

    @Override
    protected void compareTableTypes(AbstractPgTable newTable, StringBuilder sb) {
        // untransformable
    }

    public String getServerName() {
        return serverName;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof AbstractForeignTable table && super.compare(obj)) {
            return Objects.equals(serverName, table.getServerName());
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(serverName);
    }
}
