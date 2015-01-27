package cz.startnet.utils.pgdiff.parsers.antlr;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;

public class AntlrParser {
        
    private final IProgressMonitor monitor;
    private final int monitoringLevel;
    
    public AntlrParser(IProgressMonitor mon, int monitoringLevel) {
        monitor = mon == null ? new NullProgressMonitor() : mon;        
        this.monitoringLevel = monitoringLevel;
    }
    
    public void parseInputStream(InputStream inputStream,
            String charsetName, CustomSQLParserListener listener) throws IOException {

        SQLLexer lexer = new SQLLexer(new ANTLRInputStream(new InputStreamReader(inputStream, charsetName)));
        lexer.removeErrorListeners();
        CustomErrorListener.INSTATANCE.setPath(listener.getPath());
        lexer.addErrorListener(CustomErrorListener.INSTATANCE);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SQLParser parser = new SQLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(CustomErrorListener.INSTATANCE);
        parser.addParseListener(new ParseTreeListener() {
            
            @Override
            public void visitTerminal(TerminalNode node) {
                
            }
            
            @Override
            public void visitErrorNode(ErrorNode node) {
                
            }
            
            @Override
            public void exitEveryRule(ParserRuleContext ctx) {
                if (ctx.depth() <= monitoringLevel){
                    monitor.worked(1);
                }
            }
            
            @Override
            public void enterEveryRule(ParserRuleContext ctx) {
                
            }
        });
        
        ParseTreeWalker walker = new ParseTreeWalker();
        SqlContext ctx = parser.sql();
        walker.walk(listener, ctx);
    }
    
}