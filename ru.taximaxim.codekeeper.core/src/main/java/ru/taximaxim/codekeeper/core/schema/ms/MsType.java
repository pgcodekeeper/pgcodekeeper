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
package ru.taximaxim.codekeeper.core.schema.ms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractType;
import ru.taximaxim.codekeeper.core.schema.IConstraint;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.IStatementContainer;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public final class MsType extends AbstractType implements IStatementContainer {

    // base type
    private String baseType;
    private boolean isNotNull;

    // assembly type
    private String assemblyName;
    private String assemblyClass;

    // table type
    private boolean isMemoryOptimized;
    private final List<String> columns = new ArrayList<>();
    private final List<String> constraints = new ArrayList<>();
    private final List<String> indices = new ArrayList<>();

    public MsType(String name) {
        super(name);
    }

    @Override
    protected void appendDef(StringBuilder sb) {
        if (baseType != null) {
            sb.append(" FROM ").append(baseType);
            if (isNotNull) {
                sb.append(" NOT NULL");
            }
        } else if (assemblyName != null) {
            sb.append("\nEXTERNAL NAME ").append(MsDiffUtils.quoteName(assemblyName))
            .append('.').append(MsDiffUtils.quoteName(assemblyClass));
        } else {
            sb.append(" AS TABLE(");
            for (String col : columns) {
                sb.append("\n\t");
                sb.append(col);
                sb.append(",");
            }

            if (!columns.isEmpty()) {
                sb.setLength(sb.length() - 1);
            }

            for (String ind : indices) {
                sb.append(",\n\t").append(ind);
            }

            for (String con : constraints) {
                sb.append(",\n\t").append(con);
            }

            sb.append("\n)");

            if (isMemoryOptimized) {
                sb.append("\nWITH ( MEMORY_OPTIMIZED = ON )");
            }
        }
    }

    @Override
    protected boolean compareUnalterable(AbstractType newType) {
        if (this == newType) {
            return true;
        }

        MsType type = (MsType) newType;
        return isNotNull == type.isNotNull
                && isMemoryOptimized == type.isMemoryOptimized
                && Objects.equals(baseType, type.baseType)
                && Objects.equals(assemblyName, type.assemblyName)
                && Objects.equals(assemblyClass, type.assemblyClass)
                && columns.equals(type.columns)
                && PgDiffUtils.setlikeEquals(indices, type.indices)
                && PgDiffUtils.setlikeEquals(constraints, type.constraints);
    }

    @Override
    protected AbstractType getTypeCopy() {
        MsType copy = new MsType(name);
        copy.setNotNull(isNotNull);
        copy.setMemoryOptimized(isMemoryOptimized);
        copy.setBaseType(baseType);
        copy.setAssemblyName(assemblyName);
        copy.setAssemblyClass(assemblyClass);
        copy.columns.addAll(columns);
        copy.indices.addAll(indices);
        copy.constraints.addAll(constraints);
        return copy;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsType type && super.compare(type)) {
            return compareUnalterable(type);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(isNotNull);
        hasher.put(isMemoryOptimized);
        hasher.put(baseType);
        hasher.put(assemblyName);
        hasher.put(assemblyClass);
        hasher.put(columns);
        hasher.put(indices);
        hasher.put(constraints);
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
        resetHash();
    }

    public void setNotNull(boolean isNotNull) {
        this.isNotNull = isNotNull;
        resetHash();
    }

    public void setAssemblyName(String assemblyName) {
        this.assemblyName = assemblyName;
        resetHash();
    }

    public void setAssemblyClass(String assemblyClass) {
        this.assemblyClass = assemblyClass;
        resetHash();
    }

    public void setMemoryOptimized(boolean isMemoryOptimized) {
        this.isMemoryOptimized = isMemoryOptimized;
        resetHash();
    }

    @Override
    public void addChild(IStatement stmt) {
        var type = stmt.getStatementType();
        switch (type) {
        case INDEX:
            indices.add(((MsIndex) stmt).getDefinition(true, false, false));
            break;
        case CONSTRAINT:
            constraints.add(((IConstraint) stmt).getDefinition());
            break;
        case COLUMN:
            columns.add(((AbstractColumn) stmt).getFullDefinition());
            break;
        default:
            throw new IllegalArgumentException("Unsupported child type: " + type);
        }
        resetHash();
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        // no impl
        return null;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }

}
