package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ClusteredContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_def_table_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Identity_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_optionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Index_whereContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Type_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.MsColumn;
import cz.startnet.utils.pgdiff.schema.MsType;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateMsType extends ParserAbstract {

    private final Create_typeContext ctx;

    public CreateMsType(Create_typeContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        IdContext nameCtx = ctx.qualified_name().name;
        MsType type = new MsType(nameCtx.getText());

        Type_definitionContext def = ctx.type_definition();

        if (def.FROM() != null) {
            type.setBaseType(getFullCtxText(def.data_type()));
            type.setNotNull(def.null_notnull() != null && def.null_notnull().NOT() != null);
        } else if (def.EXTERNAL() != null) {
            String assemblyName = def.assembly_name.getText();
            type.setAssemblyName(assemblyName);
            addDepSafe(type, Arrays.asList(def.assembly_name),
                    DbObjType.ASSEMBLY, false);
            String assemblyClass;
            if (def.class_name != null) {
                assemblyClass = def.class_name.getText();
            } else {
                assemblyClass = type.getName();
            }

            type.setAssemblyClass(assemblyClass);
        } else {
            for (Column_def_table_constraintContext con :
                def.column_def_table_constraints().column_def_table_constraint()) {
                fillTableType(con, type);
            }
            type.setMemoryOptimized(def.WITH() != null && def.on_off().ON() != null);
        }

        List<IdContext> ids = Arrays.asList(ctx.qualified_name().schema, nameCtx);
        addSafe(getSchemaSafe(ids), type, ids);
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
                addMsTypeDepcy(colCtx.data_type(), type);
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
        sb.append(" ");

        ClusteredContext cluster = indCtx.clustered();
        if (cluster != null && cluster.NONCLUSTERED() != null) {
            sb.append("NON");
        }
        sb.append("CLUSTERED ");

        if (indCtx.HASH() != null) {
            sb.append("HASH");
        }
        sb.append('\n');

        Index_restContext rest = indCtx.index_rest();

        sb.append(getFullCtxText(rest.index_sort()));
        Index_whereContext wherePart = rest.index_where();
        if (wherePart != null) {
            sb.append(" WHERE ").append(getFullCtxText(wherePart.where));
        }

        Index_optionsContext options = rest.index_options();
        if (options != null) {
            for (Index_optionContext option : options.index_option()) {
                String key = option.key.getText();
                String value = option.index_option_value().getText();
                if ("BUCKET_COUNT".equals(key)) {
                    if (wherePart != null) {
                        sb.append('\n');
                    } else {
                        sb.append(" ");
                    }
                    sb.append("WITH ( BUCKET_COUNT = ").append(value).append(')');
                    break;
                }
            }
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
