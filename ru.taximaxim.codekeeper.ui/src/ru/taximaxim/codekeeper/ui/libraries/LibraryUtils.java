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
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.ui.Activator;

public class LibraryUtils {

    public static final Path META_PATH = Paths.get(Platform.getStateLocation(
            Activator.getContext().getBundle()).append("dependencies").toString()); //$NON-NLS-1$

    private static final Comparator<Path> DIR_COMPORATOR = (p1, p2) -> {
        boolean bool = Files.isDirectory(p1);
        if (bool == Files.isDirectory(p2)) {
            return 0;
        }

        return bool ? -1 : 1;
    };


    public static AbstractLibrary create(List<PgLibrary> libs, boolean isMsSql) throws IOException {
        AbstractLibrary root = new LibraryContainer(isMsSql);

        for (PgLibrary lib : libs) {
            String path = lib.getPath();
            switch (lib.getSource()) {
            case JDBC:
                new SimpleLibrary(root, null, JdbcConnector.dbNameFromUrl(path), isMsSql);
                break;
            case URL:
                try {
                    String urlPath = new URI(path).getPath();
                    if (urlPath != null) {
                        path = urlPath.substring(urlPath.lastIndexOf('/') + 1) + " - " +  path; //$NON-NLS-1$
                    }
                } catch (URISyntaxException e) {
                    // Nothing to do, use default path
                }
                new SimpleLibrary(root, null, path, isMsSql);
                break;
            case LOCAL:
                Path p = Paths.get(path);
                if (Files.isDirectory(p) && Files.exists(p.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER))) {
                    readProject(root, p);
                } else {
                    readFile(root, p);
                }
                break;
            }
        }

        return root;
    }

    private static void readProject(AbstractLibrary parent, Path p) throws IOException {
        AbstractLibrary proj = new DirectoryLibrary(parent, p);
        Path extension = p.resolve(ApgdiffConsts.WORK_DIR_NAMES.EXTENSION.toString());
        if (Files.exists(extension)) {
            readFile(proj, extension);
        }

        Path schema = p.resolve(ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.toString());
        if (Files.exists(schema)) {
            readFile(proj, schema);
        }
    }

    private static void readFile(AbstractLibrary parent, Path path) throws IOException {
        if (Files.isDirectory(path)) {
            readDir(new DirectoryLibrary(parent, path), path);
        } else if (FileUtils.isZipFile(path)) {
            readZip(new ZipLibrary(parent, path), path);
        } else {
            new FileLibrary(parent, path);
        }
    }

    private static void readDir(AbstractLibrary parent, Path path) throws IOException {
        try (Stream<Path> stream = Files.list(path).sorted(DIR_COMPORATOR)) {
            for (Path sub : (Iterable<Path>) stream::iterator) {
                readFile(parent, sub);
            }
        }
    }

    static void readZip(ZipLibrary parent, Path path) throws IOException {
        Path unZipped = FileUtils.getUnzippedFilePath(META_PATH, path);
        if (Files.exists(unZipped)) {
            readDir(parent, unZipped);
            parent.setZipped(false);
        } else {
            parent.setZipped(true);
        }
    }

    private LibraryUtils() {
        // only statics
    }
}
