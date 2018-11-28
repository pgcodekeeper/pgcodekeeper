package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores trigger information.
 */
public abstract class AbstractTrigger extends PgStatementWithSearchPath {

    private final String tableName;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.TRIGGER;
    }

    public AbstractTrigger(String name, String tableName) {
        super(name);
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof AbstractTrigger) {
            AbstractTrigger trigger = (AbstractTrigger) obj;
            eq = compareWithoutComments(trigger)
                    && Objects.equals(comment, trigger.getComment());
        }

        return eq;
    }

    protected boolean compareWithoutComments(AbstractTrigger trigger) {
        return Objects.equals(name, trigger.getName())
                && Objects.equals(tableName, trigger.getTableName());
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(comment);
        hasher.put(tableName);
    }


    @Override
    public AbstractTrigger shallowCopy() {
        AbstractTrigger triggerDst = getTriggerCopy();
        triggerDst.setComment(getComment());
        triggerDst.deps.addAll(deps);
        triggerDst.setLocation(getLocation());
        return triggerDst;
    }

    protected abstract AbstractTrigger getTriggerCopy();

    @Override
    public AbstractTrigger deepCopy() {
        return shallowCopy();
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent().getParent();
    }
}
