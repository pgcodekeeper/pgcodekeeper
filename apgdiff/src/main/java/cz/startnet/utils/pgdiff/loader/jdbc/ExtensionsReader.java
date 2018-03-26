package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
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

        List<ObjectTimestamp> objects = loader.getTimestampObjects();
        if (objects != null && !objects.isEmpty()) {
            PgDatabase projDb = loader.getTimestampProjDb();
            StringBuilder sb = new StringBuilder();

            for (ObjectTimestamp obj : objects) {
                if (obj.getType() == DbObjType.EXTENSION) {
                    sb.append(obj.getObjId()).append(',');
                    db.addExtension((PgExtension)obj.getShallowCopy(projDb));
                }
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                query = JdbcReaderFactory.excludeObjects(query, sb.toString());
            }
        }

        try (ResultSet res = loader.runner.runScript(loader.statement, query)) {
            while (res.next()) {
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
