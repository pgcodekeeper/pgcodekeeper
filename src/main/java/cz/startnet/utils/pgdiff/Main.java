/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import cz.startnet.utils.pgdiff.PgDiffStatement.DangerStatements;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;

/**
 * Compares two PostgreSQL dumps and outputs information about differences in
 * the database schemas.
 *
 * @author fordfrog
 */
public class Main {

    /**
     * APgDiff main method.
     *
     * @param args the command line arguments
     *
     * @throws UnsupportedEncodingException Thrown if unsupported output
     *                                      encoding has been encountered.
     */
    public static void main(final String[] args)
            throws UnsupportedEncodingException, FileNotFoundException,
                IOException {
        final PrintWriter writer = new PrintWriter(System.out, true);
        final PgDiffArguments arguments = new PgDiffArguments();

        if (arguments.parse(writer, args)) {
            if(arguments.isModeDiff()) {
                PgDiffScript script;
                try(final PrintWriter encodedWriter = new UnixPrintWriter(
                        new OutputStreamWriter(
                            new FileOutputStream(arguments.getDiffOutfile()),
                                                arguments.getOutCharsetName()))) {
                    script = PgDiff.createDiff(encodedWriter, arguments);
                }
                if (script != null && checkOnDanger(script, arguments)) {
                    try(final PrintWriter encodedWriter = new UnixPrintWriter(
                            new OutputStreamWriter(
                                new FileOutputStream(arguments.getDiffOutfile()),
                                                    arguments.getOutCharsetName()))) {
                        encodedWriter.write("");
                        throw new IllegalStateException(
                                "Script contains danger statements use --allow-danger-ddl to avoid");
                    }
                }
            } else if(arguments.isModeParse()) {
                new ModelExporter(arguments.getParserOutdir(),
                        PgDiff.loadDatabaseSchema(arguments.getParseSrcFormat(),
                                arguments.getParseSrc(), arguments),
                            arguments.getOutCharsetName())
                    .export();
            }
        }

        writer.close();
    }

    private static boolean checkOnDanger(PgDiffScript script,
            PgDiffArguments arguments) throws UnsupportedEncodingException,
            FileNotFoundException, IOException {
        boolean cleanWriter = false;
        if (!arguments.isIgnoreAlterColumn()) {
            cleanWriter |= script.containsDangerStatements(DangerStatements.ALTER_COLUMN);
        }
        if (!arguments.isIgnoreDropColumn()) {
            cleanWriter |= script.containsDangerStatements(DangerStatements.DROP_COLUMN);
        }
        if (!arguments.isIgnoreDropTable()) {
            cleanWriter |= script.containsDangerStatements(DangerStatements.DROP_TABLE);
        }
        return cleanWriter;
    }

    /**
     * Creates a new Main object.
     */
    private Main() {
    }
}
