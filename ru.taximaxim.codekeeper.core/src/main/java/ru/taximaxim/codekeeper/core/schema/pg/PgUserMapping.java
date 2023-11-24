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

public class PgUserMapping extends PgStatement implements PgForeignOptionContainer {
    private final String user;
    private final String server;
    private final Map<String, String> options = new LinkedHashMap<>();

    public PgUserMapping(String user, String server) {
        super(user + " SERVER " + server);
        this.user = user;
        this.server = server;
    }

    public String getUser() {
        return user;
    }

    public String getServer() {
        return server;
    }

    @Override
    public String getQualifiedName() {
        return PgDiffUtils.getQuotedName(user) + " SERVER " + PgDiffUtils.getQuotedName(server);
    }

    @Override
    public void addOption(String key, String value) {
        this.options.put(key, value);
        resetHash();
    }

    @Override
    public Map<String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.USER_MAPPING;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(user);
        hasher.put(server);
        hasher.put(options);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PgUserMapping && super.compare(obj)) {
            PgUserMapping usm = (PgUserMapping) obj;
            return Objects.equals(user, usm.getUser())
                    && Objects.equals(server, usm.getServer())
                    && Objects.equals(options, usm.getOptions());
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
        sb.append("CREATE USER MAPPING ");
        appendIfNotExists(sb);
        sb.append("FOR ").append(getQualifiedName());
        if (!getOptions().isEmpty()) {
            sb.append(' ');
        }
        appendOptions(sb);
        sb.append(';');
        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgUserMapping newUsm = (PgUserMapping) newCondition;

        if (!Objects.equals(newUsm.getUser(), getUser()) ||
                !Objects.equals(newUsm.getServer(), getServer())) {
            isNeedDepcies.set(true);
            return true;
        }

        if (!Objects.equals(newUsm.getOptions(), getOptions())) {
            compareOptions(newUsm, sb);
        }
        return sb.length() > startLength;
    }

    @Override
    public String getDropSQL(boolean generateExists) {
        final StringBuilder sbString = new StringBuilder();
        sbString.append("DROP USER MAPPING ");
        if (generateExists) {
            sbString.append("IF EXISTS ");
        }
        sbString.append("FOR ").append(getQualifiedName());
        sbString.append(';');
        return sbString.toString();
    }

    @Override
    public PgStatement shallowCopy() {
        PgUserMapping copyUsm = new PgUserMapping(getUser(), getServer());
        copyBaseFields(copyUsm);
        copyUsm.options.putAll(options);
        return copyUsm;
    }

    @Override
    public String getAlterHeader() {
        return "\n\nALTER USER MAPPING FOR " + getQualifiedName();
    }
}
