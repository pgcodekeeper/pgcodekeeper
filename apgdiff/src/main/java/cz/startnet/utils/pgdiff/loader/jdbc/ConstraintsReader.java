package cz.startnet.utils.pgdiff.loader.jdbc;

import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterTable;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ConstraintsReader extends JdbcReader {

    public static class ConstraintsReaderFactory extends JdbcReaderFactory {

        public ConstraintsReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
            super(hasHelperMask, helperFunction, queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new ConstraintsReader(this, loader);
        }
    }

    static final String ADD_CONSTRAINT = "ALTER TABLE noname ADD CONSTRAINT noname ";

    private ConstraintsReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSetWrapper result, PgSchema schema) throws WrapperAccessException {
        PgTable table = schema.getTable(result.getString(CLASS_RELNAME));
        if (table != null) {
            table.addConstraint(getConstraint(result, schema, table.getName()));
        }
    }

    private PgConstraint getConstraint(ResultSetWrapper res, PgSchema schema, String tableName)
            throws WrapperAccessException {
        String schemaName = schema.getName();
        String contype = res.getString("contype");

        String constraintName = res.getString("conname");
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, constraintName, DbObjType.CONSTRAINT));
        PgConstraint c = new PgConstraint(constraintName, "");

        switch (contype) {
        case "f":
            createFKeyCon(res, c);
            break; // end foreign key
        case "p":
        case "u":
            createUniqueCon(contype, res, c);
            break;
        default:
            break;
        }

        String definition = res.getString("definition");
        loader.submitAntlrTask(ADD_CONSTRAINT + definition + ';',
                p -> p.sql().statement(0).schema_statement().schema_alter()
                .alter_table_statement().table_action(0),
                ctx -> AlterTable.parseAlterTableConstraint(ctx, c, schema.getDatabase(),
                        schemaName, tableName));

        String comment = res.getString("description");
        if (comment != null && !comment.isEmpty()) {
            c.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }
        return c;
    }

    private void createFKeyCon(ResultSetWrapper res, PgConstraint c) throws WrapperAccessException {
        String fschema = res.getString("foreign_schema_name");
        String ftable = res.getString("foreign_table_name");
        GenericColumn ftableRef = new GenericColumn(fschema, ftable, DbObjType.TABLE);
        c.setForeignTable(ftableRef);
        c.addDep(ftableRef);

        String[] referencedColumnNames = res.getArray("foreign_cols", String.class);
        for (String colName : referencedColumnNames) {
            if (colName != null) {
                c.addForeignColumn(colName);
                c.addDep(new GenericColumn(fschema, ftable, colName, DbObjType.COLUMN));
            }
        }
    }

    private void createUniqueCon(String contype, ResultSetWrapper res, PgConstraint c) throws WrapperAccessException {
        if ("p".equals(contype)) {
            c.setPrimaryKey(true);
        } else {
            c.setUnique(true);
        }

        String[] concols = res.getArray("cols", String.class);
        for (String name : concols) {
            c.addColumn(name);
        }
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.CONSTRAINT;
    }
}
