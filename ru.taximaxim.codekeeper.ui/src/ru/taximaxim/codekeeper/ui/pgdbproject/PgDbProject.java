package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

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
        project.setDefaultCharset(charset, new NullProgressMonitor());
    }

    public Path getPathToProject() {
        return Paths.get(project.getLocationURI());
    }

    /**
     * Удалить проект из workspace, не удаляя содержимое
     * @throws PgCodekeeperUIException
     */
    public void deleteFromWorkspace() throws PgCodekeeperUIException {
        try {
            project.delete(false, true, null);
        } catch (CoreException e) {
            throw new PgCodekeeperUIException(MessageFormat.format(
                    Messages.PgDbProject_error_deleting_project,
                    e.getLocalizedMessage()), e);
        }
    }

    public void openProject() throws PgCodekeeperUIException {
        try {
            project.open(null);
        } catch (CoreException e) {
            throw new PgCodekeeperUIException(MessageFormat.format(
                    Messages.PgDbProject_error_opening_project,
                    e.getLocalizedMessage()), e);
        }
    }

    public PgDbProject(IProject newProject) {
        this.project = newProject;
        ProjectScope ps = new ProjectScope(newProject);
        prefs = ps.getNode(UIConsts.PLUGIN_ID.THIS);
    }

    public static PgDbProject createPgDbProject(IProject newProject, URI location)
            throws PgCodekeeperUIException {
        if (!newProject.exists()) {
            IProjectDescription desc = newProject.getWorkspace()
                    .newProjectDescription(newProject.getName());

            desc.setLocationURI(location);
            desc.setNatureIds(new String[] {NATURE.ID});
            try {
                newProject.create(desc, null);
            } catch (CoreException e) {
                throw new PgCodekeeperUIException(MessageFormat.format(
                        Messages.PgDbProject_error_creating_project,
                        e.getLocalizedMessage()), e);
            }
        }
        return new PgDbProject(newProject);
    }
}
