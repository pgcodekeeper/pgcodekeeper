package cz.startnet.utils.pgdiff.loader.copiedfromui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;

public class ReadOnlyFileRemover {
    
    public static void remove(Path path) throws IOException {
        Files.getFileAttributeView(path, DosFileAttributeView.class).setReadOnly(false);
        Files.delete(path);
    }
}
