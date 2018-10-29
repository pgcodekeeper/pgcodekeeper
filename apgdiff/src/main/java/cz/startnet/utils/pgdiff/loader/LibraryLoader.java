package cz.startnet.utils.pgdiff.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

public class LibraryLoader {

    private final PgDatabase db;

    public LibraryLoader(PgDatabase db) {
        this.db = db;
    }

    public void loadLibraries(PgDiffArguments args, boolean isIgnorePriv,
            Collection<String> paths) throws InterruptedException, IOException, URISyntaxException {
        for (String path : paths) {
            loadLibrary(args, isIgnorePriv, path);
        }
    }

    public void loadLibrary(PgDiffArguments args, boolean isIgnorePriv, String path)
            throws InterruptedException, IOException, URISyntaxException {
        db.addLib(getLibrary(path, args, isIgnorePriv));
    }

    private PgDatabase getLibrary(String path, PgDiffArguments arguments, boolean isIgnorePriv)
            throws InterruptedException, IOException, URISyntaxException {

        PgDiffArguments args = arguments.clone();
        args.setIgnorePrivileges(isIgnorePriv);

        if (path.startsWith("jdbc:")) {
            String timezone = args.getTimeZone() == null ? ApgdiffConsts.UTC : args.getTimeZone();
            PgDatabase db = new JdbcLoader(JdbcConnector.fromUrl(path, timezone), args).getDbFromJdbc();
            db.getDescendants().forEach(st -> st.setLocation(path));
            return db;
        }

        Path p = Paths.get(path);

        if (Files.isDirectory(p)) {
            if (Files.exists(p.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER))) {
                PgDatabase db = new PgDatabase();
                db.setArguments(args);
                new ProjectLoader(path, args).loadDatabaseSchemaFromDirTree(db);
                return db;
            } else {
                PgDatabase db = new PgDatabase();
                db.setArguments(args);
                readStatementsFromDirectory(p, db, args);
                return db;
            }
        }

        if (path.endsWith("zip")) {
            return loadZip(p, args, isIgnorePriv);
        }

        try (PgDumpLoader loader = new PgDumpLoader(new File(path), args)) {
            return loader.load();
        }
    }

    private PgDatabase loadZip(Path p, PgDiffArguments args, boolean isIgnorePriv)
            throws InterruptedException, IOException, URISyntaxException {
        String name = p.getFileName().toString() + '_' + PgDiffUtils.shaString(p.toString());

        IPath iPath = getLocation().append("dependencies");

        File file = iPath.toFile();
        if (!file.exists()) {
            file.mkdirs();
        }

        PgDatabase db = getLibrary(unzip(p.toFile(), new File(file, name)).toString(),
                args, isIgnorePriv);

        db.getDescendants().forEach(st -> st.setLocation(p.toString()));

        return db;
    }

    protected IPath getLocation() {
        return Platform.getLocation();
    }

    private File unzip(File zipFile, File dir) {
        // create output directory if it doesn't exist
        if (!dir.exists()) {
            dir.mkdirs();
        } else {
            return dir;
        }
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(zipFile);
                ZipInputStream zis = new ZipInputStream(fis)) {
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String fileName = ze.getName();
                File newFile = new File(dir, fileName);
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                try (FileOutputStream fos = new FileOutputStream(newFile)) {
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }

            //close last ZipEntry
            zis.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dir;
    }

    private void readStatementsFromDirectory(final Path f, PgDatabase db, PgDiffArguments args)
            throws IOException, InterruptedException, URISyntaxException {
        if (Files.isDirectory(f)) {
            try (Stream<Path> stream = Files.list(f)) {
                for (Path sub : (Iterable<Path>) stream::iterator) {
                    readStatementsFromDirectory(sub, db, args);
                }
            }
        } else {
            try (PgDumpLoader loader = new PgDumpLoader(f.toFile(), args)) {
                db.addLib(loader.load());
            }
        }
    }
}
