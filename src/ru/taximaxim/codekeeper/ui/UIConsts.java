package ru.taximaxim.codekeeper.ui;

/**
 * Stores string ids for model objects, objects in {@link IEclipseContext}, etc,
 * that sort of string constants.
 * 
 * @author Alexander Levsha
 */
public interface UIConsts {

	String PLUGIN_ID = "ru.taximaxim.codekeeper.ui";
	String PREF_STORE = PLUGIN_ID + ".preferenceStore";
	String PROJ_PART_STACK_ID = PLUGIN_ID + ".partstack.Projects";
	String PROJ_PART_DESCR_ID = PLUGIN_ID + ".partdescriptor.Project";
	String PROJ_PART_PERSISTED_ID = PROJ_PART_DESCR_ID + ".Id";
	
	// Preferences
	String PREF_SVN_EXE_PATH = "prefSvnExePath";
	String PREF_PGDUMP_EXE_PATH = "prefPgdumpExePath";
	
	// Project preferences
	String PROJ_PREF_ENCODING = "prefGeneralEncoding";
	String PROJ_PREF_SOURCE = "prefGeneralSource";
	String PROJ_SOURCE_TYPE_DB = "db";
	String PROJ_SOURCE_TYPE_DUMP = "dump";
	
	String PROJ_PREF_DB_NAME = "prefDbName";
	String PROJ_PREF_DB_HOST = "prefDbHost";
	String PROJ_PREF_DB_PORT = "prefDbPort";
	String PROJ_PREF_DB_USER = "prefDbUser";
	String PROJ_PREF_DB_PASS = "prefDbPass";
	String PROJ_PREF_SVN_URL = "prefSvnUrl";
	String PROJ_PREF_SVN_USER = "prefSvnUser";
	String PROJ_PREF_SVN_PASS = "prefSvnPass";
	
	String FILENAME_PROJ_PREF_STORE = "pgcodekeeper.project";
	String FILENAME_PROJ_SCHEMA_DIR = "svn";
	
	String FILENAME_ICONWARNING = "/icons/warning.gif";
	String FILENAME_ICONDIR = "/icons/exportdir_wiz.gif";
	String FILENAME_ICONFILE = "/icons/file_obj.gif";
}
