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
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import cz.startnet.utils.pgdiff.libraries.PgLibrary;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;

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
        AbstractLibrary root = new LibraryContainer(isMsSql, project);

        for (PgLibrary lib : libs) {
            String path = lib.getPath();
            switch (lib.getSource()) {
            case JDBC:
                new SimpleLibrary(root, JdbcConnector.dbNameFromUrl(path));
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
                new SimpleLibrary(root, path);
                break;
            case LOCAL:
                readFile(root, Paths.get(path));
                break;
            }
        }

        return root;
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
        try (Stream<Path> stream = Files.list(path).sorted(DIR_COMPARATOR)) {
            for (Path sub : (Iterable<Path>) stream::iterator) {
                readFile(parent, sub);
            }
        }
    }

    public static void openLibrary(FileLibrary lib) throws PartInitException {
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        LibraryEditorInput input = new LibraryEditorInput(lib);
        IDE.openEditor(page, input, EDITOR.SQL);
    }

    private LibraryUtils() {
        // only statics
    }
}
