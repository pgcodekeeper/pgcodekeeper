package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map.Entry;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.wrappers.JsonResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.SQLResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

public abstract class JdbcReader implements PgCatalogStrings {

    protected final JdbcReaderFactory factory;
    protected final JdbcLoaderBase loader;

    protected JdbcReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        this.factory = factory;
        this.loader = loader;
    }

    public void read() throws SQLException, InterruptedException, WrapperAccessException {
        boolean helperSuccess = false;
        if ((loader.availableHelpersBits & factory.hasHelperMask) != 0) {
            try {
                readAllUsingHelper();
                helperSuccess = true;
            } catch (SQLException | WrapperAccessException ex) {
                loader.addError(Messages.JdbcReader_helper_function_error);
                Log.log(Log.LOG_WARNING, "Error trying to use server JDBC helper, "
                        + "falling back to old queries: " + factory.helperFunction, ex);
            }
        }
        if (!helperSuccess) {
            readSchemasSeparately();
        }
    }

    private void readAllUsingHelper() throws SQLException, InterruptedException, WrapperAccessException {
        try (PreparedStatement st = loader.connection.prepareStatement(factory.helperQuery)) {
            loader.setCurrentOperation(factory.helperFunction + " query");

            st.setArray(1, loader.schemas.oids);
            st.setArray(2, loader.schemas.names);
            try (ResultSet result = st.executeQuery()) {
                while (result.next()) {
                    ResultSetWrapper wrapper = new JsonResultSetWrapper(result.getString(1));
                    PgDiffUtils.checkCancelled(loader.monitor);
                    processResult(wrapper, loader.schemas.map.get(result.getLong("schema_oid")));
                }
            }
        }
    }

    private void readSchemasSeparately() throws SQLException, InterruptedException, WrapperAccessException {
        try (PreparedStatement st = loader.connection.prepareStatement(factory.makeFallbackQuery(loader.version))) {
            for (Entry<Long, PgSchema> schema : loader.schemas.map.entrySet()) {
                loader.setCurrentOperation("set search_path query");
                loader.statement.execute("SET search_path TO " +
                        PgDiffUtils.getQuotedName(schema.getValue().getName()) + ", pg_catalog;");

                loader.setCurrentOperation(factory.helperFunction + " query for schema " + schema.getValue().getName());
                st.setLong(1, schema.getKey());
                try (ResultSet result = st.executeQuery()) {
                    while (result.next()) {
                        ResultSetWrapper wrapper = new SQLResultSetWrapper(result);
                        PgDiffUtils.checkCancelled(loader.monitor);
                        processResult(wrapper, schema.getValue());
                    }
                }
            }
        }
    }

    protected abstract void processResult(ResultSetWrapper json, PgSchema schema)
            throws SQLException, WrapperAccessException;
}
