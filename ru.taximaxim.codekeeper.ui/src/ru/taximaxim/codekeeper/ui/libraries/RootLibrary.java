package ru.taximaxim.codekeeper.ui.libraries;

import org.eclipse.swt.graphics.Image;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class RootLibrary extends AbstractLibrary {

    RootLibrary() {
        super(null, null, Messages.LibraryContainer_root);
    }

    @Override
    public Image getImage() {
        return Activator.getRegisteredImage(FILE.ICONLIB);
    }

    @Override
    protected String getDescriptionRecursive() {
        return ""; //$NON-NLS-1$
    }
}
