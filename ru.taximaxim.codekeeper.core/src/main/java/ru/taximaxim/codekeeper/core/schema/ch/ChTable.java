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
package ru.taximaxim.codekeeper.core.schema.ch;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.IOptionContainer;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class ChTable extends AbstractTable {

    private final Map<String, String> projections = new LinkedHashMap<>();

    private ChEngine engine;

    public ChTable(String name) {
        super(name);
    }

    public void addProjection(String key, String expression) {
        projections.put(key, expression);
        resetHash();
    }

    public Map<String, String> getProjections() {
        return Collections.unmodifiableMap(projections);
    }

    public void setEngine(ChEngine engine) {
        this.engine = engine;
        resetHash();
    }

    public ChEngine getEngine() {
        return engine;
    }

    public void setPkExpr(String pkExpr) {
        engine.setPrimaryKey(pkExpr);
        resetHash();
    }

    @Override
    public String getCreationSQL() {
        var sb = new StringBuilder();
        sb.append("CREATE TABLE ").append(getQualifiedName()).append("\n(");

        for (AbstractColumn column : columns) {
            sb.append("\n\t").append(column.getFullDefinition()).append(",");
        }

        for (Entry<String, String> proj : projections.entrySet()) {
            sb.append("\n\tPROJECTION ").append(proj.getKey()).append(' ').append(proj.getValue()).append(',');
        }

        if (!columns.isEmpty() || !projections.isEmpty()) {
            sb.setLength(sb.length() - 1);
        }
        sb.append("\n)");

        engine.appendCreationSQL(sb);

        if (getComment() != null) {
            sb.append("\nCOMMENT ").append(getComment());
        }
        sb.append(';');

        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        ChTable newTable = (ChTable) newCondition;

        if (isRecreated(newTable)) {
            isNeedDepcies.set(true);
            return true;
        }

        comparePojections(sb, newTable.getProjections());
        engine.appendAlterSQL(sb, newTable.getEngine(), getAlterTable(true, false));
        compareComment(sb, newTable.getComment());
        return sb.length() > startLength;
    }

    private void comparePojections(StringBuilder sb, Map<String, String> newProjections) {
        if (Objects.equals(projections, newProjections)) {
            return;
        }
        Set<String> toDrops = new HashSet<>();
        Map<String, String> toAdds = new LinkedHashMap<>();

        for (String oldKey : projections.keySet()) {
            if (!newProjections.containsKey(oldKey)) {
                toDrops.add(oldKey);
                continue;
            }
            var newValue = newProjections.get(oldKey);
            if (!Objects.equals(newValue, projections.get(oldKey))) {
                toDrops.add(oldKey);
                toAdds.put(oldKey, newValue);
            }
        }

        for (String newKey : newProjections.keySet()) {
            if (!projections.containsKey(newKey)) {
                toAdds.put(newKey, newProjections.get(newKey));
            }
        }

        appendAlterProjections(sb, toDrops, toAdds);
    }

    private void appendAlterProjections(StringBuilder sb, Set<String> toDrops, Map<String, String> toAdds) {
        for (String toDrop : toDrops) {
            sb.append(getAlterTable(true, false)).append("\n\tDROP PROJECTION IF EXISTS ").append(toDrop)
            .append(getSeparator());
        }
        for (Entry<String, String> toAdd : toAdds.entrySet()) {
            sb.append(getAlterTable(true, false)).append("\n\tADD PROJECTION ");
            appendIfNotExists(sb);
            sb.append(toAdd.getKey()).append(' ').append(toAdd.getValue()).append(getSeparator());
        }
    }

    private void compareComment(StringBuilder sb, String newComment) {
        if (Objects.equals(getComment(), newComment)) {
            return;
        }
        sb.append(getAlterTable(true, false)).append("\n\tMODIFY COMMENT ");
        if (newComment == null) {
            sb.append("''");
        } else {
            sb.append(newComment);
        }
        sb.append(getSeparator());
    }

    @Override
    public String getAlterTable(boolean nextLine, boolean only) {
        StringBuilder sb = new StringBuilder();
        if (nextLine) {
            sb.append("\n\n");
        }
        sb.append("ALTER TABLE ");
        sb.append(getQualifiedName());
        return sb.toString();
    }

    @Override
    protected boolean isNeedRecreate(AbstractTable newTable) {
        var newEngine = ((ChTable) newTable).getEngine();
        return !engine.compareUnalterable(newEngine)
                && !engine.isModifybleSampleBy(newEngine.getSampleBy());
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(projections);
        hasher.put(engine);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChTable)) {
            return false;
        }
        var table = (ChTable) obj;
        return super.compare(table)
                && Objects.equals(projections, table.projections)
                && Objects.equals(engine, table.getEngine());
    }

    @Override
    protected AbstractTable getTableCopy() {
        var table = new ChTable(name);
        table.projections.putAll(projections);
        table.setEngine(getEngine());
        return table;
    }

    @Override
    public void appendComments(StringBuilder sb) {
        // no impl
    }

    @Override
    protected void appendCommentSql(StringBuilder sb) {
        // no impl
    }

    @Override
    public void compareOptions(IOptionContainer newContainer, StringBuilder sb) {
        // no impl
    }
}
