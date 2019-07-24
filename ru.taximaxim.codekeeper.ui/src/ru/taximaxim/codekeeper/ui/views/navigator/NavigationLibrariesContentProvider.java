package ru.taximaxim.codekeeper.ui.views.navigator;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;

import cz.startnet.utils.pgdiff.libraries.PgLibrary;
import cz.startnet.utils.pgdiff.xmlstore.DependenciesXmlStore;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;

public class NavigationLibrariesContentProvider implements ITreeContentProvider {

    @Override
    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }

    @Override
    public Object[] getChildren(Object parent) {
        if (parent instanceof IProject) {
            try {
                IProject proj = ((IProject)parent);
                List<PgLibrary> libs = new DependenciesXmlStore(Paths.get(proj.getLocation()
                        .append(DependenciesXmlStore.FILE_NAME).toString())).readObjects();
                return new Object[] {LibraryContainer.create(libs, proj.hasNature(NATURE.MS))};
            } catch (IOException | CoreException e) {
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
