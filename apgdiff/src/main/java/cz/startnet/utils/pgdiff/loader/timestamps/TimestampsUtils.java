package cz.startnet.utils.pgdiff.loader.timestamps;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Properties;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.ProjectLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;

public class TimestampsUtils {

    private static final String SNAPSHOT_PROPERTIES = ".snapshot_properties";
    private static final String SNAPSHOT_DATE = "date";


    public static PgDatabase getSnapshot(Path path) {
        PgDatabase db = new PgDatabase();
        if (Files.exists(path)) {
            try {
                return new ProjectLoader(path.toString(), new PgDiffArguments())
                        .loadDatabaseSchemaFromDirTree();
            } catch (IOException | InterruptedException ex) {
                Log.log(Log.LOG_ERROR, "Error while read db snapshot: " +
                        ex.getLocalizedMessage());
            }
        }

        return db;
    }

    public static Instant getSnapshotDate(Path folder) {
        Path path = folder.resolve(SNAPSHOT_PROPERTIES);
        if (Files.notExists(path)) {
            return null;
        }

        try (FileInputStream stream = new FileInputStream(path.toFile())) {
            Properties props = new Properties();
            props.load(stream);

            String verStr = props.getProperty(SNAPSHOT_DATE, "").trim();
            if (verStr.isEmpty()) {
                Log.log(Log.LOG_ERROR, "Unknown snapshot date");
                return null;
            }

            return Instant.parse(verStr);
        } catch (IOException | DateTimeParseException ex) {
            Log.log(Log.LOG_ERROR, "Error while read db snapshot date: " +
                    ex.getLocalizedMessage());
            return null;
        }
    }

    public static void writeSnapshot(Path folder, Instant date, PgDatabase db) {
        String charset = db.getArguments().getOutCharsetName();
        String prop = folder.resolve(SNAPSHOT_PROPERTIES).toString();

        try {
            if (Files.exists(folder)) {
                FileUtils.deleteRecursive(folder);
            }
            new ModelExporter(folder, db, charset).exportFull();
            if (date != null) {
                try (PrintWriter pw = new UnixPrintWriter(prop, charset)) {
                    pw.println(SNAPSHOT_DATE + " = " + date);
                }
            }
        } catch (IOException ex) {
            Log.log(Log.LOG_ERROR, "Error while write db snapshot: " +
                    ex.getLocalizedMessage());
        }
    }

    private TimestampsUtils() {
        // only statics
    }
}
