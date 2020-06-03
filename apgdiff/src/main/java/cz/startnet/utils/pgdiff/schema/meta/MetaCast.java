package cz.startnet.utils.pgdiff.schema.meta;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.ICast;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MetaCast extends MetaStatement implements ICast {

    private static final long serialVersionUID = -23317544341299716L;

    private final String source;
    private final String target;

    private final CastContext context;

    public MetaCast(String source, String target, CastContext context) {
        super(new GenericColumn(ICast.getSimpleName(source, target), DbObjType.CAST));
        this.source = source;
        this.target = target;
        this.context = context;
    }

    public MetaCast(String source, String target, CastContext context, PgObjLocation object) {
        super(object);
        this.source = source;
        this.target = target;
        this.context = context;
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


    @Override
    public MetaStatement getCopy() {
        return new MetaCast(source, target, context, getObject());
    }
}
