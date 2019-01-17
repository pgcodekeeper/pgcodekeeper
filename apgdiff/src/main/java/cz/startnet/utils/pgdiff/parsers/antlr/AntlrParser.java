package cz.startnet.utils.pgdiff.parsers.antlr;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.SqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.TSqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.MonitorCancelledRuntimeException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import ru.taximaxim.codekeeper.apgdiff.DaemonThreadFactory;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class AntlrParser {

    private static final ExecutorService ANTLR_POOL = Executors.newFixedThreadPool(
            Integer.max(1, Runtime.getRuntime().availableProcessors() - 1),
            new DaemonThreadFactory());

    /**
     * Constructs a <code>parserClass</code> {@link Parser} object with the stream as the token source
     * and {@link CustomAntlrErrorListener} as parser and lexer error listener.
     */
    public static <T extends Parser> T makeBasicParser(Class<T> parserClass,
            InputStream stream, String charset, String parsedObjectName) throws IOException {
        return makeBasicParser(
                parserClass, new ANTLRInputStream(new InputStreamReader(stream, charset)),
                parsedObjectName, null);
    }

    public static <T extends Parser> T makeBasicParser(Class<T> parserClass,
            InputStream stream, String charset, String parsedObjectName,
            List<AntlrError> errors) throws IOException {
        return makeBasicParser(
                parserClass, new ANTLRInputStream(new InputStreamReader(stream, charset)),
                parsedObjectName, errors);
    }

    /**
     * Constructs a <code>parserClass</code> {@link Parser} object with the string as the token source
     * and {@link CustomAntlrErrorListener} as parser and lexer error listener.
     */
    public static <T extends Parser> T makeBasicParser(Class<T> parserClass, String string,
            String parsedObjectName) {
        return makeBasicParser(parserClass, new ANTLRInputStream(string), parsedObjectName, null);
    }

    public static <T extends Parser> T makeBasicParser(Class<T> parserClass, String string,
            String parsedObjectName, List<AntlrError> errors) {
        return makeBasicParser(parserClass, new ANTLRInputStream(string), parsedObjectName, errors);
    }

    private static <T extends Parser> T makeBasicParser(Class<T> parserClass,
            ANTLRInputStream stream, String parsedObjectName, List<AntlrError> errors) {
        Lexer lexer;
        Parser parser;
        if (parserClass.isAssignableFrom(SQLParser.class)) {
            lexer = new SQLLexer(stream);
            parser = new SQLParser(new CommonTokenStream(lexer));
        } else if (parserClass.isAssignableFrom(TSQLParser.class)) {
            lexer = new TSQLLexer(stream);
            parser = new TSQLParser(new CommonTokenStream(lexer));
        } else if (parserClass.isAssignableFrom(IgnoreListParser.class)) {
            lexer = new IgnoreListLexer(stream);
            parser = new IgnoreListParser(new CommonTokenStream(lexer));
        } else if (parserClass.isAssignableFrom(PrivilegesParser.class)) {
            lexer = new PrivilegesLexer(stream);
            parser = new PrivilegesParser(new CommonTokenStream(lexer));
        } else {
            throw new IllegalArgumentException("Unknown parser class: " + parserClass);
        }

        CustomAntlrErrorListener err = new CustomAntlrErrorListener(parsedObjectName, errors);
        lexer.removeErrorListeners();
        lexer.addErrorListener(err);
        parser.removeErrorListeners();
        parser.addErrorListener(err);

        return parserClass.cast(parser);
    }

    public static void parseSqlStream(InputStream inputStream, String charsetName,
            String parsedObjectName, List<AntlrError> errors, IProgressMonitor mon, int monitoringLevel,
            Collection<SqlContextProcessor> listeners, Queue<AntlrTask<?>> antlrTasks)
                    throws InterruptedException {
        submitAntlrTask(antlrTasks, () -> {
            try(InputStream forAutoCloseInputStream = inputStream) {
                SQLParser parser = makeBasicParser(SQLParser.class, inputStream,
                        charsetName, parsedObjectName, errors);
                parser.addParseListener(new CustomParseTreeListener(
                        monitoringLevel, mon == null ? new NullProgressMonitor() : mon));
                return parser.sql();
            } catch (MonitorCancelledRuntimeException mcre){
                throw new InterruptedException();
            }
        }, ctx -> {
            try {
                listeners.forEach(listener -> listener.process(ctx, null));
            } catch (UnresolvedReferenceException ex) {
                errors.add(CustomSQLParserListener.handleUnresolvedReference(ex, parsedObjectName));
            }
        });
    }

    public static void parseTSqlStream(InputStream inputStream, String charsetName,
            String parsedObjectName, List<AntlrError> errors,IProgressMonitor mon, int monitoringLevel,
            Collection<TSqlContextProcessor> listeners, Queue<AntlrTask<?>> antlrTasks)
                    throws InterruptedException {
        submitAntlrTask(antlrTasks, () -> {
            try(InputStream forAutoCloseInputStream = inputStream) {
                TSQLParser parser = makeBasicParser(TSQLParser.class,
                        inputStream, charsetName, parsedObjectName, errors);
                parser.addParseListener(new CustomParseTreeListener(
                        monitoringLevel, mon == null ? new NullProgressMonitor() : mon));
                return new Pair<>(parser, parser.tsql_file());
            } catch (MonitorCancelledRuntimeException mcre){
                throw new InterruptedException();
            }
        }, pair -> {
            try {
                listeners.forEach(listener -> listener.process(pair.getSecond(),
                        (CommonTokenStream) pair.getFirst().getInputStream()));
            } catch (UnresolvedReferenceException ex) {
                errors.add(CustomTSQLParserListener.handleUnresolvedReference(ex, parsedObjectName));
            }
        });
    }

    public static <T> Future<T> submitAntlrTask(Callable<T> task) {
        return ANTLR_POOL.submit(task);
    }

    public static <T> void submitAntlrTask(Queue<AntlrTask<?>> antlrTasks,
            Callable<T> task, Consumer<T> finalizer) {
        Future<T> future = submitAntlrTask(task);
        antlrTasks.add(new AntlrTask<>(future, finalizer));
    }

    public static void finishAntlr(Queue<AntlrTask<?>> antlrTasks)
            throws InterruptedException, IOException {
        AntlrTask<?> task;
        try {
            while ((task = antlrTasks.poll()) != null) {
                task.finish();
            }
        } catch (ExecutionException ex) {
            handleAntlrTaskException(ex);
        }
    }

    /**
     * Uwraps potential parser Interrupted and IO Exceptions from ExecutionException.<br>
     * If non-standard parser exception is caught in the wrapper, it is rethrown
     * as an IllegalStateException.
     *
     * @throws InterruptedException
     * @throws IOException
     * @throws IllegalStateException
     */
    public static void handleAntlrTaskException(ExecutionException ex)
            throws InterruptedException, IOException {
        Throwable t = ex.getCause();
        if (t instanceof InterruptedException) {
            throw (InterruptedException) t;
        } else if (t instanceof IOException) {
            throw (IOException) t;
        } else {
            throw new IllegalStateException(ex);
        }
    }

    private AntlrParser() {
        // only static
    }
}

class CustomParseTreeListener implements ParseTreeListener{
    private final int monitoringLevel;
    private final IProgressMonitor monitor;

    public CustomParseTreeListener(int monitoringLevel, IProgressMonitor monitor){
        this.monitoringLevel = monitoringLevel;
        this.monitor = monitor;
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        //no imp
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        //no imp
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if (ctx.depth() <= monitoringLevel) {
            monitor.worked(1);
            try {
                PgDiffUtils.checkCancelled(monitor);
            } catch (InterruptedException e) {
                throw new MonitorCancelledRuntimeException();
            }
        }
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        //no imp
    }
}

class CustomAntlrErrorListener extends BaseErrorListener {

    private final String parsedObjectName;
    private final List<AntlrError> errors;

    public CustomAntlrErrorListener(String parsedObjectName, List<AntlrError> errors) {
        this.parsedObjectName = parsedObjectName;
        this.errors = errors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
            Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        Log.log(Log.LOG_WARNING, "ANTLR Error:\n"
                + parsedObjectName + " line " + line + ':' + charPositionInLine
                + ' ' + msg);
        if (errors != null) {
            Token token = offendingSymbol instanceof Token ? (Token) offendingSymbol : null;
            errors.add(new AntlrError(token, parsedObjectName, line, charPositionInLine, msg));
        }
    }
}