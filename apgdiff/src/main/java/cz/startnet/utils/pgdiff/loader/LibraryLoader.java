package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.libraries.PgLibrary;
import cz.startnet.utils.pgdiff.libraries.PgLibrarySource;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.xmlstore.DependenciesXmlStore;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;

public class LibraryLoader extends DatabaseLoader {

    private final PgDatabase database;
    private final Path metaPath;
    private final Set<String> loadedPaths;

    private boolean loadNested;


    public LibraryLoader(PgDatabase database, Path metaPath, List<Object> errors) {
        this(database, metaPath, errors, new HashSet<>());
    }

    public LibraryLoader(PgDatabase database, Path metaPath, List<Object> errors, Set<String> loadedPaths) {
        super(errors);
        this.database = database;
        this.metaPath = metaPath;
        this.loadedPaths = loadedPaths;
    }

    @Override
    public PgDatabase load() throws IOException, InterruptedException {
        throw new IllegalStateException("Unsupported operation for LibraryLoader");
    }

    public void loadLibraries(PgDiffArguments args, boolean isIgnorePriv,
            Collection<String> paths) throws InterruptedException, IOException {
        for (String path : paths) {
            database.addLib(getLibrary(path, args, isIgnorePriv), path, null);
        }
    }

    public void loadXml(DependenciesXmlStore xmlStore, PgDiffArguments args)
            throws InterruptedException, IOException {
        List<PgLibrary> xmlLibs = xmlStore.readObjects();
        loadNested = xmlStore.readLoadNestedFlag();
        for (PgLibrary lib : xmlLibs) {
            String path = lib.getPath();
            PgDatabase l = getLibrary(path, args, lib.isIgnorePriv());
            database.addLib(l, path, lib.getOwner());
        }
    }

    private PgDatabase getLibrary(String path, PgDiffArguments arguments, boolean isIgnorePriv)
            throws InterruptedException, IOException {
        if (!loadedPaths.add(path)) {
            return new PgDatabase();
        }

        PgDiffArguments args = arguments.copy();
        args.setIgnorePrivileges(isIgnorePriv);

        switch (PgLibrarySource.getSource(path)) {
        case JDBC:
            return loadJdbc(args, path);
        case URL:
            try {
                URI uri = new URI(path);
                PgDatabase db = loadURI(uri, args, isIgnorePriv);
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
                PgDatabase db = new ProjectLoader(path, args, errors).load();

                if (loadNested) {
                    new LibraryLoader(db, metaPath, errors, loadedPaths).loadXml(
                            new DependenciesXmlStore(p.resolve(DependenciesXmlStore.FILE_NAME)), args);
                }

                return db;
            }

            PgDatabase db = new PgDatabase(args);
            readStatementsFromDirectory(p, db);
            finishLoaders();
            return db;
        }

        if (FileUtils.isZipFile(p)) {
            return loadZip(p, args, isIgnorePriv);
        }

        PgDatabase db = new PgDatabase(args);
        PgDumpLoader loader = new PgDumpLoader(Paths.get(path), args);
        loader.loadAsync(db, antlrTasks);
        launchedLoaders.add(loader);
        finishLoaders();
        return db;
    }

    private PgDatabase loadZip(Path path, PgDiffArguments args, boolean isIgnorePriv)
            throws InterruptedException, IOException {
        Path dir = FileUtils.getUnzippedFilePath(metaPath, path);
        return getLibrary(unzip(path, dir), args, isIgnorePriv);
    }

    private PgDatabase loadJdbc(PgDiffArguments args, String path) throws IOException, InterruptedException {
        String timezone = args.getTimeZone() == null ? ApgdiffConsts.UTC : args.getTimeZone();
        DatabaseLoader loader;
        if (path.startsWith("jdbc:sqlserver")) {
            loader = new JdbcMsLoader(JdbcConnector.fromUrl(path, timezone), args);
        } else {
            loader = new JdbcLoader(JdbcConnector.fromUrl(path, timezone), args);
        }

        PgDatabase db;
        try {
            db = loader.load();
        } finally {
            errors.addAll(loader.getErrors());
        }

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
        Path destDir = dir.toRealPath();

        try (FileSystem fs = FileSystems.newFileSystem(zip, (ClassLoader) null)) {
            final Path root = fs.getPath("/");

            // walk the zip file tree and copy files to the destination
            Files.walkFileTree(root, new SimpleFileVisitor<Path>(){

                @Override
                public FileVisitResult visitFile(Path file,
                        BasicFileAttributes attrs) throws IOException {
                    Path destFile = Paths.get(destDir.toString(), file.toString());
                    Files.copy(file, destFile, StandardCopyOption.REPLACE_EXISTING);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir,
                        BasicFileAttributes attrs) throws IOException {
                    Path dirToCreate = Paths.get(destDir.toString(), dir.toString());

                    if (Files.notExists(dirToCreate)){
                        Files.createDirectory(dirToCreate);
                    }

                    return FileVisitResult.CONTINUE;
                }
            });
        }

        return destDir.toString();
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
            db.addLib(getLibrary(filePath, args, args.isIgnorePrivileges()), null, null);
        } else if (filePath.endsWith(".sql")) {
            PgDumpLoader loader = new PgDumpLoader(sub, args);
            loader.loadDatabase(db, antlrTasks);
            launchedLoaders.add(loader);
        }
    }
}
