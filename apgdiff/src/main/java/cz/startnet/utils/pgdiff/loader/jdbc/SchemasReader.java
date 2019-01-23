package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.timestamps.ObjectTimestamp;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class SchemasReader implements PgCatalogStrings {

    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public SchemasReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException {
        loader.setCurrentOperation("schemas query");

        String query = JdbcQueries.QUERY_SCHEMAS.getQuery();

        if (loader.hasTimestampObjects()) {
            Collection<ObjectTimestamp> objects = loader.getTimestampOldObjects();
            PgDatabase snapshot = loader.getTimestampSnapshot();
            for (ObjectTimestamp obj : objects) {
                if (obj.getType() == DbObjType.SCHEMA) {
                    long oid = obj.getObjId();
                    AbstractSchema schema = (AbstractSchema) obj.copyStatement(snapshot, loader);
                    db.addSchema(schema);
                    loader.schemaIds.put(oid, schema);
                }
            }

            objects.removeIf(obj -> obj.getType() == DbObjType.SCHEMA);

            query = JdbcReader.excludeObjects(query,
                    loader.getExtensionSchema(), loader.getTimestampLastDate());
        }

        try (ResultSet result = loader.runner.runScript(loader.statement, query)) {
            while (result.next()) {
                AbstractSchema schema = getSchema(result);
                db.addSchema(schema);
                loader.schemaIds.put(result.getLong(OID), schema);
            }
        }
    }

    private AbstractSchema getSchema(ResultSet res) throws SQLException {
        String schemaName = res.getString(NAMESPACE_NSPNAME);
        loader.setCurrentObject(new GenericColumn(schemaName, DbObjType.SCHEMA));
        AbstractSchema s = new PgSchema(schemaName);
        long owner = res.getLong("nspowner");

        if (!schemaName.equals(ApgdiffConsts.PUBLIC)) {
            loader.setOwner(s, owner);

            String comment = res.getString("comment");
            if (comment != null && !comment.isEmpty()) {
                s.setComment(loader.args, PgDiffUtils.quoteString(comment));
            }
        } else if (!"postgres".equals(loader.getRoleByOid(owner))) {
            loader.setOwner(s, owner);
        }

        loader.setPrivileges(s, res.getString("nspacl"), null);

        return s;
    }
}
