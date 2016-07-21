package ru.taximaxim.codekeeper.ui.antlr;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.ui.antlr.SQLIgnoreParser.CompileUnitContext;

public class AntlrParser {

    /**
     * Constructs a {@link SQLParser} object with the stream as the token source
     * and {@link CustomSQLErrorListener} as parser and lexer error listener.
     */
    public static SQLIgnoreParser makeBasicParser(InputStream stream, String charset,
            String parsedObjectName) throws IOException {
        return makeBasicParser(
                new ANTLRInputStream(new InputStreamReader(stream, charset)),
                parsedObjectName);
    }

    /**
     * Constructs a {@link SQLParser} object with the string as the token source
     * and {@link CustomSQLErrorListener} as parser and lexer error listener.
     */
    public static SQLIgnoreParser makeBasicParser(String string, String parsedObjectName) {
        return makeBasicParser(new ANTLRInputStream(string), parsedObjectName);
    }

    private static SQLIgnoreParser makeBasicParser(ANTLRInputStream stream, String parsedObjectName) {
        CustomSQLErrorListener errListener = new CustomSQLErrorListener(parsedObjectName);

        SQLIgnoreLexer lexer = new SQLIgnoreLexer(stream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errListener);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SQLIgnoreParser parser = new SQLIgnoreParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errListener);

        return parser;
    }

    public static void parseInputStream(InputStream inputStream, String charsetName,
            String parsedObjectName, SQLIgnoreBaseListener listener) throws IOException {
        SQLIgnoreParser parser = makeBasicParser(inputStream, charsetName, parsedObjectName);

        //final IProgressMonitor monitor = mon == null ? new NullProgressMonitor() : mon;
        parser.addParseListener(new ParseTreeListener() {

            @Override
            public void visitTerminal(TerminalNode node) {
            }

            @Override
            public void visitErrorNode(ErrorNode node) {
            }

            @Override
            public void exitEveryRule(ParserRuleContext ctx) {
            }

            @Override
            public void enterEveryRule(ParserRuleContext ctx) {
            }
        });

        CompileUnitContext ctx = parser.compileUnit();
        ParseTreeWalker.DEFAULT.walk(listener, ctx);
    }
}

class CustomSQLErrorListener extends BaseErrorListener {

    private final String parsedObjectName;

    public CustomSQLErrorListener(String parsedObjectName) {
        this.parsedObjectName = parsedObjectName;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
            Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        Log.log(Log.LOG_WARNING, "ANTLR Error:\n"
                + parsedObjectName + " line " + line + ':' + charPositionInLine
                + ' ' + msg, e);
    }
}