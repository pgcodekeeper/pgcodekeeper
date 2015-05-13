package ru.taximaxim.codekeeper.apgdiff.model.difftree;

/**
 * Типы объектов в базе <br>
 * ! Внимание, порядок обозначенный здесь используется при построении списка
 * объектов для наката
 * {@link CompareTree}
 */
public enum DbObjType {
    DATABASE,
    SCHEMA,
    EXTENSION,
    TYPE,
    DOMAIN,
    SEQUENCE,
    TABLE,
    COLUMN,
    FUNCTION,
    CONSTRAINT,  
    INDEX,
    TRIGGER,
    VIEW
}