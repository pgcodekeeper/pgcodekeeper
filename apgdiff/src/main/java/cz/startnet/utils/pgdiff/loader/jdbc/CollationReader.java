package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgCollation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CollationReader extends JdbcReader {

    public CollationReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_COLLATION, loader);
    }

    @Override
    protected void processResult(ResultSet result, AbstractSchema schema) throws SQLException, XmlReaderException {
        schema.addColletion(getCollation(result, schema));
    }

    private PgCollation getCollation(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        String collName = res.getString("collname");
        PgCollation p = new PgCollation(collName);
        loader.setCurrentObject(new GenericColumn(schemaName, p.getName(), collName, DbObjType.COLLATION));

        p.setLcCollate(res.getString("collcollate"));
        p.setLcCtype(res.getString("collctype"));

        if (SupportedVersion.VERSION_10.isLE(loader.version)) {
            if (res.getString("collprovider") != null && res.getString("collprovider").equals("i")) {
                p.setProvider("icu");
            } else {
                p.setProvider("cibc");
            }
            p.setVersion(res.getString("collversion"));
        }

        if (SupportedVersion.VERSION_12.isLE(loader.version)) {
            p.setDeterministic(res.getBoolean("collisdeterministic"));
        } else {
            p.setDeterministic(true);
        }
        schema.addColletion(p);
        return p;
    }
}
