package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.net.URI;
import java.nio.file.Paths;
import java.text.MessageFormat;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
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

    public IPath getPathToProject() {
        return project.getFullPath();
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

    private static PgDbProject createPgDbProject(IProject newProject, URI location) throws PgCodekeeperUIException {
        if (!newProject.exists()) {
            IProjectDescription desc = newProject.getWorkspace()
                    .newProjectDescription(newProject.getName());

            desc.setLocationURI(location);
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

    public static void addNatureToProject(IProject project) throws CoreException {
        if (!project.hasNature(NATURE.ID)) {
            IProjectDescription description = project.getDescription();
            String[] prevNatures = description.getNatureIds();
            String[] newNatures = new String[prevNatures.length + 1];
            System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
            newNatures[prevNatures.length] = NATURE.ID;
            description.setNatureIds(newNatures);
            project.setDescription(description, null);
        }
    }
    /**
     * Извлекает имя проекта из названия папки проекта
     * @throws PgCodekeeperUIException
     */
    public static PgDbProject getProjFromFile(String pathToProject)
            throws PgCodekeeperUIException {
        return getProjFromFile(Paths.get(pathToProject).getFileName().toString(),
                pathToProject);
    }

    public static PgDbProject getProjFromFile(String projectName,
            String pathToProject) throws PgCodekeeperUIException {
        // it is acceptable to use the ResourcesPlugin class
        return createPgDbProject(ResourcesPlugin.getWorkspace().getRoot()
                .getProject(projectName), new File(pathToProject).toURI());
    }

    public static PgDbProject getProjectFromIProjectHandle(IProject projHandle, URI location)
            throws PgCodekeeperUIException {
        return createPgDbProject(projHandle, location);
    }
}
