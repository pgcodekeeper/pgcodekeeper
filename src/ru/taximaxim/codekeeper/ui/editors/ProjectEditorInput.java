package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class ProjectEditorInput implements IEditorInput  {

    private String projName;
    
    public ProjectEditorInput(String projectName) {
        projName = projectName;
    }
    public String getProjectName() {
        return projName;
    }

    @Override
    public Object getAdapter(Class adapter) {
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
        return "Project " + projName;
    }

}
