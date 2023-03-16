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
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.Consts.WORK_DIR_NAMES;
import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.core.libraries.PgLibrary;
import ru.taximaxim.codekeeper.core.libraries.PgLibrarySource;
import ru.taximaxim.codekeeper.core.xmlstore.DependenciesXmlStore;

public class UiLibraryLoader {

    private static final Comparator<Path> DIR_COMPARATOR = (p1, p2) -> {
        boolean bool = Files.isDirectory(p1);
        if (bool == Files.isDirectory(p2)) {
            return p1.compareTo(p2);
        }

        return bool ? -1 : 1;
    };

    private final String project;
    private final boolean isMsSql;
    private boolean loadNested;

    private final Set<String> loadedLibs = new HashSet<>();

    public UiLibraryLoader(String project, boolean isMsSql, boolean loadNested) {
        this.project = project;
        this.isMsSql = isMsSql;
        this.loadNested = loadNested;
    }

    public RootLibrary load(List<PgLibrary> libs) throws IOException {
        RootLibrary root = new RootLibrary();

        for (PgLibrary lib : libs) {
            readLib(root, lib);
        }

        return root;
    }

    private void readLib(AbstractLibrary root, PgLibrary lib) throws IOException {
        readLib(root, lib.getPath());
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
                UrlLibrary url = new UrlLibrary(root, new URI(path), project, isMsSql);
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
        if (Files.isDirectory(path)) {
            readDir(new DirectoryLibrary(parent, path), path);
        } else if (FileUtils.isZipFile(path)) {
            ZipLibrary zip = new ZipLibrary(parent, path, project, isMsSql);
            readPath(zip, zip.getPath());
        } else {
            new FileLibrary(parent, path, project, isMsSql);
        }
    }

    private void readDir(AbstractLibrary parent, Path path) throws IOException {
        if (Files.notExists(path)) {
            return;
        }

        if (Files.exists(path.resolve(Consts.FILENAME_WORKING_DIR_MARKER))) {
            readProject(parent, path);
            return;
        }

        try (Stream<Path> stream = Files.list(path).sorted(DIR_COMPARATOR)) {
            for (Path sub : PgDiffUtils.sIter(stream)) {
                readPath(parent, sub);
            }
        }
    }

    private void readProject(AbstractLibrary parent, Path path) throws IOException {
        for (WORK_DIR_NAMES name : Consts.WORK_DIR_NAMES.values()) {
            Path dirPath = path.resolve(name.name());
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
