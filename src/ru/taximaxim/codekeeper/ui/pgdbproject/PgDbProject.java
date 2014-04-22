package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import ru.taximaxim.codekeeper.ui.UIConsts;

public class PgDbProject extends PreferenceStore {

    public enum RepoType {
        SVN("SVN"), GIT("GIT");
        private String repoType;

        private RepoType(String repoType) {
            this.repoType = repoType;
        }
        @Override
        public String toString() {
            return repoType;
        }
    }

    private String projectDir = "";

    private final String projectName;

    private final String projectFile;
    
    public PgDbProject(String projectFile) {
        super(projectFile);
        this.projectFile = projectFile;
        
        String fileName = Paths.get(projectFile).getFileName().toString();
        if (fileName.endsWith(UIConsts.FILENAME_PROJ_PREF_STORE)){
            this.projectName = fileName.substring(0, fileName.length() - 
                    UIConsts.FILENAME_PROJ_PREF_STORE.length());
        }else {
            this.projectName = fileName;
        }
        addPropertyChangeListener(new IPropertyChangeListener() {
            
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if(event.getProperty().equals(UIConsts.PROJ_PREF_REPO_PATH) || 
                        event.getProperty().equals(UIConsts.PROJ_PREF_WORKING_DIR_PATH)){
                    projectDir = new File(getString(UIConsts.PROJ_PREF_REPO_PATH), 
                            getString(UIConsts.PROJ_PREF_WORKING_DIR_PATH)).toString();
                }
            }
        });
    }

    @Override
    public void load() throws IOException{
        super.load();
        projectDir = new File(getString(UIConsts.PROJ_PREF_REPO_PATH), 
                getString(UIConsts.PROJ_PREF_WORKING_DIR_PATH)).toString();
    }
    
    public String getProjectName() {
        return projectName;
    }

    public String getProjectDir() {
        return projectDir;
    }

    public File getProjectDirFile() {
        return new File(projectDir);
    }

    public Path getProjectPath() {
        return getProjectDirFile().toPath();
    }

    public File getProjectPropsFile() {
        return new File(projectFile);
    }

    public File getProjectSchemaDir() {
        return new File(projectDir);
    }
    
    public File getRootDir(){
        return new File (getString(UIConsts.PROJ_PREF_REPO_PATH));
    }
}
