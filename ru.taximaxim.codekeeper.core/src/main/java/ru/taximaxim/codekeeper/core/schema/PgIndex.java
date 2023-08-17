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

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;

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
    public String getCreationSQL() {
        return getCreationSQL(getName());
    }

    private String getCreationSQL(String name) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ");

        if (isUnique()) {
            sbSQL.append("UNIQUE ");
        }

        sbSQL.append("INDEX ");
        PgDiffArguments args = getDatabase().getArguments();
        if (args != null && args.isConcurrentlyMode()) {
            sbSQL.append("CONCURRENTLY ");
        }
        if (inherit != null || (args != null && args.isGenerateExists())) {
            sbSQL.append("IF NOT EXISTS ");
        }
        sbSQL.append(PgDiffUtils.getQuotedName(name));
        sbSQL.append(" ON ");

        PgStatement par = getParent();
        if (par instanceof AbstractRegularTable
                && ((AbstractRegularTable) par).getPartitionBy() != null) {
            sbSQL.append("ONLY ");
        }

        sbSQL.append(par.getQualifiedName());
        if (getMethod() != null) {
            sbSQL.append(" USING ").append(PgDiffUtils.getQuotedName(getMethod()));
        }
        sbSQL.append(' ');
        sbSQL.append(getDefinition());

        if (!includes.isEmpty()) {
            sbSQL.append(" INCLUDE (");
            for (String col : includes) {
                sbSQL.append(PgDiffUtils.getQuotedName(col)).append(", ");
            }
            sbSQL.setLength(sbSQL.length() - 2);
            sbSQL.append(')');
        }

        if (!isNullsDistinction()) {
            sbSQL.append(" NULLS NOT DISTINCT");
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : options.entrySet()) {
            sb.append(entry.getKey());
            if (!entry.getValue().isEmpty()){
                sb.append("=").append(entry.getValue());
            }
            sb.append(", ");
        }

        if (sb.length() > 0){
            sb.setLength(sb.length() - 2);
            sbSQL.append("\nWITH (").append(sb).append(")");
        }

        if (getTablespace() != null) {
            sbSQL.append("\nTABLESPACE ").append(getTablespace());
        }
        if (getWhere() != null) {
            sbSQL.append("\nWHERE ").append(getWhere());
        }
        sbSQL.append(';');

        if (isClustered()) {
            appendClusterSql(sbSQL);
        }

        if (comment != null && !comment.isEmpty()) {
            appendCommentSql(sbSQL);
        }

        if (inherit != null) {
            sbSQL.append("\n\nALTER INDEX ").append(inherit.getQualifiedName())
            .append(" ATTACH PARTITION ").append(getQualifiedName()).append(';');
        }

        return sbSQL.toString();
    }

    @Override
    public String getQualifiedName() {
        return PgDiffUtils.getQuotedName(getSchemaName()) + '.' + PgDiffUtils.getQuotedName(getName());
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgIndex newIndex = (PgIndex) newCondition;

        if (!compareUnalterable(newIndex)) {
            isNeedDepcies.set(true);

            PgDiffArguments args = getDatabase().getArguments();
            boolean concurrently = args != null && args.isConcurrentlyMode();
            if (concurrently) {
                // generate optimized command sequence for concurrent index creation
                String tmpName = "tmp" + PgDiffUtils.RANDOM.nextInt(Integer.MAX_VALUE) + "_" + getName();

                sb.append("\n\n")
                .append(newIndex.getCreationSQL(tmpName))
                .append("\n\nBEGIN TRANSACTION;\n")
                .append(getDropSQL())
                .append("\nALTER INDEX ")
                .append(PgDiffUtils.getQuotedName(getSchemaName()))
                .append('.')
                .append(PgDiffUtils.getQuotedName(tmpName))
                .append(" RENAME TO ")
                .append(PgDiffUtils.getQuotedName(getName()))
                .append(";");
                newIndex.appendCommentSql(sb);
                sb.append("\nCOMMIT TRANSACTION;");
            }
            return true;
        }

        if (!Objects.equals(getTablespace(), newIndex.getTablespace())) {
            sb.append("\n\nALTER INDEX ").append(newIndex.getQualifiedName())
            .append(" SET TABLESPACE ");

            String newSpace = newIndex.getTablespace();
            sb.append(newSpace == null ? Consts.PG_DEFAULT : newSpace).append(';');
        }

        if (newIndex.isClustered() != isClustered()) {
            if (newIndex.isClustered()) {
                newIndex.appendClusterSql(sb);
            } else if (!((PgStatementContainer) newIndex.getParent()).isClustered()) {
                sb.append("\n\nALTER TABLE ")
                .append(newIndex.getParent().getQualifiedName())
                .append(" SET WITHOUT CLUSTER;");
            }
        }

        compareOptions(newIndex, sb);

        if (!Objects.equals(getComment(), newIndex.getComment())) {
            newIndex.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    private void appendClusterSql(StringBuilder sb) {
        sb.append("\n\nALTER ");
        sb.append(getParent().getTypeName()).append(' ');
        sb.append(getParent().getQualifiedName());
        sb.append(" CLUSTER ON ");
        sb.append(getName());
        sb.append(';');
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
        return index instanceof PgIndex
                && super.compareUnalterable(index)
                && Objects.equals(inherit, ((PgIndex) index).inherit)
                && Objects.equals(method, ((PgIndex) index).method)
                && nullsDistinction == ((PgIndex) index).nullsDistinction;
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
