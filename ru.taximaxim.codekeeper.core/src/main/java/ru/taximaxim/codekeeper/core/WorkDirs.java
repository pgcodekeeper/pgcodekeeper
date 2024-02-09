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
package ru.taximaxim.codekeeper.core;

import java.util.List;

import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public class WorkDirs {

    public static final String OVERRIDES = "OVERRIDES";

    /*
     * directory names for Postgres
     */
    public static final String PG_SCHEMA = "SCHEMA";
    private static final String PG_EXTENSION = "EXTENSION";
    private static final String PG_EVENT_TRIGGER = "EVENT_TRIGGER";
    private static final String PG_USER_MAPPING = "USER_MAPPING";
    private static final String PG_CAST = "CAST";
    private static final String PG_SERVER = "SERVER";
    private static final String PG_FDW = "FDW";

    // PG first level folders
    private static final List<String> PG_DIRECTORY_NAMES = List.of(PG_SCHEMA, PG_EXTENSION, PG_EVENT_TRIGGER,
            PG_USER_MAPPING, PG_CAST, PG_SERVER, PG_FDW);

    /*
     * directory names for Microsoft Server
     */
    public static final String MS_SECURITY = "Security";
    public static final String MS_SCHEMAS = "Schemas";
    public static final String MS_USERS = "Users";
    public static final String MS_ROLES = "Roles";
    private static final String MS_TABLES = "Tables";
    private static final String MS_FUNCTIONS = "Functions";
    private static final String MS_VIEWS = "Views";
    private static final String MS_ASSEMBLIES = "Assemblies";
    private static final String MS_TYPES = "Types";
    private static final String MS_SEQUENCES = "Sequences";
    private static final String MS_PROCEDURES = "Stored Procedures";

    // MS first level folders
    private static final List<String> MS_DIRECTORY_NAMES = List.of(MS_ASSEMBLIES, MS_TYPES, MS_TABLES, MS_VIEWS,
            MS_SEQUENCES, MS_FUNCTIONS, MS_PROCEDURES, MS_SECURITY);

    public static List<String> getDirectoryNames(DatabaseType databaseType) {
        switch (databaseType) {
        case MS:
            return MS_DIRECTORY_NAMES;
        case PG:
            return PG_DIRECTORY_NAMES;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + databaseType);
        }
    }

    public static String getDirectoryNameForType(DatabaseType databaseType, DbObjType type) {
        switch (databaseType) {
        case MS:
            return getMsDirectoryNameForType(type);
        case PG:
            return getPgDirectoryNameForType(type);
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + databaseType);
        }
    }

    private static String getMsDirectoryNameForType(DbObjType type) {
        switch (type) {
        case SCHEMA:
            return MS_SCHEMAS;
        case ROLE:
            return MS_ROLES;
        case USER:
            return MS_USERS;
        case ASSEMBLY:
            return MS_ASSEMBLIES;
        case SEQUENCE:
            return MS_SEQUENCES;
        case VIEW:
            return MS_VIEWS;
        case TABLE:
            return MS_TABLES;
        case FUNCTION:
            return MS_FUNCTIONS;
        case PROCEDURE:
            return MS_PROCEDURES;
        case TYPE:
            return MS_TYPES;
        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
        case COLUMN:
            return null;
        default:
            throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
        }
    }

    private static String getPgDirectoryNameForType(DbObjType type) {
        switch (type) {
        case EXTENSION:
        case SERVER:
        case USER_MAPPING:
        case CAST:
        case EVENT_TRIGGER:
        case SCHEMA:
        case COLLATION:
        case SEQUENCE:
        case TYPE:
        case DOMAIN:
        case VIEW:
        case TABLE:
        case FUNCTION:
        case PROCEDURE:
        case AGGREGATE:
        case OPERATOR:
        case FTS_TEMPLATE:
        case FTS_PARSER:
        case FTS_DICTIONARY:
        case FTS_CONFIGURATION:
            return type.name();
        case FOREIGN_DATA_WRAPPER:
            return PG_FDW;
        case CONSTRAINT:
        case INDEX:
        case RULE:
        case TRIGGER:
        case POLICY:
        case COLUMN:
            return null;
        default:
            throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
        }
    }

    public static boolean isInMsSchema(String dirSub) {
        return !dirSub.equals(MS_ASSEMBLIES) && !dirSub.equals(MS_SECURITY);
    }

    private WorkDirs() {
    }
}
