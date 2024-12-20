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
package ru.taximaxim.codekeeper.core.parsers.antlr;

import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.core.runtime.IProgressMonitor;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.loader.ParserListenerMode;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrContextProcessor.TSqlContextProcessor;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Another_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.BatchContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Batch_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Batch_statement_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Create_or_alter_triggerContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Create_xml_indexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Ddl_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Delete_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Dml_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Enable_disable_triggerContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Go_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Insert_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Schema_alterContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Schema_createContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Schema_dropContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Security_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Set_specialContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Set_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Sql_clausesContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.St_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Transaction_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Tsql_fileContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Update_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.AlterMsAssembly;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.AlterMsAuthorization;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.AlterMsBatch;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.AlterMsOther;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.AlterMsRole;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.AlterMsTable;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.CreateMsAssembly;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.CreateMsFunction;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.CreateMsIndex;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.CreateMsProcedure;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.CreateMsRole;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.CreateMsSchema;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.CreateMsSequence;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.CreateMsStatistics;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.CreateMsTable;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.CreateMsTrigger;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.CreateMsType;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.CreateMsUser;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.CreateMsView;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.DeleteMsStatement;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.DisableMsTrigger;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.DropMsStatement;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.GrantMsPrivilege;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.InsertMsStatement;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.MsParserAbstract;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms.UpdateMsStatement;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;

public class CustomTSQLParserListener extends CustomParserListener<MsDatabase>
implements TSqlContextProcessor {

    private boolean ansiNulls = true;
    private boolean quotedIdentifier = true;

    public CustomTSQLParserListener(MsDatabase database, String filename,
            ParserListenerMode mode, List<Object> errors, IProgressMonitor monitor) {
        super(database, filename, mode, errors, monitor);
    }

    @Override
    public void process(Tsql_fileContext rootCtx, CommonTokenStream stream) {
        for (BatchContext b : rootCtx.batch()) {
            Sql_clausesContext clauses = b.sql_clauses();
            Batch_statementContext batchSt;
            if (clauses != null) {
                for (St_clauseContext st : clauses.st_clause()) {
                    clause(st);
                }
            } else if ((batchSt = b.batch_statement()) != null) {
                batchStatement(batchSt, stream);
            }

            if (ParserListenerMode.SCRIPT == mode && b.EOF() == null) {
                endBatch(b.go_statement(0));
            }
        }
    }

    private void endBatch(Go_statementContext goCtx) {
        PgObjLocation loc = new PgObjLocation.Builder()
                .setAction(Consts.GO)
                .setCtx(goCtx)
                .setSql(Consts.GO)
                .build();

        safeParseStatement(() -> db.addReference(filename, loc), goCtx);
    }

    public void clause(St_clauseContext st) {
        Ddl_clauseContext ddl = st.ddl_clause();
        Dml_clauseContext dml;
        Another_statementContext ast;
        if (ddl != null) {
            Schema_createContext create = ddl.schema_create();
            Schema_alterContext alter;
            Schema_dropContext drop;
            Enable_disable_triggerContext disable;
            if (create != null) {
                create(create);
            } else if ((alter = ddl.schema_alter()) != null) {
                alter(alter);
            } else if ((disable = ddl.enable_disable_trigger()) != null) {
                safeParseStatement(new DisableMsTrigger(disable, db), disable);
                addToQueries(disable, getAction(disable));
            } else if ((drop = ddl.schema_drop()) != null) {
                drop(drop);
            } else {
                addToQueries(ddl, getAction(ddl));
            }
        } else if ((dml = st.dml_clause()) != null) {
            Update_statementContext update = dml.update_statement();
            Insert_statementContext insert = dml.insert_statement();
            Delete_statementContext delete = dml.delete_statement();
            if (update != null) {
                safeParseStatement(new UpdateMsStatement(update, db), update);
            } else if (insert != null) {
                safeParseStatement(new InsertMsStatement(insert, db), insert);
            } else if (delete != null) {
                safeParseStatement(new DeleteMsStatement(delete, db), delete);
            } else {
                addToQueries(dml, getAction(dml));
            }
        } else if ((ast = st.another_statement()) != null) {
            Set_statementContext set = ast.set_statement();
            Security_statementContext security;
            if (set != null) {
                set(set);
                addToQueries(set, getAction(set));
            } else if ((security = ast.security_statement()) != null
                    && security.rule_common() != null) {
                safeParseStatement(new GrantMsPrivilege(security.rule_common(), db), security);
            } else {
                addToQueries(ast, getAction(ast));
            }
        } else {
            addToQueries(st, getAction(st));
        }
    }

    private void batchStatement(Batch_statementContext ctx, CommonTokenStream stream) {
        Batch_statement_bodyContext body = ctx.batch_statement_body();

        if (ctx.ALTER() != null) {
            safeParseStatement(new AlterMsBatch(body, db, stream), body);
            return;
        }

        MsParserAbstract p;

        if (ctx.create_schema() != null) {
            p = new CreateMsSchema(ctx.create_schema(), db);
        } else if (body.create_or_alter_procedure() != null) {
            p = new CreateMsProcedure(ctx, db, ansiNulls, quotedIdentifier, stream);
        } else if (body.create_or_alter_function() != null) {
            p = new CreateMsFunction(ctx, db, ansiNulls, quotedIdentifier, stream);
        } else if (body.create_or_alter_view() != null) {
            p = new CreateMsView(ctx, db, ansiNulls, quotedIdentifier, stream);
        } else if (body.create_or_alter_trigger() != null) {
            Create_or_alter_triggerContext triggerCtx = body.create_or_alter_trigger();
            if (triggerCtx.SERVER() != null || triggerCtx.DATABASE() != null) {
                addToQueries(ctx, "CREATE TRIGGER");
                return;
            }
            p = new CreateMsTrigger(ctx, db, ansiNulls, quotedIdentifier, stream);
        } else {
            addToQueries(ctx, getAction(ctx));
            return;
        }

        safeParseStatement(p, ctx);
    }


    private void create(Schema_createContext ctx) {
        MsParserAbstract p;
        if (ctx.create_sequence() != null) {
            p = new CreateMsSequence(ctx.create_sequence(), db);
        } else if (ctx.create_index() != null) {
            p = new CreateMsIndex(ctx.create_index(), db);
        } else if (ctx.create_table() != null) {
            p = new CreateMsTable(ctx.create_table(), db, ansiNulls);
        } else if (ctx.create_assembly() != null) {
            p = new CreateMsAssembly(ctx.create_assembly(), db);
        } else if (ctx.create_db_role() != null) {
            p = new CreateMsRole(ctx.create_db_role(), db);
        } else if (ctx.create_user() != null) {
            p = new CreateMsUser(ctx.create_user(), db);
        } else if (ctx.create_type() != null) {
            p = new CreateMsType(ctx.create_type(), db);
        } else if (ctx.create_statistics() != null) {
            p = new CreateMsStatistics(ctx.create_statistics(), db);
        } else {
            addToQueries(ctx, getAction(ctx));
            return;
        }
        safeParseStatement(p, ctx);
    }

    private void alter(Schema_alterContext ctx) {
        MsParserAbstract p;
        if (ctx.alter_authorization() != null) {
            p = new AlterMsAuthorization(ctx.alter_authorization(), db);
        } else if (ctx.alter_table() != null) {
            p = new AlterMsTable(ctx.alter_table(), db);
        } else if (ctx.alter_assembly() != null) {
            p = new AlterMsAssembly(ctx.alter_assembly(), db);
        } else if (ctx.alter_db_role() != null) {
            p = new AlterMsRole(ctx.alter_db_role(), db);
        } else if (ctx.alter_schema_sql() != null
                || ctx.alter_user() != null
                || ctx.alter_sequence() != null) {
            p = new AlterMsOther(ctx, db);
        } else {
            addToQueries(ctx, getAction(ctx));
            return;
        }
        safeParseStatement(p, ctx);
    }

    private void drop(Schema_dropContext ctx) {
        MsParserAbstract p;
        if (ctx.drop_assembly() != null
                || ctx.drop_index() != null
                || ctx.drop_statements() != null) {
            p = new DropMsStatement(ctx, db);
        } else {
            addToQueries(ctx, getAction(ctx));
            return;
        }
        safeParseStatement(p, ctx);
    }

    private void set(Set_statementContext setCtx) {
        Set_specialContext ctx = setCtx.set_special();
        if (ctx == null || ctx.name_list() == null) {
            return;
        }

        for (var nameCtx : ctx.name_list().id()) {
            String set = nameCtx.getText();
            boolean isOn = ctx.on_off().ON() != null;
            if ("ansi_nulls".equalsIgnoreCase(set)) {
                ansiNulls = isOn;
            } else if ("quoted_identifier".equalsIgnoreCase(set)) {
                quotedIdentifier = isOn;
            }
        }
    }

    private String getAction(ParserRuleContext ctx) {
        if (ctx instanceof Another_statementContext ast) {
            Transaction_statementContext transactionCtx;
            if ((transactionCtx = ast.transaction_statement()) != null
                    && transactionCtx.BEGIN() != null) {
                return "BEGIN TRANSACTION";
            }
        } else if (ctx instanceof Dml_clauseContext dml) {
            if (dml.merge_statement() != null) {
                return "MERGE";
            }
            if (dml.select_statement() != null) {
                return "SELECT";
            }
        } else if (ctx instanceof Schema_createContext createCtx) {
            Create_xml_indexContext xmlIdxCtx;
            int descrWordsCount = 2;
            if (createCtx.create_application_role() != null
                    || createCtx.create_asymmetric_key() != null
                    || createCtx.create_cryptographic_provider() != null
                    || createCtx.create_event_notification() != null
                    || createCtx.create_external_library() != null
                    || createCtx.create_external_table() != null
                    || createCtx.create_fulltext_catalog() != null
                    || createCtx.create_fulltext_index() != null
                    || createCtx.create_fulltext_stoplist() != null
                    || createCtx.create_key() != null
                    || createCtx.create_master_key_sql_server() != null
                    || createCtx.create_message_type() != null
                    || createCtx.create_or_alter_broker_priority() != null
                    || createCtx.create_or_alter_event_session() != null
                    || createCtx.create_or_alter_resource_pool() != null
                    || createCtx.create_partition_function() != null
                    || createCtx.create_partition_scheme() != null
                    || createCtx.create_security_policy() != null
                    || createCtx.create_server_audit() != null
                    || createCtx.create_server_role() != null
                    || createCtx.create_workload_group() != null
                    || ((xmlIdxCtx = createCtx.create_xml_index()) != null && xmlIdxCtx.PRIMARY() == null)
                    || createCtx.create_spatial_index() != null) {
                descrWordsCount = 3;
            } else if (createCtx.create_column_encryption_key() != null
                    || createCtx.create_column_master_key() != null
                    || createCtx.create_database_encryption_key() != null
                    || createCtx.create_database_scoped_credential() != null
                    || createCtx.create_external_resource_pool() != null
                    || createCtx.create_remote_service_binding() != null
                    || createCtx.create_search_property_list() != null
                    || createCtx.create_selective_index() != null
                    || createCtx.create_server_audit_specification() != null
                    || createCtx.create_xml_schema_collection() != null
                    || ((xmlIdxCtx = createCtx.create_xml_index()) != null && xmlIdxCtx.PRIMARY() != null)) {
                descrWordsCount = 4;
            }
            return getActionDescription(ctx, descrWordsCount);
        } else if (ctx instanceof Schema_alterContext alterCtx) {
            int descrWordsCount = 2;
            if (alterCtx.alter_asymmetric_key() != null
                    || alterCtx.alter_application_role() != null
                    || alterCtx.alter_availability_group() != null
                    || alterCtx.alter_cryptographic_provider() != null
                    || alterCtx.alter_external_library() != null
                    || alterCtx.alter_fulltext_catalog() != null
                    || alterCtx.alter_fulltext_index() != null
                    || alterCtx.alter_fulltext_stoplist() != null
                    || alterCtx.alter_master_key_sql_server() != null
                    || alterCtx.alter_message_type() != null
                    || alterCtx.alter_partition_function() != null
                    || alterCtx.alter_partition_scheme() != null
                    || alterCtx.alter_resource_governor() != null
                    || alterCtx.alter_security_policy() != null
                    || alterCtx.alter_server_audit() != null
                    || alterCtx.alter_server_configuration() != null
                    || alterCtx.alter_server_role() != null
                    || alterCtx.alter_symmetric_key() != null
                    || alterCtx.alter_workload_group() != null
                    || alterCtx.create_or_alter_broker_priority() != null
                    || alterCtx.create_or_alter_event_session() != null
                    || alterCtx.create_or_alter_resource_pool() != null
                    || (alterCtx.alter_index() != null && alterCtx.alter_index().ALL() != null)) {
                descrWordsCount = 3;
            } else if (alterCtx.alter_column_encryption_key() != null
                    || alterCtx.alter_database_encryption_key() != null
                    || alterCtx.alter_database_scoped_credential() != null
                    || alterCtx.alter_external_data_source() != null
                    || alterCtx.alter_external_resource_pool() != null
                    || alterCtx.alter_remote_service_binding() != null
                    || alterCtx.alter_search_property_list() != null
                    || alterCtx.alter_server_audit_specification() != null
                    || alterCtx.alter_service_master_key() != null
                    || alterCtx.alter_xml_schema_collection() != null) {
                descrWordsCount = 4;
            }
            return getActionDescription(ctx, descrWordsCount);
        } else if (ctx instanceof Schema_dropContext dropCtx) {
            int descrWordsCount = 2;
            if (dropCtx.drop_asymmetric_key() != null
                    || dropCtx.drop_event_notifications_or_session() != null
                    || dropCtx.drop_external_library() != null
                    || dropCtx.drop_master_key() != null
                    || dropCtx.drop_symmetric_key() != null) {
                descrWordsCount = 3;
            } else if (dropCtx.drop_database_encryption_key() != null) {
                descrWordsCount = 4;
            } else if (dropCtx.drop_signature() != null) {
                return "DROP SIGNATURE";
            }
            return getActionDescription(ctx, descrWordsCount);
        }
        return ctx.getStart().getText().toUpperCase(Locale.ROOT);
    }
}