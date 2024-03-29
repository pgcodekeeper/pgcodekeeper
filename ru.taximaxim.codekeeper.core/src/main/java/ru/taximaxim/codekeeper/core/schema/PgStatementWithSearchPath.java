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

/**
 * The superclass for general pgsql statement with search_path. That is any but
 * SCHEMA and EXTENSION.
 *
 * @author Alexander Levsha
 */
public abstract class PgStatementWithSearchPath extends PgStatement implements ISearchPath {

    protected PgStatementWithSearchPath(String name) {
        super(name);
    }

    @Override
    public abstract AbstractSchema getContainingSchema();

    @Override
    public PgDatabase getDatabase() {
        return (PgDatabase)getContainingSchema().getParent();
    }
}
