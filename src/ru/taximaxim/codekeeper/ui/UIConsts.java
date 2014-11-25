package ru.taximaxim.codekeeper.ui;

public interface UIConsts {

    String UTF_8 = "UTF-8"; //$NON-NLS-1$

    interface PLUGIN_ID {
        String THIS = "ru.taximaxim.codekeeper.ui"; //$NON-NLS-1$
        String HELP = THIS + ".help"; //$NON-NLS-1$
    }
    
    interface EDITOR {
        String PROJECT = "ru.taximaxim.codekeeper.ui.projectEditorDiffer"; //$NON-NLS-1$
    }
    
    interface PREF {
        String PGDUMP_EXE_PATH = "prefPgdumpExePath"; //$NON-NLS-1$
        String PGDUMP_CUSTOM_PARAMS = "prefPgdumpCustomParams"; //$NON-NLS-1$
        String DB_STORE = "prefDbStore"; //$NON-NLS-1$
        String LAST_OPENED_LOCATION = "prefLastOpenedLocation"; //$NON-NLS-1$
        String IGNORE_OBJECTS = "prefIgnoreObjects"; //$NON-NLS-1$
        String FORCE_SHOW_CONSOLE = "prefForceShowConsole"; //$NON-NLS-1$
        String IS_FLIPPED_DB_SOURCE = "isFlippedDbSource"; //$NON-NLS-1$
        String IS_DDL_UPDATE_OVER_JDBC = "isDdlUpdateOverJdbc"; //$NON-NLS-1$
    }
    
    interface COMMIT_PREF {
        String CONSIDER_DEPCY_IN_COMMIT = "considerDepcyInCommit"; //$NON-NLS-1$
        String USE_PARTIAL_EXPORT_ON_COMMIT = "usePartialExportOnCommit"; //$NON-NLS-1$
    }
    
    interface DB_UPDATE_PREF {
        String SHOW_SCRIPT_OUTPUT_SEPARATELY = "prefShowScriptOutputSeparately"; //$NON-NLS-1$
        String USE_PSQL_DEPCY = "prefUsePSQLDepcy"; //$NON-NLS-1$
        String DROP_TABLE_STATEMENT = "prefDropTableStatement"; //$NON-NLS-1$
        String ALTER_COLUMN_STATEMENT = "prefAlterColumnStatement"; //$NON-NLS-1$
        String DROP_COLUMN_STATEMENT = "prefDropColumnStatement"; //$NON-NLS-1$
    }
    
    public enum DBSources {
        SOURCE_TYPE_JDBC("jdbc"), //$NON-NLS-1$
        SOURCE_TYPE_DB("db"), //$NON-NLS-1$
        SOURCE_TYPE_DUMP("dump"); //$NON-NLS-1$
        
        private String sourceName;
        private DBSources(String sourceName) {
            this.sourceName = sourceName;
        }
        
        @Override
        public String toString() {
            return sourceName;
        }
        public static DBSources getEnum(String value) {
            // Возвращать Дамп если тип соурса был none
            if (value.equalsIgnoreCase("none")) { //$NON-NLS-1$
                return SOURCE_TYPE_DUMP;
            }
            for (DBSources v : values()) {
                if (v.sourceName.equalsIgnoreCase(value)) {
                    return v;
                }
            }
            throw new IllegalArgumentException("No such DBSource in enum"); //$NON-NLS-1$
        }
    }
    
    interface PROJ_PREF {
        String ENCODING = "prefGeneralEncoding"; //$NON-NLS-1$
        String SOURCE = "prefGeneralSource"; //$NON-NLS-1$
        String DB_NAME = "prefDbName"; //$NON-NLS-1$
        String DB_HOST = "prefDbHost"; //$NON-NLS-1$
        String DB_PORT = "prefDbPort"; //$NON-NLS-1$
        String DB_USER = "prefDbUser"; //$NON-NLS-1$
        String REPO_SUBDIR_PATH = "prefWorkingDirPath"; //$NON-NLS-1$
        String REPO_ROOT_PATH = "prefRepoPath"; //$NON-NLS-1$
    }
    
    interface NATURE {
        String ID = "ru.taximaxim.codekeeper.ui.nature"; //$NON-NLS-1$
    }
    
    interface HELP {
        String MANUAL_DEPCIES = PLUGIN_ID.HELP + ".manual_depcies"; //$NON-NLS-1$
        String MAIN_EDITOR = PLUGIN_ID.HELP + ".pgcodekeeper_editor"; //$NON-NLS-1$
        String NEW_WIZARD = PLUGIN_ID.HELP + ".project_initializer"; //$NON-NLS-1$
        String NEW_WIZARD_INIT = PLUGIN_ID.HELP + ".schema_src_settings"; //$NON-NLS-1$
        String NEW_WIZARD_MISC = PLUGIN_ID.HELP + ".miscellaneous"; //$NON-NLS-1$
        String SQL_SCRIPT_DIALOG = PLUGIN_ID.HELP + ".roll_on_script"; //$NON-NLS-1$
    }
    
    interface FILE {
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
        String ICONBALLBLUE = "/icons/ball_blue.png"; //$NON-NLS-1$
        String ICONBALLRED = "/icons/ball_red.png"; //$NON-NLS-1$
        String ICONREFRESH = "/icons/refresh.gif"; //$NON-NLS-1$
        String ICONCLOSE = "/icons/close_view.png"; //$NON-NLS-1$
    }
}
