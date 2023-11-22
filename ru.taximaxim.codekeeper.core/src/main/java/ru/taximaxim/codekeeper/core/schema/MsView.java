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
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;

public class MsView extends AbstractView implements SourceStatement {

    private boolean ansiNulls;
    private boolean quotedIdentified;

    private String firstPart;
    private String secondPart;

    public MsView(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sbSQL = new StringBuilder();
        sbSQL.append(getViewFullSQL(true));

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);
        return sbSQL.toString();
    }

    private String getViewFullSQL(boolean isCreate) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("SET QUOTED_IDENTIFIER ").append(isQuotedIdentified() ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS ").append(isAnsiNulls() ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');

        appendSourceStatement(isCreate, sbSQL);
        sbSQL.append(GO);

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsView newView = (MsView) newCondition;

        if (isAnsiNulls() != newView.isAnsiNulls()
                || isQuotedIdentified() != newView.isQuotedIdentified()
                || !Objects.equals(getFirstPart(), newView.getFirstPart())
                || !Objects.equals(getSecondPart(), newView.getSecondPart())) {
            sb.append(newView.getViewFullSQL(false));
            isNeedDepcies.set(true);
        }

        if (!Objects.equals(getOwner(), newView.getOwner())) {
            newView.alterOwnerSQL(sb);
        }
        alterPrivileges(newView, sb);

        return sb.length() > startLength;
    }

    @Override
    public boolean canDropBeforeCreate() {
        return true;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsView && super.compare(obj)) {
            MsView view = (MsView) obj;
            return Objects.equals(getFirstPart(), view.getFirstPart())
                    && Objects.equals(getSecondPart(), view.getSecondPart())
                    && isQuotedIdentified() == view.isQuotedIdentified()
                    && isAnsiNulls() == view.isAnsiNulls();
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(getFirstPart());
        hasher.put(getSecondPart());
        hasher.put(isQuotedIdentified());
        hasher.put(isAnsiNulls());
    }

    @Override
    protected AbstractView getViewCopy() {
        MsView view = new MsView(getName());
        view.setFirstPart(getFirstPart());
        view.setSecondPart(getSecondPart());
        view.setAnsiNulls(isAnsiNulls());
        view.setQuotedIdentified(isQuotedIdentified());
        return view;
    }

    public void setAnsiNulls(boolean ansiNulls) {
        this.ansiNulls = ansiNulls;
        resetHash();
    }

    public boolean isAnsiNulls() {
        return ansiNulls;
    }

    public void setQuotedIdentified(boolean quotedIdentified) {
        this.quotedIdentified = quotedIdentified;
        resetHash();
    }

    public boolean isQuotedIdentified() {
        return quotedIdentified;
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
}
