package cz.startnet.utils.pgdiff.loader.jdbc;

import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgView;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ViewsReader extends JdbcReader {

    public static class ViewsReaderFactory extends JdbcReaderFactory {

        public ViewsReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
            super(hasHelperMask, helperFunction, queries);
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
    protected void processResult(ResultSetWrapper result, PgSchema schema) throws WrapperAccessException {
        PgView view = getView(result, schema.getName());
        loader.monitor.worked(1);
        if (view != null) {
            schema.addView(view);
        }
    }

    private PgView getView(ResultSetWrapper res, String schemaName) throws WrapperAccessException {
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

        String viewDef = res.getString("definition").trim();
        int semicolonPos = viewDef.length() - 1;
        v.setQuery(viewDef.charAt(semicolonPos) == ';' ? viewDef.substring(0, semicolonPos) : viewDef);

        loader.submitAntlrTask(viewDef,
                p -> p.sql().statement(0).data_statement().select_stmt(),
                ctx -> {
                    Select sel = new Select(schemaName);
                    sel.analyze(ctx);
                    v.addAllDeps(sel.getDepcies());
                });

        // OWNER
        loader.setOwner(v, res.getLong(CLASS_RELOWNER));

        // Query columns default values and comments
        String[] colNames = res.getArray("column_names", String.class);
        if (colNames != null) {
            String[] colComments = res.getArray("column_comments", String.class);
            String[] colDefaults = res.getArray("column_defaults", String.class);
            String[] colACLs = res.getArray("column_acl", String.class);

            for (int i = 0; i < colNames.length; i++) {
                String colName = colNames[i];
                String colDefault = colDefaults[i];
                if (colDefault != null) {
                    v.addColumnDefaultValue(colName, colDefault);
                    loader.submitAntlrTask(colDefault,
                            p -> p.vex_eof().vex().get(0),
                            ctx -> {
                                ValueExpr vex = new ValueExpr(schemaName);
                                vex.analyze(new Vex(ctx));
                                v.addAllDeps(vex.getDepcies());
                            });
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

        // STORAGE PARAMETRS
        String[] options = res.getArray("reloptions", String.class);
        if (options != null) {
            ParserAbstract.fillOptionParams(options, v::addOption, false, false);
        }

        // COMMENT
        String comment = res.getString("comment");
        if (comment != null && !comment.isEmpty()) {
            v.setComment(loader.args, PgDiffUtils.quoteString(comment));
        }

        return v;
    }
}
