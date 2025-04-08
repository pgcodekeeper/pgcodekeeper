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
package ru.taximaxim.codekeeper.core.schema.ms;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractView;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SourceStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class MsView extends AbstractView implements SourceStatement {

    private boolean ansiNulls;
    private boolean quotedIdentified;
    /**
     * Оption that blocks changes to objects on which the view depends without recreating it. <br>
     * <br>
     * Does not participate in comparison, since it is part of {@link #secondPart}
     */
    private boolean schemaBinding;

    private String firstPart;
    private String secondPart;

    private final Map<String, MsStatistics> statistics = new HashMap<>();

    public MsView(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        addViewFullSQL(script, true);
        appendOwnerSQL(script);
        appendPrivileges(script);
    }

    private void addViewFullSQL(SQLScript script, boolean isCreate) {
        final StringBuilder sb = new StringBuilder();
        sb.append("SET QUOTED_IDENTIFIER ").append(quotedIdentified ? "ON" : "OFF");
        sb.append(GO).append('\n');
        sb.append("SET ANSI_NULLS ").append(ansiNulls ? "ON" : "OFF");
        sb.append(GO).append('\n');

        appendSourceStatement(isCreate, sb, script.getSettings());
        script.addStatement(sb);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        MsView newView = (MsView) newCondition;
        boolean isNeedDepcies = false;
        if (ansiNulls != newView.ansiNulls
                || quotedIdentified != newView.quotedIdentified
                || !Objects.equals(firstPart, newView.firstPart)
                || !Objects.equals(secondPart, newView.secondPart)) {
            newView.addViewFullSQL(script, false);
            isNeedDepcies = true;
        }

        appendAlterOwner(newView, script);
        alterPrivileges(newView, script);

        return getObjectState(isNeedDepcies, script, startSize);
    }

    @Override
    public boolean canDropBeforeCreate() {
        return true;
    }

    @Override
    public boolean compare(PgStatement obj) {
        return obj instanceof MsView view
                && super.compare(obj)
                && Objects.equals(firstPart, view.firstPart)
                && Objects.equals(secondPart, view.secondPart)
                && quotedIdentified == view.quotedIdentified
                && ansiNulls == view.ansiNulls;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(firstPart);
        hasher.put(secondPart);
        hasher.put(quotedIdentified);
        hasher.put(ansiNulls);
    }

    @Override
    protected AbstractView getViewCopy() {
        MsView view = new MsView(name);
        view.setFirstPart(firstPart);
        view.setSecondPart(secondPart);
        view.setAnsiNulls(ansiNulls);
        view.setQuotedIdentified(quotedIdentified);
        view.setSchemaBinding(schemaBinding);
        return view;
    }

    @Override
    public void addChild(IStatement st) {
        if (st instanceof MsStatistics stat) {
            addStatistics(stat);
        } else {
            super.addChild(st);
        }
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        if (DbObjType.STATISTICS == type) {
            return getChildByName(statistics, name);
        }
        return super.getChild(name, type);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        super.fillChildrenList(l);
        l.add(statistics.values());
    }

    private void addStatistics(final MsStatistics stat) {
        addUnique(statistics, stat);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof MsView view && super.compareChildren(obj)) {
            return statistics.equals(view.statistics);
        }
        return false;
    }

    @Override
    public void computeChildrenHash(Hasher hasher) {
        super.computeChildrenHash(hasher);
        hasher.putUnordered(statistics);
    }

    public void setAnsiNulls(boolean ansiNulls) {
        this.ansiNulls = ansiNulls;
        resetHash();
    }

    public void setQuotedIdentified(boolean quotedIdentified) {
        this.quotedIdentified = quotedIdentified;
        resetHash();
    }

    @Override
    public String getFirstPart() {
        return firstPart;
    }

    @Override
    public void setFirstPart(String firstPart) {
        this.firstPart = firstPart;
        resetHash();
    }

    @Override
    public String getSecondPart() {
        return secondPart;
    }

    @Override
    public void setSecondPart(String secondPart) {
        this.secondPart = secondPart;
        resetHash();
    }

    public void setSchemaBinding(boolean schemaBinding) {
        this.schemaBinding = schemaBinding;
        resetHash();
    }

    public boolean isSchemaBinding() {
        return schemaBinding;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }
}
