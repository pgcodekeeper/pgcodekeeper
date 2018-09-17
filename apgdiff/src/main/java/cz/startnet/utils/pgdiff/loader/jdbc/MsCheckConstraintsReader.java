package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsConstraint;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsCheckConstraintsReader extends JdbcReader {

    public MsCheckConstraintsReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_MS_CHECK_CONSTRAINTS, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        loader.monitor.worked(1);
        String name = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), name, DbObjType.CONSTRAINT));

        AbstractConstraint con = new MsConstraint(name, "");

        con.setNotValid(res.getBoolean("with_no_check"));
        con.setDisabled(res.getBoolean("is_disabled"));

        StringBuilder sb = new StringBuilder();
        sb.append("CHECK ");

        if (res.getBoolean("is_not_for_replication")) {
            sb.append("NOT FOR REPLICATION ");
        }

        sb.append(" (").append(res.getString("definition")).append(")");

        con.setDefinition(sb.toString());
        schema.getTable(res.getString("table_name")).addConstraint(con);
    }
}
