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
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.List;
import java.util.Queue;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
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
import ru.taximaxim.codekeeper.core.utils.InputStreamProvider;
import ru.taximaxim.codekeeper.core.utils.Pair;

public final class AntlrParser {

    private static volatile long pgParserLastStart;
    private static volatile long msParserLastStart;
    private static volatile long chParserLastStart;

    public static IgnoreListParser createIgnoreListParser(Path listFile) throws IOException {
        String parsedObjectName = listFile.toString();
        var stream = CharStreams.fromPath(listFile);
        Lexer lexer = new IgnoreListLexer(stream);
        IgnoreListParser parser = new IgnoreListParser(new CommonTokenStream(lexer));
        addErrorListener(lexer, parser, parsedObjectName, null, 0, 0, 0);
        return parser;
    }

    public static PrivilegesParser createPrivilegesParser(String aclArrayAsString) {
        var stream = CharStreams.fromString(aclArrayAsString);
        Lexer lexer = new PrivilegesLexer(stream);
        PrivilegesParser parser = new PrivilegesParser(new CommonTokenStream(lexer));
        addErrorListener(lexer, parser, "jdbc privileges", null, 0, 0, 0);
        return parser;
    }

    public static SQLParser createSQLParser(String sql, String parsedObjectName, List<Object> errors) {
        var stream = CharStreams.fromString(sql);
        return createSQLParser(stream, parsedObjectName, errors, 0, 0, 0);
    }

    public static SQLParser createSQLParser(String sql, String parsedObjectName, List<Object> errors, Token start) {
        var stream = CharStreams.fromString(sql);
        CodeUnitToken cuCodeStart = (CodeUnitToken) start;
        int offset = cuCodeStart.getCodeUnitStart();
        int lineOffset = cuCodeStart.getLine() - 1;
        int inLineOffset = cuCodeStart.getCodeUnitPositionInLine();
        return createSQLParser(stream, parsedObjectName, errors, offset, lineOffset, inLineOffset);
    }

    public static SQLParser createSQLParser(InputStream is, String charset, String parsedObjectName,
            List<Object> errors) throws IOException {
        var stream = CharStreams.fromStream(is, Charset.forName(charset));
        return createSQLParser(stream, parsedObjectName, errors, 0, 0, 0);
    }

    private static SQLParser createSQLParser(CharStream stream, String parsedObjectName, List<Object> errors,
            int offset, int lineOffset, int inLineOffset) {
        SQLLexer lexer = new SQLLexer(stream);
        SQLParser parser = new SQLParser(new CommonTokenStream(lexer));
        addErrorListener(lexer, parser, parsedObjectName, errors, offset, lineOffset, inLineOffset);
        pgParserLastStart = System.currentTimeMillis();
        return parser;
    }

    public static TSQLParser createTSQLParser(String sql, String parsedObjectName, List<Object> errors) {
        var stream = CharStreams.fromString(sql);
        return createTSQLParser(stream, parsedObjectName, errors);
    }

    public static TSQLParser createTSQLParser(InputStream is, String charset, String parsedObjectName,
            List<Object> errors) throws IOException {
        var stream = CharStreams.fromStream(is, Charset.forName(charset));
        return createTSQLParser(stream, parsedObjectName, errors);
    }

    private static TSQLParser createTSQLParser(CharStream stream, String parsedObjectName, List<Object> errors) {
        TSQLLexer lexer = new TSQLLexer(stream);
        TSQLParser parser = new TSQLParser(new CommonTokenStream(lexer));
        addErrorListener(lexer, parser, parsedObjectName, errors, 0, 0, 0);
        msParserLastStart = System.currentTimeMillis();
        return parser;
    }

    public static CHParser createCHParser(String sql, String parsedObjectName, List<Object> errors) {
        var stream = CharStreams.fromString(sql);
        return createCHParser(stream, parsedObjectName, errors);
    }

    public static CHParser createCHParser(InputStream is, String charset, String parsedObjectName,
            List<Object> errors) throws IOException {
        var stream = CharStreams.fromStream(is, Charset.forName(charset));
        return createCHParser(stream, parsedObjectName, errors);
    }

    private static CHParser createCHParser(CharStream stream, String parsedObjectName, List<Object> errors) {
        Lexer lexer = new CHLexer(stream);
        CHParser parser = new CHParser(new CommonTokenStream(lexer));
        addErrorListener(lexer, parser, parsedObjectName, errors, 0, 0, 0);
        chParserLastStart = System.currentTimeMillis();
        return parser;
    }

    private static void addErrorListener(Lexer lexer, Parser parser, String parsedObjectName,
            List<Object> errors, int offset, int lineOffset, int inLineOffset) {
        var listener = new CustomAntlrErrorListener(parsedObjectName, errors, offset, lineOffset, inLineOffset);
        lexer.removeErrorListeners();
        lexer.addErrorListener(listener);
        parser.removeErrorListeners();
        parser.addErrorListener(listener);
    }

    public static void parseSqlStream(InputStreamProvider inputStream, String charsetName,
            String parsedObjectName, List<Object> errors, IProgressMonitor mon, int monitoringLevel,
            SqlContextProcessor listener, Queue<AntlrTask<?>> antlrTasks) {
        AntlrTaskManager.submit(antlrTasks, () -> {
            PgDiffUtils.checkCancelled(mon);
            try (InputStream stream = inputStream.getStream()) {
                var parser = createSQLParser(stream, charsetName, parsedObjectName, errors);
                parser.addParseListener(new CustomParseTreeListener(
                        monitoringLevel, mon == null ? new NullProgressMonitor() : mon));
                return new Pair<>(parser.sql(), (CommonTokenStream) parser.getTokenStream());
            } catch (MonitorCancelledRuntimeException mcre) {
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
        AntlrTaskManager.submit(antlrTasks, () -> {
            PgDiffUtils.checkCancelled(mon);
            try (InputStream stream = inputStream.getStream()) {
                var parser = createTSQLParser(stream, charsetName, parsedObjectName, errors);
                parser.addParseListener(new CustomParseTreeListener(
                        monitoringLevel, mon == null ? new NullProgressMonitor() : mon));
                return new Pair<>((CommonTokenStream) parser.getInputStream(), parser.tsql_file());
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

    public static void parseChSqlStream(InputStreamProvider inputStream, String charsetName, String parsedObjectName,
            List<Object> errors, IProgressMonitor mon, int monitoringLevel, ChSqlContextProcessor listener,
            Queue<AntlrTask<?>> antlrTasks) {
        AntlrTaskManager.submit(antlrTasks, () -> {
            PgDiffUtils.checkCancelled(mon);
            try (InputStream stream = inputStream.getStream()) {
                var parser = createCHParser(stream, charsetName, parsedObjectName, errors);
                parser.addParseListener(new CustomParseTreeListener(
                        monitoringLevel, mon == null ? new NullProgressMonitor() : mon));
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

    public static void checkToClean(long cleaningInterval) {
        checkToClean(cleaningInterval, chParserLastStart, DatabaseType.CH);
        checkToClean(cleaningInterval, msParserLastStart, DatabaseType.MS);
        checkToClean(cleaningInterval, pgParserLastStart, DatabaseType.PG);
    }

    private static void checkToClean(long cleaningInterval, long parserLastStart, DatabaseType dbType) {
        if (parserLastStart != 0 && (cleaningInterval < System.currentTimeMillis() - parserLastStart)) {
            cleanParserCache(dbType);
        }
    }

    private static void cleanParserCache(DatabaseType databaseType) {
        String sql = ";";
        String parsedObjectName = "fake string to clean parser cache";
        Parser parser = switch (databaseType) {
            case CH -> {
                var chParser = createCHParser(sql, parsedObjectName, null);
                chParserLastStart = 0;
                yield chParser;
            }
            case MS -> {
                var msParser = createTSQLParser(sql, parsedObjectName, null);
                msParserLastStart = 0;
                yield msParser;
            }
            case PG -> {
                var pgParser = createSQLParser(sql, parsedObjectName, null);
                pgParserLastStart = 0;
                yield pgParser;
            }
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + databaseType);
        };
        parser.getInterpreter().clearDFA();
    }

    private AntlrParser() {
    }
}
