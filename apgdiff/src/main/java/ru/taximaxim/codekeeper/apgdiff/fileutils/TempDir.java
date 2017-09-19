package ru.taximaxim.codekeeper.apgdiff.fileutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Wrapper for creation and automatic recursive deletion of a temp directory.
 * Intended for try-with-resources.
 *
 * @author Alexander Levsha
 */
public class TempDir implements AutoCloseable {

    private final Path dir;

    public TempDir(String prefix) throws IOException {
        this.dir = Files.createTempDirectory(prefix);
    }

    public TempDir(Path dir, String prefix) throws IOException {
        this.dir = Files.createTempDirectory(dir, prefix);
    }

    public Path get() {
        return dir;
    }

    @Override
    public void close() throws IOException {
        FileUtils.deleteRecursive(dir);
    }
}
