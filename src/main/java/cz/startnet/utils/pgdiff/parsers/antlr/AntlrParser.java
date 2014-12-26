package cz.startnet.utils.pgdiff.parsers.antlr;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class AntlrParser {

    public void parseInputStream(InputStream inputStream,
            String charsetName, CustomSQLParserListener listener) throws IOException {

        SQLLexer lexer = new SQLLexer(new ANTLRInputStream(new InputStreamReader(inputStream, charsetName)));
        lexer.removeErrorListeners();
        lexer.addErrorListener(CustomErrorListener.INSTATANCE);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SQLParser parser = new SQLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(CustomErrorListener.INSTATANCE);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, parser.sql());
    }
}