package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.launcher.FuncProcAnalysisLauncher;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateAggregate;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractPgFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.ArgMode;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgAggregate;
import cz.startnet.utils.pgdiff.schema.PgAggregate.AggFuncs;
import cz.startnet.utils.pgdiff.schema.PgAggregate.AggKinds;
import cz.startnet.utils.pgdiff.schema.PgAggregate.ModifyType;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgProcedure;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

/**
 * Reads FUNCTIONs, PROCEDUREs and AGGREGATEs from JDBC.
 */
public class FunctionsReader extends JdbcReader {

    public FunctionsReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_FUNCTIONS, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        String funcName = res.getString("proname");
        AbstractFunction f = res.getBoolean("proisagg") ? getAgg(res, schemaName, funcName)
                : getFunc(res, schema, funcName);

        // OWNER
        loader.setOwner(f, res.getLong("proowner"));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            f.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        // PRIVILEGES
        loader.setPrivileges(f, res.getString("aclarray"), schemaName);
        loader.setAuthor(f, res);

        schema.addFunction(f);
    }

    private AbstractFunction getFunc(ResultSet res, AbstractSchema schema,
            String funcName) throws SQLException {
        boolean isProc = SupportedVersion.VERSION_11.isLE(loader.version)
                && (res.getBoolean("proisproc"));

        loader.setCurrentObject(new GenericColumn(schema.getName(), funcName,
                isProc ? DbObjType.PROCEDURE : DbObjType.FUNCTION));

        AbstractPgFunction f = isProc ? new PgProcedure(funcName) : new PgFunction(funcName);

        PgDatabase db = schema.getDatabase();

        fillFunction(f, res, db, fillArguments(f, res));

        String defaultValuesAsString = res.getString("default_values_as_string");
        if (defaultValuesAsString != null) {
            loader.submitAntlrTask(defaultValuesAsString, SQLParser::vex_eof,
                    ctx -> {
                        List<VexContext> vexCtxList = ctx.vex();
                        ListIterator<VexContext> vexCtxListIterator = vexCtxList.listIterator(vexCtxList.size());

                        for (int i = (f.getArguments().size() - 1); i >= 0; i--) {
                            if (!vexCtxListIterator.hasPrevious()) {
                                break;
                            }
                            Argument a = f.getArguments().get(i);
                            if (a.getMode().isIn()) {
                                VexContext vx = vexCtxListIterator.previous();
                                a.setDefaultExpression(ParserAbstract.getFullCtxText(vx));
                                db.addAnalysisLauncher(new FuncProcAnalysisLauncher(f, vx));
                            }
                        }
                    });
        }

        return f;
    }

    private void fillFunction(AbstractPgFunction function, ResultSet res,
            PgDatabase db, List<Pair<String, GenericColumn>> argsQualTypes)
                    throws SQLException {
        StringBuilder body = new StringBuilder();

        function.setLanguageCost(res.getString("lang_name"), res.getFloat("procost"));

        // since 9.5 PostgreSQL
        if (SupportedVersion.VERSION_9_5.isLE(loader.version)) {
            Long[] protrftypes = getColArray(res, "protrftypes");
            if (protrftypes != null) {
                for (Long s : protrftypes) {
                    function.addTransform(loader.cachedTypesByOid.get(s).getFullName());
                }
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
        default :
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
            default :
                break;
            }
        }

        float rows = res.getFloat("prorows");
        if (0.0f != rows) {
            function.setRows(rows);
        }

        String[] proconfig = getColArray(res, "proconfig");
        if (proconfig != null) {
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
                                    sb.append(PgDiffUtils.quoteString(
                                            vex.getText()));
                                    sb.append(", ");
                                }
                                sb.setLength(sb.length() - 2);
                                function.addConfiguration(par, sb.toString());
                            });
                    break;
                default :
                    val = PgDiffUtils.quoteString(val);
                    function.addConfiguration(PgDiffUtils.getQuotedName(par), val);
                    break;
                }
            }
        }

        String definition = res.getString("prosrc");
        String quote = getStringLiteralDollarQuote(definition);
        String probin = res.getString("probin");
        if (probin != null && !probin.isEmpty()) {
            body.append(PgDiffUtils.quoteString(probin));
            if (!"-".equals(definition)) {
                body.append(", ");
                if (!definition.contains("\'") && !definition.contains("\\")) {
                    body.append(PgDiffUtils.quoteString(definition));
                } else {
                    body.append(quote).append(definition).append(quote);
                }
            }
        } else if (!"-".equals(definition)) {
            body.append(quote).append(definition).append(quote);
        }

        function.setBody(loader.args, body.toString());

        // Parsing the function definition and adding its result context for analysis.
        if (!"-".equals(definition) && "SQL".equalsIgnoreCase(function.getLanguage())) {
            loader.submitAntlrTask(definition, SQLParser::sql, ctx -> db.addAnalysisLauncher(
                    new FuncProcAnalysisLauncher(function, ctx, argsQualTypes)));
        } else if (!"-".equals(definition) && "PLPGSQL".equalsIgnoreCase(function.getLanguage())) {
            loader.submitAntlrTask(definition, SQLParser::plpgsql_function, ctx -> db.addAnalysisLauncher(
                    new FuncProcAnalysisLauncher(function, ctx, argsQualTypes)));
        }
    }

    /**
     * Function equivalent to appendStringLiteralDQ in dumputils.c
     */
    public static String getStringLiteralDollarQuote(String definition) {
        final String suffixes = "_XXXXXXX";
        String quote = "$";
        int counter = 0;
        while (definition.contains(quote)) {
            quote = quote.concat(String.valueOf(suffixes.charAt(counter++)));
            counter %= suffixes.length();
        }

        return quote.concat("$");
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
        aggregate.setDirectCount(AggKinds.NORMAL == aggregate.getKind() ?
                aggregate.getArguments().size() : res.getInt("aggnumdirectargs"));

        // since 9.6 PostgreSQL
        // parallel mode: s - safe, r - restricted, u - unsafe
        if (SupportedVersion.VERSION_9_6.isLE(loader.version)) {
            String parMode = res.getString("proparallel");
            switch (parMode) {
            case "s":
                aggregate.setParallel("SAFE");
                break;
            case "r":
                aggregate.setParallel("RESTRICTED");
                break;
            default :
                break;
            }

            aggregate.setCombineFunc(getProcessedName(aggregate, res.getString("combinefunc_nsp"),
                    res.getString("combinefunc"), AggFuncs.COMBINEFUNC));
            aggregate.setSerialFunc(getProcessedName(aggregate, res.getString("serialfunc_nsp"),
                    res.getString("serialfunc"), AggFuncs.SERIALFUNC));
            aggregate.setDeserialFunc(getProcessedName(aggregate, res.getString("deserialfunc_nsp"),
                    res.getString("deserialfunc"), AggFuncs.DESERIALFUNC));
        }

        // since 11 PostgreSQL
        if (SupportedVersion.VERSION_11.isLE(loader.version)) {
            aggregate.setFinalFuncModify(getModifyType(
                    res.getString("finalfunc_modify"), aggregate.getKind()));
            aggregate.setMFinalFuncModify(getModifyType(
                    res.getString("mfinalfunc_modify"), aggregate.getKind()));
        }

        JdbcType sType = loader.cachedTypesByOid.get(res.getLong("stype"));
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
            JdbcType mSType = loader.cachedTypesByOid.get(mstype);
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

            aggregate.addDep(new GenericColumn(operSchemaName,
                    sortOpName + CreateAggregate.getSortOperSign(aggregate),
                    DbObjType.OPERATOR));
        }
    }

    private String getProcessedName(PgAggregate agg, String schemaName, String funcName, AggFuncs funcType) {
        if (funcName == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!ApgdiffConsts.PG_CATALOG.equalsIgnoreCase(schemaName)) {
            agg.addDep(new GenericColumn(schemaName,
                    funcName + CreateAggregate.getParamFuncSignature(agg, funcType), DbObjType.FUNCTION));
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
        default :
            throw new IllegalStateException("FinalFuncModifier '"+ modifier + "' doesn't support by AGGREGATE!");
        }
    }

    /**
     * Returns a list of pairs, each of which contains the name of the argument
     * and its full type name in GenericColumn object (typeSchema, typeName, DbObjType.TYPE).
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

            JdbcType returnType = loader.cachedTypesByOid.get(argTypes[i]);
            returnType.addTypeDepcy(f);

            if ("t".equals(aMode)) {
                String name = argNames[i];
                String type = returnType.getFullName();
                sb.append(PgDiffUtils.getQuotedName(name)).append(" ")
                .append(type).append(", ");
                f.addReturnsColumn(argNames[i], type);
                continue;
            }

            JdbcType argJdbcType = loader.cachedTypesByOid.get(argTypes[i]);
            String argName = argNames != null ? argNames[i] : null;

            // these require resetHash functionality for defaults
            Argument a = f.new PgArgument(ArgMode.of(aMode), argName, argJdbcType.getFullName());

            if (!"o".equals(aMode)) {
                argsQualifiedTypes.add(new Pair<>(argName, argJdbcType.getQualifiedName()));
            }

            f.addArgument(a);
        }

        if (DbObjType.FUNCTION == f.getStatementType()) {
            // RETURN TYPE
            if (sb.length() != 0) {
                sb.setLength(sb.length() - 2);
                f.setReturns("TABLE(" + sb + ")");
            } else {
                JdbcType returnType = loader.cachedTypesByOid.get(res.getLong("prorettype"));
                String retType = returnType.getFullName();
                f.setReturns(res.getBoolean("proretset") ? "SETOF " + retType : retType);
                returnType.addTypeDepcy(f);
            }
        }

        return argsQualifiedTypes;
    }
}
