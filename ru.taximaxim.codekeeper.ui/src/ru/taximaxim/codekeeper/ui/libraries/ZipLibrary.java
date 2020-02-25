package ru.taximaxim.codekeeper.ui.libraries;

import java.nio.file.Path;

import org.eclipse.swt.graphics.Image;

import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class ZipLibrary extends CacheableLibrary {

    ZipLibrary(AbstractLibrary parent, Path path) {
        super(parent, FileUtils.getUnzippedFilePath(LibraryUtils.META_PATH, path),
                path.getFileName().toString(), path.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        if (!exists()) {
            sb.append(" [not unzipped]"); //$NON-NLS-1$
        }

        if (parent instanceof RootLibrary) {
            sb.append(CONCAT_STRING).append(getLibPath());
        }

        return sb.toString();
    }

    @Override
    public Image getImage() {
        return Activator.getRegisteredImage(FILE.ZIP);
    }
}
