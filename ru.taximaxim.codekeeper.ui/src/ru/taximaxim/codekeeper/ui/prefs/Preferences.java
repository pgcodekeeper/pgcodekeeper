/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.prefs;

import static ru.taximaxim.codekeeper.ui.prefs.PreferenceScope.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public enum Preferences {

    IGNORE_COLUMN_ORDER(
            new BooleanPreference(PREF.IGNORE_COLUMN_ORDER, PreferenceCategory.MAIN,
            Messages.GeneralPrefPage_ignore_column_order,
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_GET_CHANGES))),
    NO_PRIVILEGES(
            new BooleanPreference(PREF.NO_PRIVILEGES, PreferenceCategory.MAIN,
            Messages.dbUpdatePrefPage_ignore_privileges,
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_GET_CHANGES))),
    ENABLE_BODY_DEPENDENCIES(
            new BooleanPreference(PREF.ENABLE_BODY_DEPENDENCIES, PreferenceCategory.MAIN,
            Messages.GeneralPrefPage_enable_body_dependencies, Messages.GeneralPrefPage_body_depcy_tooltip, null, false,
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_GET_CHANGES))),
    SIMPLIFY_NOT_NULL(
            new BooleanPreference(PREF.SIMPLIFY_NOT_NULL, PreferenceCategory.MAIN,
            Messages.GeneralPrefPage_simplify_not_null, null, null, false, Set.of(DatabaseType.PG),
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_GET_CHANGES))),
    SIMPLIFY_VIEW(
            new BooleanPreference(PREF.SIMPLIFY_VIEW, PreferenceCategory.MAIN,
            Messages.GeneralPrefPage_simplify_view, null, null, false, Set.of(DatabaseType.PG),
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_GET_CHANGES))),
    FORMAT_OBJECT_CODE_AUTOMATICALLY(
            new BooleanPreference(PREF.FORMAT_OBJECT_CODE_AUTOMATICALLY, PreferenceCategory.MAIN,
            Messages.GeneralPrefPage_format_object_code_automatically,
            Set.of(GLOBAL, CUSTOM_GET_CHANGES))),
    USE_GLOBAL_IGNORE_LIST(
            new BooleanPreference(PROJ_PREF.USE_GLOBAL_IGNORE_LIST, PreferenceCategory.MAIN,
            Messages.ProjectProperties_use_global_ignore_list, null, true, false,
            Set.of(PROJECT, DIFF_WIZARD, CUSTOM_GET_CHANGES))),
    SCRIPT_IN_TRANSACTION(
            new BooleanPreference(DB_UPDATE_PREF.SCRIPT_IN_TRANSACTION, PreferenceCategory.DB_UPDATE,
            Messages.DbUpdatePrefPage_script_add_transaction,
            Set.of(GLOBAL, PROJECT, CUSTOM_APPLY_TO, DIFF_WIZARD))),
    DISABLE_CHECK_FUNCTION_BODIES(
            new BooleanPreference(DB_UPDATE_PREF.DISABLE_CHECK_FUNCTION_BODIES, PreferenceCategory.DB_UPDATE,
            Messages.dbUpdatePrefPage_check_function_bodies, null, null, false, Set.of(DatabaseType.PG),
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_APPLY_TO))),
    PRINT_USING(
            new BooleanPreference(DB_UPDATE_PREF.PRINT_USING, PreferenceCategory.DB_UPDATE,
            Messages.dbUpdatePrefPage_switch_on_off_using, null, true, false, Set.of(DatabaseType.PG),
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_APPLY_TO))),
    PRINT_INDEX_WITH_CONCURRENTLY(
            new BooleanPreference(DB_UPDATE_PREF.PRINT_INDEX_WITH_CONCURRENTLY, PreferenceCategory.DB_UPDATE,
            Messages.DbUpdatePrefPage_print_index_with_concurrently,
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_APPLY_TO))),
    PRINT_CONSTRAINT_NOT_VALID(
            new BooleanPreference(DB_UPDATE_PREF.PRINT_CONSTRAINT_NOT_VALID, PreferenceCategory.DB_UPDATE,
            Messages.ApplyCustomDialog_constraint_not_valid, null, null, false, Set.of(DatabaseType.PG),
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_APPLY_TO))),
    SCRIPT_FROM_SELECTED_OBJS(
            new BooleanPreference(DB_UPDATE_PREF.SCRIPT_FROM_SELECTED_OBJS, PreferenceCategory.DB_UPDATE,
            Messages.DbUpdatePrefPage_script_from_selected_objs,
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_APPLY_TO))),
    GENERATE_EXISTS(
            new BooleanPreference(DB_UPDATE_PREF.GENERATE_EXISTS, PreferenceCategory.DB_UPDATE,
            Messages.DbUpdatePrefPage_option_if_exists,
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_APPLY_TO))),
    GENERATE_EXIST_DO_BLOCK(
            new BooleanPreference(DB_UPDATE_PREF.GENERATE_EXIST_DO_BLOCK, PreferenceCategory.DB_UPDATE,
            Messages.DbUpdatePrefPage_generate_exist_do_block, null, null, false, Set.of(DatabaseType.PG),
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_APPLY_TO))),
    DROP_BEFORE_CREATE(
            new BooleanPreference(DB_UPDATE_PREF.DROP_BEFORE_CREATE, PreferenceCategory.DB_UPDATE,
            Messages.DbUpdatePrefPage_option_drop_object,
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_APPLY_TO))),
    ADD_PRE_POST_SCRIPT(
            new BooleanPreference(DB_UPDATE_PREF.ADD_PRE_POST_SCRIPT, PreferenceCategory.DB_UPDATE,
            Messages.DbUpdatePrefPage_add_pre_post_script,
            Set.of(PROJECT, CUSTOM_APPLY_TO))),
    COMMENTS_TO_END(
            new BooleanPreference(DB_UPDATE_PREF.COMMENTS_TO_END, PreferenceCategory.DB_UPDATE,
            Messages.DbUpdatePrefPage_comments_to_end, null, null, false, Set.of(DatabaseType.PG),
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_APPLY_TO))),
    DATA_MOVEMENT_MODE(
            new BooleanPreference(DB_UPDATE_PREF.DATA_MOVEMENT_MODE, PreferenceCategory.DB_UPDATE,
            Messages.DbUpdatePrefPage_allow_data_movement,
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_APPLY_TO))),
    USE_ACTUAL_VERSION_SYNTAX(
            new BooleanPreference(DB_UPDATE_PREF.USE_ACTUAL_VERSION_SYNTAX,
            PreferenceCategory.DB_UPDATE, Messages.dbUpdatePrefPage_use_actual_version_syntax,
            Set.of(GLOBAL, PROJECT, DIFF_WIZARD, CUSTOM_APPLY_TO))),
    CLUSTER_NAME(
            new StringPreference(DB_UPDATE_PREF.CLUSTER_NAME, PreferenceCategory.DB_UPDATE,
            Messages.DbUpdatePrefPage_cluster_name, null, null, false, Set.of(DatabaseType.CH),
            Set.of(PROJECT, CUSTOM_APPLY_TO)));


    private AbstractPreference<?> preference;

    private Preferences(AbstractPreference<?> preference) {
        this.preference = preference;
    }

    public static void initialize(IPreferenceStore store) {
        for (var value : values()) {
            var preference = value.preference;
            if (preference.getInitialValue() != null) {
                preference.initialize(store);
            }
        }
    }

    public static PreferenceCategory getCategory(String preferenceName) {
        for (var value : values()) {
            if (value.getPreferenceName().equals(preferenceName)) {
                return value.preference.getCategory();
            }
        }
        throw new IllegalArgumentException();
    }

    public static List<FieldEditor> build(PreferenceScope scope, PreferenceCategory category, Composite parent,
            DatabaseType dbType) {
        List<FieldEditor> list = new ArrayList<>();
        for (var value : values()) {
            var preference = value.preference;
            if (category == preference.getCategory() && preference.inScope(scope)
                    && preference.isNeedForThisDbType(dbType, scope)) {
                list.add(preference.create(parent, scope));
            }
        }
        return list;
    }

    public static List<AbstractPreference<?>> getPreferencesForScope(PreferenceCategory category, PreferenceScope scope,
            DatabaseType dbType) {
        List<AbstractPreference<?>> list = new ArrayList<>();
        for (var value : values()) {
            AbstractPreference<?> preference = value.preference;
            if (category == preference.getCategory() && preference.inScope(scope)
                    && preference.isNeedForThisDbType(dbType, scope)) {
                list.add(preference);
            }
        }
        return list;
    }

    public String getPreferenceName() {
        return preference.getPreferenceName();
    }
}
