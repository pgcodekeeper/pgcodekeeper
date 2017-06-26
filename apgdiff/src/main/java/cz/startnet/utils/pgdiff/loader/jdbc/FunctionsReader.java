package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class FunctionsReader extends JdbcReader {

    public static class FunctionsReaderFactory extends JdbcReaderFactory {

        public FunctionsReaderFactory(long hasHelperMask, String helperFunction, String fallbackQuery) {
            super(hasHelperMask, helperFunction, fallbackQuery);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new FunctionsReader(this, loader);
        }
    }

    private static final float DEFAULT_PROCOST = 100.0f;
    private static final float DEFAULT_PROROWS = 1000.0f;

    private FunctionsReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSet result, PgSchema schema) throws SQLException {
        PgFunction function = getFunction(result, schema.getName());
        if (function != null) {
            schema.addFunction(function);
        }
    }

    /**
     * Returns function object accordingly to data stored in current res row
     * (except for aggregate functions).
     * Defines function body from Postgres pg_get_functiondef() output.
     */
    private PgFunction getFunction(ResultSet res, String schemaName) throws SQLException {
        String functionName = res.getString("proname");
        loader.setCurrentObject(new GenericColumn(schemaName, functionName, DbObjType.FUNCTION));
        PgFunction f = new PgFunction(functionName, "");

        f.setBody(loader.args, getFunctionBody(res, schemaName));

        // RETURN TYPE
        Array proargmodes = res.getArray("proargmodes");
        boolean returnsTable = false;
        StringBuilder returnedTableArguments = new StringBuilder();
        if (proargmodes != null) {
            String[] argModes = (String[]) proargmodes.getArray();
            if (Arrays.asList(argModes).contains("t")) {
                String[] argNames = (String[]) res.getArray("proargnames").getArray();
                Long[] argTypeOids = (Long[]) res.getArray("proallargtypes").getArray();
                for (int i = 0; i < argModes.length; i++) {
                    String type = argModes[i];
                    if (type.equals("t")) {
                        returnsTable = true;
                        if (returnedTableArguments.length() > 0) {
                            returnedTableArguments.append(", ");
                        }
                        returnedTableArguments.append(argNames[i]).append(" ");

                        JdbcType returnType = loader.cachedTypesByOid.get(argTypeOids[i]);
                        returnedTableArguments.append(returnType.getFullName(schemaName));
                        returnType.addTypeDepcy(f);
                    }
                }
            }
        }

        if (returnsTable) {
            f.setReturns("TABLE(" + returnedTableArguments + ")");
        } else {
            JdbcType returnType = loader.cachedTypesByOid.get(res.getLong("prorettype"));
            String retType = returnType.getFullName(schemaName);
            f.setReturns(res.getBoolean("proretset") ? "SETOF " + retType : retType);
            returnType.addTypeDepcy(f);
        }

        // ARGUMENTS
        // TODO manually assemble function sig instead of parsing?
        // NOTE though, performance is degraded when doing multiple parser calls (to parse defaults)
        // Benchmark               Mode  Cnt       Score      Error  Units
        // StupidTests.parseArgs  thrpt   20  115902.677 ± 1179.340  ops/s
        // StupidTests.parseVex   thrpt   20  165616.367 ± 2195.409  ops/s
        String arguments = res.getString("proarguments");
        if (!arguments.isEmpty()) {
            loader.submitAntlrTask('(' + arguments + ')',
                    p -> p.function_args_parser().function_args(),
                    ctx -> ParserAbstract.fillArguments(ctx, f, schemaName));
        }

        // OWNER
        loader.setOwner(f, res.getLong("proowner"));

        // PRIVILEGES
        String signatureWithoutDefaults = PgDiffUtils.getQuotedName(functionName) + "(" +
                res.getString("proarguments_without_default") + ")";
        loader.setPrivileges(f, signatureWithoutDefaults, res.getString("aclArray"), f.getOwner(), null);

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            f.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }
        return f;
    }

    private String getFunctionBody(ResultSet res, String schemaName) throws SQLException {
        StringBuilder body = new StringBuilder();

        String lanName = res.getString("lang_name");
        body.append("LANGUAGE ").append(PgDiffUtils.getQuotedName(lanName));

        // since 9.5 PostgreSQL
        if (checkColumn(res, "protrftypes")) {
            Array array = res.getArray("protrftypes");
            if (array != null) {
                body.append(" TRANSFORM ");
                Long[] protrftypes = (Long[]) array.getArray();
                for (Long s : protrftypes) {
                    body.append("FOR TYPE ")
                    .append(loader.cachedTypesByOid.get(s).getFullNameWithParent(schemaName));
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
        if (checkColumn(res, "proparallel")) {
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
        if (lanName.equals("internal") || lanName.equals("c")) {
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

        Array configParams = res.getArray("proconfig");
        if (configParams != null) {
            for (String param : (String[]) configParams.getArray()) {
                String[] params = param.split("=");
                String par = params[0];
                String val = params[1];
                if (!par.equals("DateStyle") && !par.equals("search_path")) {
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
            if (!definition.equals("-")) {
                body.append(", ");
                if (!definition.contains("\'") && !definition.contains("\\")) {
                    body.append(PgDiffUtils.quoteString(definition));
                } else {
                    body.append(quote).append(definition).append(quote);
                }
            }
        } else {
            if (!definition.equals("-")) {
                body.append("\n    AS ").append(quote).append(definition).append(quote);
            }
        }
        return body.toString();
    }

    private boolean checkColumn(ResultSet res, String string) throws SQLException {
        ResultSetMetaData rsMetaData = res.getMetaData();
        int numberOfColumns = rsMetaData.getColumnCount();

        // get the column names; column indexes start from 1
        for (int i = 1; i < numberOfColumns + 1; i++) {
            String columnName = rsMetaData.getColumnName(i);
            // Get the name of the column's table name
            if (string.equals(columnName)) {
                return true;
            }
        }
        return false;
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
}
