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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.pg;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public abstract class PgConstraint extends AbstractConstraint {

    private boolean deferrable;
    private boolean initially;

    protected PgConstraint(String name) {
        super(name);
    }

    public void setDeferrable(boolean deferrable) {
        this.deferrable = deferrable;
        resetHash();
    }

    public boolean isDeferrable() {
        return deferrable;
    }

    public void setInitially(boolean initially) {
        this.initially = initially;
        resetHash();
    }

    public boolean isInitially() {
        return initially;
    }

    protected abstract String getErrorCode();

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();
        appendAlterTable(sbSQL);
        sbSQL.append("\n\tADD");
        if (!getName().isEmpty()) {
            sbSQL.append(" CONSTRAINT ").append(PgDiffUtils.getQuotedName(getName()));
        }
        sbSQL.append(' ');
        sbSQL.append(getDefinition());
        if (isDeferrable()) {
            sbSQL.append(" DEFERRABLE");
        }
        if (isInitially()) {
            sbSQL.append(" INITIALLY DEFERRED");
        }

        boolean generateNotValid = isGenerateNotValid();

        if (isNotValid() || generateNotValid) {
            sbSQL.append(" NOT VALID");
        }
        sbSQL.append(';');

        if (generateNotValid && !isNotValid()) {
            sbSQL.append("\n\n");
            appendAlterTable(sbSQL);
            sbSQL.append(" VALIDATE CONSTRAINT ")
            .append(PgDiffUtils.getQuotedName(getName()))
            .append(';');
        }

        appendExtraOptions(sbSQL);

        if (getDatabaseArguments().isGenerateExistDoBlock()) {
            StringBuilder sb = new StringBuilder();
            PgDiffUtils.appendSqlWrappedInDo(sb, sbSQL, getErrorCode());
            script.addStatement(sb);
        } else {
            sbSQL.setLength(sbSQL.length() - 1);
            script.addStatement(sbSQL);
        }
        appendComments(script);
    }

    protected boolean isGenerateNotValid() {
        if (!getDatabaseArguments().isConstraintNotValid()) {
            return false;
        }
        var parent = getParent();
        if (parent instanceof PartitionPgTable) {
            return false;
        }
        return parent instanceof AbstractRegularTable regTable && regTable.getPartitionBy() == null;
    }

    protected void appendExtraOptions(StringBuilder sbSQL) {
        // subclasses will override if needed
    }

    @Override
    public void getDropSQL(SQLScript script, boolean optionExists) {
        final StringBuilder sbSQL = new StringBuilder();
        appendAlterTable(sbSQL);
        sbSQL.append("\n\tDROP CONSTRAINT ");
        if (optionExists) {
            sbSQL.append(IF_EXISTS);
        }
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        script.addStatement(sbSQL);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        PgConstraint newConstr = (PgConstraint) newCondition;

        if (!compareUnalterable(newConstr)) {
            return ObjectState.RECREATE;
        }

        if (isNotValid() && !newConstr.isNotValid()) {
            StringBuilder sbSQL = new StringBuilder();
            appendAlterTable(sbSQL);
            sbSQL.append("\n\tVALIDATE CONSTRAINT ").append(PgDiffUtils.getQuotedName(getName()));
            script.addStatement(sbSQL);
        }

        compareExtraOptions(newConstr, script);
        appendAlterComments(newConstr, script);
        return getObjectState(script, startSize);
    }

    protected boolean compareUnalterable(PgConstraint newConstr) {
        return compareCommonFields(newConstr);
    }

    protected void compareExtraOptions(PgConstraint newConstr, SQLScript script) {
        // subclasses will override if needed
    }

    @Override
    protected void appendCommentSql(SQLScript script) {
        StringBuilder sb = new StringBuilder();
        sb.append("COMMENT ON CONSTRAINT ");
        sb.append(PgDiffUtils.getQuotedName(getName())).append(" ON ");
        if (getParent().getStatementType() == DbObjType.DOMAIN) {
            sb.append("DOMAIN ");
        }
        sb.append(getParent().getQualifiedName()).append(" IS ").append(checkComments() ? getComment() : "NULL");
        script.addStatement(sb.toString(), getCommentsOrder());
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(deferrable);
        hasher.put(initially);
    }

    @Override
    public AbstractConstraint shallowCopy() {
        var con = (PgConstraint) super.shallowCopy();
        con.setDeferrable(deferrable);
        con.setInitially(initially);
        return con;
    }

    @Override
    public boolean compare(PgStatement obj) {
        return obj instanceof PgConstraint && super.compare(obj);
    }

    protected boolean compareCommonFields(PgConstraint con) {
        return isDeferrable() == con.isDeferrable() && isInitially() == con.isInitially();
    }
}
