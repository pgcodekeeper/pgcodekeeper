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

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class MsUser extends PgStatement {

    // TODO PASSWORD, DEFAULT_LANGUAGE, ALLOW_ENCRYPTED_VALUE_MODIFICATIONS
    private String schema;
    private String login;
    private String language;
    private boolean allowEncrypted;

    public MsUser(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.USER;
    }

    @Override
    public AbstractDatabase getDatabase() {
        return (AbstractDatabase) getParent();
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE USER ");
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        if (login != null) {
            sbSQL.append(" FOR LOGIN ").append(MsDiffUtils.quoteName(login));
        }
        if (schema != null || language != null || allowEncrypted) {
            sbSQL.append(" WITH ");
            if (schema != null) {
                sbSQL.append("DEFAULT_SCHEMA = ").append(MsDiffUtils.quoteName(schema)).append(", ");
            }
            if (language != null) {
                sbSQL.append("DEFAULT_LANGUAGE = ").append(language).append(", ");
            }
            if (allowEncrypted) {
                sbSQL.append("ALLOW_ENCRYPTED_VALUE_MODIFICATIONS = ON, ");
            }
            sbSQL.setLength(sbSQL.length() - 2);
        }

        sbSQL.append(GO);

        appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsUser newUser = (MsUser) newCondition;

        StringBuilder sbSql = new StringBuilder();

        if (!Objects.equals(getLogin(), newUser.getLogin())) {
            sbSql.append("LOGIN = ").append(MsDiffUtils.quoteName(newUser.getLogin())).append(", ");
        }

        String newSchema = newUser.getSchema();
        if (!Objects.equals(getSchema(), newSchema)) {
            if (newSchema == null) {
                newSchema = Consts.DBO;
            }
            sbSql.append("DEFAULT_SCHEMA = ").append(MsDiffUtils.quoteName(newSchema)).append(", ");
        }
        if (!Objects.equals(getLanguage(), newUser.getLanguage())) {
            sbSql.append("DEFAULT_LANGUAGE = ")
            .append(newUser.getLanguage() == null ? "NONE" : newUser.getLanguage())
            .append(", ");
        }
        if (!isAllowEncrypted() == newUser.allowEncrypted) {
            sbSql.append("ALLOW_ENCRYPTED_VALUE_MODIFICATIONS = ").append(newUser.allowEncrypted ? "ON" : "OFF")
            .append(", ");
        }

        if (sbSql.length() > 0) {
            sbSql.setLength(sbSql.length() - 2);
            sb.append("ALTER USER ").append(MsDiffUtils.quoteName(name))
            .append(" WITH ").append(sbSql).append(GO);
        }

        alterPrivileges(newUser, sb);

        return sb.length() > startLength;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        if (Consts.DBO.equals(schema)) {
            return;
        }
        this.schema = schema;
        resetHash();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
        resetHash();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String defaultLng) {
        this.language = defaultLng;
        resetHash();
    }

    public boolean isAllowEncrypted() {
        return allowEncrypted;
    }

    public void setAllowEncrypted(boolean allowEncrypted) {
        this.allowEncrypted = allowEncrypted;
        resetHash();
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(schema);
        hasher.put(login);
        hasher.put(language);
        hasher.put(allowEncrypted);
    }

    @Override
    public MsUser shallowCopy() {
        MsUser userDst = new MsUser(getName());
        copyBaseFields(userDst);
        userDst.setSchema(getSchema());
        userDst.setLogin(getLogin());
        userDst.setLanguage(getLanguage());
        userDst.setAllowEncrypted(isAllowEncrypted());
        return userDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof MsUser && super.compare(obj)) {
            MsUser user = (MsUser) obj;
            return Objects.equals(schema, user.getSchema())
                    && Objects.equals(login, user.getLogin())
                    && Objects.equals(language, user.getLanguage())
                    && allowEncrypted == user.isAllowEncrypted();
        }
        return false;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }
}
