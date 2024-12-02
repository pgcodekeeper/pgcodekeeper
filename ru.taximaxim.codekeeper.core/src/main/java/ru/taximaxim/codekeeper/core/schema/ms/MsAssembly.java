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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SQLAction;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public class MsAssembly extends PgStatement {

    private static final int PREVIEW_LENGTH = 256*4;

    private final List<String> binaries = new ArrayList<>();
    private String permission = "SAFE";
    private boolean isVisible = true;

    public MsAssembly(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.ASSEMBLY;
    }

    @Override
    public AbstractDatabase getDatabase() {
        return (AbstractDatabase) getParent();
    }

    @Override
    public void getCreationSQL(Collection<SQLAction> createActions) {
        getAssemblyFullSQL(false, createActions);
    }

    /**
     * Returns assembly definition without full binaries
     */
    public String getPreview() {
        Set<SQLAction> sqlActions = new LinkedHashSet<>();
        getAssemblyFullSQL(true, sqlActions);
        return SQLScript.getText(sqlActions, getDbType());
    }

    private void getAssemblyFullSQL(boolean isPreview, Collection<SQLAction> sqlActions) {
        SQLAction sql = new SQLAction();

        sql.append("CREATE ASSEMBLY ").append(MsDiffUtils.quoteName(name));
        if (owner != null) {
            sql.append("\nAUTHORIZATION ").append(MsDiffUtils.quoteName(owner));
        }

        sql.append("\nFROM ");
        String bin = String.join(",\n", binaries);

        if (isPreview && bin.length() > PREVIEW_LENGTH) {
            sql.append(bin.substring(0, PREVIEW_LENGTH)).append("\n<... PREVIEW TRIMMED>");
        } else {
            sql.append(bin);
        }

        sql.append("\nWITH PERMISSION_SET = ").append(permission);
        sqlActions.add(sql);
        if (!isVisible) {
            SQLAction sqlVisible = new SQLAction();
            sqlVisible.append("ALTER ASSEMBLY ").append(MsDiffUtils.quoteName(name))
            .append(" WITH VISIBILITY = OFF");
            sqlActions.add(sqlVisible);
        }

        appendPrivileges(sqlActions);
    }


    @Override
    public void getDropSQL(Collection<SQLAction> dropActions, boolean optionExists) {
        StringBuilder dropSb = new StringBuilder();
        dropSb.append("DROP ASSEMBLY ");
        if (optionExists) {
            dropSb.append(IF_EXISTS);
        }
        dropSb.append(MsDiffUtils.quoteName(name))
        .append(" WITH NO DEPENDENTS");
        dropActions.add(new SQLAction(dropSb));
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> alterActions) {
        MsAssembly newAss = (MsAssembly) newCondition;

        // https://docs.microsoft.com/ru-ru/sql/t-sql/statements/alter-assembly-transact-sql?view=sql-server-2016
        // TODO add/drop binary as file name. What is filename?
        if (!Objects.equals(newAss.getBinaries(), getBinaries())) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        appendAlterOwner(newAss, alterActions);

        if (newAss.isVisible() != isVisible()) {
            SQLAction sql = new SQLAction();
            sql.append("ALTER ASSEMBLY ").append(MsDiffUtils.quoteName(name))
            .append(" WITH VISIBILITY = ").append(newAss.isVisible() ? "ON" : "OFF");
            alterActions.add(sql);
        }

        if (!Objects.equals(newAss.getPermission(), getPermission())) {
            StringBuilder sb = new StringBuilder();
            sb.append("ALTER ASSEMBLY ").append(MsDiffUtils.quoteName(name))
            .append(" WITH PERMISSION_SET = ").append(newAss.getPermission());
            alterActions.add(new SQLAction(sb));
        }

        return getObjectState(alterActions);
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(binaries);
        hasher.put(isVisible);
        hasher.put(permission);
    }

    @Override
    public MsAssembly shallowCopy() {
        MsAssembly assDst = new MsAssembly(getName());
        copyBaseFields(assDst);
        assDst.setPermission(getPermission());
        assDst.binaries.addAll(binaries);
        assDst.setVisible(isVisible());
        return assDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof MsAssembly as && super.compare(obj)) {
            return Objects.equals(isVisible, as.isVisible())
                    && Objects.equals(permission, as.getPermission())
                    && binaries.equals(as.binaries);
        }

        return false;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(final String permission) {
        this.permission = permission;
        resetHash();
    }

    public List<String> getBinaries() {
        return Collections.unmodifiableList(binaries);
    }

    public void addBinary(final String binary) {
        binaries.add(binary);
        resetHash();
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(final boolean isVisible) {
        this.isVisible = isVisible;
        resetHash();
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }
}
