package ru.taximaxim.codekeeper.core.parsers.antlr.statements;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_collation_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_database_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_extension_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_foreign_data_wrapperContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_function_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_operator_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_policy_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_schema_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_server_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_type_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_user_mapping_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Schema_alterContext;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class AlterOther extends ParserAbstract {

    private final Schema_alterContext ctx;

    public AlterOther(Schema_alterContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        if (ctx.alter_database_statement() != null) {
            alterDatabase(ctx.alter_database_statement());
        } else if (ctx.alter_function_statement() != null) {
            alterFunction(ctx.alter_function_statement());
        } else if (ctx.alter_schema_statement() != null) {
            alterSchema(ctx.alter_schema_statement());
        } else if (ctx.alter_type_statement() != null) {
            alterType(ctx.alter_type_statement());
        } else if (ctx.alter_operator_statement() != null) {
            alterOperator(ctx.alter_operator_statement());
        } else if (ctx.alter_extension_statement() != null) {
            alterExtension(ctx.alter_extension_statement());
        } else if (ctx.alter_foreign_data_wrapper() != null) {
            alterForeignDataWrapper(ctx.alter_foreign_data_wrapper());
        } else if (ctx.alter_policy_statement() != null) {
            alterPolicy(ctx.alter_policy_statement());
        } else if (ctx.alter_collation_statement() != null) {
            alterCollation(ctx.alter_collation_statement());
        } else if (ctx.alter_server_statement() != null) {
            alterServer(ctx.alter_server_statement());
        } else if (ctx.alter_user_mapping_statement() != null) {
            alterUserMapping(ctx.alter_user_mapping_statement());
        }
    }

    private void alterDatabase(Alter_database_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.DATABASE, ACTION_ALTER);
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

        addObjReference(getIdentifiers(ctx.function_parameters().schema_qualified_name()),
                type, ACTION_ALTER);
    }

    public void alterSchema(Alter_schema_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.SCHEMA, ACTION_ALTER);
    }

    public void alterType(Alter_type_statementContext ctx) {
        addObjReference(getIdentifiers(ctx.name), DbObjType.TYPE, ACTION_ALTER);
    }

    private void alterOperator(Alter_operator_statementContext ctx) {
        addObjReference(getIdentifiers(ctx.target_operator().name), DbObjType.OPERATOR, ACTION_ALTER);
    }

    private void alterExtension(Alter_extension_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.EXTENSION, ACTION_ALTER);
    }

    private void alterForeignDataWrapper(Alter_foreign_data_wrapperContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.FOREIGN_DATA_WRAPPER, ACTION_ALTER);
    }

    private void alterPolicy(Alter_policy_statementContext ctx) {
        List<ParserRuleContext> ids = getIdentifiers(ctx.schema_qualified_name());
        addObjReference(ids, DbObjType.TABLE, null);
        ParserRuleContext schema = QNameParser.getSchemaNameCtx(ids);
        ParserRuleContext parent = QNameParser.getFirstNameCtx(ids);
        addObjReference(Arrays.asList(schema, parent, ctx.identifier()), DbObjType.POLICY, ACTION_ALTER);
    }

    private void alterCollation(Alter_collation_statementContext ctx) {
        addObjReference(getIdentifiers(ctx.schema_qualified_name()), DbObjType.COLLATION, ACTION_ALTER);
    }

    private void alterServer(Alter_server_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.SERVER, ACTION_ALTER);
    }

    private void alterUserMapping(Alter_user_mapping_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.user_mapping_name()), DbObjType.USER_MAPPING, ACTION_ALTER);
    }

    @Override
    protected String getStmtAction() {
        DbObjType type = getType();
        ParserRuleContext id = getId();
        return type != null && id != null ? getStrForStmtAction(ACTION_ALTER, type, id) : null;

    }

    private DbObjType getType() {
        if (ctx.alter_operator_statement() != null) {
            return DbObjType.OPERATOR;
        } else if (ctx.alter_function_statement() != null) {
            return DbObjType.FUNCTION;
        } else if (ctx.alter_schema_statement() != null) {
            return DbObjType.SCHEMA;
        } else if (ctx.alter_type_statement() != null) {
            return DbObjType.TYPE;
        } else if (ctx.alter_extension_statement() != null) {
            return DbObjType.EXTENSION;
        } else if (ctx.alter_database_statement() != null) {
            return DbObjType.DATABASE;
        } else if (ctx.alter_foreign_data_wrapper() != null) {
            return DbObjType.FOREIGN_DATA_WRAPPER;
        } else if (ctx.alter_policy_statement() != null) {
            return DbObjType.POLICY;
        } else if (ctx.alter_server_statement() != null) {
            return DbObjType.SERVER;
        } else if (ctx.alter_user_mapping_statement() != null) {
            return DbObjType.USER_MAPPING;
        } else if (ctx.alter_collation_statement() != null) {
            return DbObjType.COLLATION;
        }
        return null;
    }

    private ParserRuleContext getId() {
        Alter_operator_statementContext alterOperCtx = ctx.alter_operator_statement();
        if (alterOperCtx != null) {
            return alterOperCtx.target_operator().name;
        }
        if (ctx.alter_function_statement() != null) {
            return ctx.alter_function_statement().function_parameters().schema_qualified_name();
        }
        if (ctx.alter_schema_statement() != null) {
            return ctx.alter_schema_statement().identifier();
        }
        if (ctx.alter_type_statement() != null) {
            return ctx.alter_type_statement().name;
        }
        if (ctx.alter_extension_statement() != null) {
            return ctx.alter_extension_statement().identifier();
        }
        if (ctx.alter_database_statement() != null) {
            return ctx.alter_database_statement().identifier();
        }
        if (ctx.alter_foreign_data_wrapper() != null) {
            return ctx.alter_foreign_data_wrapper().identifier();
        }
        if (ctx.alter_policy_statement() != null) {
            return ctx.alter_policy_statement().identifier();
        }
        if (ctx.alter_collation_statement() != null) {
            return ctx.alter_collation_statement().schema_qualified_name();
        }
        if (ctx.alter_server_statement() != null) {
            return ctx.alter_server_statement().identifier();
        }
        if (ctx.alter_user_mapping_statement() != null) {
            return ctx.alter_user_mapping_statement().user_mapping_name().identifier();
        }
        return null;
    }
}
