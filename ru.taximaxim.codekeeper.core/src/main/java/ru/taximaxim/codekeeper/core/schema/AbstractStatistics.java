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

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public abstract class AbstractStatistics extends PgStatement implements ISearchPath {

    protected AbstractStatistics(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.STATISTICS;
    }

    @Override
    public AbstractStatistics shallowCopy() {
        AbstractStatistics copy = getStatisticsCopy();
        copyBaseFields(copy);
        return copy;
    }

    protected abstract AbstractStatistics getStatisticsCopy();

    @Override
    public ISchema getContainingSchema() {
        return (AbstractSchema) getParent();
    }
}
