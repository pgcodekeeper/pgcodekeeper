/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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

import org.pgcodekeeper.core.DatabaseType;
import org.pgcodekeeper.core.MsDiffUtils;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public enum DataType {
    BIGINT      (e -> new IntegerData(e, Long.MAX_VALUE)),
    BIT         (e -> new BitData(e, "B'01'"), DataGenerator.INCREMENT), //$NON-NLS-1$
    BIT_MS      (e -> new IntegerData(e, "BIT", 1), DataGenerator.INCREMENT), //$NON-NLS-1$
    BOOLEAN     (BooleanData::new),
    DATE        (DateData::new),
    DOUBLE      (RealData::new, "double precision"), //$NON-NLS-1$
    INTEGER     (IntegerData::new),
    JSON        (JsonData::new,      DataGenerator.INCREMENT),
    NUMERIC     (RealData::new),
    REAL        (RealData::new),
    SMALLINT    (e -> new IntegerData(e, Short.MAX_VALUE)),
    TINYINT     (e -> new IntegerData(e, 255)),
    TEXT        (TextData::new,      DataGenerator.INCREMENT),
    TIME        (TimeData::new),
    TIMESTAMP   (TimestampData::new),
    TIMESTAMPTZ (TimestampTZPgData::new),
    DATETIME2   (TimestampData::new),
    DATETIME    (TimestampData::new),
    // shouldn't get created by any type implicitly, so use an empty type name
    OTHER       (CustomData::new, "", DataGenerator.CONSTANT, DataGenerator.INCREMENT, DataGenerator.RANDOM); //$NON-NLS-1$

    private final Collection<DataGenerator> generators;
    private final String type;
    private final Supplier<DbData<?>> factory;

    private DataType(Supplier<DbData<?>> factory) {
        this.generators = EnumSet.allOf(DataGenerator.class);
        this.type = name().toLowerCase(Locale.ROOT);
        this.factory = factory;
    }

    private DataType(Function<DataType, DbData<?>> factory) {
        this.generators = EnumSet.allOf(DataGenerator.class);
        this.type = name().toLowerCase(Locale.ROOT);
        this.factory = () -> factory.apply(this);
    }

    private DataType(Function<DataType, DbData<?>> factory, String type) {
        this.generators = EnumSet.allOf(DataGenerator.class);
        this.type = type.toLowerCase(Locale.ROOT);
        this.factory = () -> factory.apply(this);
    }

    private DataType(Supplier<DbData<?>> factory,  DataGenerator... generators) {
        this.generators = setOfGenerators(Arrays.asList(generators));
        this.type = name().toLowerCase(Locale.ROOT);
        this.factory = factory;
    }

    private DataType(Function<DataType, DbData<?>> factory, DataGenerator... generators) {
        this.generators = setOfGenerators(Arrays.asList(generators));
        this.type = name().toLowerCase(Locale.ROOT);
        this.factory = () -> factory.apply(this);
    }

    private DataType(Supplier<DbData<?>> factory, String type, DataGenerator... generators) {
        this.generators = setOfGenerators(Arrays.asList(generators));
        this.type = type.toLowerCase(Locale.ROOT);
        this.factory = factory;
    }

    public String getType() {
        return type;
    }

    public Collection<DataGenerator> getGenerators() {
        return generators;
    }

    public DataGenerator getDefaultGenerator() {
        return generators.iterator().next();
    }

    //fill combo with types
    public static List<DataType> getTypes(DatabaseType dbType) {
        return switch (dbType) {
        case PG -> Arrays.asList(DataType.BIGINT, DataType.BIT, DataType.DATE,
                DataType.BOOLEAN, DataType.DOUBLE, DataType.INTEGER,
                DataType.JSON, DataType.NUMERIC,
                DataType.REAL, DataType.SMALLINT, DataType.TEXT,
                DataType.TIME, DataType.TIMESTAMP, DataType.TIMESTAMPTZ, DataType.OTHER);
        case MS -> Arrays.asList(DataType.BIGINT, DataType.BOOLEAN, DataType.INTEGER,
                DataType.JSON,DataType.REAL, DataType.NUMERIC,
                DataType.DATETIME, DataType.DATETIME2, DataType.TIME,
                DataType.SMALLINT, DataType.TINYINT, DataType.TEXT, DataType.BIT, DataType.OTHER);
        case CH -> Arrays.asList(DataType.BIGINT, DataType.BOOLEAN, DataType.INTEGER,
                DataType.SMALLINT, DataType.JSON, DataType.DOUBLE,
                DataType.REAL, DataType.NUMERIC,
                DataType.DATETIME, DataType.TIME,
                DataType.TEXT, DataType.OTHER);
        default -> throw new IllegalArgumentException("Unsupported database type: " + dbType);
        };
    }

    /**
     * @param type type string to extract typmod (length) from, may be null
     */
    public DbData<?> makeData(String type) {
        DbData<?> data = factory.get();
        if (type == null) {
            return data;
        }

        if (this == BIT || this == TEXT) {
            int lparen = type.indexOf('(');
            int rparen = type.indexOf(')');
            if (lparen != -1 && rparen != -1) {
                data.setLength(Integer.parseUnsignedInt(type.substring(lparen + 1, rparen)));
            }
        }
        return data;
    }

    public static DbData<?> dataForType(String text, DatabaseType dbType) {
        String type = text.toLowerCase(Locale.ROOT);
        DataType t = null;
        String dataType = dbType == DatabaseType.MS ? MsDiffUtils.getUnQuotedName(type) : type;

        for (DataType e : values()) {
            if (e.type.equalsIgnoreCase(dataType)
                    && !"bit".equalsIgnoreCase(e.type)) { //$NON-NLS-1$
                t = e;
            }
        }

        if (t == null) {
            t = switch (dbType) {
            case MS -> getMsType(dataType);
            case PG -> getPgType(dataType);
            case CH -> getChType(dataType);
            default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
            };
        }
        if (t == null) {
            t = OTHER;
        }

        return t.makeData(dataType);
    }

    private static DataType getMsType(String type) {
        DataType t = null;
        if (type.startsWith(BIT.type)) {
            t = DataType.BIT_MS;
        } else if (type.startsWith(NUMERIC.type)) {
            t = DataType.NUMERIC;
        } else if (type.contains("varchar") || type.contains("char") || type.contains("nchar")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            t = DataType.TEXT;
        } else if (type.startsWith("int")) { //$NON-NLS-1$
            t = DataType.INTEGER;
        } else if ("tinyint".equals(type)) { //$NON-NLS-1$
            t = DataType.TINYINT;
        } else if (type.contains("datetime")) { //$NON-NLS-1$
            t = DataType.DATETIME;
        } else if (type.startsWith("real") || type.startsWith("float") || type.startsWith("decimal") ) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            t = DataType.REAL;
        }

        return t;
    }

    private static DataType getPgType(String type) {
        DataType t = null;
        if (type.startsWith(BIT.type)) {
            t = BIT;
        } else if (type.startsWith(NUMERIC.type)) {
            t = DataType.NUMERIC;
        } else if (type.startsWith("varchar") || type.startsWith("char")) { //$NON-NLS-1$ //$NON-NLS-2$
            t = DataType.TEXT;
        } else if (type.startsWith("timestamp without time zone")) { //$NON-NLS-1$
            t = DataType.TIMESTAMP;
        } else if (type.startsWith("timestamp with time zone")) { //$NON-NLS-1$
            t = DataType.TIMESTAMPTZ;
        } else if (type.startsWith("time without time zone")) { //$NON-NLS-1$
            t = DataType.TIME;
        }

        return t;
    }

    private static DataType getChType(String type) {
        DataType t = null;
        if (type.startsWith(BIT.type)) {
            t = BIT;
        } else if (type.startsWith(NUMERIC.type)) {
            t = DataType.NUMERIC;
        } else if (type.contains("char") || type.startsWith("string")) { //$NON-NLS-1$ //$NON-NLS-2$
            t = DataType.TEXT;
        } else if (type.startsWith("int")) { //$NON-NLS-1$
            t = DataType.INTEGER;
        } else if (type.startsWith("bool")) { //$NON-NLS-1$
            t = DataType.BOOLEAN;
        } else if (type.startsWith("real") || type.startsWith("float") || type.startsWith("decimal")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            t = DataType.REAL;
        } else if (type.startsWith("datetime")) { //$NON-NLS-1$
            t = DataType.DATETIME;
        }

        return t;
    }
    private static Set<DataGenerator> setOfGenerators(List<DataGenerator> generators) {
        return Collections.unmodifiableSet(EnumSet.complementOf(EnumSet.copyOf(generators)));
    }
}
