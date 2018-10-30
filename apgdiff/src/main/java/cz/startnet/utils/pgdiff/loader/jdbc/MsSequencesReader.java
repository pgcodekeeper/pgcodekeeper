package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractSequence;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsSequence;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsSequencesReader extends JdbcReader {

    public MsSequencesReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_MS_SEQUENCES, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException, XmlReaderException {
        loader.monitor.worked(1);
        String sequenceName = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), sequenceName, DbObjType.SEQUENCE));
        AbstractSequence s = new MsSequence(sequenceName, "");

        String dataType = res.getString("data_type");
        s.setDataType(dataType);

        s.setStartWith(Long.toString(res.getLong("start_value")));
        long precision = res.getLong("precision");
        s.setMinMaxInc(res.getLong("increment"), res.getLong("maximum_value"),
                res.getLong("minimum_value"), dataType, precision);
        s.setCached(res.getBoolean("is_cached"));

        if ("numeric".equals(dataType) || "decimal".equals(dataType)) {
            s.setPresicion(Long.toString(precision));
        }

        // getInt convert null to 0
        Object cashe = res.getObject("cache_size");
        if (cashe != null) {
            s.setCache(cashe.toString());
        }

        s.setCycle(res.getBoolean("is_cycling"));

        loader.setOwner(s, res.getString("owner"));

        schema.addSequence(s);
        loader.setPrivileges(s, XmlReader.readXML(res.getString("acl")));
    }
}