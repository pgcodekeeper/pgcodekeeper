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
package ru.taximaxim.codekeeper.core.schema;

import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public abstract class AbstractType extends PgStatement implements ISearchPath {

    protected AbstractType(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TYPE ").append(getQualifiedName());
        appendDef(sb);
        script.addStatement(sb);
        appendOptions(script);
        appendOwnerSQL(script);
        appendPrivileges(script);
        appendComments(script);
    }


    protected abstract void appendDef(StringBuilder sb);

    protected void appendOptions(SQLScript script) {
        // subclasses will override if needed
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        AbstractType newType = (AbstractType) newCondition;

        if (isNeedRecreate(newType)) {
            return ObjectState.RECREATE;
        }
        AtomicBoolean isNeedDepcies = new AtomicBoolean(false);
        compareType(newType, isNeedDepcies, script);
        appendAlterOwner(newType, script);
        alterPrivileges(newType, script);
        appendAlterComments(newType, script);
        return getObjectState(isNeedDepcies.get(), script, startSize);
    }

    private final boolean isNeedRecreate(AbstractType newType) {
        return !getClass().equals(newType.getClass()) || !compareUnalterable(newType);
    }

    protected abstract boolean compareUnalterable(AbstractType newType);

    protected void compareType(AbstractType newType, AtomicBoolean isNeedDepcies, SQLScript script) {
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
        return obj instanceof AbstractType && super.compare(obj);
    }

    protected abstract AbstractType getTypeCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) parent;
    }
}
