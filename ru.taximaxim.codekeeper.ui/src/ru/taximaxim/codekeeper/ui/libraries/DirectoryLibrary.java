package ru.taximaxim.codekeeper.ui.libraries;

import java.nio.file.Path;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;

import ru.taximaxim.codekeeper.ui.Activator;

public class DirectoryLibrary extends AbstractLibrary {

    DirectoryLibrary(AbstractLibrary parent, Path path) {
        super(parent, path);
    }

    @Override
    public Image getImage() {
        return Activator.getEclipseImage(ISharedImages.IMG_OBJ_FOLDER);
    }
}
