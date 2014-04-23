package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.jface.preference.PreferenceStore;

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

    private final String projectName;

    private final String projectFile;
    
    public PgDbProject(String projectFile) {
        super(projectFile);
        this.projectFile = projectFile;
        
        String fileName = Paths.get(projectFile).getFileName().toString();
        if (fileName.endsWith(UIConsts.FILENAME_PROJ_PREF_STORE)){
            this.projectName = fileName.substring(0, fileName.length() - 
                    UIConsts.FILENAME_PROJ_PREF_STORE.length());
        } else {
            this.projectName = fileName;
        }
    }
    
    public String getProjectName() {
        return projectName;
    }
    
    public File getProjectPropsFile() {
        return new File(projectFile);
    }
    
    public File getRepoRootDir(){
        return new File (getString(UIConsts.PROJ_PREF_REPO_ROOT_PATH));
    }
    
    public String getProjectDirName() {
        return new File(getString(UIConsts.PROJ_PREF_REPO_ROOT_PATH), 
                getString(UIConsts.PROJ_PREF_REPO_SUBDIR_PATH)).toString();
    }
    
    public File getProjectDirFile() {
        return new File(getString(UIConsts.PROJ_PREF_REPO_ROOT_PATH), 
                getString(UIConsts.PROJ_PREF_REPO_SUBDIR_PATH));
    }

    public Path getProjectDirPath() {
        return getProjectDirFile().toPath();
    }
}
