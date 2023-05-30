/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.loader;

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

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.core.libraries.PgLibrary;
import ru.taximaxim.codekeeper.core.libraries.PgLibrarySource;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.xmlstore.DependenciesXmlStore;

public class LibraryLoader extends DatabaseLoader {

    private final PgDatabase database;
    private final Path metaPath;
    private final Set<String> loadedLibs;

    private boolean loadNested;


    public LibraryLoader(PgDatabase database, Path metaPath, List<Object> errors) {
        this(database, metaPath, errors, new HashSet<>());
    }

    public LibraryLoader(PgDatabase database, Path metaPath, List<Object> errors, Set<String> loadedPaths) {
        super(errors);
        this.database = database;
        this.metaPath = metaPath;
        this.loadedLibs = loadedPaths;
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
        Path xmlPath = xmlStore.getXmlFile();
        boolean oldLoadNested = loadNested;
        try {
            loadNested = xmlStore.readLoadNestedFlag();
            for (PgLibrary lib : xmlLibs) {
                String path = lib.getPath();
                PgDatabase l = getLibrary(path, args, lib.isIgnorePriv(), xmlPath);
                database.addLib(l, path, lib.getOwner());
            }
        } finally {
            loadNested = oldLoadNested;
        }
    }

    private PgDatabase getLibrary(String path, PgDiffArguments arguments, boolean isIgnorePriv)
            throws InterruptedException, IOException {
        return getLibrary(path, arguments, isIgnorePriv, null);
    }

    private PgDatabase getLibrary(String path, PgDiffArguments arguments, boolean isIgnorePriv, Path xmlPath)
            throws InterruptedException, IOException {
        if (!loadedLibs.add(path)) {
            return new PgDatabase();
        }

        PgDiffArguments args = arguments.copy();
        args.setIgnorePrivileges(isIgnorePriv);

        switch (PgLibrarySource.getSource(path)) {
        case JDBC:
            return loadJdbc(args, path);
        case URL:
            try {
                return loadURI(new URI(path), args, isIgnorePriv);
            } catch (URISyntaxException ex) {
                // shouldn't happen, already checked by getSource
                // not URI, try to folder or file
                break;
            }
        case LOCAL:
            // continue below
        }
        Path p = Paths.get(path);
        if (!p.isAbsolute() && xmlPath != null) {
            p = xmlPath.resolveSibling(p).normalize();
        }

        if (!Files.exists(p)) {
            throw new IOException(MessageFormat.format(
                    "Error while read library : {0} - File not found", path));
        }

        if (Files.isDirectory(p)) {
            if (Files.exists(p.resolve(Consts.FILENAME_WORKING_DIR_MARKER))) {
                PgDatabase db = new ProjectLoader(p.toString(), args, errors).load();

                if (loadNested) {
                    new LibraryLoader(db, metaPath, errors, loadedLibs).loadXml(
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
        String timezone = args.getTimeZone() == null ? Consts.UTC : args.getTimeZone();
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
