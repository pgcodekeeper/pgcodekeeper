package ru.taximaxim.codekeeper.ui.libraries;

import java.nio.file.Path;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;

import ru.taximaxim.codekeeper.ui.Activator;

public class FileLibrary extends AbstractLibrary {

    FileLibrary(AbstractLibrary parent, Path path) {
        super(parent, path);
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public String getLabel() {
        StringBuilder sb = new StringBuilder(name);

        if (getParent() instanceof LibraryContainer) {
            sb.append(" - ").append(path.getParent()); //$NON-NLS-1$
        }

        return sb.toString();
    }

    @Override
    public Image getImage() {
        return Activator.getEclipseImage(ISharedImages.IMG_OBJ_FILE);
    }
}
