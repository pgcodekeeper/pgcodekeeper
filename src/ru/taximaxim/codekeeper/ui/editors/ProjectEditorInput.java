package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.model.IWorkbenchAdapter;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectEditorInput extends PlatformObject implements IEditorInput {

    private final String projName;
    
    public ProjectEditorInput(String projectName) {
        projName = projectName;
    }
    
    public IProject getProject() {
        return ResourcesPlugin.getWorkspace().getRoot().getProject(projName);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
        if (adapter.isAssignableFrom(IProject.class)) {
            return getProject();
        }
        
        if (adapter.isAssignableFrom(IWorkbenchAdapter.class)) {
            return new IWorkbenchAdapter() {
                
                @Override
                public Object getParent(Object o) {
                    return getProject().getParent();
                }
                
                @Override
                public Object[] getChildren(Object o) {
                    IProject proj = getProject();
                    if (proj.isOpen()) {
                        try {
                            return proj.members();
                        } catch (CoreException ex) {
                            // return empty array
                        }
                    }
                    return new Object[0];
                }
                
                @Override
                public String getLabel(Object o) {
                    return getProject().getName();
                }
                
                @Override
                public ImageDescriptor getImageDescriptor(Object object) {
                    return ImageDescriptor.createFromURL(Activator.getContext()
                            .getBundle().getResource(FILE.ICONAPPSMALL));
                }
            };
        }
        
        return super.getAdapter(adapter);
    }

    @Override
    public boolean exists() {
        return projName != null || !projName.isEmpty();
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return ImageDescriptor.createFromURL(Activator.getContext().getBundle()
                .getResource(FILE.ICONAPPSMALL));
    }

    @Override
    public String getName() {
        return projName;
    }

    @Override
    public IPersistableElement getPersistable() {
        // see FileEditorInput for impl
        return null;
    }

    @Override
    public String getToolTipText() {
        return projName + Messages.ProjectEditorInput_pgcodekeeper_project;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + projName.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProjectEditorInput)) {
            return false;
        }
        ProjectEditorInput other = (ProjectEditorInput) obj;
        if (!projName.equals(other.projName)) {
            return false;
        }
        return true;
    }
}
