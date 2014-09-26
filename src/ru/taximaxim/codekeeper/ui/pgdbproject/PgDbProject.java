/**
 * 
 */
package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.natures.ProjectNature;

/**
 * Проект
 *
 */
public class PgDbProject {
    
    private final IProject project;
    private final IEclipsePreferences prefs;
    
    public IEclipsePreferences getPrefs() {
        return prefs;
    }
    
    public String getProjectName() {
        return project.getName();
    }
    
    public Path getPathToProject() {
        return Paths.get(prefs.get(UIConsts.PROJ_PREF.REPO_ROOT_PATH, project.getLocation().toString()));
    }
    
    /**
     * Удалить проект из workspace, не удаляя содержимое
     */
    public void deleteFromWorkspace() {
        try {
            project.delete(false, true, null);
        } catch (CoreException e) {
            Log.log(Log.LOG_ERROR, "Cannot remove proj from workspace", e);
        }
    }
    
    public void openProject() {
        try {
            project.open(null);
        } catch (CoreException e) {
            Log.log(Log.LOG_ERROR, "Cannot open proj", e);
        }
    }
    
    /**
     * Just do the basics: create a basic project.
     *
     * @param location
     * @param projectName
     */
    public PgDbProject(String projectName, URI location) {        
        // it is acceptable to use the ResourcesPlugin class
        IProject newProject = ResourcesPlugin.getWorkspace().getRoot()
                .getProject(projectName);
 
        if (!newProject.exists()) {
            URI projectLocation = location;
            IProjectDescription desc = newProject.getWorkspace()
                    .newProjectDescription(newProject.getName());
            if (location != null && ResourcesPlugin.getWorkspace().getRoot()
                    .getLocationURI().equals(location)) {
                projectLocation = null;
            }
 
            desc.setLocationURI(projectLocation);
            try {
                newProject.create(desc, null);
            } catch (CoreException e) {
                e.printStackTrace();
            }
        }
        this.project = newProject;
        ProjectScope ps = new ProjectScope(newProject);
        prefs = ps.getNode(UIConsts.PLUGIN_ID.THIS);
    }
    
    public static void addNatureToProject(IProject project) throws CoreException {
        if (!project.hasNature(ProjectNature.ID)) {
            IProjectDescription description = project.getDescription();
            String[] prevNatures = description.getNatureIds();
            String[] newNatures = new String[prevNatures.length + 1];
            System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
            newNatures[prevNatures.length] = ProjectNature.ID;
            description.setNatureIds(newNatures);
            project.setDescription(description, null);
        }
    }
    /**
     * Извлекает имя проекта из названия папки проекта
     * @param pathToProject
     * @return
     */
    public static PgDbProject getProgFromFile(String pathToProject) {
        return getProgFromFile(Paths.get(pathToProject).getFileName().toString(),
                pathToProject);
    }
    
    public static PgDbProject getProgFromFile(String projectName, 
            String pathToProject) {
        try {
            return new PgDbProject(projectName, new URI("file:/" + pathToProject));
        } catch (URISyntaxException e1) {
            Log.log(Log.LOG_ERROR, "Error while trying to load project", e1);
            return null;
        }
    }

    public IProject getProject() {
        return project;
    }
}
