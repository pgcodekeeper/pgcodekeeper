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
package ru.taximaxim.codekeeper.core.schema.ch;

import java.util.Objects;
import ru.taximaxim.codekeeper.core.ChDiffUtils;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class ChRole extends PgStatement {

    private static final String DEF_STORAGE = "local_directory";

    private String storageType = DEF_STORAGE;

    public ChRole(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ROLE ");
        appendIfNotExists(sbSQL, script.getSettings());
        sbSQL.append(ChDiffUtils.getQuotedName(name));
        if (!DEF_STORAGE.equals(storageType)) {
            sbSQL.append("\n\tIN ").append(storageType);
        }
        script.addStatement(sbSQL);
        appendPrivileges(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        ChRole newRole = (ChRole) newCondition;

        if (!Objects.equals(storageType, newRole.getStorageType())) {
            StringBuilder sql = new StringBuilder();
            sql.append("MOVE ROLE ")
            .append(getQualifiedName()).append(" TO ")
            .append(newRole.getStorageType());
            script.addStatement(sql);
        }
        alterPrivileges(newCondition, script);
        return getObjectState(script, startSize);
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

        if (obj instanceof ChRole role && super.compare(obj)) {
            return Objects.equals(storageType, role.storageType);
        }

        return false;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }

    @Override
    public AbstractDatabase getDatabase() {
        return (AbstractDatabase) parent;
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.ROLE;
    }

    @Override
    public PgStatement shallowCopy() {
        ChRole copy = new ChRole(name);
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