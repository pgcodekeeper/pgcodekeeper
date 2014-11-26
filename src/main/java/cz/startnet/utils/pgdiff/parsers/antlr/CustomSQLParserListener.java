package cz.startnet.utils.pgdiff.parsers.antlr;

import java.nio.file.Path;
import java.util.List;

import org.antlr.v4.runtime.misc.Interval;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_column_nameContext;
import cz.startnet.utils.pgdiff.schema.PGObjLocation;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;



public class CustomSQLParserListener extends SQLParserBaseListener {
    
    private PgDatabase db;
    private Path filePath;
    private List<PgStatement> objects;

    public CustomSQLParserListener(List<PgStatement> objects, PgDatabase database, Path filePath) {
        this.db = database;
        this.filePath = filePath;
        this.objects = objects;
    }
    @Override
    public void exitCreate_table_statement(Create_table_statementContext ctx) {
        int i = 0;
        if (ctx.name == null) {
            return;
        }
        while (ctx.name.identifier(i + 1) != null) {
            i++;
        }
        
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        Interval interval = new Interval(a,b);
        ctx.start.getInputStream().getText(interval);
        PgTable table = new PgTable(ctx.name.identifier(i).getText(), 
                "CREATE " + ctx.start.getInputStream().getText(interval), "");
        for (Table_column_defContext name : ctx.table_col_def) {
            if (name.table_column_name() != null) {
                table.addColumn(new PgColumn(name.table_column_name().getText()));
            }
            if (name.table_constraint()!= null && 
                    name.table_constraint().identifier != null) {
                table.addColumn(new PgColumn(name.table_constraint().identifier.getText()));
                
            }
        }
        objects.add(table);
        db.addObjLocation(new PGObjLocation(ctx.name.identifier(i).getText(), 
                ctx.name.getStart().getStartIndex(), filePath));
    }
}
