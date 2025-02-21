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
package ru.taximaxim.codekeeper.core.loader.jdbc.pg;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.antlr.v4.runtime.CommonTokenStream;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.pg.SupportedPgVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.ViewAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractPgView;
import ru.taximaxim.codekeeper.core.schema.pg.MaterializedPgView;
import ru.taximaxim.codekeeper.core.schema.pg.PgView;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class ViewsReader extends JdbcReader {

    public ViewsReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        String viewName = res.getString("relname");
        loader.setCurrentObject(new GenericColumn(schemaName, viewName, DbObjType.VIEW));

        AbstractPgView v;

        // materialized view
        if ("m".equals(res.getString("kind"))) {
            var matV = new MaterializedPgView(viewName);
            matV.setIsWithData(res.getBoolean("relispopulated"));
            String tableSpace = res.getString("table_space");
            if (tableSpace != null && !tableSpace.isEmpty()) {
                matV.setTablespace(tableSpace);
            }
            if (SupportedPgVersion.VERSION_12.isLE(loader.getVersion())) {
                matV.setMethod(res.getString("access_method"));
            }
            if (loader.isGreenplumDb()) {
                String distribution = res.getString("distribution");
                if (distribution != null && !distribution.isBlank()) {
                    matV.setDistribution(distribution);
                }
            }
            v = matV;
        } else {
            v = new PgView(viewName);
        }

        String definition = res.getString("definition");
        checkObjectValidity(definition, DbObjType.VIEW, viewName);
        String viewDef = definition.trim();
        int semicolonPos = viewDef.length() - 1;
        String query = viewDef.charAt(semicolonPos) == ';' ? viewDef.substring(0, semicolonPos) : viewDef;

        AbstractDatabase dataBase = schema.getDatabase();

        loader.submitAntlrTask(viewDef,
                p -> new Pair<>(
                        p.sql().statement(0).data_statement().select_stmt(),
                        (CommonTokenStream) p.getTokenStream()),
                pair -> {
                    dataBase.addAnalysisLauncher(new ViewAnalysisLauncher(
                            v, pair.getFirst(), loader.getCurrentLocation()));
                    v.setQuery(query, AntlrUtils.normalizeWhitespaceUnquoted(
                            pair.getFirst(), pair.getSecond()));
                });


        // Query columns default values and comments
        String[] colNames = getColArray(res, "column_names");
        if (colNames != null) {
            String[] colComments = getColArray(res, "column_comments");
            String[] colDefaults = getColArray(res, "column_defaults");
            String[] colACLs = getColArray(res, "column_acl");

            for (int i = 0; i < colNames.length; i++) {
                String colName = colNames[i];
                String colDefault = colDefaults[i];
                if (colDefault != null) {
                    ((PgView)v).addColumnDefaultValue(colName, colDefault);
                    loader.submitAntlrTask(colDefault, p -> p.vex_eof().vex().get(0),
                            ctx -> dataBase.addAnalysisLauncher(
                                    new VexAnalysisLauncher(v, ctx, loader.getCurrentLocation())));
                }
                String colComment = colComments[i];
                if (colComment != null) {
                    v.addColumnComment(loader.getArgs(), colName, PgDiffUtils.quoteString(colComment));
                }
                String colAcl = colACLs[i];
                // Привилегии на столбцы view записываются в саму view
                if (colAcl != null) {
                    loader.setPrivileges(v, colAcl, colName, schemaName);
                }
            }
        }

        loader.setOwner(v, res.getLong("relowner"));
        loader.setPrivileges(v, res.getString("relacl"), schemaName);
        loader.setAuthor(v, res);
        loader.setComment(v, res);

        // STORAGE PARAMETRS
        String[] options = getColArray(res, "reloptions");
        if (options != null) {
            ParserAbstract.fillOptionParams(options, v::addOption, false, false, false);
        }

        schema.addView(v);
    }

    @Override
    protected void setParams(PreparedStatement statement) throws SQLException {
        statement.setBoolean(1, loader.getArgs().isSimplifyView());
    }

    @Override
    protected String getClassId() {
        return "pg_class";
    }

    @Override
    protected String getSchemaColumn() {
        return "res.relnamespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addExtensionDepsCte(builder);
        addColumnsPart(builder);
        addDescriptionPart(builder, true);

        builder
        .column("res.relname")
        .column("res.relkind AS kind")
        .column("tabsp.spcname as table_space")
        .column("res.relacl::text")
        .column("res.relowner::bigint")
        .column("pg_catalog.pg_get_viewdef(res.oid, ?) AS definition")
        .column("res.reloptions")
        .column("am.amname AS access_method")
        .column("res.relispopulated")
        .from("pg_catalog.pg_class res")
        .join("LEFT JOIN pg_catalog.pg_tablespace tabsp ON tabsp.oid = res.reltablespace")
        .join("LEFT JOIN pg_catalog.pg_am am ON am.oid = res.relam")
        .where("res.relkind IN ('v','m')");

        if (loader.isGreenplumDb()) {
            builder.column("pg_get_table_distributedby(res.oid) AS distribution");
        }
    }

    private void addColumnsPart(QueryBuilder builder) {
        QueryBuilder columns = new QueryBuilder()
                .column("attrelid")
                .column("pg_catalog.array_agg(attr.attname ORDER BY attr.attnum) AS column_names")
                .column("pg_catalog.array_agg(des.description ORDER BY attr.attnum) AS column_comments")
                .column("pg_catalog.array_agg(pg_catalog.pg_get_expr(def.adbin, def.adrelid) ORDER BY attr.attnum) AS column_defaults")
                .column("pg_catalog.array_agg(attr.attacl::text ORDER BY attr.attnum) AS column_acl")
                .from("pg_catalog.pg_attribute attr")
                .join("LEFT JOIN pg_catalog.pg_attrdef def ON def.adnum = attr.attnum")
                .join("  AND attr.attrelid = def.adrelid")
                .join("  AND attr.attisdropped IS FALSE")
                .join("LEFT JOIN pg_catalog.pg_description des ON des.objoid = attr.attrelid")
                .join("  AND des.classoid = 'pg_catalog.pg_class'::pg_catalog.regclass")
                .join("  AND des.objsubid = attr.attnum")
                .groupBy("attrelid");

        builder.column("subselect.column_names");
        builder.column("subselect.column_comments");
        builder.column("subselect.column_defaults");
        builder.column("subselect.column_acl");
        builder.join("LEFT JOIN", columns, "subselect ON subselect.attrelid = res.oid");
    }
}
