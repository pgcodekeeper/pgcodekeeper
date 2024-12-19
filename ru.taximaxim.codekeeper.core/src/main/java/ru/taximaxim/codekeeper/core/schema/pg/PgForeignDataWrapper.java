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
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public class PgForeignDataWrapper extends PgStatement implements PgForeignOptionContainer {

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

        if (obj instanceof PgForeignDataWrapper fdw && super.compare(obj)) {
            return Objects.equals(handler, fdw.getHandler())
                    && Objects.equals(validator, fdw.getValidator())
                    && Objects.equals(options, fdw.getOptions());
        }
        return false;
    }

    @Override
    public AbstractDatabase getDatabase() {
        return (AbstractDatabase) getParent();
    }

    @Override
    public void getCreationSQL(SQLScript script) {
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

        if (!Objects.equals(newForeign.getHandler(), getHandler())) {
            StringBuilder sql = new StringBuilder();
            sql.append(getAlterHeader());
            if (newForeign.getHandler() != null) {
                sql.append(" HANDLER ").append(newForeign.getHandler());
                isNeedDepcies = true;
            } else {
                sql.append(" NO HANDLER");
            }
            script.addStatement(sql);
        }

        if (!Objects.equals(newForeign.getValidator(), getValidator())) {
            StringBuilder sql = new StringBuilder();
            sql.append(getAlterHeader());
            if (newForeign.getValidator() != null) {
                sql.append(" VALIDATOR ").append(newForeign.getValidator());
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
        PgForeignDataWrapper copyFwd = new PgForeignDataWrapper(getName());
        copyBaseFields(copyFwd);
        copyFwd.setHandler(getHandler());
        copyFwd.setValidator(getValidator());
        copyFwd.options.putAll(options);
        return copyFwd;
    }
}
