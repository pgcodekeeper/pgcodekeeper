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
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;

import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Batch_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql.CreateMsFunction;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql.CreateMsProcedure;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql.CreateMsTrigger;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql.CreateMsView;
import ru.taximaxim.codekeeper.core.schema.AbstractFunction;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.MsTrigger;
import ru.taximaxim.codekeeper.core.schema.MsView;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class MsFPVTReader extends JdbcReader {

    public MsFPVTReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException, XmlReaderException {
        String name = res.getString("name");

        String type = res.getString("type");
        DbObjType tt;

        // TR - SQL trigger
        // V - View
        // P - SQL Stored Procedure
        // IF - SQL inline table-valued function
        // FN - SQL scalar function
        // TF - SQL table-valued-function
        switch (type) {
        case "TR":
            tt = DbObjType.TRIGGER;
            break;
        case "V ":
            tt = DbObjType.VIEW;
            break;
        case "P ":
            tt = DbObjType.PROCEDURE;
            break;
        default:
            tt = DbObjType.FUNCTION;
            break;
        }

        loader.setCurrentObject(new GenericColumn(schema.getName(), name, tt));
        boolean an = res.getBoolean("ansi_nulls");
        boolean qi = res.getBoolean("quoted_identifier");
        boolean isDisable = res.getBoolean("is_disabled");

        String def = res.getString("definition");
        String owner = res.getString("owner");

        List<XmlReader> acls = XmlReader.readXML(res.getString("acl"));

        PgDatabase db = schema.getDatabase();

        if (tt == DbObjType.TRIGGER) {
            loader.submitMsAntlrTask(def, p -> {
                Batch_statementContext ctx = p.tsql_file().batch(0).batch_statement();
                return new CreateMsTrigger(ctx, db, an, qi, (CommonTokenStream) p.getInputStream());
            }, creator -> {
                MsTrigger tr = creator.getObject(schema, true);
                tr.setDisable(isDisable);
            });
        } else if (tt == DbObjType.VIEW) {
            loader.submitMsAntlrTask(def, p -> {
                Batch_statementContext ctx = p.tsql_file().batch(0).batch_statement();
                return new CreateMsView(ctx, db, an, qi, (CommonTokenStream) p.getInputStream());
            }, creator -> {
                MsView st = creator.getObject(schema, true);
                loader.setOwner(st, owner);
                loader.setPrivileges(st, acls);
            });
        } else if (tt == DbObjType.PROCEDURE) {
            loader.submitMsAntlrTask(def, p -> {
                Batch_statementContext ctx = p.tsql_file().batch(0).batch_statement();
                return new CreateMsProcedure(ctx, db, an, qi, (CommonTokenStream) p.getInputStream());
            }, creator -> {
                AbstractFunction st = creator.getObject(schema, true);
                loader.setOwner(st, owner);
                loader.setPrivileges(st, acls);
            });
        } else {
            loader.submitMsAntlrTask(def, p -> {
                Batch_statementContext ctx = p.tsql_file().batch(0).batch_statement();
                return new CreateMsFunction(ctx, db, an, qi, (CommonTokenStream) p.getInputStream());
            }, creator -> {
                AbstractFunction st = creator.getObject(schema, true);
                loader.setOwner(st, owner);
                loader.setPrivileges(st, acls);
            });
        }
    }

    @Override
    protected String getSchemaColumn() {
        return "res.schema_id";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addMsPriviligesPart(builder);
        addMsOwnerPart(builder);

        builder
        .column("res.name")
        .column("res.type")
        .column("sm.definition")
        .column("sm.uses_ansi_nulls AS ansi_nulls")
        .column("sm.uses_quoted_identifier AS quoted_identifier")
        .column("t.is_disabled")
        .from("sys.objects res WITH (NOLOCK)")
        .join("JOIN sys.sql_modules sm WITH (NOLOCK) ON sm.object_id=res.object_id")
        .join("LEFT JOIN sys.triggers t WITH(NOLOCK) ON t.object_id=res.object_id")
        .where("res.type IN (N'TR', N'V', N'IF', N'FN', N'TF', N'P')")
        .where("definition IS NOT NULL");
    }
}
