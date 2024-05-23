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
package ru.taximaxim.codekeeper.core.schema.ch;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.ChDiffUtils;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public final class ChRole extends PgStatement {

    private static final String DEF_STORAGE = "local_directory";

    private String storageType = DEF_STORAGE;

    public ChRole(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ROLE ");
        sbSQL.append(ChDiffUtils.getQuotedName(getName()));
        if (!DEF_STORAGE.equals(storageType)) {
            sbSQL.append("\n\tIN ").append(storageType);
        }
        sbSQL.append(";");
        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        ChRole newRole = (ChRole) newCondition;
        final int startLength = sb.length();

        if (!Objects.equals(storageType, newRole.getStorageType())) {
            sb.append("MOVE ROLE ")
            .append(getQualifiedName()).append(" TO ")
            .append(newRole.getStorageType()).append(";");
        }
        return sb.length() > startLength;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(storageType);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        return obj instanceof ChRole && super.compare(obj)
                && Objects.equals(storageType, ((ChRole) obj).storageType);
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }

    @Override
    public AbstractDatabase getDatabase() {
        return (AbstractDatabase) getParent();
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.ROLE;
    }

    @Override
    public PgStatement shallowCopy() {
        ChRole copy = new ChRole(getName());
        copyBaseFields(copy);
        copy.setStorageType(storageType);
        return copy;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
        resetHash();
    }
}