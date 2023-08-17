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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public class PgConstraint extends AbstractConstraint {

    public PgConstraint(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        appendAlterTable(sbSQL, false);
        sbSQL.append("\n\tADD CONSTRAINT ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(' ');
        sbSQL.append(getDefinition());

        boolean generateNotValid = false;
        PgDiffArguments args = getDatabase().getArguments();
        if (args != null && args.isConstraintNotValid() && !isUnique() && !isPrimaryKey()) {
            boolean isPartitionTable = getParent() instanceof PartitionPgTable
                    || (getParent() instanceof AbstractRegularTable
                            && ((AbstractRegularTable) getParent()).getPartitionBy() != null);
            generateNotValid = !isPartitionTable;
        }

        if (isNotValid() || generateNotValid) {
            sbSQL.append(" NOT VALID");
        }
        sbSQL.append(';');

        if (generateNotValid && !isNotValid()) {
            appendAlterTable(sbSQL, true);
            sbSQL.append(" VALIDATE CONSTRAINT ")
            .append(PgDiffUtils.getQuotedName(getName()))
            .append(';');
        }
        if (isClustered()) {
            appendAlterTable(sbSQL, true);
            sbSQL.append(" CLUSTER ON ").append(getName()).append(";");
        }

        if (comment != null && !comment.isEmpty()) {
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL(boolean optionExists) {
        final StringBuilder sbSQL = new StringBuilder();
        appendAlterTable(sbSQL, false);
        sbSQL.append("\n\tDROP CONSTRAINT ");
        if (optionExists) {
            sbSQL.append("IF EXISTS ");
        }
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(';');

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgConstraint newConstr = (PgConstraint) newCondition;

        if (!Objects.equals(getDefinition(), newConstr.getDefinition())) {
            isNeedDepcies.set(true);
            return true;
        }
        if (isNotValid() && !newConstr.isNotValid()) {
            appendAlterTable(sb, true);
            sb.append("\n\tVALIDATE CONSTRAINT ")
            .append(PgDiffUtils.getQuotedName(getName())).append(';');
        }

        if (newConstr.isClustered() != isClustered()) {
            if (newConstr.isClustered()) {
                appendAlterTable(sb, true);
                sb.append(" CLUSTER ON ").append(getName()).append(";");
            } else if (!((PgStatementContainer) newConstr.getParent()).isClustered()) {
                appendAlterTable(sb, true);
                sb.append(" SET WITHOUT CLUSTER;");
            }
        }

        if (!Objects.equals(getComment(), newConstr.getComment())) {
            newConstr.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    @Override
    protected void appendCommentSql(StringBuilder sb) {
        sb.append("\n\n").append("COMMENT ON CONSTRAINT ");
        sb.append(PgDiffUtils.getQuotedName(getName())).append(" ON ");
        if (getParent().getStatementType() == DbObjType.DOMAIN) {
            sb.append("DOMAIN ");
        }
        sb.append(getParent().getQualifiedName()).append(" IS ")
        .append(comment == null || comment.isEmpty() ? "NULL" : comment)
        .append(';');
    }

    private void appendAlterTable(StringBuilder sb, boolean isNewLine) {
        if (isNewLine) {
            sb.append("\n\n");
        }
        sb.append("ALTER ").append(getParent().getStatementType().name()).append(' ');
        sb.append(getParent().getQualifiedName());
    }

    @Override
    protected AbstractConstraint getConstraintCopy() {
        return new PgConstraint(getName());
    }
}
