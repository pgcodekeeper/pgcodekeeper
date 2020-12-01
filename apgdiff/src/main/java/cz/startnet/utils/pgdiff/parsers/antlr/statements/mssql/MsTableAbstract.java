package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_name_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_with_orderContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_includeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_sortContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_whereContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_constraint_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractIndex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class MsTableAbstract extends ParserAbstract {

    public MsTableAbstract(PgDatabase db) {
        super(db);
    }

    protected AbstractConstraint getMsConstraint(Table_constraintContext conCtx,
            String schema, String table) {
        String conName = conCtx.id() == null ? "" : conCtx.id().getText();
        AbstractConstraint con = new MsConstraint(conName);

        Table_constraint_bodyContext body = conCtx.table_constraint_body();
        con.setPrimaryKey(body.PRIMARY() != null);
        con.setUnique(body.UNIQUE() != null);

        if (body.REFERENCES() != null) {
            Qualified_nameContext ref = body.qualified_name();
            List<IdContext> ids = Arrays.asList(ref.schema, ref.name);
            String fschema = getSchemaNameSafe(ids);
            String ftable = ref.name.getText();

            PgObjLocation loc = addObjReference(ids, DbObjType.TABLE, null);

            GenericColumn ftableRef = loc.getObj();
            con.setForeignTable(ftableRef);
            con.addDep(ftableRef);

            Column_name_listContext columns = body.pk;
            if (columns != null) {
                for (IdContext column : columns.id()) {
                    String col = column.getText();
                    con.addForeignColumn(col);
                    con.addDep(new GenericColumn(fschema, ftable, col, DbObjType.COLUMN));
                }
            }
        } else if (body.column_name_list_with_order() != null) {
            for (Column_with_orderContext column : body.column_name_list_with_order()
                    .column_with_order()) {
                String col = column.id().getText();
                con.addColumn(col);
                con.addDep(new GenericColumn(schema, table, col, DbObjType.COLUMN));
            }
        }

        con.setDefinition(getFullCtxText(conCtx.table_constraint_body()));
        return con;
    }

    protected void parseIndex(Index_restContext rest, AbstractIndex ind, String schema, String table) {
        Index_sortContext sort = rest.index_sort();
        for (Column_with_orderContext col : sort.column_name_list_with_order().column_with_order()) {
            IdContext colCtx = col.id();
            ind.addColumn(colCtx.getText());
            ind.addDep(new GenericColumn(schema, table, colCtx.getText(), DbObjType.COLUMN));
        }

        ind.setDefinition(getFullCtxText(sort));

        Index_includeContext include = rest.index_include();
        if (include != null) {
            for (IdContext col : include.column_name_list().id()) {
                ind.addInclude(col.getText());
                ind.addDep(new GenericColumn(schema, table, col.getText(), DbObjType.COLUMN));
            }
        }

        Index_whereContext wherePart = rest.index_where();
        if (wherePart != null){
            ind.setWhere(getFullCtxText(wherePart.where));
        }

        Index_optionsContext options = rest.index_options();
        if (options != null) {
            for (Index_optionContext option : options.index_option()) {
                String key = option.key.getText();
                String value = option.index_option_value().getText();
                ind.addOption(key, value);
            }
        }

        IdContext tablespace = rest.id();
        if (tablespace != null) {
            ind.setTablespace(tablespace.getText());
        }
    }
}
