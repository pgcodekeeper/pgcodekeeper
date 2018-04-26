package ru.taximaxim.codekeeper.ui.views.navigator;

import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.navigator.IDescriptionProvider;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class NavigationLibrariesLabelProvider extends LabelProvider
implements IDescriptionProvider {

    @Override
    public String getDescription(Object anElement) {
        return null;
    }

    @Override
    public String getText(Object element) {
        if (element instanceof IProject) {
            return null;
        }
        return super.getText(element);
    }

    @Override
    public Image getImage(Object element) {
        if (element instanceof LibraryContainer) {
            LibraryContainer container = (LibraryContainer) element;
            Path path = container.getPath();
            if (path == null) {
                if (container.isRoot()) {
                    return Activator.getRegisteredImage(FILE.ICONLIB);
                } else {
                    return Activator.getRegisteredImage(FILE.ICONDATABASE);
                }
            }

            return Activator.getEclipseImage(Files.isDirectory(path) ?
                    ISharedImages.IMG_OBJ_FOLDER : ISharedImages.IMG_OBJ_FILE);
        }
        return null;
    }
}
