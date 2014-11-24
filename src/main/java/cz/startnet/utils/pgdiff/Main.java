/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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
            throws UnsupportedEncodingException, IOException {
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
                if (script.isDangerDdl(arguments.isIgnoreDropColumn(),
                        arguments.isIgnoreAlterColumn(), arguments.isIgnoreDropTable())) {
                    try(final PrintWriter encodedWriter = new UnixPrintWriter(
                            new OutputStreamWriter(
                                new FileOutputStream(arguments.getDiffOutfile()),
                                                    arguments.getOutCharsetName()))) {
                        String msg = "Script contains dangerous statements,"
                                + " use --allow-danger-ddl to override";
                        encodedWriter.println("-- " +msg);
                        writer.println(msg);
                    }
                }
            } else if(arguments.isModeParse()) {
                new ModelExporter(new File(arguments.getParserOutdir()),
                        PgDiff.loadDatabaseSchema(arguments.getParseSrcFormat(),
                                arguments.getParseSrc(), arguments),
                            arguments.getOutCharsetName())
                    .exportFull();
            }
        }
    }

    private Main() {
    }
}
