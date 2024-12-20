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
        if (obj instanceof PgUserMapping usm && super.compare(obj)) {
            return Objects.equals(user, usm.getUser())
                    && Objects.equals(server, usm.getServer())
                    && Objects.equals(options, usm.getOptions());
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
        sb.append("CREATE USER MAPPING ");
        appendIfNotExists(sb);
        sb.append("FOR ").append(getQualifiedName());
        if (!getOptions().isEmpty()) {
            sb.append(' ');
        }
        appendOptions(sb);
        script.addStatement(sb);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        PgUserMapping newUsm = (PgUserMapping) newCondition;

        if (!Objects.equals(newUsm.getUser(), getUser()) ||
                !Objects.equals(newUsm.getServer(), getServer())) {
            return ObjectState.RECREATE;
        }

        compareOptions(newUsm, script);
        return getObjectState(script, startSize);
    }

    @Override
    public void getDropSQL(SQLScript script, boolean generateExists) {
        final StringBuilder sbString = new StringBuilder();
        sbString.append("DROP USER MAPPING ");
        if (generateExists) {
            sbString.append(IF_EXISTS);
        }
        sbString.append("FOR ").append(getQualifiedName());
        script.addStatement(sbString);
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
        return "ALTER USER MAPPING FOR " + getQualifiedName();
    }
}
