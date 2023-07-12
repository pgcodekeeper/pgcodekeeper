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
import java.util.ListIterator;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.SupportedVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.FuncProcAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.AbstractPgFunction;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgFunction;
import ru.taximaxim.codekeeper.core.schema.PgProcedure;
import ru.taximaxim.codekeeper.core.utils.Pair;

/**
 * Reads FUNCTIONs, PROCEDUREs from JDBC.
 */
public class FunctionsReader extends AbstractFunctionsReader {

    public FunctionsReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected AbstractPgFunction readFunction(ResultSet res, AbstractSchema schema) throws SQLException {
        String funcName = res.getString("proname");
        boolean isProc = SupportedVersion.VERSION_11.isLE(loader.version) && res.getBoolean("proisproc");
        AbstractPgFunction function = isProc ? new PgProcedure(funcName) : new PgFunction(funcName);
        loader.setCurrentObject(new GenericColumn(schema.getName(), funcName, function.getStatementType()));

        function.setLanguageCost(res.getString("lang_name"), res.getFloat("procost"));

        // since 9.5 PostgreSQL
        fillTransform(function, res);

        if (SupportedVersion.VERSION_12.isLE(loader.version)) {
            String supportFunc = res.getString("support_func");
            if (!"-".equals(supportFunc)) {
                setFunctionWithDep(AbstractPgFunction::setSupportFunc, function, supportFunc);
            }
        }

        if (loader.isGreenplumDb) {
            switch (res.getString("executeOn")) {
            case "m":
                function.setExecuteOn("MASTER");
                break;
            case "c":
                function.setExecuteOn("COORDINATOR");
                break;
            case "s":
                function.setExecuteOn("ALL SEGMENTS");
                break;
            case "i":
                function.setExecuteOn("INITPLAN");
                break;
            }
        }

        function.setWindow(res.getBoolean("proiswindow"));

        // VOLATILE is default
        switch (res.getString("provolatile")) {
        case "i":
            function.setVolatileType("IMMUTABLE");
            break;
        case "s":
            function.setVolatileType("STABLE");
            break;
        default:
            break;
        }

        function.setStrict(res.getBoolean("proisstrict"));
        function.setSecurityDefiner(res.getBoolean("prosecdef"));
        function.setLeakproof(res.getBoolean("proleakproof"));

        // since 9.6 PostgreSQL
        // parallel mode: s - safe, r - restricted, u - unsafe
        if (SupportedVersion.VERSION_9_6.isLE(loader.version)) {
            String parMode = res.getString("proparallel");
            switch (parMode) {
            case "s":
                function.setParallel("SAFE");
                break;
            case "r":
                function.setParallel("RESTRICTED");
                break;
            default:
                break;
            }
        }

        float rows = res.getFloat("prorows");
        if (0.0f != rows) {
            function.setRows(rows);
        }

        PgDatabase db = schema.getDatabase();
        fillBody(function, db, res);
        fillDefaultValues(function, db, res);
        fillConfiguration(function, res);

        return function;
    }

    private void fillTransform(AbstractPgFunction function, ResultSet res) throws SQLException {
        if (SupportedVersion.VERSION_9_5.isLE(loader.version)) {
            Long[] protrftypes = getColArray(res, "protrftypes");
            if (protrftypes != null) {
                for (Long s : protrftypes) {
                    function.addTransform(loader.cachedTypesByOid.get(s).getFullName());
                }
            }
        }
    }

    private void fillDefaultValues(AbstractPgFunction function, PgDatabase db, ResultSet res) throws SQLException {
        String defaultValuesAsString = res.getString("default_values_as_string");
        if (defaultValuesAsString != null) {
            loader.submitAntlrTask(defaultValuesAsString, SQLParser::vex_eof,
                    ctx -> {
                        List<VexContext> vexCtxList = ctx.vex();
                        ListIterator<VexContext> vexCtxListIterator = vexCtxList.listIterator(vexCtxList.size());

                        for (int i = (function.getArguments().size() - 1); i >= 0; i--) {
                            if (!vexCtxListIterator.hasPrevious()) {
                                break;
                            }
                            Argument a = function.getArguments().get(i);
                            if (a.getMode().isIn()) {
                                VexContext vx = vexCtxListIterator.previous();
                                a.setDefaultExpression(ParserAbstract.getFullCtxText(vx));
                                db.addAnalysisLauncher(new VexAnalysisLauncher(
                                        function, vx, loader.getCurrentLocation()));
                            }
                        }
                    });
        }
    }

    private void fillConfiguration(AbstractPgFunction function, ResultSet res) throws SQLException {
        String[] proconfig = getColArray(res, "proconfig");
        if (proconfig == null) {
            return;
        }

        for (String param : proconfig) {
            int eq = param.indexOf('=');
            final String par = param.substring(0, eq);
            String val = param.substring(eq + 1);

            switch (par) {
            case "temp_tablespaces":
            case "session_preload_libraries":
            case "shared_preload_libraries":
            case "local_preload_libraries":
            case "search_path":
                function.addConfiguration(par, null);
                loader.submitAntlrTask(val, SQLParser::vex_eof,
                        ctx -> {
                            StringBuilder sb = new StringBuilder();
                            for (VexContext vex : ctx.vex()) {
                                sb.append(PgDiffUtils.quoteString(vex.getText()));
                                sb.append(", ");
                            }
                            sb.setLength(sb.length() - 2);
                            function.addConfiguration(par, sb.toString());
                        });
                break;
            default:
                val = PgDiffUtils.quoteString(val);
                function.addConfiguration(PgDiffUtils.getQuotedName(par), val);
                break;
            }
        }
    }

    private void fillBody(AbstractPgFunction function, PgDatabase db, ResultSet res) throws SQLException {
        List<Pair<String, GenericColumn>> argsQualTypes = fillArguments(function, res);

        String body = "";
        String definition = res.getString("prosrc");
        String probin = res.getString("probin");
        if (probin != null && !probin.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(PgDiffUtils.quoteString(probin));
            if (!"-".equals(definition)) {
                sb.append(", ");
                if (!definition.contains("\'") && !definition.contains("\\")) {
                    sb.append(PgDiffUtils.quoteString(definition));
                } else {
                    sb.append(PgDiffUtils.quoteStringDollar(definition));
                }
            }
            body = sb.toString();
        } else if (definition != null && !definition.isEmpty() && !"-".equals(definition)) {
            body = PgDiffUtils.quoteStringDollar(definition);
        } else if (SupportedVersion.VERSION_14.isLE(loader.version)) {
            String probody = res.getString("prosqlbody");
            // must not be null at this point, otherwise function has no body (?)
            checkObjectValidity(probody, DbObjType.FUNCTION, function.getBareName());
            function.setInStatementBody(true);
            body = probody;
        }

        function.setBody(loader.args, body);

        // Parsing the function definition and adding its result context for analysis.
        if (function.isInStatementBody()) {
            loader.submitAntlrTask(body, SQLParser::function_body, ctx -> db.addAnalysisLauncher(
                    new FuncProcAnalysisLauncher(function, ctx, loader.getCurrentLocation(), argsQualTypes)));
        } else if (!"-".equals(definition) && "SQL".equalsIgnoreCase(function.getLanguage())) {
            loader.submitAntlrTask(definition, SQLParser::sql, ctx -> db.addAnalysisLauncher(
                    new FuncProcAnalysisLauncher(function, ctx, loader.getCurrentLocation(), argsQualTypes)));
        } else if (!"-".equals(definition) && "PLPGSQL".equalsIgnoreCase(function.getLanguage())) {
            loader.submitPlpgsqlTask(definition, SQLParser::plpgsql_function, ctx -> db.addAnalysisLauncher(
                    new FuncProcAnalysisLauncher(function, ctx, loader.getCurrentLocation(), argsQualTypes)));
        }
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        super.fillQueryBuilder(builder);

        builder
        .column("l.lanname AS lang_name")
        .column("res.prosrc")
        .column("res.provolatile")
        .column("res.proleakproof")
        .column("res.proisstrict")
        .column("res.prosecdef")
        .column("res.procost::real")
        .column("res.prorows::real")
        .column("res.proconfig")
        .column("res.probin")
        .column("pg_catalog.pg_get_expr(res.proargdefaults, 0) AS default_values_as_string")
        .join("LEFT JOIN pg_catalog.pg_language l ON l.oid = res.prolang");

        if (SupportedVersion.VERSION_9_5.isLE(loader.version)) {
            builder.column("res.protrftypes::bigint[]");
        }

        if (SupportedVersion.VERSION_11.isLE(loader.version)) {
            builder
            .column("res.prokind = 'w' AS proiswindow")
            .column("res.prokind = 'p' AS proisproc")
            .where("res.prokind != 'a'");
        } else {
            builder
            .column("res.proiswindow")
            .where("NOT res.proisagg");
        }

        if (SupportedVersion.VERSION_12.isLE(loader.version)) {
            builder.column("res.prosupport AS support_func");
        }

        if (SupportedVersion.VERSION_14.isLE(loader.version)) {
            builder.column("pg_get_function_sqlbody(res.oid) AS prosqlbody");
        }

        if (loader.isGreenplumDb) {
            builder.column("res.proexeclocation AS executeOn");
        }
    }
}
