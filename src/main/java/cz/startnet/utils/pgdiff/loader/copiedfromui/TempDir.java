package cz.startnet.utils.pgdiff.loader.copiedfromui;

import java.io.File;
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
    
    private final File dir;
    
    public TempDir(String prefix) throws IOException {
        this.dir = Files.createTempDirectory(prefix).toFile();
    }
    
    public TempDir(Path dir, String prefix) throws IOException {
        this.dir = Files.createTempDirectory(dir, prefix).toFile();
    }

    public File get() {
        return dir;
    }
    
    @Override
    public void close() throws IOException {
        Dir.deleteRecursive(dir);
    }
}
