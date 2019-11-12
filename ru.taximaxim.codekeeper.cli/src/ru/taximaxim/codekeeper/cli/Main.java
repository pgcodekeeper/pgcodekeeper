/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package ru.taximaxim.codekeeper.cli;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.kohsuke.args4j.CmdLineException;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.NotAllowedObjectException;
import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcRunner;
import cz.startnet.utils.pgdiff.parsers.antlr.ScriptParser;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.MsModelExporter;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyWriter;
import ru.taximaxim.codekeeper.cli.localizations.Messages;

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
            if (arguments.isModeParse()) {
                return parse(arguments);
            } else if (arguments.isModeGraph()) {
                return graph(writer, arguments);
            } else {
                return diff(writer, arguments);
            }
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

            Status error = new Status(IStatus.ERROR, ApgdiffConsts.APGDIFF_PLUGIN_ID,
                    "pgCodeKeeper error", e);
            Platform.getLog(Activator.getContext().getBundle()).log(error);
            return false;
        }
    }

    private static boolean diff(PrintWriter writer, PgDiffArguments arguments)
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

    private static PrintWriter getDiffWriter(PgDiffArguments arguments)
            throws FileNotFoundException, UnsupportedEncodingException {
        String outFile = arguments.getOutputTarget();
        return outFile == null ? null : new UnixPrintWriter(
                arguments.getOutputTarget(), arguments.getOutCharsetName());
    }

    private static boolean parse(PgDiffArguments arguments)
            throws IOException, InterruptedException {
        PgDiff diff = new PgDiff(arguments);
        PgDatabase d;
        try {
            d = diff.loadNewDatabase();
        } catch (PgCodekeeperException ex) {
            diff.getErrors().forEach(System.err::println);
            return false;
        }

        if (arguments.isMsSql()) {
            new MsModelExporter(Paths.get(arguments.getOutputTarget()),
                    d, arguments.getOutCharsetName()).exportFull();
        } else {
            new ModelExporter(Paths.get(arguments.getOutputTarget()),
                    d, arguments.getOutCharsetName()).exportFull();
        }

        return true;
    }

    private static boolean graph(PrintWriter writer, PgDiffArguments arguments)
            throws IOException, InterruptedException {
        PgDiff diff = new PgDiff(arguments);
        PgDatabase d;
        try {
            d = diff.loadNewDatabase();
        } catch (PgCodekeeperException ex) {
            diff.getErrors().forEach(System.err::println);
            return false;
        }

        try (PrintWriter pw = getDiffWriter(arguments)) {
            new DepcyWriter(d, arguments.getGraphDepth(),
                    pw != null ?  pw : writer, arguments.isGraphReverse())
            .write(arguments.getGraphNames());
        }
        return true;
    }

    private Main() {
    }
}
