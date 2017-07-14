package ru.taximaxim.codekeeper.ui.generators;

public class PgDataColumn {
    private String name;
    private PgDataType type;
    private PgDataGenerator generator = new RandomPgDataGenerator();
    private String begin = "1";
    private String end = "10";
    private String lenght = "255";
    private String step = "1";
    private boolean isUnique;

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

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public PgDataType getType() {
        return type;
    }

    public void setType(PgDataType type) {
        this.type = type;
        switch (type) {
        case SMALLINT:
            setBegin("-32768");
            setEnd("32767");
            break;
        case INTEGER:
            setBegin("-2147483648");
            setEnd("2147483647");
            break;
        case BIGINT:
            setBegin("-9223372036854775808");
            setEnd("9223372036854775807");
            break;
        case DATE:
            setBegin("2000-01-01 00:00:00");
            setEnd("2030-12-31 23:59:59");
            break;
        case REAL:
            setBegin("0.000001");
            setEnd("99.999999");
            break;
        case NUMERIC:
            setBegin("0.1");
            setEnd("99.999999999999999");
            break;
        case DOUBLE:
            setBegin("0.000000000000001");
            setEnd("99.999999999999999");
            break;
        case BIT:
            setBegin("1");
            setEnd("255");
            break;
        case CHARACTER:
            setBegin("1");
            setEnd("255");
            break;
        case JSON:
            setBegin("1");
            setEnd("255");
            break;
        case TEXT:
            setBegin("10");
            setEnd("255");
            break;
        default:
            break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PgDataGenerator getGenerator() {
        return generator;
    }

    public void setGenerator(PgDataGenerator generator) {
        this.generator = generator;
    }

    public Object generateValue() {
        return generator.generateValue(this);
    }

    public boolean isUnique() {
        return isUnique;
    }

    public void setUnique(boolean isUnique) {
        this.isUnique = isUnique;
    }

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }
}
