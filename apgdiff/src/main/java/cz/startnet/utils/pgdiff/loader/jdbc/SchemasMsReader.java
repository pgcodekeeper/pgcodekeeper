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
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class SchemasMsReader {

    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public SchemasMsReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException, JsonReaderException {
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

    private MsSchema getSchema(ResultSet res) throws SQLException, JsonReaderException {
        String schemaName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schemaName, DbObjType.SCHEMA));
        MsSchema s = new MsSchema(schemaName, "");

        String owner = res.getString("owner");
        if (!schemaName.equalsIgnoreCase(ApgdiffConsts.DBO) || !owner.equalsIgnoreCase(ApgdiffConsts.DBO)) {
            loader.setOwner(s, owner);
        }

        for (JsonReader acl : JsonReader.fromArray(res.getString("acl"))) {
            String state = acl.getString("sd");
            boolean isWithGrantOption = false;
            if ("GRANT_WITH_GRANT_OPTION".equals(state)) {
                state = "GRANT";
                isWithGrantOption = true;
            }

            String permission = acl.getString("pn");
            String role = acl.getString("r");

            s.addPrivilege(new PgPrivilege(state, permission,
                    "SCHEMA::" + MsDiffUtils.quoteName(s.getName()),
                    MsDiffUtils.quoteName(role), isWithGrantOption));
        }

        return s;
    }
}
