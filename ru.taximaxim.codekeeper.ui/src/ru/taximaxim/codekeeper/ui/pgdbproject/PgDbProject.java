package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;

public class PgDbProject {

    private final IProject project;
    private IEclipsePreferences prefs;

    public IProject getProject() {
        return project;
    }

    public IEclipsePreferences getPrefs() {
        IEclipsePreferences prefs = this.prefs;
        if (prefs == null) {
            prefs = getPrefs(project);
            this.prefs = prefs;
        }
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

    /**
     * @return pgCodeKeeper project preferences or null if wrong project
     */
    public static IEclipsePreferences getPrefs(IProject proj) {
        try {
            if (proj.hasNature(NATURE.ID)) {
                return new ProjectScope(proj).getNode(PLUGIN_ID.THIS);
            }
        } catch (CoreException ex) {
            Log.log(ex);
        }
        return null;
    }
}
