package ru.taximaxim.codekeeper.ui.views.navigator;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ITreeContentProvider;

import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.ui.properties.PgLibrary;
import ru.taximaxim.codekeeper.ui.xmlstore.DependenciesXmlStore;

public class NavigationLibrariesContentProvider implements ITreeContentProvider {

    @Override
    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }

    @Override
    public Object[] getChildren(Object parent) {
        if (parent instanceof IProject) {
            try {
                List<PgLibrary> libs = new DependenciesXmlStore((IProject)parent).readObjects();
                if (!libs.isEmpty()) {
                    return new Object[] {LibraryContainer.create(libs)};
                }
            } catch (IOException e) {
                Log.log(e);
            }
        } else if (parent instanceof LibraryContainer) {
            return ((LibraryContainer) parent).getChildren().toArray();
        }

        return null;
    }

    @Override
    public Object getParent(Object element) {
        if (element instanceof LibraryContainer) {
            return ((LibraryContainer) element).getParent();
        }

        return null;
    }

    @Override
    public boolean hasChildren(Object element) {
        if (element instanceof LibraryContainer) {
            return ((LibraryContainer) element).hasChildren();
        }
        return false;
    }
}
