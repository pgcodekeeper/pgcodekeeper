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
package ru.taximaxim.codekeeper.core.model.difftree;

/**
 * Типы объектов в базе <br>
 * ! Внимание, порядок обозначенный здесь используется при построении списка
 * объектов для наката
 * {@link CompareTree}
 */
public enum DbObjType {
    DATABASE,
    CAST,
    USER,
    ROLE,
    ASSEMBLY,
    SCHEMA,
    EXTENSION,
    EVENT_TRIGGER,
    FOREIGN_DATA_WRAPPER,
    SERVER,
    USER_MAPPING,
    COLLATION,
    TYPE,
    DOMAIN,
    SEQUENCE,
    OPERATOR,
    FTS_PARSER,
    FTS_TEMPLATE,
    FTS_DICTIONARY,
    FTS_CONFIGURATION,
    TABLE,
    COLUMN,
    FUNCTION,
    PROCEDURE,
    AGGREGATE,
    INDEX,
    CONSTRAINT,
    VIEW,
    TRIGGER,
    RULE,
    POLICY
}
