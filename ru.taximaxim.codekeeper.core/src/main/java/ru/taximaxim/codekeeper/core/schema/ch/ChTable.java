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

import java.util.Collection;
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
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLAction;

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
    public void getCreationSQL(Collection<SQLAction> createActions) {
        var sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        appendIfNotExists(sb);
        sb.append(getQualifiedName()).append("\n(");

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
        createActions.add(new SQLAction(sb));
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> alterActions) {
        ChTable newTable = (ChTable) newCondition;

        if (isRecreated(newTable)) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        compareProjections(newTable.getProjections(), alterActions);
        engine.appendAlterSQL(newTable.getEngine(), getAlterTable(false), alterActions);
        compareComment(newTable.getComment(), alterActions);
        return getObjectState(alterActions);
    }

    private void compareProjections(Map<String, String> newProjections, Collection<SQLAction> sqlActions) {
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

        appendAlterProjections(toDrops, toAdds, sqlActions);
    }

    private void appendAlterProjections(Set<String> toDrops, Map<String, String> toAdds,
            Collection<SQLAction> sqlActions) {
        for (String toDrop : toDrops) {
            SQLAction sql = new SQLAction();
            sql.append(getAlterTable(false)).append("\n\tDROP PROJECTION IF EXISTS ").append(toDrop);
            sqlActions.add(sql);
        }
        for (Entry<String, String> toAdd : toAdds.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(getAlterTable(false)).append("\n\tADD PROJECTION ");
            appendIfNotExists(sb);
            sb.append(toAdd.getKey()).append(' ').append(toAdd.getValue());
            sqlActions.add(new SQLAction(sb));
        }
    }

    private void compareComment(String newComment, Collection<SQLAction> sqlActions) {
        if (Objects.equals(getComment(), newComment)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getAlterTable(false)).append("\n\tMODIFY COMMENT ");
        if (newComment == null) {
            sb.append("''");
        } else {
            sb.append(newComment);
        }
        sqlActions.add(new SQLAction(sb));
    }

    @Override
    public String getAlterTable(boolean only) {
        return ALTER_TABLE + getQualifiedName();
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
        return obj instanceof ChTable table && super.compare(table)
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
    public void appendComments(Collection<SQLAction> sqlActions) {
        // no impl
    }

    @Override
    protected void appendCommentSql(Collection<SQLAction> sqlActions) {
        // no impl
    }

    @Override
    public void compareOptions(IOptionContainer newContainer, Collection<SQLAction> alterActions) {
        // no impl
    }
}
