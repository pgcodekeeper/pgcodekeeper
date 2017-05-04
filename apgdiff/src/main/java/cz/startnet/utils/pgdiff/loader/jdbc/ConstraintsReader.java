package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constr_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
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

    static final String ADD_CONSTRAINT = "ALTER TABLE noname ADD CONSTRAINT noname ";

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
                p -> p.sql().statement(0).schema_statement().schema_alter().alter_table_statement()
                .table_action(0), ctx -> {
                    Constr_bodyContext body = ctx.tabl_constraint.constr_body();
                    ParserAbstract.parseConstraintExpr(body, schemaName, c);
                    c.setDefinition(ParserAbstract.getFullCtxText(body));
                    c.setNotValid(ctx.not_valid != null);
                });


        String comment = res.getString("description");
        if (comment != null && !comment.isEmpty()) {
            c.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }
        return c;
    }

    private void createFKeyCon(ResultSet res, PgConstraint c) throws SQLException {
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
    }

    private void createUniqueCon(String contype, ResultSet res, PgConstraint c) throws SQLException {
        if ("p".equals(contype)) {
            c.setPrimaryKey(true);
        } else {
            c.setUnique(true);
        }

        String[] concols = (String[]) res.getArray("cols").getArray();
        for (String name : concols) {
            c.addColumn(name);
        }
    }
}
