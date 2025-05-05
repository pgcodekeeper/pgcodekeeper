parser grammar PrivilegesParser;

options {
    language=Java;
    tokenVocab=PrivilegesLexer;
}
@header {package ru.taximaxim.codekeeper.core.parsers.antlr.generated;}

privileges : LEFT_CURLY_BRACE acls+=privilege (COMMA acls+=privilege)* RIGHT_CURLY_BRACE EOF;
  
privilege
  : name=Identifier? priv=Privileges grantor=Identifier  
  | QUOTE_CHAR qname=identifier? priv=Privileges qgrantor=identifier QUOTE_CHAR
  ;

identifier : (Identifier | QuotedIdentifier);  
