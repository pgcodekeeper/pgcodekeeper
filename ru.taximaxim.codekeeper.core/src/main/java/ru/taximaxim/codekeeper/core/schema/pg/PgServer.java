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

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SQLAction;

public class PgServer extends PgStatement implements PgForeignOptionContainer {

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        resetHash();
    }

    public String getVersion() {
        return version;
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
            return Objects.equals(type, srv.getType())
                    && Objects.equals(version, srv.getVersion())
                    && Objects.equals(fdw, srv.getFdw())
                    && Objects.equals(options, srv.getOptions());
        }
        return false;
    }

    @Override
    public AbstractDatabase getDatabase() {
        return (AbstractDatabase) getParent();
    }

    @Override
    public void getCreationSQL(Collection<SQLAction> createActions) {
        final StringBuilder sb = new StringBuilder();
        sb.append("CREATE SERVER ");
        appendIfNotExists(sb);
        sb.append(PgDiffUtils.getQuotedName(getName()));
        if (getType() != null) {
            sb.append(" TYPE ").append(getType());
        }
        if (getVersion() != null) {
            sb.append(" VERSION ").append(getVersion());
        }
        sb.append(" FOREIGN DATA WRAPPER ").append(PgDiffUtils.getQuotedName(getFdw()));
        if (!getOptions().isEmpty()) {
            sb.append(' ');
        }
        appendOptions(sb);
        createActions.add(new SQLAction(sb));
        appendOwnerSQL(createActions);
        appendPrivileges(createActions);
        appendComments(createActions);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> alterActions) {
        PgServer newServer = (PgServer) newCondition;
        if (!Objects.equals(newServer.getFdw(), getFdw()) ||
                !Objects.equals(newServer.getType(), getType())) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        if (!Objects.equals(newServer.getVersion(), getVersion())) {
            SQLAction sql = new SQLAction();
            sql.append(getAlterHeader());
            sql.append(" VERSION ").append(newServer.getVersion());
            alterActions.add(sql);
        }

        compareOptions(newServer, alterActions);
        appendAlterOwner(newServer, alterActions);
        alterPrivileges(newCondition, alterActions);
        appendAlterComments(newServer, alterActions);

        return getObjectState(alterActions);
    }

    @Override
    public PgStatement shallowCopy() {
        PgServer copyServer = new PgServer(getName());
        copyBaseFields(copyServer);
        copyServer.setType(type);
        copyServer.setVersion(version);
        copyServer.setFdw(fdw);
        copyServer.options.putAll(options);
        return copyServer;
    }
}
