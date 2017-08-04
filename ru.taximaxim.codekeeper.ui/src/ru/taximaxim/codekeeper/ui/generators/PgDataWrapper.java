package ru.taximaxim.codekeeper.ui.generators;

/**
 * Wrapper for PostgreSql data generator.
 *
 * @since 3.11.5
 * @author galiev_mr
 * @see PgData
 */
public class PgDataWrapper {
    private PgData column;

    /**
     * Creates data generator for PostgreSql with type, that parsed from given string
     *
     * @param colType PostgresSql data type in string format
     * @since 3.11.5
     * @author galiev_mr
     */
    public PgDataWrapper(String colType) {
        for (PgDataType pgDataType : PgDataType.values()) {
            if (pgDataType.getValue().equalsIgnoreCase(colType)) {
                changeType(pgDataType);
                if (pgDataType == PgDataType.DATE) {
                    column.setStart("1980-01-01 00:00:00");
                    column.setEnd("2020-12-31 23:59:59");
                }
                return;
            }
        }

        if (colType.startsWith("bit")) {
            changeType(PgDataType.BIT);
            column.setLength(getLength(colType));
        } else if ((colType.startsWith("character"))) {
            changeType(PgDataType.CHARACTER);
            column.setLength(getLength(colType));
        } else {
            changeType(PgDataType.OTHER);
        }
    }

    /**
     * Creates data generator for PostgreSql with type: INTEGER
     *
     * @since 3.11.5
     * @author galiev_mr
     */
    public PgDataWrapper() {
        changeType(PgDataType.INTEGER);
    }

    /**
     * Changes data generator to selected and copies current state to them
     *
     * @param type Selected data type
     * @since 3.11.5
     * @author galiev_mr
     * @see PgData #copy(PgData)
     */
    private void changeType(PgDataType type) {
        PgData data = null;
        switch (type) {
        case BIGINT:
        case INTEGER:
        case SMALLINT:
            data = new IntegerPgData();
            break;
        case DOUBLE:
        case REAL:
        case NUMERIC:
            data = new RealPgData();
            break;
        case BIT:
            data = new BitPgData();
            break;
        case BOOLEAN:
            data = new BooleanPgData();
            break;
        case CHARACTER:
        case TEXT:
            data = new TextPgData();
            break;
        case DATE:
            data = new DatePgData();
            break;
        case JSON:
            data = new JsonPgData();
            break;
        case OTHER:
            data = new CustomPgData();
            break;
        default:
            // unsupported type exception
            break;
        }
        data.copy(column);
        column = data;
        column.setType(type);
    }

    /**
     * Returns a string between two bracket from given string.
     * <p>For example {@code getLength("character(255)")} will return "255"<p>
     *
     * @param string Given string
     * @return Length as String
     * @since 3.11.5
     * @author galiev_mr
     */
    private String getLength(String string) {
        return string.substring(string.indexOf("(") + 1 , string.indexOf(")"));
    }

    public void setName(String name) {
        column.setName(name);
    }

    public String getName() {
        return column.getName();
    }

    public String generateValue() {
        return column.generateValue();
    }

    public void setType(PgDataType type) {
        changeType(type);
    }

    public PgDataType getType() {
        return column.getType();
    }

    public PgDataGenerator getGenerator() {
        return column.getGenerator();
    }

    public String getStart() {
        return column.getStart();
    }

    public String getEnd() {
        return column.getEnd();
    }

    public String getStep() {
        return column.getStep();
    }

    public String getLength() {
        return column.getLenght();
    }

    public Boolean isUnique() {
        return column.isUnique();
    }

    public void setGenerator(PgDataGenerator generator) {
        column.setGenerator(generator);
    }

    public void setStart(String start) {
        column.setStart(start);
    }

    public void setEnd(String end) {
        column.setEnd(end);
    }

    public void setStep(String step) {
        column.setStep(step);
    }

    public void setLength(String length) {
        column.setLength(length);
    }

    public boolean isNotNull() {
        return column.isNotNull();
    }

    public void setUnique(boolean isUnique) {
        column.setUnique(isUnique);
    }

    public void setNotNull(boolean isNotNull) {
        column.setNotNull(isNotNull);
    }

    public void reset() {
        column.reset();
    }

    public int getMaxValues() {
        return column.getMaxValues();
    }
}
