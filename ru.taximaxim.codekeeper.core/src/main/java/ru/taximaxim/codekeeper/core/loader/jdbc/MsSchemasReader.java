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
package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.MsSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class MsSchemasReader extends AbstractStatementReader {

    private final PgDatabase db;

    public MsSchemasReader(JdbcLoaderBase loader, PgDatabase db) {
        super(loader);
        this.db = db;
    }

    @Override
    protected void processResult(ResultSet result) throws SQLException, XmlReaderException {
        AbstractSchema schema = getSchema(result);
        if (loader.ignorelistSchema == null || loader.ignorelistSchema.getNameStatus(schema.getName())) {
            db.addSchema(schema);
            loader.schemaIds.put(result.getLong("schema_id"), schema);
        }
    }

    private AbstractSchema getSchema(ResultSet res) throws SQLException, XmlReaderException {
        String schemaName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schemaName, DbObjType.SCHEMA));
        AbstractSchema s = new MsSchema(schemaName);

        String owner = res.getString("owner");
        if (!schemaName.equalsIgnoreCase(Consts.DBO) || !owner.equalsIgnoreCase(Consts.DBO)) {
            loader.setOwner(s, owner);
        }

        loader.setPrivileges(s, XmlReader.readXML(res.getString("acl")));
        return s;
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addMsPriviligesPart(builder);
        addMsOwnerPart(builder);

        builder
        .column("res.schema_id")
        .column("res.name")
        .from("sys.schemas res WITH (NOLOCK)")
        .where("p.name NOT IN ('INFORMATION_SCHEMA', 'sys')");
    }

    @Override
    protected void addMsPriviligesPart(QueryBuilder builder) {
        String acl = "CROSS APPLY (\n"
                + "  SELECT * FROM (\n"
                + "    SELECT\n"
                + "      perm.state_desc AS sd,\n"
                + "      perm.permission_name AS pn,\n"
                + "      roleprinc.name AS r\n"
                + "    FROM sys.database_principals roleprinc WITH (NOLOCK)\n"
                + "    JOIN sys.database_permissions perm WITH (NOLOCK) ON perm.grantee_principal_id = roleprinc.principal_id\n"
                + "    WHERE major_id = res.schema_id AND perm.class = 3\n"
                + "  ) cc\n"
                + "  FOR XML RAW, ROOT\n"
                + ") aa (acl)";

        builder.column("aa.acl");
        builder.join(acl);
    }

}
