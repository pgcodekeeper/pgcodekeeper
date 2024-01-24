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
package ru.taximaxim.codekeeper.core.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public abstract class AbstractType extends PgStatementWithSearchPath{

    protected AbstractType(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TYPE ").append(getQualifiedName());
        appendDef(sb);
        appendOwnerSQL(sb);
        appendPrivileges(sb);

        return sb.toString();
    }

    protected abstract void appendDef(StringBuilder sb);

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        AbstractType newType = (AbstractType) newCondition;

        if (isNeedRecreate(newType)) {
            isNeedDepcies.set(true);
            return true;
        }

        compareType(newType, sb, isNeedDepcies);

        if (!Objects.equals(getOwner(), newType.getOwner())) {
            newType.alterOwnerSQL(sb);
        }
        alterPrivileges(newType, sb);
        compareComments(sb, newType);

        return sb.length() > startLength;
    }

    private final boolean isNeedRecreate(AbstractType newType) {
        return !getClass().equals(newType.getClass()) || !compareUnalterable(newType);
    }

    protected abstract boolean compareUnalterable(AbstractType newType);

    protected void compareType(AbstractType newType, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        // subclasses may override if needed
    }

    protected void appendStringOption(StringBuilder sb, String name, String value) {
        if (value != null && !value.isEmpty()) {
            sb.append(",\n\t").append(name).append(" = ").append(value);
        }
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.TYPE;
    }

    @Override
    public AbstractType shallowCopy() {
        AbstractType typeDst = getTypeCopy();
        copyBaseFields(typeDst);
        return typeDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AbstractType) {
            AbstractType type = (AbstractType) obj;
            return super.compare(type);
        }
        return false;
    }

    protected abstract AbstractType getTypeCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) this.getParent();
    }
}
