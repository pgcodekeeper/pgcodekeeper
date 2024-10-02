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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.Consts.FUNC_SIGN;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcType;
import ru.taximaxim.codekeeper.core.loader.pg.SupportedPgVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.FuncProcAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateAggregate;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractFunction;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ArgMode;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.pg.AbstractPgFunction;
import ru.taximaxim.codekeeper.core.schema.pg.PgAggregate;
import ru.taximaxim.codekeeper.core.schema.pg.PgAggregate.AggFuncs;
import ru.taximaxim.codekeeper.core.schema.pg.PgAggregate.AggKinds;
import ru.taximaxim.codekeeper.core.schema.pg.PgAggregate.ModifyType;
import ru.taximaxim.codekeeper.core.schema.pg.PgFunction;
import ru.taximaxim.codekeeper.core.schema.pg.PgProcedure;
import ru.taximaxim.codekeeper.core.utils.Pair;

/**
 * Reads FUNCTIONs, PROCEDUREs and AGGREGATEs from JDBC.
 */
public class FunctionsReader extends JdbcReader {

    public FunctionsReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        String funcName = res.getString("proname");
        AbstractFunction f = res.getBoolean("proisagg") ? getAgg(res, schemaName, funcName)
                : getFunc(res, schema, funcName);

        loader.setOwner(f, res.getLong("proowner"));
        loader.setComment(f, res);
        loader.setPrivileges(f, res.getString("aclarray"), schemaName);
        loader.setAuthor(f, res);

        schema.addFunction(f);
    }

    private AbstractPgFunction getFunc(ResultSet res, AbstractSchema schema, String funcName) throws SQLException {
        boolean isProc = SupportedPgVersion.VERSION_11.isLE(loader.getVersion()) && res.getBoolean("proisproc");
        AbstractPgFunction function = isProc ? new PgProcedure(funcName) : new PgFunction(funcName);
        loader.setCurrentObject(new GenericColumn(schema.getName(), funcName, function.getStatementType()));

        function.setLanguageCost(res.getString("lang_name"), res.getFloat("procost"));

        // since 9.5 PostgreSQL
        fillTransform(function, res);

        if (SupportedPgVersion.VERSION_12.isLE(loader.getVersion())) {
            String supportFunc = res.getString("support_func");
            if (!"-".equals(supportFunc)) {
                setFunctionWithDep(AbstractPgFunction::setSupportFunc, function, supportFunc,
                        FUNC_SIGN.INTERNAL.getName());
            }
        }

        if (loader.isGreenplumDb()) {
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
            default:
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
        if (SupportedPgVersion.VERSION_9_6.isLE(loader.getVersion())) {
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

        AbstractDatabase db = schema.getDatabase();
        fillBody(function, db, res);
        fillDefaultValues(function, db, res);
        fillConfiguration(function, res);

        return function;
    }

    private void fillTransform(AbstractPgFunction function, ResultSet res) throws SQLException {
        if (SupportedPgVersion.VERSION_9_5.isLE(loader.getVersion())) {
            Long[] protrftypes = getColArray(res, "protrftypes");
            if (protrftypes != null) {
                for (Long s : protrftypes) {
                    function.addTransform(loader.getCachedTypeByOid(s).getFullName());
                }
            }
        }
    }

    private void fillDefaultValues(AbstractPgFunction function, AbstractDatabase db, ResultSet res)
            throws SQLException {
        String defaultValuesAsString = res.getString("default_values_as_string");
        if (defaultValuesAsString == null) {
            return;
        }

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

    private void fillBody(AbstractPgFunction function, AbstractDatabase db, ResultSet res) throws SQLException {
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
        } else if (SupportedPgVersion.VERSION_14.isLE(loader.getVersion())) {
            String probody = res.getString("prosqlbody");
            // must not be null at this point, otherwise function has no body (?)
            checkObjectValidity(probody, DbObjType.FUNCTION, function.getBareName());
            function.setInStatementBody(true);
            body = probody;
        }

        function.setBody(loader.getArgs(), body);

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

    private AbstractFunction getAgg(ResultSet res, String schemaName,
            String funcName) throws SQLException {
        loader.setCurrentObject(new GenericColumn(schemaName, funcName, DbObjType.AGGREGATE));
        PgAggregate aggregate = new PgAggregate(funcName);

        switch (res.getString("aggkind")) {
        case "o":
            aggregate.setKind(AggKinds.ORDERED);
            break;
        case "h":
            aggregate.setKind(AggKinds.HYPOTHETICAL);
            break;
        default:
            break;
        }

        //// The order is important for adding dependencies. Two steps.

        // First step: filling all types and arguments.
        fillArguments(aggregate, res);

        // Second step: filling other parameters of AGGREGATE.
        fillAggregate(aggregate, res);

        return aggregate;
    }

    private void fillAggregate(PgAggregate aggregate, ResultSet res) throws SQLException {
        // 'setDirectCount' must be first at this method, because of using 'directCount' later.
        if (AggKinds.NORMAL == aggregate.getKind()) {
            aggregate.setDirectCount(aggregate.getArguments().size());
        } else {
            int directCount = res.getInt("aggnumdirectargs");
            aggregate.setDirectCount(directCount);

            if (directCount == res.getInt("pronargs")) {
                // Explanation from documentation about this special case
                // (source: "https://www.postgresql.org/docs/11/sql-createaggregate.html").
                //
                // The syntax for ordered-set aggregates allows VARIADIC to be specified
                // for both the last direct parameter and the last aggregated (WITHIN GROUP)
                // parameter. However, the current implementation restricts use of VARIADIC
                // in two ways. First, ordered-set aggregates can only use VARIADIC "any",
                // not other variadic array types. Second, if the last direct parameter is
                // VARIADIC "any", then there can be only one aggregated parameter and it
                // must also be VARIADIC "any". (In the representation used in the system
                // catalogs, these two parameters are merged into a single VARIADIC "any"
                // item, since pg_proc cannot represent functions with more than one VARIADIC
                // parameter.) If the aggregate is a hypothetical-set aggregate, the direct
                // arguments that match the VARIADIC "any" parameter are the hypothetical
                // ones; any preceding parameters represent additional direct arguments
                // that are not constrained to match the aggregated arguments.

                // last argument must be VARIADIC "any"
                List<Argument> args = aggregate.getArguments();
                aggregate.addArgument(args.get(args.size() - 1));
            }
        }

        // since 9.6 PostgreSQL
        // parallel mode: s - safe, r - restricted, u - unsafe
        if (SupportedPgVersion.VERSION_9_6.isLE(loader.getVersion())) {
            String parMode = res.getString("proparallel");
            switch (parMode) {
            case "s":
                aggregate.setParallel("SAFE");
                break;
            case "r":
                aggregate.setParallel("RESTRICTED");
                break;
            default:
                break;
            }
        }

        // since 9.6 PostgreSQL and default for greenplum
        if (SupportedPgVersion.VERSION_9_6.isLE(loader.getVersion()) || loader.isGreenplumDb()) {
            aggregate.setCombineFunc(getProcessedName(aggregate, res.getString("combinefunc_nsp"),
                    res.getString("combinefunc"), AggFuncs.COMBINEFUNC));
            aggregate.setSerialFunc(getProcessedName(aggregate, res.getString("serialfunc_nsp"),
                    res.getString("serialfunc"), AggFuncs.SERIALFUNC));
            aggregate.setDeserialFunc(getProcessedName(aggregate, res.getString("deserialfunc_nsp"),
                    res.getString("deserialfunc"), AggFuncs.DESERIALFUNC));
        }
        // since 11 PostgreSQL
        if (SupportedPgVersion.VERSION_11.isLE(loader.getVersion())) {
            aggregate.setFinalFuncModify(getModifyType(
                    res.getString("finalfunc_modify"), aggregate.getKind()));
            aggregate.setMFinalFuncModify(getModifyType(
                    res.getString("mfinalfunc_modify"), aggregate.getKind()));
        }

        JdbcType sType = loader.getCachedTypeByOid(res.getLong("stype"));
        aggregate.setSType(sType.getFullName());
        sType.addTypeDepcy(aggregate);

        aggregate.setSSpace(res.getInt("sspace"));

        aggregate.setSFunc(getProcessedName(aggregate, res.getString("sfunc_nsp"),
                res.getString("sfunc"), AggFuncs.SFUNC));
        aggregate.setFinalFunc(getProcessedName(aggregate, res.getString("finalfunc_nsp"),
                res.getString("finalfunc"), AggFuncs.FINALFUNC));

        aggregate.setFinalFuncExtra(res.getBoolean("is_finalfunc_extra"));

        String initCond = res.getString("initcond");
        if (initCond != null) {
            aggregate.setInitCond(PgDiffUtils.quoteString(initCond));
        }

        // The parameter 'MSTYPE' must be processed before parameters 'MSFUNC',
        // 'MINVFUNC', 'MFINALFUNC', for correctly adding dependencies on the
        // functions 'MSFUNC', 'MINVFUNC', 'MFINALFUNC'.
        long mstype = res.getLong("mstype");
        if (mstype != 0) {
            JdbcType mSType = loader.getCachedTypeByOid(mstype);
            aggregate.setMSType(mSType.getFullName());
            mSType.addTypeDepcy(aggregate);
        }

        aggregate.setMSFunc(getProcessedName(aggregate, res.getString("msfunc_nsp"),
                res.getString("msfunc"), AggFuncs.MSFUNC));
        aggregate.setMInvFunc(getProcessedName(aggregate, res.getString("minvfunc_nsp"),
                res.getString("minvfunc"), AggFuncs.MINVFUNC));

        aggregate.setMSSpace(res.getInt("msspace"));

        aggregate.setMFinalFunc(getProcessedName(aggregate, res.getString("mfinalfunc_nsp"),
                res.getString("mfinalfunc"), AggFuncs.MFINALFUNC));

        aggregate.setMFinalFuncExtra(res.getBoolean("is_mfinalfunc_extra"));

        String mInitCond = res.getString("minitcond");
        if (mInitCond != null) {
            aggregate.setMInitCond(PgDiffUtils.quoteString(mInitCond));
        }

        String sortOpName = res.getString("sortop");
        if (sortOpName != null) {
            String operSchemaName = res.getString("sortop_nsp");
            StringBuilder sb = new StringBuilder().append("OPERATOR(")
                    .append(PgDiffUtils.getQuotedName(operSchemaName))
                    .append('.').append(sortOpName).append(')');
            aggregate.setSortOp(sb.toString());

            String operName = sortOpName + CreateAggregate.getSortOperSign(aggregate);
            addDep(aggregate, operSchemaName, operName, DbObjType.OPERATOR);
        }
    }

    private String getProcessedName(PgAggregate agg, String schemaName, String funcName, AggFuncs funcType) {
        if (funcName == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!Consts.PG_CATALOG.equalsIgnoreCase(schemaName)) {
            addDep(agg, schemaName, funcName + CreateAggregate.getParamFuncSignature(agg, funcType),
                    DbObjType.FUNCTION);
            sb.append(PgDiffUtils.getQuotedName(schemaName)).append('.');
        }
        sb.append(PgDiffUtils.getQuotedName(funcName));
        return sb.toString();
    }

    private ModifyType getModifyType(String modifier, AggKinds kind) {
        switch (modifier) {
        case "r":
            return AggKinds.NORMAL == kind ? null : ModifyType.READ_ONLY;
        case "s":
            return ModifyType.SHAREABLE;
        case "w":
            return AggKinds.NORMAL != kind ? null : ModifyType.READ_WRITE;
        default:
            throw new IllegalStateException("FinalFuncModifier '" + modifier + "' doesn't support by AGGREGATE!");
        }
    }

    /**
     * Returns a list of pairs, each of which contains the name of the argument and its full type name in GenericColumn
     * object (typeSchema, typeName, DbObjType.TYPE).
     */
    private List<Pair<String, GenericColumn>> fillArguments(AbstractPgFunction f,
            ResultSet res) throws SQLException {
        StringBuilder sb = new StringBuilder();
        String[] argModes = getColArray(res, "proargmodes");
        String[] argNames = getColArray(res, "proargnames");
        Long[] argTypeOids = getColArray(res, "proallargtypes");
        Long[] argTypes = argTypeOids != null ? argTypeOids : getColArray(res, "argtypes");

        // It will be used for sending the arguments of function to the namespaces
        // in launcher for correct analysis.
        List<Pair<String, GenericColumn>> argsQualifiedTypes = new ArrayList<>();

        for (int i = 0; argTypes.length > i; i++) {
            String aMode = argModes != null ? argModes[i] : "i";

            JdbcType returnType = loader.getCachedTypeByOid(argTypes[i]);
            returnType.addTypeDepcy(f);

            if ("t".equals(aMode)) {
                String name = argNames[i];
                String type = returnType.getFullName();
                sb.append(PgDiffUtils.getQuotedName(name)).append(" ")
                .append(type).append(", ");
                f.addReturnsColumn(argNames[i], type);
                continue;
            }

            JdbcType argJdbcType = loader.getCachedTypeByOid(argTypes[i]);
            String argName = argNames != null ? argNames[i] : null;

            // these require resetHash functionality for defaults
            Argument a = f.new PgArgument(ArgMode.of(aMode), argName, argJdbcType.getFullName());

            if (!"o".equals(aMode)) {
                argsQualifiedTypes.add(new Pair<>(argName, argJdbcType.getQualifiedName()));
            }

            f.addArgument(a);
        }

        if (DbObjType.FUNCTION == f.getStatementType() || DbObjType.AGGREGATE == f.getStatementType()) {
            // RETURN TYPE
            if (sb.length() != 0) {
                sb.setLength(sb.length() - 2);
                f.setReturns("TABLE(" + sb + ")");
            } else {
                JdbcType returnType = loader.getCachedTypeByOid(res.getLong("prorettype"));
                String retType = returnType.getFullName();
                f.setReturns(res.getBoolean("proretset") ? "SETOF " + retType : retType);
                returnType.addTypeDepcy(f);
            }
        }

        return argsQualifiedTypes;
    }

    @Override
    protected String getClassId() {
        return "pg_proc";
    }

    @Override
    protected String getSchemaColumn() {
        return "res.pronamespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addExtensionDepsCte(builder);
        addDescriptionPart(builder);

        builder
        // common part (functions/procedures/aggregates)
        .column("res.proname")
        .column("res.proowner::bigint")
        .column("res.prorettype::bigint")
        .column("res.proallargtypes::bigint[]")
        .column("res.proargmodes")
        .column("res.proargnames")
        .column("res.proacl::text AS aclarray")
        .column("res.proretset")
        .column("array(select pg_catalog.unnest(res.proargtypes))::bigint[] as argtypes")
        .from("pg_catalog.pg_proc res")
        .where("NOT EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp WHERE dp.classid = 'pg_catalog.pg_proc'::pg_catalog.regclass AND dp.objid = res.oid AND dp.deptype = 'i')")

        // for functions/procedures
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
        .column("res.pronargs")
        .join("LEFT JOIN pg_catalog.pg_language l ON l.oid = res.prolang")

        // for aggregates
        .column("sfunc.proname AS sfunc")
        .column("sfunc_n.nspname AS sfunc_nsp")
        .column("a.aggtranstype AS stype")
        .column("a.aggtransspace AS sspace")
        .column("finalfn.proname AS finalfunc")
        .column("finalfn_n.nspname AS finalfunc_nsp")
        .column("a.aggfinalextra AS is_finalfunc_extra")
        .column("a.agginitval AS initcond")
        .column("msfunc.proname AS msfunc")
        .column("msfunc_n.nspname AS msfunc_nsp")
        .column("minvfunc.proname AS minvfunc")
        .column("minvfunc_n.nspname AS minvfunc_nsp")
        .column("a.aggmtranstype AS mstype")
        .column("a.aggmtransspace AS msspace")
        .column("mfinalfn.proname AS mfinalfunc")
        .column("mfinalfn_n.nspname AS mfinalfunc_nsp")
        .column("a.aggmfinalextra AS is_mfinalfunc_extra")
        .column("a.aggminitval AS minitcond")
        .column("sortop.oprname AS sortop")
        .column("sortop_n.nspname AS sortop_nsp")
        .column("a.aggkind")
        .column("a.aggnumdirectargs")
        .join("LEFT JOIN pg_catalog.pg_aggregate a ON a.aggfnoid = res.oid")
        .join("LEFT JOIN pg_catalog.pg_proc sfunc ON a.aggtransfn = sfunc.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace sfunc_n ON sfunc.pronamespace = sfunc_n.oid")
        .join("LEFT JOIN pg_catalog.pg_proc finalfn ON a.aggfinalfn = finalfn.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace finalfn_n ON finalfn.pronamespace = finalfn_n.oid")
        .join("LEFT JOIN pg_catalog.pg_proc msfunc ON a.aggmtransfn = msfunc.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace msfunc_n ON msfunc.pronamespace = msfunc_n.oid")
        .join("LEFT JOIN pg_catalog.pg_proc minvfunc ON a.aggminvtransfn = minvfunc.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace minvfunc_n ON minvfunc.pronamespace = minvfunc_n.oid")
        .join("LEFT JOIN pg_catalog.pg_proc mfinalfn ON a.aggmfinalfn = mfinalfn.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace mfinalfn_n ON mfinalfn.pronamespace = mfinalfn_n.oid")
        .join("LEFT JOIN pg_catalog.pg_operator sortop ON a.aggsortop = sortop.oid")
        .join("LEFT JOIN pg_catalog.pg_namespace sortop_n ON sortop.oprnamespace = sortop_n.oid");

        if (SupportedPgVersion.VERSION_9_5.isLE(loader.getVersion())) {
            builder.column("res.protrftypes::bigint[]");
        }

        if (SupportedPgVersion.VERSION_9_6.isLE(loader.getVersion())) {
            builder.column("res.proparallel");
        }

        if (SupportedPgVersion.VERSION_9_6.isLE(loader.getVersion()) || loader.isGreenplumDb()) {
            builder
            .column("combinefn.proname AS combinefunc")
            .column("combinefn_n.nspname AS combinefunc_nsp")
            .column("serialfn.proname AS serialfunc")
            .column("serialfn_n.nspname AS serialfunc_nsp")
            .column("deserialfn.proname AS deserialfunc")
            .column("deserialfn_n.nspname AS deserialfunc_nsp")
            .join("LEFT JOIN pg_catalog.pg_proc combinefn ON a.aggcombinefn = combinefn.oid")
            .join("LEFT JOIN pg_catalog.pg_namespace combinefn_n ON combinefn.pronamespace = combinefn_n.oid")
            .join("LEFT JOIN pg_catalog.pg_proc serialfn ON a.aggserialfn = serialfn.oid")
            .join("LEFT JOIN pg_catalog.pg_namespace serialfn_n ON serialfn.pronamespace = serialfn_n.oid")
            .join("LEFT JOIN pg_catalog.pg_proc deserialfn ON a.aggdeserialfn = deserialfn.oid")
            .join("LEFT JOIN pg_catalog.pg_namespace deserialfn_n ON deserialfn.pronamespace = deserialfn_n.oid");
        }

        if (SupportedPgVersion.VERSION_11.isLE(loader.getVersion())) {
            builder
            .column("res.prokind = 'a' AS proisagg")
            .column("res.prokind = 'w' AS proiswindow")
            .column("res.prokind = 'p' AS proisproc")
            .column("a.aggfinalmodify AS finalfunc_modify")
            .column("a.aggmfinalmodify AS mfinalfunc_modify");
        } else {
            builder
            .column("res.proisagg")
            .column("res.proiswindow");
        }

        if (SupportedPgVersion.VERSION_12.isLE(loader.getVersion())) {
            builder.column("res.prosupport AS support_func");
        }

        if (SupportedPgVersion.VERSION_14.isLE(loader.getVersion())) {
            builder.column("pg_get_function_sqlbody(res.oid) AS prosqlbody");
        }

        if (loader.isGreenplumDb()) {
            builder.column("res.proexeclocation AS executeOn");
        }
    }
}
