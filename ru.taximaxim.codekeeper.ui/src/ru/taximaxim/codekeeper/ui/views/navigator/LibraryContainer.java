package ru.taximaxim.codekeeper.ui.views.navigator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.properties.PgLibrary;

public class LibraryContainer {

    private static final String ROOT = Messages.LibraryContainer_root;

    private final LibraryContainer parent;
    private final Path path;
    private final String name;
    private final List<LibraryContainer> children = new ArrayList<>();

    private LibraryContainer(LibraryContainer parent, Path path) {
        this(parent, path, path.getFileName().toString());
    }

    private LibraryContainer(LibraryContainer parent, Path path, String name) {
        this.parent = parent;
        this.path = path;
        this.name = name;
        if (parent != null) {
            parent.addChild(this);
        }
    }

    public static LibraryContainer create(List<PgLibrary> libs) throws IOException {
        LibraryContainer root = new LibraryContainer(null, null, ROOT);

        for (PgLibrary lib : libs) {
            String path = lib.getPath();
            if (path.startsWith("jdbc:")) { //$NON-NLS-1$
                new LibraryContainer(root, null, JdbcConnector.dbNameFromUrl(path));
            } else {
                Path p = Paths.get(path);
                if (Files.isDirectory(p) && Files.exists(p.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER))) {
                    readProject(root, p);
                } else {
                    readFile(root, p);
                }
            }
        }

        return root;
    }

    private static void readProject(LibraryContainer parent, Path p) throws IOException {
        LibraryContainer proj = new LibraryContainer(parent, p);
        Path extension = p.resolve(ApgdiffConsts.WORK_DIR_NAMES.EXTENSION.toString());
        if (Files.exists(extension)) {
            readFile(proj, extension);
        }

        Path schema = p.resolve(ApgdiffConsts.WORK_DIR_NAMES.SCHEMA.toString());
        if (Files.exists(schema)) {
            readFile(proj, schema);
        }
    }

    private static void readFile(LibraryContainer parent, final Path path) throws IOException {
        if (Files.isDirectory(path)) {
            LibraryContainer dir = new LibraryContainer(parent, path);
            Comparator<Path> comparator = (p1, p2) -> {
                boolean bool = Files.isDirectory(p1);
                if (bool == Files.isDirectory(p2)) {
                    return 0;
                }

                return bool ? -1 : 1;
            };

            try (Stream<Path> stream = Files.list(path).sorted(comparator)) {
                for (Path sub : (Iterable<Path>) stream::iterator) {
                    readFile(dir, sub);
                }
            }
        } else {
            new LibraryContainer(parent, path);
        }
    }

    public Path getPath() {
        return path;
    }

    public LibraryContainer getParent() {
        return parent;
    }

    private void addChild(LibraryContainer child) {
        children.add(child);
    }

    public List<LibraryContainer> getChildren() {
        return children;
    }

    public boolean isEnableToOpen() {
        if (path == null) {
            return false;
        }

        return Files.exists(path) && !Files.isDirectory(path);
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    public boolean isRoot() {
        return name == ROOT;
    }

    @Override
    public String toString() {
        return path != null && getParent().isRoot() ? name + " - " + path.getParent() : name; //$NON-NLS-1$
    }
}
