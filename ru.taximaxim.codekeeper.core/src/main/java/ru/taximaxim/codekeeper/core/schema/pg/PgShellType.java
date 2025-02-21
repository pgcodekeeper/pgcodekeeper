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
package ru.taximaxim.codekeeper.core.schema.pg;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractType;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public final class PgShellType extends AbstractType {

    public PgShellType(String name) {
        super(name);
    }

    @Override
    protected AbstractType getTypeCopy() {
        return new PgShellType(name);
    }

    @Override
    public void computeHash(Hasher hasher) {
        // no impl
    }

    @Override
    protected void appendDef(StringBuilder sb) {
        // no body
    }

    @Override
    protected boolean compareUnalterable(AbstractType newType) {
        return true;
    }

    @Override
    public boolean compare(PgStatement obj) {
        return obj instanceof PgShellType && super.compare(obj);
    }
}
