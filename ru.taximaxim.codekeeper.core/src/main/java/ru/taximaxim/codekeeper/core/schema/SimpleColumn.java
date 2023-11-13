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
package ru.taximaxim.codekeeper.core.schema;

import java.io.Serializable;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.hashers.IHashable;
import ru.taximaxim.codekeeper.core.hashers.JavaHasher;

public class SimpleColumn implements Serializable, IHashable {

    private static final long serialVersionUID = 2305486126854181859L;

    private final String name;
    private String operator;
    private String opClass;
    private String nullsOrdering;
    private boolean isDesc;

    public SimpleColumn(String name) {
        this.name = name;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setOpClass(String opClass) {
        this.opClass = opClass;
    }

    public String getOpClass() {
        return opClass;
    }

    public void setNullsOrdering(String nullsOrdering) {
        this.nullsOrdering = nullsOrdering;
    }

    public String getNullsOrdering() {
        return nullsOrdering;
    }

    public boolean isDesc() {
        return isDesc;
    }

    public void setDesc(boolean isDesc) {
        this.isDesc = isDesc;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        JavaHasher hasher = new JavaHasher();
        computeHash(hasher);
        return hasher.getResult();
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(operator);
        hasher.put(opClass);
        hasher.put(nullsOrdering);
        hasher.put(isDesc);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleColumn)) {
            return false;
        }
        SimpleColumn other = (SimpleColumn) obj;
        return isDesc == other.isDesc
                && Objects.equals(nullsOrdering, other.nullsOrdering)
                && Objects.equals(name, other.name)
                && Objects.equals(operator, other.operator)
                && Objects.equals(opClass, other.opClass);
    }
}
