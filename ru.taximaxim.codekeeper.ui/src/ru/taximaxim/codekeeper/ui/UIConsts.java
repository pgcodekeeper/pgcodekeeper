/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui;

import java.util.List;

import org.eclipse.jface.viewers.LabelProvider;

import ru.taximaxim.codekeeper.core.DatabaseType;

public interface UIConsts {

    LabelProvider DATABASE_TYPE_PROVIDER = new LabelProvider() {

        @Override
        public String getText(Object element) {
            var dbType = (DatabaseType) element;
            return dbType.getDbTypeName();
        }
    };

    String _NL = System.lineSeparator();

    interface PLUGIN_ID {
        String THIS = "ru.taximaxim.codekeeper.ui"; //$NON-NLS-1$
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
        String OBJECT_OCCURRENCE = PLUGIN_ID.THIS + ".sql.objectoccurrence"; //$NON-NLS-1$
        String ERROR_TYPE = PLUGIN_ID.THIS + ".sql.error_type"; //$NON-NLS-1$
        String MISPLACE_ERROR = PLUGIN_ID.THIS + ".sql.misplace_error"; //$NON-NLS-1$
    }

    interface DECORATOR {
        String DECORATOR = PLUGIN_ID.THIS + ".decorator"; //$NON-NLS-1$
    }

    interface VIEW {
        String OVERRIDE_VIEW = PLUGIN_ID.THIS + ".pgoverrideview"; //$NON-NLS-1$
        String RESULT_SET_VIEW = PLUGIN_ID.THIS + ".resultsetview"; //$NON-NLS-1$
    }

    interface WIZARD {
        String NEW_PROJECT_WIZARD = PLUGIN_ID.THIS + ".newprojwizard"; //$NON-NLS-1$
    }

    interface COMMAND {
        /*
         * EGit commit command id (value of org.eclipse.egit.ui.internal.actions.ActionCommands.COMMIT_ACTION)
         */
        String COMMIT_COMMAND_ID = "org.eclipse.egit.ui.team.Commit"; //$NON-NLS-1$

        String ADD_DEPCY = PLUGIN_ID.THIS + ".command.AddDepcy"; //$NON-NLS-1$
    }

    interface PREF_PAGE {
        String DB_STORE = PLUGIN_ID.THIS + ".dbstore"; //$NON-NLS-1$
        String SQL_EDITOR = PLUGIN_ID.THIS + ".sqleditor"; //$NON-NLS-1$
        String DEPENDENCIES = PLUGIN_ID.THIS + ".dependencies"; //$NON-NLS-1$
    }

    interface PREF {
        String SAVE_IN_SECURE_STORAGE = "prefSaveInSecureStorage"; //$NON-NLS-1$
        String FORCE_SHOW_CONSOLE = "prefForceShowConsole"; //$NON-NLS-1$
        String DB_STORE_FILES = "prefDbStoreHistory"; //$NON-NLS-1$
        String NO_PRIVILEGES = "prefNoPrivileges"; //$NON-NLS-1$
        String IGNORE_COLUMN_ORDER = "prefIgnoreColumnOrder"; //$NON-NLS-1$
        String SIMPLIFY_VIEW = "prefSimplifyView"; //$NON-NLS-1$
        String ENABLE_BODY_DEPENDENCIES = "prefEnableBodyDependencies"; //$NON-NLS-1$
        String LAST_OPENED_LOCATION = "prefLastOpenedLocation"; //$NON-NLS-1$
        String CALL_COMMIT_COMMAND_AFTER_UPDATE = "callCommitCommandAfterUpdate"; //$NON-NLS-1$
        String LAST_CREATED_OBJECT_TYPE = "prefLastCreatedObjectType"; //$NON-NLS-1$
        String EXPLICIT_TYPE_CAST = "explicitTypeCast"; //$NON-NLS-1$
        String REUSE_OPEN_COMPARE_EDITOR = "reuseOpenCompareEditors"; //$NON-NLS-1$
        String IGNORE_CONCURRENT_MODIFICATION = "ignoreConcurrentModification"; //$NON-NLS-1$
        String PARSER_CACHE_CLEANING_INTERVAL = "parserCacheCleaningInterval"; //$NON-NLS-1$
        String HEAP_SIZE_WARNING = "heapSizeWarning"; //$NON-NLS-1$
        String FORMAT_OBJECT_CODE_AUTOMATICALLY = "formatObjectCodeAutomatically"; //$NON-NLS-1$
    }

    interface DB_UPDATE_PREF {
        String CREATE_SCRIPT_IN_PROJECT = "prefAddScriptToProject"; //$NON-NLS-1$
        String DELETE_SCRIPT_AFTER_CLOSE = "prefDeleteScriptAfterClose"; //$NON-NLS-1$
        String DROP_TABLE_STATEMENT = "prefDropTableStatement"; //$NON-NLS-1$
        String ALTER_COLUMN_STATEMENT = "prefAlterColumnStatement"; //$NON-NLS-1$
        String DROP_COLUMN_STATEMENT = "prefDropColumnStatement"; //$NON-NLS-1$
        String ADD_PRE_POST_SCRIPT = "prefAddPrePostScript"; //$NON-NLS-1$
        String RESTART_WITH_STATEMENT = "prefRestartWithStatement"; //$NON-NLS-1$
        String UPDATE_STATEMENT = "prefUpdateStatement"; //$NON-NLS-1$
        String SCRIPT_IN_TRANSACTION = "prefScriptInTransaction"; //$NON-NLS-1$
        String CHECK_FUNCTION_BODIES = "prefCheckFunctionBodies"; //$NON-NLS-1$
        String USING_ON_OFF = "prefUsingOnOff"; //$NON-NLS-1$
        String COMMAND_LINE_DDL_UPDATE = "prefCommandLineDdlUpdate"; //$NON-NLS-1$
        String MIGRATION_COMMAND = "prefMigrationCommand"; //$NON-NLS-1$
        String PRINT_INDEX_WITH_CONCURRENTLY = "prefPrintIndexWithConcurrently"; //$NON-NLS-1$
        String PRINT_CONSTRAINT_NOT_VALID = "prefPrintConstraintNotValid"; //$NON-NLS-1$
        String SCRIPT_FROM_SELECTED_OBJS = "prefScriptFromSelectedObjs"; //$NON-NLS-1$
        String DATA_MOVEMENT_MODE = "prefDataMovementMode"; //$NON-NLS-1$
        String GENERATE_EXISTS = "prefGenerateExist"; //$NON-NLS-1$
        String GENERATE_EXIST_DO_BLOCK = "prefGenerateExistDoBlock"; //$NON-NLS-1$
        String DROP_BEFORE_CREATE = "prefDropBeforeCreate"; //$NON-NLS-1$
        String COMMENTS_TO_END = "prefCommmentsToEnd"; //$NON-NLS-1$
    }

    interface PG_EDIT_PREF {
        String PERSPECTIVE_CHANGING_STATUS = "perspectiveChangingStatus"; //$NON-NLS-1$
        String EDITOR_UPDATE_ACTION = "editorUpdateAction"; //$NON-NLS-1$
        String SHOW_GIT_USER = "showGitUser"; //$NON-NLS-1$
        String UPDATE = "UPDATE"; //$NON-NLS-1$
        String RESET = "RESET"; //$NON-NLS-1$
        String NO_ACTION = "NO_ACTION"; //$NON-NLS-1$
        String SHOW_DIFF_ERRORS = "showDiffErrors"; //$NON-NLS-1$
        String SHOW_FULL_CODE = "showFullCode"; //$NON-NLS-1$
    }

    interface SQL_EDITOR_PREF {
        String MATCHING_BRACKETS = "matchingBrackets"; //$NON-NLS-1$
        String MATCHING_BRACKETS_COLOR = "matchingBracketsColor"; //$NON-NLS-1$
        String HIGHLIGHT_BRACKET_AT_CARET_LOCATION = "highlightBracketAtCaretLocation"; //$NON-NLS-1$
        String ENCLOSING_BRACKETS = "enclosingBrackets"; //$NON-NLS-1$
        String NUMBER_OF_LINES_LIMIT = "numberOfLinesLimit"; //$NON-NLS-1$
    }

    interface FORMATTER_PREF {
        String INDENT_SIZE = "indentSize"; //$NON-NLS-1$
        String REMOVE_TRAILING_WHITESPACE = "removeTrailingWhitespace"; //$NON-NLS-1$
        String ADD_WHITESPACE_BEFORE_OP = "addWhitespaceBeforeOperator"; //$NON-NLS-1$
        String ADD_WHITESPACE_AFTER_OP = "addWhitespaceAfterOperator"; //$NON-NLS-1$

        String INDENT_TYPE = "indentType"; //$NON-NLS-1$
        String WHITESPACE = "whitespace"; //$NON-NLS-1$
        String TAB = "tab"; //$NON-NLS-1$
        String DISABLE = "disable"; //$NON-NLS-1$
    }

    interface USAGE_REPORT_PREF {
        String USAGEREPORT_ENABLED_ID = "allow_usage_report_preference"; //$NON-NLS-1$
        String ASK_USER_USAGEREPORT_ID = "ask_user_for_usage_report_preference"; //$NON-NLS-1$
        String ECLIPSE_INSTANCE_ID = "eclipse_instance_id"; //$NON-NLS-1$
        String FIRST_VISIT = "first_visit"; //$NON-NLS-1$
        String LAST_VISIT = "last_visit"; //$NON-NLS-1$
        String VISIT_COUNT = "visit_count"; //$NON-NLS-1$
    }

    interface PROJ_PREF {
        String TIMEZONE = "prefGeneralTimezone"; //$NON-NLS-1$
        String FORCE_UNIX_NEWLINES = "prefForceUnixNewlines"; //$NON-NLS-1$
        String DISABLE_PARSER_IN_EXTERNAL_FILES = "disableParserInExternalFiles"; //$NON-NLS-1$
        String LIB_SAFE_MODE = "libSafeMode"; //$NON-NLS-1$
        String STORAGE_LIST = "storageList"; //$NON-NLS-1$
        String ENABLE_PROJ_PREF_ROOT = "prefEnableProjPrefRoot"; //$NON-NLS-1$
        String ENABLE_PROJ_PREF_DB_UPDATE = "prefEnableProjPrefDbUpdate"; //$NON-NLS-1$
        String USE_GLOBAL_IGNORE_LIST = "prefUseGlobalIgnoreList"; //$NON-NLS-1$
    }

    interface DB_BIND_PREF {
        String DB_BINDING = PLUGIN_ID.THIS + ".dbbinding"; //$NON-NLS-1$

        String LAST_DB_STORE = "prefLastDbStore"; //$NON-NLS-1$
        String LAST_DIRECTION = "prefLastDirection"; //$NON-NLS-1$
        String LAST_DB_STORE_EDITOR = "prefLastDbStoreEditor"; //$NON-NLS-1$
        String NAME_OF_BOUND_DB = "nameOfBoundDatabase"; //$NON-NLS-1$
    }

    interface DB_STORE_PREF {
        String LAST_DB_STORE_CHANGE_TIME = "prefLastDbStoreChangeTime"; //$NON-NLS-1$
    }

    interface CONN_TYPE_PREF {
        String LAST_CONN_TYPE_CHANGE_TIME = "prefLastConnTypeChangeTime"; //$NON-NLS-1$
    }

    interface PROJ_PATH {
        String MIGRATION_DIR = "MIGRATION"; //$NON-NLS-1$
    }

    interface BUILDER {
        String ID = PLUGIN_ID.THIS + ".builder"; //$NON-NLS-1$
    }

    interface FILE {
        String IGNORED_OBJECTS = ".pgcodekeeperignore"; //$NON-NLS-1$
        String IGNORED_SCHEMA = ".pgcodekeeperignoreschema"; //$NON-NLS-1$

        String IGNORE_LISTS_STORE = PLUGIN_ID.THIS + ".ignoreliststore"; //$NON-NLS-1$

        String PRE_DIR = "PRE"; //$NON-NLS-1$
        String PRE_SCRIPT = "pre_script.sql"; //$NON-NLS-1$
        String POST_DIR = "POST"; //$NON-NLS-1$
        String POST_SCRIPT = "post_script.sql"; //$NON-NLS-1$
    }

    interface WORKING_SET {
        String RESOURCE_WORKING_SET = "org.eclipse.ui.resourceWorkingSetPage"; //$NON-NLS-1$
    }

    interface CMD_VARS {
        String SCRIPT_PLACEHOLDER = "%script"; //$NON-NLS-1$
        String DB_HOST_PLACEHOLDER = "%host"; //$NON-NLS-1$
        String DB_PORT_PLACEHOLDER = "%port"; //$NON-NLS-1$
        String DB_NAME_PLACEHOLDER = "%db"; //$NON-NLS-1$
        String DB_USER_PLACEHOLDER = "%user"; //$NON-NLS-1$
        String DB_PASS_PLACEHOLDER = "%pass"; //$NON-NLS-1$
    }

    String DDL_DEFAULT_CMD = "psql -e -1 -w --set ON_ERROR_STOP=1 -X -h %host -p %port -U %user -f %script %db"; //$NON-NLS-1$

    List<String> TIME_ZONES = List.of(
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
            );
    List<String> ENCODINGS = List.of(
            "UTF-8", //$NON-NLS-1$
            "UTF-16", //$NON-NLS-1$
            "UTF-16BE", //$NON-NLS-1$
            "UTF-16LE", //$NON-NLS-1$
            "US-ASCII", //$NON-NLS-1$
            "KOI8-R", //$NON-NLS-1$
            "windows-1251", //$NON-NLS-1$
            "windows-1252" //$NON-NLS-1$
            );
}
