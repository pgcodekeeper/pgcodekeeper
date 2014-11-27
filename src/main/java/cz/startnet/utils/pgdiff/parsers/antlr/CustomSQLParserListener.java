package cz.startnet.utils.pgdiff.parsers.antlr;

import java.nio.file.Path;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_extension_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateExtension;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateIndex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateTable;
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
}
