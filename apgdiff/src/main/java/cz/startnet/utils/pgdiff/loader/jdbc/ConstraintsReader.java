package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ConstraintsReader extends JdbcReader {

    public static class ConstraintsReaderFactory extends JdbcReaderFactory {

        public ConstraintsReaderFactory(long hasHelperMask, String helperFunction, String fallbackQuery) {
            super(hasHelperMask, helperFunction, fallbackQuery);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new ConstraintsReader(this, loader);
        }
    }

    private ConstraintsReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSet result, PgSchema schema) throws SQLException {
        PgTable table = schema.getTable(result.getString(CLASS_RELNAME));
        if (table != null) {
            PgConstraint constraint = getConstraint(result, schema.getName(), table.getName());
            if (constraint != null) {
                table.addConstraint(constraint);
            }
        }
    }

    private PgConstraint getConstraint(ResultSet res, String schemaName, String tableName)
            throws SQLException {
        String constraintName = res.getString("conname");
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, constraintName, DbObjType.CONSTRAINT));
        PgConstraint c = new PgConstraint(constraintName, "");

        String contype = res.getString("contype");
        switch (contype) {
        case "f":
            String fschema = res.getString("foreign_schema_name");
            String ftable = res.getString("foreign_table_name");
            GenericColumn ftableRef = new GenericColumn(fschema, ftable, DbObjType.TABLE);
            c.setForeignTable(ftableRef);
            c.addDep(ftableRef);

            String[] referencedColumnNames = (String[]) res.getArray("foreign_cols").getArray();
            for (String colName : referencedColumnNames) {
                if (colName != null) {
                    c.addForeignColumn(colName);
                    c.addDep(new GenericColumn(fschema, ftable, colName, DbObjType.COLUMN));
                }
            }

            break; // end foreign key
        case "p":
        case "u":
            if ("p".equals(contype)) {
                c.setPrimaryKey(true);
            } else {
                c.setUnique(true);
            }

            String[] concols = (String[]) res.getArray("cols").getArray();
            for (String name : concols) {
                c.addColumn(name);
            }
            break;
        }

        c.setDefinition(res.getString("definition"));
        c.setTableName(tableName);

        String comment = res.getString("description");
        if (comment != null && !comment.isEmpty()) {
            c.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        return c;
    }
}
