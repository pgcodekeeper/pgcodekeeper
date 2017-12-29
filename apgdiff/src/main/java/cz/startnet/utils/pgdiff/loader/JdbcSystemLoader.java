package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Arrays;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcLoaderBase;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcType;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.secondanalyze.TypesSetManually;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.system.PgSystemCast;
import cz.startnet.utils.pgdiff.schema.system.PgSystemFunction;
import cz.startnet.utils.pgdiff.schema.system.PgSystemFunction.PgSystemArgument;
import cz.startnet.utils.pgdiff.schema.system.PgSystemRelation;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStorage;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.SQLResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class JdbcSystemLoader extends JdbcLoaderBase {

    private static final String NAMESPACE_NAME = "nspname";
    private static final String NAME = "name";

    public JdbcSystemLoader(JdbcConnector connector, SubMonitor monitor) {
        super(connector, monitor, null);
    }

    public PgSystemStorage getStorageFromJdbc() throws IOException, InterruptedException {
        PgSystemStorage storage = new PgSystemStorage();

        Log.log(Log.LOG_INFO, "Reading db using JDBC.");
        setCurrentOperation("connection setup");

        try (Connection connection = connector.getConnection();
                Statement statement = connection.createStatement()) {
            this.connection = connection;
            this.statement = statement;
            connection.setAutoCommit(false);
            statement.execute("SET TRANSACTION ISOLATION LEVEL REPEATABLE READ, READ ONLY");
            statement.execute("SET timezone = " + PgDiffUtils.quoteString(connector.getTimezone()));

            queryTypesForCache();

            readTypes(storage);
            readRelations(storage);
            readFunctions(storage);
            readOperators(storage);
            readCasts(storage);

            connection.commit();
            finishAntlr();
            Log.log(Log.LOG_INFO, "Database object has been successfully queried from JDBC");
        } catch (InterruptedException ex) {
            throw ex;
        } catch (Exception e) {
            // connection is closed at this point, trust Postgres to rollback it; we're a read-only xact anyway
            throw new IOException(MessageFormat.format(Messages.Connection_DatabaseJdbcAccessError,
                    e.getLocalizedMessage(), getCurrentLocation()), e);
        }

        return storage;
    }

    private void readFunctions(PgSystemStorage storage)
            throws InterruptedException, SQLException, WrapperAccessException {
        try (ResultSet result = statement.executeQuery(JdbcQueries.QUERY_SYSTEM_FUNCTIONS)) {
            while (result.next()) {
                ResultSetWrapper wrapper = new SQLResultSetWrapper(result);
                PgDiffUtils.checkCancelled(monitor);
                String functionName = wrapper.getString(NAME);
                String schemaName = wrapper.getString(NAMESPACE_NAME);

                PgSystemFunction function = new PgSystemFunction(functionName);

                String[] argModes = wrapper.getArray("proargmodes", String.class);
                if (argModes != null && Arrays.asList(argModes).contains("t")) {
                    Long[] argTypeOids = wrapper.getArray("proallargtypes", Long.class);
                    String[] argNames = wrapper.getArray("proargnames", String.class);
                    for (int i = 0; i < argModes.length; i++) {
                        String type = argModes[i];
                        if ("t".equals(type)) {
                            JdbcType returnType = cachedTypesByOid.get(argTypeOids[i]);
                            function.addColumn(argNames[i], returnType.getFullName(schemaName));
                        }
                    }
                } else {
                    function.setReturns(wrapper.getString("prorettype"));
                }

                function.setSetof(wrapper.getBoolean("proretset"));

                String arguments = wrapper.getString("proarguments");

                if (!arguments.isEmpty()) {
                    submitAntlrTask('(' + arguments + ')', null,
                            p -> p.function_args_parser().function_args(),
                            (ctx, db) -> {
                                fillArguments(ctx, function);
                                storage.getSchema(schemaName).addFunction(function);
                            });
                } else {
                    storage.getSchema(schemaName).addFunction(function);
                }
            }
        }
    }

    private void fillArguments(Function_argsContext ctx, PgSystemFunction func) {
        for (Function_argumentsContext argument : ctx.function_arguments()) {
            func.addArgumentPart(getArgument(argument));
        }
        if (ctx.agg_order() != null) {
            for (Function_argumentsContext argument : ctx.agg_order().function_arguments()) {
                func.addOrderByPart(getArgument(argument));
            }
        }
    }

    private PgSystemArgument getArgument(Function_argumentsContext argument) {
        PgSystemArgument arg = new PgSystemArgument(argument.arg_mode != null ? argument.arg_mode.getText() : null,
                argument.argname != null ? argument.argname.getText() : null,
                        ParserAbstract.getFullCtxText(argument.argtype_data));

        if (argument.function_def_value() != null) {
            arg.setDefaultExpression(ParserAbstract.getFullCtxText(argument.function_def_value().def_value));
        }

        return arg;
    }

    private void readTypes(PgSystemStorage storage)
            throws InterruptedException, SQLException, WrapperAccessException {
        try (ResultSet result = statement.executeQuery(JdbcQueries.QUERY_SYSTEM_TYPES)) {
            while (result.next()) {
                ResultSetWrapper wrapper = new SQLResultSetWrapper(result);
                PgDiffUtils.checkCancelled(monitor);
                DbObjType type;
                String typtype = result.getString("typtype");
                switch (typtype) {
                case "d":
                    type = DbObjType.DOMAIN;
                    break;
                case "b":
                case "e":
                case "r":
                case "c":
                    type = DbObjType.TYPE;
                    break;
                default:
                    continue;
                }

                PgSystemRelation relation = new PgSystemRelation(result.getString(NAME), type);

                if ("c".equals(typtype)) {
                    readColumns(wrapper, relation);
                }

                storage.getSchema(result.getString(NAMESPACE_NAME)).addRelation(relation);
            }
        }
    }

    private void readRelations(PgSystemStorage storage)
            throws InterruptedException, SQLException, WrapperAccessException {
        try (ResultSet result = statement.executeQuery(JdbcQueries.QUERY_SYSTEM_RELATIONS)) {
            while (result.next()) {
                ResultSetWrapper wrapper = new SQLResultSetWrapper(result);
                PgDiffUtils.checkCancelled(monitor);
                String relationName = result.getString(NAME);
                DbObjType type;

                switch (result.getString("relkind")) {
                case "v":
                case "m":
                    type = DbObjType.VIEW;
                    break;
                case "S":
                    type = DbObjType.SEQUENCE;
                    break;
                default:
                    type = DbObjType.TABLE;
                    break;
                }

                PgSystemRelation relation = new PgSystemRelation(relationName, type);
                readColumns(wrapper, relation);
                storage.getSchema(result.getString(NAMESPACE_NAME)).addRelation(relation);
            }
        }
    }

    private void readOperators(PgSystemStorage storage)
            throws InterruptedException, SQLException, WrapperAccessException {
        try (ResultSet result = statement.executeQuery(JdbcQueries.QUERY_SYSTEM_OPERATORS)) {
            while (result.next()) {
                SQLResultSetWrapper wrapper = new SQLResultSetWrapper(result);
                PgDiffUtils.checkCancelled(monitor);
                String name = wrapper.getString(NAME);
                String schemaName = wrapper.getString(NAMESPACE_NAME);
                long leftType = wrapper.getLong("left");
                long rightType = wrapper.getLong("right");
                String left = TypesSetManually.EMPTY;
                String right = TypesSetManually.EMPTY;
                if (leftType > 0) {
                    left = cachedTypesByOid.get(leftType).getFullName(schemaName);
                }
                if (rightType > 0) {
                    right = cachedTypesByOid.get(rightType).getFullName(schemaName);
                }

                PgSystemFunction operator = new PgSystemFunction(name);
                PgSystemFunction.PgSystemArgument firstArg = new PgSystemArgument(null, left);
                PgSystemFunction.PgSystemArgument secondArg = new PgSystemArgument(null, right);
                operator.addArgumentPart(firstArg);
                operator.addArgumentPart(secondArg);

                operator.setReturns(cachedTypesByOid.get(wrapper.getLong("result")).getFullName(schemaName));

                storage.getSchema(schemaName).addFunction(operator);
            }
        }
    }

    private void readCasts(PgSystemStorage storage)
            throws InterruptedException, SQLException, WrapperAccessException {
        try (ResultSet result = statement.executeQuery(JdbcQueries.QUERY_SYSTEM_CASTS)) {
            while (result.next()) {
                SQLResultSetWrapper wrapper = new SQLResultSetWrapper(result);
                PgDiffUtils.checkCancelled(monitor);
                String source = wrapper.getString("source");
                String target = wrapper.getString("target");
                String type = wrapper.getString("castcontext");
                storage.addCast(new PgSystemCast(source, target, type));
            }
        }
    }

    private void readColumns(ResultSetWrapper wrapper, PgSystemRelation relation)
            throws WrapperAccessException {
        String[] colNames = wrapper.getArray("col_names", String.class);
        String[] colTypes = wrapper.getArray("col_types", String.class);

        if (colNames != null) {
            for (int i = 0; i < colNames.length; i++) {
                relation.addColumn(colNames[i], colTypes[i]);
            }
        }
    }
}