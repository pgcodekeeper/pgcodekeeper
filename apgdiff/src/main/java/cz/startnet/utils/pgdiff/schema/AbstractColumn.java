package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores column information.
 */
public abstract class AbstractColumn extends PgStatementWithSearchPath {

    protected static final String ALTER_COLUMN = "\n\tALTER COLUMN ";
    protected static final String COLLATE = " COLLATE ";
    protected static final String NULL = " NULL";
    protected static final String NOT_NULL = " NOT NULL";

    private String type;
    private String collation;
    private boolean nullValue = true;
    private String defaultValue;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.COLUMN;
    }

    public AbstractColumn(String name) {
        super(name);
    }

    public void setDefaultValue(final String defaultValue) {
        this.defaultValue = defaultValue;
        resetHash();
    }

    public String getDefaultValue() {
        return defaultValue;
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

    @Override
    public PgObjLocation getLocation() {
        PgObjLocation location = getMeta().getLocation();
        if (location == null) {
            location = getParent().getLocation();
        }
        return location;
    }

    @Override
    public void setLocation(PgObjLocation location) {
        getMeta().setLocation(location);
    }

    protected String getAlterTable(boolean nextLine, boolean only) {
        return ((AbstractTable) getParent()).getAlterTable(nextLine, only);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractColumn && super.compare(obj)) {
            AbstractColumn col = (AbstractColumn) obj;

            return  Objects.equals(type, col.getType())
                    && Objects.equals(collation, col.getCollation())
                    && nullValue == col.getNullValue()
                    && Objects.equals(defaultValue, col.getDefaultValue());
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(type);
        hasher.put(collation);
        hasher.put(nullValue);
        hasher.put(defaultValue);
    }

    @Override
    public AbstractColumn shallowCopy() {
        AbstractColumn colDst = getColumnCopy();
        copyBaseFields(colDst);
        colDst.setType(getType());
        colDst.setCollation(getCollation());
        colDst.setNullValue(getNullValue());
        colDst.setDefaultValue(getDefaultValue());
        return colDst;
    }

    protected abstract AbstractColumn getColumnCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent().getParent();
    }
}