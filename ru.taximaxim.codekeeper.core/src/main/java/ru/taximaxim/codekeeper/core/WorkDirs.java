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
package ru.taximaxim.codekeeper.core;

import java.nio.file.Path;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public final class WorkDirs {

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

    /**
     * Loading order and directory names of the objects in exported DB schemas.
     */
    private static final EnumSet<DbObjType> DIR_LOAD_ORDER = EnumSet.of(DbObjType.COLLATION, DbObjType.TYPE,
            DbObjType.DOMAIN, DbObjType.SEQUENCE, DbObjType.FUNCTION, DbObjType.PROCEDURE, DbObjType.AGGREGATE,
            DbObjType.OPERATOR, DbObjType.TABLE, DbObjType.VIEW, DbObjType.STATISTICS, DbObjType.DICTIONARY,
            DbObjType.FTS_PARSER, DbObjType.FTS_TEMPLATE, DbObjType.FTS_DICTIONARY, DbObjType.FTS_CONFIGURATION);

    public static List<String> getDirectoryNames(DatabaseType databaseType) {
        return switch (databaseType) {
            case CH -> CH_DIRECTORY_NAMES;
            case MS -> MS_DIRECTORY_NAMES;
            case PG -> PG_DIRECTORY_NAMES;
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + databaseType);
        };
    }

    public static String getDirectoryNameForType(DatabaseType databaseType, DbObjType type) {
        return switch (databaseType) {
            case CH -> getChDirectoryNameForType(type);
            case MS -> getMsDirectoryNameForType(type);
            case PG -> getPgDirectoryNameForType(type);
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + databaseType);
        };
    }

    public static Path getRelativeFolderPath(PgStatement st, Path baseDir) {
        var databaseType = st.getDbType();
        return switch (databaseType) {
            case CH -> getChRelativeFolderPath(st, baseDir);
            case MS -> getMsRelativeFolderPath(st, baseDir);
            case PG -> getPgRelativeFolderPath(st, baseDir);
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + databaseType);
        };
    }

    private static String getChDirectoryNameForType(DbObjType type) {
        return switch (type) {
            case SCHEMA -> CH_DATABASE;
            case FUNCTION, POLICY, USER, ROLE, TABLE, DICTIONARY, VIEW -> type.name();
            case CONSTRAINT, INDEX, COLUMN -> null;
            default -> throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
        };
    }

    private static String getMsDirectoryNameForType(DbObjType type) {
        return switch (type) {
            case SCHEMA -> MS_SCHEMAS;
            case ROLE -> MS_ROLES;
            case USER -> MS_USERS;
            case ASSEMBLY -> MS_ASSEMBLIES;
            case SEQUENCE -> MS_SEQUENCES;
            case VIEW -> MS_VIEWS;
            case TABLE -> MS_TABLES;
            case FUNCTION -> MS_FUNCTIONS;
            case PROCEDURE -> MS_PROCEDURES;
            case TYPE -> MS_TYPES;
            case CONSTRAINT, INDEX, TRIGGER, COLUMN, STATISTICS -> null;
            default -> throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
        };
    }

    private static String getPgDirectoryNameForType(DbObjType type) {
        return switch (type) {
            case FOREIGN_DATA_WRAPPER -> PG_FDW;
            case CONSTRAINT, INDEX, RULE, TRIGGER, POLICY, COLUMN -> null;
            case EXTENSION, SERVER, USER_MAPPING, CAST, EVENT_TRIGGER, SCHEMA, COLLATION, SEQUENCE, TYPE, DOMAIN,
            VIEW, TABLE, FUNCTION, PROCEDURE, AGGREGATE, OPERATOR, FTS_TEMPLATE, FTS_PARSER, FTS_DICTIONARY,
            FTS_CONFIGURATION, STATISTICS -> type.name(); 
            default -> throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
        };
    }

    public static boolean isInMsSchema(String dirSub) {
        return !dirSub.equals(MS_ASSEMBLIES) && !dirSub.equals(MS_SECURITY);
    }

    private static Path getPgRelativeFolderPath(PgStatement st, Path baseDir) {
        DbObjType type = st.getStatementType();
        return switch (type) {
            case EXTENSION, SERVER, USER_MAPPING, CAST, EVENT_TRIGGER, FOREIGN_DATA_WRAPPER -> baseDir
                .resolve(getPgDirectoryNameForType(type));
            case SCHEMA -> {
                String schemaName = FileUtils.getValidFilename(st.getBareName());
                yield baseDir.resolve(PG_SCHEMA).resolve(schemaName);
            }
            case COLLATION, SEQUENCE, TYPE, DOMAIN, VIEW, TABLE, FUNCTION, PROCEDURE, AGGREGATE, OPERATOR,
            FTS_TEMPLATE, FTS_PARSER, FTS_DICTIONARY, FTS_CONFIGURATION, STATISTICS -> {
                PgStatement parentSt = st.getParent();
                String schemaName = FileUtils.getValidFilename(parentSt.getBareName());
                yield baseDir.resolve(PG_SCHEMA).resolve(schemaName).resolve(getPgDirectoryNameForType(type));
            }
            default -> throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
        };
    }

    private static Path getMsRelativeFolderPath(PgStatement st, Path baseDir) {
        DbObjType type = st.getStatementType();
        return switch (type) {
            case SCHEMA, ROLE, USER -> baseDir.resolve(MS_SECURITY).resolve(getMsDirectoryNameForType(type));
            case ASSEMBLY, SEQUENCE, VIEW, TABLE, FUNCTION, PROCEDURE, TYPE -> baseDir
                .resolve(getMsDirectoryNameForType(type));
            default -> throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
        };
    }

    private static Path getChRelativeFolderPath(PgStatement st, Path baseDir) {
        DbObjType type = st.getStatementType();
        return switch (type) {
            case USER, ROLE, FUNCTION, POLICY -> baseDir.resolve(getChDirectoryNameForType(type));
            case SCHEMA -> {
                String databaseName = FileUtils.getValidFilename(st.getBareName());
                yield baseDir.resolve(CH_DATABASE).resolve(databaseName);
            }
            case TABLE, DICTIONARY, VIEW -> {
                PgStatement parentSt = st.getParent();
                String databaseName = FileUtils.getValidFilename(parentSt.getBareName());
                yield baseDir.resolve(CH_DATABASE).resolve(databaseName).resolve(getChDirectoryNameForType(type));
            }
            default -> throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
        };
    }

    public static Set<DbObjType> getDirLoadOrder() {
        return DIR_LOAD_ORDER;
    }

    private WorkDirs() {
    }
}
