package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class SchemasMsReader {

    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public SchemasMsReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException, XmlReaderException {
        loader.setCurrentOperation("schemas query");

        String query = JdbcQueries.QUERY_MS_SCHEMAS.getQuery();
        try (ResultSet result = loader.runner.runScript(loader.statement, query)) {
            while (result.next()) {
                AbstractSchema schema = getSchema(result);
                db.addSchema(schema);
                loader.schemaIds.put(result.getLong("schema_id"), schema);
            }
        }
    }

    private AbstractSchema getSchema(ResultSet res) throws SQLException, XmlReaderException {
        String schemaName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schemaName, DbObjType.SCHEMA));
        AbstractSchema s = new MsSchema(schemaName, "");

        String owner = res.getString("owner");
        if (!schemaName.equalsIgnoreCase(ApgdiffConsts.DBO) || !owner.equalsIgnoreCase(ApgdiffConsts.DBO)) {
            loader.setOwner(s, owner);
        }

        loader.setPrivileges(s, XmlReader.readXML(res.getString("acl")));
        return s;
    }
}
