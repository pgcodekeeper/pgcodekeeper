package cz.startnet.utils.pgdiff.schema.system;

import cz.startnet.utils.pgdiff.schema.ICast;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemCast extends PgSystemStatement implements ICast {

    private static final long serialVersionUID = -5461313864086677218L;

    private final String source;
    private final String target;

    private final CastContext context;

    public PgSystemCast(String source, String target, CastContext type) {
        super(ICast.getSimpleName(source, target), DbObjType.CAST);
        this.source = source;
        this.target = target;
        this.context = type;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public CastContext getContext() {
        return context;
    }
}