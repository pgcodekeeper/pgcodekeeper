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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractStatistics;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementUtils;

public class PgStatistics extends AbstractStatistics {

    private int statistics = -1;
    private List<String> kinds = new ArrayList<>();
    private List<String> expressions = new ArrayList<>();
    private String foreignSchema;
    private String foreignTable;

    public PgStatistics(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CREATE STATISTICS ");
        appendIfNotExists(sb);
        sb.append(getQualifiedName());
        StatementUtils.appendCollection(sb, kinds, ", ", true);
        sb.append(" ON ");
        StatementUtils.appendCollection(sb, expressions, ", ", false);
        sb.append(" FROM ");
        if (foreignSchema != null) {
            sb.append(PgDiffUtils.getQuotedName(foreignSchema)).append('.');
        }
        sb.append(PgDiffUtils.getQuotedName(foreignTable));
        sb.append(getSeparator());

        if (statistics > 0) {
            sb.append("\n\n");
            appendStatistics(sb, this);
        }

        appendOwnerSQL(sb);

        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();

        PgStatistics newStat = (PgStatistics) newCondition;
        if (!compareUnalterable(newStat)) {
            isNeedDepcies.set(true);
            return true;
        }

        if (statistics != newStat.statistics) {
            appendStatistics(sb, newStat);
        }

        if (!Objects.equals(getOwner(), newStat.getOwner())) {
            newStat.alterOwnerSQL(sb);
        }
        compareComments(sb, newStat);

        return sb.length() > startLength;
    }

    private void appendStatistics(StringBuilder sb, PgStatistics stat) {
        sb.append("ALTER STATISTICS ").append(stat.getQualifiedName());
        sb.append(" SET STATISTICS ").append(stat.statistics).append(getSeparator());
    }

    public void setForeignSchema(String foreignSchema) {
        this.foreignSchema = foreignSchema;
        resetHash();
    }

    public void setForeignTable(String foreignTable) {
        this.foreignTable = foreignTable;
        resetHash();
    }

    public void setStatistics(int statistics) {
        this.statistics = statistics;
        resetHash();
    }

    public void addKind(String kind) {
        kinds.add(kind);
        resetHash();
    }

    public void addExpr(String expression) {
        expressions.add(expression);
        resetHash();
    }

    public String getForeignSchema() {
        return foreignSchema;
    }

    public String getForeignTable() {
        return foreignTable;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgStatistics && super.compare(obj)) {
            PgStatistics stat = (PgStatistics) obj;
            return compareUnalterable(stat)
                    && stat.statistics == statistics;
        }

        return false;
    }

    private boolean compareUnalterable(PgStatistics stat) {
        return Objects.equals(kinds, stat.kinds)
                && Objects.equals(expressions, stat.expressions)
                && Objects.equals(stat.foreignSchema, foreignSchema)
                && Objects.equals(stat.foreignTable, foreignTable);
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(kinds);
        hasher.put(expressions);
        hasher.put(statistics);
        hasher.put(foreignSchema);
        hasher.put(foreignTable);
    }

    @Override
    protected PgStatistics getStatisticsCopy() {
        PgStatistics stat = new PgStatistics(getName());
        stat.kinds.addAll(kinds);
        stat.expressions.addAll(expressions);
        stat.setStatistics(statistics);
        stat.setForeignSchema(foreignSchema);
        stat.setForeignTable(foreignTable);
        return stat;
    }
}
