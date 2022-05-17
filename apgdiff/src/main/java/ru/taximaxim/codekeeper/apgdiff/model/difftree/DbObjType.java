package ru.taximaxim.codekeeper.apgdiff.model.difftree;

/**
 * Типы объектов в базе <br>
 * ! Внимание, порядок обозначенный здесь используется при построении списка
 * объектов для наката
 * {@link CompareTree}
 */
public enum DbObjType {
    DATABASE,
    CAST,
    USER,
    ROLE,
    ASSEMBLY,
    SCHEMA,
    EXTENSION,
    FOREIGN_DATA_WRAPPER,
    SERVER,
    USER_MAPPING,
    TYPE,
    DOMAIN,
    SEQUENCE,
    OPERATOR,
    FTS_PARSER,
    FTS_TEMPLATE,
    FTS_DICTIONARY,
    FTS_CONFIGURATION,
    TABLE,
    COLUMN,
    FUNCTION,
    PROCEDURE,
    AGGREGATE,
    INDEX,
    CONSTRAINT,
    VIEW,
    TRIGGER,
    RULE,
    POLICY
}