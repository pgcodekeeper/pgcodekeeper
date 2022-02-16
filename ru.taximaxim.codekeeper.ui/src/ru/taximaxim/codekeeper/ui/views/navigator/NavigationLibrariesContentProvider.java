package ru.taximaxim.codekeeper.ui.views.navigator;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.libraries.AbstractLibrary;
import ru.taximaxim.codekeeper.ui.libraries.LibraryUtils;

public class NavigationLibrariesContentProvider implements ITreeContentProvider {

    private static final Object[] NO_CHILDREN = new Object[0];

    @Override
    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }

    @Override
    public Object[] getChildren(Object parent) {
        if (parent instanceof IProject) {
            try {
                IProject proj = (IProject) parent;
                return new Object[] {LibraryUtils.create(proj)};
            } catch (IOException | CoreException e) {
                Log.log(e);
            }
        } else if (parent instanceof AbstractLibrary) {
            return ((AbstractLibrary) parent).getChildren().toArray();
        }

        return NO_CHILDREN;
    }

    @Override
    public Object getParent(Object element) {
        if (element instanceof AbstractLibrary) {
            return ((AbstractLibrary) element).getParent();
        }

        return null;
    }

    @Override
    public boolean hasChildren(Object element) {
        if (element instanceof AbstractLibrary) {
            return ((AbstractLibrary) element).hasChildren();
        }
        return false;
    }
}
