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

grammar SQLWIgnore;

options {
    language=Java;
}

@header {package ru.taximaxim.codekeeper.ui.antlr;}

compileUnit
    :   expr EOF
    ;
    
expr
	: white
	| black
	;
	
black: show_all hide_rule*;
		
hide_rule: HIDE flags identifier;

show_rule: SHOW flags identifier;

white: hide_all show_rule*;

flag: CONTENT | REGEX | NONE;

show_all: SHOW ALL;

hide_all: HIDE ALL;

flags: flag (COMMA flag)*;

//expr
/*     :   '(' expr ')'                         # parensExpr
    |   op=('+'|'-') expr                    # unaryExpr
    |   left=expr op=('*'|'/') right=expr    # infixExpr
    |   left=expr op=('+'|'-') right=expr    # infixExpr
    |   func=ID '(' expr ')'                 # funcExpr
    |   value=NUM                            # numberExpr
    ;*/
    
ALL: [aA] [lL] [lL];
HIDE: [hH] [iI] [dD] [eE];
SHOW: [sS] [hH] [oO] [wW];
CONTENT: 'CONTENT';
REGEX: 'REGEX';
NONE: 'NONE';

/*OP_ADD: '+';
OP_SUB: '-';
OP_MUL: '*';
OP_DIV: '/';*/

COMMA: ',';
DOT: '.';
WS  :   [ \t\r\n] -> channel(HIDDEN);
BAD
  : . -> channel(HIDDEN)
  ;


schema_qualified_name
  : identifier ( DOT identifier ( DOT identifier )? )?
  ;

identifier
  : Identifier
  | QuotedIdentifier
  ;


/*
===============================================================================
 Identifiers
===============================================================================
*/

Identifier
    : [a-zA-Z_] [a-zA-Z_0-9]*
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
