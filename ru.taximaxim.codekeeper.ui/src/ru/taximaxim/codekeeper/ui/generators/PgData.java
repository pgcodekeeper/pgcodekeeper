package ru.taximaxim.codekeeper.ui.generators;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * An abstract base implementation of a PostgreSql data generator.
 * <p>
 * Subclasses must implement the <code>generateValue</code> and
 * <code>getMaxValues</code> methods to create the specific data generator.
 * </p>
 * @since 3.11.5
 * @author galiev_mr
 */
public abstract class PgData {

    private String name;
    private PgDataType type;

    protected String start = "1";
    protected String end = "100";
    protected String length = "255";
    protected String step = "1";
    protected String currentInc = "1";
    protected boolean isUnique;
    protected boolean isNotNull;

    protected final Random ran = new Random();
    protected final Set<String> objects = new HashSet<>();

    protected PgDataGenerator generator = PgDataGenerator.RANDOM;

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
        reset();
    }

    public PgDataType getType() {
        return type;
    }

    public void setType(PgDataType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUnique() {
        return isUnique;
    }

    public void setUnique(boolean isUnique) {
        this.isUnique = isUnique;
    }

    public boolean isNotNull() {
        return isNotNull;
    }

    public void setNotNull(boolean isNotNull) {
        this.isNotNull = isNotNull;
    }

    public String getLenght() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public PgDataGenerator getGenerator() {
        return generator;
    }

    public void setGenerator(PgDataGenerator generator) {
        this.generator = generator;
    }

    /**
     * Generates value by generator current state
     *
     * @return Generated value in string format
     * @since 3.11.5
     * @author galiev_mr
     */
    public abstract String generateValue();

    /**
     * Counts the maximum number of unique values ​​based on the current state of the generator
     *
     * @return Maximum number of unique values
     * @since 3.11.5
     * @author galiev_mr
     */
    public abstract int getMaxValues();

    /**
     * Generates chars or bit number flow
     *
     * @param index Flow length
     * @param isOneWord Generation mode, if true flow can not contains whitespace
     * @param isChar Generation mode, if true generates chars, otherwise bit number
     * @return Generated string
     * @since 3.11.5
     * @author galiev_mr
     */
    protected String genSymbols(int index, boolean isOneWord, boolean isChar) {
        StringBuilder sb = new StringBuilder();
        boolean isPrev = true;
        for (int i = 0; i < index; i++) {
            if (isChar) {
                if (!isOneWord && !isPrev && ran.nextDouble() < 0.1) {
                    sb.append(' ');
                    isPrev = true;
                } else {
                    sb.append((char)(ran.nextInt(26) + 'a'));
                    isPrev = false;
                }
            } else {
                sb.append(ran.nextInt(2));
            }
        }
        return sb.toString();
    }

    /**
     * Copies PgData state from given PgData
     *
     * @param data Donor of data
     * @since 3.11.5
     * @author galiev_mr
     */
    public void copy(PgData data) {
        if (data != null) {
            start = data.getStart();
            end = data.getEnd();
            step = data.getStep();
            length = data.getLenght();
            isUnique = data.isUnique();
            isNotNull = data.isNotNull();
            name = data.getName();
            generator = data.getGenerator();
        }
    }

    /**
     * Resets current increment to default value
     *
     * @since 3.11.5
     * @author galiev_mr
     */
    public void reset() {
        currentInc = start;
        objects.clear();
    }

}
