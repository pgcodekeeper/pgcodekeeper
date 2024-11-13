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

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public enum ObjectLevel {
    SCHEMA, CONTAINER, SUB_ELEMENT, UNKNOWN;

    public static ObjectLevel getLevel(DatabaseType dbType, DbObjType objType) {
        return switch (objType) {
            case SCHEMA -> ObjectLevel.SCHEMA;
            case ROLE, USER -> dbType != DatabaseType.PG ? ObjectLevel.SCHEMA : ObjectLevel.UNKNOWN;
            case SERVER, CAST, EVENT_TRIGGER, EXTENSION, FOREIGN_DATA_WRAPPER, USER_MAPPING ->
                    dbType == DatabaseType.PG ? ObjectLevel.SCHEMA : ObjectLevel.UNKNOWN;
            case AGGREGATE, COLLATION, DOMAIN, FTS_CONFIGURATION, FTS_DICTIONARY, FTS_TEMPLATE, FTS_PARSER,
                    OPERATOR -> dbType == DatabaseType.PG ? ObjectLevel.CONTAINER : ObjectLevel.UNKNOWN;
            case TABLE, VIEW -> ObjectLevel.CONTAINER;
            case FUNCTION -> DatabaseType.CH == dbType ? ObjectLevel.SCHEMA : ObjectLevel.CONTAINER;
            case PROCEDURE, TYPE -> dbType != DatabaseType.CH ? ObjectLevel.CONTAINER : ObjectLevel.UNKNOWN;
            case DICTIONARY -> dbType == DatabaseType.CH ? ObjectLevel.CONTAINER : ObjectLevel.UNKNOWN;
            case ASSEMBLY -> DatabaseType.MS == dbType ? ObjectLevel.SCHEMA : ObjectLevel.UNKNOWN;
            case INDEX, CONSTRAINT -> ObjectLevel.SUB_ELEMENT;
            case RULE -> dbType == DatabaseType.PG ? ObjectLevel.SUB_ELEMENT : ObjectLevel.UNKNOWN;
            case TRIGGER, SEQUENCE -> dbType != DatabaseType.CH ? ObjectLevel.SUB_ELEMENT : ObjectLevel.UNKNOWN;
            case POLICY -> switch (dbType) {
                case CH -> ObjectLevel.SCHEMA;
                case PG -> ObjectLevel.SUB_ELEMENT;
                default -> ObjectLevel.UNKNOWN;
            };
            case STATISTICS -> switch (dbType) {
                case PG -> ObjectLevel.CONTAINER;
                case MS -> ObjectLevel.SUB_ELEMENT;
                default -> ObjectLevel.UNKNOWN;
            };
            default -> UNKNOWN;
        };
    }

    public static Set<DbObjType> getTypes(DatabaseType dbType, boolean addAllTypes, ObjectLevel... levels) {
        Set<DbObjType> res = EnumSet.noneOf(DbObjType.class);
        List<ObjectLevel> allowedLevels = Arrays.stream(levels).toList();

        for (DbObjType objType : DbObjType.values()) {
            if (!addAllTypes && objType.in(DbObjType.COLUMN, DbObjType.DATABASE)) {
                continue;
            }

            if (allowedLevels.contains(getLevel(dbType, objType))) {
                res.add(objType);
            }
        }

        return res;
    }
}
