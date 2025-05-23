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

import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.Inherits;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.schema.SimpleColumn;
import ru.taximaxim.codekeeper.core.schema.StatementUtils;
import ru.taximaxim.codekeeper.core.script.SQLScript;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public final class PgIndex extends AbstractIndex {

    private static final String ALTER_INDEX = "ALTER INDEX ";
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
    public void getCreationSQL(SQLScript script) {
        getCreationSQL(script, name);
        appendComments(script);
    }

    private void getCreationSQL(SQLScript script, String name) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ");

        if (unique) {
            sbSQL.append("UNIQUE ");
        }

        sbSQL.append("INDEX ");
        ISettings settings = script.getSettings();
        if (settings.isConcurrentlyMode() && !settings.isAddTransaction()) {
            sbSQL.append("CONCURRENTLY ");
        }
        if (inherit != null || settings.isGenerateExists()) {
            sbSQL.append("IF NOT EXISTS ");
        }
        sbSQL.append(PgDiffUtils.getQuotedName(name))
        .append(" ON ");
        if (parent instanceof AbstractRegularTable regTable && regTable.getPartitionBy() != null) {
            sbSQL.append("ONLY ");
        }
        sbSQL.append(parent.getQualifiedName());
        if (method != null) {
            sbSQL.append(" USING ").append(PgDiffUtils.getQuotedName(method));
        }
        appendSimpleColumns(sbSQL, columns);
        appendIndexParam(sbSQL);
        appendWhere(sbSQL);
        script.addStatement(sbSQL);

        if (isClustered) {
            script.addStatement(appendClusterSql());
        }

        if (inherit != null) {
            script.addStatement(ALTER_INDEX + inherit.getQualifiedName() + " ATTACH PARTITION " + getQualifiedName());
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
        if (tablespace != null) {
            sb.append("\nTABLESPACE ").append(tablespace);
        }
    }

    @Override
    public String getQualifiedName() {
        if (qualifiedName == null) {
            qualifiedName = PgDiffUtils.getQuotedName(getSchemaName()) + '.' + PgDiffUtils.getQuotedName(name);
        }
        return qualifiedName;
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        PgIndex newIndex = (PgIndex) newCondition;

        if (!compareUnalterable(newIndex)) {
            if (script.getSettings().isConcurrentlyMode()) {
                // generate optimized command sequence for concurrent index creation
                String tmpName = "tmp" + PgDiffUtils.RANDOM.nextInt(Integer.MAX_VALUE) + "_" + name;
                newIndex.getCreationSQL(script, tmpName);
                script.addStatement("BEGIN TRANSACTION");
                getDropSQL(script);
                StringBuilder sql = new StringBuilder();
                sql.append(ALTER_INDEX)
                .append(PgDiffUtils.getQuotedName(getSchemaName()))
                .append('.')
                .append(PgDiffUtils.getQuotedName(tmpName))
                .append(" RENAME TO ")
                .append(PgDiffUtils.getQuotedName(getName()));
                script.addStatement(sql);

                newIndex.appendComments(script);
                script.addStatement("COMMIT TRANSACTION");
            }
            return ObjectState.RECREATE;
        }

        if (!Objects.equals(tablespace, newIndex.tablespace)) {
            StringBuilder sql = new StringBuilder();
            sql.append(ALTER_INDEX).append(newIndex.getQualifiedName())
            .append(" SET TABLESPACE ");

            String newSpace = newIndex.tablespace;
            sql.append(newSpace == null ? Consts.PG_DEFAULT : newSpace);
            script.addStatement(sql);
        }

        if (newIndex.isClustered != isClustered) {
            if (newIndex.isClustered) {
                script.addStatement(newIndex.appendClusterSql());
            } else if (!((PgStatementContainer) newIndex.parent).isClustered()) {
                script.addStatement(ALTER_TABLE + newIndex.parent.getQualifiedName() + " SET WITHOUT CLUSTER");
            }
        }

        compareOptions(newIndex, script);
        appendAlterComments(newIndex, script);

        return getObjectState(script, startSize);
    }

    private String appendClusterSql() {
        return "ALTER " + parent.getTypeName() + ' ' + parent.getQualifiedName() + " CLUSTER ON " + name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
        resetHash();
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
        PgIndex index =  new PgIndex(name);
        index.inherit = inherit;
        index.setMethod(method);
        index.setNullsDistinction(nullsDistinction);
        return index;
    }
}
