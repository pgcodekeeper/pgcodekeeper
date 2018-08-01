package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsSequence;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsSequencesReader extends JdbcMsReader {

    public MsSequencesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_MS_SEQUENCES, loader);
    }

    @Override
    protected void processResult(ResultSet res, PgSchema schema) throws SQLException, JsonReaderException {
        loader.monitor.worked(1);
        String sequenceName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), sequenceName, DbObjType.SEQUENCE));
        MsSequence s = new MsSequence(sequenceName, "");

        s.setStartWith(Long.toString(res.getLong("start_value")));
        s.setMinMaxInc(res.getLong("increment"), res.getLong("maximum_value"),
                res.getLong("minimum_value"), res.getString("data_type"));
        s.setCached(res.getBoolean("is_cached"));

        // getInt convert null to 0
        Object cashe = res.getObject("cache_size");
        if (cashe != null) {
            s.setCache(cashe.toString());
        }

        s.setCycle(res.getBoolean("is_cycling"));

        loader.setOwner(s, res.getString("owner"));

        schema.addSequence(s);
        loader.setPrivileges(s, JsonReader.fromArray(res.getString("acl")));
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.SEQUENCE;
    }
}