package ru.taximaxim.codekeeper.ui.sqledit.antlrv4;

import java.nio.file.Path;
import java.util.List;

import ru.taximaxim.codekeeper.ui.pgdbproject.parser.DBObjectsLocation;
import ru.taximaxim.codekeeper.ui.sqledit.antlrv4.SQLParser.Create_extension_statementContext;
import ru.taximaxim.codekeeper.ui.sqledit.antlrv4.SQLParser.Create_table_statementContext;
import ru.taximaxim.codekeeper.ui.sqledit.antlrv4.SQLParser.Create_trigger_statementContext;
import ru.taximaxim.codekeeper.ui.sqledit.antlrv4.SQLParser.Grant_statementContext;
import ru.taximaxim.codekeeper.ui.sqledit.antlrv4.SQLParser.Set_statementContext;

public class CustomSQLParserListener extends SQLParserBaseListener {
    
    private List<DBObjectsLocation> objLocation;
    private Path filePath;

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
    }
    
    @Override
    public void exitCreate_extension_statement(
            Create_extension_statementContext ctx) {
        objLocation.add(new DBObjectsLocation(ctx.name.Identifier().toString(), ctx.name.getStart().getStartIndex(), filePath));
    }
    
    @Override
    public void exitCreate_trigger_statement(Create_trigger_statementContext ctx) {
        objLocation.add(new DBObjectsLocation(ctx.name.Identifier().toString(), ctx.name.getStart().getStartIndex(), filePath));
    }
    
    @Override
    public void exitGrant_statement(Grant_statementContext ctx) {
        objLocation.add(new DBObjectsLocation(ctx.schema_name.Identifier().toString(), ctx.schema_name.getStart().getStartIndex(), filePath));
    }
    
    @Override
    public void exitSet_statement(Set_statementContext ctx) {
        objLocation.add(new DBObjectsLocation(ctx.config_param.Identifier().toString(), ctx.config_param.getStart().getStartIndex(), filePath));
    }
}
