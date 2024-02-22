lexer grammar CHLexer;
@header {package ru.taximaxim.codekeeper.core.parsers.antlr.generated;}

// NOTE: don't forget to add new keywords to the parser rule "keyword"!


// case sensitive data types

AGGREGATE_FUNCTION: 'Simple'? 'AggregateFunction';
// ARRAY_TYPE: 'Array';
ENUM: 'Enum' ('8'|'16') | E N U M;
FIXED_STRING: 'FixedString';
FLOAT: 'Float' ('32' | '64') | F L O A T;
INT_TYPE: 'U'? 'Int' ('8' | '16' | '32' | '64' | '128' | '256');
IPV4: 'IPv4' | I N E T '4';
IPV6: 'IPv6' | I N E T '6';
LOW_CARDINALITY: 'LowCardinality';
MAP: 'Map';
MULTI_POLYGON: 'MultiPolygon';
NESTED: 'Nested';
NOTHING: 'Nothing';
NULLABLE: 'Nullable';
OBJECT_TYPE: 'Object';
POINT: 'Point';
POLYGIN: 'Polygon';
RING: 'Ring';
STRING: 'String';
TUPLE: 'Tuple';
// UUID_TYPE: 'UUID';
INTERVAL_TYPE
    : 'IntervalDay'
    | 'IntervalHour'
    | 'IntervalMicrosecond'
    | 'IntervalMillisecond'
    | 'IntervalMinute'
    | 'IntervalMonth'
    | 'IntervalNanosecond'
    | 'IntervalQuarter'
    | 'IntervalSecond'
    | 'IntervalWeek'
    | 'IntervalYear'
    ;

// Keywords

ADD: A D D;
AFTER: A F T E R;
ALIAS: A L I A S;
ALL: A L L;
ALTER: A L T E R;
AND: A N D;
ANTI: A N T I;
ANY: A N Y;
APPLY: A P P L Y;
ARRAY: A R R A Y;
AS: A S;
ASCENDING: A S C | A S C E N D I N G;
ASOF: A S O F;
ASSUME: A S S U M E;
AST: A S T;
ASYNC: A S Y N C;
ATTACH: A T T A C H;
AUTO_INCREMENT: A U T O '_' I N C R E M E N T;
BEGIN: B E G I N;
BETWEEN: B E T W E E N;
BIGINT: B I G I N T;
BINARY: B I N A R Y;
BIT: B I T;
BLOB: B L O B;
BOOLEAN: B O O L (E A N)?;
BOTH: B O T H;
BY: B Y;
BYTE: B Y T E;
BYTEA: B Y T E A;
CASE: C A S E;
CAST: C A S T;
CHAR: C H A R;
CHARACTER: C H A R A C T E R;
CHECK: C H E C K;
CLEAR: C L E A R;
CLOB: C L O B;
CLUSTER: C L U S T E R;
CODEC: C O D E C;
COLLATE: C O L L A T E;
COLLECTION: C O L L E C T I O N;
COLUMN: C O L U M N;
COLUMNS: C O L U M N S;
COMMENT: C O M M E N T;
COMMIT: C O M M I T;
CONSTRAINT: C O N S T R A I N T;
CREATE: C R E A T E;
CROSS: C R O S S;
CUBE: C U B E;
CURRENT: C U R R E N T;
DATABASE: D A T A B A S E;
DATABASES: D A T A B A S E S;
DATE: D A T E '32'?;
DATETIME64: D A T E T I M E '64';
DATETIME: D A T E T I M E '32'?;
DAY: D A Y;
DECIMAL: D E C (I M A L)?;
DECIMAL_BIT: D E C I M A L ('8' | '16' | '32' | '64' | '128' | '256');
DEDUPLICATE: D E D U P L I C A T E;
DEFAULT: D E F A U L T;
DELAY: D E L A Y;
DELETE: D E L E T E;
DELETED: D E L E T E D;
DESC: D E S C;
DESCENDING: D E S C E N D I N G;
DESCRIBE: D E S C R I B E;
DETACH: D E T A C H;
DETACHED: D E T A C H E D;
DICTIONARIES: D I C T I O N A R I E S;
DICTIONARY: D I C T I O N A R Y;
DISK: D I S K;
DISTINCT: D I S T I N C T;
DISTRIBUTED: D I S T R I B U T E D;
DOUBLE: D O U B L E;
DROP: D R O P;
ELSE: E L S E;
EMPTY: E M P T Y;
END: E N D;
ENGINE: E N G I N E;
EPHEMERAL: E P H E M E R A L;
EVENTS: E V E N T S;
EXCEPT: E X C E P T;
EXISTS: E X I S T S;
EXPLAIN: E X P L A I N;
EXPRESSION: E X P R E S S I O N;
EXTRACT: E X T R A C T;
FETCH: F E T C H;
FETCHES: F E T C H E S;
FILL: F I L  L;
FINAL: F I N A L;
FIRST: F I R S T;
FIXED: F I X E D;
FLUSH: F L U S H;
FOLLOWING: F O L L O W I N G;
FOR: F O R;
FORMAT: F O R M A T;
FREEZE: F R E E Z E;
FROM: F R O M;
FULL: F U L L;
FUNCTION: F U N C T I O N;
GEOMETRY: G E O M E T R Y;
GLOBAL: G L O B A L;
GRANULARITY: G R A N U L A R I T Y;
GROUP: G R O U P;
GROUPING: G R O U P I N G;
HAVING: H A V I N G;
HIERARCHICAL: H I E R A R C H I C A L;
HOUR: H O U R;
ID: I D;
IF: I F;
ILIKE: I L I K E;
IN: I N;
INDEX: I N D E X;
INF: I N F | I N F I N I T Y;
INJECTIVE: I N J E C T I V E;
INNER: I N N E R;
INSERT: I N S E R T;
INT: I N T '1'?;
INTEGER: I N T E G E R;
INTERPOLATE: I N T E R P O L A T E;
INTERVAL: I N T E R V A L;
INTO: I N T O;
IS: I S;
IS_OBJECT_ID: I S UNDERSCORE O B J E C T UNDERSCORE I D;
JOIN: J O I N;
JSON: J S O N;
KEY: K E Y;
KILL: K I L L;
LARGE: L A R G E;
LAST: L A S T;
LAYOUT: L A Y O U T;
LEADING: L E A D I N G;
LEFT: L E F T;
LIFETIME: L I F E T I M E;
LIKE: L I K E;
LIMIT: L I M I T;
LIVE: L I V E;
LOCAL: L O C A L;
LOGS: L O G S;
LONGBLOB: L O N G B L O B;
LONGTEXT: L O N G T E X T;
MASK: M A S K;
MATERIALIZE: M A T E R I A L I Z E;
MATERIALIZED: M A T E R I A L I Z E D;
MAX: M A X;
MEDIUMBLOB: M E D I U M B L O B;
MEDIUMINT: M E D I U M I N T;
MEDIUMTEXT: M E D I U M T E X T;
MERGES: M E R G E S;
MIN: M I N;
MINUTE: M I N U T E;
MODIFY: M O D I F Y;
MONTH: M O N T H;
MOVE: M O V E;
MUTATION: M U T A T I O N;
NAME: N A M E;
NAMED: N A M E D;
NAN: N A N;
NATIONAL: N A T I O N A L;
NCHAR: N C H A R;
NO: N O;
NOT: N O T;
NULL: N U L L;
NULLS: N U L L S;
NUMERIC: N U M E R I C;
NVARCHAR: N V A R C H A R;
OBJECT: O B J E C T;
OFFSET: O F F S E T;
ON: O N;
OPTIMIZE: O P T I M I Z E;
OR: O R;
ORDER: O R D E R;
OUTER: O U T E R;
OUTFILE: O U T F I L E;
OVER: O V E R;
OVERRIDABLE: O V E R R I D A B L E;
PART: P A R T;
PARTITION: P A R T I T I O N;
PERMISSIVE: P E R M I S S I V E;
POLICY: P O L I C Y;
POPULATE: P O P U L A T E;
PRECEDING: P R E C E D I N G;
PRECISION: P R E C I S I O N;
PREWHERE: P R E W H E R E;
PRIMARY: P R I M A R Y;
PROJECTION: P R O J E C T I O N;
QUARTER: Q U A R T E R;
QUERY: Q U E R Y;
RANGE: R A N G E;
REAL: R E A L;
RECOMPRESS: R E C O M P R E S S;
RELOAD: R E L O A D;
REMOVE: R E M O V E;
RENAME: R E N A M E;
REPLACE: R E P L A C E;
REPLICA: R E P L I C A;
REPLICATED: R E P L I C A T E D;
RESET: R E S E T;
RESTRICTIVE: R E S T R I C T I V E;
RIGHT: R I G H T;
ROLLBACK: R O L L B A C K;
ROLLUP: R O L L U P;
ROW: R O W;
ROWS: R O W S;
SAMPLE: S A M P L E;
SECOND: S E C O N D;
SELECT: S E L E C T;
SEMI: S E M I;
SENDS: S E N D S;
SET: S E T;
SETS: S E T S;
SETTING: S E T T I N G;
SETTINGS: S E T T I N G S;
SHOW: S H O W;
SIGNED: S I G N E D;
SINGLE: S I N G L E;
SMALLINT: S M A L L I N T;
SOURCE: S O U R C E;
START: S T A R T;
STATISTIC: S T A T I S T I C;
STEP: S T E P;
STOP: S T O P;
SUBSTRING: S U B S T R I N G;
SYNC: S Y N C;
SYNTAX: S Y N T A X;
SYSTEM: S Y S T E M;
TABLE: T A B L E;
TABLES: T A B L E S;
TEMPORARY: T E M P O R A R Y;
TEST: T E S T;
TEXT: T E X T;
THEN: T H E N;
TIES: T I E S;
TIME: T I M E;
TIMEOUT: T I M E O U T;
TIMESTAMP: T I M E S T A M P;
TINYBLOB: T I N Y B L O B;
TINYINT: T I N Y I N T;
TINYTEXT: T I N Y T E X T;
TO: T O;
TOP: T O P;
TOTALS: T O T A L S;
TRAILING: T R A I L I N G;
TRANSACTION: T R A N S A C T I O N;
TRIM: T R I M;
TRUNCATE: T R U N C A T E;
TTL: T T L;
TYPE: T Y P E;
UNBOUNDED: U N B O U N D E D;
UNFREEZE: U N F R E E Z E;
UNION: U N I O N;
UNSIGNED: U N S I G N E D;
UPDATE: U P D A T E;
USE: U S E;
USING: U S I N G;
UUID: U U I D;
VALUES: V A L U E S;
VARBINARY: V A R B I N A R Y;
VARCHAR: V A R C H A R '2'?;
VARYING: V A R Y I N G;
VIEW: V I E W;
VOLUME: V O L U M E;
WATCH: W A T C H;
WEEK: W E E K;
WHEN: W H E N;
WHERE: W H E R E;
WINDOW: W I N D O W;
WITH: W I T H;
YEAR: Y E A R | Y Y Y Y;

// Tokens

OCTAL_LITERAL: '0' OCT_DIGIT+;
DECIMAL_LITERAL: DEC_DIGIT+;
HEXADECIMAL_LITERAL: '0' X HEX_DIGIT+;

IDENTIFIER
    : (LETTER | UNDERSCORE | DEC_DIGIT)+
    | BACKQUOTE ( ~([\\`]) | (BACKSLASH .) | (BACKQUOTE BACKQUOTE) )* BACKQUOTE
    | QOUTED_IDENTIFIER
    ;

/* Quoted Identifiers
*
* These are divided into four separate tokens, allowing distinction of valid quoted identifiers from invalid quoted
* identifiers without sacrificing the ability of the lexer to reliably recover from lexical errors in the input.
*/
QOUTED_IDENTIFIER
    : UNTERMINATED_QOUTED_IDENTIFIER '"'
    // unquote so that we may always call getText() and not worry about quotes
        {
            String __tx = getText();
            setText(__tx.substring(1, __tx.length() - 1).replace("\"\"", "\""));
        }
    ;

// This is a quoted identifier which only contains valid characters but is not terminated
fragment UNTERMINATED_QOUTED_IDENTIFIER
    : '"' ( '""' | ~[\u0000"] )*
    ;

FLOATING_LITERAL
    : HEXADECIMAL_LITERAL DOT HEX_DIGIT* (P | E) (PLUS | MINUS)? DEC_DIGIT+
    | HEXADECIMAL_LITERAL (P | E) (PLUS | MINUS)? DEC_DIGIT+
    | DECIMAL_LITERAL DOT DEC_DIGIT* E (PLUS | MINUS)? DEC_DIGIT+
    | DOT DECIMAL_LITERAL E (PLUS | MINUS)? DEC_DIGIT+
    | DECIMAL_LITERAL E (PLUS | MINUS)? DEC_DIGIT+
    ;

// It's important that quote-symbol is a single character.
STRING_LITERAL: QUOTE_SINGLE ( ~([\\']) | (BACKSLASH .) | (QUOTE_SINGLE QUOTE_SINGLE) )* QUOTE_SINGLE;

// Alphabet and allowed symbols

fragment A: [aA];
fragment B: [bB];
fragment C: [cC];
fragment D: [dD];
fragment E: [eE];
fragment F: [fF];
fragment G: [gG];
fragment H: [hH];
fragment I: [iI];
fragment J: [jJ];
fragment K: [kK];
fragment L: [lL];
fragment M: [mM];
fragment N: [nN];
fragment O: [oO];
fragment P: [pP];
fragment Q: [qQ];
fragment R: [rR];
fragment S: [sS];
fragment T: [tT];
fragment U: [uU];
fragment V: [vV];
fragment W: [wW];
fragment X: [xX];
fragment Y: [yY];
fragment Z: [zZ];

fragment LETTER: [a-zA-Z];
fragment OCT_DIGIT: [0-7];
fragment DEC_DIGIT: [0-9];
fragment HEX_DIGIT: [0-9a-fA-F];

ARROW: '->';
ASTERISK: '*';
BACKQUOTE: '`';
BACKSLASH: '\\';
COLON: ':';
COMMA: ',';
CONCAT: '||';
MINUS: '-';
DOT: '.';
EQ_DOUBLE: '==';
EQ_SINGLE: '=';
GE: '>=';
GT: '>';
LBRACE: '{';
LBRACKET: '[';
LE: '<=';
LPAREN: '(';
LT: '<';
NOT_EQ: '!=' | '<>';
PERCENT: '%';
PLUS: '+';
QUESTION: '?';
QUOTE_DOUBLE: '"';
QUOTE_SINGLE: '\'';
RBRACE: '}';
RBRACKET: ']';
RPAREN: ')';
SEMICOLON: ';';
SLASH: '/';
UNDERSCORE: '_';
CAST_EXPRESSION: ':'':';

BOM: '\ufeff';

// Comments and whitespace

MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip;
SINGLE_LINE_COMMENT: '--' ~('\n'|'\r')* ('\n' | '\r' | EOF) -> skip;
WHITESPACE: [ \u000B\u000C\t\r\n] -> skip;  // '\n' can be part of multiline single query