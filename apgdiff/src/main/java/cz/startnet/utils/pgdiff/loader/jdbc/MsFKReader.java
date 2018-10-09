package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsConstraint;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsFKReader extends JdbcReader {

    public MsFKReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_MS_FK, loader);
    }

    @Override
    protected void processResult(ResultSet res, AbstractSchema schema)
            throws SQLException, XmlReaderException {
        loader.monitor.worked(1);
        String name = res.getString("name");
        loader.setCurrentObject(new GenericColumn(schema.getName(), name, DbObjType.CONSTRAINT));

        AbstractConstraint con = new MsConstraint(name, "");

        con.setNotValid(res.getBoolean("with_no_check"));
        con.setDisabled(res.getBoolean("is_disabled"));

        StringBuilder sb = new StringBuilder();

        String fschema = res.getString("referenced_schema_name");
        String ftable = res.getString("referenced_table_name");

        /*
        GenericColumn ftableRef = new GenericColumn(fschema, ftable, DbObjType.TABLE);
        con.setForeignTable(ftableRef);
        con.addDep(ftableRef);
         */

        List<String> fields = new ArrayList<>();
        List<String> references = new ArrayList<>();

        for (XmlReader col : XmlReader.readXML(res.getString("cols"))) {
            String field = col.getString("f");
            String reference = col.getString("r");

            /*
            con.addForeignColumn(reference);
            con.addDep(new GenericColumn(fschema, ftable, reference, DbObjType.COLUMN));
             */

            fields.add(MsDiffUtils.quoteName(field));
            references.add(MsDiffUtils.quoteName(reference));
        }

        sb.append("FOREIGN KEY (");
        sb.append(String.join(", ", fields));
        sb.append(") REFERENCES ");
        sb.append(MsDiffUtils.quoteName(fschema));
        sb.append('.');
        sb.append(MsDiffUtils.quoteName(ftable));
        sb.append(" (");
        sb.append(String.join(", ", references));
        sb.append(")");

        int del = res.getInt("delete_referential_action");
        if (del > 0) {
            sb.append(" ON DELETE ");
            if (del == 1) {
                sb.append("CASCADE");
            } else {
                sb.append("SET ").append(del == 2 ? "NULL" : "DEFAULT");
            }
        }

        int upd = res.getInt("update_referential_action");
        if (upd > 0) {
            sb.append(" ON UPDATE ");
            if (upd == 1) {
                sb.append("CASCADE");
            } else {
                sb.append("SET ").append(upd == 2 ? "NULL" : "DEFAULT");
            }
        }

        if (res.getBoolean("is_not_for_replication")) {
            sb.append(" NOT FOR REPLICATION");
        }

        con.setDefinition(sb.toString());

        schema.getTable(res.getString("table_name")).addConstraint(con);
    }
}
