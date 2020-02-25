package ru.taximaxim.codekeeper.ui.libraries;

import java.net.URI;

import org.eclipse.swt.graphics.Image;

import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class UrlLibrary extends CacheableLibrary {

    UrlLibrary(AbstractLibrary parent, URI uri) {
        super(parent, FileUtils.getLoadedFilePath(LibraryUtils.META_PATH, uri),
                FileUtils.getNameFromUri(uri), uri.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        if (!exists()) {
            sb.append(" [not loaded]"); //$NON-NLS-1$
        }

        if (parent instanceof RootLibrary) {
            sb.append(CONCAT_STRING).append(getLibPath());
        }

        return sb.toString();
    }

    @Override
    public Image getImage() {
        return Activator.getRegisteredImage(FILE.ICONCLOUD);
    }
}
