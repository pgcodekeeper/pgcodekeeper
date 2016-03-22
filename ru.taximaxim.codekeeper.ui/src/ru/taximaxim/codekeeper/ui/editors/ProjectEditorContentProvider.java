package ru.taximaxim.codekeeper.ui.editors;

import java.net.URI;

import org.eclipse.core.internal.resources.Resource;
import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

@SuppressWarnings("restriction")
public class ProjectEditorContentProvider implements ICommonContentProvider {

    private IProject project;
    private IPath path;

    @Override
    public Object[] getElements(Object inputElement) {
        return null;
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        project = (IProject) parentElement;
        Workspace ws = (Workspace) ResourcesPlugin.getWorkspace();
        String ipath = ((IProject) parentElement).getLocation().toOSString() + IPath.SEPARATOR + "codekeepereditor";
        path = new Path(ipath).makeRelative();
        MyElement element = new MyElement(path, ws);
        MyElement[] chilrens = new MyElement[] { element };
        return chilrens;
    }

    @Override
    public Object getParent(Object element) {
        return null;
    }

    @Override
    public boolean hasChildren(Object element) {
        if (element instanceof MyElement) {
            return false;
        }
        return true;
    }

    @Override
    public void dispose() {
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }

    @Override
    public void restoreState(IMemento aMemento) {
    }

    @Override
    public void saveState(IMemento aMemento) {
    }

    @Override
    public void init(ICommonContentExtensionSite aConfig) {
    }

    public class MyElement extends Resource {

        protected MyElement(IPath path, Workspace workspace) {
            super(path, workspace);
        }

        @Override
        public int getType() {
            return 0;
        }

        @Override
        public IProject getProject() {
            return project;
        }

        @Override
        public IPath getLocation() {
            return path;
        }

        @Override
        public URI getLocationURI() {
            return path.toFile().toURI();
        }

        @Override
        public void move(IPath destination, int updateFlags, IProgressMonitor monitor) throws CoreException {
            ;
        }

    }

}
