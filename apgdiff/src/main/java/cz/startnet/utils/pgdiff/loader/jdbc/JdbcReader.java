package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map.Entry;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgSchema;

public abstract class JdbcReader implements PgCatalogStrings {

    protected final JdbcReaderFactory factory;
    protected final JdbcLoaderBase loader;

    protected JdbcReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        this.factory = factory;
        this.loader = loader;
    }

    public void read() throws SQLException, InterruptedException {
        boolean helperAvailable = (loader.availableHelpersBits & factory.hasHelperMask) != 0;
        try (PreparedStatement st = loader.connection.prepareStatement(
                helperAvailable ? factory.helperQuery : factory.fallbackQuery)) {
            for (Entry<Long, PgSchema> schema : loader.schemas.map.entrySet()) {
                if (helperAvailable) {
                    st.setArray(1, loader.schemas.oids);
                    st.setArray(2, loader.schemas.names);
                } else {
                    loader.setCurrentOperation("set search_path query");
                    loader.statement.executeQuery("SET search_path TO " +
                            PgDiffUtils.getQuotedName(schema.getValue().getName()) + ", pg_catalog;");
                    st.setLong(1, schema.getKey());
                }

                try (ResultSet result = st.executeQuery()) {
                    while (result.next()) {
                        PgDumpLoader.checkCancelled(loader.monitor);
                        processResult(result, helperAvailable ?
                                loader.schemas.map.get(result.getLong("schema_oid")) : schema.getValue());
                    }
                }
                if (helperAvailable) {
                    // all schemas were processed using a single query, no for-loop needed
                    break;
                }
            }
        }
    }

    protected abstract void processResult(ResultSet result, PgSchema schema) throws SQLException;
}
