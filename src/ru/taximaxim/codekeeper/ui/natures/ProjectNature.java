package ru.taximaxim.codekeeper.ui.natures;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class ProjectNature implements IProjectNature {
    
    private IProject proj;

    @Override
    public void configure() throws CoreException {
//        PgDbParser.getParser(proj).getObjFromProject();
    }

    @Override
    public void deconfigure() throws CoreException {
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
