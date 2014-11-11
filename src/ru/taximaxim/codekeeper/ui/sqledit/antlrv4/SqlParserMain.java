package ru.taximaxim.codekeeper.ui.sqledit.antlrv4;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ru.taximaxim.codekeeper.ui.pgdbproject.parser.DBObjectsLocation;

public class SqlParserMain {
    public static void main(String[] args) throws IOException {
        String pathToFile = "/home/botov_av/workspace/codekeeper/ru.taximaxim.codekeeper.ui/src/ru/taximaxim/codekeeper/ui/sqledit/antlrv4/information_schema.sql";
        List<DBObjectsLocation> objLocation = new ArrayList<>();
        new SqlParserMain().testSampleInputs(
                        pathToFile,
                        new CustomSQLParserListener(objLocation, Paths.get("/")));
        System.err.println(objLocation);
    }
    public void testSampleInputs(String pathToFile, ParseTreeListener listener) throws IOException {
        String input = loadSample(pathToFile, "UTF-8");

        SQLLexer lexer = new SQLLexer(new ANTLRInputStream(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        SQLParser parser = new SQLParser(tokens);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, parser.sql());
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
}