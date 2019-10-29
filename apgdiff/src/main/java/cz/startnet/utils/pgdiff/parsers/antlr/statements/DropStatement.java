package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Drop_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Drop_operator_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Drop_rule_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Drop_statementsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Drop_trigger_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_dropContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Target_operatorContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class DropStatement extends ParserAbstract {

    private final Schema_dropContext ctx;

    public DropStatement(Schema_dropContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        if (ctx.drop_function_statement() != null) {
            dropFunction(ctx.drop_function_statement());
        } else if (ctx.drop_trigger_statement() != null) {
            dropTrigger(ctx.drop_trigger_statement());
        } else if (ctx.drop_rule_statement() != null) {
            dropRule(ctx.drop_rule_statement());
        } else if (ctx.drop_statements() != null) {
            drop(ctx.drop_statements());
        } else if (ctx.drop_operator_statement() != null) {
            dropOperator(ctx.drop_operator_statement());
        }
    }

    public void dropFunction(Drop_function_statementContext ctx) {
        DbObjType type;
        if (ctx.PROCEDURE() != null) {
            type = DbObjType.PROCEDURE;
        } else if (ctx.FUNCTION() != null) {
            type = DbObjType.FUNCTION;
        } else {
            type = DbObjType.AGGREGATE;
        }
        addObjReference(ctx.name.identifier(), type, StatementActions.DROP);
    }

    public void dropOperator(Drop_operator_statementContext ctx) {
        for (Target_operatorContext targetOperCtx : ctx.target_operator()) {
            Operator_nameContext nameCtx = targetOperCtx.operator_name();
            addObjReference(Arrays.asList(nameCtx.schema_name, nameCtx.operator),
                    DbObjType.OPERATOR, StatementActions.DROP);
        }
    }

    public void dropTrigger(Drop_trigger_statementContext ctx) {
        dropChild(ctx.table_name.identifier(), ctx.name, DbObjType.TRIGGER);
    }

    public void dropRule(Drop_rule_statementContext ctx) {
        dropChild(ctx.schema_qualified_name().identifier(), ctx.name, DbObjType.RULE);
    }

    public void dropChild(List<IdentifierContext> tableIds, IdentifierContext nameCtx, DbObjType type) {
        tableIds.add(nameCtx);
        addObjReference(tableIds, type, StatementActions.DROP);
    }

    public void drop(Drop_statementsContext ctx) {
        DbObjType type = null;
        if (ctx.DATABASE()!= null) {
            type = DbObjType.DATABASE;
        } else if (ctx.TABLE() != null) {
            type = DbObjType.TABLE;
        } else if (ctx.EXTENSION() != null) {
            type = DbObjType.EXTENSION;
        } else if (ctx.SCHEMA() != null) {
            type = DbObjType.SCHEMA;
        } else if (ctx.SEQUENCE() != null) {
            type = DbObjType.SEQUENCE;
        } else if (ctx.VIEW() != null) {
            type = DbObjType.VIEW;
        } else if (ctx.INDEX() != null) {
            type = DbObjType.INDEX;
        } else if (ctx.DOMAIN() != null) {
            type = DbObjType.DOMAIN;
        } else if (ctx.TYPE() != null) {
            type = DbObjType.TYPE;
        } else if (ctx.DICTIONARY() != null) {
            type = DbObjType.FTS_DICTIONARY;
        } else if (ctx.TEMPLATE() != null) {
            type = DbObjType.FTS_TEMPLATE;
        } else if (ctx.PARSER() != null) {
            type = DbObjType.FTS_PARSER;
        } else if (ctx.CONFIGURATION() != null) {
            type = DbObjType.FTS_CONFIGURATION;
        }

        if (type == null) {
            return;
        }

        for (Schema_qualified_nameContext objName :
            ctx.if_exist_names_restrict_cascade().names_references().schema_qualified_name()) {
            List<IdentifierContext> ids = objName.identifier();
            PgObjLocation loc = addObjReference(ids, type, StatementActions.DROP);

            if (type == DbObjType.TABLE) {
                loc.setWarningText(DangerStatement.DROP_TABLE);
            }
        }
    }
}
