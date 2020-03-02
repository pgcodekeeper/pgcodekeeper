package ru.taximaxim.codekeeper.ui.libraries;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.eclipse.core.runtime.Platform;

import cz.startnet.utils.pgdiff.libraries.PgLibrary;
import cz.startnet.utils.pgdiff.libraries.PgLibrarySource;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.xmlstore.DependenciesXmlStore;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.ui.Activator;

public class LibraryUtils {

    public static final Path META_PATH = Paths.get(Platform.getStateLocation(
            Activator.getContext().getBundle()).append("dependencies").toString()); //$NON-NLS-1$

    private static final Comparator<Path> DIR_COMPARATOR = (p1, p2) -> {
        boolean bool = Files.isDirectory(p1);
        if (bool == Files.isDirectory(p2)) {
            return p1.compareTo(p2);
        }

        return bool ? -1 : 1;
    };

    public static AbstractLibrary create(List<PgLibrary> libs, String project,
            boolean isMsSql) throws IOException {
        AbstractLibrary root = new RootLibrary(isMsSql, project);

        for (PgLibrary lib : libs) {
            readLib(root, lib);
        }

        return root;
    }

    private static void readLib(AbstractLibrary root, PgLibrary lib) throws IOException {
        String path = lib.getPath();
        switch (PgLibrarySource.getSource(path)) {
        case JDBC:
            new SimpleLibrary(root, JdbcConnector.dbNameFromUrl(path));
            break;
        case URL:
            try {
                UrlLibrary url = new UrlLibrary(root, new URI(path));
                readDir(url, url.getPath());
            } catch (URISyntaxException e) {
                // use default path
                new SimpleLibrary(root, path);
            }
            break;
        case LOCAL:
            readFile(root, Paths.get(path));
            break;
        }
    }

    private static void readFile(AbstractLibrary parent, Path path) throws IOException {
        if (Files.isDirectory(path)) {
            readDir(new DirectoryLibrary(parent, path), path);
        } else if (FileUtils.isZipFile(path)) {
            ZipLibrary zip = new ZipLibrary(parent, path);
            readDir(zip, zip.getPath());
        } else {
            new FileLibrary(parent, path);
        }
    }

    static void readDir(AbstractLibrary parent, Path path) throws IOException {
        if (Files.notExists(path)) {
            return;
        }

        if (Files.exists(path.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER))) {
            readProject(parent, path);
            return;
        }

        try (Stream<Path> stream = Files.list(path).sorted(DIR_COMPARATOR)) {
            for (Path sub : (Iterable<Path>) stream::iterator) {
                readFile(parent, sub);
            }
        }
    }

    private static void readProject(AbstractLibrary parent, Path path) throws IOException {
        Path extension = path.resolve(ApgdiffConsts.WORK_DIR_NAMES.EXTENSION.toString());
        if (Files.exists(extension)) {
            readFile(parent, extension);
        }

        Path schema = path.resolve(ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.toString());
        if (Files.exists(schema)) {
            readFile(parent, schema);
        }

        while (!(parent instanceof RootLibrary)) {
            parent = parent.getParent();
        }

        Path xml = path.resolve(DependenciesXmlStore.FILE_NAME);

        for (PgLibrary lib : new DependenciesXmlStore(xml).readObjects()) {
            readLib(parent, lib);
        }
    }

    public static FileLibrary createFileLib(Path path, String projectName, boolean isMsSql) {
        FileLibrary lib = new FileLibrary(null, path);
        lib.setProject(projectName);
        lib.setMsSql(isMsSql);
        return lib;
    }

    public static String getDescription(AbstractLibrary lib) {
        if (lib == null || lib instanceof RootLibrary) {
            return ""; //$NON-NLS-1$
        }

        StringBuilder sb = new StringBuilder(lib.getName());

        AbstractLibrary parent = lib.getParent();
        while (parent != null && !(parent instanceof RootLibrary)) {
            sb.insert(0, '/');
            sb.insert(0, parent.getName());
            parent = parent.getParent();
        }

        sb.append(AbstractLibrary.CONCAT_STRING).append(lib.getPath());

        return sb.toString();
    }

    private LibraryUtils() {
        // only statics
    }
}
