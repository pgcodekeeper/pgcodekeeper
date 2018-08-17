package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores trigger information.
 */
public abstract class AbstractTrigger extends PgStatementWithSearchPath {

    public enum TgTypes {
        BEFORE, AFTER, INSTEAD_OF
    }

    private String function;
    private String tableName;
    private String refTableName;
    /**
     * Whether the trigger should be fired BEFORE, AFTER or INSTEAD_OF action. Default is
     * before.
     */
    private TgTypes tgType = TgTypes.BEFORE;
    /**
     * Whether the trigger should be fired FOR EACH ROW or FOR EACH STATEMENT.
     * Default is FOR EACH STATEMENT.
     */
    private boolean forEachRow;
    private boolean onDelete;
    private boolean onInsert;
    private boolean onUpdate;
    private boolean onTruncate;
    private boolean constraint;
    private Boolean isImmediate;
    /**
     * Optional list of columns for UPDATE event.
     */
    protected final Set<String> updateColumns = new HashSet<>();
    private String when;


    protected final List<String> options = new ArrayList<>();
    private String query;
    private boolean isAppend;
    private boolean isNotForRep;
    private boolean isDisable;
    private boolean ansiNulls;
    private boolean quotedIdentified;


    /**
     * REFERENCING old table name
     */
    private String oldTable;
    /**
     * REFERENCING new table name
     */
    private String newTable;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.TRIGGER;
    }

    public AbstractTrigger(String name, String rawStatement) {
        super(name, rawStatement);
    }

    public void setType(final TgTypes tgType) {
        this.tgType = tgType;
        resetHash();
    }

    public TgTypes getType() {
        return tgType;
    }

    public void setForEachRow(final boolean forEachRow) {
        this.forEachRow = forEachRow;
        resetHash();
    }

    public boolean isForEachRow() {
        return forEachRow;
    }

    public void setFunction(final String function) {
        this.function = function;
        resetHash();
    }

    protected String getFunction() {
        return function;
    }

    public void setOnDelete(final boolean onDelete) {
        this.onDelete = onDelete;
        resetHash();
    }

    public boolean isOnDelete() {
        return onDelete;
    }

    public void setOnInsert(final boolean onInsert) {
        this.onInsert = onInsert;
        resetHash();
    }

    public boolean isOnInsert() {
        return onInsert;
    }

    public void setOnUpdate(final boolean onUpdate) {
        this.onUpdate = onUpdate;
        resetHash();
    }

    public boolean isOnUpdate() {
        return onUpdate;
    }

    public boolean isOnTruncate() {
        return onTruncate;
    }

    public void setOnTruncate(final boolean onTruncate) {
        this.onTruncate = onTruncate;
        resetHash();
    }

    public void setTableName(final String tableName) {
        this.tableName = tableName;
        resetHash();
    }

    public String getTableName() {
        return tableName;
    }

    public Set<String> getUpdateColumns() {
        return Collections.unmodifiableSet(updateColumns);
    }

    public void addUpdateColumn(final String columnName) {
        updateColumns.add(columnName);
        resetHash();
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(final String when) {
        this.when = when;
        resetHash();
    }

    public Boolean isImmediate() {
        return isImmediate;
    }

    public void setImmediate(final Boolean isImmediate) {
        this.isImmediate = isImmediate;
        resetHash();
    }

    public boolean isConstraint() {
        return constraint;
    }

    public void setConstraint(final boolean constraint) {
        this.constraint = constraint;
        resetHash();
    }

    public String getRefTableName() {
        return refTableName;
    }

    public void setRefTableName(final String refTableName) {
        this.refTableName = refTableName;
        resetHash();
    }

    public void setOldTable(String oldTable) {
        this.oldTable = oldTable;
        resetHash();
    }

    public String getOldTable() {
        return oldTable;
    }

    public void setNewTable(String newTable) {
        this.newTable = newTable;
        resetHash();
    }

    public String getNewTable() {
        return newTable;
    }

    public List<String> getOptions() {
        return Collections.unmodifiableList(options);
    }

    public void addOption(String option) {
        options.add(option);
        resetHash();
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(final String query) {
        this.query = query;
        resetHash();
    }

    public boolean isAppend() {
        return isAppend;
    }

    public void setAppend(final boolean isAppend) {
        this.isAppend = isAppend;
        resetHash();
    }

    public boolean isNotForRep() {
        return isNotForRep;
    }

    public void setNotForRep(final boolean isNotForRep) {
        this.isNotForRep = isNotForRep;
        resetHash();
    }

    public boolean isDisable() {
        return isDisable;
    }

    public void setDisable(boolean isDisable) {
        this.isDisable = isDisable;
        resetHash();
    }

    public void setAnsiNulls(boolean ansiNulls) {
        this.ansiNulls = ansiNulls;
        resetHash();
    }

    public boolean isAnsiNulls() {
        return ansiNulls;
    }

    public void setQuotedIdentified(boolean quotedIdentified) {
        this.quotedIdentified = quotedIdentified;
        resetHash();
    }

    public boolean isQuotedIdentified() {
        return quotedIdentified;
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof AbstractTrigger) {
            AbstractTrigger trigger = (AbstractTrigger) obj;
            eq = compareWithoutComments(trigger)
                    && Objects.equals(comment, trigger.getComment())
                    && Objects.equals(isDisable, trigger.isDisable());
        }

        return eq;
    }

    protected boolean compareWithoutComments(AbstractTrigger trigger) {
        return  tgType == trigger.getType()
                && (forEachRow == trigger.isForEachRow())
                && Objects.equals(function, trigger.getFunction())
                && Objects.equals(name, trigger.getName())
                && (onDelete == trigger.isOnDelete())
                && (onInsert == trigger.isOnInsert())
                && (onUpdate == trigger.isOnUpdate())
                && (onTruncate == trigger.isOnTruncate())
                && Objects.equals(isImmediate, trigger.isImmediate())
                && Objects.equals(refTableName, trigger.getRefTableName())
                && (constraint == trigger.isConstraint())
                && Objects.equals(tableName, trigger.getTableName())
                && Objects.equals(when, trigger.getWhen())
                && Objects.equals(newTable, trigger.getNewTable())
                && Objects.equals(oldTable, trigger.getOldTable())
                && Objects.equals(updateColumns, trigger.updateColumns)
                && Objects.equals(options, trigger.getOptions())
                && Objects.equals(query, trigger.getQuery())
                && Objects.equals(isAppend, trigger.isAppend())
                && Objects.equals(isNotForRep, trigger.isNotForRep())
                && Objects.equals(quotedIdentified, trigger.isQuotedIdentified())
                && Objects.equals(ansiNulls, trigger.isAnsiNulls());
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(tgType);
        hasher.put(forEachRow);
        hasher.put(function);
        hasher.put(name);
        hasher.put(onDelete);
        hasher.put(onInsert);
        hasher.put(onTruncate);
        hasher.put(onUpdate);
        hasher.put(tableName);
        hasher.put(when);
        hasher.put(updateColumns);
        hasher.put(comment);
        hasher.put(constraint);
        hasher.put(isImmediate);
        hasher.put(refTableName);
        hasher.put(newTable);
        hasher.put(oldTable);
        hasher.put(options);
        hasher.put(query);
        hasher.put(isAppend);
        hasher.put(isNotForRep);
        hasher.put(isDisable);
        hasher.put(quotedIdentified);
        hasher.put(ansiNulls);
    }


    @Override
    public AbstractTrigger shallowCopy() {
        AbstractTrigger triggerDst = getTriggerCopy();
        triggerDst.setType(getType());
        triggerDst.setForEachRow(isForEachRow());
        triggerDst.setFunction(getFunction());
        triggerDst.setOnDelete(isOnDelete());
        triggerDst.setOnInsert(isOnInsert());
        triggerDst.setOnTruncate(isOnTruncate());
        triggerDst.setOnUpdate(isOnUpdate());
        triggerDst.setConstraint(isConstraint());
        triggerDst.setTableName(getTableName());
        triggerDst.setWhen(getWhen());
        triggerDst.setImmediate(isImmediate());
        triggerDst.setRefTableName(getRefTableName());
        triggerDst.setNewTable(getNewTable());
        triggerDst.setOldTable(getOldTable());
        triggerDst.setComment(getComment());
        triggerDst.updateColumns.addAll(getUpdateColumns());
        triggerDst.deps.addAll(deps);
        triggerDst.options.addAll(options);
        triggerDst.setQuery(getQuery());
        triggerDst.setAppend(isAppend());
        triggerDst.setNotForRep(isNotForRep());
        triggerDst.setDisable(isDisable());
        triggerDst.setAnsiNulls(isAnsiNulls());
        triggerDst.setQuotedIdentified(isQuotedIdentified());
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
