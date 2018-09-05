/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores column information.
 */
public abstract class AbstractColumn extends PgStatementWithSearchPath implements PgOptionContainer {

    protected static final String ALTER_COLUMN = "\n\tALTER COLUMN ";

    private String type;
    private String collation;
    private boolean nullValue = true;
    private String defaultValue;
    private Integer statistics;
    private String storage;
    protected final Map<String, String> options = new LinkedHashMap<>(0);
    protected final Map<String, String> fOptions = new LinkedHashMap<>(0);
    private AbstractSequence sequence;
    private String identityType;
    private boolean isInherit;

    private boolean isSparse;
    private boolean isRowGuidCol;
    private boolean isPersisted;
    private boolean isNotForRep;
    private boolean isIdentity;
    private String seed;
    private String increment;
    private String defaultName;
    private String expession;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.COLUMN;
    }

    public AbstractColumn(String name) {
        super(name, null);
    }

    public void setDefaultValue(final String defaultValue) {
        this.defaultValue = defaultValue;
        resetHash();
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    @Override
    public Map<String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public void addOption(String attribute, String value){
        this.options.put(attribute, value);
        resetHash();
    }

    public Map<String, String> getForeignOptions() {
        return Collections.unmodifiableMap(fOptions);
    }

    public void addForeignOption(String attribute, String value){
        this.fOptions.put(attribute, value);
        resetHash();
    }

    public boolean isInherit() {
        return isInherit;
    }

    public void setInherit(boolean isInherit) {
        this.isInherit = isInherit;
        resetHash();
    }

    /**
     * Returns full definition of the column.
     *
     * @return full definition of the column
     */
    public abstract String getFullDefinition();

    public void setNullValue(final boolean nullValue) {
        this.nullValue = nullValue;
        resetHash();
    }

    public boolean getNullValue() {
        return nullValue;
    }

    public void setStatistics(final Integer statistics) {
        this.statistics = statistics;
        resetHash();
    }

    public Integer getStatistics() {
        return statistics;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(final String storage) {
        this.storage = storage;
        resetHash();
    }

    public void setType(final String type) {
        this.type = type;
        resetHash();
    }

    public String getType() {
        return type;
    }

    public void setCollation(final String collation) {
        this.collation = collation;
        resetHash();
    }

    public String getCollation() {
        return collation;
    }

    public AbstractSequence getSequence() {
        return sequence;
    }

    public void setSequence(final AbstractSequence sequence) {
        this.sequence = sequence;
        resetHash();
    }

    public void setIdentityType(final String identityType) {
        this.identityType = identityType;
        resetHash();
    }

    public String getIdentityType() {
        return identityType;
    }

    public boolean isSparse() {
        return isSparse;
    }

    public void setSparse(final boolean isSparse) {
        this.isSparse = isSparse;
        resetHash();
    }

    public boolean isRowGuidCol() {
        return isRowGuidCol;
    }

    public void setRowGuidCol(final boolean isRowGuidCol) {
        this.isRowGuidCol = isRowGuidCol;
        resetHash();
    }

    public boolean isPersisted() {
        return isPersisted;
    }

    public void setPersisted(final boolean isPersisted) {
        this.isPersisted = isPersisted;
        resetHash();
    }

    public boolean isNotForRep() {
        return isNotForRep;
    }

    public void setNotForRep(final boolean isNotForRep) {
        this.isNotForRep = isNotForRep;
        resetHash();
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(final String defaultName) {
        this.defaultName = defaultName;
        resetHash();
    }

    public String getExpression() {
        return expession;
    }

    public void setExpression(final String expession) {
        this.expession = expession;
        resetHash();
    }

    public String getSeed() {
        return seed;
    }

    public String getIncrement() {
        return increment;
    }

    public boolean isIdentity() {
        return isIdentity;
    }

    public void setIdentity(String seed, String increment) {
        this.seed = seed;
        this.increment = increment;
        this.isIdentity = true;
        resetHash();
    }

    protected String getAlterTable() {
        return ((AbstractTable) getParent()).getAlterTable(false, false);
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if(obj instanceof AbstractColumn) {
            AbstractColumn col = (AbstractColumn) obj;

            eq = Objects.equals(name, col.getName())
                    && Objects.equals(type, col.getType())
                    && Objects.equals(collation, col.getCollation())
                    && nullValue == col.getNullValue()
                    && Objects.equals(defaultValue, col.getDefaultValue())
                    && Objects.equals(statistics, col.getStatistics())
                    && Objects.equals(storage, col.getStorage())
                    && options.equals(col.options)
                    && fOptions.equals(col.fOptions)
                    && Objects.equals(sequence, col.getSequence())
                    && Objects.equals(identityType, col.getIdentityType())
                    && isInherit == col.isInherit()
                    && grants.equals(col.grants)
                    && revokes.equals(col.revokes)
                    && Objects.equals(comment, col.getComment())
                    && isSparse == col.isSparse()
                    && isRowGuidCol ==  col.isRowGuidCol()
                    && isPersisted == col.isPersisted()
                    && isNotForRep == col.isNotForRep()
                    && isIdentity == col.isIdentity()
                    && Objects.equals(seed, col.getSeed())
                    && Objects.equals(increment, col.getIncrement())
                    && Objects.equals(defaultName, col.getDefaultName())
                    && Objects.equals(expession, col.getExpression());
        }

        return eq;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(type);
        hasher.put(collation);
        hasher.put(nullValue);
        hasher.put(defaultValue);
        hasher.put(statistics);
        hasher.put(storage);
        hasher.put(options);
        hasher.put(fOptions);
        hasher.put(sequence);
        hasher.put(identityType);
        hasher.put(isInherit);
        hasher.putOrdered(grants);
        hasher.putOrdered(revokes);
        hasher.put(comment);
        hasher.put(isSparse);
        hasher.put(isRowGuidCol);
        hasher.put(isPersisted);
        hasher.put(isNotForRep);
        hasher.put(isIdentity);
        hasher.put(seed);
        hasher.put(increment);
        hasher.put(defaultName);
        hasher.put(expession);
    }

    @Override
    public AbstractColumn shallowCopy() {
        AbstractColumn colDst = getColumnCopy();
        colDst.setType(getType());
        colDst.setCollation(getCollation());
        colDst.setNullValue(getNullValue());
        colDst.setDefaultValue(getDefaultValue());
        colDst.setStatistics(getStatistics());
        colDst.setStorage(getStorage());
        colDst.setSparse(isSparse());
        colDst.setRowGuidCol(isRowGuidCol());
        colDst.setPersisted(isPersisted());
        colDst.setNotForRep(isNotForRep());
        colDst.isIdentity = isIdentity();
        colDst.seed = getSeed();
        colDst.increment = getIncrement();
        colDst.setDefaultName(getDefaultName());
        colDst.setExpression(getExpression());
        colDst.options.putAll(options);
        colDst.fOptions.putAll(fOptions);
        colDst.setIdentityType(getIdentityType());
        colDst.setSequence(getSequence());
        colDst.setInherit(isInherit());
        for (PgPrivilege priv : grants) {
            colDst.addPrivilege(priv);
        }
        for (PgPrivilege priv : revokes) {
            colDst.addPrivilege(priv);
        }
        colDst.setComment(getComment());
        colDst.deps.addAll(deps);
        return colDst;
    }

    protected abstract AbstractColumn getColumnCopy();

    @Override
    public AbstractColumn deepCopy() {
        return shallowCopy();
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent().getParent();
    }
}
