package cz.startnet.utils.pgdiff.parsers.antlr;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;

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
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Tsql_fileContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.MonitorCancelledRuntimeException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import ru.taximaxim.codekeeper.apgdiff.DaemonThreadFactory;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.fileutils.InputStreamProvider;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class AntlrParser {

    private static final String POOL_SIZE = "ru.taximaxim.codekeeper.parser.poolsize";

    private static final ExecutorService ANTLR_POOL;

    private static volatile long pgParserLastStart;
    private static volatile long msParserLastStart;

    static {
        int count = Integer.getInteger(
                POOL_SIZE, Runtime.getRuntime().availableProcessors() - 1);
        ANTLR_POOL = Executors.newFixedThreadPool(
                Integer.max(1, count), new DaemonThreadFactory());
    }

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
            parser.setErrorHandler(new CustomSQLAntlrErrorStrategy());
        } else if (parserClass.isAssignableFrom(TSQLParser.class)) {
            lexer = new TSQLLexer(stream);
            parser = new TSQLParser(new CommonTokenStream(lexer));
            parser.setErrorHandler(new CustomTSQLAntlrErrorStrategy());
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

    public static void parseSqlStream(InputStreamProvider inputStream, String charsetName,
            String parsedObjectName, List<AntlrError> errors, IProgressMonitor mon, int monitoringLevel,
            SqlContextProcessor listener, Queue<AntlrTask<?>> antlrTasks)
                    throws InterruptedException {
        submitAntlrTask(antlrTasks, () -> {
            try(InputStream stream = inputStream.getStream()) {
                SQLParser parser = makeBasicParser(SQLParser.class, stream,
                        charsetName, parsedObjectName, errors);
                parser.addParseListener(new CustomParseTreeListener(
                        monitoringLevel, mon == null ? new NullProgressMonitor() : mon));
                saveTimeOfLastParserStart(false);
                SqlContext sqlCtx = parser.sql();
                return sqlCtx;
            } catch (MonitorCancelledRuntimeException mcre){
                throw new InterruptedException();
            }
        }, ctx -> {
            try {
                listener.process(ctx, null);
            } catch (UnresolvedReferenceException ex) {
                errors.add(CustomSQLParserListener.handleUnresolvedReference(ex, parsedObjectName));
            }
        });
    }

    public static void parseTSqlStream(InputStreamProvider inputStream, String charsetName,
            String parsedObjectName, List<AntlrError> errors, IProgressMonitor mon, int monitoringLevel,
            TSqlContextProcessor listener, Queue<AntlrTask<?>> antlrTasks)
                    throws InterruptedException {
        submitAntlrTask(antlrTasks, () -> {
            try(InputStream stream = inputStream.getStream()) {
                TSQLParser parser = makeBasicParser(TSQLParser.class,
                        stream, charsetName, parsedObjectName, errors);
                parser.addParseListener(new CustomParseTreeListener(
                        monitoringLevel, mon == null ? new NullProgressMonitor() : mon));
                saveTimeOfLastParserStart(true);
                Pair<TSQLParser, Tsql_fileContext> parserAndTSqlCtx = new Pair<>(parser, parser.tsql_file());
                return parserAndTSqlCtx;
            } catch (MonitorCancelledRuntimeException mcre){
                throw new InterruptedException();
            }
        }, pair -> {
            try {
                listener.process(pair.getSecond(),
                        (CommonTokenStream) pair.getFirst().getInputStream());
            } catch (UnresolvedReferenceException ex) {
                errors.add(CustomTSQLParserListener.handleUnresolvedReference(ex, parsedObjectName));
            }
        });
    }

    public static <T extends ParserRuleContext, P extends Parser>
    T parseSqlString(Class<P> parserClass, Function<P, T> parserEntry, String sql,
            String parsedObjectName, List<AntlrError> errors) {
        Future<T> f = submitAntlrTask(() -> parserEntry.apply(
                makeBasicParser(parserClass, sql, parsedObjectName, errors)));
        try {
            saveTimeOfLastParserStart(parserClass.isAssignableFrom(TSQLParser.class));
            T ctx = f.get();
            return ctx;
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(ex);
        } catch (ExecutionException ex) {
            throw new IllegalStateException(ex);
        }
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
        } catch (MonitorCancelledRuntimeException ex) {
            // finalizing parser listeners' cancellations will reach here
            throw new InterruptedException();
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

    public static void checkToClean(boolean isMsParser, long cleaningInterval) {
        long lastParserStart = isMsParser ? msParserLastStart : pgParserLastStart;
        if (lastParserStart != 0
                && (cleaningInterval < System.currentTimeMillis() - lastParserStart)) {
            cleanParserCache(isMsParser);
        }
    }

    private static void cleanParserCache(boolean isMsParser) {
        Class<? extends Parser> parserClazz = null;
        if (isMsParser) {
            msParserLastStart = 0;
            parserClazz = TSQLParser.class;
        } else {
            pgParserLastStart = 0;
            parserClazz = SQLParser.class;
        }
        makeBasicParser(parserClazz, ";", "fake string to clean parser cache")
        .getInterpreter().clearDFA();
    }

    public static void cleanCacheOfBothParsers() {
        if (pgParserLastStart != 0) {
            cleanParserCache(false);
        }
        if (msParserLastStart != 0) {
            cleanParserCache(true);
        }
    }

    private static void saveTimeOfLastParserStart(boolean isMsParser) {
        if (isMsParser) {
            msParserLastStart = System.currentTimeMillis();
            return;
        }
        pgParserLastStart = System.currentTimeMillis();
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
