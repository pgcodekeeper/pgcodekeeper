grammar IgnoreList;

options {
    language=Java;
}
@header {package cz.startnet.utils.pgdiff.parsers.antlr;}

compileUnit: NewLine* rule_list NewLine* EOF;
rule_list: white | black;

white: HIDE ALL (NewLine+ show_rule)*;
black: SHOW ALL (NewLine+ hide_rule)*;

hide_rule: HIDE rule_rest;
show_rule: SHOW rule_rest;
rule_rest: flags obj=identifier (DB db=identifier)?;

flags: flag (COMMA flag)*;
flag: CONTENT | REGEX | NONE;

identifier: Identifier | SQstring | DQstring;

HIDE: 'HIDE';
SHOW: 'SHOW';
ALL: 'ALL';
CONTENT: 'CONTENT';
REGEX: 'REGEX';
NONE: 'NONE';
DB: 'db=';

Identifier: [a-zA-Z_] [a-zA-Z_0-9]*;
SQstring: '\'' ( ~('\'' | [\r\n]) | '\'\'' )* '\'' {
    String __tx = getText();
    setText(__tx.substring(1, __tx.length() - 1).replace("''", "'"));
};
DQstring:  '"' ( ~["\r\n] | '""' )* '"' {
    String __tx = getText();
    setText(__tx.substring(1, __tx.length() - 1).replace("\"\"", "\""));
};

COMMA: ',';
NewLine: [\r\n]+;

COMMENT: '#' ~[\r\n]* -> skip;
WS: [ \t] -> skip;
BAD: .;
