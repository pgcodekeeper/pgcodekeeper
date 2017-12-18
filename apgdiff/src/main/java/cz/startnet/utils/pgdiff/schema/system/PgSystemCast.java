package cz.startnet.utils.pgdiff.schema.system;

import java.io.Serializable;

public class PgSystemCast implements Serializable {

    private static final long serialVersionUID = -5461313864086677218L;

    private final String source;
    private final String target;
    /**
     * Indicates what contexts the cast can be invoked in. <br><br>
     * <b>e</b> means only as an explicit cast (using CAST or :: syntax).<br>
     * <b>a</b> means implicitly in assignment to a target column, as well as explicitly.<br>
     * <b>i</b> means implicitly in expressions, as well as the other cases.<br>
     */
    private final String type;

    public PgSystemCast(String source, String target, String type) {
        this.source = source;
        this.target = target;
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    /**
     *  Returns the {@link cz.startnet.utils.pgdiff.schema.system.PgSystemCast#type context of the cast}.
     */
    public String getType() {
        return type;
    }
}

/**
 *  {@link cz.startnet.utils.pgdiff.schema.system.PgSystemCast#type Context of the cast}.
 */
class CastContext {
    public static final String E = "e";
    public static final String A = "a";
    public static final String I = "i";

    private CastContext() {
    }
}