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
public abstract class PgData<T> {

    private final PgDataType type;
    private String name;
    protected T start;
    protected T end;
    protected int length = 255;
    protected T step;
    protected T currentInc;
    private boolean isUnique;
    private boolean isNotNull;
    protected PgDataGenerator generator;

    private final Random ran = new Random();
    protected final Set<T> objects = new HashSet<>();

    public T getStep() {
        return step;
    }

    public void setStep(T step) {
        this.step = step;
    }

    public String getStepAsString() {
        return valueAsString(getStep());
    }

    public void setStepFromString(String step) {
        setStep(valueFromString(step));
    }

    public T getEnd() {
        return end;
    }

    public void setEnd(T end) {
        this.end = end;
    }

    public String getEndAsString() {
        return valueAsString(getEnd());
    }

    public void setEndFromString(String end) {
        setEnd(valueFromString(end));
    }

    public T getStart() {
        return start;
    }

    public void setStart(T start) {
        this.start = start;
        reset();
    }

    public String getStartAsString() {
        return valueAsString(getStart());
    }

    public void setStartFromString(String start) {
        setStart(valueFromString(start));
    }

    public PgDataType getType() {
        return type;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public PgDataGenerator getGenerator() {
        return generator;
    }

    public void setGenerator(PgDataGenerator generator) {
        this.generator = generator;
    }

    public PgData(PgDataType type, T start, T end, T step) {
        this.type = type;
        this.start = start;
        this.end = end;
        this.step = step;
        this.currentInc = start;
        this.generator = type.getDefaultGenerator();
    }

    /**
     * Generates value by generator current state
     *
     * @return Generated value in string format
     */
    public abstract T generateValue();

    public String generateAsString() {
        return "" + generateValue(); //$NON-NLS-1$
    }

    protected T generateRandom() {
        if (!isUnique && !isNotNull && ran.nextDouble() < 0.05) {
            return null;
        }
        T object;
        do {
            object = generateRandom(ran);
        } while (isUnique && !objects.add(object));
        return object;
    }

    protected abstract T generateRandom(Random ran);

    /**
     * Counts the maximum number of unique values ​​based on the current state of the generator
     *
     * @return Maximum number of unique values
     */
    public abstract int getMaxValues();

    /**
     * Generates chars or bit number flow
     *
     * @param length Flow length
     * @param isOneWord Generation mode, if true flow can not contains whitespace
     * @param isChar Generation mode, if true generates chars, otherwise bit number
     * @return Generated string
     */
    protected String genSymbols(int length, boolean isOneWord, boolean isChar) {
        StringBuilder sb = new StringBuilder(length);
        boolean isPrev = true;
        for (int i = 0; i < length; i++) {
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
     */
    public void copyFrom(PgData<?> data) {
        length = data.getLength();
        isUnique = data.isUnique();
        isNotNull = data.isNotNull();
        name = data.getName();
        PgDataGenerator gen = data.getGenerator();
        generator = type.getGenerators().contains(gen) ? gen : type.getDefaultGenerator();
    }

    /**
     * Resets current increment to default value
     */
    public void reset() {
        currentInc = start;
        objects.clear();
    }

    public String valueAsString(T value) {
        return value == null ? "" : value.toString(); //$NON-NLS-1$
    }

    public abstract T valueFromString(String s);
}
