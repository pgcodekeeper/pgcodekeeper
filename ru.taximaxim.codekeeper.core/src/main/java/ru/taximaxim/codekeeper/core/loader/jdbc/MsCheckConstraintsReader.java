package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.loader.JdbcQueries;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.MsConstraint;

public class MsCheckConstraintsReader extends JdbcReader {

    public MsCheckConstraintsReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_MS_CHECK_CONSTRAINTS, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema) throws SQLException {
        loader.monitor.worked(1);
        String name = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), name, DbObjType.CONSTRAINT));

        AbstractTable table = schema.getTable(res.getString("table_name"));
        if (table == null) {
            return;
        }

        MsConstraint con = new MsConstraint(name);

        con.setNotValid(res.getBoolean("with_no_check"));
        con.setDisabled(res.getBoolean("is_disabled"));

        StringBuilder sb = new StringBuilder();
        sb.append("CHECK ");

        if (res.getBoolean("is_not_for_replication")) {
            sb.append("NOT FOR REPLICATION ");
        }

        sb.append(" (").append(res.getString("definition")).append(")");

        con.setDefinition(sb.toString());
        table.addConstraint(con);
    }
}
