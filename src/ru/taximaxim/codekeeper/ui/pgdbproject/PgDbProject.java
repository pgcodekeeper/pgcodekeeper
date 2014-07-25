package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.eclipse.jface.preference.PreferenceStore;

import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class PgDbProject extends PreferenceStore {

    private final String projectName;
    private final File projectFile;
    
    public PgDbProject(String projectFile) {
        super(projectFile);
        this.projectFile = new File(projectFile);
        
        String fileName = Paths.get(projectFile).getFileName().toString();
        if (fileName.endsWith(FILE.PROJ_PREF_STORE)){
            this.projectName = fileName.substring(0, fileName.length() - 
                    FILE.PROJ_PREF_STORE.length());
        } else {
            this.projectName = fileName;
        }
    }
    
    @Override
    public void load(){
        try {
            super.load();
        } catch (IOException ex) {
            throw new IllegalStateException(Messages.pgDbProject_error_loading_project_file, ex);
        }
    }
    
    public String getProjectName() {
        return projectName;
    }
    
    public File getProjectFile() {
        return projectFile;
    }
    
    public File getRepoRoot(){
        return new File(getString(PROJ_PREF.REPO_ROOT_PATH));
    }
    
    public File getProjectWorkingDir() {
        return new File(getString(PROJ_PREF.REPO_ROOT_PATH), 
                getString(PROJ_PREF.REPO_SUBDIR_PATH));
    }
}
