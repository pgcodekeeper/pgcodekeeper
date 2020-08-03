package ru.taximaxim.codekeeper.apgdiff.fileutils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.PgDiffUtils;

public final class FileUtils {

    private static final DateTimeFormatter FILE_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH''mm''ss");
    private static final Pattern INVALID_FILENAME = Pattern.compile("[\\\\/:*?\"<>|]");

    /**
     * Deletes folder and its contents recursively.
     */
    public static void deleteRecursive(Path f) throws IOException {
        if (Files.isDirectory(f, LinkOption.NOFOLLOW_LINKS)) {
            try (Stream<Path> stream = Files.list(f)){
                for (Path sub : PgDiffUtils.sIter(stream)) {
                    deleteRecursive(sub);
                }
            } catch (UncheckedIOException wrapEx) {
                throw wrapEx.getCause();
            }
        }
        removeReadOnly(f);
    }

    public static void removeReadOnly(Path path) throws IOException {
        DosFileAttributeView att = Files.getFileAttributeView(
                path, DosFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
        if (att != null) {
            try {
                att.setReadOnly(false);
            } catch (FileSystemException ex) {
                // expected behaviour for symlinks on linux
                // the impl calls open(path, O_RDONLY | O_NOFOLLOW, 0)
                // which returns ELOOP which is translated into this exception
            }
        }
        Files.delete(path);
    }

    public static String sanitizeFilename(String name) {
        return INVALID_FILENAME.matcher(name).replaceAll("");
    }

    public static String getValidFilename(String name) {
        Matcher m = INVALID_FILENAME.matcher(name);
        if (m.find()) {
            return m.replaceAll("_"); //$NON-NLS-1$
        } else {
            return name;
        }
    }

    public static String getFileDate() {
        return FILE_DATE.format(LocalDateTime.now());
    }

    private FileUtils() {
    }
}
