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
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatementWithSearchPath;

public class PgDomain extends PgStatementWithSearchPath {

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
    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE DOMAIN ").append(getQualifiedName())
        .append(" AS ").append(dataType);
        if (collation != null && !collation.isEmpty()) {
            sb.append(" COLLATE ").append(collation);
        }
        if (notNull) {
            sb.append(" NOT NULL");
        }
        if (defaultValue != null && !defaultValue.isEmpty()) {
            sb.append(" DEFAULT ").append(defaultValue);
        }

        List<AbstractConstraint> notValids = new ArrayList<>();
        for (AbstractConstraint constr : constraints) {
            if (constr.isNotValid()) {
                notValids.add(constr);
            } else {
                sb.append("\n\tCONSTRAINT ").append(PgDiffUtils.getQuotedName(constr.getName()))
                .append(' ').append(constr.getDefinition());
            }
        }
        sb.append(';');

        for (AbstractConstraint notValid : notValids) {
            sb.append("\n\n").append(notValid.getCreationSQL());
        }

        appendOwnerSQL(sb);
        appendPrivileges(sb);

        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgDomain newDomain = (PgDomain) newCondition;

        if (!Objects.equals(newDomain.getDataType(), getDataType()) ||
                !Objects.equals(newDomain.getCollation(), getCollation())) {
            isNeedDepcies.set(true);
            return true;
        }

        if (!Objects.equals(newDomain.getDefaultValue(), getDefaultValue())) {
            sb.append("\n\nALTER DOMAIN ").append(getQualifiedName());
            if (newDomain.getDefaultValue() == null) {
                sb.append("\n\tDROP DEFAULT");
            } else {
                sb.append("\n\tSET DEFAULT ").append(newDomain.getDefaultValue());
            }
            sb.append(';');
        }

        if (newDomain.isNotNull() != isNotNull()) {
            sb.append("\n\nALTER DOMAIN ").append(getQualifiedName());
            if (newDomain.isNotNull()) {
                sb.append("\n\tSET NOT NULL");
            } else {
                sb.append("\n\tDROP NOT NULL");
            }
            sb.append(';');
        }

        AtomicBoolean needDepcyConstr = new AtomicBoolean();
        for (AbstractConstraint oldConstr : getConstraints()) {
            AbstractConstraint newConstr = newDomain.getConstraint(oldConstr.getName());
            if (newConstr == null) {
                sb.append("\n\n").append(oldConstr.getDropSQL());
            } else {
                oldConstr.appendAlterSQL(newConstr, sb, needDepcyConstr);
            }
        }
        for (AbstractConstraint newConstr : newDomain.getConstraints()) {
            if (getConstraint(newConstr.getName()) == null) {
                sb.append("\n\n").append(newConstr.getCreationSQL());
            }
        }

        if (!Objects.equals(getOwner(), newDomain.getOwner())) {
            newDomain.appendOwnerSQL(sb);
        }
        alterPrivileges(newDomain, sb);
        compareComments(sb, newDomain);

        return sb.length() > startLength;
    }

    @Override
    public void appendComments(StringBuilder sb) {
        super.appendComments(sb);

        for (AbstractConstraint c : constraints) {
            c.appendComments(sb);
        }
    }

    @Override
    public void compareComments(StringBuilder sb, PgStatement newObj) {
        super.compareComments(sb, newObj);

        PgDomain newDomain = (PgDomain) newObj;
        for (AbstractConstraint newConstr : newDomain.getConstraints()) {
            AbstractConstraint oldConstr = getConstraint(newConstr.getName());
            if (oldConstr != null) {
                oldConstr.compareComments(sb, newConstr);
            } else if (newConstr.checkComments()) {
                sb.setLength(sb.length() + 1);
            }
        }
    }

    @Override
    public void appendAlterComments(StringBuilder sb, PgStatement newObj) {
        PgDomain newDomain = (PgDomain) newObj;
        super.appendAlterComments(sb, newDomain);

        for (AbstractConstraint newConstr : newDomain.getConstraints()) {
            AbstractConstraint oldConstr = getConstraint(newConstr.getName());
            if (oldConstr != null) {
                oldConstr.appendAlterComments(sb, newConstr);
            } else {
                newConstr.appendComments(sb);
            }
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

        if (obj instanceof PgDomain && super.compare(obj)) {
            PgDomain dom = (PgDomain) obj;
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
