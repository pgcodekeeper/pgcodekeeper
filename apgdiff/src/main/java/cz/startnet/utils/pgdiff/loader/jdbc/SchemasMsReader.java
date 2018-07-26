package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class SchemasMsReader implements PgCatalogStrings {

    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public SchemasMsReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException, WrapperAccessException {
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

    private MsSchema getSchema(ResultSet res) throws SQLException, WrapperAccessException {
        String schemaName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schemaName, DbObjType.SCHEMA));
        MsSchema s = new MsSchema(schemaName, "");
        loader.setOwner(s, res.getString("owner"));

        for (JsonReader acl : JsonReader.fromArray(res.getString("acl"))) {
            boolean isGrant = "GRANT".equals(acl.getString("sd"));
            String permission = res.getString("pn");
            String role = res.getString("r");

            String definition = permission + " ON SCHEMA::" + MsDiffUtils.quoteName(s.getName()) +
                    " TO " + MsDiffUtils.quoteName(role);
            s.addPrivilege(new PgPrivilege(!isGrant, definition));
        }

        return s;
    }
}
