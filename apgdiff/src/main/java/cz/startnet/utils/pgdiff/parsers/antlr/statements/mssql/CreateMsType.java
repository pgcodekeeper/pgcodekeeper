package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ClusteredContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_def_table_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Identity_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_whereContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Type_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.MsColumn;
import cz.startnet.utils.pgdiff.schema.MsType;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateMsType extends ParserAbstract {

    private final Create_typeContext ctx;

    public CreateMsType(Create_typeContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        MsType type = new MsType(ctx.name.getText(), getFullCtxText(ctx.getParent()));

        Type_definitionContext def = ctx.type_definition();

        if (def.FROM() != null) {
            type.setBaseType(getFullCtxText(def.data_type()));
            type.setNotNull(def.null_notnull() != null && def.null_notnull().NOT() != null);
        } if (def.EXTERNAL() != null) {
            String assemblyClass = null;
            if (def.class_name == null) {
                assemblyClass = def.class_name.getText();
            }
            type.setAssemblyName(def.assembly_name.getText(), assemblyClass);
        } else {
            for (Column_def_table_constraintContext con :
                def.column_def_table_constraints().column_def_table_constraint()) {
                fillTableType(con, type);
            }
            type.setMemoryOptimazed(def.WITH() != null && def.on_off().ON() != null);
        }

        return type;
    }

    private void fillTableType(Column_def_table_constraintContext colCtx, MsType type) {
        if (colCtx.table_constraint() != null) {
            type.addConstraint(getFullCtxText(colCtx.table_constraint().table_constraint_body()));
        } else if (colCtx.table_index() != null) {
            fillTableIndex(colCtx.table_index(), type);
        } else {
            MsColumn col = new MsColumn(colCtx.id().getText());

            if (colCtx.data_type() != null) {
                col.setType(getFullCtxText(colCtx.data_type()));
            } else {
                col.setExpression(getFullCtxText(colCtx.expression()));
            }

            for (Column_optionContext option : colCtx.column_option()) {
                fillColumnOption(option, col);
            }

            type.addColumn(col.getFullDefinition());
        }
    }

    private void fillTableIndex(Table_indexContext indCtx, MsType type) {
        final StringBuilder sb = new StringBuilder();
        sb.append("INDEX ");
        sb.append(MsDiffUtils.quoteName(indCtx.index_name.getText()));

        ClusteredContext cluster = indCtx.clustered();
        if (cluster != null && cluster.CLUSTERED() != null) {
            sb.append("NON");
        }
        sb.append("CLUSTERED ");

        Index_restContext rest = indCtx.index_rest();

        sb.append(getFullCtxText(rest.index_sort()));
        Index_whereContext wherePart = rest.index_where();
        if (wherePart != null) {
            sb.append("\nWHERE ").append(getFullCtxText(wherePart.where));
        }

        type.addIndex(sb.toString());
    }

    private void fillColumnOption(Column_optionContext option, MsColumn col) {
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
        }
    }
}
