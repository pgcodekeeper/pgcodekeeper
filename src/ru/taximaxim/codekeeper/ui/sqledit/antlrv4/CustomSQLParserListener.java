package ru.taximaxim.codekeeper.ui.sqledit.antlrv4;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import ru.taximaxim.codekeeper.ui.pgdbproject.parser.DBObjectsLocation;
import ru.taximaxim.codekeeper.ui.sqledit.antlrv4.SQLParser.Create_extension_statementContext;
import ru.taximaxim.codekeeper.ui.sqledit.antlrv4.SQLParser.Create_table_statementContext;

public class CustomSQLParserListener extends SQLParserBaseListener {
    
    private List<DBObjectsLocation> objLocation = new ArrayList<>();
    private Path filePath;

    public CustomSQLParserListener() {
        // TODO Auto-generated constructor stub
    }
    
    public CustomSQLParserListener(List<DBObjectsLocation> objLocation, Path filePath) {
        this.objLocation = objLocation;
        this.filePath = filePath;
    }
    @Override
    public void exitCreate_table_statement(Create_table_statementContext ctx) {
        int i = 0;
        while (ctx.n.identifier(i + 1) != null) {
            i++;
        }
        objLocation.add(new DBObjectsLocation(ctx.n.identifier(i).Identifier().toString(), ctx.n.identifier(i).getStart().getStartIndex(), filePath));
        System.out.println(ctx.n.identifier(i).Identifier() + " " + 
                ctx.n.identifier(i).getStart().getStartIndex() +" "+ ctx.n.identifier(i).getStart().getStopIndex());
    }
    
    @Override
    public void exitCreate_extension_statement(
            Create_extension_statementContext ctx) {
        objLocation.add(new DBObjectsLocation(ctx.name.Identifier().toString(), ctx.name.getStart().getStartIndex(), filePath));
        System.out.println(ctx.name.Identifier());
    }
}
