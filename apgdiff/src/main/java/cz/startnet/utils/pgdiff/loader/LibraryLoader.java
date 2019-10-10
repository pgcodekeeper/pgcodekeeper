package cz.startnet.utils.pgdiff.loader;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.libraries.PgLibrary;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.xmlstore.DependenciesXmlStore;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;

public class LibraryLoader extends DatabaseLoader {

    private final PgDatabase database;
    private final Path metaPath;

    public LibraryLoader(PgDatabase database, Path metaPath, List<? super AntlrError> errors) {
        super(errors);
        this.database = database;
        this.metaPath = metaPath;
    }

    public void loadLibraries(PgDiffArguments args, boolean isIgnorePriv,
            Collection<String> paths) throws InterruptedException, IOException {
        for (String path : paths) {
            database.addLib(getLibrary(path, args, isIgnorePriv));
        }
    }

    public void loadXml(DependenciesXmlStore xmlStore, PgDiffArguments args)
            throws InterruptedException, IOException {
        for (PgLibrary lib : xmlStore.readObjects()) {
            PgDatabase l = getLibrary(lib.getPath(), args, lib.isIgnorePriv());
            String owner = lib.getOwner();
            if (!owner.isEmpty()) {
                l.getDescendants()
                .filter(PgStatement::isOwned)
                .forEach(st -> st.setOwner(owner));
            }

            database.addLib(l);
        }
    }

    private PgDatabase getLibrary(String path, PgDiffArguments arguments, boolean isIgnorePriv)
            throws InterruptedException, IOException {

        PgDiffArguments args = arguments.clone();
        args.setIgnorePrivileges(isIgnorePriv);

        switch (PgLibrary.getSource(path)) {
        case JDBC:
            String timezone = args.getTimeZone() == null ? ApgdiffConsts.UTC : args.getTimeZone();
            PgDatabase db;
            if (path.startsWith("jdbc:sqlserver")) {
                db = new JdbcMsLoader(JdbcConnector.fromUrl(path, timezone), args).readDb();
            } else {
                // TODO add errors from JDBC to list
                db = new JdbcLoader(JdbcConnector.fromUrl(path, timezone), args).getDbFromJdbc();
            }

            db.getDescendants().forEach(st -> st.setLocation(new PgObjLocation(path)));
            return db;

        case URL:
            try {
                URI uri = new URI(path);
                db = loadURI(uri, args, isIgnorePriv);
                db.getDescendants().forEach(st -> st.setLocation(new PgObjLocation(path)));
                return db;
            } catch (URISyntaxException ex) {
                // shouldn't happen, already checked by getSource
                // not URI, try to folder or file
                break;
            }
        case LOCAL:
            // continue below
        }
        Path p = Paths.get(path);

        if (!Files.exists(p)) {
            throw new IOException(MessageFormat.format(
                    "Error while read library : {0} - File not found", path));
        }

        if (Files.isDirectory(p)) {
            if (Files.exists(p.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER))) {
                return new ProjectLoader(path, args, null, errors).loadSchemaOnly();
            } else {
                PgDatabase db = new PgDatabase(args);
                readStatementsFromDirectory(p, db);
                finishLoaders();
                return db;
            }
        }

        if (isZipFile(path)) {
            return loadZip(p, args, isIgnorePriv);
        }

        PgDatabase db = new PgDatabase(args);
        PgDumpLoader loader = new PgDumpLoader(new File(path), args);
        loader.loadAsync(db, antlrTasks);
        launchedLoaders.add(loader);
        finishLoaders();
        return db;
    }

    private boolean isZipFile(String path) throws IOException {
        int fileSignature = 0;
        try (RandomAccessFile raf = new RandomAccessFile(path, "r")) {
            fileSignature = raf.readInt();
        } catch (EOFException e) {
            // empty file
            return false;
        }

        return fileSignature == 0x504B0304 || fileSignature == 0x504B0506
                || fileSignature == 0x504B0708;
    }

    private PgDatabase loadZip(Path path, PgDiffArguments args, boolean isIgnorePriv)
            throws InterruptedException, IOException {
        String hash;
        if (path.startsWith(metaPath)) {
            hash = metaPath.relativize(path).toString();
        } else {
            hash = path.toString();
        }

        String name = path.getFileName().toString() + '_'
                + PgDiffUtils.md5(hash).substring(0, 10);

        PgDatabase db = getLibrary(unzip(path, metaPath.resolve(name)),
                args, isIgnorePriv);

        db.getDescendants().forEach(st -> st.setLocation(new PgObjLocation(path.toString())));
        return db;
    }

    private PgDatabase loadURI(URI uri, PgDiffArguments args, boolean isIgnorePriv)
            throws InterruptedException, IOException {
        String path = uri.getPath();
        String fileName = FileUtils.getValidFilename(Paths.get(path).getFileName().toString());
        String name = fileName + '_' + PgDiffUtils.md5(path).substring(0, 10);

        Path dir = metaPath.resolve(name);

        // do nothing if directory already exists
        if (!Files.exists(dir)) {

            Path file = dir.resolve(fileName);

            try (InputStream in = uri.toURL().openStream()) {
                Files.createDirectories(dir);
                Files.copy(in, file);
            } catch (IOException e) {
                IOException ioe = new IOException(
                        MessageFormat.format("Error while read library from URI : {0} - {1} ",
                                uri, e.getLocalizedMessage()), e);

                try {
                    Files.deleteIfExists(file);
                } catch (IOException ex) {
                    ioe.addSuppressed(ex);
                }

                try {
                    Files.deleteIfExists(dir);
                } catch (IOException ex) {
                    ioe.addSuppressed(ex);
                }

                throw ioe;
            }
        }

        return getLibrary(dir.toString(), args, isIgnorePriv);
    }

    private String unzip(Path zip, Path dir) throws IOException {
        // return output directory if it exists
        if (Files.exists(dir)) {
            return dir.toString();
        }

        Files.createDirectories(dir);
        dir = dir.toRealPath();

        try (InputStream fis = Files.newInputStream(zip);
                ZipInputStream zis = new ZipInputStream(fis)) {
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                Path newFile = dir.resolve(ze.getName()).normalize();
                if (!newFile.startsWith(dir)) {
                    throw new SecurityException("Malicious zip-archive attempting to write outside target directory: "
                            + newFile);
                }

                //create directories for sub directories in zip
                if (!ze.isDirectory()) {
                    Files.createDirectories(newFile.getParent());
                    Files.copy(zis, newFile);
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

    private void readStatementsFromDirectory(Path f, PgDatabase db)
            throws IOException, InterruptedException {
        try (Stream<Path> stream = Files.list(f)) {
            List<Path> dirs = new ArrayList<>();
            for (Path sub : (Iterable<Path>) stream::iterator) {
                if (Files.isDirectory(sub)) {
                    dirs.add(sub);
                } else {
                    readStatementsFromFile(sub, db);
                }
            }

            for (Path sub : dirs) {
                readStatementsFromDirectory(sub, db);
            }
        }
    }

    private void readStatementsFromFile(Path sub, PgDatabase db)
            throws InterruptedException, IOException {
        String filePath = sub.toString();
        PgDiffArguments args = db.getArguments();
        if (filePath.endsWith(".zip")) {
            db.addLib(getLibrary(filePath, args, args.isIgnorePrivileges()));
        } else if (filePath.endsWith(".sql")) {
            PgDumpLoader loader = new PgDumpLoader(sub.toFile(), args);
            loader.loadDatabase(db, antlrTasks);
            launchedLoaders.add(loader);
        }
    }
}
