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

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public abstract class AbstractType extends PgStatementWithSearchPath {

    protected AbstractType(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.TYPE;
    }

    @Override
    public AbstractType shallowCopy() {
        AbstractType typeDst = getTypeCopy();
        copyBaseFields(typeDst);
        return typeDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        return this == obj || obj instanceof AbstractType && super.compare(obj);
    }

    protected abstract AbstractType getTypeCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) this.getParent();
    }
}
