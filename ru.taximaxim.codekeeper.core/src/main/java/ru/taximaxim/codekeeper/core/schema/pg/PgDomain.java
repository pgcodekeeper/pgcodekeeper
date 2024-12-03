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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLAction;

public class PgDomain extends PgStatement implements ISearchPath {

    private String dataType;
    private String collation;
    private String defaultValue;
    private boolean notNull;
    private final List<AbstractConstraint> constraints = new ArrayList<>();

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
        resetHash();
    }

    public String getCollation() {
        return collation;
    }

    public void setCollation(String collation) {
        this.collation = collation;
        resetHash();
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        resetHash();
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
        resetHash();
    }

    public List<AbstractConstraint> getConstraints() {
        return Collections.unmodifiableList(constraints);
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
    public void getCreationSQL(Collection<SQLAction> createActions) {
        SQLAction sql = new SQLAction();
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
        createActions.add(sql);

        for (AbstractConstraint notValid : notValids) {
            notValid.getCreationSQL(createActions);
        }

        appendOwnerSQL(createActions);
        appendPrivileges(createActions);
        appendComments(createActions);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> alterActions) {
        PgDomain newDomain = (PgDomain) newCondition;

        if (!Objects.equals(newDomain.getDataType(), getDataType()) ||
                !Objects.equals(newDomain.getCollation(), getCollation())) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        if (!Objects.equals(newDomain.getDefaultValue(), getDefaultValue())) {
            SQLAction sql = new SQLAction();
            sql.append("ALTER DOMAIN ").append(getQualifiedName());
            if (newDomain.getDefaultValue() == null) {
                sql.append("\n\tDROP DEFAULT");
            } else {
                sql.append("\n\tSET DEFAULT ").append(newDomain.getDefaultValue());
            }
            alterActions.add(sql);
        }

        if (newDomain.isNotNull() != isNotNull()) {
            SQLAction sql = new SQLAction();
            sql.append("ALTER DOMAIN ").append(getQualifiedName());
            if (newDomain.isNotNull()) {
                sql.append("\n\tSET NOT NULL");
            } else {
                sql.append("\n\tDROP NOT NULL");
            }
            alterActions.add(sql);
        }

        appendAlterOwner(newDomain, alterActions);
        alterPrivileges(newDomain, alterActions);
        appendAlterComments(newDomain, alterActions);

        AtomicBoolean needDepcyConstr = new AtomicBoolean();
        for (AbstractConstraint oldConstr : getConstraints()) {
            AbstractConstraint newConstr = newDomain.getConstraint(oldConstr.getName());
            if (newConstr == null) {
                oldConstr.getDropSQL(alterActions);
            } else {
                ((PgConstraint) oldConstr).appendAlterSQL(newConstr, needDepcyConstr, alterActions);
            }
        }
        for (AbstractConstraint newConstr : newDomain.getConstraints()) {
            if (getConstraint(newConstr.getName()) == null) {
                newConstr.getCreationSQL(alterActions);
            }
        }

        return getObjectState(alterActions);
    }

    @Override
    public void appendComments(Collection<SQLAction> sqlActions) {
        super.appendComments(sqlActions);
        appendChildrenComments(sqlActions);
    }

    private void appendChildrenComments(Collection<SQLAction> sqlActions) {
        for (AbstractConstraint c : constraints) {
            c.appendComments(sqlActions);
        }
    }

    @Override
    public PgDomain shallowCopy() {
        PgDomain domainDst = new PgDomain(getName());
        copyBaseFields(domainDst);
        domainDst.setDataType(getDataType());
        domainDst.setCollation(getCollation());
        domainDst.setDefaultValue(getDefaultValue());
        domainDst.setNotNull(isNotNull());
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
            return Objects.equals(dataType, dom.getDataType())
                    && Objects.equals(collation, dom.getCollation())
                    && Objects.equals(defaultValue, dom.getDefaultValue())
                    && notNull == dom.isNotNull()
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
        return (AbstractSchema) this.getParent();
    }
}
