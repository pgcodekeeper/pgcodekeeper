package cz.startnet.utils.pgdiff.loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.libraries.PgLibrary;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.xmlstore.DependenciesXmlStore;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

public class LibraryLoader {

    private final PgDatabase db;
    private final Path metaPath;

    public LibraryLoader(PgDatabase db, Path metaPath) {
        this.db = db;
        this.metaPath = metaPath;
    }

    public void loadLibraries(PgDiffArguments args, boolean isIgnorePriv,
            Collection<String> paths) throws InterruptedException, IOException {
        for (String path : paths) {
            loadLibrary(args, isIgnorePriv, path);
        }
    }

    public void loadXml(DependenciesXmlStore xmlStore, PgDiffArguments args)
            throws InterruptedException, IOException {
        for (PgLibrary lib : xmlStore.readObjects()) {
            loadLibrary(args, lib.isIgnorePriv(), lib.getPath());
        }
    }

    private void loadLibrary(PgDiffArguments args, boolean isIgnorePriv, String path)
            throws InterruptedException, IOException {
        db.addLib(getLibrary(path, args, isIgnorePriv));
    }

    private PgDatabase getLibrary(String path, PgDiffArguments arguments, boolean isIgnorePriv)
            throws InterruptedException, IOException {

        PgDiffArguments args = arguments.clone();
        args.setIgnorePrivileges(isIgnorePriv);

        if (path.startsWith("jdbc:")) {
            String timezone = args.getTimeZone() == null ? ApgdiffConsts.UTC : args.getTimeZone();
            PgDatabase db = new JdbcLoader(JdbcConnector.fromUrl(path, timezone), args).getDbFromJdbc();
            db.getDescendants().forEach(st -> st.setLocation(path));
            return db;
        }

        try {
            URI uri = new URI(path);
            if (uri.getScheme() != null) {
                return loadURI(uri, args, isIgnorePriv);
            }
        } catch (URISyntaxException e) {
            // not URI, try to folder or file
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

        if (path.endsWith(".zip")) {
            return loadZip(p, args, isIgnorePriv);
        }

        try (PgDumpLoader loader = new PgDumpLoader(new File(path), args)) {
            return loader.load();
        }
    }

    private PgDatabase loadZip(Path path, PgDiffArguments args, boolean isIgnorePriv)
            throws InterruptedException, IOException {
        String name = path.getFileName().toString() + '_'
                + PgDiffUtils.md5(path.toString()).substring(0, 10);

        PgDatabase db = getLibrary(unzip(path, metaPath.resolve(name)),
                args, isIgnorePriv);

        db.getDescendants().forEach(st -> st.setLocation(path.toString()));
        return db;
    }

    private PgDatabase loadURI(URI uri, PgDiffArguments args, boolean isIgnorePriv)
            throws InterruptedException, IOException {
        String path = uri.getPath();
        String fileName = Paths.get(path).getFileName().toString();
        String name = fileName + '_' + PgDiffUtils.md5(path).substring(0, 10);

        PgDatabase db = getLibrary(download(uri, metaPath.resolve(name), fileName),
                args, isIgnorePriv);

        db.getDescendants().forEach(st -> st.setLocation(path));
        return db;
    }

    private String download(URI uri, Path dir, String fileName) throws IOException {
        createMetaFolder();
        // create output directory if it doesn't exist
        if (Files.exists(dir)) {
            return dir.toString();
        }

        Files.createDirectories(dir);

        InputStream in = uri.toURL().openStream();
        Files.copy(in, dir.resolve(fileName));

        return dir.toString();
    }

    private void createMetaFolder() throws IOException {
        if (!Files.exists(metaPath)) {
            Files.createDirectories(metaPath);
        }
    }

    private String unzip(Path zip, Path dir) throws FileNotFoundException, IOException {
        createMetaFolder();
        // create output directory if it doesn't exist
        if (Files.exists(dir)) {
            return dir.toString();
        }

        Files.createDirectories(dir);

        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try (InputStream fis = Files.newInputStream(zip);
                ZipInputStream zis = new ZipInputStream(fis)) {
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                Path newFile = dir.resolve(ze.getName());

                //create directories for sub directories in zip
                if (!ze.isDirectory()) {
                    Files.createDirectories(newFile.getParent());

                    try (OutputStream fos = Files.newOutputStream(newFile)) {
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }

            //close last ZipEntry
            zis.closeEntry();
        }

        return dir.toString();
    }

    private void readStatementsFromDirectory(final Path f, PgDatabase db, PgDiffArguments args)
            throws IOException, InterruptedException {
        if (Files.isDirectory(f)) {
            try (Stream<Path> stream = Files.list(f)) {
                for (Path sub : (Iterable<Path>) stream::iterator) {
                    readStatementsFromDirectory(sub, db, args);
                }
            }
        } else if (f.toString().endsWith(".zip")) {
            db.addLib(getLibrary(f.toString(), args, args.isIgnorePrivileges()));
        } else {
            try (PgDumpLoader loader = new PgDumpLoader(f.toFile(), args)) {
                db.addLib(loader.load());
            }
        }
    }
}
