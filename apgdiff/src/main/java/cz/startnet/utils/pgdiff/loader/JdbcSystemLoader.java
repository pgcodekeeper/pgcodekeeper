package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Arrays;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcLoaderBase;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcType;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgFunction.Argument;
import cz.startnet.utils.pgdiff.schema.system.PgSystemFunction;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStatement;
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

    public JdbcSystemLoader(JdbcConnector connector, SubMonitor monitor,
            PgDiffArguments args) {
        super(connector, monitor, args);
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

            readSchemas(storage);
            readTypes(storage);
            readRelations(storage);
            readFunctions(storage);
            readSubElements(storage, JdbcQueries.QUERY_SYSTEM_CONSTRAINTS, DbObjType.CONSTRAINT);
            readSubElements(storage, JdbcQueries.QUERY_SYSTEM_INDICES, DbObjType.INDEX);
            readSubElements(storage, JdbcQueries.QUERY_SYSTEM_TRIGGERS, DbObjType.TRIGGER);
            readSubElements(storage, JdbcQueries.QUERY_SYSTEM_RULES, DbObjType.RULE);

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

                PgSystemFunction function = new PgSystemFunction(schemaName, functionName);

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
                        function.setReturnType("table");
                    }
                } else {
                    function.setReturnType(wrapper.getString("prorettype"));
                }

                function.setSetof(wrapper.getBoolean("proretset"));

                String arguments = wrapper.getString("proarguments");

                if (!arguments.isEmpty()) {
                    submitAntlrTask('(' + arguments + ')',
                            p -> p.function_args_parser().function_args(),
                            ctx -> fillArguments(ctx, function));
                }

                storage.addObject(function);
            }
        }
    }

    private void fillArguments(Function_argsContext ctx, PgSystemFunction func) {
        for (Function_argumentsContext argument : ctx.function_arguments()) {
            func.addSignaturePart(getArgument(argument));
        }
        if (ctx.agg_order() != null) {
            for (Function_argumentsContext argument : ctx.agg_order().function_arguments()) {
                func.addOrderByPart(getArgument(argument));
            }
        }
    }

    private Argument getArgument(Function_argumentsContext argument) {
        PgFunction.Argument arg = new PgFunction.Argument();
        if (argument.argname != null) {
            arg.setName(argument.argname.getText());
        }
        arg.setDataType(ParserAbstract.getFullCtxText(argument.argtype_data));

        if (argument.function_def_value() != null) {
            arg.setDefaultExpression(ParserAbstract.getFullCtxText(argument.function_def_value().def_value));
        }
        if (argument.arg_mode != null) {
            arg.setMode(argument.arg_mode.getText());
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

                String typeName = result.getString(NAME);
                String schemaName = result.getString(NAMESPACE_NAME);

                PgSystemStatement relation = new PgSystemStatement(schemaName, typeName, type);

                if ("c".equals(typtype)) {
                    readColumns(wrapper, relation);
                }

                storage.addObject(relation);
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
                String schemaName = result.getString(NAMESPACE_NAME);
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

                PgSystemStatement relation = new PgSystemStatement(schemaName, relationName, type);
                readColumns(wrapper, relation);
                storage.addObject(relation);
            }
        }
    }

    private void readSchemas(PgSystemStorage storage)
            throws InterruptedException, SQLException, WrapperAccessException {
        try (ResultSet result = statement.executeQuery(JdbcQueries.QUERY_SYSTEM_SCHEMAS)) {
            while (result.next()) {
                PgDiffUtils.checkCancelled(monitor);
                String schemaName = new SQLResultSetWrapper(result).getString(NAMESPACE_NAME);
                storage.addObject(new PgSystemStatement(schemaName));
            }
        }
    }

    private void readSubElements(PgSystemStorage storage, String query, DbObjType type)
            throws InterruptedException, SQLException, WrapperAccessException {
        try (ResultSet result = statement.executeQuery(query)) {
            while (result.next()) {
                ResultSetWrapper wrapper = new SQLResultSetWrapper(result);
                PgDiffUtils.checkCancelled(monitor);
                String objectName = wrapper.getString(NAME);
                String schemaName = wrapper.getString(NAMESPACE_NAME);
                storage.addObject(new PgSystemStatement(schemaName, objectName, type));
            }
        }
    }

    private void readColumns(ResultSetWrapper wrapper, PgSystemStatement relation)
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