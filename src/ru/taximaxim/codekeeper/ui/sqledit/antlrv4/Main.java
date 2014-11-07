package ru.taximaxim.codekeeper.ui.sqledit.antlrv4;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ru.taximaxim.codekeeper.ui.sqledit.antlrv4.SQLParser.Create_extension_statementContext;
import ru.taximaxim.codekeeper.ui.sqledit.antlrv4.SQLParser.Create_table_statementContext;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().testSampleInputs();
    }
    public void testSampleInputs() throws IOException {
        String input = loadSample("/home/botov_av/workspace/AntLrTest/src/org/antlr/v4/runtime/information_schema.sql", "UTF-8");

        SQLLexer lexer = new SQLLexer(new ANTLRInputStream(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        SQLParser parser = new SQLParser(tokens);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new SQLParserListener(), parser.sql());
    }

    protected String loadSample(String fileName, String encoding) throws IOException
    {
        if ( fileName==null ) {
            return null;
        }

        String fullFileName = fileName;
        int size = 1024 * 1024;
        InputStreamReader isr;
        InputStream fis = Files.newInputStream(Paths.get(fullFileName));
        if ( encoding!=null ) {
            isr = new InputStreamReader(fis, encoding);
        }
        else {
            isr = new InputStreamReader(fis);
        }
        try {
            char[] data = new char[size];
            int n = isr.read(data);
            return new String(data, 0, n);
        }
        finally {
            isr.close();
        }
    }

    class SQLParserListener extends SQLParserBaseListener {
        
        @Override
        public void exitCreate_table_statement(Create_table_statementContext ctx) {
            int i = 0;
            while (ctx.n.identifier(i + 1) != null) {
                i++;
            }
            System.out.println(ctx.n.identifier(i).Identifier() + " " + 
                    ctx.n.identifier(i).getStart().getStartIndex() +" "+ ctx.n.identifier(i).getStart().getStopIndex());
        }
        
        @Override
        public void exitCreate_extension_statement(
                Create_extension_statementContext ctx) {
            System.out.println(ctx.name.Identifier());
        }
    }
}