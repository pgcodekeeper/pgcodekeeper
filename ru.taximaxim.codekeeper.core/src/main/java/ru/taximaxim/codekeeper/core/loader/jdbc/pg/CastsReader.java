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
package ru.taximaxim.codekeeper.core.loader.jdbc.pg;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.SupportedVersion;
import ru.taximaxim.codekeeper.core.loader.jdbc.AbstractStatementReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.PgParserAbstract;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ICast.CastContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.pg.PgCast;
import ru.taximaxim.codekeeper.core.schema.pg.PgCast.CastMethod;

public class CastsReader extends AbstractStatementReader {

    private final PgDatabase db;

    public CastsReader(JdbcLoaderBase loader, PgDatabase db) {
        super(loader);
        this.db = db;
    }

    @Override
    protected void processResult(ResultSet res) throws SQLException {
        String source = res.getString("source");
        JdbcReader.checkTypeValidity(source);
        String target = res.getString("target");
        JdbcReader.checkTypeValidity(target);

        PgCast cast = new PgCast(source, target);
        loader.setCurrentObject(new GenericColumn(cast.getName(), DbObjType.CAST));

        addDep(cast, source);
        addDep(cast, target);

        String type = res.getString("castcontext");
        switch (type) {
        case "e":
            cast.setContext(CastContext.EXPLICIT);
            break;
        case "a":
            cast.setContext(CastContext.ASSIGNMENT);
            break;
        case "i":
            cast.setContext(CastContext.IMPLICIT);
            break;
        default:
            throw new IllegalStateException("Unknown cast context: " + type);
        }

        String method = res.getString("castmethod");
        switch (method) {
        case "f":
            cast.setMethod(CastMethod.FUNCTION);
            String function = res.getString("func");
            JdbcReader.checkObjectValidity(function, DbObjType.CAST, cast.getName());
            cast.setFunction(function);
            loader.submitAntlrTask(function, SQLParser::function_args_parser, ctx -> {
                List<ParserRuleContext> ids = PgParserAbstract.getIdentifiers(ctx.schema_qualified_name());
                String schemaName = QNameParser.getSchemaName(ids);
                if (schemaName != null && !Utils.isPgSystemSchema(schemaName)) {
                    String funcName = PgParserAbstract.parseSignature(
                            QNameParser.getFirstName(ids), ctx.function_args());
                    cast.addDep(new GenericColumn(schemaName, funcName, DbObjType.FUNCTION));
                }
            });

            break;
        case "i":
            cast.setMethod(CastMethod.INOUT);
            break;
        case "b":
            cast.setMethod(CastMethod.BINARY);
            break;
        default:
            throw new IllegalStateException("Unknown cast method: " + type);
        }

        loader.setComment(cast, res);
        loader.setAuthor(cast, res);

        db.addCast(cast);
    }

    private void addDep(PgStatement statement, String objectName) {
        if (objectName.indexOf('.') != -1) {
            QNameParser<ParserRuleContext> parser = QNameParser.parsePg(objectName);
            String schemaName = parser.getSchemaName();
            if (schemaName != null && !Utils.isPgSystemSchema(schemaName)) {
                statement.addDep(new GenericColumn(schemaName, parser.getFirstName(), DbObjType.TYPE));
            }
        }
    }

    @Override
    protected void setParams(PreparedStatement statement) throws SQLException {
        statement.setLong(1, loader.getLastSysOid());
    }

    @Override
    protected String getClassId() {
        return "pg_cast";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addExtensionDepsCte(builder);
        addDescriptionPart(builder);

        builder
        .column("pg_catalog.format_type(res.castsource, null) AS source")
        .column("pg_catalog.format_type(res.casttarget, null) AS target")
        .column("res.castfunc::regprocedure AS func")
        .column("res.castcontext")
        .column("res.castmethod")
        .from("pg_catalog.pg_cast res")
        .where("res.oid > ?");

        if (SupportedVersion.VERSION_14.isLE(loader.getVersion())) {
            builder.where("NOT EXISTS (SELECT 1 FROM pg_range r WHERE res.castsource = r.rngtypid AND res.casttarget = r.rngmultitypid)");
        }
    }
}
