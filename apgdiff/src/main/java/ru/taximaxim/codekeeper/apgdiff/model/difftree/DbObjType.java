package ru.taximaxim.codekeeper.apgdiff.model.difftree;

/**
 * Типы объектов в базе <br>
 * ! Внимание, порядок обозначенный здесь используется при построении списка
 * объектов для наката
 * {@link CompareTree}
 */
public enum DbObjType {
    DATABASE(512), SCHEMA(1024), EXTENSION(11), TYPE(128), DOMAIN(10), SEQUENCE(256),
    // TODO workaround for function call dependencies from COLUMN DEFAULT
    // maybe move back after COLUMN, when proper function call dependencies are implemented
    FUNCTION(32), TABLE(1), COLUMN(2048), CONSTRAINT(64), INDEX(4), TRIGGER(8), VIEW(2), RULE(16);

    private int mask;

    DbObjType(int mask) {
        this.mask = mask;
    }

    public int getMask() {
        return mask;
    }
}