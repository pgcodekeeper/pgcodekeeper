package ru.taximaxim.codekeeper.ui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface UIConsts {

    String _NL = System.lineSeparator();

    interface PLUGIN_ID {
        String THIS = "ru.taximaxim.codekeeper.ui"; //$NON-NLS-1$
        String HELP = THIS + ".help"; //$NON-NLS-1$
    }

    interface PERSPECTIVE {
        String MAIN = PLUGIN_ID.THIS + ".mainperspective"; //$NON-NLS-1$
    }

    interface CONTEXT {
        String MAIN = PLUGIN_ID.THIS + ".pgCodeKeeper"; //$NON-NLS-1$
        String EDITOR = PLUGIN_ID.THIS + ".pgCodeKeeperEditorScope"; //$NON-NLS-1$
    }

    interface EDITOR {
        String PROJECT = PLUGIN_ID.THIS + ".projectEditorDiffer"; //$NON-NLS-1$
        String SQL = PLUGIN_ID.THIS + ".SQLEditor"; //$NON-NLS-1$
    }

    interface MARKER {
        String ERROR = PLUGIN_ID.THIS + ".sql.errormarker"; //$NON-NLS-1$
        String DANGER_ANNOTATION = PLUGIN_ID.THIS + ".sql.dangerannotation"; //$NON-NLS-1$
    }

    interface DECORATOR {
        String DECORATOR = PLUGIN_ID.THIS + ".decorator"; //$NON-NLS-1$
    }

    interface COMMAND {
        /* EGit commit command id
        (value of org.eclipse.egit.ui.internal.actions.ActionCommands.COMMIT_ACTION) */
        String COMMIT_COMMAND_ID = "org.eclipse.egit.ui.team.Commit"; //$NON-NLS-1$

        String GET_CHANGES = PLUGIN_ID.THIS + ".command.GetChanges"; //$NON-NLS-1$
        String UPDATE_DDL = PLUGIN_ID.THIS + ".command.UpdateDdl"; //$NON-NLS-1$
        String ADD_DEPCY = PLUGIN_ID.THIS + ".command.AddDepcy"; //$NON-NLS-1$
    }

    interface PREF_PAGE {
        int WIDTH_HINT_PX = 240;
        String DB_STORE = PLUGIN_ID.THIS + ".dbstore"; //$NON-NLS-1$
    }

    interface PREF {
        String PGDUMP_EXE_PATH = "prefPgdumpExePath"; //$NON-NLS-1$
        String PGDUMP_CUSTOM_PARAMS = "prefPgdumpCustomParams"; //$NON-NLS-1$
        String PGDUMP_SWITCH = "prefPgDumpSwitch"; //$NON-NLS-1$
        String FORCE_SHOW_CONSOLE = "prefForceShowConsole"; //$NON-NLS-1$
        String DB_STORE = "prefDbStore"; //$NON-NLS-1$
        String DB_STORE_FILES = "prefDbStoreHistory"; //$NON-NLS-1$
        //String IGNORE_OBJECTS = "prefIgnoreObjects"; //$NON-NLS-1$
        String NO_PRIVILEGES = "prefNoPrivileges"; //$NON-NLS-1$

        String LAST_OPENED_LOCATION = "prefLastOpenedLocation"; //$NON-NLS-1$
        //String IS_FLIPPED_DB_SOURCE = "isFlippedDbSource"; //$NON-NLS-1$
        //String IS_DDL_UPDATE_OVER_JDBC_INFO = "isDDLUpdateOverJDBCInfo"; //$NON-NLS-1$

        String CALL_COMMIT_COMMAND_AFTER_UPDATE = "callCommitCommandAfterUpdate"; //$NON-NLS-1$
    }

    interface COMMIT_PREF {
        String CONSIDER_DEPCY_IN_COMMIT = "considerDepcyInCommit"; //$NON-NLS-1$
    }

    interface DB_UPDATE_PREF {
        String SHOW_SCRIPT_OUTPUT_SEPARATELY = "prefShowScriptOutputSeparately"; //$NON-NLS-1$
        String CREATE_SCRIPT_IN_PROJECT = "prefAddScriptToProject"; //$NON-NLS-1$
        String DELETE_SCRIPT_AFTER_CLOSE = "prefDeleteScriptAfterClose"; //$NON-NLS-1$
        String DROP_TABLE_STATEMENT = "prefDropTableStatement"; //$NON-NLS-1$
        String ALTER_COLUMN_STATEMENT = "prefAlterColumnStatement"; //$NON-NLS-1$
        String DROP_COLUMN_STATEMENT = "prefDropColumnStatement"; //$NON-NLS-1$
        String RESTART_WITH_STATEMENT = "prefRestartWithStatement"; //$NON-NLS-1$
        String SCRIPT_IN_TRANSACTION = "prefScriptInTransaction"; //$NON-NLS-1$
        String CHECK_FUNCTION_BODIES = "prefCheckFunctionBodies"; //$NON-NLS-1$
        String USING_ON_OFF = "prefUsingOnOff"; //$NON-NLS-1$;
        String COMMAND_LINE_DDL_UPDATE = "prefCommandLineDdlUpdate"; //$NON-NLS-1$;
        String MIGRATION_COMMAND = "prefMigrationCommand"; //$NON-NLS-1$;
        String PRINT_INDEX_WITH_CONCURRENTLY = "prefPrintIndexWithConcurrently"; //$NON-NLS-1$;
    }

    interface PG_EDIT_PREF {
        String PERSPECTIVE_CHANGING_STATUS = "perspectiveChangingStatus"; //$NON-NLS-1$
        String EDITOR_UPDATE_ACTION = "editorUpdateAction"; //$NON-NLS-1$
        String SHOW_GIT_USER = "showGitUser"; //$NON-NLS-1$
        String UPDATE = "UPDATE"; //$NON-NLS-1$
        String RESET = "RESET"; //$NON-NLS-1$
        String NO_ACTION = "NO_ACTION"; //$NON-NLS-1$
    }


    interface USAGE_REPORT_PREF {
        String USAGEREPORT_ENABLED_ID = "allow_usage_report_preference"; //$NON-NLS-1$
        String ASK_USER_USAGEREPORT_ID = "ask_user_for_usage_report_preference"; //$NON-NLS-1$
        String ECLIPSE_INSTANCE_ID = "eclipse_instance_id"; //$NON-NLS-1$
        String FIRST_VISIT = "first_visit";
        String LAST_VISIT = "last_visit";
        String VISIT_COUNT = "visit_count";
    }

    public enum DBSources {
        SOURCE_TYPE_JDBC("jdbc"), //$NON-NLS-1$
        SOURCE_TYPE_DB("db"), //$NON-NLS-1$
        SOURCE_TYPE_DUMP("dump"); //$NON-NLS-1$

        private final String sourceName;
        private DBSources(String sourceName) {
            this.sourceName = sourceName;
        }

        @Override
        public String toString() {
            return sourceName;
        }
        public static DBSources getEnum(String value) {
            for (DBSources v : values()) {
                if (v.sourceName.equalsIgnoreCase(value)) {
                    return v;
                }
            }
            // источником по умолчанию для всего что не попадает в enum
            return SOURCE_TYPE_DUMP;
        }
    }

    interface PROJ_PREF {
        String TIMEZONE = "prefGeneralTimezone"; //$NON-NLS-1$
        String FORCE_UNIX_NEWLINES = "prefForceUnixNewlines"; //$NON-NLS-1$
        String LAST_DB_STORE = "prefLastDbStore"; //$NON-NLS-1$
        String LAST_DB_STORE_EDITOR = "prefLastDbStoreEditor"; //$NON-NLS-1$
        /*
        String SOURCE = "prefGeneralSource"; //$NON-NLS-1$
        String DB_NAME = "prefDbName"; //$NON-NLS-1$
        String DB_HOST = "prefDbHost"; //$NON-NLS-1$
        String DB_PORT = "prefDbPort"; //$NON-NLS-1$
        String DB_USER = "prefDbUser"; //$NON-NLS-1$
         */
    }

    interface PROJ_PATH {
        String MIGRATION_DIR = "MIGRATION"; //$NON-NLS-1$
    }

    interface NATURE {
        String ID = PLUGIN_ID.THIS + ".nature"; //$NON-NLS-1$
    }

    interface BUILDER {
        String ID = PLUGIN_ID.THIS + ".builder"; //$NON-NLS-1$
    }

    interface HELP {
        String MANUAL_DEPCIES = PLUGIN_ID.HELP + ".manual_depcies"; //$NON-NLS-1$
        String MAIN_EDITOR = PLUGIN_ID.HELP + ".pgcodekeeper_editor"; //$NON-NLS-1$
        String NEW_WIZARD = PLUGIN_ID.HELP + ".project_initializer"; //$NON-NLS-1$
        String NEW_WIZARD_INIT = PLUGIN_ID.HELP + ".schema_src_settings"; //$NON-NLS-1$
        String SQL_SCRIPT_DIALOG = PLUGIN_ID.HELP + ".roll_on_script"; //$NON-NLS-1$
        String DIALOG_UPDATE_PROJECT = PLUGIN_ID.HELP + ".update_project_dialog"; //$NON-NLS-1$
    }

    interface FILE {
        String IGNORED_OBJECTS = ".pgcodekeeperignore"; //$NON-NLS-1$
        String DDL_UPDATE_COMMANDS_HIST_FILENAME = "rollon_cmd_history.xml"; //$NON-NLS-1$

        // external icons
        String ICONAPPSMALL = "/icons/app_icon16.png"; //$NON-NLS-1$
        String ICONAPPWIZ = "/icons/app_icon_wiz.png"; //$NON-NLS-1$
        String ICONAPPBIG = "/icons/app_icon128.png"; //$NON-NLS-1$
        String ICONBALLBLUE = "/icons/ball_blue.png"; //$NON-NLS-1$
        String ICONBALLGREEN = "/icons/ball_green.png"; //$NON-NLS-1$
        String ICONFROMPROJECT = "/icons/arrow_left_blue.png"; //$NON-NLS-1$
        String ICONFROMREMOTE = "/icons/arrow_right_green.png"; //$NON-NLS-1$
        String ICONADDDEP = "/icons/add_dep.png"; //$NON-NLS-1$

        // pgadmin icons
        String ICONPGADMIN = "/icons/pgadmin/"; //$NON-NLS-1$
        String ICONDATABASE = ICONPGADMIN + "database.png"; //$NON-NLS-1$

        // copies of inaccessible Eclipse icons
        String ICONUP = "/icons/search_prev.gif"; //$NON-NLS-1$
        String ICONDOWN = "/icons/search_next.gif"; //$NON-NLS-1$
        String ICONEDIT = "/icons/editor_area.png"; //$NON-NLS-1$
        String ICONSELECTALL = "/icons/check_all.gif"; //$NON-NLS-1$
        String ICONSELECTNONE = "/icons/uncheck_all.gif"; //$NON-NLS-1$
        String ICONINVERTSELECTION = "/icons/loop_obj.png"; //$NON-NLS-1$
        String ICONREFRESH = "/icons/refresh.png"; //$NON-NLS-1$
        String ICONCLOSE = "/icons/close_view.png"; //$NON-NLS-1$
        String ICONWRITEOUTCONSOLE = "/icons/writeout_co.png"; //$NON-NLS-1$
        String ICONFILE = "/icons/file_obj.png"; //$NON-NLS-1$
        String ICONCHECK = "/icons/header_complete.gif"; //$NON-NLS-1$
        String ICONEMPTYFILTER = "/icons/empty_filter.png"; //$NON-NLS-1$
        String ICONFILTER = "/icons/filter_tsk.png"; //$NON-NLS-1$
        String ICONALERT = "/icons/alert_obj.gif"; //$NON-NLS-1$
        String ICONSORT = "/icons/alpha_mode.gif"; //$NON-NLS-1$
    }

    interface WORKING_SET {
        String RESOURCE_WORKING_SET = "org.eclipse.ui.resourceWorkingSetPage"; //$NON-NLS-1$
    }

    interface XML_TAGS{
        String DDL_UPDATE_COMMANDS_HIST_ROOT = "scripts"; //$NON-NLS-1$
        String DDL_UPDATE_COMMANDS_HIST_ELEMENT = "s"; //$NON-NLS-1$
        int DDL_UPDATE_COMMANDS_MAX_STORED = 20;

        String IGNORED_OBJS_ROOT = "ignored_objects"; //$NON-NLS-1$
        String IGNORED_OBJS_ELEMENT = "obj"; //$NON-NLS-1$
    }

    String DDL_DEFAULT_CMD = "psql -e -1 -w --set ON_ERROR_STOP=1 -X -h %host -p %port -U %user -f %script %db"; //$NON-NLS-1$

    List<String> TIME_ZONES = Collections.unmodifiableList(Arrays.asList(
            "UTC-12:00", //$NON-NLS-1$
            "UTC-11:00", //$NON-NLS-1$
            "UTC-10:00", //$NON-NLS-1$
            "UTC-09:00", //$NON-NLS-1$
            "UTC-08:00", //$NON-NLS-1$
            "UTC-07:00", //$NON-NLS-1$
            "UTC-06:00", //$NON-NLS-1$
            "UTC-05:00", //$NON-NLS-1$
            "UTC-04:00", //$NON-NLS-1$
            "UTC-03:00", //$NON-NLS-1$
            "UTC-02:00", //$NON-NLS-1$
            "UTC-01:00", //$NON-NLS-1$
            "UTC", //$NON-NLS-1$
            "UTC+01:00", //$NON-NLS-1$
            "UTC+02:00", //$NON-NLS-1$
            "UTC+03:00", //$NON-NLS-1$
            "UTC+04:00", //$NON-NLS-1$
            "UTC+05:00", //$NON-NLS-1$
            "UTC+06:00", //$NON-NLS-1$
            "UTC+07:00", //$NON-NLS-1$
            "UTC+08:00", //$NON-NLS-1$
            "UTC+09:00", //$NON-NLS-1$
            "UTC+10:00", //$NON-NLS-1$
            "UTC+11:00", //$NON-NLS-1$
            "UTC+12:00" //$NON-NLS-1$
            ));
    List<String> ENCODINGS = Collections.unmodifiableList(Arrays.asList(
            "UTF-8", //$NON-NLS-1$
            "UTF-16", //$NON-NLS-1$
            "UTF-16BE", //$NON-NLS-1$
            "UTF-16LE", //$NON-NLS-1$
            "US-ASCII", //$NON-NLS-1$
            "KOI8-R", //$NON-NLS-1$
            "windows-1251", //$NON-NLS-1$
            "windows-1252" //$NON-NLS-1$
            ));
}
