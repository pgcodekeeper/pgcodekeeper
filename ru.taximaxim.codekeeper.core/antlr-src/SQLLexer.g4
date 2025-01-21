/*
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

lexer grammar SQLLexer;

options {
    caseInsensitive = true;
}

@header {
package ru.taximaxim.codekeeper.core.parsers.antlr.generated;
import java.util.ArrayDeque;
import java.util.Deque;
}

@members {
/* This field stores the tags which are used to detect the end of a dollar-quoted string literal.
*/
private final Deque<String> _tags = new ArrayDeque<String>();
}

    /*
     * Most keyword tokens are autogenerated using the list in the Keyword class,
     * which comes directly from PostgreSQL source.
     * Each word-token must also participate in a parser rule corresponding to 
     * its keyword's category. These are autogenerated using Keyword class.
     * 
     * Manually added word-tokens must also be manually added to the 
     * tokens_nonkeyword parser rule. 
     */

    /*
    ==================================================
    UNRESERVED_KEYWORD
    ==================================================
    */

    ABORT: 'ABORT';    // first identifier rule, sync with CustomSQLAntlrErrorStrategy & AntlrUtils
    ABSENT: 'ABSENT';
    ABSOLUTE: 'ABSOLUTE';
    ACCESS: 'ACCESS';
    ACTION: 'ACTION';
    ADD: 'ADD';
    ADMIN: 'ADMIN';
    AFTER: 'AFTER';
    AGGREGATE: 'AGGREGATE';
    ALSO: 'ALSO';
    ALTER: 'ALTER';
    ALWAYS: 'ALWAYS';
    ASENSITIVE: 'ASENSITIVE';
    ASSERTION: 'ASSERTION';
    ASSIGNMENT: 'ASSIGNMENT';
    AT: 'AT';
    ATOMIC: 'ATOMIC';
    ATTACH: 'ATTACH';
    ATTRIBUTE: 'ATTRIBUTE';

    BACKWARD: 'BACKWARD';
    BEFORE: 'BEFORE';
    BEGIN: 'BEGIN';
    BREADTH: 'BREADTH';
    BY: 'BY';

    CACHE: 'CACHE';
    CALL: 'CALL';
    CALLED: 'CALLED';
    CASCADE: 'CASCADE';
    CASCADED: 'CASCADED';
    CATALOG: 'CATALOG';
    CHAIN: 'CHAIN';
    CHARACTERISTICS: 'CHARACTERISTICS';
    CHECKPOINT: 'CHECKPOINT';
    CLASS: 'CLASS';
    CLOSE: 'CLOSE';
    CLUSTER: 'CLUSTER';
    COLUMNS: 'COLUMNS';
    COMMENT: 'COMMENT';
    COMMENTS: 'COMMENTS';
    COMMIT: 'COMMIT';
    COMMITTED: 'COMMITTED';
    COMPRESSION: 'COMPRESSION';
    CONDITIONAL: 'CONDITIONAL';
    CONFIGURATION: 'CONFIGURATION';
    CONFLICT: 'CONFLICT';
    CONNECTION: 'CONNECTION';
    CONSTRAINTS: 'CONSTRAINTS';
    CONTENT: 'CONTENT';
    CONTINUE: 'CONTINUE';
    CONVERSION: 'CONVERSION';
    COPY: 'COPY';
    COST: 'COST';
    CSV: 'CSV';
    CUBE: 'CUBE';
    CURRENT: 'CURRENT';
    CURSOR: 'CURSOR';
    CYCLE: 'CYCLE';

    DATA: 'DATA';
    DATABASE: 'DATABASE';
    DAY: 'DAY';
    DEALLOCATE: 'DEALLOCATE';
    DECLARE: 'DECLARE';
    DEFAULTS: 'DEFAULTS';
    DEFERRED: 'DEFERRED';
    DEFINER: 'DEFINER';
    DELETE: 'DELETE';
    DELIMITER: 'DELIMITER';
    DELIMITERS: 'DELIMITERS';
    DEPENDS: 'DEPENDS';
    DEPTH: 'DEPTH';
    DETACH: 'DETACH';
    DICTIONARY: 'DICTIONARY';
    DISABLE: 'DISABLE';
    DISCARD: 'DISCARD';
    DOCUMENT: 'DOCUMENT';
    DOMAIN: 'DOMAIN';
    DOUBLE: 'DOUBLE';
    DROP: 'DROP';

    EACH: 'EACH';
    EMPTY: 'EMPTY';
    ENABLE: 'ENABLE';
    ENCODING: 'ENCODING';
    ENCRYPTED: 'ENCRYPTED';
    ENUM: 'ENUM';
    ERROR: 'ERROR';
    ESCAPE: 'ESCAPE';
    EVENT: 'EVENT';
    EXCLUDE: 'EXCLUDE';
    EXCLUDING: 'EXCLUDING';
    EXCLUSIVE: 'EXCLUSIVE';
    EXECUTE: 'EXECUTE';
    EXPLAIN: 'EXPLAIN';
    EXPRESSION: 'EXPRESSION';
    EXTENSION: 'EXTENSION';
    EXTERNAL: 'EXTERNAL';

    FAMILY: 'FAMILY';
    FILTER: 'FILTER';
    FINALIZE: 'FINALIZE';
    FIRST: 'FIRST';
    FOLLOWING: 'FOLLOWING';
    FORCE: 'FORCE';
    FORMAT: 'FORMAT';
    FORWARD: 'FORWARD';
    FUNCTION: 'FUNCTION';
    FUNCTIONS: 'FUNCTIONS';

    GENERATED: 'GENERATED';
    GLOBAL: 'GLOBAL';
    GRANTED: 'GRANTED';
    GROUPS: 'GROUPS';

    HANDLER: 'HANDLER';
    HEADER: 'HEADER';
    HOLD: 'HOLD';
    HOUR: 'HOUR';

    IDENTITY: 'IDENTITY';
    IF: 'IF';
    IMMEDIATE: 'IMMEDIATE';
    IMMUTABLE: 'IMMUTABLE';
    IMPLICIT: 'IMPLICIT';
    IMPORT: 'IMPORT';
    INCLUDE: 'INCLUDE';
    INCLUDING: 'INCLUDING';
    INCREMENT: 'INCREMENT';
    INDENT: 'INDENT';
    INDEX: 'INDEX';
    INDEXES: 'INDEXES';
    INHERIT: 'INHERIT';
    INHERITS: 'INHERITS';
    INLINE: 'INLINE';
    INPUT: 'INPUT';
    INSENSITIVE: 'INSENSITIVE';
    INSERT: 'INSERT';
    INSTEAD: 'INSTEAD';
    INVOKER: 'INVOKER';
    ISOLATION: 'ISOLATION';

    JSON: 'JSON';

    KEEP: 'KEEP';
    KEY: 'KEY';
    KEYS: 'KEYS';

    LABEL: 'LABEL';
    LANGUAGE: 'LANGUAGE';
    LARGE: 'LARGE';
    LAST: 'LAST';
    LEAKPROOF: 'LEAKPROOF';
    LEVEL: 'LEVEL';
    LISTEN: 'LISTEN';
    LOAD: 'LOAD';
    LOCAL: 'LOCAL';
    LOCATION: 'LOCATION';
    LOCK: 'LOCK';
    LOCKED: 'LOCKED';
    LOGGED: 'LOGGED';

    MAPPING: 'MAPPING';
    MATCH: 'MATCH';
    MATCHED: 'MATCHED';
    MATERIALIZED: 'MATERIALIZED';
    MAXVALUE: 'MAXVALUE';
    MERGE: 'MERGE';
    METHOD: 'METHOD';
    MINUTE: 'MINUTE';
    MINVALUE: 'MINVALUE';
    MODE: 'MODE';
    MONTH: 'MONTH';
    MOVE: 'MOVE';

    NAME: 'NAME';
    NAMES: 'NAMES';
    NESTED: 'NESTED';
    NEW: 'NEW';
    NEXT: 'NEXT';
    NFC: 'NFC';
    NFD: 'NFD';
    NFKC: 'NFKC';
    NFKD: 'NFKD';
    NO: 'NO';
    NORMALIZED: 'NORMALIZED';
    NOTHING: 'NOTHING';
    NOTIFY: 'NOTIFY';
    NOWAIT: 'NOWAIT';
    NULLS: 'NULLS';

    OBJECT: 'OBJECT';
    OF: 'OF';
    OFF: 'OFF';
    OIDS: 'OIDS';
    OLD: 'OLD';
    OMIT: 'OMIT';
    OPERATOR: 'OPERATOR';
    OPTION: 'OPTION';
    OPTIONS: 'OPTIONS';
    ORDINALITY: 'ORDINALITY';
    OTHERS: 'OTHERS';
    OVER: 'OVER';
    OVERRIDING: 'OVERRIDING';
    OWNED: 'OWNED';
    OWNER: 'OWNER';

    PARALLEL: 'PARALLEL';
    PARAMETER: 'PARAMETER';
    PARSER: 'PARSER';
    PARTIAL: 'PARTIAL';
    PARTITION: 'PARTITION';
    PASSING: 'PASSING';
    PASSWORD: 'PASSWORD';
    PATH: 'PATH';
    PLAN: 'PLAN';
    PLANS: 'PLANS';
    POLICY: 'POLICY';
    PRECEDING: 'PRECEDING';
    PREPARE: 'PREPARE';
    PREPARED: 'PREPARED';
    PRESERVE: 'PRESERVE';
    PRIOR: 'PRIOR';
    PRIVILEGES: 'PRIVILEGES';
    PROCEDURAL: 'PROCEDURAL';
    PROCEDURE: 'PROCEDURE';
    PROCEDURES: 'PROCEDURES';
    PROGRAM: 'PROGRAM';
    PUBLICATION: 'PUBLICATION';

    QUOTE: 'QUOTE';
    QUOTES: 'QUOTES';

    RANGE: 'RANGE';
    READ: 'READ';
    REASSIGN: 'REASSIGN';
    RECHECK: 'RECHECK';
    RECURSIVE: 'RECURSIVE';
    REF: 'REF';
    REFERENCING: 'REFERENCING';
    REFRESH: 'REFRESH';
    REINDEX: 'REINDEX';
    RELATIVE: 'RELATIVE';
    RELEASE: 'RELEASE';
    RENAME: 'RENAME';
    REPEATABLE: 'REPEATABLE';
    REPLACE: 'REPLACE';
    REPLICA: 'REPLICA';
    RESET: 'RESET';
    RESTART: 'RESTART';
    RESTRICT: 'RESTRICT';
    RETURN: 'RETURN';
    RETURNS: 'RETURNS';
    REVOKE: 'REVOKE';
    ROLE: 'ROLE';
    ROLLBACK: 'ROLLBACK';
    ROLLUP: 'ROLLUP';
    ROUTINE: 'ROUTINE';
    ROUTINES: 'ROUTINES';
    ROWS: 'ROWS';
    RULE: 'RULE';

    SAVEPOINT: 'SAVEPOINT';
    SCALAR: 'SCALAR';
    SCHEMA: 'SCHEMA';
    SCHEMAS: 'SCHEMAS';
    SCROLL: 'SCROLL';
    SEARCH: 'SEARCH';
    SECOND: 'SECOND';
    SECURITY: 'SECURITY';
    SEQUENCE: 'SEQUENCE';
    SEQUENCES: 'SEQUENCES';
    SERIALIZABLE: 'SERIALIZABLE';
    SERVER: 'SERVER';
    SESSION: 'SESSION';
    SET: 'SET';
    SETS: 'SETS';
    SHARE: 'SHARE';
    SHOW: 'SHOW';
    SIMPLE: 'SIMPLE';
    // SKIP is reserved by ANTLR
    SKIP_: 'SKIP';
    SNAPSHOT: 'SNAPSHOT';
    SOURCE: 'SOURCE';
    SQL: 'SQL';
    STABLE: 'STABLE';
    STANDALONE: 'STANDALONE';
    START: 'START';
    STATEMENT: 'STATEMENT';
    STATISTICS: 'STATISTICS';
    STDIN: 'STDIN';
    STDOUT: 'STDOUT';
    STORAGE: 'STORAGE';
    STORED: 'STORED';
    STRICT: 'STRICT';
    STRING: 'STRING';
    STRIP: 'STRIP';
    SUBSCRIPTION: 'SUBSCRIPTION';
    SUPPORT: 'SUPPORT';
    SYSID: 'SYSID';
    SYSTEM: 'SYSTEM';

    TABLES: 'TABLES';
    TABLESPACE: 'TABLESPACE';
    TARGET: 'TARGET';
    TEMP: 'TEMP';
    TEMPLATE: 'TEMPLATE';
    TEMPORARY: 'TEMPORARY';
    TEXT: 'TEXT';
    TIES: 'TIES';
    TRANSACTION: 'TRANSACTION';
    TRANSFORM: 'TRANSFORM';
    TRIGGER: 'TRIGGER';
    TRUNCATE: 'TRUNCATE';
    TRUSTED: 'TRUSTED';
    TYPE: 'TYPE';
    TYPES: 'TYPES';

    UESCAPE: 'UESCAPE';
    UNBOUNDED: 'UNBOUNDED';
    UNCOMMITTED: 'UNCOMMITTED';
    UNCONDITIONAL: 'UNCONDITIONAL';
    UNENCRYPTED: 'UNENCRYPTED';
    UNKNOWN: 'UNKNOWN';
    UNLISTEN: 'UNLISTEN';
    UNLOGGED: 'UNLOGGED';
    UNTIL: 'UNTIL';
    UPDATE: 'UPDATE';

    VACUUM: 'VACUUM';
    VALID: 'VALID';
    VALIDATE: 'VALIDATE';
    VALIDATOR: 'VALIDATOR';
    VALUE: 'VALUE';
    VARYING: 'VARYING';
    VERSION: 'VERSION';
    VIEW: 'VIEW';
    VIEWS: 'VIEWS';
    VOLATILE: 'VOLATILE';

    WHITESPACE: 'WHITESPACE';
    WITHIN: 'WITHIN';
    WITHOUT: 'WITHOUT';
    WORK: 'WORK';
    WRAPPER: 'WRAPPER';
    WRITE: 'WRITE';

    XML: 'XML';

    YEAR: 'YEAR';
    YES: 'YES';

    ZONE: 'ZONE';

    /*
    ==================================================
    COL_NAME_KEYWORD
    ==================================================
    */

    BETWEEN: 'BETWEEN';
    BIGINT: 'BIGINT';
    BIT: 'BIT';
    BOOLEAN: 'BOOLEAN';

    CHAR: 'CHAR';
    CHARACTER: 'CHARACTER';
    COALESCE: 'COALESCE';

    DEC: 'DEC';
    DECIMAL: 'DECIMAL';

    EXISTS: 'EXISTS';
    EXTRACT: 'EXTRACT';

    FLOAT: 'FLOAT';

    GREATEST: 'GREATEST';
    GROUPING: 'GROUPING';

    INOUT: 'INOUT';
    INT: 'INT';
    INTEGER: 'INTEGER';
    INTERVAL: 'INTERVAL';

    JSON_ARRAY: 'JSON_ARRAY';
    JSON_ARRAYAGG: 'JSON_ARRAYAGG';
    JSON_EXISTS: 'JSON_EXISTS';
    JSON_OBJECT: 'JSON_OBJECT';
    JSON_OBJECTAGG: 'JSON_OBJECTAGG';
    JSON_QUERY: 'JSON_QUERY';
    JSON_SCALAR: 'JSON_SCALAR';
    JSON_SERIALIZE: 'JSON_SERIALIZE';
    JSON_TABLE: 'JSON_TABLE';
    JSON_VALUE: 'JSON_VALUE';

    LEAST: 'LEAST';

    MERGE_ACTION: 'MERGE_ACTION';

    NATIONAL: 'NATIONAL';
    NCHAR: 'NCHAR';
    NONE: 'NONE';
    NORMALIZE: 'NORMALIZE';
    NULLIF: 'NULLIF';
    NUMERIC: 'NUMERIC';

    OUT: 'OUT';
    OVERLAY: 'OVERLAY';

    POSITION: 'POSITION';
    PRECISION: 'PRECISION';

    REAL: 'REAL';
    ROW: 'ROW';

    SETOF: 'SETOF';
    SMALLINT: 'SMALLINT';
    SUBSTRING: 'SUBSTRING';

    TIME: 'TIME';
    TIMESTAMP: 'TIMESTAMP';
    TREAT: 'TREAT';
    TRIM: 'TRIM';

    VALUES: 'VALUES';
    VARCHAR: 'VARCHAR';

    XMLATTRIBUTES: 'XMLATTRIBUTES';
    XMLCONCAT: 'XMLCONCAT';
    XMLELEMENT: 'XMLELEMENT';
    XMLEXISTS: 'XMLEXISTS';
    XMLFOREST: 'XMLFOREST';
    XMLNAMESPACES: 'XMLNAMESPACES';
    XMLPARSE: 'XMLPARSE';
    XMLPI: 'XMLPI';
    XMLROOT: 'XMLROOT';
    XMLSERIALIZE: 'XMLSERIALIZE';
    XMLTABLE: 'XMLTABLE';

    /*
    ==================================================
    TYPE_FUNC_NAME_KEYWORD
    ==================================================
    */

    AUTHORIZATION: 'AUTHORIZATION';

    BINARY: 'BINARY';

    COLLATION: 'COLLATION';
    CONCURRENTLY: 'CONCURRENTLY';
    CROSS: 'CROSS';
    CURRENT_SCHEMA: 'CURRENT_SCHEMA';

    FREEZE: 'FREEZE';
    FULL: 'FULL';

    ILIKE: 'ILIKE';
    INNER: 'INNER';
    IS: 'IS';
    ISNULL: 'ISNULL';

    JOIN: 'JOIN';

    LEFT: 'LEFT';
    LIKE: 'LIKE';

    NATURAL: 'NATURAL';
    NOTNULL: 'NOTNULL';

    OUTER: 'OUTER';
    OVERLAPS: 'OVERLAPS';

    RIGHT: 'RIGHT';

    SIMILAR: 'SIMILAR';

    TABLESAMPLE: 'TABLESAMPLE';

    VERBOSE: 'VERBOSE';

    /*
    ==================================================
    RESERVED_KEYWORD
    ==================================================
    */

    ALL: 'ALL';   // first RESERVED_KEYWORD, sync with AntlrUtils.normalizeWhitespaceUnquoted
    ANALYSE: 'ANALYSE';
    ANALYZE: 'ANALYZE';
    AND: 'AND';
    ANY: 'ANY';
    ARRAY: 'ARRAY';
    AS: 'AS';
    ASC: 'ASC';
    ASYMMETRIC: 'ASYMMETRIC';

    BOTH: 'BOTH';

    CASE: 'CASE';
    CAST: 'CAST';
    CHECK: 'CHECK';
    COLLATE: 'COLLATE';
    COLUMN: 'COLUMN';
    CONSTRAINT: 'CONSTRAINT';
    CREATE: 'CREATE';
    CURRENT_CATALOG: 'CURRENT_CATALOG';
    CURRENT_DATE: 'CURRENT_DATE';
    CURRENT_ROLE: 'CURRENT_ROLE';
    CURRENT_TIME: 'CURRENT_TIME';
    CURRENT_TIMESTAMP: 'CURRENT_TIMESTAMP';
    CURRENT_USER: 'CURRENT_USER';

    DEFAULT: 'DEFAULT';
    DEFERRABLE: 'DEFERRABLE';
    DESC: 'DESC';
    DISTINCT: 'DISTINCT';
    DO: 'DO';

    ELSE: 'ELSE';
    END: 'END';
    EXCEPT: 'EXCEPT';

    FALSE: 'FALSE';
    FETCH: 'FETCH';
    FOR: 'FOR';
    FOREIGN: 'FOREIGN';
    FROM: 'FROM';

    GRANT: 'GRANT';
    GROUP: 'GROUP';

    HAVING: 'HAVING';

    IN: 'IN';
    INITIALLY: 'INITIALLY';
    INTERSECT: 'INTERSECT';
    INTO: 'INTO';

    LATERAL: 'LATERAL';
    LEADING: 'LEADING';
    LIMIT: 'LIMIT';
    LOCALTIME: 'LOCALTIME';
    LOCALTIMESTAMP: 'LOCALTIMESTAMP';

    NOT: 'NOT';
    NULL: 'NULL';

    OFFSET: 'OFFSET';
    ON: 'ON';
    ONLY: 'ONLY';
    OR: 'OR';
    ORDER: 'ORDER';

    PLACING: 'PLACING';
    PRIMARY: 'PRIMARY';

    REFERENCES: 'REFERENCES';
    RETURNING: 'RETURNING';

    SELECT: 'SELECT';
    SESSION_USER: 'SESSION_USER';
    SOME: 'SOME';
    SYMMETRIC: 'SYMMETRIC';
    SYSTEM_USER: 'SYSTEM_USER';

    TABLE: 'TABLE';
    THEN: 'THEN';
    TO: 'TO';
    TRAILING: 'TRAILING';
    TRUE: 'TRUE';

    UNION: 'UNION';
    UNIQUE: 'UNIQUE';
    USER: 'USER';
    USING: 'USING';

    VARIADIC: 'VARIADIC';

    WHEN: 'WHEN';
    WHERE: 'WHERE';
    WINDOW: 'WINDOW';
    WITH: 'WITH';   // last RESERVED_KEYWORD, sync with AntlrUtils.normalizeWhitespaceUnquoted

    /*
     * Other tokens.
     * Some sql words/data types are not keywords but we need a token to be able to parse them.
     *
     * Manually added word-tokens must also be manually added to the 
     * tokens_nonkeyword parser rule SQLParser.g4. 
     */

    ALIGNMENT: 'ALIGNMENT';
    ALLOW_CONNECTIONS: 'ALLOW_CONNECTIONS';

    BASETYPE: 'BASETYPE';
    BLOCKSIZE: 'BLOCKSIZE';
    BUFFERS: 'BUFFERS';
    BUFFER_USAGE_LIMIT: 'BUFFER_USAGE_LIMIT';
    BYPASSRLS: 'BYPASSRLS';

    CANONICAL: 'CANONICAL';
    CATEGORY: 'CATEGORY';
    COLLATABLE: 'COLLATABLE';
    COLLATION_VERSION: 'COLLATION_VERSION';
    COMBINEFUNC: 'COMBINEFUNC';
    COMMUTATOR: 'COMMUTATOR';
    COMPRESSLEVEL: 'COMPRESSLEVEL';
    COMPRESSTYPE: 'COMPRESSTYPE';
    CONNECT: 'CONNECT';
    CONTAINS: 'CONTAINS';
    COORDINATOR : 'COORDINATOR';
    COSTS: 'COSTS';
    CREATEDB: 'CREATEDB';
    CREATEEXTTABLE: 'CREATEEXTTABLE';
    CREATEROLE: 'CREATEROLE';
    CREATEUSER: 'CREATEUSER';

    DESERIALFUNC: 'DESERIALFUNC';
    DETERMINISTIC: 'DETERMINISTIC';
    DISABLE_PAGE_SKIPPING: 'DISABLE_PAGE_SKIPPING';
    DISTRIBUTED: 'DISTRIBUTED';

    ELEMENT: 'ELEMENT';
    ERRORS: 'ERRORS';
    EVERY: 'EVERY';
    EXCHANGE: 'EXCHANGE';
    EXTENDED: 'EXTENDED';

    FIELDS: 'FIELDS';
    FILL: 'FILL';
    FINALFUNC: 'FINALFUNC';
    FINALFUNC_EXTRA: 'FINALFUNC_EXTRA';
    FINALFUNC_MODIFY: 'FINALFUNC_MODIFY';
    FORCE_NOT_NULL: 'FORCE_NOT_NULL';
    FORCE_NULL: 'FORCE_NULL';
    FORCE_QUOTE: 'FORCE_QUOTE';
    FORMATTER: 'FORMATTER';

    GETTOKEN: 'GETTOKEN';
    GENERIC_PLAN: 'GENERIC_PLAN';

    HASH: 'HASH';
    HASHES: 'HASHES';
    HEADLINE: 'HEADLINE';
    HOST: 'HOST';
    HYPOTHETICAL: 'HYPOTHETICAL';

    ICU_LOCALE: 'ICU_LOCALE';
    ICU_RULES : 'ICU_RULES';
    IGNORE : 'IGNORE';
    INCLUSIVE: 'INCLUSIVE';
    INDEX_CLEANUP: 'INDEX_CLEANUP';
    INIT: 'INIT';
    INITCOND: 'INITCOND';
    INITPLAN: 'INITPLAN';
    INTERNALLENGTH: 'INTERNALLENGTH';
    IS_TEMPLATE: 'IS_TEMPLATE';

    LC_COLLATE: 'LC_COLLATE';
    LC_CTYPE: 'LC_CTYPE';
    LEFTARG: 'LEFTARG';
    LEXIZE: 'LEXIZE';
    LEXTYPES: 'LEXTYPES';
    LIST: 'LIST';
    LOCALE: 'LOCALE';
    LOCALE_PROVIDER: 'LOCALE_PROVIDER';
    LOG_VERBOSITY: 'LOG_VERBOSITY';
    LOGIN: 'LOGIN';

    MAIN: 'MAIN';
    MAINTAIN: 'MAINTAIN';
    MASTER: 'MASTER';
    MEMORY: 'MEMORY';
    MERGES: 'MERGES';
    MFINALFUNC: 'MFINALFUNC';
    MFINALFUNC_EXTRA: 'MFINALFUNC_EXTRA';
    MFINALFUNC_MODIFY: 'MFINALFUNC_MODIFY';
    MINITCOND: 'MINITCOND';
    MINVFUNC: 'MINVFUNC';
    MISSING: 'MISSING';
    MODIFIES: 'MODIFIES';
    MODULUS: 'MODULUS';
    MSFUNC: 'MSFUNC';
    MSSPACE: 'MSSPACE';
    MSTYPE: 'MSTYPE';
    MULTIRANGE_TYPE_NAME: 'MULTIRANGE_TYPE_NAME';

    NEGATOR: 'NEGATOR';
    NEWLINE: 'NEWLINE';
    NOBYPASSRLS: 'NOBYPASSRLS';
    NOCREATEDB: 'NOCREATEDB';
    NOCREATEEXTTABLE: 'NOCREATEEXTTABLE';
    NOCREATEROLE: 'NOCREATEROLE';
    NOCREATEUSER: 'NOCREATEUSER';
    NOINHERIT: 'NOINHERIT';
    NOLOGIN: 'NOLOGIN';
    NOREPLICATION: 'NOREPLICATION';
    NOSUPERUSER: 'NOSUPERUSER';

    OID: 'OID';
    ON_ERROR: 'ON_ERROR';
    ONLY_DATABASE_STATS: 'ONLY_DATABASE_STATS';
    OUTPUT: 'OUTPUT';

    PASSEDBYVALUE: 'PASSEDBYVALUE';
    PERCENT: 'PERCENT';
    PERMISSIVE: 'PERMISSIVE';
    PERSISTENTLY: 'PERSISTENTLY';
    PLAIN: 'PLAIN';
    PREFERRED: 'PREFERRED';
    PROCESS_MAIN : 'PROCESS_MAIN';
    PROTOCOL: 'PROTOCOL';
    PROVIDER: 'PROVIDER';

    RANDOMLY: 'RANDOMLY';
    RANK: 'RANK';
    READ_ONLY: 'READ_ONLY';
    READ_WRITE: 'READ_WRITE';
    READABLE: 'READABLE';
    RECEIVE: 'RECEIVE';
    REJECT: 'REJECT';
    REMAINDER: 'REMAINDER';
    REORGANIZE: 'REORGANIZE';
    REPLICATED: 'REPLICATED';
    REPLICATION: 'REPLICATION';
    RESTRICTED: 'RESTRICTED';
    RESTRICTIVE: 'RESTRICTIVE';
    RIGHTARG: 'RIGHTARG';
    RULES: 'RULES';

    SAFE: 'SAFE';
    SEGMENTS: 'SEGMENTS';
    SEGMENT: 'SEGMENT';
    SEND: 'SEND';
    SERIALIZE: 'SERIALIZE';
    SERIALFUNC: 'SERIALFUNC';
    SETTINGS: 'SETTINGS';
    SFUNC: 'SFUNC';
    SHAREABLE: 'SHAREABLE';
    SKIP_LOCKED: 'SKIP_LOCKED';
    SKIP_DATABASE_STATS: 'SKIP_DATABASE_STATS';
    SORTOP: 'SORTOP';
    SPLIT: 'SPLIT';
    SSPACE: 'SSPACE';
    STRATEGY: 'STRATEGY';
    STOP : 'STOP';
    STYPE: 'STYPE';
    SUBPARTITION: 'SUBPARTITION';
    SUBTYPE_DIFF: 'SUBTYPE_DIFF';
    SUBTYPE_OPCLASS: 'SUBTYPE_OPCLASS';
    SUBTYPE: 'SUBTYPE';
    SUBSCRIPT: 'SUBSCRIPT';
    SUMMARY: 'SUMMARY';
    SUPERUSER: 'SUPERUSER';

    TIMING: 'TIMING';
    TYPMOD_IN: 'TYPMOD_IN';
    TYPMOD_OUT: 'TYPMOD_OUT';

    UNSAFE: 'UNSAFE';
    USAGE: 'USAGE';

    VALIDATION: 'VALIDATION';
    VARIABLE: 'VARIABLE';

    WAL: 'WAL';
    WEB: 'WEB';
    WRITABLE: 'WRITABLE';

    YAML: 'YAML';

    // plpgsql tokens

    ALIAS: 'ALIAS';
    ASSERT: 'ASSERT';

    CONSTANT: 'CONSTANT';

    DATATYPE: 'DATATYPE';
    DEBUG: 'DEBUG';
    DETAIL: 'DETAIL';
    DIAGNOSTICS: 'DIAGNOSTICS';

    ELSEIF: 'ELSEIF';
    ELSIF: 'ELSIF';
    ERRCODE: 'ERRCODE';
    EXIT: 'EXIT';
    EXCEPTION: 'EXCEPTION';

    FOREACH: 'FOREACH';

    GET: 'GET';

    HINT: 'HINT';

    INFO: 'INFO';

    LOG: 'LOG';
    LOOP: 'LOOP';

    MESSAGE: 'MESSAGE';

    NOTICE: 'NOTICE';

    OPEN: 'OPEN';

    PERFORM: 'PERFORM';

    QUERY: 'QUERY';

    RAISE: 'RAISE';
    READS: 'READS';
    RECORD: 'RECORD';
    REVERSE: 'REVERSE';
    ROWTYPE: 'ROWTYPE';

    SLICE: 'SLICE';
    SQLSTATE: 'SQLSTATE';
    STACKED: 'STACKED';

    WARNING: 'WARNING';
    WHILE: 'WHILE';     // last identifier rule, sync with CustomSQLAntlrErrorStrategy & AntlrUtils

// Operators

// Cast Operator
CAST_EXPRESSION : ':' ':';   // first operator rule, sync with CustomSQLAntlrErrorStrategy

EQUAL : '=';
COLON :  ':';
SEMI_COLON :  ';';
COMMA : ',';
NOT_EQUAL : '<>' | '!=';
LTH : '<';
LEQ : '<=';
GTH : '>';
GEQ : '>=';
LEFT_PAREN :  '(';
RIGHT_PAREN : ')';
PLUS  : '+';
MINUS : '-';
MULTIPLY: '*';
DIVIDE  : '/';
MODULAR : '%';
EXP : '^';

DOT : '.';
QUOTE_CHAR : '\'';
DOUBLE_QUOTE : '"';
DOLLAR : '$';
LEFT_BRACKET : '[';
RIGHT_BRACKET : ']';

EQUAL_GTH : '=>';
COLON_EQUAL : ':=';

LESS_LESS : '<<';
GREATER_GREATER : '>>';
DOUBLE_DOT: '..';
HASH_SIGN: '#';              // last operator rule, sync with CustomSQLAntlrErrorStrategy

BlockComment: '/*' (BlockComment |.)*? '*/' -> channel(HIDDEN);
LineComment: '--' ~[\r\n]* -> channel(HIDDEN);

// must follow all explicitly defined operators and comments
// so that they are matched first
OP_CHARS
    // may not end with + or -
    : OperatorBasic+ OperatorBasicEnd
    // may end with any character but must include at least one of OperatorSpecial
    | (OperatorBasic | OperatorSpecial)* OperatorSpecial (OperatorBasic | OperatorSpecial)*
    ;

fragment
OperatorBasic
    : [+*<>=]
    // check so that comment start sequences are not matched by this
    | '-' {_input.LA(1) != '-'}?
    | '/' {_input.LA(1) != '*'}?;
fragment OperatorBasicEnd: [*/<>=];
fragment OperatorSpecial: [~!@#%^&|`?];

Integer: Digit+;

fragment Digit: '0'..'9';

Numeric
    // fail double dots into a separate token
    // otherwise 1..10 would lex into 2 numbers
    :   Digit+ '.' {_input.LA(1) != '.'}?
    |   Digit+ '.' Digit+ EXPONENT?
    |   Digit+ '.' EXPONENT
    |   '.' Digit+ EXPONENT?
    |   Digit+ EXPONENT
    ;

DOLLAR_NUMBER: DOLLAR Integer;

/*
===============================================================================
 Identifiers
===============================================================================
*/

Identifier
    : IdentifierStartChar IdentifierChar*
    // always lowercase unquoted ids
        { setText(getText().toLowerCase(java.util.Locale.ROOT)); }
    ;
fragment
IdentifierStartChar options {
       caseInsensitive = false;
  } : // these are the valid identifier start characters below 0x7F
    [a-zA-Z_]
    | // these are the valid characters from 0x80 to 0xFF
    [\u00AA\u00B5\u00BA\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u00FF]
    | // these are the letters above 0xFF which only need a single UTF-16 code unit
    [\u0100-\uD7FF\uE000-\uFFFF] {Character.isLetter((char)_input.LA(-1))}?
    | // letters which require multiple UTF-16 code units
    [\uD800-\uDBFF] [\uDC00-\uDFFF] {Character.isLetter(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

fragment IdentifierChar: StrictIdentifierChar | '$' ;
fragment StrictIdentifierChar: IdentifierStartChar | [0-9];

UnicodeQuotedIdentifier: 'U&' QuotedIdentifier;

/* Quoted Identifiers
*
* These are divided into four separate tokens, allowing distinction of valid quoted identifiers from invalid quoted
* identifiers without sacrificing the ability of the lexer to reliably recover from lexical errors in the input.
*/
QuotedIdentifier
    : UnterminatedQuotedIdentifier '"'
    // unquote so that we may always call getText() and not worry about quotes
        {
            String __tx = getText();
            setText(__tx.substring(1, __tx.length() - 1).replace("\"\"", "\""));
        }
    ;
// This is a quoted identifier which only contains valid characters but is not terminated
fragment UnterminatedQuotedIdentifier : '"' ( '""' | ~[\u0000"] )*;
/*
===============================================================================
 Literal
===============================================================================
*/

StringConstant: [ENXB]? SingleString (StringJoiner SingleString)*;

UnicodeEscapeStringConstant: 'U&' StringConstant;

fragment SingleString : QUOTE_CHAR ( ~'\'' | '\'\'')* QUOTE_CHAR;
fragment StringJoiner: ((Space | Tab | WhiteSpace | LineComment)* NewLine)+ (Space | Tab | WhiteSpace)*;

// Some Unicode Character Ranges
fragment Control_Characters                  :   '\u0001' .. '\u0008' | '\u000B' | '\u000C' | '\u000E' .. '\u001F';
fragment Extended_Control_Characters         :   '\u0080' .. '\u009F';

fragment
EXPONENT : 'E' ('+'|'-')? Digit+ ;

// Dollar-quoted String Constants (§4.1.2.4)
BeginDollarStringConstant
    : '$' Tag? '$' {_tags.push(getText());} -> pushMode(DollarQuotedStringMode)
    ;

fragment
Tag
    : IdentifierStartChar StrictIdentifierChar*
    ;

/*
===============================================================================
 Whitespace Tokens
===============================================================================
*/

Space
  : ' ' -> channel(HIDDEN)
  ;

WhiteSpace
  : ( Control_Characters  | Extended_Control_Characters )+ -> channel(HIDDEN)
  ;

NewLine
    : ('\u000D' | '\u000D'? '\u000A') -> channel(HIDDEN)
    ;

Tab
    : '\u0009' -> channel(HIDDEN)
    ;

BOM: '\ufeff';

BAD
  : .
  ;

mode DollarQuotedStringMode;
Text_between_Dollar
   : ~'$'+
    | // this alternative improves the efficiency of handling $ characters within a dollar-quoted string which are
    // not part of the ending tag.
    '$' ~'$'*
    ;

EndDollarStringConstant
    : '$' Tag? '$' {getText().equals(_tags.peek())}? {_tags.pop();} -> popMode
    ;
