package ru.taximaxim.codekeeper.ui.natures;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class ProjectNature implements IProjectNature {
    
    public static final String ID = "ru.taximaxim.codekeeper.ui.nature";
    private IProject proj;

    @Override
    public void configure() throws CoreException {
        // TODO Auto-generated method stub

    }

    @Override
    public void deconfigure() throws CoreException {
        // TODO Auto-generated method stub

    }

    @Override
    public IProject getProject() {
        return proj;
    }

    @Override
    public void setProject(IProject project) {
        proj = project;
    }

}
