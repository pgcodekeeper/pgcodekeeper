/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.licensing.License;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;

/**
 * Compares two PostgreSQL dumps and outputs information about differences in
 * the database schemas.
 *
 * @author fordfrog
 */
public final class Main {

    public static void main(String[] args) throws IOException, InterruptedException,
    URISyntaxException, LicenseException, NotAllowedObjectException {
        PrintWriter writer = new PrintWriter(System.out, true);
        PgDiffArguments arguments = new PgDiffArguments();

        if (arguments.parse(writer, args)) {
            License l = new License(arguments.getLicensePath());
            l.verify(false);
            arguments.setLicense(l);
            if(arguments.isModeDiff()) {
                diff(writer, arguments);
            } else if(arguments.isModeParse()) {
                parse(arguments);
            }
        }
        Thread.sleep(100);
    }

    private static void diff(PrintWriter writer, PgDiffArguments arguments)
            throws InterruptedException, IOException, LicenseException, URISyntaxException {
        PgDiffScript script;
        try(PrintWriter encodedWriter = new UnixPrintWriter(
                arguments.getDiffOutfile(), arguments.getOutCharsetName())) {
            script = PgDiff.createDiff(encodedWriter, arguments);
        }
        if (script.isDangerDdl(arguments.isIgnoreDropColumn(),
                arguments.isIgnoreAlterColumn(), arguments.isIgnoreDropTable(),
                arguments.isIgnoreRestartWith())) {
            try (PrintWriter encodedWriter = new UnixPrintWriter(
                    arguments.getDiffOutfile(), arguments.getOutCharsetName())) {
                String msg = Messages.Main_danger_statements;
                encodedWriter.println("-- " + msg); //$NON-NLS-1$
                writer.println(msg);
            }
        }
    }

    private static void parse(PgDiffArguments arguments)
            throws IOException, InterruptedException, LicenseException, URISyntaxException {
        PgDatabase d = PgDiff.loadDatabaseSchema(
                arguments.getParseSrcFormat(), arguments.getParseSrc(), arguments);
        new ModelExporter(new File(arguments.getParserOutdir()),
                d, arguments.getOutCharsetName()).exportFull();
    }

    private Main() {
    }
}
