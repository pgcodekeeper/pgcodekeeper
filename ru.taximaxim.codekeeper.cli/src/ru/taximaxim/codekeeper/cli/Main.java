/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.kohsuke.args4j.CmdLineException;

import ru.taximaxim.codekeeper.cli.localizations.Messages;
import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.NotAllowedObjectException;
import ru.taximaxim.codekeeper.core.PgCodekeeperException;
import ru.taximaxim.codekeeper.core.PgDiff;
import ru.taximaxim.codekeeper.core.UnixPrintWriter;
import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.core.loader.JdbcConnector;
import ru.taximaxim.codekeeper.core.loader.JdbcRunner;
import ru.taximaxim.codekeeper.core.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.core.model.exporter.MsModelExporter;
import ru.taximaxim.codekeeper.core.model.graph.DepcyWriter;
import ru.taximaxim.codekeeper.core.parsers.antlr.ScriptParser;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

/**
 * Compares two PostgreSQL dumps and outputs information about differences in
 * the database schemas.
 *
 * @author fordfrog
 */
public final class Main {

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
            if (arguments.isModeParse()) {
                return parse(arguments);
            }
            if (arguments.isModeGraph()) {
                return graph(writer, arguments);
            }
            if (arguments.getOldSrc() == null || arguments.getNewSrc() == null) {
                return true; // clear cache
            }
            return diff(writer, arguments);
        } catch (CmdLineException | NotAllowedObjectException ex) {
            System.err.println(ex.getLocalizedMessage());
            return false;
        } catch (Exception e) {
            if (arguments.isDebug()) {
                e.printStackTrace(System.err);
            } else {
                System.err.println(e.getLocalizedMessage());
                System.err.println("Use -E to see exception stacktrace");
            }

            Status error = new Status(IStatus.ERROR, Consts.PLUGIN_ID,
                    "pgCodeKeeper error", e);
            Platform.getLog(Activator.getContext().getBundle()).log(error);
            return false;
        }
    }

    private static boolean diff(PrintWriter writer, CliArgs arguments)
            throws InterruptedException, IOException, SQLException {
        try (PrintWriter encodedWriter = getDiffWriter(arguments)) {
            PgDiff diff = new PgDiff(arguments);
            String text;
            try {
                text = diff.createDiff();
            } catch (PgCodekeeperException ex) {
                diff.getErrors().forEach(System.err::println);
                return false;
            }

            ScriptParser parser = new ScriptParser("CLI", text, arguments.isMsSql());

            if (arguments.isSafeMode()) {
                Set<DangerStatement> dangerTypes =
                        parser.getDangerDdl(arguments.getAllowedDangers());

                if (!dangerTypes.isEmpty()) {
                    String msg = MessageFormat.format(Messages.Main_danger_statements,
                            dangerTypes.stream().map(DangerStatement::name)
                            .collect(Collectors.joining(", ")));
                    writer.println(msg);
                    if (encodedWriter != null) {
                        encodedWriter.println("-- " + msg);
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
                new JdbcRunner().runBatches(
                        JdbcConnector.fromUrl(url), parser.batch(), null);
            } else if (encodedWriter == null) {
                writer.println(text);
            }
        }

        return true;
    }

    private static PrintWriter getDiffWriter(CliArgs arguments)
            throws FileNotFoundException, UnsupportedEncodingException {
        String outFile = arguments.getOutputTarget();
        return outFile == null ? null : new UnixPrintWriter(
                outFile, arguments.getOutCharsetName());
    }

    private static boolean parse(CliArgs arguments)
            throws IOException, InterruptedException, PgCodekeeperException {
        PgDiffCli diff = new PgDiffCli(arguments);
        try {
            if (arguments.isProjUpdate()) {
                diff.updateProject();
            } else {
                PgDatabase d = diff.loadNewDatabase();
                if (arguments.isMsSql()) {
                    new MsModelExporter(Paths.get(arguments.getOutputTarget()), d,
                            arguments.getOutCharsetName()).exportFull();
                } else {
                    new ModelExporter(Paths.get(arguments.getOutputTarget()), d,
                            arguments.getOutCharsetName()).exportFull();
                }
            }
        } catch (PgCodekeeperException ex) {
            diff.getErrors().forEach(System.err::println);
            return false;
        }
        return true;
    }

    private static boolean graph(PrintWriter writer, CliArgs arguments)
            throws IOException, InterruptedException {
        PgDiff diff = new PgDiff(arguments);
        PgDatabase d;
        try {
            d = diff.loadNewDatabaseWithLibraries();
        } catch (PgCodekeeperException ex) {
            diff.getErrors().forEach(System.err::println);
            return false;
        }

        try (PrintWriter pw = getDiffWriter(arguments)) {
            new DepcyWriter(d, arguments.getGraphDepth(),
                    pw != null ?  pw : writer, arguments.isGraphReverse(),
                            arguments.getGraphFilterTypes(), arguments.isGraphInvertFilter())
            .write(arguments.getGraphNames());
        }
        return true;
    }

    private static void clearCache() throws IOException {
        Path metaPath = Paths.get(System.getProperty("user.home"))
                .resolve(".pgcodekeeper-cli").resolve("dependencies");
        FileUtils.deleteRecursive(metaPath);
        System.err.println("Clear cached libraries");
    }

    private Main() {
    }
}
