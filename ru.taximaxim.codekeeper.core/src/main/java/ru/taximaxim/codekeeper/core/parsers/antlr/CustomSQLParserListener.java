/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.parsers.antlr;

import java.util.List;
import java.util.Locale;
import java.util.Queue;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.core.runtime.IProgressMonitor;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.loader.ParserListenerMode;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrContextProcessor.SqlContextProcessor;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.UnresolvedReferenceException;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Data_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_alterContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_createContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_dropContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Script_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Script_transactionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Session_local_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Set_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Set_statement_valueContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.SqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.StatementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.AlterDomain;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.AlterFtsStatement;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.AlterIndex;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.AlterMatView;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.AlterOther;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.AlterOwner;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.AlterSequence;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.AlterTable;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.AlterView;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CommentOn;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateAggregate;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateCast;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateCollation;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateDatabase;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateDomain;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateEventTrigger;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateExtension;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateFdw;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateForeignTable;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateFtsConfiguration;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateFtsDictionary;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateFtsParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateFtsTemplate;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateFunction;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateGpExternalTable;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateIndex;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateOperator;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreatePolicy;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateRule;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateSchema;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateSequence;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateServer;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateTable;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateTrigger;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateUserMapping;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.CreateView;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.DeleteStatement;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.DropStatement;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.GrantPrivilege;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.InsertStatement;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.MergeStatement;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.UpdateStatement;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class CustomSQLParserListener extends CustomParserListener
implements SqlContextProcessor {

    private String tablespace;
    private String accessMethod;
    private String oids;
    private final Queue<AntlrTask<?>> antlrTasks;

    public CustomSQLParserListener(PgDatabase database, String filename, ParserListenerMode mode,
            List<Object> errors, Queue<AntlrTask<?>> antlrTasks, IProgressMonitor monitor) {
        super(database, filename, mode, errors, monitor);
        this.antlrTasks = antlrTasks;
    }

    @Override
    public void process(SqlContext rootCtx, CommonTokenStream stream) {
        for (StatementContext s : rootCtx.statement()) {
            statement(s, stream);
        }
        if (ParserListenerMode.NORMAL == mode) {
            db.sortColumns();
        }
    }

    public void statement(StatementContext statement, CommonTokenStream stream) {
        Schema_statementContext schema = statement.schema_statement();
        Data_statementContext ds;
        if (schema != null) {
            Schema_createContext create = schema.schema_create();
            Schema_alterContext alter;
            Schema_dropContext drop;
            if (create != null) {
                create(create, stream);
            } else if ((alter = schema.schema_alter()) != null) {
                alter(alter, stream);
            } else if ((drop = schema.schema_drop()) != null) {
                drop(drop);
            }
        } else if ((ds = statement.data_statement()) != null) {
            data(ds);
        } else {
            addToQueries(statement, getAction(statement));
        }
    }

    private void create(Schema_createContext ctx, CommonTokenStream stream) {
        ParserAbstract p;
        if (ctx.create_table_statement() != null) {
            p = new CreateTable(ctx.create_table_statement(), db, tablespace, accessMethod, oids, stream);
        } else if (ctx.create_foreign_table_statement() != null) {
            p = new CreateForeignTable(ctx.create_foreign_table_statement(), db, stream);
        } else if (ctx.create_table_external_statement() != null) {
            p = new CreateGpExternalTable(db, stream, ctx.create_table_external_statement());
        } else if (ctx.create_index_statement() != null) {
            p = new CreateIndex(ctx.create_index_statement(), db, tablespace, stream);
        } else if (ctx.create_extension_statement() != null) {
            p = new CreateExtension(ctx.create_extension_statement(), db);
        } else if (ctx.create_foreign_data_wrapper_statement() != null) {
            p = new CreateFdw(ctx.create_foreign_data_wrapper_statement(), db);
        } else if (ctx.create_server_statement() != null) {
            p = new CreateServer(ctx.create_server_statement(), db);
        } else if (ctx.create_cast_statement() != null) {
            p = new CreateCast(ctx.create_cast_statement(), db);
        } else if (ctx.create_user_mapping_statement() != null) {
            p = new CreateUserMapping(ctx.create_user_mapping_statement(), db);
        } else if (ctx.create_trigger_statement() != null) {
            p = new CreateTrigger(ctx.create_trigger_statement(), db);
        } else if (ctx.create_rewrite_statement() != null) {
            p = new CreateRule(ctx.create_rewrite_statement(), db);
        } else if (ctx.create_policy_statement() != null) {
            p = new CreatePolicy(ctx.create_policy_statement(), db);
        } else if (ctx.create_collation_statement() != null) {
            p = new CreateCollation(ctx.create_collation_statement(), db);
        } else if (ctx.create_function_statement() != null) {
            p = new CreateFunction(ctx.create_function_statement(), db, errors, antlrTasks);
        } else if (ctx.create_aggregate_statement() != null) {
            p = new CreateAggregate(ctx.create_aggregate_statement(), db);
        } else if (ctx.create_operator_statement() != null) {
            p = new CreateOperator(ctx.create_operator_statement(), db);
        } else if (ctx.create_sequence_statement() != null) {
            p = new CreateSequence(ctx.create_sequence_statement(), db);
        } else if (ctx.create_schema_statement() != null) {
            p = new CreateSchema(ctx.create_schema_statement(), db);
        } else if (ctx.create_view_statement() != null) {
            p = new CreateView(ctx.create_view_statement(), db, tablespace, accessMethod, stream);
        } else if (ctx.create_type_statement() != null) {
            p = new CreateType(ctx.create_type_statement(), db);
        } else if (ctx.create_domain_statement() != null) {
            p = new CreateDomain(ctx.create_domain_statement(), db, stream);
        } else if (ctx.create_fts_configuration_statement() != null) {
            p = new CreateFtsConfiguration(ctx.create_fts_configuration_statement(), db);
        } else if (ctx.create_fts_template_statement() != null) {
            p = new CreateFtsTemplate(ctx.create_fts_template_statement(), db);
        } else if (ctx.create_fts_parser_statement() != null) {
            p = new CreateFtsParser(ctx.create_fts_parser_statement(), db);
        } else if (ctx.create_event_trigger_statement() != null) {
            p = new CreateEventTrigger(ctx.create_event_trigger_statement(), db);
        } else if (ctx.create_fts_dictionary_statement() != null) {
            p = new CreateFtsDictionary(ctx.create_fts_dictionary_statement(), db);
        } else if (ctx.comment_on_statement() != null) {
            p = new CommentOn(ctx.comment_on_statement(), db);
        } else if (ctx.rule_common() != null) {
            p = new GrantPrivilege(ctx.rule_common(), db);
        } else if (ctx.create_database_statement() != null) {
            p = new CreateDatabase(ctx.create_database_statement(), db);
        } else if (ctx.set_statement() != null) {
            Set_statementContext setCtx = ctx.set_statement();
            set(setCtx);
            addToQueries(setCtx, getAction(setCtx));
            return;
        } else {
            addToQueries(ctx, getAction(ctx));
            return;
        }
        safeParseStatement(p, ctx);
    }

    private void alter(Schema_alterContext ctx, CommonTokenStream stream) {
        ParserAbstract p;
        if (ctx.alter_table_statement() != null) {
            p = new AlterTable(ctx.alter_table_statement(), db, tablespace, stream);
        } else if (ctx.alter_index_statement() != null) {
            p = new AlterIndex(ctx.alter_index_statement(), db);
        } else if (ctx.alter_sequence_statement() != null) {
            p = new AlterSequence(ctx.alter_sequence_statement(), db);
        } else if (ctx.alter_view_statement() != null) {
            p = new AlterView(ctx.alter_view_statement(), db, stream);
        } else if (ctx.alter_materialized_view_statement() != null) {
            p = new AlterMatView(ctx.alter_materialized_view_statement(), db);
        } else if (ctx.alter_domain_statement() != null) {
            p = new AlterDomain(ctx.alter_domain_statement(), db);
        } else if (ctx.alter_fts_statement() != null) {
            p = new AlterFtsStatement(ctx.alter_fts_statement(), db);
        } else if (ctx.alter_owner_statement() != null) {
            p = new AlterOwner(ctx.alter_owner_statement(), db);
        } else if (ctx.alter_database_statement() != null
                || ctx.alter_extension_statement() != null
                || ctx.alter_function_statement() != null
                || ctx.alter_operator_statement() != null
                || ctx.alter_schema_statement() != null
                || ctx.alter_type_statement() != null
                || ctx.alter_foreign_data_wrapper() != null
                || ctx.alter_policy_statement() != null
                || ctx.alter_server_statement() != null
                || ctx.alter_collation_statement() != null
                || ctx.alter_event_trigger_statement() != null
                || ctx.alter_user_mapping_statement() != null) {
            p = new AlterOther(ctx, db);
        } else {
            addToQueries(ctx, getAction(ctx));
            return;
        }
        safeParseStatement(p, ctx);
    }

    private void drop(Schema_dropContext ctx) {
        ParserAbstract p;
        if (ctx.drop_database_statement() != null
                || ctx.drop_function_statement() != null
                || ctx.drop_trigger_statement() != null
                || ctx.drop_rule_statement() != null
                || ctx.drop_statements() != null
                || ctx.drop_operator_statement() != null
                || ctx.drop_cast_statement() != null
                || ctx.drop_policy_statement() != null
                || ctx.drop_user_mapping_statement() != null) {
            p = new DropStatement(ctx, db);
        } else {
            addToQueries(ctx, getAction(ctx));
            return;
        }
        safeParseStatement(p, ctx);
    }

    private void data(Data_statementContext ctx) {
        ParserAbstract p;
        if (ctx.update_stmt_for_psql() != null) {
            p = new UpdateStatement(ctx.update_stmt_for_psql(), db);
        } else if (ctx.insert_stmt_for_psql() != null) {
            p = new InsertStatement(ctx.insert_stmt_for_psql(), db);
        } else if (ctx.delete_stmt_for_psql() != null) {
            p = new DeleteStatement(ctx.delete_stmt_for_psql(), db);
        } else if (ctx.merge_stmt_for_psql() != null) {
            p = new MergeStatement(ctx.merge_stmt_for_psql(), db);
        } else {
            addToQueries(ctx, getAction(ctx));
            return;
        }

        safeParseStatement(p, ctx);
    }

    private void set(Set_statementContext ctx) {
        Session_local_optionContext sesLocOpt = ctx.set_action().session_local_option();
        if (sesLocOpt == null || sesLocOpt.config_param == null || sesLocOpt.DOT() != null
                || sesLocOpt.FROM() != null) {
            return;
        }
        String confParam = sesLocOpt.config_param.getText();
        // TODO set param values can be identifiers, quoted identifiers, string
        // or other literals: improve handling
        Set_statement_valueContext confValueCtx = sesLocOpt.set_statement_value();
        if (confValueCtx.DEFAULT() != null) {
            return;
        }
        List<VexContext> vex = confValueCtx.vex();
        String confValue = vex.get(0).getText();

        switch (confParam.toLowerCase(Locale.ROOT)) {
        case "search_path":
            if (ParserListenerMode.NORMAL == mode
            && (vex.size() != 1 || !Consts.PG_CATALOG.equals(confValue))) {
                throw new UnresolvedReferenceException("Unsupported search_path", ctx.start);
            }
            break;
        case "default_with_oids":
            oids = confValue;
            if ("false".equals(oids)) {
                oids = null;
            }
            break;
        case "default_tablespace":
            tablespace = confValue;
            if (tablespace.isEmpty()
                    // special case for pg_dump's unset default_tablespace
                    // remove after good unquoting mechanism would be introduced
                    || "''".equals(tablespace)) {
                tablespace = null;
            }
            break;
        case "default_table_access_method":
            accessMethod = confValue;
            break;
        default:
            break;
        }
    }

    private String getAction(ParserRuleContext ctx) {
        if (ctx instanceof StatementContext) {
            StatementContext stmtCtx = (StatementContext) ctx;
            Script_statementContext scriptCtx;
            Script_transactionContext transactionCtx;
            if ((scriptCtx = stmtCtx.script_statement()) != null
                    && (transactionCtx = scriptCtx.script_transaction()) != null
                    && transactionCtx.START() != null) {
                return "START TRANSACTION";
            }
        } else if (ctx instanceof Data_statementContext) {
            if (((Data_statementContext) ctx).select_stmt() != null) {
                return "SELECT";
            }
        } else if (ctx instanceof Schema_createContext) {
            Schema_createContext createCtx = (Schema_createContext) ctx;
            int descrWordsCount = 2;
            if (createCtx.create_language_statement() != null) {
                return "CREATE LANGUAGE";
            } else if (createCtx.create_transform_statement() != null) {
                return "CREATE TRANSFORM";
            } else if (createCtx.create_table_as_statement() != null) {
                return "CREATE TABLE";
            } else if (createCtx.create_conversion_statement() != null) {
                return "CREATE CONVERSION";
            } else if (createCtx.create_event_trigger_statement() != null
                    || createCtx.create_user_mapping_statement() != null
                    || createCtx.create_access_method_statement() != null
                    || createCtx.create_operator_family_statement() != null
                    || createCtx.create_operator_class_statement() != null
                    || createCtx.security_label() != null) {
                descrWordsCount = 3;
            } else if (createCtx.schema_import() != null
                    || createCtx.create_foreign_data_wrapper_statement() != null) {
                descrWordsCount = 4;
            }
            return getActionDescription(ctx, descrWordsCount);
        } else if (ctx instanceof Schema_alterContext) {
            Schema_alterContext alterCtx = (Schema_alterContext) ctx;
            int descrWordsCount = 2;
            if (alterCtx.alter_language_statement() != null) {
                return "ALTER LANGUAGE";
            } else if (alterCtx.alter_foreign_data_wrapper() != null) {
                descrWordsCount = 4;
            } else if (alterCtx.alter_default_privileges_statement() != null
                    || alterCtx.alter_event_trigger_statement() != null
                    || alterCtx.alter_user_mapping_statement() != null
                    || alterCtx.alter_operator_family_statement() != null
                    || alterCtx.alter_operator_class_statement() != null) {
                descrWordsCount = 3;
            }
            return getActionDescription(ctx, descrWordsCount);
        } else if (ctx instanceof Schema_dropContext) {
            Schema_dropContext dropCtx = (Schema_dropContext) ctx;
            int descrWordsCount = 2;
            if (dropCtx.drop_operator_family_statement() != null
                    || dropCtx.drop_operator_class_statement() != null
                    || dropCtx.drop_user_mapping_statement() != null
                    || dropCtx.drop_owned_statement() != null) {
                descrWordsCount = 3;
            }
            return getActionDescription(ctx, descrWordsCount);
        }
        return ctx.getStart().getText().toUpperCase(Locale.ROOT);
    }
}
