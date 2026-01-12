/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.libraries;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.pgcodekeeper.core.Consts;
import org.pgcodekeeper.core.DatabaseType;
import org.pgcodekeeper.core.Utils;
import org.pgcodekeeper.core.WorkDirs;
import org.pgcodekeeper.core.library.PgLibrary;
import org.pgcodekeeper.core.library.PgLibrarySource;
import org.pgcodekeeper.core.utils.FileUtils;
import org.pgcodekeeper.core.xmlstore.DependenciesXmlStore;

public class UiLibraryLoader {

    private static final Pattern ZIP_HASH_END = Pattern.compile("\\.zip_[0-9a-f]{10}$");

    private static final Comparator<Path> DIR_COMPARATOR = (p1, p2) -> {
        boolean bool = Files.isDirectory(p1);
        if (bool == Files.isDirectory(p2)) {
            return p1.compareTo(p2);
        }

        return bool ? -1 : 1;
    };

    private final String project;
    private final DatabaseType dbType;
    private final Path xmlPath;
    private boolean loadNested;

    private final Set<String> loadedLibs = new HashSet<>();

    public UiLibraryLoader(String project, DatabaseType dbType, boolean loadNested, Path xmlPath) {
        this.project = project;
        this.dbType = dbType;
        this.loadNested = loadNested;
        this.xmlPath = xmlPath;
    }

    public RootLibrary load(List<PgLibrary> libs) throws IOException {
        RootLibrary root = RootLibrary.getRootLib(project);
        LibraryStorage.clean(root);
        root.clearChildren();

        for (PgLibrary lib : libs) {
            readLib(root, lib);
        }

        return root;
    }

    private void readLib(AbstractLibrary root, PgLibrary lib) throws IOException {
        readLib(root, lib.path());
    }

    void readLib(AbstractLibrary root, String path) throws IOException {
        if (!loadedLibs.add(path)) {
            return;
        }

        switch (PgLibrarySource.getSource(path)) {
        case JDBC:
            new JdbcLibrary(root, path);
            break;
        case URL:
            try {
                UrlLibrary url = new UrlLibrary(root, new URI(path), project, dbType);
                url.load();
                readPath(url, url.getPath());
            } catch (URISyntaxException e) {
                // shouldn't happen, already checked by getSource
                // not URI, try to folder or file
            }
            break;
        case LOCAL:
            readPath(root, Paths.get(path));
            break;
        }
    }

    private void readPath(AbstractLibrary parent, Path path) throws IOException {
        if (!path.isAbsolute()) {
            path = xmlPath.resolveSibling(path).normalize();
        }

        if (Files.notExists(path)) {
            return;
        }

        if (Files.isDirectory(path)) {
            if (isHidden(parent, path)) {
                readDir(parent, path);
            } else {
                readDir(new DirectoryLibrary(parent, path), path);
            }
        } else if (FileUtils.isZipFile(path)) {
            ZipLibrary zip;
            if (parent instanceof RootLibrary) {
                zip = new ZipLibrary(parent, path, project, dbType);
                parent = zip;
            } else {
                zip = new ZipLibrary(null, path, project, dbType);
            }
            zip.load();
            readPath(parent, zip.getPath());
        } else {
            new FileLibrary(parent, path, project, dbType);
        }
    }

    private boolean isHidden(AbstractLibrary parent, Path path) {
        return parent instanceof CacheableLibrary && ZIP_HASH_END.matcher(path.toString()).find();
    }

    private void readDir(AbstractLibrary parent, Path path) throws IOException {
        if (Files.exists(path.resolve(Consts.FILENAME_WORKING_DIR_MARKER))) {
            readProject(parent, path);
            return;
        }

        try (Stream<Path> stream = Files.list(path).sorted(DIR_COMPARATOR)) {
            for (Path sub : Utils.streamIterator(stream)) {
                readPath(parent, sub);
            }
        }
    }

    private void readProject(AbstractLibrary parent, Path path) throws IOException {
        for (String name : WorkDirs.getDirectoryNames(DatabaseType.PG)) {
            Path dirPath = path.resolve(name);
            if (Files.exists(dirPath)) {
                readPath(parent, dirPath);
            }
        }

        if (!loadNested) {
            return;
        }

        while (!(parent instanceof RootLibrary)) {
            parent = parent.getParent();
        }

        Path xml = path.resolve(DependenciesXmlStore.FILE_NAME);

        DependenciesXmlStore xmlStore = new DependenciesXmlStore(xml);
        List<PgLibrary> libs = xmlStore.readObjects();
        boolean oldLoadNested = loadNested;
        try {
            loadNested = xmlStore.readLoadNestedFlag();
            for (PgLibrary lib : libs) {
                readLib(parent, lib);
            }
        } finally {
            loadNested = oldLoadNested;
        }
    }
}
