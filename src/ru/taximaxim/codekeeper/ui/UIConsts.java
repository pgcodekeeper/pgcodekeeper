package ru.taximaxim.codekeeper.ui;

import org.eclipse.e4.core.contexts.IEclipseContext;

/**
 * Stores string ids for model objects, objects in {@link IEclipseContext}, etc,
 * that sort of string constants.
 * 
 * @author Alexander Levsha
 */
public interface UIConsts {
    
    interface PLUGIN_ID {
        String JGIT = "org.eclipse.jgit"; //$NON-NLS-1$
        String MAINAPP = "ru.taximaxim.codekeeper.mainapp"; //$NON-NLS-1$
        String APGDIFF = "apgdiff"; //$NON-NLS-1$
        String THIS = "ru.taximaxim.codekeeper.ui"; //$NON-NLS-1$
    }
    
    String PREF_STORE = PLUGIN_ID.THIS + ".preferenceStore"; //$NON-NLS-1$
    
    interface PART_STACK {
        String EDITORS = UIConsts.PLUGIN_ID.THIS + ".partstack.Editors"; //$NON-NLS-1$
        String DEVTEST = UIConsts.PLUGIN_ID.THIS + ".partstack.Devtest"; //$NON-NLS-1$
    }
    
    interface PART {
        String SQL_EDITOR = UIConsts.PLUGIN_ID.THIS + ".partdescriptor.SQLEditorDescr"; //$NON-NLS-1$
        String SQL_EDITOR_FILENAME = SQL_EDITOR + ".filename"; //$NON-NLS-1$
        String SYNC = UIConsts.PLUGIN_ID.THIS + ".partdescriptor.Sync"; //$NON-NLS-1$
        String SYNC_ID = SYNC + ".Id"; //$NON-NLS-1$
        String DIFF = UIConsts.PLUGIN_ID.THIS + ".partdescriptor.Diff"; //$NON-NLS-1$
        String DIFF_ID = DIFF + ".Id"; //$NON-NLS-1$
        String WELCOME = UIConsts.PLUGIN_ID.THIS + ".part.Welcome"; //$NON-NLS-1$
        
        String DEVTEST = "ru.taximaxim.codekeeper.ui.part.TestPart";
        String CTXP = "ru.taximaxim.codekeeper.ui.part.CtXp";
    }
    
    interface PERSP {
        String MAIN = "ru.taximaxim.codekeeper.ui.perspective.Main"; //$NON-NLS-1$
    }
    
    interface MENU {
        String PROJXP_TREE_POPUP = UIConsts.PLUGIN_ID.THIS + ".popupmenu.project"; //$NON-NLS-1$
    }
    
    interface WINDOW {
        String MAIN = "ru.taximaxim.codekeeper.mainapp.mainwindow"; //$NON-NLS-1$
    }
    
    interface EVENT {
        String REOPEN_PROJECT = "ru/taximaxim/codekeeper/ui/project/changed"; //$NON-NLS-1$
    }
    
    String HANDLER_RECENT_PROJ = "bundleclass://" + PLUGIN_ID.THIS + "/" //$NON-NLS-1$ //$NON-NLS-2$
            + PLUGIN_ID.THIS + ".handlers.OpenRecent"; //$NON-NLS-1$
    
    interface PREF {
        String PGDUMP_EXE_PATH = "prefPgdumpExePath"; //$NON-NLS-1$
        String PGDUMP_CUSTOM_PARAMS = "prefPgdumpCustomParams"; //$NON-NLS-1$
        String DB_STORE = "prefDbStore"; //$NON-NLS-1$
        String GIT_KEY_PRIVATE_FILE = "prefGitKeyPrivateFile"; //$NON-NLS-1$
        String RECENT_PROJECTS = "prefRecentProject"; //$NON-NLS-1$
        String OPEN_LAST_ON_START = "prefOpenLastOnStart"; //$NON-NLS-1$
        String CONSIDER_DEPCY_IN_COMMIT = "considerDepcyInCommit"; //$NON-NLS-1$
        String LAST_OPENED_LOCATION = "prefLastOpenedLocation"; //$NON-NLS-1$
        String LAST_REPO = "prefLastRepo"; //$NON-NLS-1$
        String IGNORE_OBJECTS = "prefIgnoreObjects"; //$NON-NLS-1$
    }
    
    interface PROJ_PREF {
        String ENCODING = "prefGeneralEncoding"; //$NON-NLS-1$
        String SOURCE = "prefGeneralSource"; //$NON-NLS-1$
        String SOURCE_TYPE_NONE = "none"; //$NON-NLS-1$
        String SOURCE_TYPE_DB = "db"; //$NON-NLS-1$
        String SOURCE_TYPE_DUMP = "dump"; //$NON-NLS-1$
        String REPO_TYPE_GIT_NAME = "GIT"; //$NON-NLS-1$
        String DB_NAME = "prefDbName"; //$NON-NLS-1$
        String DB_HOST = "prefDbHost"; //$NON-NLS-1$
        String DB_PORT = "prefDbPort"; //$NON-NLS-1$
        String DB_USER = "prefDbUser"; //$NON-NLS-1$
        String DB_PASS = "prefDbPass"; //$NON-NLS-1$
        String REPO_URL = "prefRepoUrl"; //$NON-NLS-1$
        String REPO_USER = "prefRepoUser"; //$NON-NLS-1$
        String REPO_PASS = "prefRepoPass"; //$NON-NLS-1$
        String REPO_TYPE = "prefRepoType"; //$NON-NLS-1$
        String REPO_SUBDIR_PATH = "prefWorkingDirPath"; //$NON-NLS-1$
        String REPO_ROOT_PATH = "prefRepoPath"; //$NON-NLS-1$
    }
    
    interface FILE {
        String PROJ_PREF_STORE = ".project"; //$NON-NLS-1$
        
        String ICONPGADMIN = "/icons/pgadmin/"; //$NON-NLS-1$
        String ICONWARNING = "/icons/warning.gif"; //$NON-NLS-1$
        String ICONDIR = "/icons/exportdir_wiz.gif"; //$NON-NLS-1$
        String ICONFILE = "/icons/file_obj.gif"; //$NON-NLS-1$
        String ICONADD = "/icons/add_obj.gif"; //$NON-NLS-1$
        String ICONSAVE = "/icons/save_edit.gif"; //$NON-NLS-1$
        String ICONDEL = "/icons/delete_obj.gif"; //$NON-NLS-1$
        String ICONEDIT = "/icons/editor.gif"; //$NON-NLS-1$
        String ICONDEFAULTSORT = "/icons/alpha_mode.gif"; //$NON-NLS-1$
        String ICONSELECTALL = "/icons/check_all.gif"; //$NON-NLS-1$
        String ICONSELECTNONE = "/icons/uncheck_all.gif"; //$NON-NLS-1$
    }
}
