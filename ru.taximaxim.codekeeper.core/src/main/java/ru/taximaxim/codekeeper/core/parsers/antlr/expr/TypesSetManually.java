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
package ru.taximaxim.codekeeper.core.parsers.antlr.expr;

public interface TypesSetManually {
    String UNKNOWN = "unknown_unknown";
    String EMPTY = "empty";

    String COLUMN = "column";
    String FUNCTION_COLUMN = "functionCol";
    String FUNCTION_TABLE = "functionTable";

    String QUALIFIED_ASTERISK = "qualifiedAsterisk";

    String BIT = "bit";
    String BOOLEAN = "boolean";
    String INTEGER = "integer";
    String NUMERIC = "numeric";
    String DOUBLE = "double precision";
    String BPCHAR = "bpchar";
    String TEXT = "text";
    String NAME = "name";
    String XML = "xml";
    String JSON = "json";
    String ANY = "any";
    String ANYTYPE = "anyelement";
    String ANYARRAY = "anyarray";
    String ANYENUM = "anyenum";
    String ANYRANGE = "anyrange";
    String ANYNOARRAY = "anynonarray";

    String DATE = "date";
    String TIMETZ = "time with time zone";
    String TIMESTAMPTZ = "timestamp with time zone";
    String TIME = "time without time zone";
    String TIMESTAMP = "timestamp without time zone";
    String CURSOR = "refcursor";
}
