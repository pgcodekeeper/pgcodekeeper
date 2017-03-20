package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_type_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comment_on_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_extension_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_index_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_trigger_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_type_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rule_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterDomain;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterFunction;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterSchema;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterSequence;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterType;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterView;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CommentOn;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateDomain;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateExtension;
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
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class CustomSQLParserListener extends SQLParserBaseListener {

    private final PgDatabase db;
    private final String parsedObjectName;
    private String tablespace;
    private String oids;
    private final List<AntlrError> errors;

    public CustomSQLParserListener(PgDatabase database, String parsedObjectName,
            List<AntlrError> errors) {
        this.db = database;
        this.errors = errors;
        this.parsedObjectName = parsedObjectName;
    }

    private PgStatement safeParseStatement(ParserAbstract p) {
        try {
            return p.getObject();
        } catch (Exception ex) {
            Log.log(Log.LOG_WARNING, "Exception while analyzing parser tree for: "
                    + parsedObjectName, ex);
            return null;
        }
    }

    @Override
    public void exitCreate_table_statement(Create_table_statementContext ctx) {
        safeParseStatement(new CreateTable(ctx, db, tablespace, oids, errors));
    }

    @Override
    public void exitCreate_index_statement(Create_index_statementContext ctx) {
        safeParseStatement(new CreateIndex(ctx, db, errors));
    }

    @Override
    public void exitCreate_extension_statement(Create_extension_statementContext ctx) {
        safeParseStatement(new CreateExtension(ctx, db, errors));
    }

    @Override
    public void exitCreate_trigger_statement(Create_trigger_statementContext ctx) {
        safeParseStatement(new CreateTrigger(ctx, db, errors));
    }

    @Override
    public void exitCreate_rewrite_statement(Create_rewrite_statementContext ctx) {
        safeParseStatement(new CreateRewrite(ctx, db, errors));
    }

    @Override
    public void exitCreate_function_statement(Create_function_statementContext ctx) {
        safeParseStatement(new CreateFunction(ctx, db, errors));
    }

    @Override
    public void exitCreate_sequence_statement(Create_sequence_statementContext ctx) {
        safeParseStatement(new CreateSequence(ctx, db, errors));
    }

    @Override
    public void exitCreate_schema_statement(Create_schema_statementContext ctx) {
        safeParseStatement(new CreateSchema(ctx, db, errors));
    }

    @Override
    public void exitCreate_view_statement(Create_view_statementContext ctx) {
        safeParseStatement(new CreateView(ctx, db, errors));
    }

    @Override
    public void exitCreate_type_statement(Create_type_statementContext ctx) {
        safeParseStatement(new CreateType(ctx, db, errors));
    }

    @Override
    public void exitCreate_domain_statement(Create_domain_statementContext ctx) {
        safeParseStatement(new CreateDomain(ctx, db, errors));
    }

    @Override
    public void exitComment_on_statement(Comment_on_statementContext ctx) {
        safeParseStatement(new CommentOn(ctx, db, errors));
    }

    @Override
    public void exitSet_statement(Set_statementContext ctx) {
        if (ctx.config_param_val.isEmpty()) {
            return;
        }
        String confParam = ctx.config_param.getText();
        // TODO set param values can be identifiers, quoted identifiers, string or other literals: improve handling
        String confValue = ctx.config_param_val.get(0).getText();

        switch (confParam.toLowerCase()) {
        case "search_path":
            db.setDefaultSchema(confValue);
            break;
        case "default_with_oids":
            oids = confValue;
            if (oids.equals("false")) {
                oids = null;
            }
            break;
        case "default_tablespace":
            tablespace = confValue;
            if (tablespace.isEmpty()
                    // special case for pg_dump's unset default_tablespace
                    // remove after good unquoting mechanism would be introduced
                    || tablespace.equals("''")) {
                tablespace = null;
            }
            break;
        }
    }

    @Override
    public void exitRule_common(Rule_commonContext ctx) {
        safeParseStatement(new CreateRule(ctx, db, errors));
    }

    @Override
    public void exitAlter_function_statement(Alter_function_statementContext ctx) {
        safeParseStatement(new AlterFunction(ctx, db, errors));
    }

    @Override
    public void exitAlter_schema_statement(Alter_schema_statementContext ctx) {
        safeParseStatement(new AlterSchema(ctx, db, errors));
    }

    @Override
    public void exitAlter_table_statement(Alter_table_statementContext ctx) {
        safeParseStatement(new AlterTable(ctx, db, errors));
    }

    @Override
    public void exitAlter_sequence_statement(Alter_sequence_statementContext ctx) {
        safeParseStatement(new AlterSequence(ctx, db, errors));
    }

    @Override
    public void exitAlter_view_statement(Alter_view_statementContext ctx) {
        safeParseStatement(new AlterView(ctx, db, errors));
    }

    @Override
    public void exitAlter_type_statement(Alter_type_statementContext ctx) {
        safeParseStatement(new AlterType(ctx, db, errors));
    }

    @Override
    public void exitAlter_domain_statement(Alter_domain_statementContext ctx) {
        safeParseStatement(new AlterDomain(ctx, db, errors));
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx){
        if(ctx.exception != null) {
            throw new MonitorCancelledRuntimeException();
        }
    }
}
