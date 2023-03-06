package ru.taximaxim.codekeeper.core.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.ClusteredContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Column_def_table_constraintContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Column_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Create_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Index_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Index_optionsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Index_restContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Index_whereContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Table_constraint_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Table_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLParser.Type_definitionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.MsColumn;
import ru.taximaxim.codekeeper.core.schema.MsType;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

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

        List<ParserRuleContext> ids = Arrays.asList(ctx.qualified_name().schema, nameCtx);
        addSafe(getSchemaSafe(ids), type, ids);
    }

    private void fillTableType(Column_def_table_constraintContext colCtx, MsType type) {
        if (colCtx.table_constraint() != null) {
            StringBuilder constrSb = new StringBuilder();
            Table_constraint_bodyContext body = colCtx.table_constraint().table_constraint_body();
            if (body.column_name_list_with_order() != null) {
                constrSb.append(body.PRIMARY() != null ? "PRIMARY KEY " : "UNIQUE ");

                if (body.clustered() != null) {
                    constrSb.append(body.clustered().CLUSTERED() != null ? "" : "NON");
                    constrSb.append("CLUSTERED ");
                }

                if (body.HASH() != null) {
                    constrSb.append("HASH");
                }

                constrSb.append('\n');

                appendCols(constrSb, body.column_name_list_with_order().column_with_order());

                if (body.index_options() != null) {
                    constrSb.append(' ');
                    constrSb.append(getFullCtxText(body.index_options()));
                }

                if (body.ON() != null) {
                    constrSb.append(' ');
                    constrSb.append(getFullCtxText(body.id()));
                }
            } else {
                constrSb.append(getFullCtxText(body));
            }
            type.addConstraint(constrSb.toString());
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
                fillMsColumnOption(option, col, type);
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

        appendCols(sb, rest.index_sort().column_name_list_with_order().column_with_order());

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

    private void appendCols(StringBuilder sb, List<? extends ParserRuleContext> colsCtx) {
        sb.append("(\n\t");
        sb.append(colsCtx.stream().map(ParserAbstract::getFullCtxText)
                .collect(Collectors.joining(",\n\t")));
        sb.append("\n)");
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.TYPE, ctx.qualified_name());
    }
}
