lexer grammar PrivilegesLexer;

options {
    superClass = CodeUnitLexer;
}

@header {
package ru.taximaxim.codekeeper.core.parsers.antlr.generated;

import ru.taximaxim.codekeeper.core.parsers.antlr.CodeUnitLexer;
}

COMMA: ',';
QUOTE_CHAR : '"';
LEFT_CURLY_BRACE: '{';
RIGHT_CURLY_BRACE: '}';

// consume terminator chars to distinct this token from an Indentifier
// strip terminators for getText()
Privileges: '=' ([acdmrtxwCDTUX] '*'?)+ '/' { removeQuotes();};
Identifier: [a-zA-Z_0-9]+;

QuotedIdentifier
    : '\\"' UnterminatedQuotedIdentifier '\\"'
    // unquote so that we may always call getText() and not worry about quotes
        {
            String __tx = getText();
            calculateOffset(__tx);
            setText(__tx.substring(2, __tx.length() - 2)
                        .replace("\\\"\\\"", "\"")
                        .replace("\\\\", "\\")
            );
        }
    ;

fragment UnterminatedQuotedIdentifier
    :
    ( '\\"\\"'
    | '\\\\'
    | ~["\\]
    )*
    ;