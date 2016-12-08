package ru.taximaxim.codekeeper.ui.fileutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;

public final class ReadOnlyFileRemover {

    public static void remove(Path path) throws IOException {
        DosFileAttributeView att = Files.getFileAttributeView(path, DosFileAttributeView.class);
        if (att != null) {
            att.setReadOnly(false);
        }
        Files.delete(path);
    }

    private ReadOnlyFileRemover() {}
}
