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
        if (this == obj) {
            return true;
        }

        return obj instanceof AbstractTrigger && compareBaseFields(obj)
                && compareWithoutComments((AbstractTrigger) obj);
    }

    protected boolean compareWithoutComments(AbstractTrigger trigger) {
        return Objects.equals(name, trigger.getName())
                && Objects.equals(tableName, trigger.getTableName());
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(tableName);
    }

    @Override
    public AbstractTrigger shallowCopy() {
        AbstractTrigger triggerDst = getTriggerCopy();
        copyBaseFields(triggerDst);
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
