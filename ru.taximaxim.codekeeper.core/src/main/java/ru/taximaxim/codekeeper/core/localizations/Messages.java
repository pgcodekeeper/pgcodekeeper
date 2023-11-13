/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.localizations;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {
    public static final String BUNDLE_NAME = "ru.taximaxim.codekeeper.core.localizations.messages"; //$NON-NLS-1$

    // SONAR-OFF

    // common
    public static String UnknownDBFormat;

    // pgdiff.loader
    public static String Connection_DatabaseJdbcAccessError;

    public static String Constraint_WarningMismatchedConstraintTypeForClusterOn;

    public static String ProjectUpdater_error_backup_restore;

    public static String ProjectUpdater_error_no_tempdir;

    public static String ProjectUpdater_error_update;

    public static String ProjectUpdater_old_db_null;
    public static String PgDiff_read_error;

    public static String Table_TypeParameterChange;
    public static String Storage_WarningUnableToDetermineStorageType;

    public static String XmlStore_read_error;

    public static String XmlStore_root_error;

    public static String XmlStore_write_error;

    // SONAR-ON

    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
