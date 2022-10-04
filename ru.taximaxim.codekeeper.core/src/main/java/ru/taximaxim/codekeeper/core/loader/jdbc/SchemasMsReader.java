package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.MsSchema;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

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
                PgDiffUtils.checkCancelled(loader.monitor);
                AbstractSchema schema = getSchema(result);
                if (loader.ignorelistSchema == null || loader.ignorelistSchema.getNameStatus(schema.getName())) {
                    db.addSchema(schema);
                    loader.schemaIds.put(result.getLong("schema_id"), schema);
                }
            }
        }
    }

    private AbstractSchema getSchema(ResultSet res) throws SQLException, XmlReaderException {
        String schemaName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schemaName, DbObjType.SCHEMA));
        AbstractSchema s = new MsSchema(schemaName);

        String owner = res.getString("owner");
        if (!schemaName.equalsIgnoreCase(Consts.DBO) || !owner.equalsIgnoreCase(Consts.DBO)) {
            loader.setOwner(s, owner);
        }

        loader.setPrivileges(s, XmlReader.readXML(res.getString("acl")));
        return s;
    }
}
