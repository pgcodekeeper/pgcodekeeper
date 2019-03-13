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
    ASSEMBLY,
    SCHEMA,
    EXTENSION,
    TYPE,
    DOMAIN,
    SEQUENCE,
    // TODO workaround for function call dependencies from COLUMN DEFAULT
    // maybe move back after COLUMN, when proper function call dependencies are implemented
    // see test case PgDiffTest#177 (tabl_to_func)
    FUNCTION,
    PROCEDURE,
    AGGREGATE,
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