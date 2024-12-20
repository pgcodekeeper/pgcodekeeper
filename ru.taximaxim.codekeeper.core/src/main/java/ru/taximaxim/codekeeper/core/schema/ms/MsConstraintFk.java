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
package ru.taximaxim.codekeeper.core.schema.ms;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.IConstraintFk;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementUtils;

public final class MsConstraintFk extends MsConstraint implements IConstraintFk {

    private final Set<String> columns = new LinkedHashSet<>();
    private String foreignSchema;
    private String foreignTable;
    private final Set<String> refs = new LinkedHashSet<>();
    private String delAction;
    private String updAction;
    private boolean isNotForRepl;

    public MsConstraintFk(String name) {
        super(name);
    }

    @Override
    public Set<String> getColumns() {
        return Collections.unmodifiableSet(columns);
    }

    public void addColumn(String column) {
        columns.add(column);
        resetHash();
    }

    @Override
    public Set<String> getForeignColumns() {
        return Collections.unmodifiableSet(refs);
    }

    public void addForeignColumn(String referencedColumn) {
        refs.add(referencedColumn);
        resetHash();
    }

    @Override
    public String getForeignTable() {
        return foreignTable;
    }

    public void setForeignTable(String foreignTable) {
        this.foreignTable = foreignTable;
        resetHash();
    }

    @Override
    public String getForeignSchema() {
        return foreignSchema;
    }

    public void setForeignSchema(String foreignSchema) {
        this.foreignSchema = foreignSchema;
        resetHash();
    }

    public void setDelAction(String delAction) {
        this.delAction = delAction;
        resetHash();
    }

    public String getDelAction() {
        return delAction;
    }

    public void setUpdAction(String updAction) {
        this.updAction = updAction;
        resetHash();
    }

    public String getUpdAction() {
        return updAction;
    }

    public void setNotForRepl(boolean isNotForRepl) {
        this.isNotForRepl = isNotForRepl;
        resetHash();
    }

    public boolean isNotForRepl() {
        return isNotForRepl;
    }

    @Override
    public String getDefinition() {
        var sbSQL = new StringBuilder();
        sbSQL.append("FOREIGN KEY ");
        StatementUtils.appendCols(sbSQL, columns, getDbType());
        sbSQL.append(" REFERENCES ").append(MsDiffUtils.quoteName(getForeignSchema())).append('.')
        .append(MsDiffUtils.quoteName(getForeignTable()));
        if (!refs.isEmpty()) {
            sbSQL.append(' ');
            StatementUtils.appendCols(sbSQL, refs, getDbType());
        }
        if (delAction != null) {
            sbSQL.append(" ON DELETE ").append(delAction);
        }
        if (updAction != null) {
            sbSQL.append(" ON UPDATE ").append(updAction);
        }
        if (isNotForRepl) {
            sbSQL.append(" NOT FOR REPLICATION");
        }

        return sbSQL.toString();
    }

    @Override
    protected boolean compareUnalterable(MsConstraint obj) {
        if (obj instanceof MsConstraintFk con) {
            return Objects.equals(columns, con.columns)
                    && Objects.equals(getForeignSchema(), con.getForeignSchema())
                    && Objects.equals(getForeignTable(), con.getForeignTable())
                    && Objects.equals(refs, con.refs)
                    && Objects.equals(getDelAction(), con.getDelAction())
                    && Objects.equals(getUpdAction(), con.getUpdAction())
                    && isNotForRepl() == con.isNotForRepl();
        }

        return false;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsConstraintFk con && super.compare(con)) {
            return compareUnalterable(con);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(columns);
        hasher.put(foreignSchema);
        hasher.put(foreignTable);
        hasher.put(refs);
        hasher.put(delAction);
        hasher.put(updAction);
        hasher.put(isNotForRepl);
    }

    @Override
    protected AbstractConstraint getConstraintCopy() {
        var con = new MsConstraintFk(name);
        con.columns.addAll(columns);
        con.setForeignSchema(getForeignSchema());
        con.setForeignTable(getForeignTable());
        con.refs.addAll(refs);
        con.setDelAction(delAction);
        con.setUpdAction(updAction);
        con.setNotForRepl(isNotForRepl);
        return con;
    }
}