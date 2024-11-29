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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SQLAction;

public class PgCollation extends PgStatement implements ISearchPath {

    public PgCollation(String name) {
        super(name);
    }

    private String lcCollate;
    private String lcCtype;
    private String provider;
    private boolean deterministic = true;
    private String rules;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.COLLATION;
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent();
    }

    public boolean isDeterministic() {
        return deterministic;
    }

    public void setDeterministic(boolean deterministic) {
        this.deterministic = deterministic;
        resetHash();
    }

    public String getLcCollate() {
        return lcCollate;
    }

    public void setLcCollate(final String lcCollate) {
        this.lcCollate = lcCollate;
        resetHash();
    }

    public String getLcCtype() {
        return lcCtype;
    }

    public void setLcCtype(final String lcCtype) {
        this.lcCtype = lcCtype;
        resetHash();
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(final String provider) {
        this.provider = provider;
        resetHash();
    }

    public String getRules() {
        return rules;
    }

    public void setRules(final String rules) {
        this.rules = rules;
        resetHash();
    }

    @Override
    public void getCreationSQL(Collection<SQLAction> createActions) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE COLLATION ");
        appendIfNotExists(sbSQL);
        sbSQL.append(getQualifiedName());
        sbSQL.append(" (");
        if (Objects.equals(getLcCollate(), getLcCtype())) {
            sbSQL.append("LOCALE = ").append(getLcCollate());
        } else {
            sbSQL.append("LC_COLLATE = ").append(getLcCollate());
            sbSQL.append(", LC_CTYPE = ").append(getLcCtype());
        }
        if (getProvider() != null) {
            sbSQL.append(", PROVIDER = ").append(getProvider());
        }
        if (!isDeterministic()) {
            sbSQL.append(", DETERMINISTIC = FALSE");
        }
        if (getRules() != null) {
            sbSQL.append(", RULES = ").append(getRules());
        }

        sbSQL.append(")");
        createActions.add(new SQLAction(sbSQL));

        appendOwnerSQL(createActions);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> alterActions) {
        PgCollation newCollation = (PgCollation) newCondition;

        if (!compareUnalterable(newCollation)) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        if (!Objects.equals(getOwner(), newCollation.getOwner())) {
            newCollation.alterOwnerSQL(alterActions);
        }
        appendAlterComments(newCollation, alterActions);

        return getObjectState(alterActions);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgCollation coll && super.compare(obj)) {
            return compareUnalterable(coll);
        }
        return false;
    }

    private boolean compareUnalterable(PgCollation coll) {
        return deterministic == coll.isDeterministic()
                && Objects.equals(lcCollate, coll.getLcCollate())
                && Objects.equals(lcCtype, coll.getLcCtype())
                && Objects.equals(provider, coll.getProvider())
                && Objects.equals(rules, coll.getRules());
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(deterministic);
        hasher.put(lcCollate);
        hasher.put(lcCtype);
        hasher.put(provider);
        hasher.put(rules);
    }

    @Override
    public PgStatement shallowCopy() {
        PgCollation collationDst = new PgCollation(getName());
        copyBaseFields(collationDst);
        collationDst.setLcCollate(getLcCollate());
        collationDst.setLcCtype(getLcCtype());
        collationDst.setProvider(getProvider());
        collationDst.setDeterministic(isDeterministic());
        collationDst.setRules(getRules());
        return collationDst;
    }
}
