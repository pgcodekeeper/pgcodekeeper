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

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

/**
 * MS SQL schema code generation.
 */
public class MsSchema extends AbstractSchema {

    public MsSchema(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE SCHEMA ");
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        if (owner != null) {
            sbSQL.append("\nAUTHORIZATION ").append(MsDiffUtils.quoteName(owner));
        }
        sbSQL.append(GO);
        appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        if (!Objects.equals(getOwner(), newCondition.getOwner())) {
            newCondition.alterOwnerSQL(sb);
        }
        alterPrivileges(newCondition, sb);
        return sb.length() > startLength;
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
