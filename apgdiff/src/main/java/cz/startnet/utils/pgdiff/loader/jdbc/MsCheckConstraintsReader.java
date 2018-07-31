package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsConstraint;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsCheckConstraintsReader extends JdbcMsReader {

    public static class MsCheckConstraintsReaderFactory extends JdbcReaderFactory {

        public MsCheckConstraintsReaderFactory(Map<SupportedVersion, String> queries) {
            super(0, "", queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new MsCheckConstraintsReader(this, loader);
        }
    }

    public MsCheckConstraintsReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSet res, PgSchema schema) throws SQLException, JsonReaderException {
        loader.monitor.worked(1);
        String name = res.getString("name");
        boolean isSystemNamed = res.getBoolean("is_system_named");
        loader.setCurrentObject(new GenericColumn(schema.getName(), name, DbObjType.CONSTRAINT));

        MsConstraint con = new MsConstraint(isSystemNamed ? "" : name, "");
        // TODO with no check

        StringBuilder sb = new StringBuilder();
        sb.append("CHECK ");

        if (res.getBoolean("is_not_for_replication")) {
            sb.append("NOT FOR REPLICATION ");
        }

        sb.append(" (").append(res.getString("definition")).append(")");

        // TODO disabled

        con.setDefinition(sb.toString());
        schema.getTable(res.getString("table_name")).addConstraint(con);
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.CONSTRAINT;
    }
}
