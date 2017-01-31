package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map.Entry;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.Log;

public abstract class JdbcReader implements PgCatalogStrings {

    protected final JdbcReaderFactory factory;
    protected final JdbcLoaderBase loader;

    protected JdbcReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        this.factory = factory;
        this.loader = loader;
    }

    public void read() throws SQLException, InterruptedException {
        boolean helperSuccess = false;
        if ((loader.availableHelpersBits & factory.hasHelperMask) != 0) {
            try {
                readAllUsingHelper();
                helperSuccess = true;
            } catch (SQLException ex) {
                Log.log(Log.LOG_WARNING, "Error trying to use server JDBC helper, "
                        + "falling back to old queries: " + factory.helperFunction, ex);
            }
        }
        if (!helperSuccess) {
            readSchemasSeparately();
        }
    }

    private void readAllUsingHelper() throws SQLException, InterruptedException {
        try (PreparedStatement st = loader.connection.prepareStatement(factory.helperQuery)) {
            loader.setCurrentOperation(factory.helperFunction + " query");

            st.setArray(1, loader.schemas.oids);
            st.setArray(2, loader.schemas.names);
            try (ResultSet result = st.executeQuery()) {
                while (result.next()) {
                    PgDiffUtils.checkCancelled(loader.monitor);
                    processResult(result, loader.schemas.map.get(result.getLong("schema_oid")));
                }
            }
        }
    }

    private void readSchemasSeparately() throws SQLException, InterruptedException {
        try (PreparedStatement st = loader.connection.prepareStatement(factory.fallbackQuery)) {
            for (Entry<Long, PgSchema> schema : loader.schemas.map.entrySet()) {
                loader.setCurrentOperation("set search_path query");
                loader.statement.execute("SET search_path TO " +
                        PgDiffUtils.getQuotedName(schema.getValue().getName()) + ", pg_catalog;");

                loader.setCurrentOperation(factory.helperFunction + " query for schema " + schema.getValue().getName());
                st.setLong(1, schema.getKey());
                try (ResultSet result = st.executeQuery()) {
                    while (result.next()) {
                        PgDiffUtils.checkCancelled(loader.monitor);
                        processResult(result, schema.getValue());
                    }
                }
            }
        }
    }

    protected abstract void processResult(ResultSet result, PgSchema schema) throws SQLException;
}
