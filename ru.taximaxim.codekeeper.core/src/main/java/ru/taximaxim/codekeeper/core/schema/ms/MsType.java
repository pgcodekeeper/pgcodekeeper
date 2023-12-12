/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
import java.util.Collections;
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
        if (getBaseType() != null) {
            sb.append(" FROM ").append(getBaseType());
            if (isNotNull()) {
                sb.append(" NOT NULL");
            }
        } else if (getAssemblyName() != null) {
            sb.append("\nEXTERNAL NAME ").append(MsDiffUtils.quoteName(getAssemblyName()))
            .append('.').append(MsDiffUtils.quoteName(getAssemblyClass()));
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

            if (isMemoryOptimized()) {
                sb.append("\nWITH ( MEMORY_OPTIMIZED = ON )");
            }
        }
        sb.append(GO);
    }

    @Override
    protected boolean compareUnalterable(AbstractType newType) {
        if (this == newType) {
            return true;
        }

        MsType type = (MsType) newType;
        return isNotNull() == type.isNotNull()
                && isMemoryOptimized() == type.isMemoryOptimized()
                && Objects.equals(getBaseType(), type.getBaseType())
                && Objects.equals(getAssemblyName(), type.getAssemblyName())
                && Objects.equals(getAssemblyClass(), type.getAssemblyClass())
                && columns.equals(type.columns)
                && PgDiffUtils.setlikeEquals(indices, type.indices)
                && PgDiffUtils.setlikeEquals(constraints, type.constraints);
    }

    @Override
    protected AbstractType getTypeCopy() {
        MsType copy = new MsType(getName());
        copy.setNotNull(isNotNull());
        copy.setMemoryOptimized(isMemoryOptimized());
        copy.setBaseType(getBaseType());
        copy.setAssemblyName(getAssemblyName());
        copy.setAssemblyClass(getAssemblyClass());
        copy.columns.addAll(columns);
        copy.indices.addAll(indices);
        copy.constraints.addAll(constraints);
        return copy;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof MsType) {
            MsType type = (MsType) obj;
            return super.compare(type) && compareUnalterable(type);
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

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
        resetHash();
    }

    public boolean isNotNull() {
        return isNotNull;
    }

    public void setNotNull(boolean isNotNull) {
        this.isNotNull = isNotNull;
        resetHash();
    }

    public String getAssemblyName() {
        return assemblyName;
    }

    public void setAssemblyName(String assemblyName) {
        this.assemblyName = assemblyName;
        resetHash();
    }

    public String getAssemblyClass() {
        return assemblyClass;
    }

    public void setAssemblyClass(String assemblyClass) {
        this.assemblyClass = assemblyClass;
        resetHash();
    }

    public boolean isMemoryOptimized() {
        return isMemoryOptimized;
    }

    public void setMemoryOptimized(boolean isMemoryOptimized) {
        this.isMemoryOptimized = isMemoryOptimized;
        resetHash();
    }

    public List<String> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    public List<String> getConstraints() {
        return Collections.unmodifiableList(constraints);
    }

    public List<String> getIndices() {
        return Collections.unmodifiableList(indices);
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }

    @Override
    public void addChild(IStatement stmt) {
        var type = stmt.getStatementType();
        switch (type) {
        case INDEX:
            indices.add(((MsIndex) stmt).getDefinition(true, false));
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
}
