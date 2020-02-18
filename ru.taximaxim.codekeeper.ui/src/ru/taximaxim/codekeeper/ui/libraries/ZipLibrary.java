package ru.taximaxim.codekeeper.ui.libraries;

import java.io.IOException;
import java.nio.file.Path;

import org.eclipse.swt.graphics.Image;

import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class ZipLibrary extends AbstractLibrary {

    ZipLibrary(AbstractLibrary parent, Path path) {
        super(parent, FileUtils.getUnzippedFilePath(LibraryUtils.META_PATH, path), path.getFileName().toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        if (!exists()) {
            sb.append(" [not unzipped]"); //$NON-NLS-1$
        }

        if (getParent() instanceof LibraryContainer) {
            sb.append(" - ").append(path.getParent()); //$NON-NLS-1$
        }

        return sb.toString();
    }

    @Override
    public Image getImage() {
        return Activator.getRegisteredImage(FILE.ZIP);
    }

    public void clearCache() throws IOException {
        children.clear();
        if (exists()) {
            FileUtils.deleteRecursive(path);
        }
    }

    public void reload() throws IOException {
        children.clear();
        LibraryUtils.readDir(this, path);
    }
}
