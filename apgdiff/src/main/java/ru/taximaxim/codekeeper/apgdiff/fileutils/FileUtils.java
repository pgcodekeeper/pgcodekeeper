package ru.taximaxim.codekeeper.apgdiff.fileutils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public final class FileUtils {

    public static final Pattern INVALID_FILENAME = Pattern.compile("[\\\\/:*?\"<>|]");

    /**
     * Deletes folder and its contents recursively. FOLLOWS SYMLINKS!
     */
    public static void deleteRecursive(Path f) throws IOException {
        if (Files.isDirectory(f)) {
            try (Stream<Path> stream = Files.list(f)){
                Path[] list = stream.toArray(Path[]::new);
                for(Path sub : list) {
                    deleteRecursive(sub);
                }
            } catch (UncheckedIOException wrapEx) {
                throw wrapEx.getCause();
            }
        }
        FileUtils.removeReadOnly(f);
    }

    public static void removeReadOnly(Path path) throws IOException {
        DosFileAttributeView att = Files.getFileAttributeView(path, DosFileAttributeView.class);
        if (att != null) {
            att.setReadOnly(false);
        }
        Files.delete(path);
    }

    private FileUtils() {}
}
