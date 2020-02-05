package ru.taximaxim.codekeeper.ui.libraries;

import org.eclipse.swt.graphics.Image;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class LibraryContainer extends AbstractLibrary {

    private static final String ROOT = Messages.LibraryContainer_root;

    LibraryContainer(boolean isMsSql) {
        super(null, null, ROOT, isMsSql);
    }

    @Override
    public String getLabel() {
        return ROOT;
    }

    @Override
    public Image getImage() {
        return Activator.getRegisteredImage(FILE.ICONLIB);
    }
}
