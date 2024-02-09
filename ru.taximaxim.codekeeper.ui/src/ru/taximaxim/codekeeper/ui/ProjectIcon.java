/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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

public enum ProjectIcon {

    // external icons
    APP_SMALL("/icons/app_icon16.png"), //$NON-NLS-1$
    APP_WIZ("/icons/app_icon_wiz.png"), //$NON-NLS-1$
    APP_BIG("/icons/app_icon128.png"), //$NON-NLS-1$
    BALL_BLUE("/icons/ball_blue.png"), //$NON-NLS-1$
    BALL_GREEN("/icons/ball_green.png"), //$NON-NLS-1$
    ADD_DEP("/icons/add_dep.png"), //$NON-NLS-1$
    COLUMN("/icons/columns.png"), //$NON-NLS-1$
    PGPASS("/icons/pg_pass.png"), //$NON-NLS-1$
    ZIP("/icons/zip.png"), //$NON-NLS-1$
    PG_ICON("/icons/postgresql_icon.png"), //$NON-NLS-1$
    MS_ICON("/icons/mssql_icon.png"), //$NON-NLS-1$
    CH_ICON("/icons/ch_icon16.png"), //$NON-NLS-1$
    DECOR_DATABASE("/icons/db_decorator.png"), //$NON-NLS-1$
    DECOR_PGCODEKEEPER("/icons/nature_decorator.png"), //$NON-NLS-1$

    // pgadmin icons
    DATABASE("/icons/pgadmin/database.png"), //$NON-NLS-1$

    // copies of inaccessible Eclipse icons
    SEARCH_LINE("/icons/search_line.gif"), //$NON-NLS-1$
    EDIT("/icons/editor_area.png"), //$NON-NLS-1$
    SELECT_ALL("/icons/check_all.gif"), //$NON-NLS-1$
    SELECT_NONE("/icons/uncheck_all.gif"), //$NON-NLS-1$
    INVERT_SELECTION("/icons/loop_obj.png"), //$NON-NLS-1$
    APPLY_TO("/icons/save_edit.png"), //$NON-NLS-1$
    REFRESH("/icons/refresh_16x18.png"), //$NON-NLS-1$
    WRITEOUT_CONSOLE("/icons/writeout_co.png"), //$NON-NLS-1$
    EMPTY_FILTER("/icons/empty_filter.png"), //$NON-NLS-1$
    FILTER("/icons/filter_tsk.png"), //$NON-NLS-1$
    ALERT("/icons/alert_obj.gif"), //$NON-NLS-1$
    SORT("/icons/alpha_mode.gif"), //$NON-NLS-1$
    LIB("/icons/lib.gif"), //$NON-NLS-1$
    CLOUD("/icons/cloud.png"), //$NON-NLS-1$
    IMPORT("/icons/import_wiz.png"), //$NON-NLS-1$
    EXPORT("/icons/export_wiz.png"); //$NON-NLS-1$

    public static final String PG_ADMIN_ICON_FOLDER = "/icons/pgadmin/"; //$NON-NLS-1$

    private final String path;

    private ProjectIcon(String path) {
        this.path = path;
    }

    public final String getPath() {
        return path;
    }
}
