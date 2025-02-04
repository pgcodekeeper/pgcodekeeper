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

public final class PgServer extends PgStatement implements PgForeignOptionContainer {

    private String type;
    private String version;
    private String fdw;
    private final Map<String, String> options = new LinkedHashMap<>();

    public PgServer(String name) {
        super(name);
    }

    @Override
    public String getAlterHeader() {
        return "ALTER SERVER " + getQualifiedName();
    }

    public void setType(String type) {
        this.type = type;
        resetHash();
    }

    public void setVersion(String version) {
        this.version = version;
        resetHash();
    }

    public String getFdw() {
        return fdw;
    }

    public void setFdw(String fdw) {
        this.fdw = fdw;
        resetHash();
    }

    @Override
    public Map<String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public void addOption(String key, String value) {
        this.options.put(key, value);
        resetHash();
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.SERVER;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(type);
        hasher.put(version);
        hasher.put(fdw);
        hasher.put(options);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PgServer srv && super.compare(obj)) {
            return Objects.equals(type, srv.type)
                    && Objects.equals(version, srv.version)
                    && Objects.equals(fdw, srv.fdw)
                    && Objects.equals(options, srv.options);
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
        sb.append("CREATE SERVER ");
        appendIfNotExists(sb);
        sb.append(PgDiffUtils.getQuotedName(name));
        if (type != null) {
            sb.append(" TYPE ").append(type);
        }
        if (version != null) {
            sb.append(" VERSION ").append(version);
        }
        sb.append(" FOREIGN DATA WRAPPER ").append(PgDiffUtils.getQuotedName(fdw));
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
        PgServer newServer = (PgServer) newCondition;
        if (!Objects.equals(newServer.fdw, fdw) ||
                !Objects.equals(newServer.type, type)) {
            return ObjectState.RECREATE;
        }

        if (!Objects.equals(newServer.version, version)) {
            StringBuilder sql = new StringBuilder();
            sql.append(getAlterHeader());
            sql.append(" VERSION ").append(newServer.version);
            script.addStatement(sql);
        }

        compareOptions(newServer, script);
        appendAlterOwner(newServer, script);
        alterPrivileges(newCondition, script);
        appendAlterComments(newServer, script);

        return getObjectState(script, startSize);
    }

    @Override
    public PgStatement shallowCopy() {
        PgServer copyServer = new PgServer(name);
        copyBaseFields(copyServer);
        copyServer.setType(type);
        copyServer.setVersion(version);
        copyServer.setFdw(fdw);
        copyServer.options.putAll(options);
        return copyServer;
    }
}
