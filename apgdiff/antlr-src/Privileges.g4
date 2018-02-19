grammar Privileges;

options {
    language=Java;
}
@header {package cz.startnet.utils.pgdiff.parsers.antlr;}

privileges : '{' acls+=privilege (COMMA acls+=privilege)* '}' EOF;
  
privilege
  : name=Identifier? priv=Privileges grantor=Identifier  
  | QUOTE_CHAR qname=identifier? priv=Privileges qgrantor=identifier QUOTE_CHAR
  ;

identifier : (Identifier | QuotedIdentifier);  
   
COMMA: ',';
QUOTE_CHAR : '"';

// consume terminator chars to distinct this token from an Indentifier
// strip terminators for getText()
Privileges : '=' ([acdrtxwCDTUX] '*'?)+ '/'
    {
        String __tx = getText();
        setText(__tx.substring(1, __tx.length() - 1));
    };

Identifier: [a-zA-Z_0-9]+;
    
QuotedIdentifier
    : '\\"' UnterminatedQuotedIdentifier '\\"'
    // unquote so that we may always call getText() and not worry about quotes
        {
            String __tx = getText();
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