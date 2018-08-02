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
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class FunctionsReader extends JdbcReader {

    private static final float DEFAULT_PROCOST = 100.0f;
    private static final float DEFAULT_PROROWS = 1000.0f;

    public FunctionsReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_FUNCTIONS_PER_SCHEMA, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        String functionName = res.getString("proname");
        loader.setCurrentObject(new GenericColumn(schemaName, functionName, DbObjType.FUNCTION));
        PgFunction f = new PgFunction(functionName, "");

        f.setBody(loader.args, getFunctionBody(res, schemaName));

        // OWNER
        loader.setOwner(f, res.getLong("proowner"));

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            f.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

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

            Argument a = new Argument(aMode,
                    argNames != null ? argNames[i] : null,
                            loader.cachedTypesByOid.get(argTypes[i]).getFullName());

            f.addArgument(a);
        }

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

        // PRIVILEGES
        loader.setPrivileges(f, res.getString("aclarray"), schemaName);

        schema.addFunction(f);
    }

    private String getFunctionBody(ResultSet res, String schemaName) throws SQLException {
        StringBuilder body = new StringBuilder();

        String lanName = res.getString("lang_name");
        body.append("LANGUAGE ").append(PgDiffUtils.getQuotedName(lanName));

        // since 9.5 PostgreSQL
        if (SupportedVersion.VERSION_9_5.checkVersion(loader.version)) {
            Long[] protrftypes = getColArray(res, "protrftypes");
            if (protrftypes != null) {
                body.append(" TRANSFORM ");
                for (Long s : protrftypes) {
                    body.append("FOR TYPE ")
                    .append(loader.cachedTypesByOid.get(s).getFullName());
                    body.append(", ");
                }
                body.setLength(body.length() - 2);
            }
        }

        if (res.getBoolean("proiswindow")) {
            body.append(" WINDOW");
        }

        // VOLATILE is default
        switch (res.getString("provolatile")) {
        case "i":
            body.append(" IMMUTABLE");
            break;
        case "s":
            body.append(" STABLE");
            break;
        default :
            break;
        }

        // CALLED ON NULL INPUT is default
        if (res.getBoolean("proisstrict")) {
            body.append(" STRICT");
        }

        // SECURITY INVOKER is default
        if (res.getBoolean("prosecdef")) {
            body.append(" SECURITY DEFINER");
        }

        if (res.getBoolean("proleakproof")) {
            body.append(" LEAKPROOF");
        }

        // since 9.6 PostgreSQL
        // parallel mode: s - safe, r - restricted, u - unsafe
        if (SupportedVersion.VERSION_9_6.checkVersion(loader.version)) {
            String parMode = res.getString("proparallel");
            switch (parMode) {
            case "s":
                body.append(" PARALLEL SAFE");
                break;
            case "r":
                body.append(" PARALLEL RESTRICTED");
                break;
            default :
                break;
            }
        }

        float cost = res.getFloat("procost");
        if ("internal".equals(lanName) || "c".equals(lanName)) {
            /* default cost is 1 */
            if (cost != 1) {
                body.append(" COST ").append((int) cost);
            }
        } else {
            /* default cost is 100 */
            if (cost != DEFAULT_PROCOST) {
                body.append(" COST ").append((int) cost);
            }
        }

        float rows = res.getFloat("prorows");
        if (rows != 0.0f && rows != DEFAULT_PROROWS) {
            body.append(" ROWS ").append((int) rows);
        }

        String[] proconfig = getColArray(res, "proconfig");
        if (proconfig != null) {
            for (String param : proconfig) {
                String[] params = param.split("=");
                String par = params[0];
                String val = params[1];
                if (!"DateStyle".equals(par) && !"search_path".equals(par)) {
                    par = PgDiffUtils.getQuotedName(par);
                    val = PgDiffUtils.quoteString(val);
                }
                body.append("\n    SET ").append(par).append(" TO ")
                .append(val);
            }
        }

        String definition = res.getString("prosrc");
        String quote = getStringLiteralDollarQuote(definition);
        String probin = res.getString("probin");
        if (probin != null && !probin.isEmpty()) {
            body.append("\n    AS ").append(PgDiffUtils.quoteString(probin));
            if (!"-".equals(definition)) {
                body.append(", ");
                if (!definition.contains("\'") && !definition.contains("\\")) {
                    body.append(PgDiffUtils.quoteString(definition));
                } else {
                    body.append(quote).append(definition).append(quote);
                }
            }
        } else {
            if (!"-".equals(definition)) {
                body.append("\n    AS ").append(quote).append(definition).append(quote);
            }
        }
        return body.toString();
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

    @Override
    protected DbObjType getType() {
        return DbObjType.FUNCTION;
    }
}
