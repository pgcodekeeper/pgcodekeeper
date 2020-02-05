package ru.taximaxim.codekeeper.ui.libraries;

import java.nio.file.Path;

import org.eclipse.swt.graphics.Image;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class SimpleLibrary extends AbstractLibrary {

    SimpleLibrary(AbstractLibrary parent, Path path, String name, boolean isMsSql) {
        super(parent, path, name, isMsSql);
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
        return Activator.getRegisteredImage(FILE.ICONDATABASE);
    }
}
