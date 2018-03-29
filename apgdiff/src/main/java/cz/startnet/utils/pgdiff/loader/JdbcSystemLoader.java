package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcLoaderBase;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcType;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.TypesSetManually;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.system.CastContext;
import cz.startnet.utils.pgdiff.schema.system.PgSystemCast;
import cz.startnet.utils.pgdiff.schema.system.PgSystemFunction;
import cz.startnet.utils.pgdiff.schema.system.PgSystemFunction.PgSystemArgument;
import cz.startnet.utils.pgdiff.schema.system.PgSystemRelation;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStorage;
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
            throws InterruptedException, SQLException {
        try (ResultSet result = statement.executeQuery(JdbcQueries.QUERY_SYSTEM_FUNCTIONS)) {
            while (result.next()) {
                PgDiffUtils.checkCancelled(monitor);
                String functionName = result.getString(NAME);
                String schemaName = result.getString(NAMESPACE_NAME);

                PgSystemFunction function = new PgSystemFunction(functionName);

                Array arr = result.getArray("proargmodes");
                if (arr != null) {
                    List<String> argModes = Arrays.asList((String[])arr.getArray());
                    if (argModes.contains("t")) {
                        Long[] argTypeOids = (Long[]) result.getArray("proallargtypes").getArray();
                        String[] argNames = (String[]) result.getArray("proargnames").getArray();

                        IntStream.range(0, argModes.size()).filter(i -> "t".equals(argModes.get(i))).forEach(e -> {
                            JdbcType returnType = cachedTypesByOid.get(argTypeOids[e]);
                            function.addReturnsColumns(argNames[e], returnType.getFullName(schemaName));
                        });
                    }
                } else {
                    function.setReturns(result.getString("prorettype"));
                }

                function.setSetof(result.getBoolean("proretset"));

                String arguments = result.getString("proarguments");

                if (!arguments.isEmpty()) {
                    submitAntlrTask('(' + arguments + ')',
                            p -> p.function_args_parser().function_args(),
                            ctx -> {
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
            func.addArgument(getArgument(argument));
        }
        if (ctx.agg_order() != null) {
            for (Function_argumentsContext argument : ctx.agg_order().function_arguments()) {
                func.addOrderBy(getArgument(argument));
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

    private void readRelations(PgSystemStorage storage)
            throws InterruptedException, SQLException {
        try (ResultSet result = statement.executeQuery(JdbcQueries.QUERY_SYSTEM_RELATIONS)) {
            while (result.next()) {
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

                Array arr = result.getArray("col_names");
                if (arr != null) {
                    String[] colNames = (String[]) arr.getArray();
                    String[] colTypes = (String[]) result.getArray("col_types").getArray();
                    for (int i = 0; i < colNames.length; i++) {
                        relation.addColumn(colNames[i], colTypes[i]);
                    }
                }

                storage.getSchema(result.getString(NAMESPACE_NAME)).addRelation(relation);
            }
        }
    }

    private void readOperators(PgSystemStorage storage)
            throws InterruptedException, SQLException {
        try (ResultSet result = statement.executeQuery(JdbcQueries.QUERY_SYSTEM_OPERATORS)) {
            while (result.next()) {
                PgDiffUtils.checkCancelled(monitor);
                String name = result.getString(NAME);
                String schemaName = result.getString(NAMESPACE_NAME);
                long leftType = result.getLong("left");
                long rightType = result.getLong("right");
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
                operator.addArgument(firstArg);
                operator.addArgument(secondArg);
                operator.setReturns(cachedTypesByOid.get(result.getLong("result")).getFullName(schemaName));

                storage.getSchema(schemaName).addFunction(operator);
            }
        }
    }

    private void readCasts(PgSystemStorage storage)
            throws InterruptedException, SQLException {
        try (ResultSet result = statement.executeQuery(JdbcQueries.QUERY_SYSTEM_CASTS)) {
            while (result.next()) {
                PgDiffUtils.checkCancelled(monitor);
                String source = result.getString("source");
                String target = result.getString("target");
                String type = result.getString("castcontext");
                storage.addCast(new PgSystemCast(source, target, CastContext.getEnumByValue(type)));
            }
        }
    }
}