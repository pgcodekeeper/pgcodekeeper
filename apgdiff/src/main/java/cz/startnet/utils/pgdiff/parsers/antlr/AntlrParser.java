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
import java.util.function.Function;
import java.util.function.Supplier;

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
import cz.startnet.utils.pgdiff.loader.jdbc.AntlrTask;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.SqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.TSqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Tsql_fileContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.MonitorCancelledRuntimeException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.DaemonThreadFactory;
import ru.taximaxim.codekeeper.apgdiff.Log;

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
                    throws IOException, InterruptedException {
        try {
            submitAntlrTask(antlrTasks, () -> {
                SQLParser parser;
                // TODO подумать что нужно делать с finalizer-ом если ctx == null
                SqlContext ctx = null;
                try {
                    parser = makeBasicParser(SQLParser.class, inputStream,
                            charsetName, parsedObjectName, errors);
                    parser.addParseListener(new CustomParseTreeListener(
                            monitoringLevel, mon == null ? new NullProgressMonitor() : mon));
                    ctx = parser.sql();
                } catch (IOException e) {
                    // TODO проверить какие ошибки могут вылетать
                    // TODO подумать над тема как можно по другому обрабатывать ошибку
                    errors.add(CustomParserListener
                            .handleParserContextException(e, parsedObjectName, ctx));
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        errors.add(CustomParserListener
                                .handleParserContextException(e, parsedObjectName, ctx));
                    }
                }
                return ctx;
            }, ctx -> listeners.forEach(listener -> listener.process(ctx, null)), null);
        } catch (MonitorCancelledRuntimeException mcre){
            throw new InterruptedException();
        } catch (UnresolvedReferenceException ex) {
            errors.add(CustomSQLParserListener.handleUnresolvedReference(ex, parsedObjectName));
        }
    }

    public static void parseTSqlStream(InputStream inputStream, String charsetName,
            String parsedObjectName, List<AntlrError> errors,IProgressMonitor mon, int monitoringLevel,
            Collection<TSqlContextProcessor> listeners, Queue<AntlrTask<?>> antlrTasks)
                    throws IOException, InterruptedException {
        try {
            // TODO сделать подкласс AntlrTask'a у которого будет еще CommonTokenStream
            TSQLParser parser = submitTask(() -> makeBasicParser(TSQLParser.class,
                    inputStream, charsetName, parsedObjectName, errors)).get();

            submitAntlrTask(antlrTasks, () -> {
                Tsql_fileContext ctx = null;
                try {
                    parser.addParseListener(new CustomParseTreeListener(
                            monitoringLevel, mon == null ? new NullProgressMonitor() : mon));
                    ctx = parser.tsql_file();
                }
                finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        errors.add(CustomParserListener
                                .handleParserContextException(e, parsedObjectName, ctx));
                    }
                }
                return ctx;
            }, ctx -> listeners.forEach(listener -> listener.process(ctx,
                    (CommonTokenStream) parser.getInputStream())), null);
        } catch (MonitorCancelledRuntimeException mcre){
            throw new InterruptedException();
        } catch (UnresolvedReferenceException ex) {
            errors.add(CustomTSQLParserListener.handleUnresolvedReference(ex, parsedObjectName));
        } catch (ExecutionException ee) {
            AntlrError err = new AntlrError(null, parsedObjectName, 0, 0,  ee.getMessage());
            Log.log(Log.LOG_ERROR, err.toString(), ee);
            errors.add(err);
        }
    }

    public static <C> Future<C> submitTask(Callable<C> task) {
        return ANTLR_POOL.submit(task);
    }

    // TODO !!! СДЕЛАТЬ в первую очередь !!! Supplier<C> parserCtxReader заменить на callable
    public static <C> void submitAntlrTask(Queue<AntlrTask<?>> antlrTasks,
            Supplier<C> parserCtxReader, Consumer<C> finalizer,
            GenericColumn currentObject) {
        Future<C> future = submitTask(parserCtxReader::get);
        antlrTasks.add(new AntlrTask<>(future, finalizer, currentObject));
    }

    public static <P, C> void submitAntlrTask(Queue<AntlrTask<?>> antlrTasks,
            Function<P, C> parserCtxReader, P parser, Consumer<C> finalizer,
            GenericColumn currentObject) {
        Future<C> future = submitTask(() -> parserCtxReader.apply(parser));
        antlrTasks.add(new AntlrTask<>(future, finalizer, currentObject));
    }

    public static void finishAntlr(Queue<AntlrTask<?>> antlrTasks,
            Consumer<String> setCurrentOperation, Consumer<GenericColumn> setCurrentObject)
                    throws InterruptedException, ExecutionException {
        AntlrTask<?> task;
        if (setCurrentOperation != null) {
            setCurrentOperation.accept("finalizing antlr");
        }
        while ((task = antlrTasks.poll()) != null) {
            if (setCurrentObject != null) {
                // default to operation if object is null
                setCurrentObject.accept(task.getObject());
            }
            task.finish();
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