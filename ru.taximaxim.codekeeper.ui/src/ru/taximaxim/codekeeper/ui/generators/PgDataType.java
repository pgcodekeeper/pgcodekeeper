package ru.taximaxim.codekeeper.ui.generators;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

public enum PgDataType {
    BIGINT      (IntegerPgData::new,   PgDataGenerator.CONSTANT, PgDataGenerator.INCREMENT, PgDataGenerator.RANDOM),
    BIT         (BitPgData::new,       PgDataGenerator.CONSTANT, PgDataGenerator.RANDOM),
    BOOLEAN     (BooleanPgData::new,   PgDataGenerator.CONSTANT, PgDataGenerator.INCREMENT, PgDataGenerator.RANDOM),
    CHARACTER   (TextPgData::new,      PgDataGenerator.CONSTANT, PgDataGenerator.RANDOM),
    DATE        (DatePgData::new,      PgDataGenerator.CONSTANT, PgDataGenerator.INCREMENT, PgDataGenerator.RANDOM),
    TIMESTAMP   (TimestampPgData::new, PgDataGenerator.CONSTANT, PgDataGenerator.INCREMENT, PgDataGenerator.RANDOM),
    DOUBLE      (RealPgData::new,      "double precision", PgDataGenerator.CONSTANT, PgDataGenerator.INCREMENT, PgDataGenerator.RANDOM), //$NON-NLS-1$
    INTEGER     (IntegerPgData::new,   PgDataGenerator.CONSTANT, PgDataGenerator.INCREMENT, PgDataGenerator.RANDOM),
    JSON        (JsonPgData::new,      PgDataGenerator.CONSTANT, PgDataGenerator.RANDOM),
    NUMERIC     (RealPgData::new,      PgDataGenerator.CONSTANT, PgDataGenerator.INCREMENT, PgDataGenerator.RANDOM),
    REAL        (RealPgData::new,      PgDataGenerator.CONSTANT, PgDataGenerator.INCREMENT, PgDataGenerator.RANDOM),
    SMALLINT    (IntegerPgData::new,   PgDataGenerator.CONSTANT, PgDataGenerator.INCREMENT, PgDataGenerator.RANDOM),
    TEXT        (TextPgData::new,      PgDataGenerator.CONSTANT, PgDataGenerator.RANDOM),
    // shouldn't get created by any type implicitly, so use an empty type name
    OTHER       (CustomPgData::new,    "", PgDataGenerator.CONSTANT); //$NON-NLS-1$

    private final Collection<PgDataGenerator> generators;
    private final String type;
    private final Supplier<PgData<?>> factory;

    private PgDataType(Supplier<PgData<?>> factory, PgDataGenerator... generators) {
        this.generators = setOfGenerators(generators);
        this.type = name().toLowerCase();
        this.factory = factory;
    }

    private PgDataType(Function<PgDataType, PgData<?>> factory, PgDataGenerator... generators) {
        this.generators = setOfGenerators(generators);
        this.type = name().toLowerCase();
        this.factory = () -> factory.apply(this);
    }

    private PgDataType(Supplier<PgData<?>> factory, String type, PgDataGenerator... generators) {
        this.generators = setOfGenerators(generators);
        this.type = type;
        this.factory = factory;
    }

    private PgDataType(Function<PgDataType, PgData<?>> factory, String type, PgDataGenerator... generators) {
        this.generators = setOfGenerators(generators);
        this.type = type;
        this.factory = () -> factory.apply(this);
    }

    public String getType() {
        return type;
    }

    public Collection<PgDataGenerator> getGenerators() {
        return generators;
    }

    public PgDataGenerator getDefaultGenerator() {
        return generators.iterator().next();
    }

    /**
     * @param type type string to extract typmod (length) from, may be null
     */
    public PgData<?> makeData(String type) {
        PgData<?> data = factory.get();
        if (type == null) {
            return data;
        }
        switch (this) {
        case BIT:
        case CHARACTER:
            int lparen = type.indexOf('(');
            int rparen = type.indexOf(')');
            if (lparen != -1 && rparen != -1) {
                data.setLength(Integer.parseUnsignedInt(type.substring(lparen + 1, rparen)));
            }
            break;
        default:
            break;
        }
        return data;
    }

    public static PgData<?> dataForType(String type) {
        PgDataType t = null;
        for (PgDataType e : values()) {
            if (e.type.equalsIgnoreCase(type)) {
                t = e;
            }
        }

        if (t == null) {
            if (type.startsWith(BIT.type)) {
                t = BIT;
            } else if (type.startsWith(CHARACTER.type)) {
                t = CHARACTER;
            }
        }
        if (t == null) {
            t = OTHER;
        }

        return t.makeData(type);
    }

    private static Set<PgDataGenerator> setOfGenerators(PgDataGenerator[] generators) {
        EnumSet<PgDataGenerator> generatorsSet = EnumSet.noneOf(PgDataGenerator.class);
        for (PgDataGenerator generator : generators) {
            generatorsSet.add(generator);
        }
        return Collections.unmodifiableSet(generatorsSet);
    }
}
