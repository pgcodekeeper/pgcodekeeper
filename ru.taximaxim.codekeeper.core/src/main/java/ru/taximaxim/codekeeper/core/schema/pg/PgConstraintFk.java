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

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.IConstraintFk;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementUtils;

public final class PgConstraintFk extends PgConstraint implements IConstraintFk {

    private String foreignSchema;
    private String foreignTable;
    private final Set<String> columns = new LinkedHashSet<>();
    private final Set<String> delActCols = new LinkedHashSet<>();
    private final Set<String> refs = new LinkedHashSet<>();
    private String match;
    private String delAction;
    private String updAction;

    public PgConstraintFk(String name) {
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

    public Set<String> getDelActCols() {
        return Collections.unmodifiableSet(delActCols);
    }

    public void addDelActCol(String col) {
        delActCols.add(col);
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
    public String getForeignSchema() {
        return foreignSchema;
    }

    public void setForeignSchema(String foreignSchema) {
        this.foreignSchema = foreignSchema;
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

    public void setMatch(String match) {
        this.match = match;
        resetHash();
    }

    public String getMatch() {
        return match;
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


    @Override
    public String getDefinition() {
        var sbSQL = new StringBuilder();
        sbSQL.append("FOREIGN KEY ");
        StatementUtils.appendCols(sbSQL, columns, getDbType());
        sbSQL.append(" REFERENCES ").append(PgDiffUtils.getQuotedName(getForeignSchema())).append('.')
            .append(PgDiffUtils.getQuotedName(getForeignTable()));
        if (!refs.isEmpty()) {
            StatementUtils.appendCols(sbSQL, getForeignColumns(), getDbType());
        }
        if (getMatch() != null) {
            sbSQL.append(" MATCH ").append(getMatch());
        }
        if (getUpdAction() != null) {
            sbSQL.append(" ON UPDATE ").append(getUpdAction());
        }
        if (getDelAction() != null) {
            sbSQL.append(" ON DELETE ").append(getDelAction());
            if (!delActCols.isEmpty()) {
                StatementUtils.appendCols(sbSQL, getDelActCols(), getDbType());
            }
        }
        return sbSQL.toString();
    }

    @Override
    protected void compareExtraOptions(StringBuilder sb, PgConstraint newConstr) {
        if (!compareCommonFields(newConstr)) {
            appendAlterTable(sb, true);
            sb.append("\n\tALTER CONSTRAINT ").append(PgDiffUtils.getQuotedName(getName()));
            if (isDeferrable() != newConstr.isDeferrable() && !newConstr.isDeferrable()) {
                sb.append(" NOT DEFERRABLE;");
                return;
            }
            sb.append(" DEFERRABLE INITIALLY ").append(newConstr.isInitially() ? "DEFERRED" : "IMMEDIATE").append(';');
        }
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgConstraintFk) {
            var con = (PgConstraintFk) obj;
            return super.compare(con) && compareCommonFields(con)
                    && compareUnalterable(con);
        }
        return false;
    }

    @Override
    protected boolean compareUnalterable(PgConstraint newConstr) {
        var con = (PgConstraintFk) newConstr;
        return isPrimaryKey() == con.isPrimaryKey()
                && Objects.equals(getForeignSchema(), con.getForeignSchema())
                && Objects.equals(getForeignTable(), con.getForeignTable())
                && Objects.equals(columns, con.columns)
                && Objects.equals(delActCols, con.delActCols)
                && Objects.equals(refs, con.refs)
                && Objects.equals(getMatch(), con.getMatch())
                && Objects.equals(getDelAction(), con.getDelAction())
                && Objects.equals(getUpdAction(), con.getUpdAction());
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(foreignSchema);
        hasher.put(foreignTable);
        hasher.put(columns);
        hasher.put(delActCols);
        hasher.put(refs);
        hasher.put(match);
        hasher.put(delAction);
        hasher.put(updAction);
    }

    @Override
    protected AbstractConstraint getConstraintCopy() {
        var con = new PgConstraintFk(name);
        con.setForeignSchema(getForeignSchema());
        con.setForeignTable(getForeignTable());
        con.columns.addAll(columns);
        con.delActCols.addAll(delActCols);
        con.refs.addAll(refs);
        con.setMatch(getMatch());
        con.setDelAction(getDelAction());
        con.setUpdAction(getUpdAction());
        return con;
    }
}