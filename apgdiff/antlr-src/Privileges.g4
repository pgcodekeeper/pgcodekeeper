grammar Privileges;

options {
    language=Java;
}
@header {package cz.startnet.utils.pgdiff.parsers.antlr;}

privileges : '{' acls+=privilege (COMMA acls+=privilege)* '}' EOF;
  
privilege
  : name=Identifier? EQUAL priv=Privileges SLASH grantor=Identifier  
  | QUOTE_CHAR qname=identifier? EQUAL priv=Privileges SLASH qgrantor=identifier QUOTE_CHAR
  ;

identifier : (Identifier | QuotedIdentifier);  
   
COMMA: ','; 
SLASH: '/';
EQUAL: '=';
QUOTE_CHAR : '"';

Privileges : ([acdrtxwCDTUX] '*'?)+ ;

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