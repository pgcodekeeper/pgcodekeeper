package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgCollation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CollationsReader extends JdbcReader {

    public CollationsReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_COLLATIONS, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        String collName = res.getString("collname");
        loader.setCurrentObject(new GenericColumn(schemaName, collName, DbObjType.COLLATION));

        PgCollation coll = new PgCollation(collName);

        String lcCollate = res.getString("collcollate");
        if (lcCollate != null) {
            coll.setLcCollate(PgDiffUtils.quoteString(lcCollate));
        }
        String lcCtype = res.getString("collctype");
        if (lcCtype != null) {
            coll.setLcCtype(PgDiffUtils.quoteString(lcCtype));
        }

        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            coll.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        if (SupportedVersion.VERSION_10.isLE(loader.version)) {
            String provider = res.getString("collprovider");
            switch (provider) {
            case "c": coll.setProvider("libc"); break;
            case "i": coll.setProvider("icu"); break;
            case "d": coll.setProvider("default"); break;
            }
        }

        if (SupportedVersion.VERSION_12.isLE(loader.version)) {
            coll.setDeterministic(res.getBoolean("collisdeterministic"));
        } else {
            coll.setDeterministic(true);
        }

        loader.setOwner(coll, res.getLong("collowner"));
        loader.setAuthor(coll, res);

        schema.addCollation(coll);
    }

    @Override
    protected String getClassId() {
        return "pg_collation";
    }
}
