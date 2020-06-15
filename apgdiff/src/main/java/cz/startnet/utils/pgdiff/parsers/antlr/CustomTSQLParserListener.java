package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.loader.ParserListenerMode;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.TSqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Another_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.BatchContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statement_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_xml_indexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Ddl_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Delete_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Dml_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Enable_disable_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Go_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Insert_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_createContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_dropContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Security_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Set_specialContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Set_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sql_clausesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.St_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Transaction_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Tsql_fileContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Update_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.AlterMsAssembly;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.AlterMsAuthorization;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.AlterMsBatch;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.AlterMsOther;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.AlterMsRole;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.AlterMsTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsAssembly;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsFunction;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsIndex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsProcedure;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsRole;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsRule;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsSchema;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsSequence;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsTrigger;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsType;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsUser;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsView;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.DeleteMsStatement;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.DisableMsTrigger;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.DropMsStatement;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.InsertMsStatement;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.UpdateMsStatement;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

public class CustomTSQLParserListener extends CustomParserListener
implements TSqlContextProcessor {

    private boolean ansiNulls = true;
    private boolean quotedIdentifier = true;

    public CustomTSQLParserListener(PgDatabase database, String filename,
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
        db.addReference(filename, new PgObjLocation(ApgdiffConsts.GO,
                goCtx, ApgdiffConsts.GO));
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
                safeParseStatement(new CreateMsRule(security.rule_common(), db), security);
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

        ParserAbstract p;

        if (ctx.create_schema() != null) {
            p = new CreateMsSchema(ctx.create_schema(), db);
        } else if (body.create_or_alter_procedure() != null) {
            p = new CreateMsProcedure(ctx, db, ansiNulls, quotedIdentifier, stream);
        } else if (body.create_or_alter_function() != null) {
            p = new CreateMsFunction(ctx, db, ansiNulls, quotedIdentifier, stream);
        } else if (body.create_or_alter_view() != null) {
            p = new CreateMsView(ctx, db, ansiNulls, quotedIdentifier, stream);
        } else if (body.create_or_alter_trigger() != null) {
            p = new CreateMsTrigger(ctx, db, ansiNulls, quotedIdentifier, stream);
        } else {
            addToQueries(ctx, getAction(ctx));
            return;
        }

        safeParseStatement(p, ctx);
    }

    private void create(Schema_createContext ctx) {
        ParserAbstract p;
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
        } else {
            addToQueries(ctx, getAction(ctx));
            return;
        }
        safeParseStatement(p, ctx);
    }

    private void alter(Schema_alterContext ctx) {
        ParserAbstract p;
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
        ParserAbstract p;
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
        if(ctx == null || ctx.name == null) {
            return;
        }

        String set = ctx.name.getText();
        switch (set.toLowerCase(Locale.ROOT)) {
        case "ansi_nulls":
            if (ctx.ON() != null) {
                ansiNulls = true;
            } else if (ctx.OFF() != null) {
                ansiNulls = false;
            }
            break;
        case "quoted_identifier":
            if (ctx.ON() != null) {
                quotedIdentifier = true;
            } else if (ctx.OFF() != null) {
                quotedIdentifier = false;
            }
            break;
        default:
            break;
        }
    }

    private String getAction(ParserRuleContext ctx) {
        if (ctx instanceof Another_statementContext) {
            Another_statementContext ast = (Another_statementContext) ctx;
            Transaction_statementContext transactionCtx;
            if ((transactionCtx = ast.transaction_statement()) != null
                    && transactionCtx.BEGIN() != null) {
                return "BEGIN TRANSACTION";
            }
        } else if (ctx instanceof Dml_clauseContext) {
            Dml_clauseContext dml = (Dml_clauseContext) ctx;
            if (dml.merge_statement() != null) {
                return "MERGE";
            } else if (dml.select_statement() != null) {
                return "SELECT";
            }
        } else if (ctx instanceof Schema_createContext) {
            Schema_createContext createCtx = (Schema_createContext) ctx;
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
                    || ((xmlIdxCtx = createCtx.create_xml_index()) != null
                    && xmlIdxCtx.PRIMARY() == null)) {
                descrWordsCount = 3;
            } else if (createCtx.create_column_encryption_key() != null
                    || createCtx.create_column_master_key() != null
                    || createCtx.create_database_encryption_key() != null
                    || createCtx.create_database_scoped_credential() != null
                    || createCtx.create_external_resource_pool() != null
                    || createCtx.create_master_key_sql_server() != null
                    || createCtx.create_remote_service_binding() != null
                    || createCtx.create_search_property_list() != null
                    || createCtx.create_selective_index() != null
                    || createCtx.create_server_audit_specification() != null
                    || createCtx.create_xml_schema_collection() != null
                    || ((xmlIdxCtx = createCtx.create_xml_index()) != null
                    && xmlIdxCtx.PRIMARY() != null)) {
                descrWordsCount = 4;
            }
            return getActionDescription(ctx, descrWordsCount);
        } else if (ctx instanceof Schema_alterContext) {
            Schema_alterContext alterCtx = (Schema_alterContext) ctx;
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
                    || alterCtx.alter_server_role_pdw() != null
                    || alterCtx.alter_symmetric_key() != null
                    || alterCtx.alter_workload_group() != null
                    || alterCtx.create_or_alter_broker_priority() != null
                    || alterCtx.create_or_alter_event_session() != null
                    || alterCtx.create_or_alter_resource_pool() != null
                    || alterCtx.create_symmetric_key() != null) {
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
        } else if (ctx instanceof Schema_dropContext) {
            Schema_dropContext dropCtx = (Schema_dropContext) ctx;
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