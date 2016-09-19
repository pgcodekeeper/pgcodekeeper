package ru.taximaxim.codekeeper.ui.views.navigator;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ITreeContentProvider;

public class NavigatorRootContentProvider implements ITreeContentProvider {

    @Override
    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        if (parentElement instanceof IProject) {
            return new Object[] { new OpenProjectFromNavigator((IProject) parentElement) };
        }
        return null;
    }

    @Override
    public Object getParent(Object element) {
        return null;
    }

    @Override
    public boolean hasChildren(Object element) {
        return !(element instanceof OpenProjectFromNavigator);
    }
}
