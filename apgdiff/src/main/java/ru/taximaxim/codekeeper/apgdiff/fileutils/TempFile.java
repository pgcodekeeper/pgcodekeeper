package ru.taximaxim.codekeeper.apgdiff.fileutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Wrapper for creation and auto deletion of a temp file.
 * Intended for try-with-resources.
 *
 * @author Alexander Levsha
 */
public class TempFile implements AutoCloseable {

    private final Path f;

    public TempFile(String prefix, String suffix) throws IOException {
        this.f = Files.createTempFile(prefix, suffix);
    }

    public TempFile(Path dir, String prefix, String suffix) throws IOException {
        this.f = Files.createTempFile(dir, prefix, suffix);
    }

    public Path get() {
        return f;
    }

    @Override
    public void close() throws IOException {
        FileUtils.removeReadOnly(f);
    }
}
