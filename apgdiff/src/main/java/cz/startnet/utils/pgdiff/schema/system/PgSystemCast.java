package cz.startnet.utils.pgdiff.schema.system;

import java.io.Serializable;

public class PgSystemCast implements Serializable {

    private static final long serialVersionUID = -5461313864086677218L;

    private final String source;
    private final String target;

    private final CastContext context;

    public PgSystemCast(String source, String target, CastContext type) {
        this.source = source;
        this.target = target;
        this.context = type;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public CastContext getContext() {
        return context;
    }
}