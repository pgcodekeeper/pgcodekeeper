package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;

public class PgDbProject {

    private final IProject project;
    private final IEclipsePreferences prefs;

    public IProject getProject() {
        return project;
    }

    public IEclipsePreferences getPrefs() {
        return prefs;
    }

    public String getProjectName() {
        return project.getName();
    }

    public String getProjectCharset() throws CoreException {
        return project.getDefaultCharset(true);
    }

    public void setProjectCharset(String charset) throws CoreException {
        project.setDefaultCharset(charset, null);
    }

    public Path getPathToProject() {
        return Paths.get(project.getLocationURI());
    }

    /**
     * Удалить проект из workspace, не удаляя содержимое
     */
    public void deleteFromWorkspace() throws CoreException {
        project.delete(false, true, null);
    }

    public void openProject() throws CoreException {
        project.open(null);
    }

    public PgDbProject(IProject newProject) {
        this.project = newProject;
        ProjectScope ps = new ProjectScope(newProject);
        prefs = ps.getNode(UIConsts.PLUGIN_ID.THIS);
    }

    public static PgDbProject createPgDbProject(IProject newProject, URI location)
            throws CoreException {
        if (!newProject.exists()) {
            IProjectDescription desc = newProject.getWorkspace()
                    .newProjectDescription(newProject.getName());

            desc.setLocationURI(location);
            desc.setNatureIds(new String[] {NATURE.ID});
            newProject.create(desc, null);
        }
        return new PgDbProject(newProject);
    }
}
