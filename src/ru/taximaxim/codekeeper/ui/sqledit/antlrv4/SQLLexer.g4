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
}

@members {
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

ADD: A D D;
AGGREGATE: A G G R E G A T E;
AFTER: A F T E R;
AS : A S;
ALL : A L L;
ALTER: A L T E R;
AND : A N D;
ANY : A N Y;
ASYMMETRIC : A S Y M M E T R I C;
ASC : A S C;
AUTHORIZATION: A U T H O R I Z A T I O N;

BEFORE: B E F O R E;
BOTH : B O T H;

CASE : C A S E;
CASCADE: C A S C A D E;
CAST : C A S T;
COLLATE: C O L L A T E;
COLLATION: C O L L A T I O N;
CONNECT: C O N N E C T;
CONSTRAINT: C O N S T R A I N T;
CONSTRAINTS: CONSTRAINT S;
CONVERSION: C O N V E R S I O N;
CREATE : C R E A T E;
CROSS : C R O S S;

DATABASE: D A T A B A S E;
DEFAULT: D E F A U L T;
DEFAULTS: DEFAULT S;
DEFERRABLE: D E F E R R A B L E;
DEFERRED: D E F E R R E D;
DELETE: D E L E T E;
DESC : D E S C;
DISTINCT : D I S T I N C T;
DOMAIN: D O M A I N;

EACH: E A C H;
END : E N D;
ELSE : E L S E;
EXCEPT : E X C E P T;
EXCLUDE: E X C L U D E;
EXCLUDING: E X C L U D I N G;
EXECUTE: E X E C U T E;
EXTENSION : E X T E N S I O N;

FALSE : F A L S E;
FOR: F O R;
FOREIGN: F O R E I G N;
FULL : F U L L;
FUNCTION: F U N C T I O N;
FUNCTIONS: FUNCTION S;
FROM : F R O M;

GLOBAL: G L O B A L;
GRANT: G R A N T;
GROUP : G R O U P;

HAVING : H A V I N G;
HANDLER: H A N D L E R;

IF: I F;
ILIKE : I L I K E;
IMMEDIATE: I M M E D I A T E;
IMMUTABLE: I M M U T A B L E;
IN : I N;
INCLUDING: I N C L U D I N G;
INHERITS: I N H E R I T S;
INITIALLY: I N I T I A L L Y;
INLINE: I N L I N E;
INNER : I N N E R;
INTERSECT : I N T E R S E C T;
INTO : I N T O;
INOUT: I N O U T;
INSTEAD: I N S T E A D;
INVOKER: I N V O K E R;
IS : I S;

JOIN : J O I N;

KEY: K E Y;

LEADING : L E A D I N G;
LEFT : L E F T;
LIKE : L I K E;
LIMIT : L I M I T;
LOCAL: L O C A L;

NATURAL : N A T U R A L;
NOT : N O T;
NULL : N U L L;

OF: O F;
OIDS: O I D S;
OUTER : O U T E R;
OUT: O U T;
OPERATOR: O P E R A T O R;
OR : O R;
ORDER : O R D E R;
OWNED: O W N E D;
OWNER: O W N E R;

PRESERVE: P R E S E R V E;
PRIMARY: P R I M A R Y;
PRIVILEGES: P R I V I L E G E S;
PROCEDURE: P R O C E D U R E;
PROCEDURAL: P R O C E D U R A L;

ROLE: R O L E;
ROW: R O W;
ROWS: ROW S;
REFERENCES: R E F E R E N C E S;
REPLACE: R E P L A C E;
RESTRICT: R E S T R I C T;
RETURNS: R E T U R N S;
REVOKE: R E V O K E;
RIGHT : R I G H T;
RULE: R U L E;

SCHEMA: S C H E M A;
SEQUENCE: S E Q U E N C E;
SEQUENCES: SEQUENCE S;
SELECT : S E L E C T;
SESSION: S E S S I O N;
SETOF: SET OF;
SOME : S O M E;
STATEMENT: S T A T E M E N T;
STRICT: S T R I C T;
SYMMETRIC : S Y M M E T R I C;

TABLE : T A B L E;
TEMP: T E M P;
TEMPORARY: T E M P O R A R Y;
THEN : T H E N;
TRAILING : T R A I L I N G;
TRUSTED: T R U S T E D;
TRIGGER: T R I G G E R;
TRUE : T R U E;
TRUNCATE: T R U N C A T E;

UNION : U N I O N;
UNIQUE : U N I Q U E;
UPDATE: U P D A T E;
USAGE: U S A G E;
USING : U S I N G;

VALIDATOR: V A L I D A T O R;
VARIADIC: V A R I A D I C;
VIEW: V I E W;

WHEN : W H E N;
WHERE : W H E R E;
WITH : W I T H;
WITHOUT: W I T H O U T;

/*
===============================================================================
  Non Reserved Keywords
===============================================================================
*/

ADMIN: A D M I N;
ALWAYS: A L W A Y S;
AVG : A V G;

BETWEEN : B E T W E E N;
BY : B Y;

CACHE: C A C H E;
CALLED: C A L L E D;
CLASS: C L A S S;
CENTURY : C E N T U R Y;
CHARACTER : C H A R A C T E R;
CHECK: C H E C K;
CLUSTER: C L U S T E R;
COLLECT : C O L L E C T;
COALESCE : C O A L E S C E;
COLUMN : C O L U M N;
COMMENT: C O M M E N T;
COMMENTS: COMMENT S;
COMMIT: C O M M I T;
CONFIGURATION: C O N F I G U R A T I O N;
COST: C O S T;
COUNT : C O U N T;
CUBE : C U B E;
CURRENT: C U R R E N T;
CYCLE: C Y C L E;

DATA: D A T A;
DAY : D A Y;
DEC : D E C;
DECADE : D E C A D E;
DEFINER: D E F I N E R;
DICTIONARY: D I C T I O N A R Y;
DISABLE: D I S A B L E;
DOW : D O W;
DOY : D O Y;
DROP : D R O P;

ENABLE: E N A B L E;
EPOCH : E P O C H;
EVENT: E V E N T;
EVERY : E V E R Y;
EXISTS : E X I S T S;
EXTENDED: E X T E N D E D;
EXTERNAL : E X T E R N A L;
EXTRACT : E X T R A C T;

FAMILY: F A M I L Y;
FILTER : F I L T E R;
FIRST : F I R S T;
FORMAT : F O R M A T;
FUSION : F U S I O N;

GROUPING : G R O U P I N G;

HASH : H A S H;
HOUR : H O U R;

INHERIT: I N H E R I T;
INDEX : I N D E X;
INDEXES: INDEX E S;
INCREMENT: I N C R E M E N T;
INPUT: I N P U T;
INSERT : I N S E R T;
INTERSECTION : I N T E R S E C T I O N;
ISCACHABLE: I S C A C H A B L E;
ISODOW : I S O D O W;
ISOYEAR : I S O Y E A R;
ISSTRICT: I S S T R I C T;

LANGUAGE: L A N G U A G E;
LARGE: L A R G E;
LAST : L A S T;
LESS : L E S S;
LIST : L I S T;
LOCATION : L O C A T I O N;

MAIN:M A I N;
MATCH: M A T C H;
MAX : M A X;
MAXVALUE : M A X V A L U E;
MICROSECONDS : M I C R O S E C O N D S;
MILLENNIUM : M I L L E N N I U M;
MILLISECONDS : M I L L I S E C O N D S;
MIN : M I N;
MINVALUE: MIN V A L U E;
MINUTE : M I N U T E;
MONTH : M O N T H;

NATIONAL : N A T I O N A L;
NO: N O;
NONE: NO N E;
NULLIF : N U L L I F;
N_DISTINCT: N UNDERLINE DISTINCT;
N_DISTINCT_INHERITED: N UNDERLINE DISTINCT UNDERLINE I N H E R I T E D;

OBJECT: O B J E C T;
ON : O N;
ONLY: O N L Y;
OPTION: O P T I O N;
OPTIONS: OPTION S;
OVERWRITE : O V E R W R I T E;

PARSER: P A R S E R;
PARTIAL: P A R T I A L;
PARTITION : P A R T I T I O N;
PARTITIONS : P A R T I T I O N S;
PLAIN: P L A I N;
PRECISION : P R E C I S I O N;
PUBLIC: P U B L I C;
PURGE : P U R G E;

QUARTER : Q U A R T E R;

RANGE : R A N G E;
REGEXP : R E G E X P;
RENAME: R E N A M E;
REPLICA: R E P L I C A;
RESET: R E S E T;
RLIKE : R L I K E;
ROLLUP : R O L L U P;

SEARCH: S E A R C H;
SECOND : S E C O N D;
SECURITY: S E C U R I T Y;
SERVER: S E R V E R;
SET : S E T;
SIMILAR : S I M I L A R;
SIMPLE: S I M P L E;
STABLE: S T A B L E;
START: S T A R T;
STATISTICS: S T A T I S T I C S;
STORAGE: S T O R A G E;
STDDEV_POP : S T D D E V UNDERLINE P O P;
STDDEV_SAMP : S T D D E V UNDERLINE S A M P;
SUBPARTITION : S U B P A R T I T I O N;
SUM : S U M;

TABLESPACE : T A B L E S P A C E;
TABLES: T A B L E S;
TEMPLATE: T E M P L A T E;
THAN : T H A N;
TIMEZONE: T I M E Z O N E;
TIMEZONE_HOUR: T I M E Z O N E UNDERLINE H O U R;
TIMEZONE_MINUTE: T I M E Z O N E UNDERLINE M I N U T E;
TRIM : T R I M;
TO : T O;
TYPE: T Y P E;
TYPES: TYPE S;

UNKNOWN : U N K N O W N;
UNLOGGED: U N L O G G E D;
USER: U S E R;

VALID: V A L I D;
VALIDATE: V A L I D A T E;
VALUES : V A L U E S;
VAR_SAMP : V A R UNDERLINE S A M P;
VAR_POP : V A R UNDERLINE P O P;
VARYING : V A R Y I N G;
VERSION: V E R S I O N;
VOLATILE: V O L A T I L E;

WEEK : W E E K;
WINDOW: W I N D O W;
WRAPPER: W R A P P E R;

YEAR : Y E A R;

ZONE : Z O N E;


/*
===============================================================================
  Data Type Tokens
===============================================================================
*/
BOOLEAN : B O O L E A N;
BOOL : B O O L;
BIT : B I T;
VARBIT : V A R B I T;

INT1 : I N T '1';
INT2 : I N T '2';
INT4 : I N T '4';
INT8 : I N T '8';

TINYINT : T I N Y I N T; // alias for INT1
SMALLINT : S M A L L I N T; // alias for INT2
INT : I N T; // alias for INT4
INTEGER : I N T E G E R; // alias - INT4
BIGINT : B I G I N T; // alias for INT8

FLOAT4 : F L O A T '4';
FLOAT8 : F L O A T '8';

REAL : R E A L; // alias for FLOAT4
REGCLASS: R E G C L A S S;
FLOAT : F L O A T; // alias for FLOAT8
DOUBLE : D O U B L E; // alias for FLOAT8

NUMERIC : N U M E R I C;
DECIMAL : D E C I M A L; // alias for number

CHAR : C H A R;
VARCHAR : V A R C H A R;
NCHAR : N C H A R;
NVARCHAR : N V A R C H A R;

DATE : D A T E;
TIME : T I M E;
TIMETZ : T I M E T Z;
TIMESTAMP : T I M E S T A M P;
TIMESTAMPTZ : T I M E S T A M P T Z;

TEXT : T E X T;

UUID: U U I D;

BINARY : B I N A R Y;
VARBINARY : V A R B I N A R Y;
BLOB : B L O B;
BYTEA : B Y T E A; // alias for BLOB

INET4 : I N E T '4';

INTERVAL: I N T E R V A L;
VOID: V O I D;

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
QUOTE : '\'';
DOUBLE_QUOTE : '"';
DOLLAR: '$';
DOUBLE_DOLLAR: '$$';
DOUBLE_UNDER_DOLLAR: '$_$';

NUMBER : Digit+;

fragment
Digit : '0'..'9';

REAL_NUMBER
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

BlockComment
    :   '/*' .*? '*/' -> skip
    ;

LineComment
    :   '--' ~[\r\n]* -> skip
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
  : QUOTE ( ESC_SEQ | ~('\\'|'\'') )* QUOTE
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
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
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


/*
===============================================================================
 Whitespace Tokens
===============================================================================
*/

Space
  : ' ' -> skip
  ;

White_Space
  :	( Control_Characters  | Extended_Control_Characters )+ -> skip
  ;


BAD
  : . -> skip
  ;
