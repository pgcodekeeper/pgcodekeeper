/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_collation_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_database_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_event_trigger_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_extension_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_foreign_data_wrapperContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_function_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_operator_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_policy_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_schema_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_server_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_statistics_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_type_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Alter_user_mapping_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Encoding_identifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_alterContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Storage_directiveContext;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractType;
import ru.taximaxim.codekeeper.core.schema.pg.PgBaseType;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgEventTrigger;
import ru.taximaxim.codekeeper.core.schema.pg.PgSchema;
import ru.taximaxim.codekeeper.core.schema.pg.PgStatistics;

public class AlterOther extends PgParserAbstract {

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
        } else if (ctx.alter_event_trigger_statement() != null) {
            alterEventTrigger(ctx.alter_event_trigger_statement());
        } else if (ctx.alter_statistics_statement() != null) {
            alterStatistics(ctx.alter_statistics_statement());
        }
    }

    private void alterDatabase(Alter_database_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.DATABASE, ACTION_ALTER);
    }

    private void alterFunction(Alter_function_statementContext ctx) {
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

    private void alterSchema(Alter_schema_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.SCHEMA, ACTION_ALTER);
    }

    private void alterType(Alter_type_statementContext ctx) {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        addObjReference(ids, DbObjType.TYPE, ACTION_ALTER);

        Encoding_identifierContext encodingCtx = ctx.encoding_identifier();
        if (encodingCtx == null) {
            return;
        }

        AbstractSchema schema = getSchemaSafe(ids);
        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);

        AbstractType type = getSafe(AbstractSchema::getType, schema, nameCtx);
        if (type instanceof PgBaseType) {
            PgBaseType baseType = (PgBaseType) type;
            for (Storage_directiveContext storDirCtx : encodingCtx.storage_directive()) {
                if (storDirCtx.compress_type != null) {
                    doSafe(PgBaseType::setCompressType, baseType, storDirCtx.compress_type.getText());
                } else if (storDirCtx.compress_level != null) {
                    doSafe(PgBaseType::setCompressLevel, baseType,
                            Integer.parseInt(storDirCtx.compress_level.getText()));
                } else if (storDirCtx.block_size != null) {
                    doSafe(PgBaseType::setBlockSize, baseType, Integer.parseInt(storDirCtx.block_size.getText()));
                }
            }
        }
    }

    private void alterOperator(Alter_operator_statementContext ctx) {
        addObjReference(getIdentifiers(ctx.target_operator().name), DbObjType.OPERATOR, ACTION_ALTER);
    }

    private void alterExtension(Alter_extension_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.EXTENSION, ACTION_ALTER);
    }

    private void alterEventTrigger(Alter_event_trigger_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.EVENT_TRIGGER, ACTION_ALTER);
        PgEventTrigger eventTrigger = getSafe(PgDatabase::getEventTrigger, db, ctx.name);
        if (eventTrigger != null) {
            if (ctx.alter_event_trigger_action().DISABLE() != null) {
                eventTrigger.setMode("DISABLE");
            } else if (ctx.alter_event_trigger_action().REPLICA() != null) {
                eventTrigger.setMode("ENABLE REPLICA");
            } else if (ctx.alter_event_trigger_action().ALWAYS() != null) {
                eventTrigger.setMode("ENABLE ALWAYS");
            }
        }
    }

    private void alterStatistics(Alter_statistics_statementContext ctx) {
        List<ParserRuleContext> ids = getIdentifiers(ctx.name);
        addObjReference(ids, DbObjType.STATISTICS, ACTION_ALTER);

        PgStatistics stat = getSafe(PgSchema::getStatistics, getSchemaSafe(ids), QNameParser.getFirstNameCtx(ids));

        var statCtx = ctx.set_statistics();
        if (statCtx != null) {
            doSafe(PgStatistics::setStatistics, stat, Integer.parseInt(statCtx.signed_number_literal().getText()));
        }
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
        }
        if (ctx.alter_function_statement() != null) {
            return DbObjType.FUNCTION;
        }
        if (ctx.alter_schema_statement() != null) {
            return DbObjType.SCHEMA;
        }
        if (ctx.alter_type_statement() != null) {
            return DbObjType.TYPE;
        }
        if (ctx.alter_extension_statement() != null) {
            return DbObjType.EXTENSION;
        }
        if (ctx.alter_database_statement() != null) {
            return DbObjType.DATABASE;
        }
        if (ctx.alter_foreign_data_wrapper() != null) {
            return DbObjType.FOREIGN_DATA_WRAPPER;
        }
        if (ctx.alter_policy_statement() != null) {
            return DbObjType.POLICY;
        }
        if (ctx.alter_server_statement() != null) {
            return DbObjType.SERVER;
        }
        if (ctx.alter_user_mapping_statement() != null) {
            return DbObjType.USER_MAPPING;
        }
        if (ctx.alter_collation_statement() != null) {
            return DbObjType.COLLATION;
        }
        if (ctx.alter_event_trigger_statement() != null) {
            return DbObjType.EVENT_TRIGGER;
        }
        if (ctx.alter_statistics_statement() != null) {
            return DbObjType.STATISTICS;
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
        if (ctx.alter_event_trigger_statement() != null) {
            return ctx.alter_event_trigger_statement().name;
        }
        if (ctx.alter_statistics_statement() != null) {
            return ctx.alter_statistics_statement().name;
        }
        return null;
    }
}
