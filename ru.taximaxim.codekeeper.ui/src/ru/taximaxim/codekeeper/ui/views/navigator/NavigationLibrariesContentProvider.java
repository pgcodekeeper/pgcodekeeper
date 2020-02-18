package ru.taximaxim.codekeeper.ui.views.navigator;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;

import cz.startnet.utils.pgdiff.libraries.PgLibrary;
import cz.startnet.utils.pgdiff.xmlstore.DependenciesXmlStore;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
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
                List<PgLibrary> libs = new DependenciesXmlStore(Paths.get(proj.getLocation()
                        .append(DependenciesXmlStore.FILE_NAME).toString())).readObjects();
                return new Object[] {LibraryUtils.create(libs, proj.getName(), proj.hasNature(NATURE.MS))};
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
