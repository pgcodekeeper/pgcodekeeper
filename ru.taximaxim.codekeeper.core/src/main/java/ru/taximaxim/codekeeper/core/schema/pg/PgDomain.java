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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class PgDomain extends PgStatement implements ISearchPath {

    private String dataType;
    private String collation;
    private String defaultValue;
    private boolean notNull;
    private final List<AbstractConstraint> constraints = new ArrayList<>();

    public void setDataType(String dataType) {
        this.dataType = dataType;
        resetHash();
    }

    public void setCollation(String collation) {
        this.collation = collation;
        resetHash();
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        resetHash();
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
        resetHash();
    }

    public AbstractConstraint getConstraint(String name) {
        for (AbstractConstraint c : constraints) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public void addConstraint(AbstractConstraint constraint) {
        assertUnique(getConstraint(constraint.getName()), constraint);
        constraints.add(constraint);
        constraint.setParent(this);
        resetHash();
    }

    public PgDomain(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.DOMAIN;
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE DOMAIN ").append(getQualifiedName())
        .append(" AS ").append(dataType);
        if (collation != null && !collation.isEmpty()) {
            sql.append(" COLLATE ").append(collation);
        }
        if (notNull) {
            sql.append(" NOT NULL");
        }
        if (defaultValue != null && !defaultValue.isEmpty()) {
            sql.append(" DEFAULT ").append(defaultValue);
        }

        List<AbstractConstraint> notValids = new ArrayList<>();
        for (AbstractConstraint constr : constraints) {
            if (constr.isNotValid()) {
                notValids.add(constr);
            } else {
                sql.append("\n\tCONSTRAINT ").append(PgDiffUtils.getQuotedName(constr.getName()))
                .append(' ').append(constr.getDefinition());
            }
        }
        script.addStatement(sql);

        for (AbstractConstraint notValid : notValids) {
            notValid.getCreationSQL(script);
        }

        appendOwnerSQL(script);
        appendPrivileges(script);
        appendComments(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        PgDomain newDomain = (PgDomain) newCondition;

        if (!Objects.equals(newDomain.dataType, dataType) ||
                !Objects.equals(newDomain.collation, collation)) {
            return ObjectState.RECREATE;
        }

        if (!Objects.equals(newDomain.defaultValue, defaultValue)) {
            StringBuilder sql = new StringBuilder();
            sql.append("ALTER DOMAIN ").append(getQualifiedName());
            if (newDomain.defaultValue == null) {
                sql.append("\n\tDROP DEFAULT");
            } else {
                sql.append("\n\tSET DEFAULT ").append(newDomain.defaultValue);
            }
            script.addStatement(sql);
        }

        if (newDomain.notNull != notNull) {
            StringBuilder sql = new StringBuilder();
            sql.append("ALTER DOMAIN ").append(getQualifiedName());
            if (newDomain.notNull) {
                sql.append("\n\tSET NOT NULL");
            } else {
                sql.append("\n\tDROP NOT NULL");
            }
            script.addStatement(sql);
        }

        appendAlterOwner(newDomain, script);
        alterPrivileges(newDomain, script);
        appendAlterComments(newDomain, script);

        for (AbstractConstraint oldConstr : constraints) {
            AbstractConstraint newConstr = newDomain.getConstraint(oldConstr.getName());
            if (newConstr == null) {
                oldConstr.getDropSQL(script);
            } else if ((oldConstr.appendAlterSQL(newConstr, script) == ObjectState.RECREATE)) {
                oldConstr.getDropSQL(script);
                newConstr.getCreationSQL(script);
            }
        }
        for (AbstractConstraint newConstr : newDomain.constraints) {
            if (getConstraint(newConstr.getName()) == null) {
                newConstr.getCreationSQL(script);
            }
        }

        return getObjectState(script, startSize);
    }

    @Override
    public void appendComments(SQLScript script) {
        super.appendComments(script);
        appendChildrenComments(script);
    }

    private void appendChildrenComments(SQLScript script) {
        for (AbstractConstraint c : constraints) {
            c.appendComments(script);
        }
    }

    @Override
    public PgDomain shallowCopy() {
        PgDomain domainDst = new PgDomain(name);
        copyBaseFields(domainDst);
        domainDst.setDataType(dataType);
        domainDst.setCollation(collation);
        domainDst.setDefaultValue(defaultValue);
        domainDst.setNotNull(notNull);
        for (AbstractConstraint constr : constraints) {
            domainDst.addConstraint((AbstractConstraint) constr.deepCopy());
        }
        return domainDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgDomain dom && super.compare(obj)) {
            return Objects.equals(dataType, dom.dataType)
                    && Objects.equals(collation, dom.collation)
                    && Objects.equals(defaultValue, dom.defaultValue)
                    && notNull == dom.notNull
                    && PgDiffUtils.setlikeEquals(constraints, dom.constraints);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(dataType);
        hasher.put(collation);
        hasher.put(defaultValue);
        hasher.put(notNull);
        hasher.putUnordered(constraints);
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) parent;
    }
}
