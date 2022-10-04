package ru.taximaxim.codekeeper.core.schema.meta;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ICast;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class MetaCast extends MetaStatement implements ICast {

    private static final long serialVersionUID = 3309369936371201302L;

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
}
