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
 *
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.cli;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.kohsuke.args4j.CmdLineException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.cli.localizations.Messages;
import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.NotAllowedObjectException;
import ru.taximaxim.codekeeper.core.PgCodekeeperException;
import ru.taximaxim.codekeeper.core.PgDiff;
import ru.taximaxim.codekeeper.core.UnixPrintWriter;
import ru.taximaxim.codekeeper.core.loader.JdbcRunner;
import ru.taximaxim.codekeeper.core.loader.TokenLoader;
import ru.taximaxim.codekeeper.core.loader.UrlJdbcConnector;
import ru.taximaxim.codekeeper.core.model.graph.DepcyFinder;
import ru.taximaxim.codekeeper.core.model.graph.InsertWriter;
import ru.taximaxim.codekeeper.core.parsers.antlr.ScriptParser;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.utils.FileUtils;

/**
 * Compares two PostgreSQL dumps and outputs information about differences in
 * the database schemas.
 *
 * @author fordfrog
 */
public final class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    /**
     * @return success value
     */
    public static boolean main(String[] args) {
        PrintWriter writer = new PrintWriter(System.out, true);
        CliArgs arguments = new CliArgs();
        try {
            if (!arguments.parse(writer, args)) {
                return true;
            }
            if (arguments.isClearLibCache()) {
                clearCache();
            }

            switch (arguments.getMode()) {
            case INSERT:
                return insert(writer, arguments);
            case PARSE:
                return parse(arguments);
            case GRAPH:
                return graph(writer, arguments);
            case VERIFY:
                return verify(writer, arguments);
            default:
                if (arguments.getOldSrc() == null || arguments.getNewSrc() == null) {
                    return true; // clear cache
                }
                return diff(writer, arguments);
            }
        } catch (CmdLineException | NotAllowedObjectException ex) {
            writeError(ex.getLocalizedMessage());
            return false;
        } catch (Exception e) {
            if (arguments.isDebug()) {
                LOG.error(Messages.Main_log_running_error, e);
                e.printStackTrace(System.err);
            } else {
                writeError(e.getLocalizedMessage());
                writeError(Messages.Main_show_stacktrace);
            }

            return false;
        }
    }

    private static boolean diff(PrintWriter writer, CliArgs arguments)
            throws InterruptedException, IOException, SQLException {
        try (PrintWriter encodedWriter = getDiffWriter(arguments)) {
            PgDiff diff = new PgDiff(arguments);
            String text;
            try {
                LOG.info(Messages.Main_log_create_script);
                text = diff.createDiff(arguments);
            } catch (PgCodekeeperException ex) {
                printError(diff);
                return false;
            }

            ScriptParser parser = new ScriptParser("CLI", text, arguments); //$NON-NLS-1$

            if (arguments.isSafeMode()) {
                var dangerTypes = parser.getDangerDdl(arguments.getAllowedDangers());

                if (!dangerTypes.isEmpty()) {
                    String dangerStmt = dangerTypes.stream().map(DangerStatement::name)
                            .collect(Collectors.joining(", ")); //$NON-NLS-1$
                    LOG.warn(Messages.Main_log_contains_dangerous_statements, dangerStmt);
                    String msg = MessageFormat.format(Messages.Main_danger_statements, dangerStmt);
                    writer.println(msg);
                    if (encodedWriter != null) {
                        encodedWriter.println("-- " + msg); //$NON-NLS-1$
                    }
                    return false;
                }
            }

            if (encodedWriter != null) {
                encodedWriter.println(text);
            }

            String url = arguments.getRunOnDb();
            if (arguments.isRunOnTarget() || url != null) {
                if (url == null) {
                    url = arguments.getOldSrc();
                }

                LOG.info(Messages.Main_log_apply_migration_script);
                new JdbcRunner().runBatches(new UrlJdbcConnector(url), parser.batch(), null);
            } else if (encodedWriter == null) {
                writer.println(text);
            }
        }

        LOG.info(Messages.Main_log_succes_finish);
        return true;
    }

    private static PrintWriter getDiffWriter(CliArgs arguments)
            throws FileNotFoundException, UnsupportedEncodingException {
        String outFile = arguments.getOutputTarget();
        return outFile == null ? null : new UnixPrintWriter(outFile, arguments.getOutCharsetName());
    }

    private static boolean parse(CliArgs arguments) throws IOException, InterruptedException, PgCodekeeperException {
        PgDiffCli diff = new PgDiffCli(arguments);
        try {
            if (arguments.isProjUpdate()) {
                LOG.info(Messages.Main_log_start_update_proj);
                diff.updateProject();
            } else {
                LOG.info(Messages.Main_log_start_export_proj);
                diff.exportProject();
            }
        } catch (PgCodekeeperException ex) {
            diff.getErrors().forEach(Main::writeError);
            return false;
        }

        LOG.info(Messages.Main_log_succes_finish);
        return true;
    }

    private static boolean insert(PrintWriter writer, CliArgs arguments)
            throws IOException, InterruptedException, SQLException {
        PgDiff diff = new PgDiff(arguments);
        AbstractDatabase db;
        try {
            db = diff.loadNewDatabaseWithLibraries(arguments);
        } catch (PgCodekeeperException ex) {
            printError(diff);
            return false;
        }

        LOG.info(Messages.Main_log_start_insert_data);
        var script = InsertWriter.write(db, arguments, arguments.getInsertName(), arguments.getInsertFilter());

        try (PrintWriter pw = getDiffWriter(arguments)) {
            if (pw != null) {
                pw.println(script);
            }
            String url = arguments.getRunOnDb();
            if (url != null) {
                LOG.info(Messages.Main_log_run_insert_data);
                new JdbcRunner().runBatches(new UrlJdbcConnector(url),
                        new ScriptParser("CLI", script, arguments).batch(), null); //$NON-NLS-1$
            } else if (pw == null) {
                writer.println(script);
            }
        }

        LOG.info(Messages.Main_log_succes_finish);
        return true;
    }

    private static boolean graph(PrintWriter writer, CliArgs arguments) throws IOException, InterruptedException {
        PgDiff diff = new PgDiff(arguments);
        AbstractDatabase d;
        try {
            d = diff.loadNewDatabaseWithLibraries(arguments);
        } catch (PgCodekeeperException ex) {
            printError(diff);
            return false;
        }
        LOG.info(Messages.Main_log_build_graph_deps);
        List<String> deps = DepcyFinder.byPatterns(arguments.getGraphDepth(), arguments.isGraphReverse(),
                arguments.getGraphFilterTypes(), arguments.isGraphInvertFilter(), d, arguments.getGraphNames());

        try (PrintWriter pw = getDiffWriter(arguments)) {
            var w = pw != null ? pw : writer;
            for (String dep : deps) {
                w.println(dep);
            }
        }

        LOG.info(Messages.Main_log_succes_finish);
        return true;
    }

    private static boolean verify(PrintWriter writer, CliArgs arguments)
            throws IOException, InterruptedException {
        Path path = Paths.get(arguments.getVerifyRuleSetPath());
        LOG.info(Messages.Main_log_start_code_verify);
        List<Object> errors = TokenLoader.verify(arguments, path, arguments.getVerifySources());
        if (!errors.isEmpty()) {
            errors.forEach(writer::println);
            return false;
        }
        LOG.info(Messages.Main_log_finish_code_verify);
        return true;
    }

    private static void clearCache() throws IOException {
        Path metaPath = Paths.get(System.getProperty("user.home")) //$NON-NLS-1$
                .resolve(".pgcodekeeper-cli").resolve("dependencies"); //$NON-NLS-1$ //$NON-NLS-2$
        FileUtils.deleteRecursive(metaPath);
        writeMessage(Messages.Main_cach_clear);
    }

    private static void printError(PgDiff diff) {
        for (var err : diff.getErrors()) {
            writeError(err);
        }
    }

    private static void writeMessage(Object message) {
        String msg = message.toString();
        LOG.info(msg);
        System.out.println(msg);
    }

    private static void writeError(Object message) {
        String msg = message.toString();
        LOG.error(msg);
        System.err.println(msg);
    }

    private Main() {
    }
}
