package ru.taximaxim.codekeeper.ui.editors;

import java.text.MessageFormat;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectEditorInput implements IEditorInput  {

    private final String projName;
    
    public ProjectEditorInput(String projectName) {
        projName = projectName;
    }
    
    public String getProjectName() {
        return projName;
    }

    @Override
    public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
        return null;
    }

    @Override
    public boolean exists() {
        return (projName != null) || (!projName.isEmpty());
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
}
