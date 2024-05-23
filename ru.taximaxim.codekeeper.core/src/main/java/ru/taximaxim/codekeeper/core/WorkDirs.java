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

import java.nio.file.Path;
import java.util.List;

import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class WorkDirs {

    public static final String OVERRIDES = "OVERRIDES";

    /*
     * directory names for Postgres
     */
    public static final String PG_SCHEMA = DbObjType.SCHEMA.name();
    private static final String PG_EXTENSION = DbObjType.EXTENSION.name();
    private static final String PG_EVENT_TRIGGER = DbObjType.EVENT_TRIGGER.name();
    private static final String PG_USER_MAPPING = DbObjType.USER_MAPPING.name();
    private static final String PG_CAST = DbObjType.CAST.name();
    private static final String PG_SERVER = DbObjType.SERVER.name();
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

    /*
     * directory names for ClickHouse
     */
    public static final String CH_DATABASE = DbObjType.DATABASE.name();
    private static final String CH_FUNCTION = DbObjType.FUNCTION.name();
    private static final String CH_POLICY = DbObjType.POLICY.name();
    private static final String CH_USER = DbObjType.USER.name();
    private static final String CH_ROLE = DbObjType.ROLE.name();

    // CH first level folder
    private static final List<String> CH_DIRECTORY_NAMES = List.of(CH_DATABASE, CH_FUNCTION, CH_USER,
            CH_POLICY, CH_ROLE);

    public static List<String> getDirectoryNames(DatabaseType databaseType) {
        switch (databaseType) {
        case CH:
            return CH_DIRECTORY_NAMES;
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
        case CH:
            return getChDirectoryNameForType(type);
        case MS:
            return getMsDirectoryNameForType(type);
        case PG:
            return getPgDirectoryNameForType(type);
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + databaseType);
        }
    }

    public static Path getRelativeFolderPath(PgStatement st, Path baseDir) {
        var databaseType = st.getDbType();
        switch (databaseType) {
        case CH:
            return getChRelativeFolderPath(st, baseDir);
        case MS:
            return getMsRelativeFolderPath(st, baseDir);
        case PG:
            return getPgRelativeFolderPath(st, baseDir);
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + databaseType);
        }
    }

    private static String getChDirectoryNameForType(DbObjType type) {
        switch (type) {
        case SCHEMA:
            return CH_DATABASE;
        case FUNCTION:
        case POLICY:
        case USER:
        case ROLE:
        case TABLE:
        case VIEW:
            return type.name();
        case CONSTRAINT:
        case INDEX:
        case COLUMN:
            return null;
        default:
            throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
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

    private static Path getPgRelativeFolderPath(PgStatement st, Path baseDir) {
        DbObjType type = st.getStatementType();
        switch (type) {
        case EXTENSION:
        case SERVER:
        case USER_MAPPING:
        case CAST:
        case EVENT_TRIGGER:
        case FOREIGN_DATA_WRAPPER:
            return baseDir.resolve(getPgDirectoryNameForType(type));
        case SCHEMA:
            String schemaName = FileUtils.getValidFilename(st.getBareName());
            return baseDir.resolve(PG_SCHEMA).resolve(schemaName);

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
            PgStatement parentSt = st.getParent();
            schemaName = FileUtils.getValidFilename(parentSt.getBareName());
            return baseDir.resolve(PG_SCHEMA).resolve(schemaName).resolve(getPgDirectoryNameForType(type));
        default:
            throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
        }
    }

    private static Path getMsRelativeFolderPath(PgStatement st, Path baseDir) {
        DbObjType type = st.getStatementType();
        switch (type) {
        case SCHEMA:
        case ROLE:
        case USER:
            return baseDir.resolve(MS_SECURITY).resolve(getMsDirectoryNameForType(type));
        case ASSEMBLY:
        case SEQUENCE:
        case VIEW:
        case TABLE:
        case FUNCTION:
        case PROCEDURE:
        case TYPE:
            return baseDir.resolve(getMsDirectoryNameForType(type));
        default:
            throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
        }
    }

    private static Path getChRelativeFolderPath(PgStatement st, Path baseDir) {
        DbObjType type = st.getStatementType();
        switch (type) {
        case USER:
        case ROLE:
        case FUNCTION:
        case POLICY:
            return baseDir.resolve(getChDirectoryNameForType(type));
        case SCHEMA:
            String databaseName = FileUtils.getValidFilename(st.getBareName());
            return baseDir.resolve(CH_DATABASE).resolve(databaseName);
        case TABLE:
        case VIEW:
            PgStatement parentSt = st.getParent();
            databaseName = FileUtils.getValidFilename(parentSt.getBareName());
            return baseDir.resolve(CH_DATABASE).resolve(databaseName).resolve(getChDirectoryNameForType(type));
        default:
            throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
        }
    }

    private WorkDirs() {
    }
}
