package cz.startnet.utils.pgdiff.schema.system;

/**
 * Indicates what contexts the cast can be invoked in. <br><br>
 * <b>E</b> means only as an explicit cast (using CAST or :: syntax).<br>
 * <b>A</b> means implicitly in assignment to a target column, as well as explicitly.<br>
 * <b>I</b> means implicitly in expressions, as well as the other cases.<br>
 */
public enum CastContext {
    E("e"),
    A("a"),
    I("i");

    private String type;

    CastContext(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    public static CastContext getEnumByValue(String stringType) {
        for (CastContext castContext : CastContext.values()) {
            if (stringType.equals(castContext.toString())) {
                return castContext;
            }
        }
        return null;
    }
}
