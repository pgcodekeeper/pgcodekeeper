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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.IConstraintFk;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementUtils;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class PgConstraintFk extends PgConstraint implements IConstraintFk {

    private String foreignSchema;
    private String foreignTable;
    private final List<String> columns = new ArrayList<>();
    private final List<String> delActCols = new ArrayList<>();
    private final List<String> refs = new ArrayList<>();
    private String match;
    private String delAction;
    private String updAction;

    public PgConstraintFk(String name) {
        super(name);
    }

    @Override
    public List<String> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    public void addColumn(String column) {
        columns.add(column);
        resetHash();
    }

    public void addDelActCol(String col) {
        delActCols.add(col);
        resetHash();
    }

    @Override
    public List<String> getForeignColumns() {
        return Collections.unmodifiableList(refs);
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

    public void setDelAction(String delAction) {
        this.delAction = delAction;
        resetHash();
    }

    public void setUpdAction(String updAction) {
        this.updAction = updAction;
        resetHash();
    }

    @Override
    public String getErrorCode() {
        return Consts.DUPLICATE_OBJECT;
    }

    @Override
    public String getDefinition() {
        var sbSQL = new StringBuilder();
        sbSQL.append("FOREIGN KEY ");
        StatementUtils.appendCols(sbSQL, columns, getDbType());
        sbSQL.append(" REFERENCES ").append(PgDiffUtils.getQuotedName(foreignSchema)).append('.')
        .append(PgDiffUtils.getQuotedName(foreignTable));
        if (!refs.isEmpty()) {
            StatementUtils.appendCols(sbSQL, refs, getDbType());
        }
        if (match != null) {
            sbSQL.append(" MATCH ").append(match);
        }
        if (updAction != null) {
            sbSQL.append(" ON UPDATE ").append(updAction);
        }
        if (delAction != null) {
            sbSQL.append(" ON DELETE ").append(delAction);
            if (!delActCols.isEmpty()) {
                StatementUtils.appendCols(sbSQL, delActCols, getDbType());
            }
        }
        return sbSQL.toString();
    }

    @Override
    protected void compareExtraOptions(PgConstraint newConstr, SQLScript script) {
        if (!compareCommonFields(newConstr)) {
            StringBuilder sb = new StringBuilder();
            appendAlterTable(sb);
            sb.append("\n\tALTER CONSTRAINT ").append(PgDiffUtils.getQuotedName(name));
            if (deferrable != newConstr.deferrable && !newConstr.deferrable) {
                sb.append(" NOT DEFERRABLE");
                script.addStatement(sb);
                return;
            }
            sb.append(" DEFERRABLE INITIALLY ").append(newConstr.initially ? "DEFERRED" : "IMMEDIATE");
            script.addStatement(sb);
        }
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgConstraintFk con && super.compare(con)) {
            return compareCommonFields(con)
                    && compareUnalterable(con);
        }
        return false;
    }

    @Override
    protected boolean compareUnalterable(PgConstraint newConstr) {
        var con = (PgConstraintFk) newConstr;
        return isPrimaryKey() == con.isPrimaryKey()
                && Objects.equals(foreignSchema, con.foreignSchema)
                && Objects.equals(foreignTable, con.foreignTable)
                && Objects.equals(columns, con.columns)
                && Objects.equals(delActCols, con.delActCols)
                && Objects.equals(refs, con.refs)
                && Objects.equals(match, con.match)
                && Objects.equals(delAction, con.delAction)
                && Objects.equals(updAction, con.updAction);
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
        con.setForeignSchema(foreignSchema);
        con.setForeignTable(foreignTable);
        con.columns.addAll(columns);
        con.delActCols.addAll(delActCols);
        con.refs.addAll(refs);
        con.setMatch(match);
        con.setDelAction(delAction);
        con.setUpdAction(updAction);
        return con;
    }
}