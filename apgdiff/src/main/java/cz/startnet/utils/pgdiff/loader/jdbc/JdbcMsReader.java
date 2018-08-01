package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.PgSchema;

public abstract class JdbcMsReader extends JdbcReader {

    public JdbcMsReader(Map<SupportedVersion, String> queries, JdbcLoaderBase loader) {
        super(queries, loader);
    }

    // TODO use super implementation after PG queries become schema-independent
    @Override
    public void read() throws SQLException, InterruptedException, JsonReaderException {
        try (ResultSet r = loader.runner.runScript(loader.statement, makeQuery(loader.version))) {
            while (r.next()) {
                processResult(r, loader.schemaIds.get(r.getLong("schema_oid")));
            }
        }
    }

    @Override
    protected abstract void processResult(ResultSet result, PgSchema schema)
            throws SQLException, JsonReaderException;
}
