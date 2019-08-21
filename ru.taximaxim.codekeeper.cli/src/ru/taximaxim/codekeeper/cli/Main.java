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
import java.text.MessageFormat;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.kohsuke.args4j.CmdLineException;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.NotAllowedObjectException;
import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffScript;
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
                parse(arguments);
                return true;
            } else if (arguments.isModeGraph()) {
                graph(writer, arguments);
                return true;
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
            throws InterruptedException, IOException {
        try (PrintWriter encodedWriter = getDiffWriter(arguments)) {
            PgDiffScript script = PgDiff.createDiff(arguments);
            String text = script.getText();

            if (arguments.isSafeMode()) {
                ScriptParser parser = new ScriptParser("CLI", text, arguments.isMsSql());
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
                encodedWriter.println(script.getText());
            } else {
                writer.println(script.getText());
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

    private static void parse(PgDiffArguments arguments)
            throws IOException, InterruptedException {
        PgDatabase d = PgDiff.loadDatabaseSchema(
                arguments.getNewSrcFormat(), arguments.getNewSrc(), arguments);

        if (arguments.isMsSql()) {
            new MsModelExporter(Paths.get(arguments.getOutputTarget()),
                    d, arguments.getOutCharsetName()).exportFull();
        } else {
            new ModelExporter(Paths.get(arguments.getOutputTarget()),
                    d, arguments.getOutCharsetName()).exportFull();
        }
    }

    private static void graph(PrintWriter writer, PgDiffArguments arguments)
            throws IOException, InterruptedException {
        PgDatabase d = PgDiff.loadDatabaseSchema(
                arguments.getNewSrcFormat(), arguments.getNewSrc(), arguments);

        try (PrintWriter encodedWriter = getDiffWriter(arguments)) {
            DepcyWriter dw;
            if (encodedWriter != null) {
                dw = new DepcyWriter(d, arguments.getGraphDepth(), encodedWriter,
                        arguments.isGraphReverse());
            } else {
                dw = new DepcyWriter(d, arguments.getGraphDepth(), writer,
                        arguments.isGraphReverse());
            }

            dw.write(arguments.getGraphNames());
        }
    }

    private Main() {
    }
}
