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
package ru.taximaxim.codekeeper.core.schema;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

/**
 * Stores trigger information.
 */
public abstract class AbstractTrigger extends PgStatement implements ISearchPath
{

    @Override
    public DbObjType getStatementType() {
        return DbObjType.TRIGGER;
    }

    protected AbstractTrigger(String name) {
        super(name);
    }

    @Override
    public AbstractTrigger shallowCopy() {
        AbstractTrigger triggerDst = getTriggerCopy();
        copyBaseFields(triggerDst);
        return triggerDst;
    }

    protected abstract AbstractTrigger getTriggerCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) parent.parent;
    }

    @Override
    public boolean isSubElement() {
        return true;
    }
}
