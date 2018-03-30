package ru.taximaxim.codekeeper.apgdiff.fileutils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.PgDiffUtils;

public final class FileUtils {

    public static final DateTimeFormatter FILE_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH''mm''ss");
    public static final Pattern INVALID_FILENAME = Pattern.compile("[\\\\/:*?\"<>|]");

    /**
     * Deletes folder and its contents recursively. FOLLOWS SYMLINKS!
     */
    public static void deleteRecursive(Path f) throws IOException {
        if (Files.isDirectory(f)) {
            try (Stream<Path> stream = Files.list(f)){
                for (Path sub : PgDiffUtils.sIter(stream)) {
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

    public static String sanitizeFilename(String name) {
        return INVALID_FILENAME.matcher(name).replaceAll("");
    }

    private FileUtils() {
    }
}
