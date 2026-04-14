/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.util.Collections;
import java.util.List;

import org.pgcodekeeper.core.database.api.loader.ILoader;
import org.pgcodekeeper.core.database.api.schema.IDatabase;
import org.pgcodekeeper.core.settings.DiffSettings;
import org.pgcodekeeper.core.settings.ISettings;

/**
 * A stub implementation of {@link ILoader} that wraps an already-loaded
 * {@link IDatabase} instance. Unlike real loaders, this class performs no
 * parsing or network access — {@link #load()} and {@link #loadAndAnalyze()}
 * simply return the pre-built database as-is.
 */
public class StubDatabaseLoader implements ILoader {

    private final IDatabase db;
    private final String databaseName;

    /**
     * Creates a stub loader backed by the given database.
     *
     * @param db           the pre-loaded database to return from load methods
     * @param databaseName a human-readable name identifying the database source
     */
    public StubDatabaseLoader(IDatabase db, String databaseName) {
        this.db = db;
        this.databaseName = databaseName;
    }

    @Override
    public IDatabase load() {
        return db;
    }

    @Override
    public IDatabase loadAndAnalyze() {
        return db;
    }

    @Override
    public IDatabase getDatabase() {
        return db;
    }

    @Override
    public String getDatabaseName() {
        return databaseName;
    }

    @Override
    public ISettings getSettings() {
        throw new IllegalStateException();
    }

    @Override
    public List<Object> getErrors() {
        return Collections.emptyList();
    }

    @Override
    public DiffSettings getDiffSettings() {
        throw new IllegalStateException();
    }
}
