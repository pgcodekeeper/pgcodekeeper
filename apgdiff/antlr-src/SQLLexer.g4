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

@header {
    package cz.startnet.utils.pgdiff.parsers.antlr;
    import java.util.ArrayDeque;
    import java.util.Deque;
}

@members {
/* This field stores the tags which are used to detect the end of a dollar-quoted string literal.
*/
private final Deque<String> _tags = new ArrayDeque<String>();
}


    /*
    ===============================================================================
      Reserved Keywords
    ===============================================================================
    */

    ALL: [aA] [lL][lL];
    ANALYSE: [aA] [nN] [aA] [lL] [yY] [sS] [eE];
    ANALYZE: [aA] [nN] [aA] [lL] [yY] [zZ] [eE];
    AND: [aA] [nN] [dD];
    ANY: [aA] [nN] [yY];
    ARRAY: [aA] [rR] [rR] [aA] [yY];
    AS: [aA] [sS];
    ASC: [aA] [sS] [cC];
    ASYMMETRIC: [aA] [sS] [yY] [mM] [mM] [eE] [tT] [rR] [iI] [cC];
    AUTHORIZATION: [aA] [uU] [tT] [hH] [oO] [rR] [iI] [zZ] [aA] [tT] [iI] [oO]  [nN];
    
    BINARY: [bB] [iI] [nN] [aA] [rR] [yY];
    BOTH: [bB] [oO] [tT] [hH];
    
    CASE: [cC] [aA] [sS] [eE];
    CAST: [cC] [aA] [sS] [tT];
    CHECK: [cC] [hH] [eE] [cC] [kK];
    COLLATE: [cC] [oO] [lL] [lL] [aA] [tT] [eE];
    COLLATION: [cC] [oO] [lL] [lL] [aA] [tT] [iI] [oO]  [nN];
    COLUMN: [cC] [oO] [lL] [uU] [mM]  [nN];
    CONCURRENTLY: [cC] [oO] [nN] [cC] [uU] [rR] [rR] [eE] [nN] [tT] [lL] [yY];
    CONSTRAINT: [cC] [oO] [nN] [sS] [tT] [rR] [aA] [iI] [nN] [tT];
    CREATE: [cC] [rR] [eE] [aA] [tT] [eE];
    CROSS: [cC] [rR] [oO] [sS] [sS];
    CURRENT_CATALOG: [cC] [uU] [rR] [rR] [eE] [nN] [tT] UNDERLINE [cC] [aA] [tT] [aA] [lL] [oO] [gG];
    CURRENT_DATE: [cC] [uU] [rR] [rR] [eE] [nN] [tT] UNDERLINE [dD] [aA] [tT] [eE];
    CURRENT_ROLE: [cC] [uU] [rR] [rR] [eE] [nN] [tT] UNDERLINE [rR] [oO] [lL] [eE];
    CURRENT_SCHEMA: [cC] [uU] [rR] [rR] [eE] [nN] [tT] UNDERLINE [sS] [cC] [hH] [eE] [mM] [aA];
    CURRENT_TIME: [cC] [uU] [rR] [rR] [eE] [nN] [tT] UNDERLINE [tT] [iI] [mM] [eE];
    CURRENT_TIMESTAMP: [cC] [uU] [rR] [rR] [eE] [nN] [tT] UNDERLINE [tT] [iI] [mM] [eE] [sS] [tT] [aA] [mM] [pP];
    CURRENT_USER: [cC] [uU] [rR] [rR] [eE] [nN] [tT] UNDERLINE [uU] [sS] [eE] [rR];
    
    DEFAULT: [dD] [eE] [fF] [aA] [uU] [lL] [tT];
    DEFERRABLE: [dD] [eE] [fF] [eE] [rR] [rR] [aA] [bB] [lL] [eE];
    DESC: [dD] [eE] [sS] [cC];
    DISTINCT: [dD] [iI] [sS] [tT] [iI] [nN] [cC] [tT];
    DO: [dD] [oO];
    
    ELSE: [eE] [lL] [sS] [eE];
    END: [eE] [nN] [dD];
    EXCEPT: [eE] [xX] [cC] [eE] [pP] [tT];
    
    FALSE: [fF] [aA] [lL] [sS] [eE];
    FETCH: [fF] [eE] [tT] [cC] [hH];
    FOR: [fF] [oO] [rR];
    FOREIGN: [fF] [oO] [rR] [eE] [iI] [gG]  [nN];
    FREEZE: [fF] [rR] [eE] [eE] [zZ] [eE];
    FROM: [fF] [rR] [oO] [mM];
    FULL: [fF] [uU] [lL] [lL];
    
    GRANT: [gG] [rR] [aA] [nN] [tT];
    GROUP: [gG] [rR] [oO] [uU] [pP];
    
    HAVING: [hH] [aA] [vV] [iI] [nN] [gG];
    
    ILIKE: [iI] [lL] [iI] [kK] [eE];
    IN: [iI]  [nN];
    INITIALLY: [iI] [nN] [iI] [tT] [iI] [aA] [lL] [lL] [yY];
    INNER: [iI] [nN] [nN] [eE] [rR];
    INTERSECT: [iI] [nN] [tT] [eE] [rR] [sS] [eE] [cC] [tT];
    INTO: [iI] [nN] [tT] [oO];
    IS: [iI] [sS];
    ISNULL: [iI] [sS] [nN] [uU] [lL] [lL];
    
    JOIN: [jJ] [oO] [iI]  [nN];
    
    LATERAL: [lL] [aA] [tT] [eE] [rR] [aA] [lL];
    LEADING: [lL] [eE] [aA] [dD] [iI] [nN] [gG];
    LEFT: [lL] [eE] [fF] [tT];
    LIKE: [lL] [iI] [kK] [eE];
    LIMIT: [lL] [iI] [mM] [iI] [tT];
    LOCALTIME: [lL] [oO] [cC] [aA] [lL] [tT] [iI] [mM] [eE];
    LOCALTIMESTAMP: [lL] [oO] [cC] [aA] [lL] [tT] [iI] [mM] [eE] [sS] [tT] [aA] [mM] [pP];
    
    NATURAL: [nN] [aA] [tT] [uU] [rR] [aA] [lL];
    NOT: [nN] [oO] [tT];
    NOTNULL: [nN] [oO] [tT] [nN] [uU] [lL] [lL];
    NULL: [nN] [uU] [lL] [lL];
    
    OFFSET: [oO] [fF] [fF] [sS] [eE] [tT];
    ON: [oO]  [nN];
    ONLY: [oO] [nN] [lL] [yY];
    OR: [oO] [rR];
    ORDER: [oO] [rR] [dD] [eE] [rR];
    OUTER: [oO] [uU] [tT] [eE] [rR];
    OVER: [oO] [vV] [eE] [rR];
    OVERLAPS: [oO] [vV] [eE] [rR] [lL] [aA] [pP] [sS];
    
    PLACING: [pP] [lL] [aA] [cC] [iI] [nN] [gG];
    PRIMARY: [pP] [rR] [iI] [mM] [aA] [rR] [yY];
    
    REFERENCES: [rR] [eE] [fF] [eE] [rR] [eE] [nN] [cC] [eE] [sS];
    RETURNING: [rR] [eE] [tT] [uU] [rR] [nN] [iI] [nN] [gG];
    RIGHT: [rR] [iI] [gG] [hH] [tT];
    
    SELECT: [sS] [eE] [lL] [eE] [cC] [tT];
    SESSION_USER: [sS] [eE] [sS] [sS] [iI] [oO] [nN] UNDERLINE [uU] [sS] [eE] [rR];
    SIMILAR: [sS] [iI] [mM] [iI] [lL] [aA] [rR];
    SOME: [sS] [oO] [mM] [eE];
    SYMMETRIC: [sS] [yY] [mM] [mM] [eE] [tT] [rR] [iI] [cC];
    
    TABLE: [tT] [aA] [bB] [lL] [eE];
    THEN: [tT] [hH] [eE]  [nN];
    TO: [tT] [oO];
    TRAILING: [tT] [rR] [aA] [iI] [lL] [iI] [nN] [gG];
    TRUE: [tT] [rR] [uU] [eE];
    
    UNION: [uU] [nN] [iI] [oO]  [nN];
    UNIQUE: [uU] [nN] [iI] [qQ] [uU] [eE];
    USER: [uU] [sS] [eE] [rR];
    USING: [uU] [sS] [iI] [nN] [gG];
    
    VARIADIC: [vV] [aA] [rR] [iI] [aA] [dD] [iI] [cC];
    VERBOSE: [vV] [eE] [rR] [bB] [oO] [sS] [eE];
    
    WHEN: [wW] [hH] [eE]  [nN];
    WHERE: [wW] [hH] [eE] [rR] [eE];
    WINDOW: [wW] [iI] [nN] [dD] [oO] [wW];
    WITH: [wW] [iI] [tT] [hH];
    
    /*
    ===============================================================================
      Non-reserved Keywords
    ===============================================================================
    */
    
    ABORT: [aA] [bB] [oO] [rR] [tT];
    ABSOLUTE: [aA] [bB] [sS] [oO] [lL] [uU] [tT] [eE];
    ACCESS: [aA] [cC] [cC] [eE] [sS] [sS];
    ACTION: [aA] [cC] [tT] [iI] [oO]  [nN];
    ADD: [aA] [dD] [dD];
    ADMIN: [aA] [dD] [mM] [iI]  [nN];
    AFTER: [aA] [fF] [tT] [eE] [rR];
    AGGREGATE: [aA] [gG] [gG] [rR] [eE] [gG] [aA] [tT] [eE];
    ALSO: [aA] [lL] [sS] [oO];
    ALTER: [aA] [lL] [tT] [eE] [rR];
    ALWAYS: [aA] [lL] [wW] [aA] [yY] [sS];
    ASSERTION: [aA] [sS] [sS] [eE] [rR] [tT] [iI] [oO]  [nN];
    ASSIGNMENT: [aA] [sS] [sS] [iI] [gG] [nN] [mM] [eE] [nN] [tT];
    AT: [aA] [tT];
    ATTRIBUTE: [aA] [tT] [tT] [rR] [iI] [bB] [uU] [tT] [eE];
    
    BACKWARD: [bB] [aA] [cC] [kK] [wW] [aA] [rR] [dD];
    BEFORE: [bB] [eE] [fF] [oO] [rR] [eE];
    BEGIN: [bB] [eE] [gG] [iI]  [nN];
    BETWEEN: [bB] [eE] [tT] [wW] [eE] [eE]  [nN];
    BIGINT: [bB] [iI] [gG] [iI] [nN] [tT];
    BIT: [bB] [iI] [tT];
    BOOLEAN: [bB] [oO] [oO] [lL] [eE] [aA]  [nN];
    BY: [bB] [yY];
    
    CACHE: [cC] [aA] [cC] [hH] [eE];
    CALLED: [cC] [aA] [lL] [lL] [eE] [dD];
    CASCADE: [cC] [aA] [sS] [cC] [aA] [dD] [eE];
    CASCADED: [cC] [aA] [sS] [cC] [aA] [dD] [eE] [dD];
    CATALOG: [cC] [aA] [tT] [aA] [lL] [oO] [gG];
    CHAIN: [cC] [hH] [aA] [iI]  [nN];
    CHAR: [cC] [hH] [aA] [rR];
    CHARACTER: [cC] [hH] [aA] [rR] [aA] [cC] [tT] [eE] [rR];
    CHARACTERISTICS: [cC] [hH] [aA] [rR] [aA] [cC] [tT] [eE] [rR] [iI] [sS] [tT] [iI] [cC] [sS];
    CHECKPOINT: [cC] [hH] [eE] [cC] [kK] [pP] [oO] [iI] [nN] [tT];
    CLASS: [cC] [lL] [aA] [sS] [sS];
    CLOSE: [cC] [lL] [oO] [sS] [eE];
    CLUSTER: [cC] [lL] [uU] [sS] [tT] [eE] [rR];
    COALESCE: [cC] [oO] [aA] [lL] [eE] [sS] [cC] [eE];
    COMMENT: [cC] [oO] [mM] [mM] [eE] [nN] [tT];
    COMMENTS: [cC] [oO] [mM] [mM] [eE] [nN] [tT] [sS];
    COMMIT: [cC] [oO] [mM] [mM] [iI] [tT];
    COMMITTED: [cC] [oO] [mM] [mM] [iI] [tT] [tT] [eE] [dD];
    CONFIGURATION: [cC] [oO] [nN] [fF] [iI] [gG] [uU] [rR] [aA] [tT] [iI] [oO]  [nN];
    CONNECTION: [cC] [oO] [nN] [nN] [eE] [cC] [tT] [iI] [oO]  [nN];
    CONSTRAINTS: [cC] [oO] [nN] [sS] [tT] [rR] [aA] [iI] [nN] [tT] [sS];
    CONTENT: [cC] [oO] [nN] [tT] [eE] [nN] [tT];
    CONTINUE: [cC] [oO] [nN] [tT] [iI] [nN] [uU] [eE];
    CONVERSION: [cC] [oO] [nN] [vV] [eE] [rR] [sS] [iI] [oO]  [nN];
    COPY: [cC] [oO] [pP] [yY];
    COST: [cC] [oO] [sS] [tT];
    CSV: [cC] [sS] [vV];
    CURRENT: [cC] [uU] [rR] [rR] [eE] [nN] [tT];
    CURSOR: [cC] [uU] [rR] [sS] [oO] [rR];
    CYCLE: [cC] [yY] [cC] [lL] [eE];
    
    DATA: [dD] [aA] [tT] [aA];
    DATABASE: [dD] [aA] [tT] [aA] [bB] [aA] [sS] [eE];
    DAY: [dD] [aA] [yY];
    DEALLOCATE: [dD] [eE] [aA] [lL] [lL] [oO] [cC] [aA] [tT] [eE];
    DEC: [dD] [eE] [cC];
    DECIMAL: [dD] [eE] [cC] [iI] [mM] [aA] [lL];
    DECLARE: [dD] [eE] [cC] [lL] [aA] [rR] [eE];
    DEFAULTS: [dD] [eE] [fF] [aA] [uU] [lL] [tT] [sS];
    DEFERRED: [dD] [eE] [fF] [eE] [rR] [rR] [eE] [dD];
    DEFINER: [dD] [eE] [fF] [iI] [nN] [eE] [rR];
    DELETE: [dD] [eE] [lL] [eE] [tT] [eE];
    DELIMITER: [dD] [eE] [lL] [iI] [mM] [iI] [tT] [eE] [rR];
    DELIMITERS: [dD] [eE] [lL] [iI] [mM] [iI] [tT] [eE] [rR] [sS];
    DICTIONARY: [dD] [iI] [cC] [tT] [iI] [oO] [nN] [aA] [rR] [yY];
    DISABLE: [dD] [iI] [sS] [aA] [bB] [lL] [eE];
    DISCARD: [dD] [iI] [sS] [cC] [aA] [rR] [dD];
    DOCUMENT: [dD] [oO] [cC] [uU] [mM] [eE] [nN] [tT];
    DOMAIN: [dD] [oO] [mM] [aA] [iI]  [nN];
    DOUBLE: [dD] [oO] [uU] [bB] [lL] [eE];
    DROP: [dD] [rR] [oO] [pP];
    
    EACH: [eE] [aA] [cC] [hH];
    ENABLE: [eE] [nN] [aA] [bB] [lL] [eE];
    ENCODING: [eE] [nN] [cC] [oO] [dD] [iI] [nN] [gG];
    ENCRYPTED: [eE] [nN] [cC] [rR] [yY] [pP] [tT] [eE] [dD];
    END_EXEC: [eE] [nN] [dD] MINUS [eE] [xX] [eE] [cC];
    ENUM: [eE] [nN] [uU] [mM];
    ESCAPE: [eE] [sS] [cC] [aA] [pP] [eE];
    EVENT: [eE] [vV] [eE] [nN] [tT];
    EXCLUDE: [eE] [xX] [cC] [lL] [uU] [dD] [eE];
    EXCLUDING: [eE] [xX] [cC] [lL] [uU] [dD] [iI] [nN] [gG];
    EXCLUSIVE: [eE] [xX] [cC] [lL] [uU] [sS] [iI] [vV] [eE];
    EXECUTE: [eE] [xX] [eE] [cC] [uU] [tT] [eE];
    EXISTS: [eE] [xX] [iI] [sS] [tT] [sS];
    EXPLAIN: [eE] [xX] [pP] [lL] [aA] [iI]  [nN];
    EXTENSION: [eE] [xX] [tT] [eE] [nN] [sS] [iI] [oO]  [nN];
    EXTERNAL: [eE] [xX] [tT] [eE] [rR] [nN] [aA] [lL];
    EXTRACT: [eE] [xX] [tT] [rR] [aA] [cC] [tT];
    
    FAMILY: [fF] [aA] [mM] [iI] [lL] [yY];
    FIRST: [fF] [iI] [rR] [sS] [tT];
    FLOAT: [fF] [lL] [oO] [aA] [tT];
    FOLLOWING: [fF] [oO] [lL] [lL] [oO] [wW] [iI] [nN] [gG];
    FORCE: [fF] [oO] [rR] [cC] [eE];
    FORWARD: [fF] [oO] [rR] [wW] [aA] [rR] [dD];
    FUNCTION: [fF] [uU] [nN] [cC] [tT] [iI] [oO]  [nN];
    FUNCTIONS: [fF] [uU] [nN] [cC] [tT] [iI] [oO] [nN] [sS];
    
    GLOBAL: [gG] [lL] [oO] [bB] [aA] [lL];
    GRANTED: [gG] [rR] [aA] [nN] [tT] [eE] [dD];
    GREATEST: [gG] [rR] [eE] [aA] [tT] [eE] [sS] [tT];
    
    HANDLER: [hH] [aA] [nN] [dD] [lL] [eE] [rR];
    HEADER: [hH] [eE] [aA] [dD] [eE] [rR];
    HOLD: [hH] [oO] [lL] [dD];
    HOUR: [hH] [oO] [uU] [rR];
    
    IDENTITY: [iI] [dD] [eE] [nN] [tT] [iI] [tT] [yY];
    IF: [iI] [fF];
    IMMEDIATE: [iI] [mM] [mM] [eE] [dD] [iI] [aA] [tT] [eE];
    IMMUTABLE: [iI] [mM] [mM] [uU] [tT] [aA] [bB] [lL] [eE];
    IMPLICIT: [iI] [mM] [pP] [lL] [iI] [cC] [iI] [tT];
    INCLUDING: [iI] [nN] [cC] [lL] [uU] [dD] [iI] [nN] [gG];
    INCREMENT: [iI] [nN] [cC] [rR] [eE] [mM] [eE] [nN] [tT];
    INDEX: [iI] [nN] [dD] [eE] [xX];
    INDEXES: [iI] [nN] [dD] [eE] [xX] [eE] [sS];
    INHERIT: [iI] [nN] [hH] [eE] [rR] [iI] [tT];
    INHERITS: [iI] [nN] [hH] [eE] [rR] [iI] [tT] [sS];
    INLINE: [iI] [nN] [lL] [iI] [nN] [eE];
    INOUT: [iI] [nN] [oO] [uU] [tT];
    INPUT: [iI] [nN] [pP] [uU] [tT];
    INSENSITIVE: [iI] [nN] [sS] [eE] [nN] [sS] [iI] [tT] [iI] [vV] [eE];
    INSERT: [iI] [nN] [sS] [eE] [rR] [tT];
    INSTEAD: [iI] [nN] [sS] [tT] [eE] [aA] [dD];
    INT: [iI] [nN] [tT];
    INTEGER: [iI] [nN] [tT] [eE] [gG] [eE] [rR];
    INTERVAL: [iI] [nN] [tT] [eE] [rR] [vV] [aA] [lL];
    INVOKER: [iI] [nN] [vV] [oO] [kK] [eE] [rR];
    ISOLATION: [iI] [sS] [oO] [lL] [aA] [tT] [iI] [oO]  [nN];
    
    KEY: [kK] [eE] [yY];
    
    LABEL: [lL] [aA] [bB] [eE] [lL];
    LANGUAGE: [lL] [aA] [nN] [gG] [uU] [aA] [gG] [eE];
    LARGE: [lL] [aA] [rR] [gG] [eE];
    LAST: [lL] [aA] [sS] [tT];
    LC_COLLATE: [lL] [cC] UNDERLINE [cC] [oO] [lL] [lL] [aA] [tT] [eE];
    LC_CTYPE: [lL] [cC] UNDERLINE [cC] [tT] [yY] [pP] [eE];
    LEAKPROOF: [lL] [eE] [aA] [kK] [pP] [rR] [oO] [oO] [fF];
    LEAST: [lL] [eE] [aA] [sS] [tT];
    LEVEL: [lL] [eE] [vV] [eE] [lL];
    LISTEN: [lL] [iI] [sS] [tT] [eE]  [nN];
    LOAD: [lL] [oO] [aA] [dD];
    LOCAL: [lL] [oO] [cC] [aA] [lL];
    LOCATION: [lL] [oO] [cC] [aA] [tT] [iI] [oO]  [nN];
    LOCK: [lL] [oO] [cC] [kK];
    
    MAPPING: [mM] [aA] [pP] [pP] [iI] [nN] [gG];
    MATCH: [mM] [aA] [tT] [cC] [hH];
    MATERIALIZED: [mM] [aA] [tT] [eE] [rR] [iI] [aA] [lL] [iI] [zZ] [eE] [dD];
    MAXVALUE: [mM] [aA] [xX] [vV] [aA] [lL] [uU] [eE];
    MINUTE: [mM] [iI] [nN] [uU] [tT] [eE];
    MINVALUE: [mM] [iI] [nN] [vV] [aA] [lL] [uU] [eE];
    MODE: [mM] [oO] [dD] [eE];
    MONTH: [mM] [oO] [nN] [tT] [hH];
    MOVE: [mM] [oO] [vV] [eE];
    
    NAME: [nN] [aA] [mM] [eE];
    NAMES: [nN] [aA] [mM] [eE] [sS];
    NATIONAL: [nN] [aA] [tT] [iI] [oO] [nN] [aA] [lL];
    NCHAR: [nN] [cC] [hH] [aA] [rR];
    NEXT: [nN] [eE] [xX] [tT];
    NO: [nN] [oO];
    NONE: [nN] [oO] [nN] [eE];
    NOTHING: [nN] [oO] [tT] [hH] [iI] [nN] [gG];
    NOTIFY: [nN] [oO] [tT] [iI] [fF] [yY];
    NOWAIT: [nN] [oO] [wW] [aA] [iI] [tT];
    NULLIF: [nN] [uU] [lL] [lL] [iI] [fF];
    NULLS: [nN] [uU] [lL] [lL] [sS];
    NUMERIC: [nN] [uU] [mM] [eE] [rR] [iI] [cC];
    
    OBJECT: [oO] [bB] [jJ] [eE] [cC] [tT];
    OF: [oO] [fF];
    OFF: [oO] [fF] [fF];
    OID: [oO] [iI] [dD];
    OIDS: [oO] [iI] [dD] [sS];
    OPERATOR: [oO] [pP] [eE] [rR] [aA] [tT] [oO] [rR];
    OPTION: [oO] [pP] [tT] [iI] [oO]  [nN];
    OPTIONS: [oO] [pP] [tT] [iI] [oO] [nN] [sS];
    OUT: [oO] [uU] [tT];
    OVERLAY: [oO] [vV] [eE] [rR] [lL] [aA] [yY];
    OWNED: [oO] [wW] [nN] [eE] [dD];
    OWNER: [oO] [wW] [nN] [eE] [rR];
    
    PARSER: [pP] [aA] [rR] [sS] [eE] [rR];
    PARTIAL: [pP] [aA] [rR] [tT] [iI] [aA] [lL];
    PARTITION: [pP] [aA] [rR] [tT] [iI] [tT] [iI] [oO]  [nN];
    PASSING: [pP] [aA] [sS] [sS] [iI] [nN] [gG];
    PASSWORD: [pP] [aA] [sS] [sS] [wW] [oO] [rR] [dD];
    PLANS: [pP] [lL] [aA] [nN] [sS];
    POSITION: [pP] [oO] [sS] [iI] [tT] [iI] [oO]  [nN];
    PRECEDING: [pP] [rR] [eE] [cC] [eE] [dD] [iI] [nN] [gG];
    PRECISION: [pP] [rR] [eE] [cC] [iI] [sS] [iI] [oO]  [nN];
    PREPARE: [pP] [rR] [eE] [pP] [aA] [rR] [eE];
    PREPARED: [pP] [rR] [eE] [pP] [aA] [rR] [eE] [dD];
    PRESERVE: [pP] [rR] [eE] [sS] [eE] [rR] [vV] [eE];
    PRIOR: [pP] [rR] [iI] [oO] [rR];
    PRIVILEGES: [pP] [rR] [iI] [vV] [iI] [lL] [eE] [gG] [eE] [sS];
    PROCEDURAL: [pP] [rR] [oO] [cC] [eE] [dD] [uU] [rR] [aA] [lL];
    PROCEDURE: [pP] [rR] [oO] [cC] [eE] [dD] [uU] [rR] [eE];
    PROGRAM: [pP] [rR] [oO] [gG] [rR] [aA] [mM];
    
    QUOTE: [qQ] [uU] [oO] [tT] [eE];
    
    RANGE: [rR] [aA] [nN] [gG] [eE];
    READ: [rR] [eE] [aA] [dD];
    REAL: [rR] [eE] [aA] [lL];
    REASSIGN: [rR] [eE] [aA] [sS] [sS] [iI] [gG]  [nN];
    RECHECK: [rR] [eE] [cC] [hH] [eE] [cC] [kK];
    RECURSIVE: [rR] [eE] [cC] [uU] [rR] [sS] [iI] [vV] [eE];
    REF: [rR] [eE] [fF];
    REFRESH: [rR] [eE] [fF] [rR] [eE] [sS] [hH];
    REINDEX: [rR] [eE] [iI] [nN] [dD] [eE] [xX];
    RELATIVE: [rR] [eE] [lL] [aA] [tT] [iI] [vV] [eE];
    RELEASE: [rR] [eE] [lL] [eE] [aA] [sS] [eE];
    RENAME: [rR] [eE] [nN] [aA] [mM] [eE];
    REPEATABLE: [rR] [eE] [pP] [eE] [aA] [tT] [aA] [bB] [lL] [eE];
    REPLACE: [rR] [eE] [pP] [lL] [aA] [cC] [eE];
    REPLICA: [rR] [eE] [pP] [lL] [iI] [cC] [aA];
    RESET: [rR] [eE] [sS] [eE] [tT];
    RESTART: [rR] [eE] [sS] [tT] [aA] [rR] [tT];
    RESTRICT: [rR] [eE] [sS] [tT] [rR] [iI] [cC] [tT];
    RETURNS: [rR] [eE] [tT] [uU] [rR] [nN] [sS];
    REVOKE: [rR] [eE] [vV] [oO] [kK] [eE];
    ROLE: [rR] [oO] [lL] [eE];
    ROLLBACK: [rR] [oO] [lL] [lL] [bB] [aA] [cC] [kK];
    ROW: [rR] [oO] [wW];
    ROWS: [rR] [oO] [wW] [sS];
    RULE: [rR] [uU] [lL] [eE];
    
    SAVEPOINT: [sS] [aA] [vV] [eE] [pP] [oO] [iI] [nN] [tT];
    SCHEMA: [sS] [cC] [hH] [eE] [mM] [aA];
    SCROLL: [sS] [cC] [rR] [oO] [lL] [lL];
    SEARCH: [sS] [eE] [aA] [rR] [cC] [hH];
    SECOND: [sS] [eE] [cC] [oO] [nN] [dD];
    SECURITY: [sS] [eE] [cC] [uU] [rR] [iI] [tT] [yY];
    SEQUENCE: [sS] [eE] [qQ] [uU] [eE] [nN] [cC] [eE];
    SEQUENCES: [sS] [eE] [qQ] [uU] [eE] [nN] [cC] [eE] [sS];
    SERIALIZABLE: [sS] [eE] [rR] [iI] [aA] [lL] [iI] [zZ] [aA] [bB] [lL] [eE];
    SERVER: [sS] [eE] [rR] [vV] [eE] [rR];
    SESSION: [sS] [eE] [sS] [sS] [iI] [oO]  [nN];
    SET: [sS] [eE] [tT];
    SETOF: [sS] [eE] [tT] [oO] [fF];
    SHARE: [sS] [hH] [aA] [rR] [eE];
    SHOW: [sS] [hH] [oO] [wW];
    SIMPLE: [sS] [iI] [mM] [pP] [lL] [eE];
    SMALLINT: [sS] [mM] [aA] [lL] [lL] [iI] [nN] [tT];
    SNAPSHOT: [sS] [nN] [aA] [pP] [sS] [hH] [oO] [tT];
    STABLE: [sS] [tT] [aA] [bB] [lL] [eE];
    STANDALONE: [sS] [tT] [aA] [nN] [dD] [aA] [lL] [oO] [nN] [eE];
    START: [sS] [tT] [aA] [rR] [tT];
    STATEMENT: [sS] [tT] [aA] [tT] [eE] [mM] [eE] [nN] [tT];
    STATISTICS: [sS] [tT] [aA] [tT] [iI] [sS] [tT] [iI] [cC] [sS];
    STDIN: [sS] [tT] [dD] [iI]  [nN];
    STDOUT: [sS] [tT] [dD] [oO] [uU] [tT];
    STORAGE: [sS] [tT] [oO] [rR] [aA] [gG] [eE];
    STRICT: [sS] [tT] [rR] [iI] [cC] [tT];
    STRIP: [sS] [tT] [rR] [iI] [pP];
    SUBSTRING: [sS] [uU] [bB] [sS] [tT] [rR] [iI] [nN] [gG];
    SYSID: [sS] [yY] [sS] [iI] [dD];
    SYSTEM: [sS] [yY] [sS] [tT] [eE] [mM];
    
    TABLES: [tT] [aA] [bB] [lL] [eE] [sS];
    TABLESPACE: [tT] [aA] [bB] [lL] [eE] [sS] [pP] [aA] [cC] [eE];
    TEMP: [tT] [eE] [mM] [pP];
    TEMPLATE: [tT] [eE] [mM] [pP] [lL] [aA] [tT] [eE];
    TEMPORARY: [tT] [eE] [mM] [pP] [oO] [rR] [aA] [rR] [yY];
    TEXT: [tT] [eE] [xX] [tT];
    TIME: [tT] [iI] [mM] [eE];
    TIMESTAMP: [tT] [iI] [mM] [eE] [sS] [tT] [aA] [mM] [pP];
    TRANSACTION: [tT] [rR] [aA] [nN] [sS] [aA] [cC] [tT] [iI] [oO]  [nN];
    TREAT: [tT] [rR] [eE] [aA] [tT];
    TRIGGER: [tT] [rR] [iI] [gG] [gG] [eE] [rR];
    TRIM: [tT] [rR] [iI] [mM];
    TRUNCATE: [tT] [rR] [uU] [nN] [cC] [aA] [tT] [eE];
    TRUSTED: [tT] [rR] [uU] [sS] [tT] [eE] [dD];
    TYPE: [tT] [yY] [pP] [eE];
    TYPES: [tT] [yY] [pP] [eE] [sS];
    
    UNBOUNDED: [uU] [nN] [bB] [oO] [uU] [nN] [dD] [eE] [dD];
    UNCOMMITTED: [uU] [nN] [cC] [oO] [mM] [mM] [iI] [tT] [tT] [eE] [dD];
    UNENCRYPTED: [uU] [nN] [eE] [nN] [cC] [rR] [yY] [pP] [tT] [eE] [dD];
    UNKNOWN: [uU] [nN] [kK] [nN] [oO] [wW]  [nN];
    UNLISTEN: [uU] [nN] [lL] [iI] [sS] [tT] [eE]  [nN];
    UNLOGGED: [uU] [nN] [lL] [oO] [gG] [gG] [eE] [dD];
    UNTIL: [uU] [nN] [tT] [iI] [lL];
    UPDATE: [uU] [pP] [dD] [aA] [tT] [eE];
    
    VACUUM: [vV] [aA] [cC] [uU] [uU] [mM];
    VALID: [vV] [aA] [lL] [iI] [dD];
    VALIDATE: [vV] [aA] [lL] [iI] [dD] [aA] [tT] [eE];
    VALIDATOR: [vV] [aA] [lL] [iI] [dD] [aA] [tT] [oO] [rR];
    VALUE: [vV] [aA] [lL] [uU] [eE];
    VALUES: [vV] [aA] [lL] [uU] [eE] [sS];
    VARCHAR: [vV] [aA] [rR] [cC] [hH] [aA] [rR];
    VARYING: [vV] [aA] [rR] [yY] [iI] [nN] [gG];
    VERSION: [vV] [eE] [rR] [sS] [iI] [oO]  [nN];
    VIEW: [vV] [iI] [eE] [wW];
    VOLATILE: [vV] [oO] [lL] [aA] [tT] [iI] [lL] [eE];
    
    WHITESPACE: [wW] [hH] [iI] [tT] [eE] [sS] [pP] [aA] [cC] [eE];
    WITHOUT: [wW] [iI] [tT] [hH] [oO] [uU] [tT];
    WORK: [wW] [oO] [rR] [kK];
    WRAPPER: [wW] [rR] [aA] [pP] [pP] [eE] [rR];
    WRITE: [wW] [rR] [iI] [tT] [eE];
    
    XML: [xX] [mM] [lL];
    XMLATTRIBUTES: [xX] [mM] [lL] [aA] [tT] [tT] [rR] [iI] [bB] [uU] [tT] [eE] [sS];
    XMLCONCAT: [xX] [mM] [lL] [cC] [oO] [nN] [cC] [aA] [tT];
    XMLELEMENT: [xX] [mM] [lL] [eE] [lL] [eE] [mM] [eE] [nN] [tT];
    XMLEXISTS: [xX] [mM] [lL] [eE] [xX] [iI] [sS] [tT] [sS];
    XMLFOREST: [xX] [mM] [lL] [fF] [oO] [rR] [eE] [sS] [tT];
    XMLPARSE: [xX] [mM] [lL] [pP] [aA] [rR] [sS] [eE];
    XMLPI: [xX] [mM] [lL] [pP] [iI];
    XMLROOT: [xX] [mM] [lL] [rR] [oO] [oO] [tT];
    XMLSERIALIZE: [xX] [mM] [lL] [sS] [eE] [rR] [iI] [aA] [lL] [iI] [zZ] [eE];
    
    YEAR: [yY] [eE] [aA] [rR];
    YES: [yY] [eE] [sS];
    
    ZONE: [zZ] [oO] [nN] [eE];
    
    /*
     * Other tokens.
     * Some sql words/data types are not keywords but we need a token to be able to parse them.
     */
    
    FORCE_NOT_NULL: [fF] [oO] [rR] [cC] [eE] UNDERLINE [nN] [oO] [tT] UNDERLINE [nN] [uU] [lL] [lL];
    FORCE_QUOTE: [fF] [oO] [rR] [cC] [eE] UNDERLINE [qQ] [uU] [oO] [tT] [eE];
    FORMAT: [fF] [oO] [rR] [mM] [aA] [tT];
    PLAIN: [pP] [lL] [aA] [iI]  [nN];
    EXTENDED: [eE] [xX] [tT] [eE] [nN] [dD] [eE] [dD];
    MAIN: [mM] [aA] [iI]  [nN];
    N_DISTINCT: [nN] UNDERLINE [dD] [iI] [sS] [tT] [iI] [nN] [cC] [tT];
    N_DISTINCT_INHERITED: [nN] UNDERLINE [dD] [iI] [sS] [tT] [iI] [nN] [cC] [tT] UNDERLINE [iI] [nN] [hH] [eE] [rR] [iI] [tT] [eE] [dD];
    SUBTYPE: [sS] [uU] [bB] [tT] [yY] [pP] [eE];
    SUBTYPE_OPCLASS: [sS] [uU] [bB] [tT] [yY] [pP] [eE] UNDERLINE [oO] [pP] [cC] [lL] [aA] [sS] [sS];
    CANONICAL: [cC] [aA] [nN] [oO] [nN] [iI] [cC] [aA] [lL];
    SUBTYPE_DIFF: [sS] [uU] [bB] [tT] [yY] [pP] [eE] UNDERLINE [dD] [iI] [fF] [fF];
    RECEIVE: [rR] [eE] [cC] [eE] [iI] [vV] [eE];
    SEND: [sS] [eE] [nN] [dD];
    TYPMOD_IN: [tT] [yY] [pP] [mM] [oO] [dD] UNDERLINE [iI]  [nN];
    TYPMOD_OUT: [tT] [yY] [pP] [mM] [oO] [dD] UNDERLINE [oO] [uU] [tT];
    INTERNALLENGTH: [iI] [nN] [tT] [eE] [rR] [nN] [aA] [lL] [lL] [eE] [nN] [gG] [tT] [hH];
    PASSEDBYVALUE: [pP] [aA] [sS] [sS] [eE] [dD] [bB] [yY] [vV] [aA] [lL] [uU] [eE];
    ALIGNMENT: [aA] [lL] [iI] [gG] [nN] [mM] [eE] [nN] [tT];
    CATEGORY: [cC] [aA] [tT] [eE] [gG] [oO] [rR] [yY];
    PREFERRED: [pP] [rR] [eE] [fF] [eE] [rR] [rR] [eE] [dD];
    COLLATABLE: [cC] [oO] [lL] [lL] [aA] [tT] [aA] [bB] [lL] [eE];
    ISSTRICT: [iI] [sS] [sS] [tT] [rR] [iI] [cC] [tT];
    ISCACHABLE: [iI] [sS] [cC] [aA] [cC] [hH] [aA] [bB] [lL] [eE];
    REGCLASS: [rR] [eE] [gG] [cC] [lL] [aA] [sS] [sS];
    REGCONFIG: [rR] [eE] [gG] [cC] [oO] [nN] [fF] [iI] [gG];
    UUID: [uU] [uU] [iI] [dD];
    VOID: [vV] [oO] [iI] [dD];
    INET: [iI] [nN] [eE] [tT];
    INET4: [iI] [nN] [eE] [tT] '4';
    BYTEA: [bB] [yY] [tT] [eE] [aA];
    INT1: [iI] [nN] [tT] '1';
    TINYINT: [tT] [iI] [nN] [yY] [iI] [nN] [tT];
    INT2: [iI] [nN] [tT] '2';
    INT4: [iI] [nN] [tT] '4';
    INT8: [iI] [nN] [tT] '8';
    MONEY: [mM] [oO] [nN] [eE] [yY];
    FLOAT4: [fF] [lL] [oO] [aA] [tT] '4';
    FLOAT8: [fF] [lL] [oO] [aA] [tT] '8';
    BOOL: [bB] [oO] [oO] [lL];
    TIMETZ: [tT] [iI] [mM] [eE] [tT] [zZ];
    TIMESTAMPTZ: [tT] [iI] [mM] [eE] [sS] [tT] [aA] [mM] [pP] [tT] [zZ];
    VARBIT: [vV] [aA] [rR] [bB] [iI] [tT];
    TIMEZONE: [tT] [iI] [mM] [eE] [zZ] [oO] [nN] [eE];
    REGEXP: [rR] [eE] [gG] [eE] [xX] [pP];
    RLIKE: [rR] [lL] [iI] [kK] [eE];
    CENTURY: [cC] [eE] [nN] [tT] [uU] [rR] [yY];
    DECADE: [dD] [eE] [cC] [aA] [dD] [eE];
    DOW: [dD] [oO] [wW];
    DOY: [dD] [oO] [yY];
    EPOCH: [eE] [pP] [oO] [cC] [hH];
    ISODOW: [iI] [sS] [oO] [dD] [oO] [wW];
    ISOYEAR: [iI] [sS] [oO] [yY] [eE] [aA] [rR];
    MICROSECONDS: [mM] [iI] [cC] [rR] [oO] [sS] [eE] [cC] [oO] [nN] [dD] [sS];
    MILLENNIUM: [mM] [iI] [lL] [lL] [eE] [nN] [nN] [iI] [uU] [mM];
    MILLISECONDS: [mM] [iI] [lL] [lL] [iI] [sS] [eE] [cC] [oO] [nN] [dD] [sS];
    QUARTER: [qQ] [uU] [aA] [rR] [tT] [eE] [rR];
    WEEK: [wW] [eE] [eE] [kK];
    VARIABLE: [vV] [aA] [rR] [iI] [aA] [bB] [lL] [eE];
    USAGE: [uU] [sS] [aA] [gG] [eE];
    OUTPUT: [oO] [uU] [tT] [pP] [uU] [tT];
    ELEMENT: [eE] [lL] [eE] [mM] [eE] [nN] [tT];
    PUBLIC: [pP] [uU] [bB] [lL] [iI] [cC];
    CONNECT: [cC] [oO] [nN] [nN] [eE] [cC] [tT];
    DATE: [dD] [aA] [tT] [eE];
    BLOB: [bB] [lL] [oO] [bB];
    VARBINARY: [vV] [aA] [rR] [bB] [iI] [nN] [aA] [rR] [yY];
    COUNT: [cC] [oO] [uU] [nN] [tT];
    AVG: [aA] [vV] [gG];
    MAX: [mM] [aA] [xX];
    MIN: [mM] [iI]  [nN];
    SUM: [sS] [uU] [mM];
    EVERY: [eE] [vV] [eE] [rR] [yY];
    STDDEV_POP: [sS] [tT] [dD] [dD] [eE] [vV] UNDERLINE [pP] [oO] [pP];
    STDDEV_SAMP: [sS] [tT] [dD] [dD] [eE] [vV] UNDERLINE [sS] [aA] [mM] [pP];
    VAR_SAMP: [vV] [aA] [rR] UNDERLINE [sS] [aA] [mM] [pP];
    VAR_POP: [vV] [aA] [rR] UNDERLINE [pP] [oO] [pP];
    COLLECT: [cC] [oO] [lL] [lL] [eE] [cC] [tT];
    FUSION: [fF] [uU] [sS] [iI] [oO]  [nN];
    INTERSECTION: [iI] [nN] [tT] [eE] [rR] [sS] [eE] [cC] [tT] [iI] [oO]  [nN];
    FILTER: [fF] [iI] [lL] [tT] [eE] [rR];
    TIMEZONE_HOUR: [tT] [iI] [mM] [eE] [zZ] [oO] [nN] [eE] UNDERLINE [hH] [oO] [uU] [rR];
    TIMEZONE_MINUTE: [tT] [iI] [mM] [eE] [zZ] [oO] [nN] [eE] UNDERLINE [mM] [iI] [nN] [uU] [tT] [eE];
    ROLLUP: [rR] [oO] [lL] [lL] [uU] [pP];
    CUBE: [cC] [uU] [bB] [eE];
    GROUPING : [gG] [rR] [oO] [uU] [pP] [iI] [nN] [gG];
    SETS : [sS] [eE] [tT] [sS];
    CIDR : [cC] [iI] [dD] [rR];

// Operators

// Cast Operator
CAST_EXPRESSION
  : COLON COLON
  ;

EQUAL  : '=';
COLON :  ':';
SEMI_COLON :  ';';
COMMA : ',';
NOT_EQUAL  : '<>' | '!=';
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
UNDERLINE : '_';
QUOTE_CHAR : '\'';
DOUBLE_QUOTE : '"';
DOLLAR : '$';
LEFT_BRACKET : '[';
RIGHT_BRACKET : ']';

fragment
Operator : [\~\!\@\#\^\&\|\`\?\+\-\*\/\%\<\>\=];

NUMBER_LITERAL : Digit+;

fragment
Digit : '0'..'9';

REAL_NUMBER
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

BlockComment
    :   '/*' .*? '*/' -> channel(HIDDEN)
    ;

LineComment
    :   '--' ~[\r\n]* -> channel(HIDDEN)
    ;

OP_CHARS
	:	Operator+
	;

/*
===============================================================================
 Identifiers
===============================================================================
*/

Identifier
    : IdentifierStartChar IdentifierChar*
    // always lowercase unquoted ids
        { setText(getText().toLowerCase()); }
    ;
fragment
IdentifierStartChar
    : // these are the valid identifier start characters below 0x7F
    [a-zA-Z_]
    | // these are the valid characters from 0x80 to 0xFF
    [\u00AA\u00B5\u00BA\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u00FF]
    | // these are the letters above 0xFF which only need a single UTF-16 code unit
    [\u0100-\uD7FF\uE000-\uFFFF] {Character.isLetter((char)_input.LA(-1))}?
    | // letters which require multiple UTF-16 code units
    [\uD800-\uDBFF] [\uDC00-\uDFFF] {Character.isLetter(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;
fragment
IdentifierChar
    : StrictIdentifierChar
    | '$'
    ;
fragment
StrictIdentifierChar
    : IdentifierStartChar
    | [0-9]
    ;

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
fragment UnterminatedQuotedIdentifier
    : '"'
    ( '""'
    | ~[\u0000"]
    )*
    ;
/*
===============================================================================
 Literal
===============================================================================
*/

// Some Unicode Character Ranges
fragment
Control_Characters                  :   '\u0001' .. '\u001F';
fragment
Extended_Control_Characters         :   '\u0080' .. '\u009F';

Character_String_Literal
  : QUOTE_CHAR ( ESC_SEQ | ~('\'') )* QUOTE_CHAR
  ;

ESC_SEQUENCES
    : (ESC_SEQ)
    ;
fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    | ('\'\'')
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

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

White_Space
  : ( Control_Characters  | Extended_Control_Characters )+ -> channel(HIDDEN)
  ;


BAD
  : . -> channel(HIDDEN)
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
