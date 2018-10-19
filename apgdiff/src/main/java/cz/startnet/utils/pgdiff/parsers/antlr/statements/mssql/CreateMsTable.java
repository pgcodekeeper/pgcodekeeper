package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.List;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_constraint_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_def_table_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Identity_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.TableAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.AbstractRegularTable;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsColumn;
import cz.startnet.utils.pgdiff.schema.MsConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.SimpleMsTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateMsTable extends TableAbstract {

    private final Create_tableContext ctx;

    private final boolean ansiNulls;

    public CreateMsTable(Create_tableContext ctx, PgDatabase db, boolean ansiNulls) {
        super(db);
        this.ctx = ctx;
        this.ansiNulls = ansiNulls;
    }

    @Override
    public PgStatement getObject() {
        IdContext schemaCtx = ctx.qualified_name().schema;
        AbstractSchema schema = schemaCtx == null ? db.getDefaultSchema() : getSafe(db::getSchema, schemaCtx);
        String tableName = ctx.qualified_name().name.getText();

        SimpleMsTable table = new SimpleMsTable(tableName, getFullCtxText(ctx.getParent()));

        table.setAnsiNulls(ansiNulls);

        if (ctx.tablespace != null) {
            String tableSpace = MsDiffUtils.quoteName(ctx.tablespace.getText());
            if (ctx.partition_col_name != null) {
                tableSpace = tableSpace + '(' +
                        MsDiffUtils.quoteName(ctx.partition_col_name.getText()) + ')';
            }
            table.setTablespace(tableSpace);
        }

        if (ctx.textimage != null) {
            table.setTextImage(ctx.textimage.getText());
        }

        if (ctx.filestream != null) {
            table.setFileStream(ctx.filestream.getText());
        }

        for (Table_optionsContext options : ctx.table_options()) {
            parseOptions(options.index_option(), table);
        }

        for (Column_def_table_constraintContext colCtx : ctx.column_def_table_constraints().column_def_table_constraint()) {
            fillColumn(colCtx, table);
        }

        schema.addTable(table);
        return table;
    }

    private void fillColumn(Column_def_table_constraintContext colCtx,
            AbstractTable table) {
        if (colCtx.table_constraint() != null) {
            AbstractConstraint con = getMsConstraint(colCtx.table_constraint());
            table.addConstraint(con);
        } else {
            AbstractColumn col = new MsColumn(colCtx.id().getText());

            if (colCtx.data_type() != null) {
                col.setType(getFullCtxText(colCtx.data_type()));
            } else {
                col.setExpression(getFullCtxText(colCtx.expression()));
            }

            for (Column_optionContext option : colCtx.column_option()) {
                fillColumnOption(option, col, table);
            }

            table.addColumn(col);
        }
    }

    private void fillColumnOption(Column_optionContext option,
            AbstractColumn col, AbstractTable table) {
        if (option.SPARSE() != null) {
            col.setSparse(true);
        } else if (option.COLLATE() != null) {
            col.setCollation(getFullCtxText(option.collate));
        } else if (option.PERSISTED() != null) {
            col.setPersisted(true);
        } else if (option.ROWGUIDCOL() != null) {
            col.setRowGuidCol(true);
        } else if (option.IDENTITY() != null) {
            Identity_valueContext identity = option.identity_value();
            if (identity == null) {
                col.setIdentity("1", "1");
            } else {
                col.setIdentity(identity.seed.getText(), identity.increment.getText());
            }

            if (option.not_for_rep != null) {
                col.setNotForRep(true);
            }
        } else if (option.NULL() != null) {
            col.setNullValue(option.NOT() == null);
        } else if (option.DEFAULT() != null) {
            if (option.id() != null) {
                col.setDefaultName(option.id().getText());
            }
            col.setDefaultValue(getFullCtxText(option.expression()));
        } else if (option.column_constraint_body() != null) {
            fillColumnConstraint(option, col, table);
        }
    }

    private void fillColumnConstraint(Column_optionContext option,
            AbstractColumn col, AbstractTable table) {
        String conName = option.id() == null ? "" : getFullCtxText(option.id());
        AbstractConstraint con = new MsConstraint(conName, getFullCtxText(option));
        Column_constraint_bodyContext body = option.column_constraint_body();
        con.setPrimaryKey(body.PRIMARY() != null);
        con.setUnique(body.UNIQUE() != null);

        if (body.REFERENCES() != null) {
            Qualified_nameContext ref = body.qualified_name();
            IdContext schCtx = ref.schema;
            String fschema = schCtx == null ? getDefSchemaName() : schCtx.getText();
            String ftable = ref.name.getText();

            GenericColumn ftableRef = new GenericColumn(fschema, ftable, DbObjType.TABLE);
            con.setForeignTable(ftableRef);
            con.addDep(ftableRef);

            if (body.id() != null) {
                String rcol = body.id().getText();
                con.addForeignColumn(rcol);
                con.addDep(new GenericColumn(fschema, ftable, rcol, DbObjType.COLUMN));
            }
        } else if (con.isUnique() || con.isPrimaryKey()) {
            con.addColumn(col.getName());
        }

        con.setDefinition(getFullCtxText(body));
        table.addConstraint(con);
    }

    private void parseOptions(List<Index_optionContext> options, AbstractRegularTable table){
        for (Index_optionContext option : options) {
            String key = option.key.getText();
            String value = option.index_option_value().getText();
            table.addOption(key, value);
        }
    }
}
