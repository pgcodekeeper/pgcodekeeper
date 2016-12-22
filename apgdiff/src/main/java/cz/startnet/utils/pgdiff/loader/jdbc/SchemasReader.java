package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
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

    public SchemasContainer read() throws SQLException, InterruptedException {
        loader.setCurrentOperation("schemas query");
        Map<Long, PgSchema> schemas = new HashMap<>();
        try (ResultSet result = loader.statement.executeQuery(JdbcQueries.QUERY_SCHEMAS)) {
            while (result.next()) {
                PgDiffUtils.checkCancelled(loader.monitor);
                PgSchema schema = getSchema(result);
                if (ApgdiffConsts.PUBLIC.equals(schema.getName())) {
                    db.replaceSchema(db.getSchema(ApgdiffConsts.PUBLIC), schema);
                } else {
                    db.addSchema(schema);
                }
                schemas.put(result.getLong(OID), schema);
            }
        }
        return new SchemasContainer(schemas, loader.connection);
    }

    private PgSchema getSchema(ResultSet res) throws SQLException {
        String schemaName = res.getString(NAMESPACE_NSPNAME);
        loader.setCurrentObject(new GenericColumn(schemaName, DbObjType.SCHEMA));
        PgSchema s = new PgSchema(schemaName, "");
        long owner = res.getLong("nspowner");

        if (!schemaName.equals(ApgdiffConsts.PUBLIC)) {
            loader.setOwner(s, owner);

            String comment = res.getString("comment");
            if (comment != null && !comment.isEmpty()) {
                s.setComment(loader.args, PgDiffUtils.quoteString(comment));
            }
        }

        loader.setPrivileges(s, PgDiffUtils.getQuotedName(schemaName),
                res.getString("nspacl"), owner);

        return s;
    }
}
