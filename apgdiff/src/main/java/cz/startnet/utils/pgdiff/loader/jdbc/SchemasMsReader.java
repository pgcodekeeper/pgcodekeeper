package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class SchemasMsReader implements PgCatalogStrings {

    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public SchemasMsReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException {
        loader.setCurrentOperation("schemas query");

        String query = JdbcQueries.QUERY_MS_SCHEMAS.get(null);
        try (ResultSet result = loader.runner.runScript(loader.statement, query)) {
            while (result.next()) {
                PgSchema schema = getSchema(result);
                db.addSchema(schema);
                loader.schemaIds.put(result.getLong("schema_id"), schema);
            }
        }
    }

    private MsSchema getSchema(ResultSet res) throws SQLException {
        String schemaName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schemaName, DbObjType.SCHEMA));
        MsSchema s = new MsSchema(schemaName, "");
        String owner = res.getString("owner");

        if (!loader.args.isIgnorePrivileges()) {
            s.setOwner(owner == null ? ApgdiffConsts.SCHEMA_OWNER : owner);
        }

        // TODO schemas privileges
        return s;
    }
}
