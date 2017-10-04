package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.JdbcTimestampLoader;
import cz.startnet.utils.pgdiff.loader.timestamps.ObjectTimestamp;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ExtensionsReader implements PgCatalogStrings {

    private final JdbcLoaderBase loader;
    private final PgDatabase db;

    public ExtensionsReader(JdbcLoaderBase loader, PgDatabase db) {
        this.loader = loader;
        this.db = db;
    }

    public void read() throws SQLException, InterruptedException {
        loader.setCurrentOperation("extensions query");
        String query = JdbcQueries.QUERY_EXTENSIONS.get(null);
        if (loader instanceof JdbcTimestampLoader) {
            List<ObjectTimestamp> objects = ((JdbcTimestampLoader)loader).getObjects();
            if (objects != null) {
                PgDatabase projDb = ((JdbcTimestampLoader)loader).getProjDb();
                List<Long> oids = new ArrayList<>();
                for (ObjectTimestamp obj : objects) {
                    if (obj.getType() == DbObjType.EXTENSION) {
                        oids.add(obj.getObjId());
                        db.addExtension((PgExtension)obj.getShallowCopy(projDb));
                    }
                }
                if (!oids.isEmpty()) {
                    query = JdbcReaderFactory.excludeObjects(query, oids);
                }
            }
        }

        try (ResultSet res = loader.statement.executeQuery(query)) {
            while (res.next()) {
                PgDiffUtils.checkCancelled(loader.monitor);
                PgExtension extension = getExtension(res);
                db.addExtension(extension);
            }
        }
    }

    private PgExtension getExtension(ResultSet res) throws SQLException {
        String extName = res.getString("extname");
        loader.setCurrentObject(new GenericColumn(extName, DbObjType.EXTENSION));
        PgExtension e = new PgExtension(extName, "");
        e.setSchema(res.getString("namespace"));
        e.addDep(new GenericColumn(e.getSchema(), DbObjType.SCHEMA));

        String comment = res.getString("description");
        if (comment != null && !comment.isEmpty()) {
            e.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }
        return e;
    }
}
