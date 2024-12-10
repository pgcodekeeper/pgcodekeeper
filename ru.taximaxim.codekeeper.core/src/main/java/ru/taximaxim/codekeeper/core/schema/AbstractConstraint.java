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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema;

import java.util.Collections;
import java.util.Set;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

/**
 * Stores table constraint information.
 */
public abstract class AbstractConstraint extends PgStatement implements IConstraint, ISearchPath {

    private boolean notValid;

    protected AbstractConstraint(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.CONSTRAINT;
    }

    @Override
    public Set<String> getColumns() {
        return Collections.emptySet();
    }

    @Override
    public boolean containsColumn(String name) {
        return getColumns().contains(name);
    }

    public boolean isNotValid() {
        return notValid;
    }

    public void setNotValid(boolean notValid) {
        this.notValid = notValid;
        resetHash();
    }

    @Override
    public PgObjLocation getLocation() {
        PgObjLocation location = getMeta().getLocation();
        if (location == null) {
            location = getParent().getLocation();
        }
        return location;
    }

    @Override
    public void setLocation(PgObjLocation location) {
        getMeta().setLocation(location);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractConstraint con && super.compare(obj)) {
            return notValid == con.isNotValid();
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(notValid);
    }

    @Override
    public AbstractConstraint shallowCopy() {
        AbstractConstraint constraintDst = getConstraintCopy();
        copyBaseFields(constraintDst);
        constraintDst.setNotValid(isNotValid());
        return constraintDst;
    }

    protected void appendAlterTable(StringBuilder sb) {
        sb.append("ALTER ").append(getParent().getStatementType().name()).append(' ');
        sb.append(getParent().getQualifiedName());
    }

    protected abstract AbstractConstraint getConstraintCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent().getParent();
    }

    @Override
    public String getTableName() {
        return getParent().getName();
    }

    @Override
    public boolean isSubElement() {
        return true;
    }
}