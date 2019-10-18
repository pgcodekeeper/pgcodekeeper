package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_extension_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_index_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_operator_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_type_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class AlterOther extends ParserAbstract {

    private final Schema_alterContext ctx;

    public AlterOther(Schema_alterContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        if (ctx.alter_function_statement() != null) {
            alterFunction(ctx.alter_function_statement());
        } else if (ctx.alter_schema_statement() != null) {
            alterSchema(ctx.alter_schema_statement());
        } else if (ctx.alter_type_statement() != null) {
            alterType(ctx.alter_type_statement());
        } else if (ctx.alter_operator_statement() != null) {
            alterOperator(ctx.alter_operator_statement());
        } else if (ctx.alter_index_statement() != null) {
            alterIndex(ctx.alter_index_statement());
        } else if (ctx.alter_extension_statement() != null) {
            alterExtension(ctx.alter_extension_statement());
        }
    }

    public void alterFunction(Alter_function_statementContext ctx) {
        DbObjType type;
        if (ctx.FUNCTION() != null) {
            type = DbObjType.FUNCTION;
        } else if (ctx.PROCEDURE() != null) {
            type = DbObjType.PROCEDURE;
        } else {
            type = DbObjType.AGGREGATE;
        }

        addObjReference(ctx.function_parameters().name.identifier(), type, ACTION_ALTER);
    }

    public void alterSchema(Alter_schema_statementContext ctx) {
        IdentifierContext nameCtx = ctx.schema_with_name().name;
        addObjReference(Arrays.asList(nameCtx), DbObjType.SCHEMA, ACTION_ALTER);
    }

    public void alterType(Alter_type_statementContext ctx) {
        addObjReference(ctx.name.identifier(), DbObjType.TYPE, ACTION_ALTER);
    }

    private void alterOperator(Alter_operator_statementContext ctx) {
        Operator_nameContext nameCtx = ctx.target_operator().operator_name();
        addObjReference(Arrays.asList(nameCtx.schema_name, nameCtx.operator),
                DbObjType.OPERATOR, ACTION_ALTER);
    }

    private void alterIndex(Alter_index_statementContext ctx) {
        addObjReference(ctx.index_all_def() != null ? Arrays.asList(ctx.index_all_def().tbl_spc)
                : ctx.index_def().index_if_exists_name().schema_qualified_name().identifier(),
                DbObjType.INDEX, ACTION_ALTER);
    }

    private void alterExtension(Alter_extension_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.EXTENSION, ACTION_ALTER);
    }

    @Override
    protected Pair<String, GenericColumn> getActionAndObjForStmtAction() {
        GenericColumn descrObj = null;
        Alter_operator_statementContext alterOperCtx = ctx.alter_operator_statement();
        if (alterOperCtx != null) {
            Operator_nameContext nameCtx = alterOperCtx.target_operator().operator_name();
            descrObj = new GenericColumn(nameCtx.schema_name.getText(),
                    nameCtx.operator.getText(), DbObjType.OPERATOR);
        } else {
            DbObjType type = getType();
            List<IdentifierContext> ids = getIds();
            if (type != null && !ids.isEmpty()) {
                descrObj = new GenericColumn(QNameParser.getSchemaName(ids),
                        QNameParser.getFirstNameCtx(ids).getText(), type);
            }
        }
        return descrObj != null ? new Pair<>(ACTION_ALTER, descrObj) : null;
    }

    private DbObjType getType() {
        if (ctx.alter_function_statement() != null) {
            return DbObjType.FUNCTION;
        } else if (ctx.alter_schema_statement() != null) {
            return DbObjType.SCHEMA;
        } else if (ctx.alter_type_statement() != null) {
            return DbObjType.TYPE;
        } else if (ctx.alter_index_statement() != null) {
            return DbObjType.INDEX;
        } else if (ctx.alter_extension_statement() != null) {
            return DbObjType.EXTENSION;
        }
        return null;
    }

    private List<IdentifierContext> getIds() {
        if (ctx.alter_function_statement() != null) {
            return ctx.alter_function_statement().function_parameters().name.identifier();
        } else if (ctx.alter_schema_statement() != null) {
            return Arrays.asList(ctx.alter_schema_statement().schema_with_name().name);
        } else if (ctx.alter_type_statement() != null) {
            return ctx.alter_type_statement().name.identifier();
        } else if (ctx.alter_index_statement() != null) {
            Alter_index_statementContext alterIdxCtx = ctx.alter_index_statement();
            return alterIdxCtx.index_all_def() != null ? Arrays.asList(alterIdxCtx.index_all_def().tbl_spc)
                    : alterIdxCtx.index_def().index_if_exists_name().schema_qualified_name().identifier();
        } else if (ctx.alter_extension_statement() != null) {
            return Arrays.asList(ctx.alter_extension_statement().identifier());
        }
        return Collections.emptyList();
    }
}