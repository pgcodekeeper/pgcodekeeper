package cz.startnet.utils.pgdiff.schema.system;

/**
 *  {@link cz.startnet.utils.pgdiff.schema.system.PgSystemCast#type Context of the cast}.
 */
public enum CastContext {
    E("e"),
    A("a"),
    I("i");

    String type;

    CastContext(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    public boolean checkCast(String type) {
        return this.type.equals(type);
    }
}
