/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.generators;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import ru.taximaxim.codekeeper.core.PgDiffUtils;

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

    protected static final String EXP_FORMAT = "{0}. Expected format: {1}"; //$NON-NLS-1$

    private final PgDataType type;
    private String name;
    private String alias;
    protected String any = "any value"; //$NON-NLS-1$
    protected T start;
    protected T end;
    protected int length = 255;
    protected T step;
    protected T currentInc;
    private boolean isUnique;
    private boolean isNotNull;
    protected PgDataGenerator generator;

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

    public String getAlias() {
        if (alias != null) {
            return alias;
        }

        return type.name();
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAny() {
        return any;
    }

    public void setAny(String any) {
        this.any = any;
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

    protected PgData(PgDataType type, T start, T end, T step) {
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
     * @return Generated value in T format
     */
    public abstract T generateValue();

    public String generateAsString() {
        return generator == PgDataGenerator.ANY ? any : "" + generateValue(); //$NON-NLS-1$
    }

    protected T generateRandom() {
        if (!isUnique && !isNotNull && PgDiffUtils.RANDOM.nextDouble() < 0.05) {
            return null;
        }
        T object;
        do {
            object = generateRandom(PgDiffUtils.RANDOM);
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
                if (!isOneWord && !isPrev && PgDiffUtils.RANDOM.nextDouble() < 0.1) {
                    sb.append(' ');
                    isPrev = true;
                } else {
                    sb.append((char)(PgDiffUtils.RANDOM.nextInt(26) + 'a'));
                    isPrev = false;
                }
            } else {
                sb.append(PgDiffUtils.RANDOM.nextInt(2));
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
        any = data.getAny();
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
