package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.timestamps.DBTimestamp;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class TimestampsReader implements PgCatalogStrings {
    private final JdbcLoaderBase loader;

    public TimestampsReader(JdbcLoaderBase loader) {
        this.loader = loader;
    }

    public DBTimestamp read() throws SQLException, InterruptedException {
        DBTimestamp time = new DBTimestamp();
        try (ResultSet result = loader.statement.executeQuery(JdbcQueries.QUERY_TIMESTAMPS)) {
            while (result.next()) {
                PgDiffUtils.checkCancelled(loader.monitor);
                fill(result, time);
            }
        }

        return time;
    }

    private void fill(ResultSet res, DBTimestamp time) throws SQLException {
        String type = res.getString("type");
        String identity = res.getString("identity");
        String schema = res.getString("schema");
        String name = res.getString("name");
        Instant lastModified = res.getTimestamp("last_modified").toInstant();

        DbObjType t = DbObjType.DATABASE;
        for (DbObjType v : DbObjType.values()) {
            if (v.toString().equalsIgnoreCase(type)) {
                t = v;
            }
        }
        switch (t) {
        case SCHEMA:
        case EXTENSION:
            time.addObject(null, name, t, null, lastModified);
            break;
        case TYPE:
        case SEQUENCE:
        case FUNCTION:
        case TABLE:
        case VIEW:
            time.addObject(schema, name, t, null, lastModified);
            break;
        case RULE:
        case TRIGGER:
            // have text format like "object_name on schema_name.parent_name".
            // parser?
            String[] objects = identity.split(" ");
            String[] parents = objects[objects.length - 1].split(".");
            time.addObject(parents[0], parents[1], objects[0], t, null, lastModified);
            break;
        default:break;
        }
    }
}