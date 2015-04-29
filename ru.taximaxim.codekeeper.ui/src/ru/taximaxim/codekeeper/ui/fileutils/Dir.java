package ru.taximaxim.codekeeper.ui.fileutils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public final class Dir {

    /**
     * Deletes folder and its contents recursively. FOLLOWS SYMLINKS!
     */
    public static void deleteRecursive(File f) throws IOException {
        if (f.isDirectory()) {
            for (File sub : f.listFiles()) {
                deleteRecursive(sub);
            }
        }
        ReadOnlyFileRemover.remove(f.toPath());
    }
    
    /**
     * Tries to use <code>Files.move()</code>
     * with <code>StandardCopyOption.ATOMIC_MOVE</code>.
     */
    public static void moveDirAtomic(File source, File destination) throws IOException {
        Files.move(source.toPath(), destination.toPath(), StandardCopyOption.ATOMIC_MOVE);
    }
    
    private Dir() {}
}
