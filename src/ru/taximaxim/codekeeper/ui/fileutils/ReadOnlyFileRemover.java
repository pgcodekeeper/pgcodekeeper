package ru.taximaxim.codekeeper.ui.fileutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;

public class ReadOnlyFileRemover {
    
    public static void remove(Path path) throws IOException {
        Files.getFileAttributeView(path, DosFileAttributeView.class,
                (LinkOption) null).setReadOnly(false);
        Files.delete(path);
    }
}
