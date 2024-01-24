/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.schema;

import java.io.Serializable;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.hashers.IHashable;
import ru.taximaxim.codekeeper.core.hashers.JavaHasher;

/**
 * Subclass when need to reset hashes
 * (like when setting hashed fields after adding the arg to its container).
 */
public class Argument implements Serializable, IHashable {

    private static final long serialVersionUID = -2427789431834197575L;

    private final ArgMode mode;
    private final String name;
    private final String dataType;
    private String defaultExpression;
    private boolean isReadOnly;

    public Argument(String name, String dataType) {
        this(ArgMode.IN, name, dataType);
    }

    public Argument(ArgMode mode, String name, String dataType) {
        this.mode = mode;
        this.name = (name != null && name.isEmpty()) ? null : name;
        this.dataType = dataType;
    }

    public String getDataType() {
        return dataType;
    }

    public String getDefaultExpression() {
        return defaultExpression;
    }

    public void setDefaultExpression(final String defaultExpression) {
        this.defaultExpression = defaultExpression;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(final boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    public ArgMode getMode() {
        return mode;
    }

    public String getName() {
        return name;
    }

    public StringBuilder appendDeclaration(StringBuilder sbString,
            boolean includeDefaultValue, boolean includeArgName) {
        if (includeArgName) {
            ArgMode mode = getMode();
            if (mode != ArgMode.IN) {
                sbString.append(mode);
                sbString.append(' ');
            }

            String name = getName();

            if (name != null && !name.isEmpty()) {
                sbString.append(PgDiffUtils.getQuotedName(name));
                sbString.append(' ');
            }
        }

        sbString.append(getDataType());

        String def = getDefaultExpression();

        if (includeDefaultValue && def != null && !def.isEmpty()) {
            sbString.append(" = ");
            sbString.append(def);
        }

        return sbString;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof Argument) {
            final Argument arg = (Argument) obj;
            eq = Objects.equals(dataType, arg.getDataType())
                    && Objects.equals(defaultExpression, arg.getDefaultExpression())
                    && mode == arg.getMode()
                    && isReadOnly == arg.isReadOnly()
                    && Objects.equals(name, arg.getName());
        }

        return eq;
    }

    @Override
    public int hashCode() {
        JavaHasher hasher = new JavaHasher();
        computeHash(hasher);
        return hasher.getResult();
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(dataType);
        hasher.put(defaultExpression);
        hasher.put(mode);
        hasher.put(name);
        hasher.put(isReadOnly);
    }
}
