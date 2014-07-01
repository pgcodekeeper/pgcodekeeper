package ru.taximaxim.codekeeper.ui;

import org.eclipse.e4.core.contexts.IEclipseContext;

/**
 * Stores string ids for model objects, objects in {@link IEclipseContext}, etc,
 * that sort of string constants.
 * 
 * @author Alexander Levsha
 */
public interface UIConsts {
    
    String JGIT_PLUGIN_ID = "org.eclipse.jgit"; //$NON-NLS-1$
    String MAINAPP_PLUGIN_ID = "ru.taximaxim.codekeeper.mainapp"; //$NON-NLS-1$
    String APGDIFF_PLUGIN_ID = "apgdiff"; //$NON-NLS-1$

    String PLUGIN_ID = "ru.taximaxim.codekeeper.ui"; //$NON-NLS-1$
    String PREF_STORE = PLUGIN_ID + ".preferenceStore"; //$NON-NLS-1$
    
    String PART_STACK_EDITORS = PLUGIN_ID + ".partstack.Editors"; //$NON-NLS-1$
    String PART_SQL_EDITOR = PLUGIN_ID + ".partdescriptor.SQLEditorDescr"; //$NON-NLS-1$
    String PART_SQL_EDITOR_FILENAME = PART_SQL_EDITOR + ".filename"; //$NON-NLS-1$
    String PART_PROJXP_TREE_POPUP = PLUGIN_ID + ".popupmenu.project"; //$NON-NLS-1$
    String PART_SYNC = PLUGIN_ID + ".partdescriptor.Sync"; //$NON-NLS-1$
    String PART_SYNC_ID = PART_SYNC + ".Id"; //$NON-NLS-1$
    String PART_DIFF = PLUGIN_ID + ".partdescriptor.Diff"; //$NON-NLS-1$
    String PART_DIFF_ID = PART_DIFF + ".Id"; //$NON-NLS-1$
    String PART_WELCOME = PLUGIN_ID + ".part.Welcome"; //$NON-NLS-1$
    
    String WINDOW_MAIN_ID = "ru.taximaxim.codekeeper.mainapp.mainwindow"; //$NON-NLS-1$
    String PERSP_MAIN_ID = "ru.taximaxim.codekeeper.ui.perspective.Main"; //$NON-NLS-1$
    
    String HANDLER_RECENT_PROJ = "bundleclass://" + PLUGIN_ID + "/" + PLUGIN_ID //$NON-NLS-1$ //$NON-NLS-2$
            + ".handlers.OpenRecent"; //$NON-NLS-1$
    
    // Preferences
    String PREF_PGDUMP_EXE_PATH = "prefPgdumpExePath"; //$NON-NLS-1$
    String PREF_PGDUMP_CUSTOM_PARAMS = "prefPgdumpCustomParams"; //$NON-NLS-1$
    String PREF_DB_STORE = "prefDbStore"; //$NON-NLS-1$
    String PREF_GIT_KEY_PRIVATE_FILE = "prefGitKeyPrivateFile"; //$NON-NLS-1$
    String PREF_RECENT_PROJECTS = "prefRecentProject"; //$NON-NLS-1$
    String PREF_OPEN_LAST_ON_START = "prefOpenLastOnStart"; //$NON-NLS-1$
    String PREF_LAST_OPENED_LOCATION = "prefLastOpenedLocation"; //$NON-NLS-1$
    String PREF_LAST_ROLLON_SCRIPT = "prefLastRollonScript"; //$NON-NLS-1$
    String PREF_LAST_REPO = "prefLastRepo"; //$NON-NLS-1$
    
    // Project preferences
    String PROJ_PREF_ENCODING = "prefGeneralEncoding"; //$NON-NLS-1$
    String PROJ_PREF_SOURCE = "prefGeneralSource"; //$NON-NLS-1$
    String PROJ_SOURCE_TYPE_NONE = "none"; //$NON-NLS-1$
    String PROJ_SOURCE_TYPE_DB = "db"; //$NON-NLS-1$
    String PROJ_SOURCE_TYPE_DUMP = "dump"; //$NON-NLS-1$
    String PROJ_REPO_TYPE_GIT_NAME = "GIT"; //$NON-NLS-1$
    
    String PROJ_PREF_DB_NAME = "prefDbName"; //$NON-NLS-1$
    String PROJ_PREF_DB_HOST = "prefDbHost"; //$NON-NLS-1$
    String PROJ_PREF_DB_PORT = "prefDbPort"; //$NON-NLS-1$
    String PROJ_PREF_DB_USER = "prefDbUser"; //$NON-NLS-1$
    String PROJ_PREF_DB_PASS = "prefDbPass"; //$NON-NLS-1$
    String PROJ_PREF_REPO_URL = "prefRepoUrl"; //$NON-NLS-1$
    String PROJ_PREF_REPO_USER = "prefRepoUser"; //$NON-NLS-1$
    String PROJ_PREF_REPO_PASS = "prefRepoPass"; //$NON-NLS-1$
    String PROJ_PREF_REPO_TYPE = "prefRepoType"; //$NON-NLS-1$
    String PROJ_PREF_REPO_SUBDIR_PATH = "prefWorkingDirPath"; //$NON-NLS-1$
    String PROJ_PREF_REPO_ROOT_PATH = "prefRepoPath"; //$NON-NLS-1$
    
    String FILENAME_PROJ_PREF_STORE = ".project"; //$NON-NLS-1$
    
    String FILENAME_ICONPGADMIN = Messages.UIConsts_icons_pgadmin;
    String FILENAME_ICONWARNING = Messages.UIConsts_icons_warning;
    String FILENAME_ICONDIR = Messages.UIConsts_icons_exportdir_wiz;
    String FILENAME_ICONFILE = Messages.UIConsts_icons_file_obj;
    String FILENAME_ICONADD = Messages.UIConsts_icons_add_obj;
    String FILENAME_ICONSAVE = Messages.UIConsts_icons_save_edit;
    String FILENAME_ICONDEL = Messages.UIConsts_icons_delete_obj;
    String FILENAME_ICONEDIT = Messages.UIConsts_icons_editor;
    
    String EVENT_REOPEN_PROJECT = "ru/taximaxim/codekeeper/ui/project/changed"; //$NON-NLS-1$
}
