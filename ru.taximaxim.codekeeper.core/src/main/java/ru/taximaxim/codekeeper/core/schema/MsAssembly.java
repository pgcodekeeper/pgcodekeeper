/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

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
    public PgDatabase getDatabase() {
        return (PgDatabase) getParent();
    }

    @Override
    public String getCreationSQL() {
        return getAssemblyFullSQL(false);
    }

    /**
     * Returns assembly definition without full binaries
     */
    public String getPreview() {
        return getAssemblyFullSQL(true);
    }

    private String getAssemblyFullSQL(boolean isPreview) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE ASSEMBLY ").append(MsDiffUtils.quoteName(name));
        if (owner != null) {
            sb.append("\nAUTHORIZATION ").append(MsDiffUtils.quoteName(owner));
        }

        sb.append("\nFROM ");
        String bin = String.join(",\n", binaries);

        if (isPreview && bin.length() > PREVIEW_LENGTH) {
            sb.append(bin.substring(0, PREVIEW_LENGTH)).append("\n<... PREVIEW TRIMMED>");
        } else {
            sb.append(bin);
        }

        sb.append("\nWITH PERMISSION_SET = ").append(permission);
        sb.append(GO);

        if (!isVisible) {
            sb.append("\nALTER ASSEMBLY ").append(MsDiffUtils.quoteName(name))
            .append(" WITH VISIBILITY = OFF").append(GO);
        }

        appendPrivileges(sb);

        return sb.toString();
    }


    @Override
    public String getDropSQL(boolean optionExists) {
        StringBuilder dropSb = new StringBuilder();
        dropSb.append("DROP ASSEMBLY ");
        if (optionExists) {
            dropSb.append("IF EXISTS ");
        }
        dropSb.append(MsDiffUtils.quoteName(name))
        .append(" WITH NO DEPENDENTS")
        .append(GO);
        return dropSb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsAssembly newAss = (MsAssembly) newCondition;

        // https://docs.microsoft.com/ru-ru/sql/t-sql/statements/alter-assembly-transact-sql?view=sql-server-2016
        // TODO add/drop binary as file name. What is filename?
        if (!Objects.equals(newAss.getBinaries(), getBinaries())) {
            isNeedDepcies.set(true);
            return true;
        }

        if (!Objects.equals(getOwner(), newAss.getOwner())) {
            newAss.alterOwnerSQL(sb);
        }

        if (newAss.isVisible() != isVisible()) {
            sb.append("\nALTER ASSEMBLY ").append(MsDiffUtils.quoteName(name))
            .append(" WITH VISIBILITY = ").append(newAss.isVisible() ? "ON" : "OFF").append(GO);
        }

        if (!Objects.equals(newAss.getPermission(), getPermission())) {
            sb.append("\nALTER ASSEMBLY ").append(MsDiffUtils.quoteName(name))
            .append(" WITH PERMISSION_SET = ").append(newAss.getPermission()).append(GO);
        }

        return sb.length() > startLength;
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

        if (obj instanceof MsAssembly && super.compare(obj)) {
            MsAssembly as = (MsAssembly) obj;
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
    public boolean isPostgres() {
        return false;
    }
}
