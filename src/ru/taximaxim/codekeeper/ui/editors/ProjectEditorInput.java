package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectEditorInput implements IEditorInput  {

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
        return null;
    }

    @Override
    public boolean exists() {
        return projName != null || !projName.isEmpty();
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return null;
    }

    @Override
    public String getName() {
        return projName;
    }

    @Override
    public IPersistableElement getPersistable() {
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
