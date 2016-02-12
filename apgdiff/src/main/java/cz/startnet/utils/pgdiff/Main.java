/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.Log;
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

    public static void main(String[] args) throws IOException, InterruptedException {
        PrintWriter writer = new PrintWriter(System.out, true);
        PgDiffArguments arguments = new PgDiffArguments();

        if (arguments.parse(writer, args)) {
            try {
                arguments.setLicense(new License(arguments.getLicensePath(), false));
                if(arguments.isModeDiff()) {
                    diff(writer, arguments);
                } else if(arguments.isModeParse()) {
                    parse(arguments);
                }
            } catch (LicenseException ex) {
                writer.println(Messages.Main_license_error + ex.getLocalizedMessage());
                Log.log(ex);
            }
        }
    }

    private static void diff(PrintWriter writer, PgDiffArguments arguments)
            throws InterruptedException, IOException, LicenseException {
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
            throws IOException, InterruptedException, LicenseException {
        PgDatabase d = PgDiff.loadDatabaseSchema(
                arguments.getParseSrcFormat(), arguments.getParseSrc(), arguments);
        new ModelExporter(new File(arguments.getParserOutdir()),
                d, arguments.getOutCharsetName()).exportFull();
    }

    private Main() {
    }
}
