package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;

import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.osgi.util.NLS;

public class ProjectRecord {

    private final File projectSystemFile;
    private String projectName;
    private boolean hasConflicts;
    private final boolean isInvalid = false;
    private IProjectDescription description;

    ProjectRecord(File file) {
        projectSystemFile = file;
        setProjectName();
    }

    private void setProjectName() {
        if (projectName == null) {
            IPath path = new Path(projectSystemFile.getPath());
            if (path.toFile().exists()) {
                try {
                    description = ResourcesPlugin.getWorkspace().loadProjectDescription(path);
                    projectName = description.getName();
                } catch (CoreException e) {
                    // not found files
                    e.printStackTrace();
                }
            } else {
                projectName = path.segment(path.segmentCount() - 2);
                description = ResourcesPlugin.getWorkspace().newProjectDescription(projectName);
            }
        }
    }

    public String getProjectName() {
        return projectName;
    }

    public boolean isInvalidProject() {
        return isInvalid;
    }

    public String getProjectLabel() {
        String path = projectSystemFile.getPath();
        return NLS.bind(description.getName(), projectName, path);
    }

    public boolean hasConflicts() {
        return hasConflicts;
    }

    public void setConflicts(boolean hasConflicts) {
        this.hasConflicts = hasConflicts;

    }

    public File getProjectSystemFile() {
        return projectSystemFile;
    }

    public IProjectDescription getDescription() {
        return description;
    }

    public void setDescription(IProjectDescription description) {
        this.description = description;
    }
}