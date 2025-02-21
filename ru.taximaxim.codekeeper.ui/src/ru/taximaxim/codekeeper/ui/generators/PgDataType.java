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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

public enum PgDataType {
    BIGINT      (IntegerPgData::new),
    BIT         (BitPgData::new,       PgDataGenerator.INCREMENT),
    BOOLEAN     (BooleanPgData::new),
    DATE        (DatePgData::new),
    DOUBLE      (RealPgData::new, "double precision"), //$NON-NLS-1$
    INTEGER     (IntegerPgData::new),
    JSON        (JsonPgData::new,      PgDataGenerator.INCREMENT),
    NUMERIC     (RealPgData::new),
    REAL        (RealPgData::new),
    SMALLINT    (IntegerPgData::new),
    TEXT        (TextPgData::new,      PgDataGenerator.INCREMENT),
    TIME        (TimePgData::new),
    TIMESTAMP   (TimestampPgData::new),
    TIMESTAMPTZ (TimestampTZPgData::new),
    // shouldn't get created by any type implicitly, so use an empty type name
    OTHER       (CustomPgData::new, "", PgDataGenerator.CONSTANT, PgDataGenerator.INCREMENT, PgDataGenerator.RANDOM); //$NON-NLS-1$

    private final Collection<PgDataGenerator> generators;
    private final String type;
    private final Supplier<PgData<?>> factory;

    private PgDataType(Supplier<PgData<?>> factory) {
        this.generators = EnumSet.allOf(PgDataGenerator.class);
        this.type = name().toLowerCase(Locale.ROOT);
        this.factory = factory;
    }

    private PgDataType(Function<PgDataType, PgData<?>> factory) {
        this.generators = EnumSet.allOf(PgDataGenerator.class);
        this.type = name().toLowerCase(Locale.ROOT);
        this.factory = () -> factory.apply(this);
    }

    private PgDataType(Function<PgDataType, PgData<?>> factory, String type) {
        this.generators = EnumSet.allOf(PgDataGenerator.class);
        this.type = type.toLowerCase(Locale.ROOT);
        this.factory = () -> factory.apply(this);
    }

    private PgDataType(Supplier<PgData<?>> factory, String type) {
        this.generators = EnumSet.allOf(PgDataGenerator.class);
        this.type = type.toLowerCase(Locale.ROOT);
        this.factory = factory;
    }

    private PgDataType(Supplier<PgData<?>> factory,  PgDataGenerator... generators) {
        this.generators = setOfGenerators(Arrays.asList(generators));
        this.type = name().toLowerCase(Locale.ROOT);
        this.factory = factory;
    }

    private PgDataType(Function<PgDataType, PgData<?>> factory, PgDataGenerator... generators) {
        this.generators = setOfGenerators(Arrays.asList(generators));
        this.type = name().toLowerCase(Locale.ROOT);
        this.factory = () -> factory.apply(this);
    }

    private PgDataType(Supplier<PgData<?>> factory, String type, PgDataGenerator... generators) {
        this.generators = setOfGenerators(Arrays.asList(generators));
        this.type = type.toLowerCase(Locale.ROOT);
        this.factory = factory;
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
        case BIT, TEXT:
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

    public static PgData<?> dataForType(String text) {
        String type = text.toLowerCase(Locale.ROOT);
        PgDataType t = null;
        for (PgDataType e : values()) {
            if (e.type.equalsIgnoreCase(type)) {
                t = e;
            }
        }

        if (t == null) {
            if (type.startsWith(BIT.type)) {
                t = BIT;
            } else if (type.startsWith(NUMERIC.type)) {
                t = PgDataType.NUMERIC;
            } else if (type.startsWith("varchar") || type.startsWith("character")) { //$NON-NLS-1$ //$NON-NLS-2$
                t = PgDataType.TEXT;
            } else if ("timestamp without time zone".equals(type)) { //$NON-NLS-1$
                t = PgDataType.TIMESTAMP;
            } else if ("timestamp with time zone".equals(type)) { //$NON-NLS-1$
                t = PgDataType.TIMESTAMPTZ;
            } else if ("time without time zone".equals(type)) { //$NON-NLS-1$
                t = PgDataType.TIME;
            }
        }
        if (t == null) {
            t = OTHER;
        }

        return t.makeData(type);
    }

    private static Set<PgDataGenerator> setOfGenerators(List<PgDataGenerator> generators) {
        return Collections.unmodifiableSet(EnumSet.complementOf(EnumSet.copyOf(generators)));
    }
}
