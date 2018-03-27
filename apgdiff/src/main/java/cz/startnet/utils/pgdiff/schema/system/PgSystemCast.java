package cz.startnet.utils.pgdiff.schema.system;

import java.io.Serializable;

public class PgSystemCast implements Serializable {

    private static final long serialVersionUID = -5461313864086677218L;

    private final String source;
    private final String target;

    /**
     *  {@link cz.startnet.utils.pgdiff.schema.system.CastContext Context of the cast}.
     */
    private final CastContext type;

    public PgSystemCast(String source, String target, CastContext type) {
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
    public CastContext getType() {
        return type;
    }
}