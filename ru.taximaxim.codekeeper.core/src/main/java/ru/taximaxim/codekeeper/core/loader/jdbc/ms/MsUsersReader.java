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
package ru.taximaxim.codekeeper.core.loader.jdbc.ms;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.AbstractStatementReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReaderException;
import ru.taximaxim.codekeeper.core.loader.ms.SupportedMsVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;
import ru.taximaxim.codekeeper.core.schema.ms.MsUser;

public class MsUsersReader extends AbstractStatementReader {

    private final MsDatabase db;

    public MsUsersReader(JdbcLoaderBase loader, MsDatabase db) {
        super(loader);
        this.db = db;
    }

    @Override
    protected void processResult(ResultSet res) throws SQLException, XmlReaderException {
        String name = res.getString("name");
        loader.setCurrentObject(new GenericColumn(name, DbObjType.USER));

        MsUser user = new MsUser(name);
        user.setLogin(res.getString("loginname"));

        user.setSchema(res.getString("schema_name"));
        user.setLanguage(res.getString("default_lang"));
        if (SupportedMsVersion.VERSION_16.isLE(loader.getVersion())) {
            user.setAllowEncrypted(res.getBoolean("allow_encrypted"));
        }

        loader.setPrivileges(user, XmlReader.readXML(res.getString("acl")));
        db.addUser(user);
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addMsPriviligesPart(builder);

        builder
        .column("res.name")
        .column("suser_sname(res.sid) AS loginname")
        .column("res.default_schema_name AS schema_name")
        .column("res.default_language_lcid AS default_lang")
        .from("sys.database_principals res WITH (NOLOCK)")
        .where("res.type IN ('S', 'U', 'G')")
        .where("NOT name IN ('guest', 'sys', 'INFORMATION_SCHEMA')");

        if (SupportedMsVersion.VERSION_16.isLE(loader.getVersion())) {
            builder.column("res.allow_encrypted_value_modifications AS allow_encrypted");
        }
    }

    @Override
    protected QueryBuilder formatMsPriviliges(QueryBuilder privileges) {
        return privileges
                .column("col.name AS c")
                .where("major_id = res.principal_id")
                .where("perm.class = 4");
    }
}
