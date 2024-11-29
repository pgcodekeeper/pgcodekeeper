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
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.ChDiffUtils;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SQLAction;

public class ChConstraint extends AbstractConstraint {

    private final boolean isAssume;
    private String expr;

    public ChConstraint(String name, boolean isAssume) {
        super(name);
        this.isAssume = isAssume;
    }

    public boolean isAssume() {
        return isAssume;
    }

    public void setExpr(String expr) {
        this.expr = expr;
        resetHash();
    }

    public String getExpr() {
        return expr;
    }

    @Override
    public String getDefinition() {
        final StringBuilder sb = new StringBuilder();
        sb.append(isAssume() ? "ASSUME " : "CHECK ").append(getExpr());
        return sb.toString();
    }

    @Override
    public void getCreationSQL(Collection<SQLAction> createActions) {
        final StringBuilder sb = new StringBuilder();
        appendAlterTable(sb);
        sb.append(" ADD CONSTRAINT ").append(ChDiffUtils.getQuotedName(name)).append(' ').append(getDefinition());
        createActions.add(new SQLAction(sb));
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> alterActions) {
        var newConstr = (ChConstraint) newCondition;
        if (!compareUnalterable(newConstr)) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }
        return ObjectState.NOTHING;
    }

    @Override
    public void getDropSQL(Collection<SQLAction> dropActions, boolean optionExists) {
        final StringBuilder sb = new StringBuilder();
        appendAlterTable(sb);
        sb.append("\n\tDROP CONSTRAINT ");
        if (optionExists) {
            sb.append(IF_EXISTS);
        }
        sb.append(ChDiffUtils.getQuotedName(getName()));
        dropActions.add(new SQLAction(sb));
    }

    private boolean compareUnalterable(ChConstraint newConstr) {
        return Objects.equals(isAssume, newConstr.isAssume())
                && Objects.equals(expr, newConstr.getExpr());
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(isAssume);
        hasher.put(expr);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof ChConstraint constr && super.compare(constr)
                && compareUnalterable(constr);
    }

    @Override
    protected AbstractConstraint getConstraintCopy() {
        var constr = new ChConstraint(name, isAssume);
        constr.setExpr(expr);
        return constr;
    }
}