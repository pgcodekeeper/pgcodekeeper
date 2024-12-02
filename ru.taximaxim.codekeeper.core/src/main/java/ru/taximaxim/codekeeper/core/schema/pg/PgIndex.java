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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.Inherits;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.SQLAction;
import ru.taximaxim.codekeeper.core.schema.SimpleColumn;
import ru.taximaxim.codekeeper.core.schema.StatementUtils;

public class PgIndex extends AbstractIndex {

    private Inherits inherit;
    private String method;
    private boolean nullsDistinction = true;

    public PgIndex(String name) {
        super(name);
    }

    @Override
    public boolean canDrop() {
        return inherit == null;
    }

    @Override
    public void getCreationSQL(Collection<SQLAction> createActions) {
        getCreationSQL(createActions, getName());
        appendComments(createActions);
    }

    private void getCreationSQL(Collection<SQLAction> createActions, String name) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ");

        if (isUnique()) {
            sbSQL.append("UNIQUE ");
        }

        sbSQL.append("INDEX ");
        if (getDatabaseArguments().isConcurrentlyMode() && !getDatabaseArguments().isAddTransaction()) {
            sbSQL.append("CONCURRENTLY ");
        }
        if (inherit != null || getDatabaseArguments().isGenerateExists()) {
            sbSQL.append("IF NOT EXISTS ");
        }
        sbSQL.append(PgDiffUtils.getQuotedName(name))
        .append(" ON ");
        PgStatement par = getParent();
        if (par instanceof AbstractRegularTable regTable && regTable.getPartitionBy() != null) {
            sbSQL.append("ONLY ");
        }
        sbSQL.append(par.getQualifiedName());
        if (getMethod() != null) {
            sbSQL.append(" USING ").append(PgDiffUtils.getQuotedName(getMethod()));
        }
        appendSimpleColumns(sbSQL, columns);
        appendIndexParam(sbSQL);
        appendWhere(sbSQL);
        createActions.add(new SQLAction(sbSQL));

        if (isClustered()) {
            SQLAction sql = new SQLAction();
            appendClusterSql(sql);
            createActions.add(sql);
        }

        if (inherit != null) {
            SQLAction sql = new SQLAction();
            sbSQL.append("ALTER INDEX ").append(inherit.getQualifiedName())
            .append(" ATTACH PARTITION ").append(getQualifiedName());
            createActions.add(sql);
        }
    }

    private void appendSimpleColumns(StringBuilder sbSQL, List<SimpleColumn> columns) {
        sbSQL.append(" (");
        for (var col : columns) {
            // column name already quoted
            sbSQL.append(col.getName());
            if (col.getCollation() != null) {
                sbSQL.append(" COLLATE ").append(col.getCollation());
            }
            if (col.getOpClass() != null) {
                sbSQL.append(' ').append(col.getOpClass());
                var opClassParams = col.getOpClassParams();
                if (!opClassParams.isEmpty()) {
                    StatementUtils.appendOptionsWithParen(sbSQL, opClassParams, getDbType());
                }
            }
            if (col.isDesc()) {
                sbSQL.append(" DESC");
            }
            if (col.getNullsOrdering() != null) {
                sbSQL.append(col.getNullsOrdering());
            }
            sbSQL.append(", ");
        }
        sbSQL.setLength(sbSQL.length() - 2);
        sbSQL.append(')');
    }

    private void appendIndexParam(StringBuilder sb) {
        if (!includes.isEmpty()) {
            sb.append(" INCLUDE ");
            StatementUtils.appendCols(sb, includes, DatabaseType.PG);
        }
        if (!nullsDistinction) {
            sb.append(" NULLS NOT DISTINCT");
        }
        if (!options.isEmpty()) {
            sb.append("\nWITH");
            StatementUtils.appendOptionsWithParen(sb, options, DatabaseType.PG);
        }
        if (getTablespace() != null) {
            sb.append("\nTABLESPACE ").append(getTablespace());
        }
    }

    @Override
    public String getQualifiedName() {
        return PgDiffUtils.getQuotedName(getSchemaName()) + '.' + PgDiffUtils.getQuotedName(getName());
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> alterActions) {
        PgIndex newIndex = (PgIndex) newCondition;

        if (!compareUnalterable(newIndex)) {
            isNeedDepcies.set(true);

            if (getDatabaseArguments().isConcurrentlyMode()) {
                // generate optimized command sequence for concurrent index creation
                String tmpName = "tmp" + PgDiffUtils.RANDOM.nextInt(Integer.MAX_VALUE) + "_" + getName();
                newIndex.getCreationSQL(alterActions, tmpName);
                alterActions.add(new SQLAction("BEGIN TRANSACTION"));
                getDropSQL(alterActions);
                SQLAction sql = new SQLAction();
                sql.append("ALTER INDEX ")
                .append(PgDiffUtils.getQuotedName(getSchemaName()))
                .append('.')
                .append(PgDiffUtils.getQuotedName(tmpName))
                .append(" RENAME TO ")
                .append(PgDiffUtils.getQuotedName(getName()));
                alterActions.add(sql);

                newIndex.appendComments(alterActions);
                alterActions.add(new SQLAction("COMMIT TRANSACTION"));
            }
            return ObjectState.RECREATE;
        }

        if (!Objects.equals(getTablespace(), newIndex.getTablespace())) {
            SQLAction sql = new SQLAction();
            sql.append("ALTER INDEX ").append(newIndex.getQualifiedName())
            .append(" SET TABLESPACE ");

            String newSpace = newIndex.getTablespace();
            sql.append(newSpace == null ? Consts.PG_DEFAULT : newSpace);
            alterActions.add(sql);
        }

        if (newIndex.isClustered() != isClustered()) {
            SQLAction sql = new SQLAction();
            if (newIndex.isClustered()) {
                newIndex.appendClusterSql(sql);
                alterActions.add(sql);
            } else if (!((PgStatementContainer) newIndex.getParent()).isClustered()) {
                sql.append(ALTER_TABLE)
                .append(newIndex.getParent().getQualifiedName())
                .append(" SET WITHOUT CLUSTER");
                alterActions.add(sql);
            }
        }

        compareOptions(newIndex, alterActions);
        appendAlterComments(newIndex, alterActions);

        return getObjectState(alterActions);
    }

    private void appendClusterSql(SQLAction sql) {
        sql.append("ALTER ");
        sql.append(getParent().getTypeName()).append(' ');
        sql.append(getParent().getQualifiedName());
        sql.append(" CLUSTER ON ");
        sql.append(getName());
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
        resetHash();
    }

    public Inherits getInherit() {
        return inherit;
    }

    public void addInherit(final String schemaName, final String indexName) {
        inherit = new Inherits(schemaName, indexName);
        resetHash();
    }

    public boolean isNullsDistinction() {
        return nullsDistinction;
    }

    public void setNullsDistinction(boolean nullsDistinction) {
        this.nullsDistinction = nullsDistinction;
        resetHash();
    }

    @Override
    protected boolean compareUnalterable(AbstractIndex index) {
        if (!(index instanceof PgIndex pgIndex)) {
            return false;
        }
        return super.compareUnalterable(pgIndex)
                && Objects.equals(inherit, pgIndex.inherit)
                && Objects.equals(method, pgIndex.method)
                && nullsDistinction == pgIndex.nullsDistinction;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(inherit);
        hasher.put(method);
        hasher.put(nullsDistinction);
    }

    @Override
    protected AbstractIndex getIndexCopy() {
        PgIndex index =  new PgIndex(getName());
        index.inherit = inherit;
        index.setMethod(getMethod());
        index.setNullsDistinction(isNullsDistinction());
        return index;
    }
}
