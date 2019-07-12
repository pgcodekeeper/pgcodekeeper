package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.List;
import java.util.Locale;
import java.util.Queue;

import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.SqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_createContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_dropContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Session_local_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_statement_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterDomain;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterFtsStatement;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterOther;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterOwner;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterSequence;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterView;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CommentOn;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateAggregate;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateDomain;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateExtension;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateForeignTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateFtsConfiguration;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateFtsDictionary;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateFtsParser;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateFtsTemplate;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateFunction;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateIndex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateOperator;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateRewrite;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateRule;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateSchema;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateSequence;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateTrigger;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateType;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateView;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.DropStatement;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.UpdateStatement;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

public class CustomSQLParserListener extends CustomParserListener
implements SqlContextProcessor {

    private String tablespace;
    private String oids;
    private final Queue<AntlrTask<?>> antlrTasks;

    public CustomSQLParserListener(PgDatabase database, String filename, boolean refMode,
            List<AntlrError> errors, Queue<AntlrTask<?>> antlrTasks, IProgressMonitor monitor) {
        super(database, filename, refMode, errors, monitor);
        this.antlrTasks = antlrTasks;
    }

    @Override
    public void process(SqlContext rootCtx, CommonTokenStream stream) {
        for (StatementContext s : rootCtx.statement()) {
            statement(s);
        }
        db.sortColumns();
    }

    public void statement(StatementContext statement) {
        Schema_statementContext schema = statement.schema_statement();
        Data_statementContext ds;
        if (schema != null) {
            Schema_createContext create = schema.schema_create();
            Schema_alterContext alter;
            Schema_dropContext drop;
            if (create != null) {
                create(create);
            } else if ((alter = schema.schema_alter()) != null) {
                alter(alter);
            } else if ((drop = schema.schema_drop()) != null) {
                safeParseStatement(new DropStatement(drop, db), drop);
            }
        } else if ((ds = statement.data_statement()) != null) {
            data(ds);
        }
    }

    private void create(Schema_createContext ctx) {
        ParserAbstract p;
        if (ctx.create_table_statement() != null) {
            p = new CreateTable(ctx.create_table_statement(), db, tablespace, oids);
        } else if (ctx.create_foreign_table_statement() != null) {
            p = new CreateForeignTable(ctx.create_foreign_table_statement(), db);
        } else if (ctx.create_index_statement() != null) {
            p = new CreateIndex(ctx.create_index_statement(), db, tablespace);
        } else if (ctx.create_extension_statement() != null) {
            p = new CreateExtension(ctx.create_extension_statement(), db);
        } else if (ctx.create_trigger_statement() != null) {
            p = new CreateTrigger(ctx.create_trigger_statement(), db);
        } else if (ctx.create_rewrite_statement() != null) {
            p = new CreateRewrite(ctx.create_rewrite_statement(), db);
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
            p = new CreateView(ctx.create_view_statement(), db, tablespace);
        } else if (ctx.create_type_statement() != null) {
            p = new CreateType(ctx.create_type_statement(), db);
        } else if (ctx.create_domain_statement() != null) {
            p = new CreateDomain(ctx.create_domain_statement(), db);
        } else if (ctx.create_fts_configuration() != null) {
            p = new CreateFtsConfiguration(ctx.create_fts_configuration(), db);
        } else if (ctx.create_fts_template() != null) {
            p = new CreateFtsTemplate(ctx.create_fts_template(), db);
        } else if (ctx.create_fts_parser() != null) {
            p = new CreateFtsParser(ctx.create_fts_parser(), db);
        } else if (ctx.create_fts_dictionary() != null) {
            p = new CreateFtsDictionary(ctx.create_fts_dictionary(), db);
        } else if (ctx.comment_on_statement() != null) {
            p = new CommentOn(ctx.comment_on_statement(), db);
        } else if (ctx.rule_common() != null) {
            p = new CreateRule(ctx.rule_common(), db);
        } else if (ctx.set_statement() != null) {
            set(ctx.set_statement());
            return;
        } else {
            return;
        }
        safeParseStatement(p, ctx);
    }

    private void alter(Schema_alterContext ctx) {
        ParserAbstract p;
        if (ctx.alter_table_statement() != null) {
            p = new AlterTable(ctx.alter_table_statement(), db, tablespace);
        } else if (ctx.alter_sequence_statement() != null) {
            p = new AlterSequence(ctx.alter_sequence_statement(), db);
        } else if (ctx.alter_view_statement() != null) {
            p = new AlterView(ctx.alter_view_statement(), db);
        } else if (ctx.alter_domain_statement() != null) {
            p = new AlterDomain(ctx.alter_domain_statement(), db);
        } else if (ctx.alter_fts_statement() != null) {
            p = new AlterFtsStatement(ctx.alter_fts_statement(), db);
        } else if (ctx.alter_owner() != null) {
            p = new AlterOwner(ctx.alter_owner(), db);
        } else {
            p = new AlterOther(ctx, db);
        }
        safeParseStatement(p, ctx);
    }

    private void data(Data_statementContext ctx) {
        ParserAbstract p;
        if (ctx.update_stmt_for_psql() != null) {
            p =  new UpdateStatement(ctx.update_stmt_for_psql(), db);
        } else {
            return;
        }

        safeParseStatement(p, ctx);
    }

    private void set(Set_statementContext ctx) {
        Session_local_optionContext sesLocOpt = ctx.set_action().session_local_option();
        if (sesLocOpt == null || sesLocOpt.config_param == null) {
            return;
        }
        String confParam = sesLocOpt.config_param.getText();
        // TODO set param values can be identifiers, quoted identifiers, string
        // or other literals: improve handling
        List<Set_statement_valueContext> confValueCtx = sesLocOpt.config_param_val;
        String confValue = confValueCtx.get(0).getText();

        switch (confParam.toLowerCase(Locale.ROOT)) {
        case "search_path":
            if (!refMode && (confValueCtx.size() != 1 || !ApgdiffConsts.PG_CATALOG.equals(confValue))) {
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
        default:
            break;
        }
    }
}