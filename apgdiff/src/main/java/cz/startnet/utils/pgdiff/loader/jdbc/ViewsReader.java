package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ViewSelect;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ViewsReader extends JdbcReader {

    public ViewsReader(JdbcLoaderBase loader) {
        super(JdbcQueries.QUERY_VIEWS_PER_SCHEMA, loader);
    }

    @Override
    protected void processResult(ResultSet result, AbstractSchema schema) throws SQLException {
        PgView view = getView(result, schema);
        loader.monitor.worked(1);
        schema.addView(view);
    }

    private PgView getView(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        String viewName = res.getString(CLASS_RELNAME);
        loader.setCurrentObject(new GenericColumn(schemaName, viewName, DbObjType.VIEW));

        PgView v = new PgView(viewName, "");

        // materialized view
        if ("m".equals(res.getString("kind"))) {
            v.setIsWithData(res.getBoolean("relispopulated"));
            String tableSpace = res.getString("table_space");
            if (tableSpace != null && !tableSpace.isEmpty()) {
                v.setTablespace(tableSpace);
            }
        }

        String definition = res.getString("definition");
        checkObjectValidity(definition, getType(), viewName);
        String viewDef = definition.trim();
        int semicolonPos = viewDef.length() - 1;
        v.setQuery(viewDef.charAt(semicolonPos) == ';' ? viewDef.substring(0, semicolonPos) : viewDef);

        PgDatabase dataBase = schema.getDatabase();

        loader.submitAntlrTask(viewDef, p -> p.sql().statement(0).data_statement()
                .select_stmt(),
                ctx -> {
                    dataBase.addContextForAnalyze(v, ctx);

                    // collect basic FROM dependencies between VIEW objects themselves
                    // to ensure correct order during the main analysis phase
                    ViewSelect select = new ViewSelect(schemaName);
                    select.analyze(new SelectStmt(ctx));
                    v.addAllDeps(select.getDepcies());
                });

        // OWNER
        loader.setOwner(v, res.getLong(CLASS_RELOWNER));

        // Query columns default values and comments
        String[] colNames = getColArray(res, "column_names");
        if (colNames != null) {
            String[] colComments = getColArray(res, "column_comments");
            String[] colDefaults = getColArray(res, "column_defaults");
            String[] colACLs = getColArray(res, "column_acl");

            for (int i = 0; i < colNames.length; i++) {
                String colName = colNames[i];
                String colDefault = colDefaults[i];
                if (colDefault != null) {
                    v.addColumnDefaultValue(colName, colDefault);
                    loader.submitAntlrTask(colDefault, p -> p.vex_eof().vex().get(0),
                            ctx -> dataBase.addContextForAnalyze(v, ctx));
                }
                String colComment = colComments[i];
                if (colComment != null) {
                    v.addColumnComment(loader.args, colName, PgDiffUtils.quoteString(colComment));
                }
                String colAcl = colACLs[i];
                // Привилегии на столбцы view записываются в саму view
                if (colAcl != null) {
                    loader.setPrivileges(v, colAcl, colName, schemaName);
                }
            }
        }

        // Query view privileges
        loader.setPrivileges(v, res.getString("relacl"), schemaName);

        // STORAGE PARAMETRS
        String[] options = getColArray(res, "reloptions");
        if (options != null) {
            ParserAbstract.fillOptionParams(options, v::addOption, false, false, false);
        }

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            v.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        return v;
    }

    @Override
    protected DbObjType getType() {
        return DbObjType.VIEW;
    }
}
