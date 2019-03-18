package cz.startnet.utils.pgdiff.schema;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class AbstractType extends PgStatementWithSearchPath {

    public AbstractType(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.TYPE;
    }

    @Override
    public AbstractType shallowCopy() {
        AbstractType typeDst = getTypeCopy();
        copyBaseFields(typeDst);
        return typeDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        return this == obj || obj instanceof AbstractType && super.compare(obj);
    }

    protected abstract AbstractType getTypeCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) this.getParent();
    }
}
