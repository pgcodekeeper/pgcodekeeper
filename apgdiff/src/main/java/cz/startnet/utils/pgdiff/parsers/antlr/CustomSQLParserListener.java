package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.SqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_createContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_statement_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.MonitorCancelledRuntimeException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.ObjectCreationException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterDomain;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterFtsStatement;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterFunction;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterSchema;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterSequence;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterType;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterView;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CommentOn;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateDomain;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateExtension;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateForeignTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateFtsConfiguration;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateFtsDictionary;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateFtsParser;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateFtsTemplate;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateFunction;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateIndex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateRewrite;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateRule;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateSchema;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateSequence;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateTrigger;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateType;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateView;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class CustomSQLParserListener implements SqlContextProcessor {

    private final PgDatabase db;
    private final List<AntlrError> errors;
    private final IProgressMonitor monitor;
    private final String filename;
    private String tablespace;
    private String oids;

    public CustomSQLParserListener(PgDatabase database, String filename,
            List<AntlrError> errors, IProgressMonitor monitor) {
        this.db = database;
        this.errors = errors;
        this.monitor = monitor;
        this.filename = filename;
    }

    /**
     * @param ctx statememnt's first token rule
     */
    private void safeParseStatement(ParserAbstract p, ParserRuleContext ctx) {
        try {
            PgDiffUtils.checkCancelled(monitor);
            PgStatement st = p.getObject();
            if (st != null) {
                st.setLocation(filename);

                if (st instanceof AbstractTable) {
                    ((AbstractTable) st).getConstraints().stream()
                    .filter(con -> con.getLocation() == null)
                    .forEach(con -> con.setLocation(filename));
                }
            }
        } catch (UnresolvedReferenceException ex) {
            errors.add(handleUnresolvedReference(ex, filename));
        } catch (ObjectCreationException ex) {
            errors.add(handleCreationException(ex, filename, ctx));
        } catch (InterruptedException ex) {
            throw new MonitorCancelledRuntimeException();
        } catch (Exception e) {
            Log.log(e);
        }
    }

    @Override
    public void process(SqlContext rootCtx, CommonTokenStream stream) {
        for (StatementContext s : rootCtx.statement()) {
            Schema_statementContext st = s.schema_statement();
            if (st != null) {
                Schema_createContext create = st.schema_create();
                Schema_alterContext alter;
                if (create != null) {
                    create(create);
                } else if ((alter = st.schema_alter()) != null) {
                    alter(alter);
                }
            }
        }
        db.sortColumns();
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
            p = new CreateFunction(ctx.create_function_statement(), db);
        } else if (ctx.create_sequence_statement() != null) {
            p = new CreateSequence(ctx.create_sequence_statement(), db);
        } else if (ctx.create_schema_statement() != null) {
            p = new CreateSchema(ctx.create_schema_statement(), db);
        } else if (ctx.create_view_statement() != null) {
            p = new CreateView(ctx.create_view_statement(), db);
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
        if (ctx.alter_function_statement() != null) {
            p = new AlterFunction(ctx.alter_function_statement(), db);
        } else if (ctx.alter_schema_statement() != null) {
            p = new AlterSchema(ctx.alter_schema_statement(), db);
        } else if (ctx.alter_table_statement() != null) {
            p = new AlterTable(ctx.alter_table_statement(), db);
        } else if (ctx.alter_sequence_statement() != null) {
            p = new AlterSequence(ctx.alter_sequence_statement(), db);
        } else if (ctx.alter_view_statement() != null) {
            p = new AlterView(ctx.alter_view_statement(), db);
        } else if (ctx.alter_type_statement() != null) {
            p = new AlterType(ctx.alter_type_statement(), db);
        } else if (ctx.alter_domain_statement() != null) {
            p = new AlterDomain(ctx.alter_domain_statement(), db);
        } else if (ctx.alter_fts_statement() != null) {
            p = new AlterFtsStatement(ctx.alter_fts_statement(), db);
        } else {
            return;
        }
        safeParseStatement(p, ctx);
    }

    private void set(Set_statementContext ctx) {
        if (ctx.config_param_val.isEmpty()) {
            return;
        }
        String confParam = ctx.config_param.getText();
        // TODO set param values can be identifiers, quoted identifiers, string
        // or other literals: improve handling
        Set_statement_valueContext confValueCtx = ctx.config_param_val.get(0);
        String confValue = confValueCtx.getText();

        switch (confParam.toLowerCase()) {
        case "search_path":
            // костыль: TRANSFORM объекты создаются в pg_catalog и дампятся pg_dump
            if ("pg_catalog".equals(confValue)) {
                break;
            }
            // allow the exception to terminate entire walker here
            // so that objects aren't created on the wrong search_path
            db.setDefaultSchema(ParserAbstract.getSafe(
                    db::getSchema, confValue, confValueCtx.getStart()).getName());
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

    public static AntlrError handleUnresolvedReference(UnresolvedReferenceException ex, String filename) {
        Token t = ex.getErrorToken();
        Log.log(Log.LOG_WARNING, ex.getMessage(), ex);
        return new AntlrError(t, filename, t.getLine(), t.getCharPositionInLine(), ex.getMessage());
    }

    static AntlrError handleCreationException(ObjectCreationException ex, String filename, ParserRuleContext ctx) {
        Token t = ctx.getStart();
        Log.log(Log.LOG_WARNING, ex.getMessage(), ex);
        return new AntlrError(t, filename, t.getLine(), t.getCharPositionInLine(),  ex.getMessage());
    }
}