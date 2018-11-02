package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.TSqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Another_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.BatchContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statement_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Ddl_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Enable_disable_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_createContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Security_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Set_specialContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Set_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sql_clausesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.St_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Tsql_fileContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.AlterMsAssembly;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.AlterMsAuthorization;
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
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsUser;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsView;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.DisableMsTrigger;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class CustomTSQLParserListener extends CustomParserListener
implements TSqlContextProcessor {

    private boolean ansiNulls = true;
    private boolean quotedIdentifier = true;

    public CustomTSQLParserListener(PgDatabase database, String filename,
            List<AntlrError> errors, IProgressMonitor monitor) {
        super(database, filename, errors, monitor);
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
        }
    }

    private void clause(St_clauseContext st) {
        Ddl_clauseContext ddl = st.ddl_clause();
        Another_statementContext ast;
        if (ddl != null) {
            Schema_createContext create = ddl.schema_create();
            Schema_alterContext alter;
            Enable_disable_triggerContext disable;
            if (create != null) {
                create(create);
            } else if ((alter = ddl.schema_alter()) != null) {
                alter(alter);
            } else if ((disable = ddl.enable_disable_trigger()) != null && disable.DISABLE() != null) {
                safeParseStatement(new DisableMsTrigger(disable, db), disable);
            }
        } else if ((ast = st.another_statement()) != null) {
            Set_statementContext set = ast.set_statement();
            Security_statementContext security;
            if (set != null) {
                set(set);
            } else if ((security = ast.security_statement()) != null
                    && security.rule_common() != null) {
                safeParseStatement(new CreateMsRule(security.rule_common(), db), security);
            }
        }
    }

    private void batchStatement(Batch_statementContext ctx, CommonTokenStream stream) {
        if (ctx.CREATE() == null) {
            return;
        }

        ParserAbstract p;

        Batch_statement_bodyContext body = ctx.batch_statement_body();

        if (body.create_or_alter_procedure() != null) {
            p = new CreateMsProcedure(ctx, db, ansiNulls, quotedIdentifier, stream);
        } else if (body.create_or_alter_function() != null) {
            p = new CreateMsFunction(ctx, db, ansiNulls, quotedIdentifier, stream);
        } else if (body.create_or_alter_view() != null) {
            p = new CreateMsView(ctx, db, ansiNulls, quotedIdentifier, stream);
        } else if (body.create_or_alter_trigger() != null) {
            p = new CreateMsTrigger(ctx, db, ansiNulls, quotedIdentifier, stream);
        } else {
            return;
        }

        safeParseStatement(p, ctx);
    }

    private void create(Schema_createContext ctx) {
        ParserAbstract p;
        if (ctx.create_sequence() != null) {
            p = new CreateMsSequence(ctx.create_sequence(), db);
        } else if (ctx.create_schema() != null) {
            p = new CreateMsSchema(ctx.create_schema(), db);
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
        } else {
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
        } else {
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
        switch (set.toLowerCase()) {
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
}