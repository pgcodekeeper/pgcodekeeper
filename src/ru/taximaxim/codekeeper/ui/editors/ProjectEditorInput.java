package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.PlatformObject;
import java.text.MessageFormat;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.model.IWorkbenchAdapter;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectEditorInput extends PlatformObject implements IEditorInput, IPersistableElement {

    private final String projName;
    private PgCodekeeperUIException ex;
    
    public ProjectEditorInput(String projectName) {
        projName = projectName;
    }
    
    public IProject getProject() {
        return ResourcesPlugin.getWorkspace().getRoot().getProject(projName);
    }
    
    public PgCodekeeperUIException getError() {
        return ex;
    }
    
    public void setError(PgCodekeeperUIException ex) {
        this.ex = ex;
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
        
        if (adapter.isAssignableFrom(org.eclipse.ui.IPersistableElement.class)){
            return this;
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
        return this;
    }

    @Override
    public String getToolTipText() {
        return MessageFormat.format(
                Messages.ProjectEditorInput_pgcodekeeper_project, projName);
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

    @Override
    public void saveState(IMemento memento) {
        ProjectEditorInputFactory.saveState(memento, this);
    }

    @Override
    public String getFactoryId() {
        return ProjectEditorInputFactory.getFactoryId();
    }
}
