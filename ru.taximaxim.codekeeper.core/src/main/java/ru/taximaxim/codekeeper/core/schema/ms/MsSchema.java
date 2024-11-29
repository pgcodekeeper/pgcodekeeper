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
package ru.taximaxim.codekeeper.core.schema.ms;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SQLAction;

/**
 * MS SQL schema code generation.
 */
public class MsSchema extends AbstractSchema {

    public MsSchema(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(Collection<SQLAction> createActions) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE SCHEMA ");
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        if (owner != null) {
            sbSQL.append("\nAUTHORIZATION ").append(MsDiffUtils.quoteName(owner));
        }
        createActions.add(new SQLAction(sbSQL));
        appendPrivileges(createActions);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> alterActions) {
        if (!Objects.equals(getOwner(), newCondition.getOwner())) {
            newCondition.alterOwnerSQL(alterActions);
        }
        alterPrivileges(newCondition, alterActions);
        return getObjectState(alterActions);
    }

    @Override
    protected AbstractSchema getSchemaCopy() {
        return new MsSchema(getName());
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }
}
