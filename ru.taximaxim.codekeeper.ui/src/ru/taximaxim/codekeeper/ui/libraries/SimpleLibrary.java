package ru.taximaxim.codekeeper.ui.libraries;

import org.eclipse.swt.graphics.Image;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class SimpleLibrary extends AbstractLibrary {

    SimpleLibrary(AbstractLibrary parent, String name) {
        super(parent, null, name);
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public Image getImage() {
        return Activator.getRegisteredImage(FILE.ICONDATABASE);
    }
}
