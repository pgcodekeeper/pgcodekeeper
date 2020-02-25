package ru.taximaxim.codekeeper.ui.views.navigator;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.navigator.IDescriptionProvider;

import ru.taximaxim.codekeeper.ui.libraries.AbstractLibrary;
import ru.taximaxim.codekeeper.ui.libraries.LibraryUtils;

public class NavigationLibrariesLabelProvider extends LabelProvider
implements IDescriptionProvider {

    @Override
    public String getDescription(Object element) {
        if (element instanceof AbstractLibrary) {
            return LibraryUtils.getDescription((AbstractLibrary) element);
        }

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
        if (element instanceof AbstractLibrary) {
            return ((AbstractLibrary) element).getImage();
        }

        return null;
    }
}
