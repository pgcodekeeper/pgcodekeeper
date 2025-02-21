/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.parsers.antlr;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DaemonThreadFactory;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.fileutils.InputStreamProvider;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrContextProcessor.ChSqlContextProcessor;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrContextProcessor.SqlContextProcessor;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrContextProcessor.TSqlContextProcessor;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.MonitorCancelledRuntimeException;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.UnresolvedReferenceException;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHLexer;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.IgnoreListLexer;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.IgnoreListParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.PrivilegesLexer;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.PrivilegesParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLLexer;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLLexer;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser;
import ru.taximaxim.codekeeper.core.utils.Pair;

public final class AntlrParser {

    private static final int POOL_SIZE = Integer.max(1,
            Integer.getInteger(Consts.POOL_SIZE, Runtime.getRuntime().availableProcessors() - 1));

    private static final ExecutorService ANTLR_POOL =
            Executors.newFixedThreadPool(POOL_SIZE, new DaemonThreadFactory());

    private static volatile long pgParserLastStart;
    private static volatile long msParserLastStart;
    private static volatile long chParserLastStart;

    public static int getPoolSize() {
        return POOL_SIZE;
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
            List<Object> errors) throws IOException {
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
            String parsedObjectName, List<Object> errors) {
        return makeBasicParser(parserClass, new ANTLRInputStream(string), parsedObjectName, errors);
    }

    private static <T extends Parser> T makeBasicParser(Class<T> parserClass,
            ANTLRInputStream stream, String parsedObjectName, List<Object> errors) {
        return makeBasicParser(parserClass, stream, parsedObjectName, errors, 0, 0, 0);
    }

    public static <T extends Parser> T makeBasicParser(Class<T> parserClass, String string,
            String parsedObjectName, List<Object> errors, Token codeStart) {
        int offset = codeStart.getStartIndex();
        int lineOffset = codeStart.getLine() - 1;
        int inLineOffset = codeStart.getCharPositionInLine();
        return makeBasicParser(parserClass, new ANTLRInputStream(string),
                parsedObjectName, errors, offset, lineOffset, inLineOffset);
    }

    private static <T extends Parser> T makeBasicParser(Class<T> parserClass,
            ANTLRInputStream stream, String parsedObjectName, List<Object> errors,
            int offset, int lineOffset, int inLineOffset) {
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
        } else if (parserClass.isAssignableFrom(CHParser.class)) {
            lexer = new CHLexer(stream);
            parser = new CHParser(new CommonTokenStream(lexer));
            parser.setErrorHandler(new CustomChSQLAntlrErrorStrategy());
        } else if (parserClass.isAssignableFrom(IgnoreListParser.class)) {
            lexer = new IgnoreListLexer(stream);
            parser = new IgnoreListParser(new CommonTokenStream(lexer));
        } else if (parserClass.isAssignableFrom(PrivilegesParser.class)) {
            lexer = new PrivilegesLexer(stream);
            parser = new PrivilegesParser(new CommonTokenStream(lexer));
        } else {
            throw new IllegalArgumentException("Unknown parser class: " + parserClass);
        }

        CustomAntlrErrorListener err = new CustomAntlrErrorListener(
                parsedObjectName, errors, offset, lineOffset, inLineOffset);
        lexer.removeErrorListeners();
        lexer.addErrorListener(err);
        parser.removeErrorListeners();
        parser.addErrorListener(err);

        return parserClass.cast(parser);
    }

    public static void parseSqlStream(InputStreamProvider inputStream, String charsetName,
            String parsedObjectName, List<Object> errors, IProgressMonitor mon, int monitoringLevel,
            SqlContextProcessor listener, Queue<AntlrTask<?>> antlrTasks) {
        submitAntlrTask(antlrTasks, () -> {
            PgDiffUtils.checkCancelled(mon);
            try(InputStream stream = inputStream.getStream()) {
                SQLParser parser = makeBasicParser(SQLParser.class, stream,
                        charsetName, parsedObjectName, errors);
                parser.addParseListener(new CustomParseTreeListener(
                        monitoringLevel, mon == null ? new NullProgressMonitor() : mon));
                saveTimeOfLastParserStart(SQLParser.class);
                return new Pair<>(parser.sql(), (CommonTokenStream) parser.getTokenStream());
            } catch (MonitorCancelledRuntimeException mcre){
                throw new InterruptedException();
            }
        }, pair -> {
            try {
                listener.process(pair.getFirst(), pair.getSecond());
            } catch (UnresolvedReferenceException ex) {
                errors.add(CustomParserListener.handleUnresolvedReference(ex, parsedObjectName));
            }
        });
    }

    public static void parseTSqlStream(InputStreamProvider inputStream, String charsetName,
            String parsedObjectName, List<Object> errors, IProgressMonitor mon, int monitoringLevel,
            TSqlContextProcessor listener, Queue<AntlrTask<?>> antlrTasks) {
        submitAntlrTask(antlrTasks, () -> {
            PgDiffUtils.checkCancelled(mon);
            try(InputStream stream = inputStream.getStream()) {
                TSQLParser parser = makeBasicParser(TSQLParser.class,
                        stream, charsetName, parsedObjectName, errors);
                parser.addParseListener(new CustomParseTreeListener(
                        monitoringLevel, mon == null ? new NullProgressMonitor() : mon));
                saveTimeOfLastParserStart(TSQLParser.class);
                return new Pair<>((CommonTokenStream) parser.getInputStream(), parser.tsql_file());
            } catch (MonitorCancelledRuntimeException mcre){
                throw new InterruptedException();
            }
        }, pair -> {
            try {
                listener.process(pair.getSecond(), pair.getFirst());
            } catch (UnresolvedReferenceException ex) {
                errors.add(CustomParserListener.handleUnresolvedReference(ex, parsedObjectName));
            }
        });
    }

    public static void parseChSqlStream(InputStreamProvider inputStream, String charsetName, String parsedObjectName,
            List<Object> errors, IProgressMonitor mon, int monitoringLevel, ChSqlContextProcessor listener,
            Queue<AntlrTask<?>> antlrTasks) {
        submitAntlrTask(antlrTasks, () -> {
            PgDiffUtils.checkCancelled(mon);
            try (InputStream stream = inputStream.getStream()) {
                CHParser parser = makeBasicParser(CHParser.class, stream, charsetName, parsedObjectName, errors);
                parser.addParseListener(new CustomParseTreeListener(
                        monitoringLevel, mon == null ? new NullProgressMonitor() : mon));
                saveTimeOfLastParserStart(CHParser.class);
                return new Pair<>((CommonTokenStream) parser.getInputStream(), parser.ch_file());
            } catch (MonitorCancelledRuntimeException mcre) {
                throw new InterruptedException();
            }
        }, pair -> {
            try {
                listener.process(pair.getSecond(), pair.getFirst());
            } catch (UnresolvedReferenceException ex) {
                errors.add(CustomParserListener.handleUnresolvedReference(ex, parsedObjectName));
            }
        });
    }

    public static <T extends ParserRuleContext, P extends Parser>
    T parseSqlString(Class<P> parserClass, Function<P, T> parserEntry, String sql,
            String parsedObjectName, List<Object> errors) {
        Future<T> f = submitAntlrTask(() -> parserEntry.apply(
                makeBasicParser(parserClass, sql, parsedObjectName, errors)));
        try {
            saveTimeOfLastParserStart(parserClass);
            return f.get();
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
        if (t instanceof InterruptedException in) {
            throw in;
        }
        if (t instanceof IOException io) {
            throw io;
        }

        throw new IllegalStateException(ex);
    }

    public static void checkToClean(DatabaseType databaseType, long cleaningInterval) {
        long lastParserStart;
        switch (databaseType) {
        case CH:
            lastParserStart = chParserLastStart;
            break;
        case MS:
            lastParserStart = msParserLastStart;
            break;
        case PG:
            lastParserStart = pgParserLastStart;
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + databaseType);
        }
        if (lastParserStart != 0 && (cleaningInterval < System.currentTimeMillis() - lastParserStart)) {
            cleanParserCache(databaseType);
        }
    }

    private static void cleanParserCache(DatabaseType databaseType) {
        Class<? extends Parser> parserClazz;
        switch (databaseType) {
        case CH:
            chParserLastStart = 0;
            parserClazz = CHParser.class;
            break;
        case MS:
            msParserLastStart = 0;
            parserClazz = TSQLParser.class;
            break;
        case PG:
            pgParserLastStart = 0;
            parserClazz = SQLParser.class;
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + databaseType);
        }

        makeBasicParser(parserClazz, ";", "fake string to clean parser cache").getInterpreter().clearDFA();
    }

    public static void cleanCacheOfAllParsers() {
        if (pgParserLastStart != 0) {
            cleanParserCache(DatabaseType.PG);
        }
        if (msParserLastStart != 0) {
            cleanParserCache(DatabaseType.MS);
        }
        if (chParserLastStart != 0) {
            cleanParserCache(DatabaseType.CH);
        }
    }

    private static void saveTimeOfLastParserStart(Class<?> parserClass) {
        if (parserClass.isAssignableFrom(SQLParser.class)) {
            pgParserLastStart = System.currentTimeMillis();
        } else if (parserClass.isAssignableFrom(TSQLParser.class)) {
            msParserLastStart = System.currentTimeMillis();
        } else if (parserClass.isAssignableFrom(CHParser.class)) {
            chParserLastStart = System.currentTimeMillis();
        } else {
            throw new IllegalArgumentException("Unknown parser class: " + parserClass);
        }
    }

    private AntlrParser() {
        // only static
    }
}

class CustomParseTreeListener implements ParseTreeListener {
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

    private static final Logger LOG = LoggerFactory.getLogger(CustomAntlrErrorListener.class);

    private final String parsedObjectName;
    private final List<Object> errors;
    private final int offset;
    private final int lineOffset;
    private final int inLineOffset;

    public CustomAntlrErrorListener(String parsedObjectName, List<Object> errors,
            int offset, int lineOffset, int inLineOffset) {
        this.parsedObjectName = parsedObjectName;
        this.errors = errors;
        this.offset = offset;
        this.lineOffset = lineOffset;
        this.inLineOffset = inLineOffset;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
            int line, int charPositionInLine, String msg, RecognitionException e) {
        Token token = offendingSymbol instanceof Token t ? t : null;
        AntlrError error = new AntlrError(token, parsedObjectName, line, charPositionInLine, msg)
                .copyWithOffset(offset, lineOffset, inLineOffset);

        LOG.warn("ANTLR Error:\n{}", error);
        if (errors != null) {
            errors.add(error);
        }
    }
}
