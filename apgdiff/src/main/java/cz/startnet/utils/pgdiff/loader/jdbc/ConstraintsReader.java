package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterTable;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ConstraintsReader extends JdbcReader {

    static final String ADD_CONSTRAINT = "ALTER TABLE noname ADD CONSTRAINT noname ";

    public ConstraintsReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_CONSTRAINTS_PER_SCHEMA, loader);
    }

    @Override
    protected void processResult(ResultSet result, AbstractSchema schema) throws SQLException {
        AbstractTable table = schema.getTable(result.getString(CLASS_RELNAME));
        if (table != null) {
            table.addConstraint(getConstraint(result, schema, table.getName()));
        }
    }

    private AbstractConstraint getConstraint(ResultSet res, AbstractSchema schema, String tableName)
            throws SQLException {
        String schemaName = schema.getName();
        String contype = res.getString("contype");

        String constraintName = res.getString("conname");
        loader.setCurrentObject(new GenericColumn(schemaName, tableName, constraintName, DbObjType.CONSTRAINT));
        AbstractConstraint c = new PgConstraint(constraintName, "");

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
        checkObjectValidity(definition, getType(), constraintName);
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

    private void createFKeyCon(ResultSet res, AbstractConstraint c) throws SQLException {
        String fschema = res.getString("foreign_schema_name");
        String ftable = res.getString("foreign_table_name");
        GenericColumn ftableRef = new GenericColumn(fschema, ftable, DbObjType.TABLE);
        c.setForeignTable(ftableRef);
        c.addDep(ftableRef);

        String[] referencedColumnNames = getColArray(res, "foreign_cols");
        for (String colName : referencedColumnNames) {
            if (colName != null) {
                c.addForeignColumn(colName);
                c.addDep(new GenericColumn(fschema, ftable, colName, DbObjType.COLUMN));
            }
        }
    }

    private void createUniqueCon(String contype, ResultSet res, AbstractConstraint c) throws SQLException {
        if ("p".equals(contype)) {
            c.setPrimaryKey(true);
        } else {
            c.setUnique(true);
        }

        String[] concols = getColArray(res, "cols");
        for (String name : concols) {
            c.addColumn(name);
        }
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.CONSTRAINT;
    }
}
