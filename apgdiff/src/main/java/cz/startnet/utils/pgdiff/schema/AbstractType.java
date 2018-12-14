package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class AbstractType extends PgStatementWithSearchPath {

    public AbstractType(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.TYPE;
    }

    @Override
    public AbstractType shallowCopy() {
        AbstractType copy = getTypeCopy();
        copy.setOwner(getOwner());
        copy.grants.addAll(grants);
        copy.revokes.addAll(revokes);
        copy.setComment(getComment());
        copy.deps.addAll(deps);
        copy.setLocation(getLocation());
        return copy;
    }

    @Override
    public AbstractType deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractType) {
            AbstractType type = (AbstractType) obj;

            return Objects.equals(name, type.getName())
                    && Objects.equals(owner, type.getOwner())
                    && grants.equals(type.grants)
                    && revokes.equals(type.revokes)
                    && Objects.equals(comment, type.getComment());
        }

        return false;
    }

    protected abstract AbstractType getTypeCopy();

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(owner);
        hasher.putUnordered(grants);
        hasher.putUnordered(revokes);
        hasher.put(comment);
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) this.getParent();
    }
}
