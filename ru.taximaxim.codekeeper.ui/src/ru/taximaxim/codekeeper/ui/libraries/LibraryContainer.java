package ru.taximaxim.codekeeper.ui.libraries;

import org.eclipse.swt.graphics.Image;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class LibraryContainer extends AbstractLibrary {

    LibraryContainer(boolean isMsSql, String project) {
        super(null, null, Messages.LibraryContainer_root);
        this.isMsSql = isMsSql;
        this.project = project;
    }

    @Override
    public Image getImage() {
        return Activator.getRegisteredImage(FILE.ICONLIB);
    }
}
