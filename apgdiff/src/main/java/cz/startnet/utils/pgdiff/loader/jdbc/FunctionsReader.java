package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgAggregate;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgProcedure;
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
        AbstractFunction f = res.getBoolean("proisagg") ? processResultAggr(res, schema, schemaName, funcName)
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
        StringBuilder returnedTableArguments = fillArguments(f, res);

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

    private AbstractFunction processResultAggr(ResultSet res, AbstractSchema schema,
            String schemaName, String funcName) throws SQLException {
        loader.setCurrentObject(new GenericColumn(schemaName, funcName, DbObjType.AGGREGATE));

        PgAggregate f = new PgAggregate(funcName, "");

        fillAggregate(f, res);
        fillArguments(f, res);

        // RETURN TYPE
        JdbcType returnType = loader.cachedTypesByOid.get(res.getLong("prorettype"));
        f.setReturns(returnType.getFullName());
        returnType.addTypeDepcy(f);

        return f;
    }

    private void fillAggregate(PgAggregate aggregate, ResultSet res) throws SQLException {
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

        aggregate.setSFunc(getProcessedName(res.getString("sfunc_nsp"), res.getString("sfunc")));
        aggregate.setSType(loader.cachedTypesByOid.get(res.getLong("stype")).getFullName());

        String kind = res.getString("aggkind");
        aggregate.setKind(kind);

        if ("h".equals(kind)) {
            aggregate.setHypothetical(true);
        }

        String sspace = res.getString("sspace");
        if (sspace != null) {
            aggregate.setSSpace(Long.parseLong(sspace));
        }

        String finalfunc = res.getString("finalfunc");
        if (finalfunc != null) {
            aggregate.setFinalFunc(getProcessedName(res.getString("finalfunc_nsp"), finalfunc));
        }

        if (res.getBoolean("is_finalfunc_extra")) {
            aggregate.setFinalFuncExtra(true);
        }

        String combinefunc = res.getString("combinefunc");
        if (combinefunc != null) {
            aggregate.setCombineFunc(getProcessedName(res.getString("combinefunc_nsp"), combinefunc));
        }

        String serialfanc = res.getString("serialfanc");
        if (serialfanc != null) {
            aggregate.setSerialFunc(getProcessedName(res.getString("serialfanc_nsp"), serialfanc));
        }

        String deserialfunc = res.getString("deserialfunc");
        if (deserialfunc != null) {
            aggregate.setDeserialFunc(getProcessedName(res.getString("deserialfunc_nsp"), deserialfunc));
        }

        String initCond = res.getString("initcond");
        if (initCond != null) {
            aggregate.setInitCond(PgDiffUtils.quoteString(initCond));
        }

        String msfunc = res.getString("msfunc");
        if (deserialfunc != null) {
            aggregate.setMSFunc(getProcessedName(res.getString("msfunc_nsp"), msfunc));
        }

        String minvfunc = res.getString("minvfunc");
        if (minvfunc != null) {
            aggregate.setMInvFunc(getProcessedName(res.getString("minvfunc_nsp"), minvfunc));
        }

        long mstype = res.getLong("mstype");
        if (mstype != 0) {
            aggregate.setMSType(loader.cachedTypesByOid.get(mstype).getFullName());
        }

        String msspace = res.getString("msspace");
        if (sspace != null) {
            aggregate.setMSSpace(Long.parseLong(msspace));
        }

        String mfinalfunc = res.getString("mfinalfunc");
        if (mfinalfunc != null) {
            aggregate.setMFinalFunc(getProcessedName(res.getString("mfinalfunc_nsp"), mfinalfunc));
        }

        if (res.getBoolean("is_mfinalfunc_extra")) {
            aggregate.setMFinalFuncExtra(true);
        }

        String mInitCond = res.getString("minitcond");
        if (mInitCond != null) {
            aggregate.setMInitCond(PgDiffUtils.quoteString(mInitCond));
        }

        String sortOp = res.getString("sortop");
        if (mfinalfunc != null) {
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

    private StringBuilder fillArguments(AbstractFunction f, ResultSet res)
            throws SQLException {
        StringBuilder returnedTableArguments = new StringBuilder();
        String[] argModes = getColArray(res, "proargmodes");
        String[] argNames = getColArray(res, "proargnames");
        Long[] argTypeOids = getColArray(res, "proallargtypes");

        Long[] argTypes = argTypeOids != null ? argTypeOids : getColArray(res, "argtypes");
        for (int i = 0; argTypes.length > i; i++) {
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
            Argument a = f.new PgArgument(aMode, argNames != null ? argNames[i] : null,
                    loader.cachedTypesByOid.get(argTypes[i]).getFullName());

            f.addArgument(a);
        }
        return returnedTableArguments;
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.FUNCTION;
    }
}
