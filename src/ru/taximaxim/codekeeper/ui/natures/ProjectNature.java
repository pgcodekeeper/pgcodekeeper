package ru.taximaxim.codekeeper.ui.natures;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

import ru.taximaxim.codekeeper.ui.handlers.AddBuilder;
import ru.taximaxim.codekeeper.ui.handlers.RemoveBuilder;

public class ProjectNature implements IProjectNature {
    
    private IProject proj;

    @Override
    public void configure() throws CoreException {
        AddBuilder.addBuilder(proj);
    }

    @Override
    public void deconfigure() throws CoreException {
        RemoveBuilder.removeBuilder(proj);
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
