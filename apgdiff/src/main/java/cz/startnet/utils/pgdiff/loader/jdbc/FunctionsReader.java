package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;
import java.util.function.BiConsumer;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateAggregate;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgAggregate;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgProcedure;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStorage;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

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
        AbstractFunction f = res.getBoolean("proisagg") ? processResultAggr(res, schemaName, funcName)
                : processResultFunc(res, schema, schemaName, funcName);

        // OWNER
        loader.setOwner(f, res.getLong("proowner"));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            f.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        // PRIVILEGES
        loader.setPrivileges(f, res.getString("aclarray"), schemaName);

        schema.addFunction(f);
    }

    private AbstractFunction processResultFunc(ResultSet res, AbstractSchema schema,
            String schemaName, String funcName) throws SQLException {
        boolean isProc = SupportedVersion.VERSION_11.isLE(loader.version)
                && (res.getBoolean("proisproc"));

        loader.setCurrentObject(new GenericColumn(schemaName, funcName,
                isProc ? DbObjType.PROCEDURE : DbObjType.FUNCTION));

        AbstractFunction f = isProc ? new PgProcedure(funcName, "") : new PgFunction(funcName, "");

        fillFunction(f, res);
        StringBuilder returnedTableArguments = fillAllArguments(f, res);

        if (!isProc) {
            // RETURN TYPE
            if (returnedTableArguments.length() != 0) {
                returnedTableArguments.setLength(returnedTableArguments.length() - 2);
                f.setReturns("TABLE(" + returnedTableArguments + ")");
            } else {
                JdbcType returnType = loader.cachedTypesByOid.get(res.getLong("prorettype"));
                String retType = returnType.getFullName();
                f.setReturns(res.getBoolean("proretset") ? "SETOF " + retType : retType);
                returnType.addTypeDepcy(f);
            }
        }

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
                            if ("IN".equals(a.getMode()) || "INOUT".equals(a.getMode())) {
                                VexContext vx = vexCtxListIterator.previous();
                                a.setDefaultExpression(ParserAbstract.getFullCtxText(vx));
                                schema.getDatabase().addContextForAnalyze(f, vx);
                            }
                        }
                    });
        }

        return f;
    }

    private void fillFunction(AbstractFunction function, ResultSet res) throws SQLException {
        StringBuilder body = new StringBuilder();

        function.setLanguage(res.getString("lang_name"));

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
        function.setCost(res.getFloat("procost"));

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

    private AbstractFunction processResultAggr(ResultSet res, String schemaName,
            String funcName) throws SQLException {
        loader.setCurrentObject(new GenericColumn(schemaName, funcName, DbObjType.AGGREGATE));
        PgAggregate aggr = new PgAggregate(funcName, "");

        //// The order is important for adding dependencies. Two steps.

        // First step: filling all types and arguments.
        fillAllArguments(aggr, res);

        // Second step: filling other parameters of AGGREGATE.
        fillAggregate(aggr, res, schemaName);

        return aggr;
    }

    private void fillAggregate(PgAggregate aggregate, ResultSet res,
            String schemaName) throws SQLException {
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
        }

        // since 11 PostgreSQL
        if (SupportedVersion.VERSION_11.isLE(loader.version)) {
            aggregate.setFinalFuncModify(getFuncModifier(res.getString("finalfunc_modify")));
            aggregate.setMFinalFuncModify(getFuncModifier(res.getString("mfinalfunc_modify")));
        }

        JdbcType sType = loader.cachedTypesByOid.get(res.getLong("stype"));
        aggregate.setSType(sType.getFullName(schemaName));
        sType.addTypeDepcy(aggregate);

        String sFuncSchemaName = res.getString("sfunc_nsp");
        String sFuncName = res.getString("sfunc");
        aggregate.setSFunc(getProcessedName(sFuncSchemaName, sFuncName));
        addFuncAsDepcy(aggregate, sFuncSchemaName,
                CreateAggregate.getParamFuncSignature(aggregate, sFuncName,
                        PgAggregate.SFUNC));

        String kind = res.getString("aggkind");
        aggregate.setKind(kind);

        if ("h".equals(kind)) {
            aggregate.setHypothetical(true);
        }

        String sspace = res.getString("sspace");
        if (sspace != null) {
            aggregate.setSSpace(Long.parseLong(sspace));
        }

        String finalFuncName = res.getString("finalfunc");
        if (finalFuncName != null) {
            String finalFuncSchemaName = res.getString("finalfunc_nsp");
            aggregate.setFinalFunc(getProcessedName(finalFuncSchemaName, finalFuncName));
            addFuncAsDepcy(aggregate, finalFuncSchemaName,
                    CreateAggregate.getParamFuncSignature(aggregate, finalFuncName,
                            PgAggregate.FINALFUNC));
        }

        if (res.getBoolean("is_finalfunc_extra")) {
            aggregate.setFinalFuncExtra(true);
        }

        String combineFuncName = res.getString("combinefunc");
        if (combineFuncName != null) {
            String combineFuncSchemaName = res.getString("combinefunc_nsp");
            aggregate.setCombineFunc(getProcessedName(combineFuncSchemaName, combineFuncName));
            addFuncAsDepcy(aggregate, combineFuncSchemaName,
                    CreateAggregate.getParamFuncSignature(aggregate, combineFuncName,
                            PgAggregate.COMBINEFUNC));
        }

        String serialfanc = res.getString("serialfanc");
        if (serialfanc != null) {
            // TODO add dependency
            aggregate.setSerialFunc(getProcessedName(res.getString("serialfanc_nsp"), serialfanc));
        }

        String deserialfunc = res.getString("deserialfunc");
        if (deserialfunc != null) {
            // TODO add dependency
            aggregate.setDeserialFunc(getProcessedName(res.getString("deserialfunc_nsp"), deserialfunc));
        }

        String initCond = res.getString("initcond");
        if (initCond != null) {
            aggregate.setInitCond(PgDiffUtils.quoteString(initCond));
        }

        String msFuncName = res.getString("msfunc");
        if (msFuncName != null) {
            String mSFuncSchemaName = res.getString("msfunc_nsp");
            aggregate.setMSFunc(getProcessedName(mSFuncSchemaName, msFuncName));
            addFuncAsDepcy(aggregate, mSFuncSchemaName,
                    CreateAggregate.getParamFuncSignature(aggregate, msFuncName,
                            PgAggregate.MSFUNC));
        }

        String mInvFuncName = res.getString("minvfunc");
        if (mInvFuncName != null) {
            String mInvFuncSchemaName = res.getString("minvfunc_nsp");
            aggregate.setMInvFunc(getProcessedName(mInvFuncSchemaName, mInvFuncName));
            addFuncAsDepcy(aggregate, mInvFuncSchemaName,
                    CreateAggregate.getParamFuncSignature(aggregate, mInvFuncName,
                            PgAggregate.MINVFUNC));
        }

        long mstype = res.getLong("mstype");
        if (mstype != 0) {
            JdbcType mSType = loader.cachedTypesByOid.get(mstype);
            aggregate.setMSType(mSType.getFullName(schemaName));
            mSType.addTypeDepcy(aggregate);
        }

        String msspace = res.getString("msspace");
        if (msspace != null) {
            aggregate.setMSSpace(Long.parseLong(msspace));
        }

        String mFinalFuncName = res.getString("mfinalfunc");
        if (mFinalFuncName != null) {
            String mFinalFuncSchemaName = res.getString("mfinalfunc_nsp");
            aggregate.setMFinalFunc(getProcessedName(mFinalFuncSchemaName, mFinalFuncName));
            addFuncAsDepcy(aggregate, mFinalFuncSchemaName,
                    CreateAggregate.getParamFuncSignature(aggregate, mFinalFuncName,
                            PgAggregate.MFINALFUNC));
        }

        if (res.getBoolean("is_mfinalfunc_extra")) {
            aggregate.setMFinalFuncExtra(true);
        }

        String mInitCond = res.getString("minitcond");
        if (mInitCond != null) {
            aggregate.setMInitCond(PgDiffUtils.quoteString(mInitCond));
        }

        String sortOp = res.getString("sortop");
        if (sortOp != null) {
            // TODO add dependency
            aggregate.setSortOp(getProcessedName(res.getString("sortop_nsp"), sortOp));
        }
    }

    private String getFuncModifier(String modifier) {
        switch (modifier) {
        case "r":
            return "READ_ONLY";
        case "s":
            return "SHAREABLE";
        case "w":
            return "READ_WRITE";
        default :
            throw new IllegalStateException("FinalFuncModifier '"+ modifier + "' doesn't support by AGGREGATE!");
        }
    }

    private void addFuncAsDepcy(PgAggregate aggr, String funcSchemaName, String funcName) {
        if (!PgSystemStorage.SCHEMA_PG_CATALOG.equalsIgnoreCase(funcSchemaName)) {
            aggr.addDep(new GenericColumn(funcSchemaName, funcName, DbObjType.FUNCTION));
        }
    }

    private StringBuilder fillAllArguments(AbstractFunction f, ResultSet res)
            throws SQLException {
        StringBuilder returnedTableArguments = new StringBuilder();
        String[] argModes = getColArray(res, "proargmodes");
        String[] argNames = getColArray(res, "proargnames");
        Long[] argTypeOids = getColArray(res, "proallargtypes");

        Long[] argTypes = argTypeOids != null ? argTypeOids : getColArray(res, "argtypes");
        int allArgsLength =  argTypes.length;

        BiConsumer<AbstractFunction, Argument> addArgument = (fn, a) -> fn.addArgument(a);

        String aggrKind = (f instanceof PgAggregate) ? ((PgAggregate) f).getKind() : null;
        int aggNumDirectArgs = res.getInt("aggnumdirectargs");
        if (aggrKind == null ||
                (PgAggregate.NORMAL.equals(aggrKind) && aggNumDirectArgs == 0)) {
            // This case used for FUNCTIONs and NORMAL AGGREGATEs.

            fillArguments(argModes, argTypes, argNames, 0, allArgsLength,
                    f, returnedTableArguments, addArgument);
        } else {
            if (aggNumDirectArgs != 0) {
                // This case is used for ORDERED and HYPOTHETICAL aggregates,
                // which have arguments and orderByArguments in their signature.

                fillArguments(argModes, argTypes, argNames, 0, aggNumDirectArgs,
                        f, returnedTableArguments, addArgument);

                fillArguments(argModes, argTypes, argNames, aggNumDirectArgs, allArgsLength,
                        f, returnedTableArguments,
                        (abstrFunc, a) -> ((PgAggregate) abstrFunc).addOrderByArg(a));
            } else {
                // This case is used for ORDERED and HYPOTHETICAL aggregates,
                // which have only orderByArguments in their signature.

                fillArguments(argModes, argTypes, argNames, 0, allArgsLength,
                        f, returnedTableArguments,
                        (abstrFunc, a) -> ((PgAggregate) abstrFunc).addOrderByArg(a));
            }
        }

        return returnedTableArguments;
    }

    private void fillArguments(String[] argModes, Long[] argTypes, String[] argNames,
            int startInex, int arrayLength, AbstractFunction f, StringBuilder returnedTableArguments,
            BiConsumer<AbstractFunction, Argument> addArgument) {
        for (int i = startInex; arrayLength > i; i++) {
            String aMode = argModes != null ? argModes[i] : "i";

            JdbcType returnType = loader.cachedTypesByOid.get(argTypes[i]);
            returnType.addTypeDepcy(f);

            if("t".equals(aMode)) {
                String name = argNames[i];
                String type = returnType.getFullName();
                returnedTableArguments.append(PgDiffUtils.getQuotedName(name)).append(" ")
                .append(type).append(", ");
                f.addReturnsColumn(argNames[i], type);
                continue;
            }

            switch(aMode) {
            case "i":
                aMode = "IN";
                break;
            case "o":
                aMode = "OUT";
                break;
            case "b":
                aMode = "INOUT";
                break;
            case "v":
                aMode = "VARIADIC";
                break;
            }

            // these require resetHash functionality for defaults
            addArgument.accept(f, f.new PgArgument(aMode, argNames != null ? argNames[i] : null,
                    loader.cachedTypesByOid.get(argTypes[i]).getFullName()));
        }
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.FUNCTION;
    }
}
