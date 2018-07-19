package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;

public abstract class JdbcMsReader extends JdbcReader {

    public JdbcMsReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    // TODO use super implementation after PG queries become schema-independent
    @Override
    public void read() throws SQLException, InterruptedException {
        try (ResultSet r = loader.runner.runScript(loader.statement, factory.getBaseQuery())) {
            while (r.next()) {
                processResult(r, loader.schemaIds.get(r.getLong("schema_id")));
            }
        }
    }

    protected abstract void processResult(ResultSet result, PgSchema schema)
            throws SQLException;

    @Override
    protected void processResult(ResultSetWrapper json, PgSchema schema)
            throws SQLException, WrapperAccessException {
        // no impl
        // TODO remove after ResultSetWrapper removal
    }
}
