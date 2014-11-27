package cz.startnet.utils.pgdiff.parsers.antlr;

import java.nio.file.Path;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_event_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_extension_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_language_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_trigger_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateExtension;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateFunction;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateIndex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateSchema;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateSequence;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateTrigger;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateView;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CustomSQLParserListener extends SQLParserBaseListener {

    private PgDatabase db;
    private Path filePath;
    private List<PgStatement> objects;

    public CustomSQLParserListener(List<PgStatement> objects,
            PgDatabase database, Path filePath) {
        this.db = database;
        this.filePath = filePath;
        this.objects = objects;
    }

    @Override
    public void exitCreate_table_statement(Create_table_statementContext ctx) {
        objects.add(new CreateTable(ctx, db, filePath).getObject());
    }

    @Override
    public void exitIndex_statement(Index_statementContext ctx) {
        objects.add(new CreateIndex(ctx, db, filePath).getObject());
    }
    
    @Override
    public void exitCreate_extension_statement(
            Create_extension_statementContext ctx) {
        objects.add(new CreateExtension(ctx, db, filePath).getObject());
    }
    
    @Override
    public void exitCreate_trigger_statement(Create_trigger_statementContext ctx) {
        objects.add(new CreateTrigger(ctx, db, filePath).getObject());
    }
    
    @Override
    public void exitCreate_function_statement(
            Create_function_statementContext ctx) {
        objects.add(new CreateFunction(ctx, db, filePath).getObject());
    }
    
    @Override
    public void exitCreate_sequence_statement(
            Create_sequence_statementContext ctx) {
        objects.add(new CreateSequence(ctx, db, filePath).getObject());
    }
    
    @Override
    public void exitCreate_schema_statement(Create_schema_statementContext ctx) {
        objects.add(new CreateSchema(ctx, db, filePath).getObject());
    }
    
    @Override
    public void exitCreate_view_statement(Create_view_statementContext ctx) {
        objects.add(new CreateView(ctx, db, filePath).getObject());
    }
    
    @Override
    public void exitCreate_language_statement(
            Create_language_statementContext ctx) {
//        objects.add(new CreateLanguage(ctx, db, filePath).getObject());
    }
    
    @Override
    public void exitCreate_event_trigger(Create_event_triggerContext ctx) {
//        objects.add(new CreateEventTrigger(ctx, db, filePath).getObject());
    }
    
    
}
