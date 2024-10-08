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
package ru.taximaxim.codekeeper.core.loader.jdbc.ms;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.AbstractStatementReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.XmlReaderException;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;
import ru.taximaxim.codekeeper.core.schema.ms.MsRole;

public class MsRolesReader extends AbstractStatementReader {

    private final MsDatabase db;

    public MsRolesReader(JdbcLoaderBase loader, MsDatabase db) {
        super(loader);
        this.db = db;
    }

    @Override
    protected void processResult(ResultSet res) throws SQLException, XmlReaderException {
        String name = res.getString("name");
        loader.setCurrentObject(new GenericColumn(name, DbObjType.ROLE));

        MsRole role = new MsRole(name);
        loader.setOwner(role, res.getString("owner"));

        for (XmlReader group : XmlReader.readXML(res.getString("groups"))) {
            role.addMember(group.getString("m"));
        }

        loader.setPrivileges(role, XmlReader.readXML(res.getString("acl")));

        db.addRole(role);
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addMsPriviligesPart(builder);
        addMsGroupsPart(builder);
        addMsOwnerPart("res.owning_principal_id", builder);

        builder
        .column("res.name")
        .from("sys.database_principals res WITH (NOLOCK)")
        .where("res.type IN ('R')")
        .where("res.is_fixed_role = 0")
        .where("res.name != N'public'");
    }

    @Override
    protected void addMsPriviligesPart(QueryBuilder builder) {
        String acl = """
                CROSS APPLY (
                  SELECT * FROM (
                    SELECT
                      perm.state_desc AS sd,
                      perm.permission_name AS pn,
                      roleprinc.name AS r
                    FROM sys.database_principals roleprinc WITH (NOLOCK)
                    JOIN sys.database_permissions perm WITH (NOLOCK) ON perm.grantee_principal_id = roleprinc.principal_id
                    WHERE major_id = res.principal_id AND perm.class = 4
                  ) cc\s
                  FOR XML RAW, ROOT
                ) aa (acl)""";

        builder.column("aa.acl");
        builder.join(acl);
    }

    private void addMsGroupsPart(QueryBuilder builder) {
        String groups = """
                CROSS APPLY (
                  SELECT * FROM (
                    SELECT p1.name AS m
                    FROM sys.database_role_members AS rm WITH (NOLOCK)
                    INNER JOIN sys.database_principals p1 WITH (NOLOCK) ON rm.member_principal_id=p1.principal_id
                    WHERE rm.role_principal_id=res.principal_id
                  ) cc
                  FOR XML RAW, ROOT
                ) cc (groups)""";

        builder.column("cc.groups");
        builder.join(groups);
    }
}
