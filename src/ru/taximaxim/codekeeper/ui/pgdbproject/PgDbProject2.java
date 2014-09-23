/**
 * 
 */
package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

/**
 * Проект
 *
 */
public class PgDbProject2 {
    
    private final IProject project;
    private final IEclipsePreferences prefs;
    
    /**
     * @return the prefs
     */
    public IEclipsePreferences getPrefs() {
        return prefs;
    }
    
    /**
     * @return Имя проекта
     */
    public String getName() {
        return project.getName();
    }
    
    /**
     * Just do the basics: create a basic project.
     *
     * @param location
     * @param projectName
     */
    public PgDbProject2(String projectName, URI location) {        
        // it is acceptable to use the ResourcesPlugin class
        IProject newProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
 
        if (!newProject.exists()) {
            URI projectLocation = location;
            IProjectDescription desc = newProject.getWorkspace().newProjectDescription(newProject.getName());
            if (location != null && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(location)) {
                projectLocation = null;
            }
 
            desc.setLocationURI(projectLocation);
            try {
                newProject.create(desc, null);
                if (!newProject.isOpen()) {
                    newProject.open(null);
                }
            } catch (CoreException e) {
                e.printStackTrace();
            }
        }
        this.project = newProject;
        ProjectScope ps = new ProjectScope(newProject);
        prefs = ps.getNode(UIConsts.PLUGIN_ID.THIS);
    }
    
    public static PgDbProject2 getProgFromFile(String pathToProject) {
        String fileName = Paths.get(pathToProject).getFileName().toString();
        String projectName;
        if (fileName.endsWith(FILE.PROJ_PREF_STORE)){
            projectName = fileName.substring(0, fileName.length() - 
                    FILE.PROJ_PREF_STORE.length());
        } else {
            projectName = fileName;
        }
        try {
            pathToProject = pathToProject.substring(0, pathToProject.lastIndexOf("/"));
            return new PgDbProject2(projectName, new URI("file:/" + pathToProject));
        } catch (URISyntaxException e1) {
            Log.log(Log.LOG_ERROR, "Error while trying to load project", e1);
            return null;
        }
    }
}
