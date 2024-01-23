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

public class PgServer extends PgStatement implements PgForeignOptionContainer{
    private String type;
    private String version;
    private String fdw;
    private final Map<String, String> options = new LinkedHashMap<>();

    public PgServer(String name) {
        super(name);
    }

    @Override
    public String getAlterHeader() {
        return "\n\nALTER SERVER " + getQualifiedName();
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
        if (obj instanceof PgServer && super.compare(obj)) {
            PgServer srv = (PgServer) obj;
            return Objects.equals(type, srv.getType())
                    && Objects.equals(version, srv.getVersion())
                    && Objects.equals(fdw, srv.getFdw())
                    && Objects.equals(options, srv.getOptions());
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
        sb.append(';');
        appendOwnerSQL(sb);
        appendPrivileges(sb);

        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgServer newServer = (PgServer) newCondition;
        if (!Objects.equals(newServer.getFdw(), getFdw()) ||
                !Objects.equals(newServer.getType(), getType())) {
            isNeedDepcies.set(true);
            return true;
        }

        if (!Objects.equals(newServer.getVersion(), getVersion())) {
            sb.append(getAlterHeader());
            sb.append(" VERSION ").append(newServer.getVersion())
            .append(';');
        }

        if (!Objects.equals(newServer.getOptions(), getOptions())) {
            compareOptions(newServer, sb);
        }

        if (!Objects.equals(newServer.getOwner(), getOwner())) {
            newServer.appendOwnerSQL(sb);
        }
        alterPrivileges(newCondition, sb);
        compareComments(sb, newServer);

        return sb.length() > startLength;
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
