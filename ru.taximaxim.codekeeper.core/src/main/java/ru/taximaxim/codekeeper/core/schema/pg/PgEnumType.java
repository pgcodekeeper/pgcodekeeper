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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractType;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SQLAction;

public final class PgEnumType extends AbstractType{

    private final List<String> enums = new ArrayList<>();

    public PgEnumType(String name) {
        super(name);
    }

    @Override
    protected void appendDef(StringBuilder sb) {
        sb.append(" AS ENUM (");
        for (String enum_ : enums) {
            sb.append("\n\t").append(enum_).append(',');
        }
        if (!enums.isEmpty()) {
            sb.setLength(sb.length() - 1);
        }
        sb.append("\n)");
    }

    @Override
    protected boolean compareUnalterable(AbstractType newType) {
        Iterator<String> ni = ((PgEnumType) newType).getEnums().iterator();
        for (String oldEnum : getEnums()) {
            if (!ni.hasNext()) {
                // some old members were removed in new, can't alter
                return false;
            }
            if (!oldEnum.equals(ni.next())) {
                // iterate over new enums until old enum is met or end is reached
                boolean found = false;
                while (ni.hasNext()) {
                    if (oldEnum.equals(ni.next())) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return false; // oldEnum is not in the new list
                }
                // order changes will fail this test as they should
                // consider old:(e1, e2), new:(e2, e1)
                // we will go over new.e2 while iterating for old.e1
                // thus we will fail to find new.e2 while iterating for old.e2
            }
        }
        return true;
    }

    @Override
    protected void compareType(AbstractType newType, AtomicBoolean isNeedDepcies, Collection<SQLAction> sqlActions) {
        List<String> newEnums = ((PgEnumType) newType).getEnums();
        for (int i = 0; i < newEnums.size(); ++i) {
            String value = newEnums.get(i);
            if (!getEnums().contains(value)) {
                SQLAction sql = new SQLAction();
                sql.append("ALTER TYPE ").append(getQualifiedName())
                .append("\n\tADD VALUE ").append(value);
                if (i == 0) {
                    sql.append(" BEFORE ").append(getEnums().get(0));
                } else {
                    sql.append(" AFTER ").append(newEnums.get(i - 1));
                }
                sqlActions.add(sql);
            }
        }
    }

    public List<String> getEnums() {
        return Collections.unmodifiableList(enums);
    }

    public void addEnum(String value) {
        enums.add(value);
        resetHash();
    }

    @Override
    protected AbstractType getTypeCopy() {
        PgEnumType copy = new PgEnumType(getName());
        copy.enums.addAll(enums);
        return copy;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgEnumType type && super.compare(type)) {
            return enums.equals(type.enums);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(enums);
    }
}
