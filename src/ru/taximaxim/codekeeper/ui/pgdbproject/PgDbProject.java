package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.nio.file.Paths;

import org.eclipse.jface.preference.PreferenceStore;

import ru.taximaxim.codekeeper.ui.UIConsts;

public class PgDbProject extends PreferenceStore {
	
	private final String projectDir;
	
	private final String projectName;
	
	public PgDbProject(String projectDir) {
		super(new File(projectDir,
				UIConsts.PROJ_PREF_STORE_FILENAME).getAbsolutePath());
		
		this.projectDir = projectDir;
		
		this.projectName = Paths.get(projectDir).getFileName().toString();
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public String getProjectDir() {
		return projectDir;
	}
}
