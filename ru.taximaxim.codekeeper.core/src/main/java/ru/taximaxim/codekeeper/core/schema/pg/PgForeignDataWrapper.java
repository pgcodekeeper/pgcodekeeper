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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class PgForeignDataWrapper extends PgStatement implements PgForeignOptionContainer {

    private String handler;
    private String validator;
    private final Map<String, String> options = new LinkedHashMap<>();

    public PgForeignDataWrapper(String name) {
        super(name);
    }

    @Override
    public String getAlterHeader() {
        return "ALTER FOREIGN DATA WRAPPER " + getQualifiedName();
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

    public void setHandler(String handler) {
        this.handler = handler;
        resetHash();
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

        if (obj instanceof PgForeignDataWrapper fdw && super.compare(obj)) {
            return Objects.equals(handler, fdw.handler)
                    && Objects.equals(validator, fdw.validator)
                    && Objects.equals(options, fdw.options);
        }
        return false;
    }

    @Override
    public AbstractDatabase getDatabase() {
        return (AbstractDatabase) parent;
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sb = new StringBuilder();
        sb.append("CREATE FOREIGN DATA WRAPPER ");
        sb.append(PgDiffUtils.getQuotedName(name));
        if (handler != null) {
            sb.append(" HANDLER ").append(handler);
        }
        if (validator != null) {
            sb.append(" VALIDATOR ").append(validator);
        }
        if (!options.isEmpty()) {
            sb.append(' ');
        }
        appendOptions(sb);
        script.addStatement(sb);

        appendOwnerSQL(script);
        appendPrivileges(script);
        appendComments(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        boolean isNeedDepcies = false;
        PgForeignDataWrapper newForeign = (PgForeignDataWrapper) newCondition;

        if (!Objects.equals(newForeign.handler, handler)) {
            StringBuilder sql = new StringBuilder();
            sql.append(getAlterHeader());
            if (newForeign.handler != null) {
                sql.append(" HANDLER ").append(newForeign.handler);
                isNeedDepcies = true;
            } else {
                sql.append(" NO HANDLER");
            }
            script.addStatement(sql);
        }

        if (!Objects.equals(newForeign.validator, validator)) {
            StringBuilder sql = new StringBuilder();
            sql.append(getAlterHeader());
            if (newForeign.validator != null) {
                sql.append(" VALIDATOR ").append(newForeign.validator);
                isNeedDepcies = true;
            } else {
                sql.append(" NO VALIDATOR");
            }
            script.addStatement(sql);
        }

        compareOptions(newForeign, script);
        appendAlterOwner(newForeign, script);
        alterPrivileges(newCondition, script);
        appendAlterComments(newForeign, script);

        return getObjectState(isNeedDepcies, script, startSize);
    }

    @Override
    public PgStatement shallowCopy() {
        PgForeignDataWrapper copyFwd = new PgForeignDataWrapper(name);
        copyBaseFields(copyFwd);
        copyFwd.setHandler(handler);
        copyFwd.setValidator(validator);
        copyFwd.options.putAll(options);
        return copyFwd;
    }
}
