/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Drop_cast_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Drop_database_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Drop_function_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Drop_operator_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Drop_policy_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Drop_rule_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Drop_statementsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Drop_trigger_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Drop_user_mapping_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Operator_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_dropContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Target_operatorContext;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;

public class DropStatement extends PgParserAbstract {

    private final Schema_dropContext ctx;

    public DropStatement(Schema_dropContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        if (ctx.drop_database_statement() != null) {
            dropDatabase(ctx.drop_database_statement());
        } else if (ctx.drop_function_statement() != null) {
            dropFunction(ctx.drop_function_statement());
        } else if (ctx.drop_trigger_statement() != null) {
            dropTrigger(ctx.drop_trigger_statement());
        } else if (ctx.drop_rule_statement() != null) {
            dropRule(ctx.drop_rule_statement());
        } else if (ctx.drop_policy_statement() != null) {
            dropPolicy(ctx.drop_policy_statement());
        } else if (ctx.drop_statements() != null) {
            drop(ctx.drop_statements());
        } else if (ctx.drop_operator_statement() != null) {
            dropOperator(ctx.drop_operator_statement());
        } else if (ctx.drop_cast_statement() != null) {
            dropCast(ctx.drop_cast_statement());
        } else if (ctx.drop_user_mapping_statement() != null) {
            dropUserMapping(ctx.drop_user_mapping_statement());
        }
    }

    private void dropDatabase(Drop_database_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.DATABASE, ACTION_DROP);
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
        addObjReference(getIdentifiers(ctx.name), type, ACTION_DROP);
    }

    private void dropOperator(Drop_operator_statementContext ctx) {
        for (Target_operatorContext targetOperCtx : ctx.target_operator()) {
            addObjReference(getIdentifiers(targetOperCtx.name), DbObjType.OPERATOR, ACTION_DROP);
        }
    }

    private void dropCast(Drop_cast_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.cast_name()), DbObjType.CAST, ACTION_DROP);
    }

    private void dropTrigger(Drop_trigger_statementContext ctx) {
        dropChild(getIdentifiers(ctx.table_name), ctx.name, DbObjType.TRIGGER);
    }

    private void dropRule(Drop_rule_statementContext ctx) {
        dropChild(getIdentifiers(ctx.schema_qualified_name()), ctx.name, DbObjType.RULE);
    }

    private void dropPolicy(Drop_policy_statementContext ctx) {
        List<ParserRuleContext> ids = getIdentifiers(ctx.schema_qualified_name());
        addObjReference(ids, DbObjType.TABLE, null);
        dropChild(getIdentifiers(ctx.schema_qualified_name()), ctx.identifier(), DbObjType.POLICY);
    }

    private void dropUserMapping(Drop_user_mapping_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.user_mapping_name()), DbObjType.USER_MAPPING, ACTION_DROP);
    }

    private void dropChild(List<ParserRuleContext> tableIds, IdentifierContext nameCtx, DbObjType type) {
        tableIds.add(nameCtx);
        addObjReference(tableIds, type, ACTION_DROP);
    }

    private void drop(Drop_statementsContext ctx) {
        DbObjType type = getTypeOfDropStmt(ctx);

        if (type == null) {
            return;
        }

        for (Schema_qualified_nameContext objName : ctx.if_exist_names_restrict_cascade().names_references()
                .schema_qualified_name()) {
            List<ParserRuleContext> ids = getIdentifiers(objName);
            PgObjLocation loc = addObjReference(ids, type, ACTION_DROP);

            if (type == DbObjType.TABLE) {
                loc.setWarning(DangerStatement.DROP_TABLE);
            }
        }
    }

    private DbObjType getTypeOfDropStmt(Drop_statementsContext ctx) {
        if (ctx.TABLE() != null) {
            return DbObjType.TABLE;
        }
        if (ctx.EXTENSION() != null) {
            return DbObjType.EXTENSION;
        }
        if (ctx.SCHEMA() != null) {
            return DbObjType.SCHEMA;
        }
        if (ctx.SEQUENCE() != null) {
            return DbObjType.SEQUENCE;
        }
        if (ctx.VIEW() != null) {
            return DbObjType.VIEW;
        }
        if (ctx.INDEX() != null) {
            return DbObjType.INDEX;
        }
        if (ctx.DOMAIN() != null) {
            return DbObjType.DOMAIN;
        }
        if (ctx.TYPE() != null) {
            return DbObjType.TYPE;
        }
        if (ctx.DICTIONARY() != null) {
            return DbObjType.FTS_DICTIONARY;
        }
        if (ctx.TEMPLATE() != null) {
            return DbObjType.FTS_TEMPLATE;
        }
        if (ctx.PARSER() != null) {
            return DbObjType.FTS_PARSER;
        }
        if (ctx.CONFIGURATION() != null) {
            return DbObjType.FTS_CONFIGURATION;
        }
        if (ctx.SERVER() != null) {
            return DbObjType.SERVER;
        }
        if (ctx.COLLATION() != null) {
            return DbObjType.COLLATION;
        }
        if (ctx.WRAPPER() != null) {
            return DbObjType.FOREIGN_DATA_WRAPPER;
        }
        if (ctx.EVENT() != null) {
            return DbObjType.EVENT_TRIGGER;
        }
        if (ctx.STATISTICS() != null) {
            return DbObjType.STATISTICS;
        }
        return null;
    }

    @Override
    protected PgObjLocation fillQueryLocation(ParserRuleContext ctx) {
        PgObjLocation loc = super.fillQueryLocation(ctx);
        Drop_statementsContext dropSt = ((Schema_dropContext) ctx).drop_statements();
        if (dropSt != null && dropSt.TABLE() != null) {
            loc.setWarning(DangerStatement.DROP_TABLE);
        }
        return loc;
    }

    @Override
    protected String getStmtAction() {
        List<? extends ParserRuleContext> ids = null;
        DbObjType type = null;
        if (ctx.drop_database_statement() != null) {
            Drop_database_statementContext dropDbCtx = ctx.drop_database_statement();
            ids = Arrays.asList(dropDbCtx.identifier());
            type = DbObjType.DATABASE;
        } else if (ctx.drop_function_statement() != null) {
            Drop_function_statementContext dropFuncCtx = ctx.drop_function_statement();
            ids = getIdentifiers(dropFuncCtx.name);
            if (dropFuncCtx.PROCEDURE() != null) {
                type = DbObjType.PROCEDURE;
            } else if (dropFuncCtx.FUNCTION() != null) {
                type = DbObjType.FUNCTION;
            } else {
                type = DbObjType.AGGREGATE;
            }
        } else if (ctx.drop_trigger_statement() != null) {
            Drop_trigger_statementContext dropTrigCtx = ctx.drop_trigger_statement();
            List<ParserRuleContext> auxIds = getIdentifiers(dropTrigCtx.table_name);
            auxIds.add(dropTrigCtx.name);
            ids = auxIds;
            type = DbObjType.TRIGGER;
        } else if (ctx.drop_rule_statement() != null) {
            Drop_rule_statementContext dropRuleCtx = ctx.drop_rule_statement();
            List<ParserRuleContext> auxIds = getIdentifiers(dropRuleCtx.schema_qualified_name());
            auxIds.add(dropRuleCtx.name);
            ids = auxIds;
            type = DbObjType.RULE;
        } else if (ctx.drop_policy_statement() != null) {
            Drop_policy_statementContext dropPolicyCtx = ctx.drop_policy_statement();
            List<ParserRuleContext> auxIds = getIdentifiers(dropPolicyCtx.schema_qualified_name());
            auxIds.add(dropPolicyCtx.identifier());
            ids = auxIds;
            type = DbObjType.POLICY;
        } else if (ctx.drop_statements() != null) {
            Drop_statementsContext dropStmtCtx = ctx.drop_statements();
            type = getTypeOfDropStmt(dropStmtCtx);
            if (type != null) {
                List<Schema_qualified_nameContext> objNames = dropStmtCtx
                        .if_exist_names_restrict_cascade().names_references().schema_qualified_name();
                ids = objNames.size() == 1 ? getIdentifiers(objNames.get(0))
                        : Collections.emptyList();
            }
        } else if (ctx.drop_operator_statement() != null) {
            Drop_operator_statementContext dropRuleCtx = ctx.drop_operator_statement();
            List<Target_operatorContext> targetOpers = dropRuleCtx.target_operator();
            Operator_nameContext nameCtx = targetOpers.get(0).name;
            ids = targetOpers.size() == 1 ? getIdentifiers(nameCtx) : Collections.emptyList();
            type = DbObjType.OPERATOR;
        } else if (ctx.drop_cast_statement() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(ACTION_DROP).append(' ').append(DbObjType.CAST).append(" (");
            sb.append(getCastName(ctx.drop_cast_statement().cast_name()));
            sb.append(')');
            return sb.toString();
        }
        return type != null ? getStrForStmtAction(ACTION_DROP, type, ids) : null;
    }
}
