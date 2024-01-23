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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class PgForeignDataWrapper extends PgStatement implements PgForeignOptionContainer{
    private String handler;
    private String validator;
    private final Map<String, String> options = new LinkedHashMap<>();

    public PgForeignDataWrapper(String name) {
        super(name);
    }

    @Override
    public String getAlterHeader() {
        return "\n\nALTER FOREIGN DATA WRAPPER " + getQualifiedName();
    }

    @Override
    public Map<String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public void addOption(String key, String value) {
        options.put(key, value);
        resetHash();
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
        resetHash();
    }

    public String getValidator() {
        return validator;
    }

    public void setValidator(String validator) {
        this.validator = validator;
        resetHash();
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FOREIGN_DATA_WRAPPER;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(handler);
        hasher.put(validator);
        hasher.put(options);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgForeignDataWrapper && super.compare(obj)) {
            PgForeignDataWrapper fdw = (PgForeignDataWrapper) obj;
            return Objects.equals(handler, fdw.getHandler())
                    && Objects.equals(validator, fdw.getValidator())
                    && Objects.equals(options, fdw.getOptions());
        }
        return false;
    }

    @Override
    public PgDatabase getDatabase() {
        return (PgDatabase)getParent();
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CREATE FOREIGN DATA WRAPPER ");
        sb.append(PgDiffUtils.getQuotedName(getName()));
        if (getHandler() != null) {
            sb.append(" HANDLER ").append(getHandler());
        }
        if (getValidator() != null) {
            sb.append(" VALIDATOR ").append(getValidator());
        }
        if (!getOptions().isEmpty()) {
            sb.append(' ');
        }
        appendOptions(sb);
        sb.append(';');

        appendOwnerSQL(sb);
        appendPrivileges(sb);

        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgForeignDataWrapper newForeign = (PgForeignDataWrapper) newCondition;

        if (!Objects.equals(newForeign.getHandler(), getHandler())) {
            sb.append(getAlterHeader());
            if (newForeign.getHandler() != null) {
                sb.append(" HANDLER ").append(newForeign.getHandler());
                isNeedDepcies.set(true);
            } else {
                sb.append(" NO HANDLER");
            }
            sb.append(';');
        }

        if (!Objects.equals(newForeign.getValidator(), getValidator())) {
            sb.append(getAlterHeader());
            if (newForeign.getValidator() != null) {
                sb.append(" VALIDATOR ").append(newForeign.getValidator());
                isNeedDepcies.set(true);
            } else {
                sb.append(" NO VALIDATOR");
            }
            sb.append(';');
        }

        if (!Objects.equals(newForeign.getOptions(), getOptions())) {
            compareOptions(newForeign, sb);
        }

        if (!Objects.equals(newForeign.getOwner(), getOwner())) {
            newForeign.appendOwnerSQL(sb);
        }
        alterPrivileges(newCondition, sb);
        compareComments(sb, newForeign);

        return sb.length() > startLength;
    }

    @Override
    public PgStatement shallowCopy() {
        PgForeignDataWrapper copyFwd = new PgForeignDataWrapper(getName());
        copyBaseFields(copyFwd);
        copyFwd.setHandler(getHandler());
        copyFwd.setValidator(getValidator());
        copyFwd.options.putAll(options);
        return copyFwd;
    }
}
