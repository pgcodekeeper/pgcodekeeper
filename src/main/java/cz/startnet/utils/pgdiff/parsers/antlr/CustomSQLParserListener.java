package cz.startnet.utils.pgdiff.parsers.antlr;

import java.nio.file.Path;
import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateTable;
import cz.startnet.utils.pgdiff.schema.PGObjLocation;
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
        PGObjLocation loc = null;
        objects.add(new CreateTable(ctx, filePath).getObject(loc));
        db.addObjLocation(loc);
    }

    
}
