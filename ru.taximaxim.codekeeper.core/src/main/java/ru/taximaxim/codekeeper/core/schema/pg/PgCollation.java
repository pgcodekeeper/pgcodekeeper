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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class PgCollation extends PgStatement implements ISearchPath {

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
        return (AbstractSchema) parent;
    }

    public void setDeterministic(boolean deterministic) {
        this.deterministic = deterministic;
        resetHash();
    }

    public void setLcCollate(final String lcCollate) {
        this.lcCollate = lcCollate;
        resetHash();
    }

    public void setLcCtype(final String lcCtype) {
        this.lcCtype = lcCtype;
        resetHash();
    }

    public void setProvider(final String provider) {
        this.provider = provider;
        resetHash();
    }

    public void setRules(final String rules) {
        this.rules = rules;
        resetHash();
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE COLLATION ");
        appendIfNotExists(sbSQL);
        sbSQL.append(getQualifiedName());
        sbSQL.append(" (");
        if (Objects.equals(lcCollate, lcCtype)) {
            sbSQL.append("LOCALE = ").append(lcCollate);
        } else {
            sbSQL.append("LC_COLLATE = ").append(lcCollate);
            sbSQL.append(", LC_CTYPE = ").append(lcCtype);
        }
        if (provider != null) {
            sbSQL.append(", PROVIDER = ").append(provider);
        }
        if (!deterministic) {
            sbSQL.append(", DETERMINISTIC = FALSE");
        }
        if (rules != null) {
            sbSQL.append(", RULES = ").append(rules);
        }

        sbSQL.append(")");
        script.addStatement(sbSQL);

        appendOwnerSQL(script);
        appendComments(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        PgCollation newCollation = (PgCollation) newCondition;

        if (!compareUnalterable(newCollation)) {
            return ObjectState.RECREATE;
        }

        appendAlterOwner(newCollation, script);
        appendAlterComments(newCollation, script);

        return getObjectState(script, startSize);
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
        return deterministic == coll.deterministic
                && Objects.equals(lcCollate, coll.lcCollate)
                && Objects.equals(lcCtype, coll.lcCtype)
                && Objects.equals(provider, coll.provider)
                && Objects.equals(rules, coll.rules);
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
        PgCollation collationDst = new PgCollation(name);
        copyBaseFields(collationDst);
        collationDst.setLcCollate(lcCollate);
        collationDst.setLcCtype(lcCtype);
        collationDst.setProvider(provider);
        collationDst.setDeterministic(deterministic);
        collationDst.setRules(rules);
        return collationDst;
    }
}
