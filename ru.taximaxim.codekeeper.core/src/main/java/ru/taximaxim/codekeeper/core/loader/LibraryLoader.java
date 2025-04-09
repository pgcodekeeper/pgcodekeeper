/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.core.libraries.PgLibrary;
import ru.taximaxim.codekeeper.core.libraries.PgLibrarySource;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.settings.ISettings;
import ru.taximaxim.codekeeper.core.xmlstore.DependenciesXmlStore;

public final class LibraryLoader extends DatabaseLoader {

    private final AbstractDatabase database;
    private final Path metaPath;
    private final Set<String> loadedLibs;

    private boolean loadNested;

    public LibraryLoader(AbstractDatabase database, Path metaPath, List<Object> errors) {
        this(database, metaPath, errors, new HashSet<>());
    }

    public LibraryLoader(AbstractDatabase database, Path metaPath, List<Object> errors, Set<String> loadedPaths) {
        super(errors);
        this.database = database;
        this.metaPath = metaPath;
        this.loadedLibs = loadedPaths;
    }

    @Override
    public AbstractDatabase load() throws IOException, InterruptedException {
        throw new IllegalStateException("Unsupported operation for LibraryLoader");
    }

    public void loadLibraries(ISettings settings, boolean isIgnorePriv,
            Collection<String> paths) throws InterruptedException, IOException {
        for (String path : paths) {
            database.addLib(getLibrary(path, settings, isIgnorePriv), path, null);
        }
    }

    public void loadXml(DependenciesXmlStore xmlStore, ISettings settings)
            throws InterruptedException, IOException {
        List<PgLibrary> xmlLibs = xmlStore.readObjects();
        Path xmlPath = xmlStore.getXmlFile();
        boolean oldLoadNested = loadNested;
        try {
            loadNested = xmlStore.readLoadNestedFlag();
            for (PgLibrary lib : xmlLibs) {
                String path = lib.getPath();
                AbstractDatabase l = getLibrary(path, settings, lib.isIgnorePriv(), xmlPath);
                database.addLib(l, path, lib.getOwner());
            }
        } finally {
            loadNested = oldLoadNested;
        }
    }

    private AbstractDatabase getLibrary(String path, ISettings settings, boolean isIgnorePriv)
            throws InterruptedException, IOException {
        return getLibrary(path, settings, isIgnorePriv, null);
    }

    private AbstractDatabase getLibrary(String path, ISettings settings, boolean isIgnorePriv, Path xmlPath)
            throws InterruptedException, IOException {
        if (!loadedLibs.add(path)) {
            return createDb(settings);
        }

        ISettings sets = settings.copy();
        if (!sets.isIgnorePrivileges()) {
            sets.setIgnorePrivileges(isIgnorePriv);
        }

        switch (PgLibrarySource.getSource(path)) {
        case JDBC:
            return loadJdbc(sets, path);
        case URL:
            try {
                return loadURI(new URI(path), sets, isIgnorePriv);
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
                AbstractDatabase db = new ProjectLoader(p.toString(), sets, errors).load();

                if (loadNested) {
                    new LibraryLoader(db, metaPath, errors, loadedLibs).loadXml(
                            new DependenciesXmlStore(p.resolve(DependenciesXmlStore.FILE_NAME)), sets);
                }

                return db;
            }

            AbstractDatabase db = createDb(sets);
            readStatementsFromDirectory(p, db, sets);
            finishLoaders();
            return db;
        }

        if (FileUtils.isZipFile(p)) {
            return loadZip(p, sets, isIgnorePriv);
        }

        AbstractDatabase db = createDb(sets);
        PgDumpLoader loader = new PgDumpLoader(Paths.get(path), sets);
        loader.loadAsync(db, antlrTasks);
        launchedLoaders.add(loader);
        finishLoaders();
        return db;
    }

    private AbstractDatabase loadZip(Path path, ISettings settings, boolean isIgnorePriv)
            throws InterruptedException, IOException {
        Path dir = FileUtils.getUnzippedFilePath(metaPath, path);
        return getLibrary(FileUtils.unzip(path, dir), settings, isIgnorePriv);
    }

    private AbstractDatabase loadJdbc(ISettings settings, String path) throws IOException, InterruptedException {
        DatabaseLoader loader = LoaderFactory.createJdbcLoader(settings, path, null);
        AbstractDatabase db;
        try {
            db = loader.load();
        } finally {
            errors.addAll(loader.getErrors());
        }

        return db;
    }

    private AbstractDatabase loadURI(URI uri, ISettings settings, boolean isIgnorePriv)
            throws InterruptedException, IOException {
        String path = uri.getPath();
        String fileName = FileUtils.getValidFilename(Paths.get(path).getFileName().toString());
        String name = fileName + '_' + PgDiffUtils.md5(path).substring(0, 10);

        Path dir = metaPath.resolve(name);

        FileUtils.loadURI(uri, fileName, dir);

        return getLibrary(dir.toString(), settings, isIgnorePriv);
    }



    private void readStatementsFromDirectory(Path f, AbstractDatabase db, ISettings settings)
            throws IOException, InterruptedException {
        try (Stream<Path> stream = Files.list(f)) {
            List<Path> dirs = new ArrayList<>();
            for (Path sub : (Iterable<Path>) stream::iterator) {
                if (Files.isDirectory(sub)) {
                    dirs.add(sub);
                } else {
                    readStatementsFromFile(sub, db, settings);
                }
            }

            for (Path sub : dirs) {
                readStatementsFromDirectory(sub, db, settings);
            }
        }
    }

    private void readStatementsFromFile(Path sub, AbstractDatabase db, ISettings settings)
            throws InterruptedException, IOException {
        String filePath = sub.toString();
        if (filePath.endsWith(".zip")) {
            db.addLib(getLibrary(filePath, settings, settings.isIgnorePrivileges()), null, null);
        } else if (filePath.endsWith(".sql")) {
            PgDumpLoader loader = new PgDumpLoader(sub, settings);
            loader.loadDatabase(db, antlrTasks);
            launchedLoaders.add(loader);
        }
    }
}
