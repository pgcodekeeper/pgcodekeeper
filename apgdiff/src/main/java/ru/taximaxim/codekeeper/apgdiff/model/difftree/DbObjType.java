package ru.taximaxim.codekeeper.apgdiff.model.difftree;

/**
 * Типы объектов в базе <br>
 * ! Внимание, порядок обозначенный здесь используется при построении списка
 * объектов для наката
 * {@link CompareTree}
 */
public enum DbObjType {
    DATABASE,
    USER,
    ROLE,
    SCHEMA,
    EXTENSION,
    TYPE,
    DOMAIN,
    SEQUENCE,
    ASSEMBLY,
    // TODO workaround for function call dependencies from COLUMN DEFAULT
    // maybe move back after COLUMN, when proper function call dependencies are implemented
    FUNCTION,
    PROCEDURE,
    OPERATOR,
    FTS_PARSER,
    FTS_TEMPLATE,
    FTS_DICTIONARY,
    FTS_CONFIGURATION,
    TABLE,
    COLUMN,
    CONSTRAINT,
    INDEX,
    VIEW,
    TRIGGER,
    RULE
}