package ru.taximaxim.codekeeper.ui;

/**
 * Stores string ids for model objects, objects in IEclipseContext, etc,
 * that sort of string constants.
 * 
 * @author Alexander Levsha
 */
public interface UIConsts {

    interface PLUGIN_ID {
        String THIS = "ru.taximaxim.codekeeper.ui"; //$NON-NLS-1$
    }
    
    interface PART_STACK {
        String DEVTEST = PLUGIN_ID.THIS + ".partstack.Devtest"; //$NON-NLS-1$
    }
    
    interface PART {
        String DEVTEST = PLUGIN_ID.THIS + ".part.TestPart";
        String CTXP = PLUGIN_ID.THIS + ".part.CtXp";
    }
    
    interface EDITOR {
        String PROJECT = "ru.taximaxim.codekeeper.ui.projectEditorDiffer"; //$NON-NLS-1$
    }
    
    interface PERSP {
        String MAIN = PLUGIN_ID.THIS + ".perspective.Main"; //$NON-NLS-1$
    }
    
    interface PREF {
        String PGDUMP_EXE_PATH = "prefPgdumpExePath"; //$NON-NLS-1$
        String PGDUMP_CUSTOM_PARAMS = "prefPgdumpCustomParams"; //$NON-NLS-1$
        String DB_STORE = "prefDbStore"; //$NON-NLS-1$
        String GIT_KEY_PRIVATE_FILE = "prefGitKeyPrivateFile"; //$NON-NLS-1$
        String LAST_OPENED_LOCATION = "prefLastOpenedLocation"; //$NON-NLS-1$
        String IGNORE_OBJECTS = "prefIgnoreObjects"; //$NON-NLS-1$
    }
    
    interface COMMIT_PREF {
        String CONSIDER_DEPCY_IN_COMMIT = "considerDepcyInCommit"; //$NON-NLS-1$
    }
    
    interface DB_UPDATE_PREF {
        String USE_PSQL_DEPCY = "prefUsePSQLDepcy"; //$NON-NLS-1$
        String DROP_TABLE_STATEMENT = "prefDropTableStatement"; //$NON-NLS-1$
        String ALTER_COLUMN_STATEMENT = "prefAlterColumnStatement"; //$NON-NLS-1$
        String DROP_COLUMN_STATEMENT = "prefDropColumnStatement"; //$NON-NLS-1$
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
    
    interface NATURE {
        public static final String ID = "ru.taximaxim.codekeeper.ui.nature";
    }
    
    interface FILE {
        String PROJ_PREF_STORE = ".project"; //$NON-NLS-1$
        
        String ICONPGADMIN = "/icons/pgadmin/"; //$NON-NLS-1$
        String ICONWARNING = "/icons/warning.gif"; //$NON-NLS-1$
        String ICONADD = "/icons/add_obj.gif"; //$NON-NLS-1$
        String ICONSAVE = "/icons/save_edit.gif"; //$NON-NLS-1$
        String ICONDEL = "/icons/delete_obj.gif"; //$NON-NLS-1$
        String ICONEDIT = "/icons/editor.gif"; //$NON-NLS-1$
        String ICONDEFAULTSORT = "/icons/alpha_mode.gif"; //$NON-NLS-1$
        String ICONSELECTALL = "/icons/check_all.gif"; //$NON-NLS-1$
        String ICONSELECTNONE = "/icons/uncheck_all.gif"; //$NON-NLS-1$
        String ICONINVERTSELECTION = "/icons/loop_obj.gif"; //$NON-NLS-1$
    }
}
