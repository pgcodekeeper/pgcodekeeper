package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilExpr;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ViewsReader extends JdbcReader {

    public static class ViewsReaderFactory extends JdbcReaderFactory {

        public ViewsReaderFactory(long hasHelperMask, String helperFunction, String fallbackQuery) {
            super(hasHelperMask, helperFunction, fallbackQuery);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new ViewsReader(this, loader);
        }
    }

    private ViewsReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSet result, PgSchema schema) throws SQLException {
        PgView view = getView(result, schema.getName());
        loader.monitor.worked(1);
        if (view != null) {
            schema.addView(view);
        }
    }

    private PgView getView(ResultSet res, String schemaName) throws SQLException {
        String viewName = res.getString(CLASS_RELNAME);
        loader.setCurrentObject(new GenericColumn(schemaName, viewName, DbObjType.VIEW));

        String viewDef = res.getString("definition").trim();
        if (viewDef.charAt(viewDef.length() - 1) == ';') {
            viewDef = viewDef.substring(0, viewDef.length() - 1);
        }

        PgView v = new PgView(viewName, "");
        v.setQuery(viewDef);
        parseAntlrSelect(schemaName, viewDef, v);

        // OWNER
        loader.setOwner(v, res.getLong(CLASS_RELOWNER));

        // Query columns default values and comments
        Array colNamesArr = res.getArray("column_names");
        if (colNamesArr != null) {
            String[] colNames = (String[]) colNamesArr.getArray();
            String[] colComments = (String[]) res.getArray("column_comments").getArray();
            String[] colDefaults = (String[]) res.getArray("column_defaults").getArray();
            String[] colACLs = (String[]) res.getArray("column_acl").getArray();

            for (int i = 0; i < colNames.length; i++) {
                String colName = colNames[i];
                String colDefault = colDefaults[i];
                if (colDefault != null) {
                    v.addColumnDefaultValue(colName, colDefault);
                }
                String colComment = colComments[i];
                if (colComment != null) {
                    v.addColumnComment(loader.args, colName, PgDiffUtils.quoteString(colComment));
                }
                String colAcl = colACLs[i];
                // Привилегии на столбцы view записываются в саму view
                if (colAcl != null) {
                    loader.setPrivileges(v, PgDiffUtils.getQuotedName(viewName), colAcl, v.getOwner(), PgDiffUtils.getQuotedName(colName));
                }
            }
        }

        // Query view privileges
        loader.setPrivileges(v, PgDiffUtils.getQuotedName(viewName), res.getString("relacl"), v.getOwner(), null);

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            v.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        return v;
    }

    private void parseAntlrSelect(String schemaName, String statement, PgView v) {
        SQLParser parser = AntlrParser.makeBasicParser(SQLParser.class, statement + ';', loader.getCurrentLocation());
        UtilExpr.analyze(parser.sql().statement(0).data_statement().select_stmt(), new Select(schemaName), v);
    }
}
