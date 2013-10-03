package ru.taximaxim.codekeeper.ui;

/**
 * Stores string ids for model objects, objects in {@link IEclipseContext}, etc,
 * that sort of string constants.
 * 
 * @author Alexander Levsha
 */
public interface UIConsts {

	public static final String PLUGIN_ID = "ru.taximaxim.codekeeper.ui";
	public static final String PREF_STORE = PLUGIN_ID + ".preferenceStore";
	
	// Preferences
	public static final String PREF_SVN_EXE_PATH = "prefSvnExePath";
	
}
