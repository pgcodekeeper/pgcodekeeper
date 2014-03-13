package ru.taximaxim.codekeeper.ui.fileutils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Wrapper for creation and auto deletion of a temp file.
 * Intended for try-with-resources.
 * 
 * @author Alexander Levsha
 */
public class TempFile implements AutoCloseable {
    
    private final File f;
    
    public TempFile(String prefix, String suffix) throws IOException {
        this.f = Files.createTempFile(prefix, suffix).toFile();
    }
    /*
    public TempFile(Path dir, String prefix, String suffix) throws IOException {
        this.f = Files.createTempFile(dir, prefix, suffix).toFile();
    }
    */
    public File get() {
        return f;
    }
    
    @Override
    public void close() throws IOException {
        Files.delete(f.toPath());
    }
}
