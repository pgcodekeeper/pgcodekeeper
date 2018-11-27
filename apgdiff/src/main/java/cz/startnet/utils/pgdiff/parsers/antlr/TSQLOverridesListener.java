package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.TSqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Another_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.BatchContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_assemblyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_schemaContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Ddl_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Schema_createContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Security_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sql_clausesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.St_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Tsql_fileContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.AlterMsAuthorization;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql.CreateMsRule;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementOverride;

public class TSQLOverridesListener extends CustomParserListener
implements TSqlContextProcessor {

    private final Map<PgStatement, StatementOverride> overrides;

    public TSQLOverridesListener(PgDatabase db, String filename, List<AntlrError> errors,
            IProgressMonitor mon, Map<PgStatement, StatementOverride> overrides) {
        super(db, filename, errors, mon);
        this.overrides = overrides;
    }

    @Override
    public void process(Tsql_fileContext rootCtx, CommonTokenStream stream) {
        for (BatchContext b : rootCtx.batch()) {
            Sql_clausesContext clauses = b.sql_clauses();
            if (clauses != null) {
                for (St_clauseContext st : clauses.st_clause()) {
                    clause(st);
                }
            }
        }
    }

    private void clause(St_clauseContext st) {
        Ddl_clauseContext ddl = st.ddl_clause();
        Another_statementContext ast;
        if (ddl != null && !db.getArguments().isIgnorePrivileges()) {
            Schema_createContext create = ddl.schema_create();
            Schema_alterContext alter;
            if (create != null) {
                safeParseStatement(() -> create(create), create);
            } else if ((alter = ddl.schema_alter()) != null) {
                alter(alter);
            }
        } else if ((ast = st.another_statement()) != null) {
            Security_statementContext ss;
            if ((ss = ast.security_statement()) != null && ss.rule_common() != null) {
                safeParseStatement(new CreateMsRule(ss.rule_common(), db, overrides), ss);
            }
        }
    }

    private void create(Schema_createContext ctx) {
        Create_schemaContext schema = ctx.create_schema();
        Create_assemblyContext ass;
        PgStatement st;
        String owner;
        if (schema != null && schema.owner_name != null) {
            st = ParserAbstract.getSafe(db::getSchema, schema.schema_name);
            owner = schema.owner_name.getText();
        } else if ((ass = ctx.create_assembly()) != null && ass.owner_name != null) {
            st = ParserAbstract.getSafe(db::getAssembly, ass.assembly_name);
            owner = ass.owner_name.getText();
        } else {
            return;
        }

        StatementOverride override = overrides.get(st);
        if (override == null) {
            override = new StatementOverride();
            overrides.put(st, override);
        }

        override.setOwner(owner);
    }

    private void alter(Schema_alterContext ctx) {
        if (ctx.alter_authorization() != null) {
            safeParseStatement(new AlterMsAuthorization(
                    ctx.alter_authorization(), db, overrides), ctx);
        }
    }
}