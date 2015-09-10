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
  Tokens for Case Insensitive Keywords
===============================================================================
*/
fragment A
	:	'A' | 'a';

fragment B
	:	'B' | 'b';

fragment C
	:	'C' | 'c';

fragment D
	:	'D' | 'd';

fragment E
	:	'E' | 'e';

fragment F
	:	'F' | 'f';

fragment G
	:	'G' | 'g';

fragment H
	:	'H' | 'h';

fragment I
	:	'I' | 'i';

fragment J
	:	'J' | 'j';

fragment K
	:	'K' | 'k';

fragment L
	:	'L' | 'l';

fragment M
	:	'M' | 'm';

fragment N
	:	'N' | 'n';

fragment O
	:	'O' | 'o';

fragment P
	:	'P' | 'p';

fragment Q
	:	'Q' | 'q';

fragment R
	:	'R' | 'r';

fragment S
	:	'S' | 's';

fragment T
	:	'T' | 't';

fragment U
	:	'U' | 'u';

fragment V
	:	'V' | 'v';

fragment W
	:	'W' | 'w';

fragment X
	:	'X' | 'x';

fragment Y
	:	'Y' | 'y';

fragment Z
	:	'Z' | 'z';

/*
===============================================================================
  Reserved Keywords
===============================================================================
*/

ALL: A L L;
ANALYSE: A N A L Y S E;
ANALYZE: A N A L Y Z E;
AND: A N D;
ANY: A N Y;
ARRAY: A R R A Y;
AS: A S;
ASC: A S C;
ASYMMETRIC: A S Y M M E T R I C;
AUTHORIZATION: A U T H O R I Z A T I O N;

BINARY: B I N A R Y;
BOTH: B O T H;

CASE: C A S E;
CAST: C A S T;
CHECK: C H E C K;
COLLATE: C O L L A T E;
COLLATION: C O L L A T I O N;
COLUMN: C O L U M N;
CONCURRENTLY: C O N C U R R E N T L Y;
CONSTRAINT: C O N S T R A I N T;
CREATE: C R E A T E;
CROSS: C R O S S;
CURRENT_CATALOG: C U R R E N T UNDERLINE C A T A L O G;
CURRENT_DATE: C U R R E N T UNDERLINE D A T E;
CURRENT_ROLE: C U R R E N T UNDERLINE R O L E;
CURRENT_SCHEMA: C U R R E N T UNDERLINE S C H E M A;
CURRENT_TIME: C U R R E N T UNDERLINE T I M E;
CURRENT_TIMESTAMP: C U R R E N T UNDERLINE T I M E S T A M P;
CURRENT_USER: C U R R E N T UNDERLINE U S E R;

DEFAULT: D E F A U L T;
DEFERRABLE: D E F E R R A B L E;
DESC: D E S C;
DISTINCT: D I S T I N C T;
DO: D O;

ELSE: E L S E;
END: E N D;
EXCEPT: E X C E P T;

FALSE: F A L S E;
FETCH: F E T C H;
FOR: F O R;
FOREIGN: F O R E I G N;
FREEZE: F R E E Z E;
FROM: F R O M;
FULL: F U L L;

GRANT: G R A N T;
GROUP: G R O U P;

HAVING: H A V I N G;

ILIKE: I L I K E;
IN: I N;
INITIALLY: I N I T I A L L Y;
INNER: I N N E R;
INTERSECT: I N T E R S E C T;
INTO: I N T O;
IS: I S;
ISNULL: I S N U L L;

JOIN: J O I N;

LATERAL: L A T E R A L;
LEADING: L E A D I N G;
LEFT: L E F T;
LIKE: L I K E;
LIMIT: L I M I T;
LOCALTIME: L O C A L T I M E;
LOCALTIMESTAMP: L O C A L T I M E S T A M P;

NATURAL: N A T U R A L;
NOT: N O T;
NOTNULL: N O T N U L L;
NULL: N U L L;

OFFSET: O F F S E T;
ON: O N;
ONLY: O N L Y;
OR: O R;
ORDER: O R D E R;
OUTER: O U T E R;
OVER: O V E R;
OVERLAPS: O V E R L A P S;

PLACING: P L A C I N G;
PRIMARY: P R I M A R Y;

REFERENCES: R E F E R E N C E S;
RETURNING: R E T U R N I N G;
RIGHT: R I G H T;

SELECT: S E L E C T;
SESSION_USER: S E S S I O N UNDERLINE U S E R;
SIMILAR: S I M I L A R;
SOME: S O M E;
SYMMETRIC: S Y M M E T R I C;

TABLE: T A B L E;
THEN: T H E N;
TO: T O;
TRAILING: T R A I L I N G;
TRUE: T R U E;

UNION: U N I O N;
UNIQUE: U N I Q U E;
USER: U S E R;
USING: U S I N G;

VARIADIC: V A R I A D I C;
VERBOSE: V E R B O S E;

WHEN: W H E N;
WHERE: W H E R E;
WINDOW: W I N D O W;
WITH: W I T H;

/*
===============================================================================
  Non-reserved Keywords
===============================================================================
*/

ABORT: A B O R T;
ABSOLUTE: A B S O L U T E;
ACCESS: A C C E S S;
ACTION: A C T I O N;
ADD: A D D;
ADMIN: A D M I N;
AFTER: A F T E R;
AGGREGATE: A G G R E G A T E;
ALSO: A L S O;
ALTER: A L T E R;
ALWAYS: A L W A Y S;
ASSERTION: A S S E R T I O N;
ASSIGNMENT: A S S I G N M E N T;
AT: A T;
ATTRIBUTE: A T T R I B U T E;

BACKWARD: B A C K W A R D;
BEFORE: B E F O R E;
BEGIN: B E G I N;
BETWEEN: B E T W E E N;
BIGINT: B I G I N T;
BIT: B I T;
BOOLEAN: B O O L E A N;
BY: B Y;

CACHE: C A C H E;
CALLED: C A L L E D;
CASCADE: C A S C A D E;
CASCADED: C A S C A D E D;
CATALOG: C A T A L O G;
CHAIN: C H A I N;
CHAR: C H A R;
CHARACTER: C H A R A C T E R;
CHARACTERISTICS: C H A R A C T E R I S T I C S;
CHECKPOINT: C H E C K P O I N T;
CLASS: C L A S S;
CLOSE: C L O S E;
CLUSTER: C L U S T E R;
COALESCE: C O A L E S C E;
COMMENT: C O M M E N T;
COMMENTS: C O M M E N T S;
COMMIT: C O M M I T;
COMMITTED: C O M M I T T E D;
CONFIGURATION: C O N F I G U R A T I O N;
CONNECTION: C O N N E C T I O N;
CONSTRAINTS: C O N S T R A I N T S;
CONTENT: C O N T E N T;
CONTINUE: C O N T I N U E;
CONVERSION: C O N V E R S I O N;
COPY: C O P Y;
COST: C O S T;
CSV: C S V;
CURRENT: C U R R E N T;
CURSOR: C U R S O R;
CYCLE: C Y C L E;

DATA: D A T A;
DATABASE: D A T A B A S E;
DAY: D A Y;
DEALLOCATE: D E A L L O C A T E;
DEC: D E C;
DECIMAL: D E C I M A L;
DECLARE: D E C L A R E;
DEFAULTS: D E F A U L T S;
DEFERRED: D E F E R R E D;
DEFINER: D E F I N E R;
DELETE: D E L E T E;
DELIMITER: D E L I M I T E R;
DELIMITERS: D E L I M I T E R S;
DICTIONARY: D I C T I O N A R Y;
DISABLE: D I S A B L E;
DISCARD: D I S C A R D;
DOCUMENT: D O C U M E N T;
DOMAIN: D O M A I N;
DOUBLE: D O U B L E;
DROP: D R O P;

EACH: E A C H;
ENABLE: E N A B L E;
ENCODING: E N C O D I N G;
ENCRYPTED: E N C R Y P T E D;
END_EXEC: E N D MINUS E X E C;
ENUM: E N U M;
ESCAPE: E S C A P E;
EVENT: E V E N T;
EXCLUDE: E X C L U D E;
EXCLUDING: E X C L U D I N G;
EXCLUSIVE: E X C L U S I V E;
EXECUTE: E X E C U T E;
EXISTS: E X I S T S;
EXPLAIN: E X P L A I N;
EXTENSION: E X T E N S I O N;
EXTERNAL: E X T E R N A L;
EXTRACT: E X T R A C T;

FAMILY: F A M I L Y;
FIRST: F I R S T;
FLOAT: F L O A T;
FOLLOWING: F O L L O W I N G;
FORCE: F O R C E;
FORWARD: F O R W A R D;
FUNCTION: F U N C T I O N;
FUNCTIONS: F U N C T I O N S;

GLOBAL: G L O B A L;
GRANTED: G R A N T E D;
GREATEST: G R E A T E S T;

HANDLER: H A N D L E R;
HEADER: H E A D E R;
HOLD: H O L D;
HOUR: H O U R;

IDENTITY: I D E N T I T Y;
IF: I F;
IMMEDIATE: I M M E D I A T E;
IMMUTABLE: I M M U T A B L E;
IMPLICIT: I M P L I C I T;
INCLUDING: I N C L U D I N G;
INCREMENT: I N C R E M E N T;
INDEX: I N D E X;
INDEXES: I N D E X E S;
INHERIT: I N H E R I T;
INHERITS: I N H E R I T S;
INLINE: I N L I N E;
INOUT: I N O U T;
INPUT: I N P U T;
INSENSITIVE: I N S E N S I T I V E;
INSERT: I N S E R T;
INSTEAD: I N S T E A D;
INT: I N T;
INTEGER: I N T E G E R;
INTERVAL: I N T E R V A L;
INVOKER: I N V O K E R;
ISOLATION: I S O L A T I O N;

KEY: K E Y;

LABEL: L A B E L;
LANGUAGE: L A N G U A G E;
LARGE: L A R G E;
LAST: L A S T;
LC_COLLATE: L C UNDERLINE C O L L A T E;
LC_CTYPE: L C UNDERLINE C T Y P E;
LEAKPROOF: L E A K P R O O F;
LEAST: L E A S T;
LEVEL: L E V E L;
LISTEN: L I S T E N;
LOAD: L O A D;
LOCAL: L O C A L;
LOCATION: L O C A T I O N;
LOCK: L O C K;

MAPPING: M A P P I N G;
MATCH: M A T C H;
MATERIALIZED: M A T E R I A L I Z E D;
MAXVALUE: M A X V A L U E;
MINUTE: M I N U T E;
MINVALUE: M I N V A L U E;
MODE: M O D E;
MONTH: M O N T H;
MOVE: M O V E;

NAME: N A M E;
NAMES: N A M E S;
NATIONAL: N A T I O N A L;
NCHAR: N C H A R;
NEXT: N E X T;
NO: N O;
NONE: N O N E;
NOTHING: N O T H I N G;
NOTIFY: N O T I F Y;
NOWAIT: N O W A I T;
NULLIF: N U L L I F;
NULLS: N U L L S;
NUMERIC: N U M E R I C;

OBJECT: O B J E C T;
OF: O F;
OFF: O F F;
OIDS: O I D S;
OPERATOR: O P E R A T O R;
OPTION: O P T I O N;
OPTIONS: O P T I O N S;
OUT: O U T;
OVERLAY: O V E R L A Y;
OWNED: O W N E D;
OWNER: O W N E R;

PARSER: P A R S E R;
PARTIAL: P A R T I A L;
PARTITION: P A R T I T I O N;
PASSING: P A S S I N G;
PASSWORD: P A S S W O R D;
PLANS: P L A N S;
POSITION: P O S I T I O N;
PRECEDING: P R E C E D I N G;
PRECISION: P R E C I S I O N;
PREPARE: P R E P A R E;
PREPARED: P R E P A R E D;
PRESERVE: P R E S E R V E;
PRIOR: P R I O R;
PRIVILEGES: P R I V I L E G E S;
PROCEDURAL: P R O C E D U R A L;
PROCEDURE: P R O C E D U R E;
PROGRAM: P R O G R A M;

QUOTE: Q U O T E;

RANGE: R A N G E;
READ: R E A D;
REAL: R E A L;
REASSIGN: R E A S S I G N;
RECHECK: R E C H E C K;
RECURSIVE: R E C U R S I V E;
REF: R E F;
REFRESH: R E F R E S H;
REINDEX: R E I N D E X;
RELATIVE: R E L A T I V E;
RELEASE: R E L E A S E;
RENAME: R E N A M E;
REPEATABLE: R E P E A T A B L E;
REPLACE: R E P L A C E;
REPLICA: R E P L I C A;
RESET: R E S E T;
RESTART: R E S T A R T;
RESTRICT: R E S T R I C T;
RETURNS: R E T U R N S;
REVOKE: R E V O K E;
ROLE: R O L E;
ROLLBACK: R O L L B A C K;
ROW: R O W;
ROWS: R O W S;
RULE: R U L E;

SAVEPOINT: S A V E P O I N T;
SCHEMA: S C H E M A;
SCROLL: S C R O L L;
SEARCH: S E A R C H;
SECOND: S E C O N D;
SECURITY: S E C U R I T Y;
SEQUENCE: S E Q U E N C E;
SEQUENCES: S E Q U E N C E S;
SERIALIZABLE: S E R I A L I Z A B L E;
SERVER: S E R V E R;
SESSION: S E S S I O N;
SET: S E T;
SETOF: S E T O F;
SHARE: S H A R E;
SHOW: S H O W;
SIMPLE: S I M P L E;
SMALLINT: S M A L L I N T;
SNAPSHOT: S N A P S H O T;
STABLE: S T A B L E;
STANDALONE: S T A N D A L O N E;
START: S T A R T;
STATEMENT: S T A T E M E N T;
STATISTICS: S T A T I S T I C S;
STDIN: S T D I N;
STDOUT: S T D O U T;
STORAGE: S T O R A G E;
STRICT: S T R I C T;
STRIP: S T R I P;
SUBSTRING: S U B S T R I N G;
SYSID: S Y S I D;
SYSTEM: S Y S T E M;

TABLES: T A B L E S;
TABLESPACE: T A B L E S P A C E;
TEMP: T E M P;
TEMPLATE: T E M P L A T E;
TEMPORARY: T E M P O R A R Y;
TEXT: T E X T;
TIME: T I M E;
TIMESTAMP: T I M E S T A M P;
TRANSACTION: T R A N S A C T I O N;
TREAT: T R E A T;
TRIGGER: T R I G G E R;
TRIM: T R I M;
TRUNCATE: T R U N C A T E;
TRUSTED: T R U S T E D;
TYPE: T Y P E;
TYPES: T Y P E S;

UNBOUNDED: U N B O U N D E D;
UNCOMMITTED: U N C O M M I T T E D;
UNENCRYPTED: U N E N C R Y P T E D;
UNKNOWN: U N K N O W N;
UNLISTEN: U N L I S T E N;
UNLOGGED: U N L O G G E D;
UNTIL: U N T I L;
UPDATE: U P D A T E;

VACUUM: V A C U U M;
VALID: V A L I D;
VALIDATE: V A L I D A T E;
VALIDATOR: V A L I D A T O R;
VALUE: V A L U E;
VALUES: V A L U E S;
VARCHAR: V A R C H A R;
VARYING: V A R Y I N G;
VERSION: V E R S I O N;
VIEW: V I E W;
VOLATILE: V O L A T I L E;

WHITESPACE: W H I T E S P A C E;
WITHOUT: W I T H O U T;
WORK: W O R K;
WRAPPER: W R A P P E R;
WRITE: W R I T E;

XML: X M L;
XMLATTRIBUTES: X M L A T T R I B U T E S;
XMLCONCAT: X M L C O N C A T;
XMLELEMENT: X M L E L E M E N T;
XMLEXISTS: X M L E X I S T S;
XMLFOREST: X M L F O R E S T;
XMLPARSE: X M L P A R S E;
XMLPI: X M L P I;
XMLROOT: X M L R O O T;
XMLSERIALIZE: X M L S E R I A L I Z E;

YEAR: Y E A R;
YES: Y E S;

ZONE: Z O N E;

/*
 * Other tokens.
 * Some sql words/data types are not keywords but we need a token to be able to parse them.
 */

FORCE_NOT_NULL: F O R C E UNDERLINE N O T UNDERLINE N U L L;
FORCE_QUOTE: F O R C E UNDERLINE Q U O T E;
FORMAT: F O R M A T;
PLAIN: P L A I N;
EXTENDED: E X T E N D E D;
MAIN: M A I N;
N_DISTINCT: N UNDERLINE D I S T I N C T;
N_DISTINCT_INHERITED: N UNDERLINE D I S T I N C T UNDERLINE I N H E R I T E D;
SUBTYPE: S U B T Y P E;
SUBTYPE_OPCLASS: S U B T Y P E UNDERLINE O P C L A S S;
CANONICAL: C A N O N I C A L;
SUBTYPE_DIFF: S U B T Y P E UNDERLINE D I F F;
RECEIVE: R E C E I V E;
SEND: S E N D;
TYPMOD_IN: T Y P M O D UNDERLINE I N;
TYPMOD_OUT: T Y P M O D UNDERLINE O U T;
INTERNALLENGTH: I N T E R N A L L E N G T H;
PASSEDBYVALUE: P A S S E D B Y V A L U E;
ALIGNMENT: A L I G N M E N T;
CATEGORY: C A T E G O R Y;
PREFERRED: P R E F E R R E D;
COLLATABLE: C O L L A T A B L E;
ISSTRICT: I S S T R I C T;
ISCACHABLE: I S C A C H A B L E;
REGCLASS: R E G C L A S S;
REGCONFIG: R E G C O N F I G;
UUID: U U I D;
VOID: V O I D;
INET: I N E T;
INET4: I N E T '4';
BYTEA: B Y T E A;
INT1: I N T '1';
TINYINT: T I N Y I N T;
INT2: I N T '2';
INT4: I N T '4';
INT8: I N T '8';
FLOAT4: F L O A T '4';
FLOAT8: F L O A T '8';
BOOL: B O O L;
TIMETZ: T I M E T Z;
TIMESTAMPTZ: T I M E S T A M P T Z;
VARBIT: V A R B I T;
TIMEZONE: T I M E Z O N E;
REGEXP: R E G E X P;
RLIKE: R L I K E;
CENTURY: C E N T U R Y;
DECADE: D E C A D E;
DOW: D O W;
DOY: D O Y;
EPOCH: E P O C H;
ISODOW: I S O D O W;
ISOYEAR: I S O Y E A R;
MICROSECONDS: M I C R O S E C O N D S;
MILLENNIUM: M I L L E N N I U M;
MILLISECONDS: M I L L I S E C O N D S;
QUARTER: Q U A R T E R;
WEEK: W E E K;
VARIABLE: V A R I A B L E;
USAGE: U S A G E;
OUTPUT: O U T P U T;
ELEMENT: E L E M E N T;
PUBLIC: P U B L I C;
CONNECT: C O N N E C T;
DATE: D A T E;
BLOB: B L O B;
VARBINARY: V A R B I N A R Y;
COUNT: C O U N T;
AVG: A V G;
MAX: M A X;
MIN: M I N;
SUM: S U M;
EVERY: E V E R Y;
STDDEV_POP: S T D D E V UNDERLINE P O P;
STDDEV_SAMP: S T D D E V UNDERLINE S A M P;
VAR_SAMP: V A R UNDERLINE S A M P;
VAR_POP: V A R UNDERLINE P O P;
COLLECT: C O L L E C T;
FUSION: F U S I O N;
INTERSECTION: I N T E R S E C T I O N;
FILTER: F I L T E R;
TIMEZONE_HOUR: T I M E Z O N E UNDERLINE H O U R;
TIMEZONE_MINUTE: T I M E Z O N E UNDERLINE M I N U T E;
ROLLUP: R O L L U P;
CUBE: C U B E;

// Operators
Similar_To : '~';
Not_Similar_To : '!~';
Similar_To_Case_Insensitive : '~*';
Not_Similar_To_Case_Insensitive : '!~*';

// Cast Operator
CAST_EXPRESSION
  : COLON COLON
  ;

ASSIGN  : ':=';
EQUAL  : '=';
COLON :  ':';
SEMI_COLON :  ';';
COMMA : ',';
CONCATENATION_OPERATOR : VERTICAL_BAR VERTICAL_BAR;
NOT_EQUAL  : '<>' | '!=' | '~='| '^=' ;
LTH : '<' ;
LEQ : '<=';
GTH   : '>';
GEQ   : '>=';
LEFT_PAREN :  '(';
RIGHT_PAREN : ')';
PLUS  : '+';
MINUS : '-';
MULTIPLY: '*';
DIVIDE  : '/';
MODULAR : '%';
DOT : '.';
UNDERLINE : '_';
VERTICAL_BAR : '|';
QUOTE_CHAR : '\'';
DOUBLE_QUOTE : '"';
DOLLAR: '$';
LEFT_BRACKET: '[';
RIGHT_BRACKET: ']';
BIT_AND: '&';

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

/*
===============================================================================
 Identifiers
===============================================================================
*/

Identifier
    : IdentifierStartChar IdentifierChar*
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
    ;
// This is a quoted identifier which only contains valid characters but is not terminated
UnterminatedQuotedIdentifier
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
  :	( Control_Characters  | Extended_Control_Characters )+ -> channel(HIDDEN)
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